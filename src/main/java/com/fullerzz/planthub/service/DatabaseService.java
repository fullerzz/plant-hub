package com.fullerzz.planthub.service;

import com.fullerzz.planthub.model.Plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class DatabaseService {
    @Autowired
    Connection dbConnection;

    public List<Plant> getAllPlants() {
        List<Plant> plants = new ArrayList<>();

        String sql = "SELECT * FROM plant_info";
        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            plants = buildPlantsFromResultSet(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return plants;
    }

    public Plant getPlant(String plantName) {
        Plant plant = null;
        String sql = "SELECT * FROM plant_info WHERE name=\"" + plantName + "\"";

        try {
            Statement stmt = dbConnection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            plant = buildPlantsFromResultSet(rs).get(0);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return plant;
    }

    public String addPlant() {
        return "no";
    }

    private List<Plant> buildPlantsFromResultSet(ResultSet rs) throws SQLException {
        List<Plant> plants = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            String scientificName = rs.getString("scientific_name");
            String datePlanted = rs.getString("date_planted");
            String lastWatered = rs.getString("last_watered");
            String output = rs.getString("output");
            String tags = rs.getString("tags");
            plants.add(new Plant(name, scientificName, datePlanted, lastWatered, output, tags));
        }
        return plants;
    }
}
