package LMS.JavaFx.event;

import static LMS.JavaFx.ComboBoxes.*;

public class ProductsEvent {
    private static int productCodeTwo = 0;


    public static void getProductEvent() {
        getProducts().getSelectionModel().selectedItemProperty().addListener((selected, oldProd, newProd) -> {
            if (newProd != null) {
                switch (newProd) {
                    case "Jets" -> productCodeTwo = 10;
                    case "Military Aircraft" -> productCodeTwo = 11;
                    case "Satellites Launchers" -> productCodeTwo = 12;
                    case "Helicopters" -> productCodeTwo = 13;
                    case "Drink" -> productCodeTwo = 14;
                    case "Brewing" -> productCodeTwo = 15;
                    case "Mac" -> productCodeTwo = 16;
                    case "IPad" -> productCodeTwo = 17;
                    case "IPhone" -> productCodeTwo = 18;
                    case "Watch" -> productCodeTwo = 19;
                    case "TV" -> productCodeTwo = 20;
                    case "Agriculture" -> productCodeTwo = 21;
                    case "Automotive & Transportation" -> productCodeTwo = 22;
                    case "Construction" -> productCodeTwo = 23;
                    case "Electronics & Electric" -> productCodeTwo = 24;
                    case "Airplanes" -> productCodeTwo = 25;
                    case "Transport Aircraft" -> productCodeTwo = 26;
                    case "Autonomous Systems" -> productCodeTwo = 27;
                    case "Anesthesia Supplies" -> productCodeTwo = 28;
                    case "Compression" -> productCodeTwo = 29;
                    case "Laboratory Products" -> productCodeTwo = 30;
                    case "Infection Control" -> productCodeTwo = 31;
                    case "Skin/wound Management" -> productCodeTwo = 32;
                    case "Iron" -> productCodeTwo = 33;
                    case "Steel" -> productCodeTwo = 34;
                    case "Passenger Cars" -> productCodeTwo = 35;
                    case "Trucks" -> productCodeTwo = 36;
                    case "Vans" -> productCodeTwo = 37;
                    case "Buses" -> productCodeTwo = 38;
                    case "Monitors" -> productCodeTwo = 39;
                    case "Projectors" -> productCodeTwo = 40;
                    case "Desktops" -> productCodeTwo = 41;
                    case "Laptops" -> productCodeTwo = 42;
                    case "Ultra books" -> productCodeTwo = 43;
                    case "Adhesives" -> productCodeTwo = 43;
                    case "Advanced Printing Solutions" -> productCodeTwo = 44;
                    case "Animal Nutrition" -> productCodeTwo = 45;
                    case "Biomaterials" -> productCodeTwo = 46;
                    case "Clean Technologies" -> productCodeTwo = 47;
                    case "Electronic Components" -> productCodeTwo = 48;
                    case "PCBs" -> productCodeTwo = 49;
                    case "PCB Components" -> productCodeTwo = 50;
                    case "Computer Chips" -> productCodeTwo = 51;
                    case "Jet Engine" -> productCodeTwo = 52;
                    case "Gas Turbines" -> productCodeTwo = 53;
                    case "Hydroelectric Power" -> productCodeTwo = 54;
                    case "BackgroundImg" -> productCodeTwo = 55;
                    case "Wind Turbine" -> productCodeTwo = 56;
                    case "Motor Sports" -> productCodeTwo = 57;
                    case "Hybrid Vehicles" -> productCodeTwo = 58;
                    case "Hydro tec Military Vehicles" -> productCodeTwo = 59;
                    case "Anaemia" -> productCodeTwo = 60;
                    case "Cancer" -> productCodeTwo = 61;
                    case "Dermatology" -> productCodeTwo = 62;
                    case "Leukemia" -> productCodeTwo = 63;
                    case "Transplantation" -> productCodeTwo = 64;
                    case "Processed Beef" -> productCodeTwo = 65;
                    case "By-products" -> productCodeTwo = 66;
                    case "Processed Chicken" -> productCodeTwo = 67;
                    case "Energy" -> productCodeTwo = 68;
                    case "Infrastructure" -> productCodeTwo = 69;
                    case "Consumer Electronics" -> productCodeTwo = 70;
                    case "Rifles" -> productCodeTwo = 71;
                    case "Bombs" -> productCodeTwo = 72;
                    case "Granada Launchers" -> productCodeTwo = 73;
                    case "Aircraft" -> productCodeTwo = 74;
                    case "Food" -> productCodeTwo = 75;
                    case "Snack" -> productCodeTwo = 76;
                    case "Beverage" -> productCodeTwo = 77;
                    case "Cardiovascular" -> productCodeTwo = 78;
                    case "Diabetes & Metabolic" -> productCodeTwo = 79;
                    case "Immune System" -> productCodeTwo = 80;
                    case "Infections & Infectious" -> productCodeTwo = 81;
                    case "Phones" -> productCodeTwo = 82;
                    case "Tables" -> productCodeTwo = 83;
                    case "Watches" -> productCodeTwo = 84;
                    case "Mobile Accessories" -> productCodeTwo = 85;
                    case "Real Estate" -> productCodeTwo = 86;
                    case "Finance" -> productCodeTwo = 87;
                    case "Commercial Vehicles" -> productCodeTwo = 88;
                    case "Motorcycles" -> productCodeTwo = 89;
                    case "Engines" -> productCodeTwo = 90;
                    case "Turbo Machinery" -> productCodeTwo = 91;
                }
            }
        });
    }
    public static int getCode2() {
        return productCodeTwo;
    }
}
