package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {

	@Autowired
	private Service service;

	public static void main(String[] args) throws IOException {

		FileInputStream serviceAccount = new FileInputStream("src/main/resources/serviceAccount.json");

		FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount))
				.build();

		FirebaseApp.initializeApp(options);

//		try {
//			FileInputStream serviceAccount = new FileInputStream("D:\\work place\\CamelRace server\\demo\\" +
//					"src\\main\\java\\com\\example\\demo\\serviceAccount.json");
//
//			FirebaseOptions options = new FirebaseOptions.Builder()
//					.setCredentials(GoogleCredentials.fromStream(serviceAccount))
//					.setDatabaseUrl("https://camelrace-bac8c.firebaseio.com")
//					.build();
//
//			FirebaseApp.initializeApp(options);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}


		SpringApplication.run(DemoApplication.class, args);
	}

	@Scheduled(fixedRate = 6000) // Execute every 6 seconds
	public int scheduledPost() throws JSONException, IOException, ExecutionException, InterruptedException {
	ResponseEntity<?> responseEntity = service.myData();

	if(responseEntity.getStatusCodeValue() == 200){
		DataSet myData2 = (DataSet) responseEntity.getBody();
		service.createCamelRace(myData2);
		return 1;
	}else{
		// do nothing
		return 0;
	}
	}

}
