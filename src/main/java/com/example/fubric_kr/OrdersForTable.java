package com.example.fubric_kr;

public class OrdersForTable {


    private int num;
    private String shops_fax_num;
    private String date_order;
    private String articul_id_furn;
    private String count_pos;


    public OrdersForTable(int num, String shops_fax_num, String date_order, String articul_id_furn, String count_pos) {
        this.num = num;
        this.shops_fax_num = shops_fax_num;
        this.date_order = date_order;
        this.articul_id_furn = articul_id_furn;
        this.count_pos = count_pos;
    }



    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public String getArticul_id_furn() {
        return articul_id_furn;
    }

    public void setArticul_id_furn(int articul_id_furn) {
        this.articul_id_furn = String.valueOf(articul_id_furn);
    }

    public String getCount_pos() {
        return count_pos;
    }

    public void setCount_pos(int count_pos) {
        this.count_pos = String.valueOf(count_pos);
    }

}
