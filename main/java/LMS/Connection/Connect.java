package LMS.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public static void connect() {
        String url = "jdbc:postgresql://localhost/warehouse";
        try (Connection connection = DriverManager.getConnection(url, "islam", "learningDatabase")) {
            if (connection != null) {
                System.out.println("Connection to PostgreSQL has been established.");
            } else {
                System.out.println("failed to connect");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}