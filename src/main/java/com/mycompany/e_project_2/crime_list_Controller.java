package com.mycompany.e_project_2;

import CRUD.Crime;
import CRUD.Crime_profile;
import CRUD.Crime_profile_CRUD;
import CRUD.Crime_type;
import CRUD.Has_crime;
import CRUD.Prisoner;
import static com.mycompany.e_project_2.crime_record_Controller.id;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class crime_list_Controller implements Initializable {

    static Crime_profile crime = null;
    static Prisoner prisoner = null;
    static int id;
    private static ObservableList<CRUD.Crime_profile> data;
    private static ObservableList<CRUD.Crime_type> data_crime_type;
    private static ObservableList<CRUD.Crime> data_crime;
    private static ObservableList<CRUD.Prisoner> data_prisoner;
    static ComboBox txt_crime_type_static;
    static DatePicker txt_date_static;
    static TextArea txt_note_static;
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
    private BorderPane mainPane;

    @FXML
    private Pane crime_form;

    static TitledPane crime_form_static;

    static TitledPane criminal_form_static;

    @FXML
    private ComboBox<String> txt_crime_type;

    @FXML
    private DatePicker txt_date;

    @FXML
    private TextArea txt_note;

    @FXML
    private TitledPane hoSoVuAn;

    @FXML
    private TitledPane themPhamNhan;

    @FXML
    private ComboBox<String> txt_criminal;

    @FXML
    private ComboBox<String> txt_crime;

    @FXML
    void getItem(MouseEvent event) {
        if (table_crime.getSelectionModel().getSelectedItem() != null) {
            homePage.suavuviec_btn_static.setVisible(true);
            homePage.xoavuviec_btn_static.setVisible(true);
            homePage.themtoipham_btn_static.setVisible(true);
            crime = table_crime.getSelectionModel().getSelectedItem();
        }
    }

    @FXML
    void resetItem(ActionEvent event) {
        txt_crime_type.setValue(null);
        txt_date.setValue(null);
        txt_note.setText(null);
    }

    public boolean validate() {
        Map<String, String> error = new HashMap<>();
//        error = null;
        if (txt_crime_type.getValue() == null) {
            error.put("txt_crime", "Chưa nhập loại hình");
            txt_crime_type.setPromptText(error.get("txt_crime"));
        }
        if (txt_date.getValue() == null) {
            error.put("txt_date", "Chưa nhập ngày");
            txt_date.setPromptText(error.get("txt_date"));
        }
        if (error.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validate_criminal() {
        Map<String, String> error = new HashMap<>();
        if (txt_criminal.getValue() == null) {
            error.put("txt_criminal", "Chưa nhập phạm nhân");
            txt_criminal.setPromptText(error.get("txt_criminal"));

        }
        if (txt_crime.getValue() == null) {
            error.put("txt_crime", "Chưa nhập tội danh");
            txt_crime.setPromptText(error.get("txt_crime"));
        }
        if (error.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void saveItem(ActionEvent event) throws IOException {
        if (crime != null && validate()) {
            Crime_profile crime = new Crime_profile(
                    id,
                    CRUD.Crime_type_CRUD.FindByName(txt_crime_type.getValue()).get(0).getId(),
                    0,
                    txt_date.getValue().getYear() + "-" + txt_date.getValue().getMonthValue() + "-" + txt_date.getValue().getDayOfMonth(),
                    txt_note.getText().isEmpty() ? "" : txt_note.getText());

            CRUD.Crime_profile_CRUD.update(crime);
            resetItem(event);
            crime = null;
            App.setRoot("homePage");
        } else {
            if (validate()) {
                Crime_profile crime = new Crime_profile(
                        0,
                        CRUD.Crime_type_CRUD.FindByName(txt_crime_type.getValue()).get(0).getId(),
                        0,
                        txt_date.getValue().getYear() + "-" + txt_date.getValue().getMonthValue() + "-" + txt_date.getValue().getDayOfMonth(),
                        !txt_note.getText().isEmpty() ? txt_note.getText() : "");
                CRUD.Crime_profile_CRUD.insert(crime);
                App.setRoot("homePage");
                resetItem(event);

            }

        }

    }

    @FXML
    void saveCriminal(ActionEvent event) throws IOException {
        boolean isCheck = false;
        boolean isFlag = false;
        List<Has_crime> h = new ArrayList<>();
        h = CRUD.Has_crime_CRUD.getList_by_crime_profile_id(crime.getId());
        if (crime != null && validate_criminal()) {
            CRUD.Has_crime has_crime = new Has_crime(
                    0,
                    CRUD.Crime_CRUD.findByCrime(txt_crime.getValue()).get(0).getId(),
                    CRUD.Prisoner_CRUD.findByRollno(txt_criminal.getValue()).get(0).getId(),
                    crime.getId());
            for (Has_crime h1 : h) {
                if (h1.getPrisoner_id() == has_crime.getPrisoner_id()) {
                    isFlag = true;
                    if (h1.getCrime_id() == has_crime.getCrime_id()) {
                        isCheck = true;
                        break;
                    }   
                }
            }
            if (!isFlag) {
                CRUD.Has_crime_CRUD.insert(has_crime);
                CRUD.Crime_profile_CRUD.update_numberOfCriminal(crime);
            } else {
                if (!isCheck) {
                    CRUD.Has_crime_CRUD.insert(has_crime);
                }
            }
            App.setRoot("homePage");
            crime = null;
            has_crime = null;
            resetCriminal(event);
        }

    }

    @FXML
    void resetCriminal(ActionEvent event) {
        txt_crime.setValue(null);
        txt_criminal.setValue(null);
    }

    @FXML
    void initialize() {
        if (homePage.selectedTreeItem != null) {
            homePage.suavuviec_btn_static.setVisible(false);
            homePage.xoavuviec_btn_static.setVisible(false);
            homePage.themtoipham_btn_static.setVisible(false);
            data = Crime_profile_CRUD.findByCrime_type(homePage.selectedTreeItem);

        } else {
            data = CRUD.Crime_profile_CRUD.getList();

        }

        data_crime_type = FXCollections.observableArrayList(CRUD.Crime_type_CRUD.getList());
        for (Crime_type crime_type : data_crime_type) {
            txt_crime_type.getItems().add(crime_type.getCrime());
        }

        data_crime = FXCollections.observableArrayList(CRUD.Crime_CRUD.getList());
        for (Crime crime : data_crime) {
            txt_crime.getItems().add(crime.getCrime());
        }

        data_prisoner = FXCollections.observableArrayList(CRUD.Prisoner_CRUD.getList());
        for (Prisoner prisoner : data_prisoner) {
            txt_criminal.getItems().add(prisoner.getRoll_no());
        }

        col_stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new ReadOnlyObjectWrapper(table_crime.getItems().indexOf(p.getValue()) + 1);
            }
        });
        col_crime_profile_id.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getId() + "");
            }
        });
        col_crime_type.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(CRUD.Crime_type_CRUD.FindByID(p.getValue().getCrime_type()).get(0).getCrime());
            }
        });
        col_criminal.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getNumber() + "");
            }
        });
        col_date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getDate() + "");
            }
        });
        col_note.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Crime_profile, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Crime_profile, String> p) {
                return new SimpleStringProperty(p.getValue().getNote());
            }
        });
        table_crime.setItems(data);
    }

    @FXML
    static void check_update(Crime_profile crime, ComboBox txt_crime_type, DatePicker txt_date, TextArea txt_note) {
        if (crime != null) {
            id = crime.getId();
            ObservableList<Crime_profile> dataList = CRUD.Crime_profile_CRUD.findByCrime_Proflie_ID(id);
            txt_crime_type.setValue(CRUD.Crime_type_CRUD.FindByID(dataList.get(0).getCrime_type()).get(0).getCrime());
            String[] date = dataList.get(0).getDate().split("-");
            txt_date.setValue(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
            txt_note.setText(dataList.get(0).getNote());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hoSoVuAn.setVisible(false);
        themPhamNhan.setVisible(false);
        crime_form_static = hoSoVuAn;
        criminal_form_static = themPhamNhan;
        crime_form_static.setVisible(false);
        criminal_form_static.setVisible(false);

        initialize();

        txt_crime_type_static = txt_crime_type;
        txt_date_static = txt_date;
        txt_note_static = txt_note;

    }

}
