package com.example.connection;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Factory class
public class ConnectionFactory {

    private static Properties properties=new Properties();

    static {
        try {
            FileInputStream fileInputStream=new FileInputStream("/home/nag/tng/ialab/code/todos-console-app/db.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static {
        // step-1 : register JDBC-driver
        try {
            Class.forName(properties.getProperty("db.driver-class"));
        } catch (ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    // Factory Method
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // step-2 : create database connection with URL,username and password
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;

    }

}
