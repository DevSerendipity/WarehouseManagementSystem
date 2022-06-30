package wms.javafx.event;

import wms.javafx.ComboBoxProperties;
import wms.javafx.Company;

public final class ProductsEvent {

    private ProductsEvent() {

    }

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
