package com.ym.webui.util;

import com.ym.webui.pojo.LogIn;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogInUtil {
    public static List<LogIn> logInDatas = new ArrayList<LogIn>();


//    public static void exceleDispose(){
//        System.out.println("数据预处理");
//        List<LogIn> list = ExcelUtil.load(ConfigPropertiesUtil.getPath("excel.path"),"login", LogIn.class);
//        logInDatas.addAll(list);
//        System.out.println(logInDatas.size()+"loginDatas长度");
//    }
    //静态加载excel用例list
    static {
        List<LogIn> list = ExcelUtil.load(ConfigPropertiesUtil.getPath("excel.path"), "login", LogIn.class);
        logInDatas.addAll(list);
    for (LogIn l:logInDatas) {
        System.out.println(l);

    }
    }



//        for (Register r:registerDatas) {
//            System.out.println(r);
//
//        }




    /**
     * 获取用例分别放入二维数组
     * @return
     */
    public static Object[][] getDatas(String flag,String[] cellNames) {
//        for (int i = 0; i <cellNames.length ; i++) {
//            System.out.println("-------------------"+cellNames[i]);
//
//        }
        Log4jUtil.logger.info("开始获取测试数据:是否为正向用例["+flag+"],列名:["+ Arrays.toString(cellNames)+"]");

        List<LogIn> satisfied = new ArrayList<LogIn>();
        for (LogIn r:logInDatas) {
            if (flag.equals(r.getIsNegative())){
                satisfied.add(r);
            }
        }
        Object[][] datas = new Object[satisfied.size()][cellNames.length];

        Class<LogIn> clazz = LogIn.class;
        for (int i = 0; i < satisfied.size() ; i++) {
            LogIn logIn= satisfied.get(i);
            for (int j = 0; j< cellNames.length;j++){
                String methodName = "get"+cellNames[j];
                Method method;
                try{
                    method = clazz.getMethod(methodName);
                    String value = (String) method.invoke(logIn);
                    datas[i][j] = value;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println("封装二维数据完毕，返回datas");
        System.out.println(datas.length+"data长度");
        for (int i = 0; i <datas.length ; i++) {
            for (int j = 0; j <datas[i].length ; j++) {
                System.out.println("--------------------"+datas[i][j]);

            }
        }
        return datas;

    }
}
