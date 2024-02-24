package com.example.demo;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.ExecutionException;

@org.springframework.stereotype.Service
public class Service {

    public String createCamelRace(CamelRaceModel camelRaceModel) throws ExecutionException, InterruptedException {
        Firestore dbFirestore = FirestoreClient.getFirestore();

//        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("Camelracing").document(camelRaceModel.toString()).set(camelRaceModel);
//        return collectionsApiFuture.get().getUpdateTime().toString();

//         Add the camel race model to the "camelRacing" collection without specifying a document ID
        CollectionReference camelRacingCollection = dbFirestore.collection("CamelInfo");
        System.out.println("data : " + camelRaceModel);
        ApiFuture<DocumentReference> apiFuture = camelRacingCollection.add(camelRaceModel);

        // Retrieve the auto-generated document ID
        DocumentReference documentReference = apiFuture.get();
        String documentId = documentReference.getId();

        return documentId;
    }
}
