package com.ym.webui.pojo;

import lombok.Data;

@Data
public class LogIn {
    private String id;
    private String password;


    public LogIn(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public LogIn() {
    }
}
