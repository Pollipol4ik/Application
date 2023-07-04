package com.example.fubric_kr;

import java.util.Map;

public class Orders {


    private int num;
    private String shops_fax_num;
    private String date_order;
    private int inf;

    public Orders(String num, String shops_fax_num, String date_order, int inf) {
        this.num = Integer.parseInt(num);
        this.shops_fax_num = shops_fax_num;
        this.date_order = date_order;
        this.inf = inf;
    }

    public int getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = Integer.parseInt(num);
    }

    public String getShops_fax_num() {
        return shops_fax_num;
    }

    public void setShops_fax_num(String shops_fax_num) {
        this.shops_fax_num = shops_fax_num;
    }

    public String getDate_order() {
        return date_order;
    }

    public void setDate_order(String date_order) {
        this.date_order = date_order;
    }

    public int getInf() {
        return inf;
    }

    public void setInf(Map<Integer, Integer> inf) {
        this.inf = inf.size();
    }


}
