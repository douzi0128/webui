package com.ym.testcaseui_v2.util;

import com.ym.testcaseui_v2.pojo.Register;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class RegisterUtil {
    public static List<Register> registerDatas = new ArrayList<Register>();

    //静态加载excel用例只list
    static {
        List<Register> list = ExcelUtil.load(ConfigPropertiesUtil.getPath("excel.register.path"),"用例", Register.class);
        registerDatas.addAll(list);
//        for (Register r:registerDatas) {
//            System.out.println(r);
//
//        }
    }



    /**
     * 获取用例分别放入二维数组
     * @return
     */
    public static Object[][] getDatas(String flag,String[] cellNames) {
        Log4jUtil.logger.info("开始获取测试数据:是否为正向用例["+flag+"],列名:["+cellNames.toString()+"]");

        List<Register> satisfied = new ArrayList<Register>();
        for (Register r:registerDatas) {
            if (flag.equals(r.getIsNegative())){
                satisfied.add(r);
            }
        }
        Object[][] datas = new Object[satisfied.size()][cellNames.length];

        Class<Register> clazz = Register.class;
        for (int i = 0; i < satisfied.size() ; i++) {
            Register register= satisfied.get(i);
            for (int j = 0; j< cellNames.length;j++){
                String methodName = "get"+cellNames[j];
                Method method;
                try{
                    method = clazz.getMethod(methodName);
                    String value = (String) method.invoke(register);
                    datas[i][j] = value;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return datas;

    }
}
