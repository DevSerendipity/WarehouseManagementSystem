package LMS.Connection.InsertFiles;


import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author islam_sakrak
 */
public class Insert{
// so what i did also i did add the // in front of C: instead one C://Users/.../attempt3.db
    // also what i did i created the database in the db project where i wanted to use it, or the root folder
    // also it is in the same project as the class executing it and the database
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://Users/Emir/OneDrive/Documents/NewOne/LibraryManagementSystem/src/main/java/LMS/db/projectDE.db";
        Connection con = null;
        try {
            con = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    /**
     * Insert a new row into the storage_unit table
     * @param warehouse_area to know what area is the product stored
     * @param row to know what row is the product being stored
     * @param row_area to know in which area specifically is the product stored
     * @param shelf to get the exact shelf where the product is being stored
     * @param bin and to get the exact bin where the product is being stored
     * @param manufactured  to know who produced the product labeled
     * @param code_1 to get the unique code that only this manufacturing company will have
     * @param product  to know which exactly product is being stored
     * @param code_2 unique code for that product
     * @param SKU combining [code_1 + code_2  + firstLetter + lastLetter - (of company you selected)] that is being labeled and stored to the barcode
     * @param barcodeIMG unique image that will contain the barcode
//     * @param picture
    */
    public void insert(String warehouse_area, String row, String row_area, String shelf, int bin, String manufactured, int code_1, String product, int code_2, String SKU, String barcodeIMG) {// String picture
        String sql = "INSERT INTO company_values (warehouse_area, row, row_area, shelf, bin, manufactured, code_1, product, code_2, SKU, barcodeIMG) VALUES(?,?,?,?,?,?,?,?,?,?,?)"; // , picture)  ,?
        try (Connection con = this.connect();
             PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, warehouse_area);
            pstmt.setString(2, row);
            pstmt.setString(3, row_area);
            pstmt.setString(4, shelf);
            pstmt.setInt(5, bin);
            pstmt.setString(6, manufactured);
            pstmt.setInt(7, code_1);
            pstmt.setString(8, product);
            pstmt.setInt(9, code_2);
            pstmt.setString(10, SKU);
            pstmt.setBytes(11,readFile(barcodeIMG));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
    /**
     * Read the file and returns the byte array
     * @param file
     * @return the bytes of the file
     */
    private byte[] readFile(String file) {
        ByteArrayOutputStream bos = null;
        try {
            File f = new File(file);
            FileInputStream fis = new FileInputStream(f);
            byte[] buffer = new byte[1024];
            bos = new ByteArrayOutputStream();
            for (int len; (len = fis.read(buffer)) != -1;) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return bos != null ? bos.toByteArray() : null;
    }

    /**
     * Update data of a warehouse specified by the id
     *
     * @param ROWID to get the id, of the row we are sending the pic
     * @param warehouse_area to know what area is the product stored
     * @param row to know what row is the product being stored
     * @param row_area to know in which area specifically is the product stored
     * @param shelf to get the exact shelf where the product is being stored
     * @param bin and to get the exact bin where the product is being stored
     * @param manufactured  to know who produced the product labeled
     * @param code_1 to get the unique code that only this manufacturing company will have
     * @param product  to know which exactly product is being sold
     * @param code_2 unique code for that product
     * @param SKU combining code_1 + code_2  that is being labeled and stored to the barcode
     * @param barcodeIMG of the baroce
     */
    public void update(int ROWID, String warehouse_area, String row, String row_area, String shelf, int bin, String manufactured, int code_1, String product, int code_2, String SKU, String barcodeIMG) {
        String sql = "UPDATE projectDE SET warehouse_area = ? , "
                + "SET row = ? "
                + "SET row_area = ? "
                + "SET shelf = ? "
                + "SET bin = ? "
                + "SET manufactured = ? "
                + "SET code_1 = ? "
                + "SET product = ? "
                + "SET code_2 = ? "
                + "SET SKU = ? "
                + "SET barcodeIMG = ? "
                + "WHERE ROWID = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, ROWID);
            pstmt.setString(2, warehouse_area);
            pstmt.setString(3, row);
            pstmt.setString(4, row_area);
            pstmt.setString(5, shelf);
            pstmt.setInt(6, bin);
            pstmt.setString(7, manufactured);
            pstmt.setInt(8, code_1);
            pstmt.setString(9, product);
            pstmt.setInt(10, code_2);
            pstmt.setString(11, SKU);
            pstmt.setString(12, barcodeIMG);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}