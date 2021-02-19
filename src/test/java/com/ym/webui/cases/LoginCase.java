package com.ym.webui.cases;

import com.ym.webui.pojo.LogIn;
import com.ym.webui.pojo.Register;
import com.ym.webui.util.ConfigPropertiesUtil;
import com.ym.webui.util.ExcelUtil;
import com.ym.webui.util.RegisterUtil;
import com.ym.webui.util.UILibraryUtil;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class LoginCase extends Base{

    /**
     * 执行反向用例
     * @param id
     * @param phone
     * @param password
     * @param msg
     */
    @Test(dataProvider= "negativeDatas")
    public void negativeTest(String id,String phone,String password,String msg) {

//        driver.get("http://admin.youquan.ligumall.com/toLogin");
//        UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","用户名").sendKeys(id);
//        UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","密码").sendKeys(password);
//        UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","登录按钮").click();
//        System.out.println(UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","提示信息"));

//        driver.get("https://mail.163.com/register/index.htm?from=163mail&utm_source=163mail");
//        driver.findElement(By.id("username")).sendKeys(id);
//        driver.findElement(By.id("phone")).sendKeys(phone);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.xpath("//*[@class='custom-checkbox service']/span")).click();
//        //输入验证码
////        driver.findElement(By.id("veritycode")).sendKeys(VerityCodeUtil.getVerityCode());
//        driver.findElement(By.linkText("立即注册")).click();
//        String actualMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div")).getText();
//        System.out.println(actualMsg);
//        Assert.assertEquals(msg,actualMsg);


    }

    /**
     * 执行正向用例
     * @param id
     * @param password
     * @param msg
     */

    @Test(dataProvider= "positiveDatas")
    public void positiveTest(String id,String password,String msg) throws InterruptedException {
        driver.get("http://admin.youquan.ligumall.com/toLogin");
        UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","用户名").sendKeys(id);
        UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","密码").sendKeys(password);
        UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","登录按钮").click();
        System.out.println(UILibraryUtil.getElementByKeyword(driver,"有券运营管理系统","提示信息"));












//        driver.get("https://mail.163.com/register/index.htm?from=163mail&utm_source=163mail");
//        driver.findElement(By.id("username")).sendKeys(id);
//        driver.findElement(By.id("phone")).sendKeys(phone);
//        driver.findElement(By.id("password")).sendKeys(password);
//        driver.findElement(By.xpath("//*[@class='custom-checkbox service']/span")).click();
//        Thread.sleep(1000);
//        //输入验证码
//        //driver.findElement(By.id("veritycode")).sendKeys(VerityCodeUtil.getVerityCode());
//
//
//        driver.findElement(By.linkText("立即注册")).click();
//        String js = "return $(\".phone\").next().next().text()";
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        String actualMsg = (String) executor.executeScript(js);
//        System.out.println("---------1"+msg);
//        System.out.println("---------2"+actualMsg);
//        //Thread.sleep(20000);
//
//        Assert.assertEquals(actualMsg,msg);



    }


    //加载excel用例list
    public static List<LogIn> loginDatas = new ArrayList<LogIn>();

    static {
        List<LogIn> list = ExcelUtil.load(ConfigPropertiesUtil.getPath("excel.path"),"login", LogIn.class);
        loginDatas.addAll(list);
//        for (Register r:registerDatas) {
//            System.out.println(r);
//
//        }
    }

    /**
     *获取反向用例
     * @return
     */
    @DataProvider
    public Object[][] negativeDatas() {
        String[] cellNames = {"Id","Password","Msg"};
        Object[][] datas = RegisterUtil.getDatas("0",cellNames);
        return datas;
    }



    /**
     *获取正向用例
     * @return
     */
    @DataProvider
    public Object[][] positiveDatas() {
        String[] cellNames = {"Id","Password","Msg"};
        Object[][] datas = RegisterUtil.getDatas("1",cellNames);
        return datas;
    }

}
