package com.fullerzz.planthub.service;

import com.fullerzz.planthub.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    Connection dbConnection;

    public List<Plant> readAllPlants() {
        List<Plant> plants = new ArrayList<>();

        String sql = "SELECT * FROM plant_info";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String scientificName = rs.getString("scientific_name");
                String datePlanted = rs.getString("date_planted");
                String lastWatered = rs.getString("last_watered");
                String output = rs.getString("output");
                String tags = rs.getString("tags");
                plants.add(new Plant(name, scientificName, datePlanted, lastWatered, output, tags));
            }

            //dbConnection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return plants;
    }

    public String addPlant() {
        return "no";
    }
}
