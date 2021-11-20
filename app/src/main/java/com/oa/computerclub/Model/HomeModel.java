package com.oa.computerclub.Model;

public class HomeModel {
    String imgurl;
    String url;
    String pdfurl;
    String title;

    public HomeModel() {
    }

    public HomeModel(String imgurl, String url, String pdfurl, String title) {
        this.imgurl = imgurl;
        this.url = url;
        this.pdfurl = pdfurl;
        this.title = title;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
