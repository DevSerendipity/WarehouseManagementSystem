package wms.javafx;

import javafx.scene.control.ComboBox;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import static wms.javafx.event.CompanyEvent.getCompanyCodeEvent;
import static wms.javafx.event.ProductsEvent.getProductCodeEvent;


public class ComboBoxProperties {
    private static final Map<String, String[]> keyValuesParForCompaniesAndProducts = new TreeMap<>();
    private static final ComboBox<String> COMPANIES = new ComboBox<>();
    private static final ComboBox<String> PRODUCTS = new ComboBox<>();
    private static final ComboBox<String> STORAGE_AREA = new ComboBox<>();
    private static final ComboBox<String> WAREHOUSE_ROW = new ComboBox<>();
    private static final ComboBox<String> ROW_AREA = new ComboBox<>();
    private static final ComboBox<String> SHELF = new ComboBox<>();
    private static final ComboBox<Integer> BIN = new ComboBox<>();

    public static ComboBox<String> getCompanies() {
        return COMPANIES;
    }

    public static ComboBox<String> getProducts() {
        return PRODUCTS;
    }

    public static ComboBox<String> getStorageArea() {
        return STORAGE_AREA;
    }

    public static ComboBox<String> getWarehouseRow() {
        return WAREHOUSE_ROW;
    }

    public static ComboBox<String> getRowArea() {
        return ROW_AREA;
    }

    public static ComboBox<String> getShelf() {
        return SHELF;
    }

    public static ComboBox<Integer> getBin() {
        return BIN;
    }

    public Map<String, String[]> getKeyValuesParForCompaniesAndProducts() {
        return keyValuesParForCompaniesAndProducts;
    }

    public void initializeComboBoxes() {
        getStorageArea().getItems().addAll( "Area 1", "Area 2" );
        getWarehouseRow().getItems().addAll( "A1", "A2", "B1", "B2" );
        getRowArea().getItems().addAll( "RA1", "RA2", "RA3" );
        getShelf().getItems().addAll( "A", "B", "C" );
        getBin().getItems().addAll( 1, 2, 3 );
        getCompanies().getItems().setAll( new ArrayList<>( keyValuesParForCompaniesAndProducts.keySet() ) );
        getCompanies().setOnAction( e -> getProducts().getItems().setAll(
                keyValuesParForCompaniesAndProducts.get( getCompanies().getSelectionModel().getSelectedItem() ) ) );
        getCompanyCodeEvent();
        getProductCodeEvent();
    }
}
