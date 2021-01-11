package com.ym.testcaseui_v2.report;

import com.ym.testcaseui_v2.util.Log4jUtil;
import com.ym.testcaseui_v2.util.ScreenshotUtil;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.util.Date;

public class CustomListener extends TestListenerAdapter {
    /**
     * 当测试方法失败时获取截屏并保存
     * @param iTestResult
     */
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        Log4jUtil.logger.info("测试未达成目标,将图片路径写入testng");
        String baseDir = "target"+File.separator+"surefire-reports";
        String screenshotDir= "screenshot";
        //获取测试上下文.获取当前正在执行的test测试集.获取测试集的name值(xml中配置的)
        String testNameDir = iTestResult.getTestContext().getCurrentXmlTest().getName();
        Date date = new Date();
        String dateDir = DateFormatUtils.format(date, "yyyy-MM-dd");
        String fileName = date.getTime()+".jpg";
        String filePath = baseDir+ File.separator+screenshotDir+File.separator+testNameDir+File.separator+dateDir+File.separator+fileName;
        File file = ScreenshotUtil.saveScreenshot(filePath);
        String toBeReplaced = iTestResult.getTestContext().getCurrentXmlTest().getParameter("apacheDocumentRooot");
        String replacement = iTestResult.getTestContext().getCurrentXmlTest().getParameter("host");
        String imgString = getImgString(toBeReplaced,replacement,file);
        //写到reportng日志中
        Reporter.log(imgString);


    }

    /**
     * 获取页面展示图片的html代码
     * @param toBeReplace
     * @param replacement
     * @param file
     * @return
     */
    private String getImgString(String toBeReplace,String replacement,File file) {
        //绝对路径
        String absolutePath = file.getAbsolutePath();
        //替换图片历经
        String accessPath = absolutePath.replace(toBeReplace, replacement);
        //设置点击跳转至新页面,跳转路径及图片宽高
        String img = "<img src='"+accessPath+"' height='100' width='100'><a href='"+accessPath+"' target='_blank'>点击查看大图</a></img>";
        return img;
    }
}
