package LMS.JavaFx;

import LMS.JavaFx.event.CompanyEvent;
import LMS.JavaFx.event.ProductsEvent;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import java.io.IOException;

import java.util.Arrays;
import java.util.Properties;

public class RetrieveSKU extends Application {
    private final ComboBoxes cb = new ComboBoxes();
    public static CompanyEvent companyEvent = new CompanyEvent();
    public static ProductsEvent productsEvent = new ProductsEvent();
    private final BackgroundImg background = new BackgroundImg();

    private void fillMap() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/companyProperty"));
        prop.forEach((key, value) -> cb.getMap().put(key.toString(), value.toString().split(",")));
        cb.getMap().forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
    }

    public static void main(String[] args) {
        Application.launch(args);

        System.out.println("finished");
    }

    @Override
    public void start(Stage stage) throws IOException {
        fillMap();
        stage.setTitle("ComboBoxSample");
        Scene scene = new Scene(new Group());

        cb.initialize();
        companyEvent.getCompanyEvent();
        productsEvent.getProductEvent();

        
        GridPane grid = new GridPane();
        grid.setMinSize(400, 560);
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background.getBackground());
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Area"),0,0);
        grid.add(cb.getArea(), 1, 0);
        grid.add(new Label("Row"),0,1);
        grid.add(cb.getRow(), 1, 1);
        grid.add(new Label("Row Area"),0,2);
        grid.add(cb.getRowArea(), 1, 2);
        grid.add(new Label("Shelf"),0,3);
        grid.add(cb.getShelf(), 1, 3);
        grid.add(new Label("Bin"),0,4);
        grid.add(cb.getBin(), 1, 4);
        grid.add(new Label("Companies: "), 0, 5);
        grid.add(cb.getCompanies(), 1, 5);
        grid.add(new Label("Products: "), 0, 6);
        grid.add(cb.getProducts(), 1, 6);
        grid.setVgap(15);
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

}