package com.example.fubric_kr;

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
        String update = "UPDATE" + Const.USER_TABLE + "SET" + Const.USER_PASSWORD + "=" + "?";
        try {
            PreparedStatement ps1;
            ps1 = getConnection().prepareStatement(update);
            ps1.setString(1, newpassword);
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
            ps1.setString(2, users.getUser_password());
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
            ps1.setString(2, users.getUser_password());
            res2 = ps1.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return res2;

    }

}
