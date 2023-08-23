module com.mycompany.e_project_2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.e_project_2 to javafx.fxml;
    exports com.mycompany.e_project_2;
}
