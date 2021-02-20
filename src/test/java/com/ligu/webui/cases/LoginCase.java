package com.ligu.webui.cases;

import com.ligu.webui.util.TestLogInUtil;
import com.ligu.webui.util.UILibraryUtil;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginCase extends Base{

    /**
     *获取正向用例
     * @return
     */
    @DataProvider
    public Object[][] positiveDatas() {
//        System.out.println("获取正向用例" );
        String[] cellNames = {"IsNegative","Desc","Id","Password","Msg"};
        Object[][] datas = TestLogInUtil.getDatas("1",cellNames);
//        System.out.println("正向用例数量："+datas.length);
        for (int i = 0; i < datas.length; i++) {
            for (int j = 0; j < datas[i].length; j++) {
                System.out.println("正向用例----------"+datas[i][j]);

            }

        }
        return datas;

    }
    /**
     *获取反向用例
     * @return
     */
    @DataProvider
    public Object[][] negativeDatas() {
        System.out.println("获取反向用例");
        String[] cellNames = {"IsNegative","Desc","Id","Password","Msg"};
        Object[][] datas = TestLogInUtil.getDatas("0",cellNames);
        return datas;
    }


    /**
     * 执行反向用例
     * @param isNegative
     * @param desc
     * @param id
     * @param password
     * @param msg
     */
    @Test(dataProvider= "negativeDatas")
    public void negativeTest(String isNegative,String desc,String id,String password,String msg) {
        System.out.println("执行反向用例");
        driver.get("http://admin.youquan.ligumall.com/toLogin");
        UILibraryUtil.getElementByKeyword(driver,"登录界面","用户名").sendKeys(id);
        UILibraryUtil.getElementByKeyword(driver,"登录界面","密码").sendKeys(password);
        UILibraryUtil.getElementByKeyword(driver,"登录界面","登录按钮").click();
        String text = UILibraryUtil.getElementByKeyword(driver, "登录界面", "提示信息").getText();
        Assert.assertEquals(msg,text);
    }

    /**
     * 执行正向用例
     * @param isNegative
     * @param desc
     * @param id
     * @param password
     * @param msg
     * @throws InterruptedException
     */
    @Test(dataProvider= "positiveDatas")
    public void positiveTest(String isNegative,String desc,String id,String password,String msg) throws InterruptedException {

        System.out.println("执行正向用例");
        driver.get("http://admin.youquan.ligumall.com/toLogin");
        UILibraryUtil.getElementByKeyword(driver,"登录界面","用户名").sendKeys(id);
        UILibraryUtil.getElementByKeyword(driver,"登录界面","密码").sendKeys(password);
        UILibraryUtil.getElementByKeyword(driver,"登录界面","登录按钮").click();
        String text = UILibraryUtil.getElementByKeyword(driver, "首页", "左菜单栏欢迎用户名").getText();
        Assert.assertEquals(msg,text);
//        Assert.assertEquals(1,2);


    }




}
