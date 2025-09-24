package com.jobtracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String DB_HOST = System.getenv().getOrDefault("DB_HOST", "localhost");
    private static final String DB_PORT = System.getenv().getOrDefault("DB_PORT", "5432");
    private static final String DB_NAME = System.getenv().getOrDefault("DB_NAME", "jobtracker");
    private static final String DB_USER = System.getenv().getOrDefault("DB_USER", "postgres");
    private static final String DB_PASSWORD = System.getenv().getOrDefault("DB_PASSWORD", "password");
    
    private static final String URL = String.format("jdbc:postgresql://%s:%s/%s", DB_HOST, DB_PORT, DB_NAME);
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found", e);
        }
    }
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }
}