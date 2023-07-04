package com.example.fubric_kr;

public class Users {
    private String second_name;
    private String first_name;
    private String number_phone;
    private String name_org;
    private String login;
    private String user_password;

    public Users(String second_name, String first_name, String number_phone, String name_org, String login, String user_password) {
        this.second_name = second_name;
        this.first_name = first_name;
        this.number_phone = number_phone;
        this.name_org = name_org;
        this.login = login;
        this.user_password = user_password;
    }

    public Users() {

    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getNumber_phone() {
        return number_phone;
    }

    public void setNumber_phone(String number_phone) {
        this.number_phone = number_phone;
    }

    public String getName_org() {
        return name_org;
    }

    public void setName_org(String name_org) {
        this.name_org = name_org;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }
}
