package com.example.fubric_kr;

import com.example.fubric_kr.animations.Shake;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Fabric_Controller {

    @FXML
    private ResourceBundle resources;
    private int size = 15;

    @FXML
    private URL location;

    @FXML
    private Button authSignInButton;

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button revers;

    @FXML
    void initialize() {
        revers.setOnAction(event -> {
            revers.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("enter.fxml"));
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
        authSignInButton.setOnAction(event -> {
            loginUser(loginField.getText(),passwordField.getText());

            String logintext = loginField.getText().trim();
            String loginpassword = passwordField.getText().trim();
            if (!logintext.equals("") && !loginpassword.equals("")){
                loginUser(logintext, loginpassword);
            }
            else {
                System.out.println("Error");
            }
        });

    }
    public void openNewSceneone(String window){
        authSignInButton.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    private void loginUser(String logintext, String loginpassword) {
        DataBaseHandler db = new DataBaseHandler();
        Users users = new Users();
        users.setLogin(logintext);
        users.setUser_password(loginpassword);
        ResultSet resalt =  db.getUserTwo(users);

        int count = 0;
        try {
            while (resalt.next()){
                count++;
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        if (count>=1){
            System.out.println("SUPER");
            Fifth_Fubric_Controller.logUser2 = logintext;
            openNewSceneone("firstfub.fxml");
        }
        else{
            Shake userlog = new Shake(loginField);
            Shake userlog2 = new Shake(passwordField);
            userlog.playanimation();
            userlog2.playanimation();

        }
    }

}
