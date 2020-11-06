package LMS.JavaFx.event;

import LMS.JavaFx.ComboBoxes;

public class CompanyEvent {
    private int code_1 = 0;
    private final ComboBoxes comboBoxes = new ComboBoxes();
    private final char[] firstIDLetter = new char[1];
    private final char[] secondIDLetter = new char[1];

    public void getCompanyEvent(){
        comboBoxes.getCompanies().getSelectionModel().selectedItemProperty().addListener((selected, oldComp, newComp) -> {
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
    }
    public int getCode1() {
        return code_1;
    }

    public int getFirstIDLetter(int index) {
        return firstIDLetter[index];
    }

    public int getSecondIDLetter(int index) {
        return secondIDLetter[index];
    }
}
