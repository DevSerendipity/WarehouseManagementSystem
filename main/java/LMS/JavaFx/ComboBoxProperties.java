package LMS.JavaFx;

import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static LMS.JavaFx.event.CompanyEvent.getCompanyCodeEvent;
import static LMS.JavaFx.event.ProductsEvent.getProductCodeEvent;


public class ComboBoxProperties {
    private static final Map<String, String[]> keyValuesParForCompaniesAndProducts = new TreeMap<>();
    private static final ComboBox<String> companies = new ComboBox<>();
    private static final ComboBox<String> products = new ComboBox<>();
    private static final ComboBox<String> storageArea = new ComboBox<>();
    private static final ComboBox<String> row = new ComboBox<>();
    private static final ComboBox<String> row_area = new ComboBox<>();
    private static final ComboBox<String> shelf = new ComboBox<>();
    private static final ComboBox<Integer> bin = new ComboBox<>();

    public static ComboBox<String> getCompanies() {
        return companies;
    }

    public static ComboBox<String> getProducts() { return products;}

    public static ComboBox<String> getStorageArea() {
        return storageArea;
    }

    public static ComboBox<String> getRow() {
        return row;
    }

    public static ComboBox<String> getRowArea() {
        return row_area;
    }

    public static ComboBox<String> getShelf() {
        return shelf;
    }

    public static ComboBox<Integer> getBin() {
        return bin;
    }

    public Map<String, String[]> getKeyValuesParForCompaniesAndProducts() {
        return keyValuesParForCompaniesAndProducts;
    }

   public void InitializeComboBoxes() {
        getStorageArea().getItems().addAll("Area 1","Area 2");
        getRow().getItems().addAll("A1","A2","B1","B2");
        getRowArea().getItems().addAll("RA1","RA2","RA3");
        getShelf().getItems().addAll("A","B","C");
        getBin().getItems().addAll(1,2,3);
        getCompanies().getItems().setAll(new ArrayList<>(keyValuesParForCompaniesAndProducts.keySet()));
        getCompanies().setOnAction(e -> getProducts().getItems()
                .setAll(keyValuesParForCompaniesAndProducts.get(getCompanies().getSelectionModel().getSelectedItem())));
        getCompanyCodeEvent();
        getProductCodeEvent();
    }
}
