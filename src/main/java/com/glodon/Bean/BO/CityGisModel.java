package com.glodon.Bean.BO;

import java.io.Serializable;

public class CityGisModel implements Serializable {
    private Float lng;
    private Float lat;
    private int count;
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CityGisModel{" +
                "lng=" + lng +
                ", lat=" + lat +
                ", count=" + count +
                ", city='" + address + '\'' +
                '}';
    }
}
