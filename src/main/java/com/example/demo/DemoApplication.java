package com.example.demo;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws IOException {

		FileInputStream serviceAccount = new FileInputStream("D:\\work place\\CamelRace server" +
				"\\demo\\src\\main\\java\\com\\example\\demo\\serviceAccount.json");

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

}
