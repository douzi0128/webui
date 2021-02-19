package com.ym.webui.pojo;


import java.util.List;

/**一个page对应一个页面,其中包含由多个UIElement组成的list
 *
 */

public class Page {
    private String keyword;
    private List<UIElement> uiElementList;




    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public List<UIElement> getUiElementList() {
        return uiElementList;
    }

    public void setUiElementList(List<UIElement> uiElementList) {
        this.uiElementList = uiElementList;
    }

    public Page(String keyword, List<UIElement> uiElementList) {
        this.keyword = keyword;
        this.uiElementList = uiElementList;
    }

    public Page() {
    }
}
