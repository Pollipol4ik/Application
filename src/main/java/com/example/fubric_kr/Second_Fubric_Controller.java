package com.example.fubric_kr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Second_Fubric_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button checkOrd;

    @FXML
    private Button createComp;

    @FXML
    private Button createFurn;



    @FXML
    private Label errorString;

    @FXML
    private TextField numberord;

    @FXML
    private Button orders;

    @FXML
    private Button personalAccount;

    @FXML
    private Button treet;

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
        treet.setOnAction(event -> {
            signOrder();

        });




        }
    public void signOrder () {
        DataBaseHandler db = new DataBaseHandler();
        String num = numberord.getText();
        ResultSet s = db.getOrder(num);
        String art = "";
        String count = "";
        try {
            s.next();
            art = s.getString("articul_id_furn");
            count = s.getString("count_pos");
            //System.out.println(art + count);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        ResultSet r = db.getItems(art);
        Integer count_tec  = 0;
        try {
            r.next();
            count_tec = r.getInt("count_pos");
            //System.out.println(count_tec);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (count_tec >= Integer.parseInt(count)){
            db.changeCountItems(Integer.parseInt(count), art);
        }
        else {
            errorString.setText("Необходимо создать мебель из данного заказа!");
        }

    }

    }
