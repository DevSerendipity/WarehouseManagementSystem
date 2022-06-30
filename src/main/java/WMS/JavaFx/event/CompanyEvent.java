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
    private static char FIRST_LETTER_OF_COMPANY_NAME = ' ';
    private static char LAST_LETTER_OF_COMPANY_NAME = ' ';

    public static void getCompanyCodeEvent() {
        ComboBoxProperties.getCompanies().getSelectionModel().selectedItemProperty()
                .addListener( ( selectedCompany, oldCompany, newCompany ) -> {
                    System.out.println( selectedCompany );
                    System.out.println( oldCompany );
                    System.out.println( newCompany );
                    for ( Company s: Company.values() ) {
                        if ( newCompany.equals( s.getCompanyName() ) ) {
                            companyCode = s.getCompanyCode();
                            FIRST_LETTER_OF_COMPANY_NAME = newCompany.toUpperCase().charAt( 0 );
                            LAST_LETTER_OF_COMPANY_NAME = newCompany.toUpperCase().charAt( newCompany.length() - 1 );
                        }
                    }
                } );
    }


    public static char getFirstLetterOfCompanyName(  ) {
        return FIRST_LETTER_OF_COMPANY_NAME;
    }

    public static int getLastLetterOfCompanyName(  ) {
        return LAST_LETTER_OF_COMPANY_NAME;
    }
}
