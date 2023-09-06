module com.mycompany.e_project_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires mysql.connector.j;
    requires com.google.protobuf;
    requires java.sql;
    opens com.mycompany.e_project_2 to javafx.fxml;
    exports com.mycompany.e_project_2;
}
