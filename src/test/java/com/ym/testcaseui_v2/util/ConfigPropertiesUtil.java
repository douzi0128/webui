package com.ym.testcaseui_v2.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;


public class ConfigPropertiesUtil {
    public static Properties  properties = new Properties();

    static {
        try{
            InputStream is = new FileInputStream(new File("src/test/resources/config.properties"));
            properties.load(is);
        } catch (Exception e) {
                e.printStackTrace();
            }

        }


    public static String getPath(String path){
            String excelPath = properties.getProperty(path);
            return excelPath;

    }
}
