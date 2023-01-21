package com.fullerzz.planthub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {
    @Bean
    public Connection dbConnection() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:E:/Code/Side Projects/plant-hub/src/main/resources/plants.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
