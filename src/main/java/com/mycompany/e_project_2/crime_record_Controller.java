package com.mycompany.e_project_2;

import CRUD.Crime_profile;
import CRUD.Crime_type;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

public class crime_record_Controller implements Initializable {

    static int id;
    private static ObservableList<CRUD.Crime_type> data;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> txt_crime_type;

    @FXML
    private DatePicker txt_date;

    @FXML
    private TextArea txt_note;

    @FXML
    void resetItem(ActionEvent event) {
        txt_crime_type.setValue(null);
        txt_date.setValue(null);
        txt_note.setText(null);
    }

    public boolean validate() {
        String error = null;
        if (txt_crime_type.getValue() == null) {
            error = "Chưa nhập loại hình";
        }
        if (txt_date.getValue() == null) {
            error = "Chưa nhập ngày";
        }
        return error == null;
    }

    @FXML
    void saveItem(ActionEvent event) throws IOException {
        if (crime_list_Controller.crime != null && validate()) {
            Crime_profile crime = new Crime_profile(
                    id,
                    CRUD.Crime_type_CRUD.FindByName(txt_crime_type.getValue()).get(0).getId(),
                    0,
                    txt_date.getValue().getYear() + "-" + txt_date.getValue().getMonthValue() + "-" + txt_date.getValue().getDayOfMonth(),
                    !txt_note.getText().isEmpty() ? txt_note.getText() : "");

            CRUD.Crime_profile_CRUD.update(crime);
            resetItem(event);
            crime_list_Controller.crime = null;
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
    void initialize() {
        if (crime_list_Controller.crime != null) {
            id = crime_list_Controller.crime.getId();
            ObservableList<Crime_profile> dataList = CRUD.Crime_profile_CRUD.findByCrime_Proflie_ID(id);
            txt_crime_type.setValue(CRUD.Crime_type_CRUD.FindByID(dataList.get(0).getCrime_type()).get(0).getCrime());
            String[] date = dataList.get(0).getDate().split("-");
            txt_date.setValue(LocalDate.of(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2])));
            txt_note.setText(dataList.get(0).getNote());
        }
        data = FXCollections.observableArrayList(CRUD.Crime_type_CRUD.getList());
        for (Crime_type crime_type : data) {
            txt_crime_type.getItems().add(crime_type.getCrime());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initialize();
    }

}
