package WMS.JavaFx.event;

import WMS.JavaFx.ComboBoxProperties;

public class CompanyEvent  {
    private static int companyCode = 0;
    private static final char[] firstAsciLetterOfCompany = new char[1];
    private static final char[] secondAsciLetterOfCompany = new char[1];

    public static void getCompanyCodeEvent(){
        ComboBoxProperties.getCompanies().getSelectionModel().selectedItemProperty()
                .addListener((selectedCompany, oldCompany, newCompany) -> {
            if (newCompany != null) {
                switch (newCompany) {
                    case "Volkswagen Group" -> companyCode = 100;
                    case "Daimler" -> companyCode = 101;
                    case "Airbus" -> companyCode = 102;
                    case "Anheuser-Busch InBev" -> companyCode = 103;
                    case "BASF" -> companyCode = 104;
                    case "Apple" -> companyCode = 105;
                    case "Boeing" -> companyCode = 106;
                    case "Cardinal Health" -> companyCode = 107;
                    case "Dell" -> companyCode = 108;
                    case "China Baowu Steel Group" -> companyCode = 109;
                    case "DowDuPont" -> companyCode = 110;
                    case "Foxconn" -> companyCode = 111;
                    case "General Electronics" -> companyCode = 112;
                    case "General Motors" -> companyCode = 113;
                    case "Hoffmann-La Roche" -> companyCode = 114;
                    case "JBS S.A." -> companyCode = 115;
                    case "Nippon Steel & Sumitomo Metal" -> companyCode = 116;
                    case "Norinco" -> companyCode = 117;
                    case "PepsiCo" -> companyCode = 118;
                    case "Pfizer" -> companyCode = 119;
                    case "POSCO" -> companyCode = 120;
                    case "Samsung Electronics" -> companyCode = 121;
                    case "Sinochem" -> companyCode = 122;
                    case "Toyota Group" -> companyCode = 123;
                }
            }
            assert newCompany != null;
            firstAsciLetterOfCompany[0] = newCompany.toUpperCase().charAt(0);
            secondAsciLetterOfCompany[0] =
                    newCompany.toUpperCase().charAt(newCompany.length() - 1);
        });
    }
    public static int getCompanyCode() {return companyCode;}

    public static int getFirstAsciLetterOfCompany(int index) {
        return firstAsciLetterOfCompany[index];
    }

    public static int getSecondAsciLetterOfCompany(int index) {
        return secondAsciLetterOfCompany[index];
    }
}
