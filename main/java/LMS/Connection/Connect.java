package LMS.Connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    //WORKED https://www.sqlitetutorial.net/sqlite-java/insert/
    // create a new db tomorrow and go all over again

    /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection con = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:**PATH TO DATABASE**";

            // create a connection to the database
            con = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
    }
}