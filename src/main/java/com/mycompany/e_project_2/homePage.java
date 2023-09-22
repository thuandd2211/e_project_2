package com.mycompany.e_project_2;

import CRUD.Crime_profile;
import CRUD.Crime_profile_CRUD;
import CRUD.Crime_type;
import CRUD.Crime_type_CRUD;
import CRUD.Has_crime;
import CRUD.Prisoner;
import static com.mycompany.e_project_2.crime_list_Controller.crime;
import com.mycompany.e_project_2.crime_list_Controller;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.util.Callback;

public class homePage implements Initializable {

    static String selectedTreeItem = null;
    static TreeItem<String> rootItem;
    static TreeItem<String> branchItem;
    static Crime_profile crime;
    static Pane crime_form_static = new Pane();
    static Button suavuviec_btn_static;
    static Button xoavuviec_btn_static;
    static Button suatoipham_btn_static;
    static Button xoatoipham_btn_static;
    static Button themtoipham_btn_static;
    static Button suatoipham_hoso_btn_static;
    static Button xoatoipham_hoso_btn_static;
    ObservableList<Prisoner> prisonerList;
    static String txt_search_static;

    @FXML
    private TextField txt_search;

    @FXML
    private BorderPane mainPane;

    @FXML
    private BorderPane sidePane;

    @FXML
    private Button suatoipham_hoso_btn;

    @FXML
    private Button xoatoipham_hoso_btn;

    @FXML
    private Button suatoipham_btn;

    @FXML
    private Button suavuviec_btn;

    @FXML
    private Button themtoipham_btn;

    @FXML
    private Button themvuviec_btn;

    @FXML
    private TreeView<String> treeView;

    @FXML
    private Button xoatoipham_btn;

    @FXML
    private Button xoavuviec_btn;

    @FXML
    private Label user;

    @FXML
    void crimeList(ActionEvent event) throws IOException {
        App.setRoot("homePage");
    }

    @FXML
    void crime_record(ActionEvent event) {
        Pane pane = getPage("crime_list");
        mainPane.setCenter(pane);
        crime_list_Controller.criminal_form_static.setVisible(false);
        crime_list_Controller.crime_form_static.setVisible(true);
    }

    @FXML
    void prisonList(ActionEvent event) {
        Pane pane = getPage("prisoner_list");
        mainPane.setCenter(pane);
    }

    @FXML
    void prison_info(ActionEvent event) {
        Pane pane = getPage("prison_info");
        mainPane.setCenter(pane);
    }

    @FXML
    void statistic(ActionEvent event) {
        Pane pane = getPage("statistic");
        mainPane.setCenter(pane);
    }

    @FXML
    void add_criminal(ActionEvent event) {
        if (crime_list_Controller.crime != null) {
            crime_list_Controller.crime_form_static.setVisible(false);
            crime_list_Controller.criminal_form_static.setVisible(true);
        }
        if (criminal_list_Controller.isFlag == true) {
            criminal_list_Controller.prisoner_form_static.setVisible(true);
        }

    }

    @FXML
    void log_out(ActionEvent event) throws IOException {
        App.setRoot("login");
    }

    @FXML
    void delete_criminal(ActionEvent event) {
        if (criminal_list_Controller.tbl_prisoner != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xóa tội phạm");
            alert.setContentText("Bạn muốn xóa tội phạm?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == null) {

            } else if (option.get() == ButtonType.OK) {
                List<Has_crime> dataList = new ArrayList<>();
                List<Crime_profile> crime_profile_list = new ArrayList<>();
                boolean isCheck = false;
                dataList = CRUD.Has_crime_CRUD.getList_by_prisoner_id(criminal_list_Controller.tbl_prisoner.getPrisoner().getId());
                for (Has_crime has_crime : dataList) {
                    Crime_profile crime_profile = CRUD.Crime_profile_CRUD.findByCrime_Proflie_ID(has_crime.getCrime_profile_id()).get(0);
                    if (crime_profile_list.size() > 0) {
                        for (Crime_profile cr : crime_profile_list) {
                            if (crime_profile.getId() == cr.getId()) {
                                isCheck = true;
                                break;
                            }
                        }
                        if (!isCheck) {
                            crime_profile_list.add(crime_profile);
                        }
                        isCheck = false;
                    } else {
                        crime_profile_list.add(crime_profile);
                    }
                    CRUD.Has_crime_CRUD.deleteByID(has_crime.getId());
                }
                for (Crime_profile crime_profile : crime_profile_list) {
                    CRUD.Crime_profile_CRUD.update_numberOfCriminal_decrease(crime_profile.getId(), crime_profile.getNumber());
                }
                CRUD.Prisoner_CRUD.deleteByID(criminal_list_Controller.tbl_prisoner.getPrisoner().getId());
                CRUD.Identify_CRUD.deleteByID(criminal_list_Controller.tbl_prisoner.getIdentify().getId());

                criminal_list_Controller.tbl_prisoner = null;
            } else if (option.get() == ButtonType.CANCEL) {

            } else {

            }
        }
    }

    @FXML
    void search(MouseEvent event) {
        txt_search_static = txt_search.getText();
        Pane pane = getPage("prisoner_list");
        mainPane.setCenter(pane);
//        prisonerList = FXCollections.observableArrayList(CRUD.Prisoner_CRUD.getList());
//        FilteredList<Prisoner> filteredData = new FilteredList<>(prisonerList, b -> true);
//        txt_search.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((prisoner) -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
//                if (prisoner.getFullname().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true;
//                }
//                return false;
//                
//            });
//        });

    }

    @FXML
    void update_criminal(ActionEvent event) {
        criminal_list_Controller.prisoner_form_static.setVisible(true);
    }

    @FXML
    void selectItem(MouseEvent event) {
        if (treeView.getSelectionModel().getSelectedItem() != null) {
            selectedTreeItem = treeView.getSelectionModel().getSelectedItem().getValue();
            Pane pane;

            if (mainPane.getCenter() == getPage("prisoner_list")) {
                pane = getPage("statistic");
                mainPane.setCenter(pane);
            } else {
                pane = getPage("crime_list");
                mainPane.setCenter(pane);
            }
        }

    }

    @FXML
    void update_suspect(ActionEvent event) {
        crime_list_Controller.crime_form_static.setVisible(false);
        crime_list_Controller.suspect_pane_static.setVisible(true);
        crime_list_Controller.criminal_form_static.setVisible(true);
        crime_list_Controller.txt_rollNo_static.setValue(CRUD.Prisoner_CRUD.findByID(crime_list_Controller.suspect.getPrisoner_id()).get(0).getRoll_no());
        crime_list_Controller.txt_crime_static.setValue(CRUD.Crime_CRUD.findByID(crime_list_Controller.suspect.getCrime_id()).get(0).getCrime());
    }

    @FXML
    void delete_suspect(ActionEvent event) throws IOException {
        if (crime_list_Controller.crime != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xóa tội phạm");
            alert.setContentText("Bạn muốn xóa tội phạm?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == null) {

            } else if (option.get() == ButtonType.OK) {
                List<Has_crime> dataList = new ArrayList<>();
                dataList = CRUD.Has_crime_CRUD.getList_by_crime_profile_id_by_prisoner_id(crime_list_Controller.crime.getId(), crime_list_Controller.suspect.getPrisoner_id());
                System.out.println(dataList.size());
                if (dataList.size() < 2) {
                    CRUD.Crime_profile_CRUD.update_numberOfCriminal_decrease(crime_list_Controller.crime.getId(), crime_list_Controller.crime.getNumber());
                }
                CRUD.Has_crime_CRUD.deleteByID(crime_list_Controller.suspect.getId());
                App.setRoot("homePage");
            } else if (option.get() == ButtonType.CANCEL) {

            } else {

            }
        }
    }

    @FXML
    void updateItem(ActionEvent event) {
        homePage.crime = crime_list_Controller.crime;
        crime_list_Controller.criminal_form_static.setVisible(false);
        crime_list_Controller.crime_form_static.setVisible(true);
        crime_list_Controller.check_update(crime, crime_list_Controller.txt_crime_type_static, crime_list_Controller.txt_date_static, crime_list_Controller.txt_note_static);

    }

    @FXML
    void deleteItem(ActionEvent event) {
        if (crime_list_Controller.crime != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Xóa vụ việc");
            alert.setContentText("Bạn muốn xóa vụ việc?");
            Optional<ButtonType> option = alert.showAndWait();
            if (option.get() == null) {

            } else if (option.get() == ButtonType.OK) {
                List<Has_crime> dataList = new ArrayList<>();
                dataList = CRUD.Has_crime_CRUD.getList_by_crime_profile_id(crime_list_Controller.crime.getId());
                for (Has_crime has_crime : dataList) {
                    CRUD.Has_crime_CRUD.delete_by_crime_profile(has_crime.getCrime_profile_id());
                }

                CRUD.Crime_profile_CRUD.deleteByCrime_Profile_ID(crime_list_Controller.crime.getId());
                crime_list_Controller.crime = null;
            } else if (option.get() == ButtonType.CANCEL) {

            } else {

            }
        }

    }

    Pane view;

    private Pane getPage(String fileName) {

        try {
            URL fileURL = App.class.getResource(fileName + ".fxml");
            if (fileURL == null) {
                throw new java.io.FileNotFoundException("File not found");
            }
            view = FXMLLoader.load(fileURL);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(homePage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return view;
    }

    @FXML
    void initialize() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        user.setText(login_Controller.dataList.get(0).getFullname());
        homePage.selectedTreeItem = null;
        Pane pane = getPage("crime_list");
        mainPane.setCenter(pane);
        suavuviec_btn_static = suavuviec_btn;
        xoavuviec_btn_static = xoavuviec_btn;
        suatoipham_btn_static = suatoipham_btn;
        xoatoipham_btn_static = xoatoipham_btn;
        themtoipham_btn_static = themtoipham_btn;
        suatoipham_hoso_btn_static = suatoipham_hoso_btn;
        xoatoipham_hoso_btn_static = xoatoipham_hoso_btn;
        rootItem = new TreeItem<>("Phân loại hồ sơ");
        List<CRUD.Crime_type> crime_type_list = new ArrayList<>();
        crime_type_list = Crime_type_CRUD.getList();
        for (Crime_type crime_type : crime_type_list) {
            branchItem = new TreeItem<>(crime_type.getCrime());
            rootItem.getChildren().add(branchItem);
        }
        treeView.setRoot(rootItem);

    }
}
