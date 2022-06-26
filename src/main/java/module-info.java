module LMS.JavaFx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires barcode4j;
    requires org.postgresql.jdbc;
    requires java.desktop;

    opens wms.javafx to javafx.fxml;
    exports wms.javafx;
}
