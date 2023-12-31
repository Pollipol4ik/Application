package com.example.fubric_kr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Third_Shop_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Redact;

    @FXML
    private TextField newPassword;

    @FXML
    private TextField oldPassword;

    @FXML
    private Button ordFurn;

    @FXML
    private Button orders;

    @FXML
    private Button personalAccount;
    public static String logUser = "";


    @FXML
    void initialize() {
        orders.setOnAction(event -> {
            orders.getScene().getWindow().hide();
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
        ordFurn.setOnAction(event -> {
            ordFurn.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("secondpageshop.fxml"));
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
        personalAccount.setOnAction(event -> {
            personalAccount.getScene().getWindow().hide();
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("thirdpageshop.fxml"));
            try {
                loader2.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root2 = loader2.getRoot();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.show();
        });
        DataBaseHandler db = new DataBaseHandler();
        Redact.setOnAction(event -> {
            if (newPassword.toString() != oldPassword.toString()) {
                db.changePassword(String.valueOf(newPassword.getText().hashCode()));
            } else
                System.out.println("Error!");
            Redact.getScene().getWindow().hide();
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("thirdpageshop.fxml"));
            try {
                loader2.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root2 = loader2.getRoot();
            Stage stage2 = new Stage();
            stage2.setScene(new Scene(root2));
            stage2.show();
        });


    }

}