package com.gnt.COOP.models;

/**
 * Created by Roger-1 on 5/17/2016.
 */


public class News {
    private String title;
    private int imageId;
    private String desc;


    public News(String title, String desc, int imageId) {
        this.title = title;
        this.imageId = imageId;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
