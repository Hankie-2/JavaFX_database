module com.example.javafx_database {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx_database.contoller to javafx.fxml;
    exports com.example.javafx_database;
}