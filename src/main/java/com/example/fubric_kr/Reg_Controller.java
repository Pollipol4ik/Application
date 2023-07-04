package com.example.fubric_kr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Reg_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button RegistrationOn;

    @FXML
    private TextField lastName;

    @FXML
    private TextField loginField;

    @FXML
    private TextField name;

    @FXML
    private TextField nameOrg;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField phoneNumber;

    @FXML
    void initialize() {

        RegistrationOn.setOnAction(event -> {
            signUpNewUser();

            RegistrationOn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("firstpageshop.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    private void signUpNewUser() {
        DataBaseHandler db = new DataBaseHandler();
        String second_name = lastName.getText();
        String first_name = name.getText();
        String number_phone = phoneNumber.getText();
        String name_org = nameOrg.getText();
        String login = loginField.getText();
        String user_password = passwordField.getText();
        Users users = new Users(second_name, first_name, number_phone, name_org, login, user_password);
        db.signUpUsers(users);
    }

}