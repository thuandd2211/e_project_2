package com.mycompany.e_project_2;

import CRUD.Identify;
import CRUD.Prisoner;
import CRUD.Prisoner_Table;
import CRUD.room;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

public class criminal_list_Controller implements Initializable {

    static ObservableList<Prisoner_Table> data;
    static ObservableList<room> data_room;
    static ObservableList<Identify> identify_list;
    static ObservableList<Prisoner> prisoner_List;
    static Prisoner_Table tbl_prisoner = null;
    static TitledPane prisoner_form_static;
    static int id;
    static String txt_fullname_static;
    static String txt_gender_static;
    static String txt_male_static;
    static String txt_female_static;
    static String txt_height_static;
    static String txt_weight_static;
    static String txt_dob_static;
    static String txt_place_static;
    static String txt_address_static;
    static String txt_rollno_static;
    static String txt_identify_static;
    static String txt_room_static;
    static String txt_release_date_static;
    static String txt_execution_date_static;
    static boolean isFlag = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Prisoner_Table, String> col_dob;

    @FXML
    private TableColumn<Prisoner_Table, String> col_fullname;

    @FXML
    private TableColumn<Prisoner_Table, String> col_gender;

    @FXML
    private TableColumn<Prisoner_Table, String> col_height;

    @FXML
    private TableColumn<Prisoner_Table, String> col_identify;

    @FXML
    private TableColumn<Prisoner_Table, String> col_place;

    @FXML
    private TableColumn<Prisoner_Table, String> col_rollno;

    @FXML
    private TableColumn<Prisoner_Table, String> col_room;

    @FXML
    private TableColumn<Prisoner_Table, String> col_stt;

    @FXML
    private TableColumn<Prisoner_Table, String> col_weight;

    @FXML
    private TableColumn<Prisoner_Table, String> col_execution_date;

    @FXML
    private TableColumn<Prisoner_Table, String> col_release_date;

    @FXML
    private TableColumn<Prisoner_Table, String> col_status;

    @FXML
    private TitledPane prisoner_form;

    @FXML
    private TableView<Prisoner_Table> table_criminal;

    @FXML
    private TextField txt_address;

    @FXML
    private DatePicker txt_dob;

    @FXML
    private DatePicker txt_execution_date;

    @FXML
    private RadioButton txt_female;

    @FXML
    private TextField txt_fullname;

    @FXML
    private TextField txt_height;

    @FXML
    private TextField txt_identify;

    @FXML
    private RadioButton txt_male;

    private String txt_gender = null;

    @FXML
    private TextField txt_place;

    @FXML
    private DatePicker txt_release_date;

    @FXML
    private TextField txt_rollno;

    @FXML
    private ComboBox<String> txt_room;

    @FXML
    private TableColumn<Prisoner_Table, String> txt_status;

    @FXML
    private TextField txt_weight;

    @FXML
    void getItem(MouseEvent event) {
        tbl_prisoner = table_criminal.getSelectionModel().getSelectedItem();
        if (tbl_prisoner != null) {
            homePage.suatoipham_btn_static.setVisible(true);
            homePage.xoatoipham_btn_static.setVisible(true);
            check_update(tbl_prisoner);
            setValue();
        }

    }

    @FXML
    String getGender(ActionEvent event) {
        return getGender();
    }

    String getGender() {
        if (txt_male.isSelected()) {
            txt_gender = txt_male.getText();
        } else if (txt_female.isSelected()) {
            txt_gender = txt_female.getText();
        } else {
            txt_gender = null;
        }
        return txt_gender;
    }

    void setGender(String gender) {
        if (txt_male.getText().equalsIgnoreCase(gender)) {
            txt_male.setSelected(true);
        } else if (txt_female.getText().equalsIgnoreCase(gender)) {
            txt_female.setSelected(true);
        }
    }

    boolean validate() {
        Map<String, String> error = new HashMap<>();
        if (txt_fullname.getText().isBlank()) {
            error.put("txt_fullname", "Chưa nhập tên");
            txt_fullname.setPromptText(error.get("txt_fullname"));
        }
        if (txt_height.getText().isBlank()) {
            error.put("txt_height", "Chưa nhập chiều cao");
            txt_height.setPromptText(error.get("txt_height"));
        }
        if (txt_weight.getText().isBlank()) {
            error.put("txt_weight", "Chưa nhập cân nặng");
            txt_weight.setPromptText(error.get("txt_weight"));
        }
        if (txt_dob.getValue() == null) {
            error.put("txt_dob", "Chưa nhập ngày sinh");
            txt_dob.setPromptText(error.get("txt_dob"));
        }
        if (txt_place.getText().isBlank()) {
            error.put("txt_place", "Chưa nhập quê quán");
            txt_place.setPromptText(error.get("txt_place"));
        }
        if (txt_address.getText().isBlank()) {
            error.put("txt_address", "Chưa nhập nơi thường trú");
            txt_address.setPromptText(error.get("txt_address"));
        }
        if (txt_rollno.getText().isBlank()) {
            error.put("txt_rollno", "Chưa nhập mã phạm nhân");
            txt_rollno.setPromptText(error.get("txt_rollno"));
        }
        if (txt_identify.getText().isBlank()) {
            error.put("txt_identify", "Chưa nhập CCCD");
            txt_identify.setPromptText(error.get("txt_identify"));
        }
        if (txt_room.getValue() == null) {
            error.put("txt_room", "Chưa nhập phòng giam");
            txt_room.setPromptText(error.get("txt_room"));
        }
        if (txt_execution_date.getValue() == null) {
            error.put("txt_execution_date", "Chưa nhập ngày vào tù");
            txt_execution_date.setPromptText(error.get("txt_execution_date"));
        }
        if (txt_release_date.getValue() == null) {
            error.put("txt_release_date", "Chưa nhập ngày ra tù");
            txt_release_date.setPromptText(error.get("txt_release_date"));
        }
        if (error.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void resetCriminal(ActionEvent event) {
        txt_fullname.setText(null);
        txt_gender = null;
        txt_male.setSelected(false);
        txt_female.setSelected(false);
        txt_height.setText(null);
        txt_weight.setText(null);
        txt_dob.setValue(null);
        txt_place.setText(null);
        txt_address.setText(null);
        txt_rollno.setText(null);
        txt_identify.setText(null);
        txt_room.setValue(null);
        txt_release_date.setValue(null);
        txt_execution_date.setValue(null);
    }

    void setValue() {
        txt_fullname.setText(txt_fullname_static);
        txt_gender = txt_gender_static;
        setGender(txt_gender);
        txt_height.setText(txt_height_static);
        txt_weight.setText(txt_weight_static);
        txt_dob.setValue(LocalDate.parse(txt_dob_static));
        txt_place.setText(txt_place_static);
        txt_address.setText(txt_address_static);
        txt_rollno.setText(txt_rollno_static);
        txt_identify.setText(txt_identify_static);
        txt_room.setValue(txt_room_static);
        txt_release_date.setValue(LocalDate.parse(txt_release_date_static));
        txt_execution_date.setValue(LocalDate.parse(txt_execution_date_static));
    }

    @FXML
    void saveCriminal(ActionEvent event) throws IOException {
        if (tbl_prisoner != null && validate()) {
            Identify identify = new Identify(
                    tbl_prisoner.getIdentify().getId(),
                    txt_identify.getText(),
                    txt_fullname.getText(),
                    txt_dob.getValue().getYear() + "-" + txt_dob.getValue().getMonthValue() + "-" + txt_dob.getValue().getDayOfMonth(),
                    txt_place.getText(),
                    txt_address.getText());
            CRUD.Identify_CRUD.update(identify);
            Prisoner p = new Prisoner(
                    tbl_prisoner.getPrisoner().getId(),
                    txt_rollno.getText(),
                    txt_fullname.getText(),
                    txt_gender,
                    Integer.parseInt(txt_height.getText()),
                    Integer.parseInt(txt_weight.getText()),
                    identify.getId(),
                    txt_execution_date.getValue().getYear() + "-" + txt_execution_date.getValue().getMonthValue() + "-" + txt_execution_date.getValue().getDayOfMonth(),
                    txt_release_date.getValue().getYear() + "-" + txt_release_date.getValue().getMonthValue() + "-" + txt_release_date.getValue().getDayOfMonth(),
                    CRUD.room_CRUD.findByRoomName(txt_room.getValue()).get(0).getId(),
                    "",
                    "Đang thụ án");
            CRUD.Prisoner_CRUD.update(p);
            resetCriminal(event);
            tbl_prisoner = null;
            initialize();
        } else {
            if (validate()) {
                Identify identify = new Identify(
                        0,
                        txt_identify.getText(),
                        txt_fullname.getText(),
                        txt_dob.getValue().getYear() + "-" + txt_dob.getValue().getMonthValue() + "-" + txt_dob.getValue().getDayOfMonth(),
                        txt_place.getText(),
                        txt_address.getText());
                CRUD.Identify_CRUD.insert(identify);
                Prisoner p = new Prisoner(
                        0,
                        txt_rollno.getText(),
                        txt_fullname.getText(),
                        txt_gender,
                        Integer.parseInt(txt_height.getText()),
                        Integer.parseInt(txt_weight.getText()),
                        CRUD.Identify_CRUD.findByIdentifyNumber(identify.getIdentify_number()).get(0).getId(),
                        txt_execution_date.getValue().getYear() + "-" + txt_execution_date.getValue().getMonthValue() + "-" + txt_execution_date.getValue().getDayOfMonth(),
                        txt_release_date.getValue().getYear() + "-" + txt_release_date.getValue().getMonthValue() + "-" + txt_release_date.getValue().getDayOfMonth(),
                        CRUD.room_CRUD.findByRoomName(txt_room.getValue()).get(0).getId(),
                        "",
                        "Đang thụ án");
                CRUD.Prisoner_CRUD.insert(p);
                resetCriminal(event);
                initialize();

            }
        }
    }

    void check_update(CRUD.Prisoner_Table tbl) {
        id = tbl.getPrisoner().getId();
        Prisoner prisoner = tbl.getPrisoner();
        Identify identify = tbl.getIdentify();
        room room = tbl.getRoom();
        txt_fullname_static = prisoner.getFullname();
        txt_gender_static = prisoner.getGender();
        txt_height_static = prisoner.getHeight() + "";
        txt_weight_static = prisoner.getWeight() + "";
        txt_dob_static = identify.getDob();
        txt_place_static = identify.getPlace();
        txt_address_static = identify.getAddress();
        txt_identify_static = identify.getIdentify_number();
        txt_rollno_static = prisoner.getRoll_no();
        txt_room_static = room.getRoom_name();
        txt_execution_date_static = prisoner.getExecution_date();
        txt_release_date_static = prisoner.getRelease_date();
    }

    void getTable(ObservableList<Prisoner> prisoner_List) {
        for (Prisoner prisoner : prisoner_List) {
            for (Identify identify : identify_list) {
                if (prisoner.getIdentify_id() == identify.getId()) {
                    tbl_prisoner.setIdentify(identify);
                    break;
                }
            }
            for (room room : data_room) {
                if (prisoner.getRoom_id() == room.getId()) {
                    tbl_prisoner.setRoom(room);
                    break;
                }
            }
            tbl_prisoner.setPrisoner(prisoner);
            data.add(tbl_prisoner);
            tbl_prisoner = new Prisoner_Table();
        }
    }

    @FXML
    void initialize() {

        tbl_prisoner = new Prisoner_Table();
        data = FXCollections.observableArrayList();

        prisoner_List = FXCollections.observableArrayList(CRUD.Prisoner_CRUD.getList());
        identify_list = FXCollections.observableArrayList(CRUD.Identify_CRUD.getList());

        data_room = FXCollections.observableArrayList(CRUD.room_CRUD.getList());
        if (homePage.txt_search_static != null) {
            prisoner_List = FXCollections.observableArrayList(CRUD.Prisoner_CRUD.findByName(homePage.txt_search_static.toLowerCase()));
            getTable(prisoner_List);
        } else {
            getTable(prisoner_List);
        }


        tbl_prisoner = null;
        for (room room_data : data_room) {
            txt_room.getItems().add(room_data.getRoom_name());
        }

        col_stt.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new ReadOnlyObjectWrapper(table_criminal.getItems().indexOf(p.getValue()) + 1);
            }
        });
        col_rollno.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getRoll_no());
            }
        });
        col_room.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getRoom().getRoom_name());
            }
        });
        col_identify.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getIdentify().getIdentify_number());
            }
        });
        col_fullname.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getFullname());
            }
        });
        col_gender.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getGender());
            }
        });
        col_dob.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getIdentify().getDob());
            }
        });
        col_place.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getIdentify().getPlace());
            }
        });
        col_height.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getHeight() + "");
            }
        });
        col_weight.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getWeight() + "");
            }
        });
        col_execution_date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getExecution_date());
            }
        });
        col_release_date.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getRelease_date());
            }
        });
        col_status.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Prisoner_Table, String>, ObservableValue<String>>() {
            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Prisoner_Table, String> p) {
                return new SimpleStringProperty(p.getValue().getPrisoner().getStatus());
            }
        });
        table_criminal.setItems(data);
        homePage.txt_search_static = null;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isFlag = true;
        homePage.suavuviec_btn_static.setVisible(false);
        homePage.xoavuviec_btn_static.setVisible(false);
        homePage.suatoipham_hoso_btn_static.setVisible(false);
        homePage.xoatoipham_hoso_btn_static.setVisible(false);
        prisoner_form.setVisible(false);
        prisoner_form_static = prisoner_form;
        prisoner_form_static.setVisible(false);

        homePage.themtoipham_btn_static.setVisible(true);
        initialize();
    }

}
