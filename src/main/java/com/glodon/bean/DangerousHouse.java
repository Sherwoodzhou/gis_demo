package com.glodon.bean;

import java.io.Serializable;

public class DangerousHouse implements Serializable {
    private Integer zipCode;
    private String address;
    private Integer count;
    private Float longitude;
    private Float latitude;
    private Integer finished;
    private Integer inprocess;
    private Integer nostart;
    private Integer nofound;
    private Integer inappropriate;
    private Integer proved;

    public Integer getFinished() {
        return finished;
    }

    public void setFinished(Integer finished) {
        this.finished = finished;
    }

    public Integer getInprocess() {
        return inprocess;
    }

    public void setInprocess(Integer inprocess) {
        this.inprocess = inprocess;
    }

    public Integer getNostart() {
        return nostart;
    }

    public void setNostart(Integer nostart) {
        this.nostart = nostart;
    }

    public Integer getNofound() {
        return nofound;
    }

    public void setNofound(Integer nofound) {
        this.nofound = nofound;
    }

    public Integer getInappropriate() {
        return inappropriate;
    }

    public void setInappropriate(Integer inappropriate) {
        this.inappropriate = inappropriate;
    }

    public Integer getProved() {
        return proved;
    }

    public void setProved(Integer proved) {
        this.proved = proved;
    }

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
        return "DangerousHouse{" +
                "zipCode=" + zipCode +
                ", address='" + address + '\'' +
                ", count=" + count +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", finished=" + finished +
                ", inprocess=" + inprocess +
                ", nostrart=" + nostart +
                ", nofound=" + nofound +
                ", inappropriate=" + inappropriate +
                ", proved=" + proved +
                '}';
    }
}
