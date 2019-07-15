package com.glodon.Bean;

import java.io.Serializable;

public class DangerousHouse implements Serializable {
    private Integer zipCode;
    private String address;
    private Integer count;
    private Float longitude;
    private Float latitude;

    public void setZip_code(Integer zipCode) {
        this.zipCode = zipCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Integer getZip_code() {
        return zipCode;
    }

    public String getAddress() {
        return address;
    }

    public Integer getCount() {
        return count;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    @Override
    public String toString() {
        return "{" +
                "zipCode=" + zipCode +
                ", address='" + address + '\'' +
                ", count=" + count +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
