package com.ym.webui.pojo;


import lombok.Data;

@Data
public class Register {
    private String isNegative;
    private String desc;
    private String id;
    private String phone;
    private String password;
    private String msg;


    public Register(String isNegative, String desc, String id, String phone, String password, String msg) {
        this.isNegative = isNegative;
        this.desc = desc;
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.msg = msg;
    }

    public Register() {
    }

    @Override
    public String toString() {
        return "Register{" +
                "isNegative='" + isNegative + '\'' +
                ", desc='" + desc + '\'' +
                ", id='" + id + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
