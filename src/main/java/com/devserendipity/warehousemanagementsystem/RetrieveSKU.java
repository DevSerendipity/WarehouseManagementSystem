package com.devserendipity.warehousemanagementsystem;

import com.devserendipity.warehousemanagementsystem.javafx.BackgroundImg;
import com.devserendipity.warehousemanagementsystem.javafx.Barcode;
import com.devserendipity.warehousemanagementsystem.javafx.ComboBoxProperties;
import com.devserendipity.warehousemanagementsystem.javafx.event.CompanyEvent;
import com.devserendipity.warehousemanagementsystem.javafx.event.ProductsEvent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import com.devserendipity.warehousemanagementsystem.files.Insert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class RetrieveSKU extends Application {

    public static void main(String[] args) {
        Application.launch(args);
        Barcode barcode = new Barcode();
        Barcode.createBarcode("BarcodeImage.png", barcode.getSKU());
        System.out.println("image inserted");
        Insert.insertWarehouseItem(ComboBoxProperties.getStorageArea().getValue(),
                                   ComboBoxProperties.getWarehouseRow().getValue(),
                                   ComboBoxProperties.getRowArea().getValue(), ComboBoxProperties.getShelf().getValue(),
                                   ComboBoxProperties.getBin().getValue(), ComboBoxProperties.getCompanies().getValue(),
                                   CompanyEvent.getCompanyCode(), ComboBoxProperties.getProducts().getValue(),
                                   ProductsEvent.getProductCode(), barcode.getSKU(),
                                   "src/main/resources/Images/BarcodeImages/BarcodeImage.png");
    }

    private void loadingProperties() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/files/companyProperty"));
        prop.forEach((key, value) -> new ComboBoxProperties().getKeyValuesParForCompaniesAndProducts()
                                                             .put(key.toString(), value.toString().split(",")));
        /*new ComboBoxes().getMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));*/
    }

    @Override public void start(Stage stage) throws IOException {
        loadingProperties();
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group());
        comboBoxValueInitialization();
        GridPane grid = getGridProperties();
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    private void comboBoxValueInitialization() {
        ComboBoxProperties comboBoxProperties = new ComboBoxProperties();
        comboBoxProperties.initializeComboBoxes();
    }

    private GridPane getGridProperties() throws FileNotFoundException {
        GridPane grid = new GridPane();
        setGridSpacing(grid);
        setBackgroundImage(grid);
        gridLayout(grid);
        return grid;
    }

    private void setGridSpacing(GridPane grid) {
        grid.setMinSize(400, 560);
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(15);
        grid.setPadding(new Insets(5, 5, 5, 5));
    }

    private void setBackgroundImage(GridPane grid) throws FileNotFoundException {
        BackgroundImg background = new BackgroundImg();
        grid.setBackground(background.getBackgroundImage());
    }

    private void gridLayout(GridPane grid) {
        grid.add(new Label("Storage Area"), 0, 0);
        grid.add(ComboBoxProperties.getStorageArea(), 1, 0);
        grid.add(new Label("Row"), 0, 1);
        grid.add(ComboBoxProperties.getWarehouseRow(), 1, 1);
        grid.add(new Label("Row Area"), 0, 2);
        grid.add(ComboBoxProperties.getRowArea(), 1, 2);
        grid.add(new Label("Shelf"), 0, 3);
        grid.add(ComboBoxProperties.getShelf(), 1, 3);
        grid.add(new Label("Bin"), 0, 4);
        grid.add(ComboBoxProperties.getBin(), 1, 4);
        grid.add(new Label("Companies: "), 0, 5);
        grid.add(ComboBoxProperties.getCompanies(), 1, 5);
        grid.add(new Label("Products: "), 0, 6);
        grid.add(ComboBoxProperties.getProducts(), 1, 6);
    }
}
