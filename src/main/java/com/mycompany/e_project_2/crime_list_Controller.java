package com.mycompany.e_project_2;

import CRUD.Crime_profile;
import CRUD.Crime_profile_CRUD;
import com.mycompany.e_project_2.homePage;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class crime_list_Controller implements Initializable{
    private ObservableList<CRUD.Crime_profile> data;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Crime_profile, String> col_crime_profile_id;
    
    @FXML
    private TableColumn<Crime_profile, String> col_crime_type;
    
    @FXML
    private TableColumn<Crime_profile, String> col_criminal;

    @FXML
    private TableColumn<Crime_profile, String> col_date;

    @FXML
    private TableColumn<Crime_profile, String> col_stt;

    @FXML
    private TableColumn<Crime_profile, String> col_note;

    @FXML
    private TableView<Crime_profile> table_crime;

    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        col_stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new ReadOnlyObjectWrapper(table_crime.getItems().indexOf(p.getValue())+1);
            }
        });
        col_crime_profile_id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getId()+"");
            }
        });
        col_crime_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getCrime_type());
            }
        });
        col_criminal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getNumber()+"");
            }
        });
        col_date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getDate()+"");
            }
        });
        col_note.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getNote());
            }
        });
        
        data = Crime_profile_CRUD.getList();
//        data = homePage.selectedItem();s
                
        table_crime.setItems(data);
    }

}
