package com.devserendipity.warehousemanagementsystem.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connect {

    private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/warehouse";
    private static final String USER = "postgres";
    private static final String PASSWORD = "learningCode";
    public Connect() {}

    public static Connection connection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
            if ( connection == null ) {
                throw new IllegalStateException("The connection could not be established" + connection);
            }
            System.out.println("Connection to PostgreSQL has been established.");
        } catch ( SQLException e ) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
