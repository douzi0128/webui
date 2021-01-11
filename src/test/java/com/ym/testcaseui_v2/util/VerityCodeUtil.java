package com.ym.testcaseui_v2.util;

import com.ym.testcaseui_v2.cases.Base;

/**
 *获取cookie
 */
public class VerityCodeUtil {
    public static final String COOKIE_NAME = "verifycode";
    public static String getVerityCode(){
        String cookie= Base.driver.manage().getCookieNamed(COOKIE_NAME).getValue();
        Log4jUtil.logger.info("获取的cookie为:["+cookie+"]");
        return cookie;



    }

}
