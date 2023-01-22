package com.fullerzz.planthub.controller;

import com.fullerzz.planthub.model.Plant;
import com.fullerzz.planthub.service.DatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlantController {

    @Autowired
    DatabaseService dbService;

    @GetMapping("/")
    public String index() {
        return "Greetings from PlantHub!";
    }

    @GetMapping("/plants")
    public ResponseEntity<List> getAllPlants() {
        List<Plant> plants = dbService.getAllPlants();
        if (plants.size() > 0) {
            return ResponseEntity.ok().body(plants);
        } else {
            return ResponseEntity.internalServerError().body(plants);
        }

    }

    @GetMapping("/plants/{plantName}")
    public ResponseEntity<Plant> getPlant(@PathVariable String plantName) {
        Plant plant = dbService.getPlant(plantName);
        return ResponseEntity.ok().body(plant);
    }

    @PostMapping("/addPlant")
    public ResponseEntity<String> addPlant(@Validated @RequestBody Plant plant) {
        return ResponseEntity.internalServerError().body("Not implemented yet");
    }

}
