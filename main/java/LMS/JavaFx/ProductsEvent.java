package LMS.JavaFx;

import LMS.Connection.InsertFiles.Insert;

public class ProductsEvent extends RetrieveSKU{
    private final ComboBoxes comboBoxes = new ComboBoxes();
    private final Insert insert = new Insert();
    private final Barcode barcode = new Barcode();
    private int code_2 = 0;

    public void getProductEvent() {
        comboBoxes.getProducts().getSelectionModel().selectedItemProperty().addListener((selected, oldProd, newProd) -> {

            if (newProd != null) {
                switch (newProd) {
                    case "Jets":
                        code_2 = 10;
                        break;
                    case "Military Aircrafts":
                        code_2 = 11;
                        break;
                    case "Satellites Launchers":
                        code_2 = 12;
                        break;
                    case "Helicopters":
                        code_2 = 13;
                        break;
                    case "Drink":
                        code_2 = 15;
                        break;
                    case "Brewing":
                        code_2 = 16;
                        break;
                    case "Mac":
                        code_2 = 17;
                        break;
                    case "IPad":
                        code_2 = 18;
                        break;
                    case "IPhone":
                        code_2 = 19;
                        break;
                    case "Watch":
                        code_2 = 20;
                        break;
                    case "TV":
                        code_2 = 21;
                        break;
                    case "Agriculture":
                        code_2 = 22;
                        break;
                    case "Automotive & Transportation":
                        code_2 = 23;
                        break;
                    case "Construction":
                        code_2 = 24;
                        break;
                    case "Electronics & Electric":
                        code_2 = 25;
                        break;
                    case "Airplanes":
                        code_2 = 26;
                        break;
                    case "Transport Aircraft":
                        code_2 = 27;
                        break;
                    case "Autonomous Systems":
                        code_2 = 28;
                        break;
                    case "Anesthesia Supplies":
                        code_2 = 29;
                        break;
                    case "Compression":
                        code_2 = 30;
                        break;
                    case "Laboratory Products":
                        code_2 = 31;
                        break;
                    case "Infection Control":
                        code_2 = 32;
                        break;
                    case "Skin/wound Management":
                        code_2 = 33;
                        break;
                    case "Iron":
                        code_2 = 34;
                        break;
                    case "Steel":
                        code_2 = 35;
                        break;
                    case "Passenger Cars":
                        code_2 = 36;
                        break;
                    case "Trucks":
                        code_2 = 37;
                        break;
                    case "Vans":
                        code_2 = 38;
                        break;
                    case "Buses":
                        code_2 = 39;
                        break;
                    case "Monitors":
                        code_2 = 40;
                        break;
                    case "Projectors":
                        code_2 = 41;
                        break;
                    case "Desktops":
                        code_2 = 42;
                        break;
                    case "Laptops":
                        code_2 = 43;
                        break;
                    case "Ultra books":
                        code_2 = 44;
                        break;
                    case "Adhesives":
                        code_2 = 45;
                        break;
                    case "Advanced Printing Solutions":
                        code_2 = 46;
                        break;
                    case "Animal Nutrition":
                        code_2 = 47;
                        break;
                    case "Biomaterials":
                        code_2 = 48;
                        break;
                    case "Clean Technologies":
                        code_2 = 49;
                        break;
                    case "Electronic Components":
                        code_2 = 50;
                        break;
                    case "PCBs":
                        code_2 = 51;
                        break;
                    case "PCB Components":
                        code_2 = 52;
                        break;
                    case "Computer Chips":
                        code_2 = 53;
                        break;
                    case "Jet Engine":
                        code_2 = 54;
                        break;
                    case "Gas Turbines":
                        code_2 = 55;
                        break;
                    case "Hydroelectric Power":
                        code_2 = 56;
                        break;
                    case "BackgroundImg":
                        code_2 = 57;
                        break;
                    case "Wind Turbine":
                        code_2 = 58;
                        break;
                    case "Motor Sports":
                        code_2 = 59;
                        break;
                    case "Hybrid Vehicles":
                        code_2 = 60;
                        break;
                    case "Hydrotec Military Vehicles":
                        code_2 = 61;
                        break;
                    case "Anaemia":
                        code_2 = 62;
                        break;
                    case "Cancer":
                        code_2 = 63;
                        break;
                    case "Dermatology":
                        code_2 = 64;
                        break;
                    case "Leukemia":
                        code_2 = 65;
                        break;
                    case "Transplantation":
                        code_2 = 66;
                        break;
                    case "Processed Beef":
                        code_2 = 67;
                        break;
                    case "By-products":
                        code_2 = 68;
                        break;
                    case "Processed Chicken":
                        code_2 = 69;
                        break;
                    case "Energy":
                        code_2 = 70;
                        break;
                    case "Infrastructure":
                        code_2 = 71;
                        break;
                    case "Consumer Electronics":
                        code_2 = 72;
                        break;
                    case "Rifles":
                        code_2 = 73;
                        break;
                    case "Bombs":
                        code_2 = 74;
                        break;
                    case "Granada Launchers":
                        code_2 = 75;
                        break;
                    case "Aircrafts, Ships":
                        code_2 = 76;
                        break;
                    case "Food":
                        code_2 = 77;
                        break;
                    case "Snack":
                        code_2 = 78;
                        break;
                    case "Beverage":
                        code_2 = 78;
                        break;
                    case "Cardiovascular":
                        code_2 = 79;
                        break;
                    case "Diabetes & Metabolic":
                        code_2 = 80;
                        break;
                    case "Immune System":
                        code_2 = 81;
                        break;
                    case "Infections & Infectious":
                        code_2 = 82;
                        break;
                    case "Phones":
                        code_2 = 83;
                        break;
                    case "Tables":
                        code_2 = 84;
                        break;
                    case "Watches":
                        code_2 = 85;
                        break;
                    case "Mobile Accessories":
                        code_2 = 86;
                        break;
                    case "Real Estate":
                        code_2 = 87;
                        break;
                    case "Finance":
                        code_2 = 88;
                        break;
                    case "Commercial Vehicles":
                        code_2 = 89;
                        break;
                    case "Motorcycles":
                        code_2 = 90;
                        break;
                    case "Engines":
                        code_2 = 91;
                        break;
                    case "Turbo Machinery":
                        code_2 = 91;
                        break;
                }
            }
            // first i must retrieve values from here, than after than i need to return these values
            barcode.createBarcode("Comp2.png", barcode.getSKU()); // need to take the method from RETRIEVE SKU AND ADD
            // inserting code to the database
            insert.insert(comboBoxes.getArea().getValue(), comboBoxes.getRow().getValue(), comboBoxes.getRowArea().getValue(), comboBoxes.getShelf().getValue(), comboBoxes.getBin().getValue(), comboBoxes.getCompanies().getValue(), companyEvent.getCode1(), comboBoxes.getProducts().getValue(), code_2, barcode.getSKU(), "C://Users/Emir/OneDrive/Documents/Comp1.png");
        });
    }
    public int getCode2() {
        return code_2;
    }
}
