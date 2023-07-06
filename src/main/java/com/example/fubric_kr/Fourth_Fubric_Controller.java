package com.example.fubric_kr;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Fourth_Fubric_Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField articleNumber;

    @FXML
    private Button checkOrd;

    @FXML
    private TextField countPos;

    @FXML
    private Button create;

    @FXML
    private Button createComp;

    @FXML
    private Button createFurn;

    @FXML
    private Label errorString;

    @FXML
    private Button orders;

    @FXML
    private Button personalAccount;

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
        create.setOnAction(event -> {
            signFurnitureItems();
        });


    }

    public void signFurnitureItems() {
        DataBaseHandler db = new DataBaseHandler();
        String articleNumberText = articleNumber.getText();
        String countPosText = countPos.getText();
        ResultSet s = db.getFurnItems(articleNumberText);
        String[] inf = {};
        ArrayList<String[]> next = new ArrayList<>();
        boolean flag = true;
        try {
            s.next();
            inf = s.getString("inf_component").replace("{", "").replace("}", "").split(",");
            String[] pair;
            int countFromDB = 0;
            for (String i : inf) {
                pair = i.replace("\"", "").replace(" ", "").split(":");
                s = db.getItemsCount(pair[0]);
                s.next();
                countFromDB = Integer.parseInt(s.getString("count_in_fub"));
                int num = Integer.parseInt(pair[1]);
                if (countFromDB >= num * Integer.parseInt(countPosText)) {
                    next.add(new String[]{pair[0], String.valueOf(num * Integer.parseInt(countPosText))});
                } else {
                    flag = false;
                }
            }
            if (flag) {
                for (String[] i:next) {
                    db.changeCount(Integer.parseInt(i[1]), i[0]);
                }
                db.changeIt(Integer.parseInt(countPosText), articleNumberText);
            }

            else{
                errorString.setText("Не хватает компонентов");
            }
            //System.out.println(inf);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

}
