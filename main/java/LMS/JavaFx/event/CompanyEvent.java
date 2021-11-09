package LMS.JavaFx.event;

import static LMS.JavaFx.ComboBoxes.getCompanies;

public class CompanyEvent  {
    private static int productCodeOne = 0;
    private static final char[] firstIDLetter = new char[1];
    private static final char[] secondIDLetter = new char[1];

    public static void getCompanyEvent(){
        getCompanies().getSelectionModel().selectedItemProperty().addListener((selected, oldComp, newComp) -> {
            if (newComp != null) {
                switch (newComp) {
                    case "Volkswagen Group" -> productCodeOne = 100;
                    case "Daimler" -> productCodeOne = 101;
                    case "Airbus" -> productCodeOne = 102;
                    case "Anheuser-Busch InBev" -> productCodeOne = 103;
                    case "BASF" -> productCodeOne = 104;
                    case "Apple" -> productCodeOne = 105;
                    case "Boeing" -> productCodeOne = 106;
                    case "Cardinal Health" -> productCodeOne = 107;
                    case "Dell" -> productCodeOne = 108;
                    case "China Baowu Steel Group" -> productCodeOne = 109;
                    case "DowDuPont" -> productCodeOne = 110;
                    case "Foxconn" -> productCodeOne = 111;
                    case "General Electronics" -> productCodeOne = 112;
                    case "General Motors" -> productCodeOne = 113;
                    case "Hoffmann-La Roche" -> productCodeOne = 114;
                    case "JBS S.A." -> productCodeOne = 115;
                    case "Nippon Steel & Sumitomo Metal" -> productCodeOne = 116;
                    case "Norinco" -> productCodeOne = 117;
                    case "PepsiCo" -> productCodeOne = 118;
                    case "Pfizer" -> productCodeOne = 119;
                    case "POSCO" -> productCodeOne = 120;
                    case "Samsung Electronics" -> productCodeOne = 121;
                    case "Sinochem" -> productCodeOne = 122;
                    case "Toyota Group" -> productCodeOne = 123;
                }
            }
            assert newComp != null;
            firstIDLetter[0] = newComp.toUpperCase().charAt(0);
            secondIDLetter[0] = newComp.toUpperCase().charAt(newComp.length() - 1);
        });
    }
    public static int getProductCodeOne() {
        return productCodeOne;
    }

    public static int getFirstIDLetter(int index) {
        return firstIDLetter[index];
    }

    public static int getSecondIDLetter(int index) {
        return secondIDLetter[index];
    }
}
