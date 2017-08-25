package com.bway.two.model.bean;

import java.io.Serializable;

/**
 * Created by 卢程
 * 2017/8/24.
 */

public class ItemMessage implements Serializable{
    private double lon;
    private double lat;
    private int parentId;
    private String imageUrl;
    private String name;
    private String adr;
    private int juli;

    public ItemMessage() {
    }

    public ItemMessage(double lon, double lat, int parentId, String imageUrl, String name, String adr, int juli) {
        this.lon = lon;
        this.lat = lat;
        this.parentId = parentId;
        this.imageUrl = imageUrl;
        this.name = name;
        this.adr = adr;
        this.juli = juli;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdr() {
        return adr;
    }

    public void setAdr(String adr) {
        this.adr = adr;
    }

    public int getJuli() {
        return juli;
    }

    public void setJuli(int juli) {
        this.juli = juli;
    }
}
