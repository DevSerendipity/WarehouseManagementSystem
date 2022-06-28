package wms.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connect {

    private Connect() {

    }

    public static Connection connection() {
        Connection connection = null;
        try {
            String url = "jdbc:postgresql://localhost:5432/warehouse";
            String user = "postgres";
            String password = "learningCode";
            connection = DriverManager.getConnection( url, user, password );
            if ( connection != null ) {
                System.out.println( "Connection to PostgreSQL has been established." );
            } else {
                System.out.println( "failed to connect" );
            }
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );
        }
        return connection;
    }
}
