package wms.javafx;

public enum Company {

    VOLKSWAGEN( "Volkswagen Group", 100 ),
    DAIMLER( "Daimler", 101 ),
    AIRBUS( "Airbus", 102 ),
    ANHEUSER_BUSCH_INBEV( "Anheuser-Busch InBev", 103 ),
    BASF( "BASF", 104 ),
    APPLE( "Apple", 105 ),
    BOEIN( "Boeing", 106 ),
    CARDINAL_HEALTH( "Cardinal Health", 107 ),
    DELL( "Dell", 108 ),
    CHINA_BAOWU_STEEL_GROUP( "China Baowu Steel Group", 109 ),
    DOW_DU_PONT( "DowDuPont", 110 ),
    FOXCONN( "Foxconn", 111 ),
    GENERAL_ELECTRONICS( "General Electronics", 112 ),
    GENERAL_MOTORS( "General Motors", 113 ),
    HOFFMAN_LA_ROCHE( "Hoffmann-La Roche", 114 ),
    JBS_S_A( "JBS S.A.", 115 ),
    NIPPON_STEEL_AND_SUMITOMO_METAL( "Nippon Steel & Sumitomo Metal", 116 ),
    NORINCO( "Norinco", 117 ),
    PEPSI_CO( "PepsiCo", 118 ),
    PFIZER( "Pfizer", 119 ),
    POSCO( "POSCO", 120 ),
    SAMSUNG_ELECTRONICS( "Samsung Electronics", 121 ),
    SINOCHEM( "Sinochem", 122 ),
    TOYOTA_GROUP( "Toyota Group", 12 );

    public String getCompanyName() {
        return companyName;
    }

    public int getCompanyCode() {
        return companyCode;
    }

    public final String companyName;
    public final int companyCode;

    private Company( String companyName, int companyCode ) {
        this.companyName = companyName;
        this.companyCode = companyCode;
    }
}
