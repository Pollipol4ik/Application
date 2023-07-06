package com.example.fubric_kr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.*;

public class DataBaseHandler {
    private static Connection connection;
    private static final String URL_DB = "jdbc:mysql://std-mysql.ist.mospolytech.ru:3306/std_2259_furniture_factory";
    private static final String USER_DB = "std_2259_furniture_factory";
    private static final String PASSWORD_DB = "128128128";


    public Connection getConnection() throws RuntimeException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public void signUpUsers(Users users) {
        String insert = "INSERT INTO " + Const.USER_TABLE + "(" +
                Const.USER_SECOND_NAME + "," + Const.USER_FIRST_NAME + "," + Const.USER_PHONE + "," + Const.USER_ORGANIZATION +
                "," + Const.USER_LOGIN + "," + Const.USER_PASSWORD + ")" +
                "VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(insert);
            ps1.setString(1, users.getSecond_name());
            ps1.setString(2, users.getFirst_name());
            ps1.setString(3, users.getNumber_phone());
            ps1.setString(4, users.getName_org());
            ps1.setString(5, users.getLogin());
            ps1.setString(6, users.getUser_password());
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void changePassword(String newpassword) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD + "=?" +
                " WHERE " + Const.USER_LOGIN + " = '" + Third_Shop_Controller.logUser + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.setString(1, newpassword);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void changePasswordTwo(String newpassword) {
        String update = "UPDATE " + Const.USER_TABLE + " SET " + Const.USER_PASSWORD + "=?" +
                " WHERE " + Const.USER_LOGIN + " = '" + Fifth_Fubric_Controller.logUser2 + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.setString(1, newpassword);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getUser(Users users) {
        ResultSet res = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=? AND " + Const.USER_ORGANIZATION + "!='0'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(select);
            ps1.setString(1, users.getLogin());
            ps1.setString(2, String.valueOf(users.getUser_password().hashCode()));
            res = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res;

    }

    public ResultSet getUserTwo(Users users) {
        ResultSet res2 = null;
        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=? AND " + Const.USER_PASSWORD + "=? AND " + Const.USER_ORGANIZATION + "='0'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(select);
            ps1.setString(1, users.getLogin());
            ps1.setString(2, String.valueOf(users.getUser_password().hashCode()));
            res2 = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res2;

    }

    public void changeComp(int newcount) {
        String update = "UPDATE " + Const.COMPONENTS_TABLE + " SET " + Const.COMPONENTS_COUNT + "=?" + "+" + Const.COMPONENTS_COUNT
                + " WHERE " + Const.COMPONENTS_CODE + "=" + "'" + Third_Fubric_Controller.num_cod_1 + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.setInt(1, newcount);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getCfomp(Components componentsn) {
        String update = "SELECT * FROM " + Const.COMPONENTS_TABLE;

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(String.valueOf(componentsn));
            ResultSet resultSet = preparedStatement.executeQuery(update); // Возвращаем результат выполнения запроса
            return resultSet;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении запроса: " + e.getMessage());
        }


    }


    public void insOrders(Orders orders) {
        String insert = "INSERT INTO " + Const.ORDERS_TABLE + "(" + Const.ORDERS_FAX_NUMBER + "," +
                Const.ORDERS_DATE + "," + Const.ORDERS_ARTICUL + "," + Const.ORDERS_Count + ")" +
                " VALUES(" + "'" + Second_Shop_Controller.logOrder + "'" + ",?,?,?)";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(insert);
            ps1.setString(1, orders.getDate_order());
            ps1.setString(2, orders.getArticul_id_furn());
            ps1.setString(3, orders.getCount_pos());
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet findFax(String login) {
        String update = "SELECT " + Const.USER_PHONE + " FROM " + Const.USER_TABLE + " WHERE " +
                Const.USER_LOGIN + "=" + "'" + login + "'";

        try {
            PreparedStatement preparedStatement = getConnection().prepareStatement(String.valueOf(login));
            ResultSet resultSet = preparedStatement.executeQuery(update); //
            return resultSet;
        } catch (Exception e) {
            throw new RuntimeException("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    public ObservableList<OrdersForTable> getOrders() {
        Connection conn = getConnection();
        ObservableList<OrdersForTable> list = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from orders");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new OrdersForTable(Integer.parseInt(resultSet.getString("num")), resultSet.getString("shops_fax_num"),
                        resultSet.getString("date_order"), resultSet.getString("articul_id_furn"),
                        resultSet.getString("count_pos")));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public ObservableList<OrdersForTable> getOrdersTwo() {
        Connection conn = getConnection();
        ObservableList<OrdersForTable> list = FXCollections.observableArrayList();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("select * from orders" + " where " + Const.ORDERS_FAX_NUMBER +
                    "=" + "'" + Second_Shop_Controller.logOrder + "'");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                list.add(new OrdersForTable(Integer.parseInt(resultSet.getString("num")), resultSet.getString("shops_fax_num"),
                        resultSet.getString("date_order"), resultSet.getString("articul_id_furn"),
                        resultSet.getString("count_pos")));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void changeCountItems(int count, String articul) {
        String update = "UPDATE " + Const.ITEMS_TABLE + " SET " + Const.ITEMS_COUNT + "=" + Const.ITEMS_COUNT + "-" + count
                + " WHERE " + Const.ITEMS_ARTICUL + "=" + "'" + articul + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ResultSet getOrder(String num) {
        ResultSet res2 = null;
        String select = "SELECT articul_id_furn, count_pos  FROM " + Const.ORDERS_TABLE + " WHERE " +
                Const.ORDERS_NUMBER + "= " + "'" + num + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(select);
            res2 = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res2;

    }

    public ResultSet getItems(String num) {
        ResultSet res2 = null;
        String select = "SELECT count_pos  FROM " + Const.ITEMS_TABLE + " WHERE " +
                Const.ITEMS_ARTICUL + "= " + "'" + num + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(select);
            res2 = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res2;

    }

    public ResultSet getFurnItems(String articul) {
        ResultSet res2 = null;
        String select = "SELECT inf_component  FROM " + Const.ITEMS_TABLE + " WHERE " +
                Const.ITEMS_ARTICUL + "= " + "'" + articul + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(select);
            res2 = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res2;

    }

    public ResultSet getItemsCount(String code) {
        ResultSet res2 = null;
        String select = "SELECT count_in_fub  FROM " + Const.COMPONENTS_TABLE + " WHERE " +
                Const.COMPONENTS_CODE + "= " + "'" + code + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(select);
            res2 = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res2;

    }

    public void changeCount(int count, String code) {
        String update = "UPDATE " + Const.COMPONENTS_TABLE + " SET " + Const.COMPONENTS_COUNT + "=" + Const.COMPONENTS_COUNT + "-" + count
                + " WHERE " + Const.COMPONENTS_CODE + "=" + "'" + code + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public void changeIt(int count, String articul) {
        String update = "UPDATE " + Const.ITEMS_TABLE + " SET " + Const.ITEMS_COUNT + "=" + Const.ITEMS_COUNT + "+" + count
                + " WHERE " + Const.ITEMS_ARTICUL + "=" + "'" + articul + "'";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    public void deleteOrder(int  num) {
        String update = "DELETE FROM orders WHERE " + Const.ORDERS_NUMBER  + "=" + num;
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}

//select (json_extract(json_keys(inf_component),'$[0]')), (json_extract(json_keys(inf_component),'$[*]'))
//from furniture_items