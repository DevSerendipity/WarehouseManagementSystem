package wms.javafx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static wms.InsertFiles.Insert.insertWarehouseItem;
import static wms.javafx.Barcode.createBarcode;
import static wms.javafx.ComboBoxProperties.*;
import static wms.javafx.event.CompanyEvent.getCompanyCode;
import static wms.javafx.event.ProductsEvent.getProductCode;

public class RetrieveSKU extends Application {

    private void loadingProperties() throws IOException {
        Properties prop = new Properties();
        prop.load( this.getClass().getResourceAsStream( "/companyProperty" ) );
        prop.forEach( ( key, value ) -> new ComboBoxProperties().getKeyValuesParForCompaniesAndProducts()
                .put( key.toString(), value.toString().split( "," ) ) );
        /*new ComboBoxes().getMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));*/
    }

    public static void main( String[] args ) {
        Application.launch( args );
        Barcode barcode = new Barcode();
        createBarcode( "BarcodeImage.png", barcode.getSKU() );
        System.out.println( "image inserted" );
        insertWarehouseItem( getStorageArea().getValue(), getWarehouseRow().getValue(), getRowArea().getValue(),
                             getShelf().getValue(), getBin().getValue(), getCompanies().getValue(), getCompanyCode(),
                             getProducts().getValue(), getProductCode(), barcode.getSKU(),
                             "src/main/resources/Output/BarcodeImage.png" );
    }

    @Override public void start( Stage stage ) throws IOException {
        loadingProperties();
        stage.setTitle( "ComboBoxSample" );
        Scene scene = new Scene( new Group() );
        comboBoxValueInitialization();
        GridPane grid = getGridProperties();
        Group root = (Group) scene.getRoot();
        root.getChildren().add( grid );
        stage.setScene( scene );
        stage.show();
    }

    private void comboBoxValueInitialization() {
        ComboBoxProperties comboBoxProperties = new ComboBoxProperties();
        comboBoxProperties.InitializeComboBoxes();
    }

    private GridPane getGridProperties() throws FileNotFoundException {
        GridPane grid = new GridPane();
        setGridSpacing( grid );
        setBackgroundImage( grid );
        gridLayout( grid );
        return grid;
    }

    private void setGridSpacing( GridPane grid ) {
        grid.setMinSize( 400, 560 );
        grid.setAlignment( Pos.CENTER );
        grid.setHgap( 10 );
        grid.setVgap( 15 );
        grid.setPadding( new Insets( 5, 5, 5, 5 ) );
    }

    private void setBackgroundImage( GridPane grid ) throws FileNotFoundException {
        BackgroundImg background = new BackgroundImg();
        grid.setBackground( background.getBackgroundImage() );
    }

    private void gridLayout( GridPane grid ) {
        grid.add( new Label( "Storage Area" ), 0, 0 );
        grid.add( getStorageArea(), 1, 0 );
        grid.add( new Label( "Row" ), 0, 1 );
        grid.add( getWarehouseRow(), 1, 1 );
        grid.add( new Label( "Row Area" ), 0, 2 );
        grid.add( getRowArea(), 1, 2 );
        grid.add( new Label( "Shelf" ), 0, 3 );
        grid.add( getShelf(), 1, 3 );
        grid.add( new Label( "Bin" ), 0, 4 );
        grid.add( getBin(), 1, 4 );
        grid.add( new Label( "Companies: " ), 0, 5 );
        grid.add( getCompanies(), 1, 5 );
        grid.add( new Label( "Products: " ), 0, 6 );
        grid.add( getProducts(), 1, 6 );
    }
}
