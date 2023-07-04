package com.example.fubric_kr;

public class Components {
    private int num_cod;

    private String type;
    private int count_in_fub;
    public Components(){

    }

    public int getNum_cod() {
        return num_cod;
    }

    public void setNum_cod(int num_cod) {
        this.num_cod = num_cod;
    }

    public Components(String type, String count_in_fub) {
        this.type = type;
        this.count_in_fub = Integer.parseInt(count_in_fub);
        this.num_cod = Integer.parseInt(String.valueOf(num_cod));
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount_in_fub() {
        return count_in_fub;
    }

    public void setCount_in_fub(String count_in_fub) {
        this.count_in_fub = Integer.parseInt(count_in_fub);
    }
}
