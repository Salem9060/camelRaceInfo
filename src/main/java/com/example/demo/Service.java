package com.example.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.gson.JsonObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;

@org.springframework.stereotype.Service
public class Service {

    String checker = "";
    int documentManualID = 0;
    public String createCamelRace(DataSet camelRaceModel) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();
//
////        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Camelracing").document(camelRaceModel.toString()).set(camelRaceModel);
////        return collectionsApiFuture.get().getUpdateTime().toString();
//
////         Add the camel race model to the "camelRacing" collection without specifying a document ID
//
//        CollectionReference camelRacingCollection = dbFirestore.collection("CamelInfo");
//        System.out.println("data : " + camelRaceModel);
//        ApiFuture<DocumentReference> apiFuture = camelRacingCollection.add(camelRaceModel);
//
//        // Retrieve the auto-generated document ID
////        DocumentReference documentReference = apiFuture.get();
////        String documentId = documentReference.getId();
//
//        documentManualID = documentManualID + 1;
//        String documentId = String.valueOf(documentManualID);
//        return documentId;



        documentManualID = documentManualID + 1;
        camelRaceModel.setId(documentManualID);
        String documentId = String.valueOf(documentManualID);

        // Add the camel race model to the "camelRacing" collection with the specified document ID
        DocumentReference documentReference = dbFirestore.collection("CamelInfo").document(documentId);
        ApiFuture<WriteResult> apiFuture = documentReference.set(camelRaceModel);

        System.out.println(documentId);
        // Return the document ID
        return documentId;
    }

    public ResponseEntity<?> myData() throws IOException, JSONException {
        String url = "http://demo.njoka.net/izooh/2024-03-izooh.txt";
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        String response = httpClient.execute(httpGet, httpResponse -> {
            int status = httpResponse.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
                return EntityUtils.toString(httpResponse.getEntity());
            } else {
                try {
                    throw new Exception("HTTP request failed with status code: " + status);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        String[] lines = response.split("\n");
        String lastLine = lines[lines.length - 1];
        if(lastLine.equals(checker)){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(HttpStatus.BAD_REQUEST.value());
        }else{
            checker = lastLine;
            DataSet myData1 = convertData(lastLine);
            return ResponseEntity.ok(myData1);
        }
    }

    public DataSet convertData(String lastLine){

        String lastLine1 = lastLine.substring(0,lastLine.length()-1);
        DataSet sensorData = new DataSet();
        // Split the string by '&' to separate key-value pairs
        String[] keyValuePairs = lastLine1.split("&");
        for (String pair : keyValuePairs) {
            // Split each pair by '=' to separate key and value
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                String key = keyValue[0];
                String value = keyValue[1];

                // Map key-value pairs to fields in SensorData object
                switch (key) {
                    case "value0":
                        sensorData.setHeartBeatRate(Double.parseDouble(value));
                        break;
                    case "value1":
                        sensorData.setBloodOxygenConcentration(Double.parseDouble(value));
                        break;
                    case "csq":
                        sensorData.setSignalStrength(Integer.parseInt(value));
                        break;
                    case "sat":
                        sensorData.setSatellite(Integer.parseInt(value));
                        break;
                    case "Tstamp":
                        Timestamp currTime = currentTimeAndDate(value);
                        sensorData.setuTCTimeStamp(currTime);
                        break;
                    case "lon":
                        sensorData.setLongitude(Double.parseDouble(value));
                        break;
                    case "lat":
                        sensorData.setLatitude(Double.parseDouble(value));
                        break;
                    case "alt":
                        sensorData.setAltitude(Double.parseDouble(value));
                        break;
                    case "speed":
                        sensorData.setAcceleration(Double.parseDouble(value));
                        break;
                    // Handle additional key-value pairs if needed
                    default:
                        // Ignore unknown keys or handle them as needed
                        break;
                }
            }
        }

        return sensorData;
    }

    public Timestamp currentTimeAndDate(String value){

        // Get current date
        LocalDate currentDate = LocalDate.now();

        // Parse time string to LocalTime
        LocalTime time = LocalTime.parse(value, DateTimeFormatter.ofPattern("H:m:s"));

        // Merge date and time to create a LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.of(currentDate, time);

        // Convert LocalDateTime to Timestamp
        Timestamp timestamp = Timestamp.valueOf(localDateTime);

        return timestamp;
    }

//    public static LocalTime timeOfJockey(String timeString){
//
//        int hours = 0;
//        int minutes = 0;
//        int seconds = 0;
//        switch (timeString.length()) {
//            case 3: // If string length is 3 (e.g., "345"), interpret it as HHM
//                hours = Integer.parseInt(timeString.substring(0, 1));
//                minutes = Integer.parseInt(timeString.substring(1, 3));
//                break;
//            case 4: // If string length is 4 (e.g., "1234"), interpret it as HHMM
//                hours = Integer.parseInt(timeString.substring(0, 2));
//                minutes = Integer.parseInt(timeString.substring(2, 4));
//                break;
//            case 5: // If string length is 5 (e.g., "12345"), interpret it as HHMMx (where x is seconds)
//                hours = Integer.parseInt(timeString.substring(0, 2));
//                minutes = Integer.parseInt(timeString.substring(2, 4));
//                seconds = Integer.parseInt(timeString.substring(4, 5));
//                break;
//            case 6: // If string length is 6 (e.g., "123456"), interpret it as HHMMSS
//                hours = Integer.parseInt(timeString.substring(0, 2));
//                minutes = Integer.parseInt(timeString.substring(2, 4));
//                seconds = Integer.parseInt(timeString.substring(4, 6));
//                break;
//            default:
//                // Handle invalid input
//                throw new IllegalArgumentException("Invalid time format");
//        }
//
//        // Creating a LocalTime object
//        return LocalTime.of(hours, minutes, seconds);
//    }
}



