package LMS.JavaFx;

import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ComboBoxes{
    // moved the ComboBox class instances to another class, and cleaning up the main class

    private final Map<String, String[]> map = new TreeMap<>();
    private final ComboBox<String> companies = new ComboBox<>();
    private final ComboBox<String> products = new ComboBox<>();
    private final ComboBox<String> area = new ComboBox<>();
    private final ComboBox<String> row = new ComboBox<>();
    private final ComboBox<String> row_area = new ComboBox<>();
    private final ComboBox<String> shelf = new ComboBox<>();
    private final ComboBox<Integer> bin = new ComboBox<>();
    // providing getters to retrieve values
    public ComboBox<String> getCompanies() {
        return companies;
    }

    public ComboBox<String> getProducts() {
        return products;
    }

    public ComboBox<String> getArea() {
        return area;
    }

    public ComboBox<String> getRow() {
        return row;
    }

    public ComboBox<String> getRowArea() {
        return row_area;
    }

    public ComboBox<String> getShelf() {
        return shelf;
    }

    public ComboBox<Integer> getBin() {
        return bin;
    }

    public Map<String, String[]> getMap() {
        return map;
    }

    public void initialize() {
        getArea().getItems().addAll("Area 1","Area 2");
        getRow().getItems().addAll("A1","A2","B1","B2");
        getRowArea().getItems().addAll("RA1","RA2","RA3");
        getShelf().getItems().addAll("A","B","C");
        getBin().getItems().addAll(1,2,3);
        getCompanies().getItems().setAll(new ArrayList<>(map.keySet()));
        getCompanies().setOnAction(e -> getProducts().getItems().setAll(map.get(getCompanies().getSelectionModel().getSelectedItem())));
    }


}
