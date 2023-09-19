package com.mycompany.e_project_2;

import CRUD.Crime;
import CRUD.Crime_profile;
import CRUD.Crime_type;
import CRUD.Has_crime;
import CRUD.Prisoner;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import CRUD.statistic_Crime;
import CRUD.statistic_Crime_type;
import CRUD.statistic_Prisoner;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.Callback;

public class statistic_Controller implements Initializable {

//    static ObservableList<statistic> data;
    static ObservableList<CRUD.statistic_Crime> data_crime = FXCollections.observableArrayList();
    static ObservableList<CRUD.statistic_Crime_type> data_crime_type;
    static ObservableList<CRUD.statistic_Prisoner> data_prisoner = FXCollections.observableArrayList();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<statistic_Crime, String> col_crime;

    @FXML
    private TableColumn<statistic_Crime, String> col_crime_quantity;

    @FXML
    private TableColumn<statistic_Crime, String> col_crime_sus;

    @FXML
    private TableColumn<statistic_Crime_type, String> col_crime_type;

    @FXML
    private TableColumn<statistic_Crime_type, String> col_crime_type_quantity;

    @FXML
    private TableColumn<statistic_Crime_type, String> col_crime_type_sus;

    @FXML
    private TableColumn<statistic_Prisoner, String> col_criminal_in;

    @FXML
    private TableColumn<statistic_Prisoner, String> col_criminal_out;

    @FXML
    private TableColumn<statistic_Prisoner, String> col_criminal_quantity;

    @FXML
    private TableView<statistic_Crime> filter_By_Crime;

    @FXML
    private TableView<statistic_Crime_type> filter_By_Crime_type;

    @FXML
    private TableView<statistic_Prisoner> filter_Criminal;

    @FXML
    private DatePicker txt_firstDate;

    @FXML
    private DatePicker txt_lastDate;

    @FXML
    void search(ActionEvent event) {
        String firstDate = txt_firstDate.getValue().getYear() + "-" + txt_firstDate.getValue().getMonthValue() + "-" + txt_firstDate.getValue().getDayOfMonth();
        String lastDate = txt_lastDate.getValue().getYear() + "-" + txt_lastDate.getValue().getMonthValue() + "-" + txt_lastDate.getValue().getDayOfMonth();
        Crime_profile_list = CRUD.Crime_profile_CRUD.getListByDay(firstDate, lastDate);
        prisoner_in = CRUD.Prisoner_CRUD.getListInByDay(firstDate, lastDate);
        prisoner_out = CRUD.Prisoner_CRUD.getListOutByDay(firstDate, lastDate);
        prisoner = CRUD.Prisoner_CRUD.findByStatus();
        setItemCrime_type();
        setItemCrime();
        setItemPrisoner();
        crime_initialize();
        crime_type_initialize();
        prisonser_initialize();
    }

    void crime_initialize() {
        col_crime.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Crime, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Crime, String> p) {
                return new SimpleStringProperty(p.getValue().getCrime().getCrime());
            }
        });
        col_crime_quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Crime, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Crime, String> p) {
                return new SimpleStringProperty(p.getValue().getCrime_profile().size() + "");
            }
        });
        col_crime_sus.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Crime, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Crime, String> p) {
                int count = 0;
                for (Crime_profile crime_profile : p.getValue().getCrime_profile()) {
                    count += crime_profile.getNumber();
                }
                return new SimpleStringProperty(count + "");
            }
        });
        filter_By_Crime.setItems(data_crime);
    }

    void crime_type_initialize() {
        data_crime_type = FXCollections.observableArrayList(data_crime_type_list);
        col_crime_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Crime_type, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Crime_type, String> p) {
                return new SimpleStringProperty(p.getValue().getCrime_type().getCrime());
            }

        });
        col_crime_type_quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Crime_type, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Crime_type, String> p) {
                return new SimpleStringProperty(p.getValue().getCrime_profile().size() + "");
            }
        });
        col_crime_type_sus.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Crime_type, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Crime_type, String> p) {
                int count = 0;
                for (Crime_profile crime_profile : p.getValue().getCrime_profile()) {
                    count += crime_profile.getNumber();
                }
                return new SimpleStringProperty(count + "");
            }
        });
        filter_By_Crime_type.setItems(data_crime_type);
    }

    void prisonser_initialize() {
        col_criminal_in.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Prisoner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Prisoner, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner_in().size() + "");
            }
        });
        col_criminal_out.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Prisoner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Prisoner, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner_out().size() + "");
            }
        });
        col_criminal_quantity.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<statistic_Prisoner, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<statistic_Prisoner, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().size() + "");
            }
        });
        filter_Criminal.setItems(data_prisoner);
    }
    static List<Crime_type> Crime_type_list;
    static List<Crime> Crime_list;
    static List<Crime_profile> Crime_profile_list;
    static List<CRUD.statistic_Crime_type> data_crime_type_list = new ArrayList<>();

    void setItemCrime() {
        boolean isCheck = false;
        data_crime = FXCollections.observableArrayList();
        for (Crime crime : Crime_list) {
            List<Has_crime> has_crime_list = CRUD.Has_crime_CRUD.getList_by_crime_id(crime.getId());
            List<Crime_profile> crime_profile_list_by_day = new ArrayList<>();
            for (Has_crime has_crime : has_crime_list) {
                for (Crime_profile crime_profile : Crime_profile_list) {
                    if (crime_profile.getId() == has_crime.getCrime_profile_id()) {
                        if (crime_profile_list_by_day.size() > 0) {
                            for (Crime_profile cr : crime_profile_list_by_day) {
                                if (crime_profile.getId() == cr.getId()) {
                                    isCheck = true;
                                    break;
                                }
                            }
                            if (!isCheck) {
                                crime_profile_list_by_day.add(crime_profile);
                            }
                            isCheck = false;
                        } else {
                            crime_profile_list_by_day.add(crime_profile);
                        }
                    }
                }
            }
            statistic_Crime statistic_Crime = new statistic_Crime(crime, crime_profile_list_by_day);
            data_crime.add(statistic_Crime);
        }
    }
    
    void setItemCrime_type() {
        data_crime_type_list = new ArrayList<>();
        for (Crime_type crime_type : Crime_type_list) {
            List<Crime_profile> Crime_profile_list_by_day = new ArrayList<>();
            for (Crime_profile crime_profile : Crime_profile_list) {
                if (crime_profile.getCrime_type() == crime_type.getId()) {
                    Crime_profile_list_by_day.add(crime_profile);
                }
            }
            statistic_Crime_type statistic_Crime_type = new statistic_Crime_type(crime_type, Crime_profile_list_by_day);
            data_crime_type_list.add(statistic_Crime_type);
        }
    }

    void setItemPrisoner() {
        data_prisoner = FXCollections.observableArrayList();
        statistic_Prisoner statistic_Prisoner = new statistic_Prisoner(prisoner_in, prisoner_out, prisoner);
        data_prisoner.add(statistic_Prisoner);
    }

    static List<Prisoner> prisoner;
    static List<Prisoner> prisoner_in;
    static List<Prisoner> prisoner_out;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Crime_type_list = CRUD.Crime_type_CRUD.getList();
        Crime_profile_list = CRUD.Crime_profile_CRUD.getList();
        Crime_list = CRUD.Crime_CRUD.getList();
        prisoner_in = CRUD.Prisoner_CRUD.getList();
        prisoner_out = CRUD.Prisoner_CRUD.getList();
        prisoner = CRUD.Prisoner_CRUD.getList();
        setItemCrime_type();
        setItemCrime();
        setItemPrisoner();
        crime_initialize();
        crime_type_initialize();
        prisonser_initialize();
    }

}
