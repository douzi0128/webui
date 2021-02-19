package com.ym.webui.util;

import com.ym.webui.pojo.Page;
import com.ym.webui.pojo.UIElement;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class UILibraryUtil {

    public static List<Page> pageList = new ArrayList<Page>();
    static {
        UILibraryUtil.logePages(ConfigPropertiesUtil.getPath("xml.uiLibrary.path"));


    }

    /** 根据页面关键字和元素关键字定位元素
     *
     * @param pageName 页面关键字
     * @param uiElementName 元素关键字
     * @return WebElement
     */
    public static WebElement getElementByKeyword(WebDriver driver, String pageName, String uiElementName){
        Log4jUtil.logger.info("尝试获取:["+pageName+"]页面的["+uiElementName+"]元素");

        //System.out.println("getElementByKeyWord");
        WebElement element = null;
        for (Page p:pageList) {
            if(pageName.equals(p.getKeyword())){
                List<UIElement> uiElements = p.getUiElementList();
                for (UIElement ele:uiElements) {
                    if(uiElementName.equals(ele.getKeyword())){
                        String by = ele.getBy();
                        String value = ele.getValue();
                        WebDriverWait wait = new WebDriverWait(driver,20);

                        try{
                            if("id".equalsIgnoreCase(by)){
                                element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
                            }else if("name".equalsIgnoreCase(by)){
                                element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
                            }else if("linkText".equalsIgnoreCase(by)){
                                element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
                            }else if("xpath".equalsIgnoreCase(by)){
                                element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
                            }else if("cssSelector".equalsIgnoreCase(by)){
                                element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
                            }else {
                                Log4jUtil.logger.info("不支持此类型:["+by+"]");
                            }
                        }catch (Exception e){
                            Log4jUtil.logger.info("根据["+by+"]方法定位["+value+"]元素失败");
                        }
                    }
                }

            }
        }
        return element;
    }



    /**
     * 解析uiLibrary文件
     * @param uiLibraryPath
     */

    public static void logePages(String uiLibraryPath){
        Log4jUtil.logger.info("开始解析uiLibrary的xml文件数据");

        SAXReader saxReader = new SAXReader();
        InputStream is = null;
        try {
            is = new FileInputStream(new File(uiLibraryPath));
            Document document = saxReader.read(is);
            Element pages = document.getRootElement();
            List<Element> page = pages.elements("page");
            for (Element p:page) {
                String pageKeyword = p.attributeValue("keyword");
                List<Element> uielements = p.elements("uielement");
                //保存UIElement类型list
                List<UIElement> uiElementList = new ArrayList<UIElement>();
                for (Element e:uielements) {
                    String uiKeyword = e.attributeValue("keyword");
                    String uiId = e.attributeValue("by");
                    String uiValue = e.attributeValue("value");
                    UIElement uiElement = new UIElement(uiKeyword,uiId,uiValue);
                    uiElementList.add(uiElement);
                }Page page1 = new Page(pageKeyword,uiElementList);
                pageList.add(page1);
            }

        } catch (Exception e) {
            Log4jUtil.logger.error("解析失败");
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
