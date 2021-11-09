package LMS.InsertFiles;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert{

    /**
     * @param sku combining [productCodeOne + firstLetterOfCompanyToAsci  + productCodeTwo + lastLetterOfCompanyToAsci - and storing it to a database
     * @param barcodeIMG unique image that will contain the SKU barcode
    */
    public static void insert(String warehouse_area, String row, String row_area, String shelf, int bin, String manufactured, int productcodeone, String product, int productcodetwo, String sku, String barcodeIMG) {// String picture
        String sql = "INSERT INTO warehouse_storage (warehouse_area, row, row_area, shelf, bin, manufactured, productcodeone, product, productcodetwo, SKU, barcodeIMG) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        String url = "jdbc:postgresql://localhost/warehouse";
        try (Connection con = DriverManager.getConnection(url, "islam", "learningDatabase"); PreparedStatement pstmt = con.prepareStatement(sql)) {
            try{
                pstmt.setString(1, warehouse_area);
                pstmt.setString(2, row);
                pstmt.setString(3, row_area);
                pstmt.setString(4, shelf);
                pstmt.setInt(5, bin);
                pstmt.setString(6, manufactured);
                pstmt.setInt(7, productcodeone);
                pstmt.setString(8, product);
                pstmt.setInt(9, productcodetwo);
                pstmt.setString(10, sku);
                pstmt.setBytes(11,readFile(barcodeIMG));
            }catch (Exception e){
                e.printStackTrace();
            }


            pstmt.executeUpdate();
        } catch (SQLException  e) {
            e.getStackTrace();
        }
    }

    private static byte[] readFile(String file) {
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
     * @param sku combining [code_1 + code_2  + firstLetter + lastLetter - (of company you selected)] that is being labeled and stored to the barcode
     * @param barcodeIMG unique image that will contain the barcode
     */
    public static void update(int id, String warehouse_area, String row, String row_area, String shelf, int bin, String manufactured, int productcodeone, String product, int productcodetwo, String sku, String barcodeIMG) {
        String sql = "UPDATE warehouse_storing "
                + "SET warehouse_area = ? , "
                + "SET row = ? "
                + "SET row_area = ? "
                + "SET shelf = ? "
                + "SET bin = ? "
                + "SET manufactured = ? "
                + "SET productcodeone = ? "
                + "SET product = ? "
                + "SET productcodetwo = ? "
                + "SET sku = ? "
                + "SET barcodeIMG = ? "
                + "WHERE id = ?";
        String url = "jdbc:postgresql://localhost/warehouse";
        try (Connection connection = DriverManager.getConnection(url, "islam", "learningDatabase");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            // set the corresponding param
            pstmt.setInt(1, id);
            pstmt.setString(2, warehouse_area);
            pstmt.setString(3, row);
            pstmt.setString(4, row_area);
            pstmt.setString(5, shelf);
            pstmt.setInt(6, bin);
            pstmt.setString(7, manufactured);
            pstmt.setInt(8, productcodeone);
            pstmt.setString(9, product);
            pstmt.setInt(10, productcodetwo);
            pstmt.setString(11, sku);
            pstmt.setString(12, barcodeIMG);
            // update
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }
    }
}