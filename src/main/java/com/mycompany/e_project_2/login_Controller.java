package com.mycompany.e_project_2;

import CRUD.Admin;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class login_Controller implements Initializable {
    
    static List<Admin> dataList = new ArrayList<>();
    
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private URL location;
    
    @FXML
    private PasswordField txt_password;
    
    @FXML
    private TextField txt_username;
    
    @FXML
    void btn_Login(ActionEvent event) throws IOException {
        
        Map<String, String> error = new HashMap<>();
        if (txt_username.getText().isBlank()) {
            error.put("txt_username", "Chưa nhập tài khoản");
            txt_username.setPromptText(error.get("txt_username"));
        }        
        if (txt_password.getText().isBlank()) {
            error.put("txt_password", "Chưa nhập mật khẩu");
            txt_password.setPromptText(error.get("txt_password"));
        }        
        if (txt_username.getText().isBlank() == false && txt_password.getText().isBlank() == false) {
            boolean flag = CRUD.Admin_CRUD.getListByUserName(txt_username.getText().toString(), txt_password.getText().toString());
            if (!flag) {
                txt_username.setText(null);
                txt_password.setText(null);
                error.put("txt_username", "Nhập sai");
                txt_username.setPromptText(error.get("txt_username"));
                error.put("txt_password", "Nhập sai");
                txt_password.setPromptText(error.get("txt_password"));
            }
        }
        if (error.isEmpty()) {
            dataList = CRUD.Admin_CRUD.findByUserName(txt_username.getText());
            App.setRoot("homepage");
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
