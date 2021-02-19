package com.ym.webui.cases;

import com.ym.webui.util.Log4jUtil;
import com.ym.webui.util.RegisterUtil;
import com.ym.webui.util.UILibraryUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterCase extends Base {

    /**
     * 执行反向用例
     * @param id
     * @param phone
     * @param password
     * @param msg
     */
    @Test(dataProvider= "negativeDatas")
    public void negativeTest(String id,String desc,String phone,String password,String msg) {
        Log4jUtil.logger.info("测试数据-用例id:["+id+"],用例描述:["+desc+"],手机号:["+phone+"],密码:["+password+"],提示信息:["+msg+"]");

        driver.get("https://www.baidu.com");
        UILibraryUtil.getElementByKeyword(driver, "百度首页","搜索框").sendKeys(id,phone,password,msg);
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
        Assert.assertEquals(1,0);


    }

    /**
     * 执行正向用例
     * @param id
     * @param phone
     * @param password
     * @param msg
     */

    @Test(dataProvider= "positiveDatas")
    public void positiveTest(String id,String desc,String phone,String password,String msg) throws InterruptedException {
        Log4jUtil.logger.info("测试数据-用例id:["+id+"],用例描述:["+desc+"],手机号:["+phone+"],密码:["+password+"],提示信息:["+msg+"]");

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

    /**
     *获取反向用例
     * @return
     */
    @DataProvider
    public Object[][] negativeDatas() {
        String[] cellNames = {"Id","Desc","Phone","Password","Msg"};
        Object[][] datas = RegisterUtil.getDatas("0",cellNames);
        return datas;
    }



    /**
     *获取正向用例
     * @return
     */
    @DataProvider
    public Object[][] positiveDatas() {
        String[] cellNames = {"Id","Desc","Phone","Password","Msg"};
        Object[][] datas = RegisterUtil.getDatas("1",cellNames);
        return datas;
    }


}
