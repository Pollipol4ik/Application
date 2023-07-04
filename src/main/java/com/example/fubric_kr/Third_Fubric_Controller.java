package com.example.fubric_kr;

import com.example.fubric_kr.animations.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Third_Fubric_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Create;

    @FXML
    private Button checkOrd;

    @FXML
    private TextField countComp;

    @FXML
    private Button createComp;

    @FXML
    private Button createFurn;

    @FXML
    private TextField numcod;

    @FXML
    private Button orders;

    @FXML
    private Button personalAccount;
    public static String num_cod_1;
    public static String counter;

    @FXML
    void initialize() {
        orders.setOnAction(event -> {
            orders.getScene().getWindow().hide();
            FXMLLoader loader2 = new FXMLLoader();
            loader2.setLocation(getClass().getResource("firstfub.fxml"));
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
        DataBaseHandler db = new DataBaseHandler();
        Create.setOnAction(event -> {
            db.changeComp(Integer.parseInt(countComp.getText()));
            loginComp(numcod.getText(), countComp.getText());
        });


    }
    private void loginComp(String code, String count) {
        DataBaseHandler db = new DataBaseHandler();
        Components components = new Components();
        components.setNum_cod(Integer.parseInt(code));
        components.setCount_in_fub(count);
        ResultSet resalt =  db.getComp(components);
            num_cod_1 = code;
            counter = count;
        }

    }

