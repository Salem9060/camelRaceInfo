package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @PostMapping("/api/senddataofcamelrace")
    public String createfunc(@RequestBody CamelRaceModel camelRaceModel) {
        try {
            return service.createCamelRace(camelRaceModel);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
