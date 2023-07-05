package com.example.fubric_kr;

import java.util.Map;

public class Furniture_items {
    private int articul;
    private String type;
    private double price;
    private String lines_furniture_id;
    //private Map<Integer, Integer> inf;
    private int count_pos;

    public Furniture_items(int articul, String type, double price, String lines_furniture_id, Map<Integer, Integer> inf, int count_pos) {
        this.articul = articul;
        this.type = type;
        this.price = price;
        this.lines_furniture_id = lines_furniture_id;
        //this.inf = inf;
        this.count_pos = count_pos;
    }

    public int getCount_pos() {
        return count_pos;
    }

    public void setCount_pos(int count_pos) {
        this.count_pos = count_pos;
    }

    public int getArticul() {
        return articul;
    }

    public void setArticul(int articul) {
        this.articul = articul;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLines_furniture_id() {
        return lines_furniture_id;
    }

    public void setLines_furniture_id(String lines_furniture_id) {
        this.lines_furniture_id = lines_furniture_id;
    }

//    public Map<Integer, Integer> getInf() {
//        return inf;
//    }
//
//    public void setInf(Map<Integer, Integer> inf) {
//        this.inf = inf;
//    }
}
