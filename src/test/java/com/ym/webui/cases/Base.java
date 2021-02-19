package com.ym.webui.cases;

import com.ym.webui.util.Log4jUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class Base {
    public static WebDriver driver;



    @BeforeSuite
    @Parameters(value="browserType")
    public void init(String browserType){
        Log4jUtil.logger.info("-----------套件开始执行-----------");
        Log4jUtil.logger.info("浏览器类型为["+browserType+"]");
        if ("chrome".equalsIgnoreCase(browserType)){
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
            ChromeOptions chromeOptions=new ChromeOptions();
            chromeOptions.addArguments("-headless");
            driver = new ChromeDriver(chromeOptions);

        }else if ("firefox".equalsIgnoreCase(browserType)){
            System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver");
            driver = new FirefoxDriver();

        }else {
            System.out.println("不支持该浏览器,请检查配置");
            Log4jUtil.logger.error("不支持该浏览器:["+browserType+"]请检查配置");
        }
    }

    @AfterSuite
    public void quitDriver(){
        driver.quit();
        Log4jUtil.logger.info("-----------套件执行完成-----------");

    }



}
