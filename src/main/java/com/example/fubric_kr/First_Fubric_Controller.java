package com.example.fubric_kr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class First_Fubric_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TableView<?> tblord;

    @FXML
    private Button checkOrd;

    @FXML
    private Button createComp;

    @FXML
    private Button createFurn;

    @FXML
    private Button orders;

    @FXML
    private Button personalAccount;

    @FXML
    void initialize() {
        checkOrd.setOnAction(event -> {
            checkOrd.getScene().getWindow().hide();
            FXMLLoader loader3 = new FXMLLoader();
            loader3.setLocation(getClass().getResource("secondfub.fxml"));
            try {
                loader3.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root3 = loader3.getRoot();
            Stage stage3 = new Stage();
            stage3.setScene(new Scene(root3));
            stage3.show();
        });
        createComp.setOnAction(event -> {
            createComp.getScene().getWindow().hide();
            FXMLLoader loader4 = new FXMLLoader();
            loader4.setLocation(getClass().getResource("thirdfub.fxml"));
            try {
                loader4.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root4 = loader4.getRoot();
            Stage stage4 = new Stage();
            stage4.setScene(new Scene(root4));
            stage4.show();
        });
        createFurn.setOnAction(event -> {
            createFurn.getScene().getWindow().hide();
            FXMLLoader loader5 = new FXMLLoader();
            loader5.setLocation(getClass().getResource("fourthfub.fxml"));
            try {
                loader5.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root5 = loader5.getRoot();
            Stage stage5 = new Stage();
            stage5.setScene(new Scene(root5));
            stage5.show();
        });
        personalAccount.setOnAction(event -> {
            personalAccount.getScene().getWindow().hide();
            FXMLLoader loader6 = new FXMLLoader();
            loader6.setLocation(getClass().getResource("fifthfub.fxml"));
            try {
                loader6.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root6 = loader6.getRoot();
            Stage stage6 = new Stage();
            stage6.setScene(new Scene(root6));
            stage6.show();
        });
    }

}