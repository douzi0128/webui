package com.ym.testcaseui_v2.util;

import com.ym.testcaseui_v2.cases.Base;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class ScreenshotUtil {
    public static File saveScreenshot(String filePath) {
        Log4jUtil.logger.info("开始保存截图");
        File screenshot = null;

        if(Base.driver instanceof ChromeDriver){
            ChromeDriver chromeDriver = (ChromeDriver)Base.driver;
            screenshot = chromeDriver.getScreenshotAs(OutputType.FILE);
        }else if(Base.driver instanceof FirefoxDriver){
            FirefoxDriver firefoxDriver = (FirefoxDriver)Base.driver;
            screenshot = firefoxDriver.getScreenshotAs(OutputType.FILE);
        }
        File destFile = new File(filePath);
        try {
            //拷贝截图文件到指定目录
            Log4jUtil.logger.info("拷贝截图文件到指定目录");
            FileUtils.copyFile(screenshot,destFile);
        } catch (IOException e) {
            Log4jUtil.logger.error("保存失败");
            e.printStackTrace();
        }
        return destFile;
    }
}
