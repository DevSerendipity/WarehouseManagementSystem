package wms.javafx.event;

import wms.javafx.ComboBoxProperties;
import wms.javafx.Company;

public final class CompanyEvent {

    private CompanyEvent() {

    }

    public static int getCompanyCode() {
        return companyCode;
    }

    private static int companyCode;
    private static char firstLetterOfCompanyName = ' ';
    private static char lastLetterOfCompanyName = ' ';

    public static void getCompanyCodeEvent() {
        ComboBoxProperties.getCompanies().getSelectionModel().selectedItemProperty()
                .addListener( ( selectedCompany, oldCompany, newCompany ) -> {
                    System.out.println( selectedCompany );
                    System.out.println( oldCompany );
                    System.out.println( newCompany );
                    for ( Company s: Company.values() ) {
                        if ( newCompany.equals( s.getCompanyName() ) ) {
                            companyCode = s.getCompanyCode();
                            firstLetterOfCompanyName = newCompany.toUpperCase().charAt( 0 );
                            lastLetterOfCompanyName = newCompany.toUpperCase().charAt( newCompany.length() - 1 );
                        }
                    }
                } );
    }


    public static char getFirstLetterOfCompanyName(  ) {
        return firstLetterOfCompanyName;
    }

    public static int getLastLetterOfCompanyName(  ) {
        return lastLetterOfCompanyName;
    }
}
