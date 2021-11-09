package LMS.JavaFx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

import static LMS.InsertFiles.Insert.insert;
import static LMS.JavaFx.Barcode.createBarcode;
import static LMS.JavaFx.ComboBoxes.*;
import static LMS.JavaFx.event.CompanyEvent.getProductCodeOne;
import static LMS.JavaFx.event.ProductsEvent.getCode2;

public class RetrieveSKU extends Application {

    private void fillMap() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/companyProperty"));
        prop.forEach((key, value) -> new ComboBoxes().getMap().put(key.toString(), value.toString().split(",")));
        /*new ComboBoxes().getMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));*/
    }

    public static void main(String[] args) {
        Application.launch(args);
        Barcode barcode = new Barcode();
        createBarcode("BarcodeImage.png", barcode.getSKU());
        System.out.println("image inserted");
        insert(getArea().getValue(), getRow().getValue(), getRowArea().getValue(), getShelf().getValue(), getBin().getValue(), getCompanies().getValue(), getProductCodeOne(), getProducts().getValue(), getCode2(), barcode.getSKU(), "C:/Users/Emir/OneDrive/Documents/Comp1.png");
    }

    @Override
    public void start(Stage stage) throws IOException {
        fillMap();
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group());
        ComboBoxes cb = new ComboBoxes();
        cb.onInitialize();
        GridPane grid = new GridPane();
        grid.setMinSize(400, 560);
        grid.setAlignment(Pos.CENTER);
        BackgroundImg background = new BackgroundImg();
        grid.setBackground(background.getBackgroundImage());
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Area"),0,0);
        grid.add(getArea(), 1, 0);
        grid.add(new Label("Row"),0,1);
        grid.add(getRow(), 1, 1);
        grid.add(new Label("Row Area"),0,2);
        grid.add(getRowArea(), 1, 2);
        grid.add(new Label("Shelf"),0,3);
        grid.add(getShelf(), 1, 3);
        grid.add(new Label("Bin"),0,4);
        grid.add(getBin(), 1, 4);
        grid.add(new Label("Companies: "), 0, 5);
        grid.add(getCompanies(), 1, 5);
        grid.add(new Label("Products: "), 0, 6);
        grid.add(getProducts(), 1, 6);
        grid.setVgap(15);
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }
/*
 stage.setTitle("ComboBoxSample");
        FXMLLoader fxmlLoader = new FXMLLoader(RetrieveSKU.class.getResource("/WarehouseStoring.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Text Duplicate Project!");
        stage.setScene(scene);
        stage.show();
        cb.onInitialize();
        companyEvent.getCompanyEvent();
        productsEvent.getProductEvent();
 */
}