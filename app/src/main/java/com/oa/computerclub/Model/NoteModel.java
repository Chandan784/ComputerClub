package com.oa.computerclub.Model;

public class NoteModel {
    String imgurl;
    String title;
    String pdfurl;
    String url;

    public NoteModel() {
    }



    public NoteModel(String imgurl, String pdfurl, String url, String title) {
        this.imgurl = imgurl;
        this.pdfurl = pdfurl;
        this.url = url;
        this.title = title;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
