package com.ym.webui.pojo;

import lombok.Data;

@Data
public class LogIn {
    private String isNegative;
    private String desc;
    private String id;
    private String password;
    private String msg;


    public LogIn(String isNegative, String desc, String id, String password, String msg) {
        this.isNegative = isNegative;
        this.desc = desc;
        this.id = id;
        this.password = password;
        this.msg = msg;
    }

    public LogIn() {
    }
}
