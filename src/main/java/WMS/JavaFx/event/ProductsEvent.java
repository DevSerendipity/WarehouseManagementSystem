package WMS.JavaFx.event;

import WMS.JavaFx.ComboBoxProperties;

public class ProductsEvent {

    private static int productCode = 0;

    public static void getProductCodeEvent() {
        ComboBoxProperties.getProducts().getSelectionModel().selectedItemProperty()
                .addListener((selectedProduct, oldProduct, newProduct) -> {
            if (newProduct != null) {
                switch (newProduct) {
                    case "Jets" -> productCode = 10;
                    case "Military Aircraft" -> productCode = 11;
                    case "Satellites Launchers" -> productCode = 12;
                    case "Helicopters" -> productCode = 13;
                    case "Drink" -> productCode = 14;
                    case "Brewing" -> productCode = 15;
                    case "Mac" -> productCode = 16;
                    case "IPad" -> productCode = 17;
                    case "IPhone" -> productCode = 18;
                    case "Watch" -> productCode = 19;
                    case "TV" -> productCode = 20;
                    case "Agriculture" -> productCode = 21;
                    case "Automotive & Transportation" -> productCode = 22;
                    case "Construction" -> productCode = 23;
                    case "Electronics & Electric" -> productCode = 24;
                    case "Airplanes" -> productCode = 25;
                    case "Transport Aircraft" -> productCode = 26;
                    case "Autonomous Systems" -> productCode = 27;
                    case "Anesthesia Supplies" -> productCode = 28;
                    case "Compression" -> productCode = 29;
                    case "Laboratory Products" -> productCode = 30;
                    case "Infection Control" -> productCode = 31;
                    case "Skin/wound Management" -> productCode = 32;
                    case "Iron" -> productCode = 33;
                    case "Steel" -> productCode = 34;
                    case "Passenger Cars" -> productCode = 35;
                    case "Trucks" -> productCode = 36;
                    case "Vans" -> productCode = 37;
                    case "Buses" -> productCode = 38;
                    case "Monitors" -> productCode = 39;
                    case "Projectors" -> productCode = 40;
                    case "Desktops" -> productCode = 41;
                    case "Laptops" -> productCode = 42;
                    case "Ultra books" -> productCode = 43;
                    case "Adhesives" -> productCode = 43;
                    case "Advanced Printing Solutions" -> productCode = 44;
                    case "Animal Nutrition" -> productCode = 45;
                    case "Biomaterials" -> productCode = 46;
                    case "Clean Technologies" -> productCode = 47;
                    case "Electronic Components" -> productCode = 48;
                    case "PCBs" -> productCode = 49;
                    case "PCB Components" -> productCode = 50;
                    case "Computer Chips" -> productCode = 51;
                    case "Jet Engine" -> productCode = 52;
                    case "Gas Turbines" -> productCode = 53;
                    case "Hydroelectric Power" -> productCode = 54;
                    case "BackgroundImg" -> productCode = 55;
                    case "Wind Turbine" -> productCode = 56;
                    case "Motor Sports" -> productCode = 57;
                    case "Hybrid Vehicles" -> productCode = 58;
                    case "Hydro tec Military Vehicles" -> productCode = 59;
                    case "Anaemia" -> productCode = 60;
                    case "Cancer" -> productCode = 61;
                    case "Dermatology" -> productCode = 62;
                    case "Leukemia" -> productCode = 63;
                    case "Transplantation" -> productCode = 64;
                    case "Processed Beef" -> productCode = 65;
                    case "By-products" -> productCode = 66;
                    case "Processed Chicken" -> productCode = 67;
                    case "Energy" -> productCode = 68;
                    case "Infrastructure" -> productCode = 69;
                    case "Consumer Electronics" -> productCode = 70;
                    case "Rifles" -> productCode = 71;
                    case "Bombs" -> productCode = 72;
                    case "Granada Launchers" -> productCode = 73;
                    case "Aircraft" -> productCode = 74;
                    case "Food" -> productCode = 75;
                    case "Snack" -> productCode = 76;
                    case "Beverage" -> productCode = 77;
                    case "Cardiovascular" -> productCode = 78;
                    case "Diabetes & Metabolic" -> productCode = 79;
                    case "Immune System" -> productCode = 80;
                    case "Infections & Infectious" -> productCode = 81;
                    case "Phones" -> productCode = 82;
                    case "Tables" -> productCode = 83;
                    case "Watches" -> productCode = 84;
                    case "Mobile Accessories" -> productCode = 85;
                    case "Real Estate" -> productCode = 86;
                    case "Finance" -> productCode = 87;
                    case "Commercial Vehicles" -> productCode = 88;
                    case "Motorcycles" -> productCode = 89;
                    case "Engines" -> productCode = 90;
                    case "Turbo Machinery" -> productCode = 91;
                }
            }
        });
    }
    public static int getProductCode() {
        return productCode;
    }
}
