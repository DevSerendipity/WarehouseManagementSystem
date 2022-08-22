package com.devserendipity.warehousemanagementsystem.javafx;

public enum Product {

    JETS("JETS", 10),
    MILITARY_AIRCRAFT("Military_Aircraft", 11),
    SATELLITES_LAUNCHERS("Satellites_Launchers", 12),
    HELICOPTERS("Helicopters", 13),
    DRINK("Drink", 14),
    BREWING("Brewing", 15),
    MAC("Mac", 16),
    IPAD("IPad", 17),
    IPHONE("IPhone", 18),
    WATCH("Watch", 19),
    TV("TV", 20),
    AGRICULTURE("Agriculture", 21),
    AUTOMOTIVE_AND_TRANSPORTATION("Automotive_and_Transportation", 22),
    CONSTRUCTION("Construction", 23),
    ELECTRONICS_AND_ELECTRIC("Electronics_and_Electric", 24),
    AIRPLANES("Airplanes", 25),
    TRANSPORT_AIRCRAFT("Transport_Aircraft", 26),
    AUTONOMOUS_SYSTEMS("Autonomous_Systems", 27),
    ANESTHESIA_SUPPLIES("Anesthesia_Supplies", 28),
    COMPRESSION("Compression", 29),
    LABORATORY_PRODUCTS("Laboratory_Products", 30),
    INFECTION_CONTROL("Infection_Control", 31),
    SKIN_WOUND_MANAGEMENT("Skin_wound_Management", 32),
    IRON("Iron", 33),
    STEEL("Steel", 34),
    PASSENGER_CARS("Passenger_Cars", 35),
    TRUCKS("Trucks", 36),
    VANS("Vans", 37),
    BUSES("Buses", 38),
    MONITORS("Monitors", 39),
    PROJECTORS("Projectors", 40),
    DESKTOP("Desktops", 41),
    LAPTOPS("Laptops", 42),
    ULTRA_BOOKS("Ultra_books", 43),
    ADHESIVES("Adhesives", 43),
    ADVANCED_PRINTING_SOLUTIONS("Advanced_Printing_Solutions", 44),
    ANIMAL_NUTRITION("Animal_Nutrition", 45),
    BIOMATERIALS("Biomaterials", 46),
    CLEAN_TECHNOLOGIES("Clean_Technologies", 47),
    ELECTRONIC_COMPONENTS("Electronic_Components", 48),
    PCBS("PCBs", 49),
    PCB_COMPONENTS("PCB_Components", 50),
    COMPUTER_CHIPS("Computer_Chips", 51),
    JET_ENGINE("Jet_Engine", 52),
    GAS_TURBINES("Gas_Turbines", 53),
    HYDROELECTRIC_POWER("Hydroelectric_Power", 54),
    GRID("Grid", 55),
    WIND_TURBINE("Wind_Turbine", 56),
    MOTOR_SPORTS("Motor_Sports", 57),
    HYBRID_VEHICLES("Hybrid_Vehicles", 58),
    HYDRO_TEC_MILITARY_VEHICLES("Hydro_tec_Military_Vehicles", 59),
    ANAEMIA("Anaemia", 60),
    CANCER("Cancer", 61),
    DERMATOLOGY("Dermatology", 62),
    LEUKEMIA("Leukemia", 63),
    TRANSPLANTATION("Transplantation", 64),
    PROCESSED_BEEF("Processed_Beef", 65),
    BY_PRODUCTS("By_products", 66),
    PROCESSED_CHICKEN("Processed_Chicken", 67),
    ENERGY("Energy", 68),
    INFRASTRUCTURE("Infrastructure", 69),
    CONSUMER_ELECTRONICS("Consumer_Electronics", 70),
    RIFLES("Rifles", 71),
    BOMBS("Bombs", 72),
    GRANADA_LAUNCHERS("Granada_Launchers", 73),
    AIRCRAFT("Aircraft", 74),
    FOOD("Food", 75),
    SNACKS("Snack", 76),
    BEVERAGE("Beverage", 77),
    CARDIOVASCULAR("Cardiovascular", 78),
    DIABETES_AND_METABOLIC("Diabetes_and_Metabolic", 79),
    IMMUNE_SYSTEM("Immune_System", 80),
    INFECTIONS_AND_INFECTIOUS("Infections_and_Infectious", 81),
    PHONES("Phones", 82),
    TABLES("Tables", 83),
    WATCHERS("Watches", 84),
    MOBILE_ACCESSORIES("Mobile_Accessories", 85),
    REAL_ESTATE("Real_Estate", 86),
    FINANCE("Finance", 87),
    COMMERCIAL_VEHICLES("Commercial_Vehicles", 88),
    MOTORCYCLES("Motorcycles", 89),
    ENGINE("Engines", 90),
    TURBO_MACHINERY("Turbo_Machinery", 91);

    private final String productName;
    private final int productCode;

    Product(String productName, int productCode) {
        this.productName = productName;
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductCode() {
        return productCode;
    }
}
