package wms.InsertFiles;

import wms.Connection.Connect;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {

    private Insert(){

    }

    /**
     * @param sku        combining [productCodeOne + firstLetterOfCompanyToAsci  + productCodeTwo +
     *                   lastLetterOfCompanyToAsci - and storing it to a database
     * @param barcodeIMG unique image that will contain the SKU barcode
     */
    public static void insertWarehouseItem( String warehouse_area, String warehouse_row, String row_area,
                                            String shelf, int bin, String manufacturer, int productCodeOne,
                                            String product, int productCodeTwo, String sku, String barcodeIMG ) {
        // String picture
        try ( Connection con = Connect.connection()){
            try {
                String sql = "INSERT INTO warehouse (warehouse_uid, warehouse_area, warehouse_row, row_area, shelf, "
                        + "bin, manufacturer, product_code_one, product, product_code_two, sku, barcode_img) "
                        + "VALUES" + "(uuid_generate_v4(), ?,?,?,?,?,?,?,?,?,?,?)";
                File f = new File( barcodeIMG );
                if ( !f.exists() ) {
                    System.out.println( "Image file not found. Terminating..." );
                }
                PreparedStatement preparedStatement = con.prepareStatement( sql );
                preparedStatement.setString( 1, warehouse_area );
                preparedStatement.setString( 2, warehouse_row );
                preparedStatement.setString( 3, row_area );
                preparedStatement.setString( 4, shelf );
                preparedStatement.setInt( 5, bin );
                preparedStatement.setString( 6, manufacturer );
                preparedStatement.setInt( 7, productCodeOne );
                preparedStatement.setString( 8, product );
                preparedStatement.setInt( 9, productCodeTwo );
                preparedStatement.setString( 10, sku );
                preparedStatement.setBinaryStream( 11, new FileInputStream( f ) );
                preparedStatement.execute();
            } catch ( Exception e ) {
                e.printStackTrace();
            }
        } catch ( SQLException e ) {
            System.out.println( e.getMessage() );
        }
    }
}
