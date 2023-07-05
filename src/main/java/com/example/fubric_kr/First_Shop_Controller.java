package com.example.fubric_kr;

import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.sql.Connection;

public class First_Shop_Controller{
    @FXML
    private TableColumn<OrdersForTable, String> articul;

    @FXML
    private TableColumn<OrdersForTable, String> count;


    @FXML
    private TableColumn<OrdersForTable, String> date;

    @FXML
    private TableColumn<OrdersForTable,Integer> num_ord;
    @FXML
    private TableView<OrdersForTable> tblord;
    ObservableList<OrdersForTable> ordersData ;
    int index = -1;
    Connection conn = null;
    ResultSet resultSet = null;
    PreparedStatement preparedStatement = null;


    @FXML
    private ResourceBundle resources;


    @FXML
    private URL location;

    @FXML
    private Button ordFurn;

    @FXML
    private Button orders_tec;

    @FXML
    private Button personalAccount;




    @FXML
    void initialize() {
        orders_tec.setOnAction(event -> {
            orders_tec.getScene().getWindow().hide();
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
        num_ord.setCellValueFactory(new PropertyValueFactory<OrdersForTable, Integer>("num"));
        date.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("date_order"));
        articul.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("articul_id_furn"));
        count.setCellValueFactory(new PropertyValueFactory<OrdersForTable, String>("count_pos"));
        ordersData = db.getOrdersTwo();
        tblord.setItems(ordersData);
    }

}
