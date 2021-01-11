package com.ym.testcaseui_v2.pojo;




public class Register {
    private String isNegative;
    private String desc;
    private String id;
    private String phone;
    private String password;
    private String msg;

    public String getIsNegative() {
        return isNegative;
    }

    public void setIsNegative(String isNegative) {
        this.isNegative = isNegative;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

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
