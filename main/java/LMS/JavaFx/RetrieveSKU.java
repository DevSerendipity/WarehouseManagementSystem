package LMS.JavaFx;

import LMS.Connection.InsertFiles.Insert;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

import org.jetbrains.annotations.Contract;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

public class RetrieveSKU extends Application {

    private final Map<String, String[]> map = new TreeMap<>();
    private final ComboBox<String> companies = new ComboBox<>();
    private final ComboBox<String> products = new ComboBox<>();
    private final ComboBox<String> area = new ComboBox<>();
    private final ComboBox<String> row = new ComboBox<>();
    private final ComboBox<String> row_area = new ComboBox<>();
    private final ComboBox<String> shelf = new ComboBox<>();
    private final ComboBox<Integer> bin = new ComboBox<>();
    private int code_1 = 0, code_2 = 0;
    Insert insert = new Insert();
    private final char[] firstIDLetter = new char[1];
    private final char[] secondIDLetter = new char[1];

    private void fillMap() throws IOException {
        Properties prop = new Properties();
        prop.load(this.getClass().getResourceAsStream("/companyProperty"));
        prop.forEach((key, value) -> map.put(key.toString(), value.toString().split(",")));
        map.forEach((k, v) -> System.out.println(k + ": " + Arrays.toString(v)));
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
        area.getItems().addAll("Area 1","Area 2");
        row.getItems().addAll("A1","A2","B1","B2");
        row_area.getItems().addAll("RA1","RA2","RA3");
        shelf.getItems().addAll("A","B","C");
        bin.getItems().addAll(1,2,3);
        companies.getItems().setAll(new ArrayList<>(map.keySet()));
        companies.setOnAction(e -> products.getItems().setAll(map.get(companies.getSelectionModel().getSelectedItem())));

        companies.getSelectionModel().selectedItemProperty().addListener((selected, oldComp, newComp) -> {
            if (newComp != null) {
                switch (newComp) {
                    case "Volkswage Group":
                        code_1 = 100;
                        break;
                    case "Daimler":
                        code_1 = 101;
                        break;
                    case "Airbus":
                        code_1 = 102;
                        break;
                    case "Anheuser-Busch InBev":
                        code_1 = 103;
                        break;
                    case "BASF":
                        code_1 = 104;
                        break;
                    case "Apple":
                        code_1 = 105;
                        break;
                    case "Boeing":
                        code_1 = 106;
                        break;
                    case "Cardinal Health":
                        code_1 = 107;
                        break;
                    case "Dell":
                        code_1 = 108;
                        break;
                    case "China Baowu Steel Group":
                        code_1 = 109;
                        break;
                    case "DowDuPont":
                        code_1 = 110;
                        break;
                    case "Foxconn":
                        code_1 = 111;
                        break;
                    case "General Electronics":
                        code_1 = 112;
                        break;
                    case "General Motors":
                        code_1 = 113;
                        break;
                    case "Hoffmann-La Roche":
                        code_1 = 114;
                        break;
                    case "JBS S.A.":
                        code_1 = 115;
                        break;
                    case "Nippon Steel & Sumitomo Metal":
                        code_1 = 116;
                        break;
                    case "Norinco":
                        code_1 = 117;
                        break;
                    case "PepsiCo":
                        code_1 = 118;
                        break;
                    case "Pfizer":
                        code_1 = 119;
                        break;
                    case "POSCO":
                        code_1 = 120;
                        break;
                    case "Samsung Electronics":
                        code_1 = 121;
                        break;
                    case "Sinochem":
                        code_1 = 122;
                        break;
                    case "Toyota Group":
                        code_1 = 123;
                        break;
                }
            }
            assert newComp != null;
            firstIDLetter[0] = newComp.toUpperCase().charAt(0);
            secondIDLetter[0] = newComp.toUpperCase().charAt(newComp.length() - 1);
        });
        products.getSelectionModel().selectedItemProperty().addListener((selected, oldProd, newProd) -> {

            if (newProd != null) {
                switch (newProd) {
                    case "Jets":
                        code_2 = 10;
                        break;
                    case "Military Aircrafts":
                        code_2 = 11;
                        break;
                    case "Satellites Launchers":
                        code_2 = 12;
                        break;
                    case "Helicopters":
                        code_2 = 13;
                        break;
                    case "Drink":
                        code_2 = 15;
                        break;
                    case "Brewing":
                        code_2 = 16;
                        break;
                    case "Mac":
                        code_2 = 17;
                        break;
                    case "IPad":
                        code_2 = 18;
                        break;
                    case "IPhone":
                        code_2 = 19;
                        break;
                    case "Watch":
                        code_2 = 20;
                        break;
                    case "TV":
                        code_2 = 21;
                        break;
                    case "Agriculture":
                        code_2 = 22;
                        break;
                    case "Automotive & Transportation":
                        code_2 = 23;
                        break;
                    case "Construction":
                        code_2 = 24;
                        break;
                    case "Electronics & Electric":
                        code_2 = 25;
                        break;
                    case "Airplanes":
                        code_2 = 26;
                        break;
                    case "Transport Aircraft":
                        code_2 = 27;
                        break;
                    case "Autonomous Systems":
                        code_2 = 28;
                        break;
                    case "Anesthesia Supplies":
                        code_2 = 29;
                        break;
                    case "Compression":
                        code_2 = 30;
                        break;
                    case "Laboratory Products":
                        code_2 = 31;
                        break;
                    case "Infection Control":
                        code_2 = 32;
                        break;
                    case "Skin/wound Management":
                        code_2 = 33;
                        break;
                    case "Iron":
                        code_2 = 34;
                        break;
                    case "Steel":
                        code_2 = 35;
                        break;
                    case "Passenger Cars":
                        code_2 = 36;
                        break;
                    case "Trucks":
                        code_2 = 37;
                        break;
                    case "Vans":
                        code_2 = 38;
                        break;
                    case "Buses":
                        code_2 = 39;
                        break;
                    case "Monitors":
                        code_2 = 40;
                        break;
                    case "Projectors":
                        code_2 = 41;
                        break;
                    case "Desktops":
                        code_2 = 42;
                        break;
                    case "Laptops":
                        code_2 = 43;
                        break;
                    case "Ultra books":
                        code_2 = 44;
                        break;
                    case "Adhesives":
                        code_2 = 45;
                        break;
                    case "Advanced Printing Solutions":
                        code_2 = 46;
                        break;
                    case "Animal Nutrition":
                        code_2 = 47;
                        break;
                    case "Biomaterials":
                        code_2 = 48;
                        break;
                    case "Clean Technologies":
                        code_2 = 49;
                        break;
                    case "Electronic Components":
                        code_2 = 50;
                        break;
                    case "PCBs":
                        code_2 = 51;
                        break;
                    case "PCB Components":
                        code_2 = 52;
                        break;
                    case "Computer Chips":
                        code_2 = 53;
                        break;
                    case "Jet Engine":
                        code_2 = 54;
                        break;
                    case "Gas Turbines":
                        code_2 = 55;
                        break;
                    case "Hydroelectric Power":
                        code_2 = 56;
                        break;
                    case "Grid":
                        code_2 = 57;
                        break;
                    case "Wind Turbine":
                        code_2 = 58;
                        break;
                    case "Motor Sports":
                        code_2 = 59;
                        break;
                    case "Hybrid Vehicles":
                        code_2 = 60;
                        break;
                    case "Hydrotec Military Vehicles":
                        code_2 = 61;
                        break;
                    case "Anaemia":
                        code_2 = 62;
                        break;
                    case "Cancer":
                        code_2 = 63;
                        break;
                    case "Dermatology":
                        code_2 = 64;
                        break;
                    case "Leukemia":
                        code_2 = 65;
                        break;
                    case "Transplantation":
                        code_2 = 66;
                        break;
                    case "Processed Beef":
                        code_2 = 67;
                        break;
                    case "By-products":
                        code_2 = 68;
                        break;
                    case "Processed Chicken":
                        code_2 = 69;
                        break;
                    case "Energy":
                        code_2 = 70;
                        break;
                    case "Infrastructure":
                        code_2 = 71;
                        break;
                    case "Consumer Electronics":
                        code_2 = 72;
                        break;
                    case "Rifles":
                        code_2 = 73;
                        break;
                    case "Bombs":
                        code_2 = 74;
                        break;
                    case "Granada Launchers":
                        code_2 = 75;
                        break;
                    case "Aircrafts, Ships":
                        code_2 = 76;
                        break;
                    case "Food":
                        code_2 = 77;
                        break;
                    case "Snack":
                        code_2 = 78;
                        break;
                    case "Beverage":
                        code_2 = 78;
                        break;
                    case "Cardiovascular":
                        code_2 = 79;
                        break;
                    case "Diabetes & Metabolic":
                        code_2 = 80;
                        break;
                    case "Immune System":
                        code_2 = 81;
                        break;
                    case "Infections & Infectious":
                        code_2 = 82;
                        break;
                    case "Phones":
                        code_2 = 83;
                        break;
                    case "Tables":
                        code_2 = 84;
                        break;
                    case "Watches":
                        code_2 = 85;
                        break;
                    case "Mobile Accessories":
                        code_2 = 86;
                        break;
                    case "Real Estate":
                        code_2 = 87;
                        break;
                    case "Finance":
                        code_2 = 88;
                        break;
                    case "Commercial Vehicles":
                        code_2 = 89;
                        break;
                    case "Motorcycles":
                        code_2 = 90;
                        break;
                    case "Engines":
                        code_2 = 91;
                        break;
                    case "Turbo Machinery":
                        code_2 = 91;
                        break;
                }
            }
            // first i must retrieve values from here, than after than i need to return these values
            createBarcode("Comp2.png", getSKU());
            insert.insert(area.getValue(), row.getValue(),row_area.getValue(),shelf.getValue(),bin.getValue(),companies.getValue(),code_1,products.getValue(),code_2,getSKU(),"C://Users/Emir/OneDrive/Documents/Comp1.png");
        });

        FileInputStream input = new FileInputStream("C:/Users/Emir/OneDrive/Documents/Test6.jpeg");

        // create a image
        Image image = new Image(input);

        // create a background image
        BackgroundImage backgroundimage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, new BackgroundSize(1.0, 1.0, true, true, false, false));

        // create Background
        Background background = new Background(backgroundimage);
        // set background

        GridPane grid = new GridPane();
        /*grid.setBackground(new Background(myBI));*/

        grid.setMinSize(400, 560);
        grid.setAlignment(Pos.CENTER);
        grid.setBackground(background);
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        grid.add(new Label("Area"),0,0);
        grid.add(area, 1, 0);
        grid.add(new Label("Row"),0,1);
        grid.add(row, 1, 1);
        grid.add(new Label("Row Area"),0,2);
        grid.add(row_area, 1, 2);
        grid.add(new Label("Shelf"),0,3);
        grid.add(shelf, 1, 3);
        grid.add(new Label("Bin"),0,4);
        grid.add(bin, 1, 4);
        grid.add(new Label("Companies: "), 0, 5);
        grid.add(companies, 1, 5);
        grid.add(new Label("Products: "), 0, 6);
        grid.add(products, 1, 6);
        grid.setVgap(15);
        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    public static void createBarcode(String image_name, String myString) {
        try {
            Code128Bean code128 = new Code128Bean();
            code128.setHeight(10f);
            code128.setModuleWidth(0.3);
            code128.setQuietZone(10);
            code128.doQuietZone(true);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            code128.generateBarcode(canvas, myString);
            canvas.finish();
            //write to png file
            FileOutputStream fos = new FileOutputStream("C:/Users/Emir/OneDrive/Documents/" + image_name);
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }

    @Contract(pure = true)
    public String getSKU() {
        return (code_1 + "" + code_2 + "" + firstIDLetter[0] + secondIDLetter[0]);
    }
}