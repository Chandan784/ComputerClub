package com.oa.computerclub.Model;

public class ShortcutkeyModel {

    String title;
    String url;
    String imgurl;
    String pdfurl;

    public ShortcutkeyModel() {
    }

    public ShortcutkeyModel(String title, String url, String imgurl, String pdfurl) {
        this.title = title;
        this.url = url;
        this.imgurl = imgurl;
        this.pdfurl = pdfurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }
}
