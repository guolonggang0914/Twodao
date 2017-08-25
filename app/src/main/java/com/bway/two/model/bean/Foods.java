package com.bway.two.model.bean;

/**
 * Created by 卢程
 * 2017/8/12.
 */

public class Foods {
    private String message;
    private String imageid;

    public Foods(String message, String imageid) {
        this.message = message;
        this.imageid = imageid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }
}
