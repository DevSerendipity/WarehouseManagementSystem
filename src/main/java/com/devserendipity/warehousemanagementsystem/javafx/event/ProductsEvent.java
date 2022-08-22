package com.devserendipity.warehousemanagementsystem.javafx.event;

import com.devserendipity.warehousemanagementsystem.javafx.ComboBoxProperties;
import com.devserendipity.warehousemanagementsystem.javafx.Company;

public final class ProductsEvent {

    private static int productCode;
    public static void getProductCodeEvent() {
        ComboBoxProperties.getProducts().getSelectionModel().selectedItemProperty()
                          .addListener( ( selectedProduct, oldProduct, newProduct ) -> {
                    for ( Company s: Company.values() ) {
                        if ( newProduct.equals( s.getCompanyName() ) ) {
                            productCode = s.getCompanyCode();
                        }
                    }
                } );
    }
    public static int getProductCode() {
        return productCode;
    }
}
