package com.ym.webui.cases;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] cells = new String[3];
        for (int i = 0; i <cells.length ; i++) {
            cells[i]= "测试"+i;
        }

        System.out.println(Arrays.toString(cells));
    }
}
