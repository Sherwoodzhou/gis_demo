package com.glodon.Bean.BO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

public class GisModle implements Serializable {

    private Float lng;
    private Float lat;
    private int count;

    public Float getLng() {
        return lng;
    }

    public void setLng(Float lng) {
        this.lng = lng;
    }

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "{" +
                "lng=" + lng +
                ", lat=" + lat +
                ", count=" + count +
                '}';
    }
}
