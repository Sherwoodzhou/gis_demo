package com.glodon.Bean;

import java.io.Serializable;

public class MobileEvents implements Serializable {
    private Integer eventId ;
    private String deviceId;
    private String timestamp;
    private Float longitude;
    private Float latitude;

    //get方法
    public Integer getEvent_id() {
        return eventId;
    }

    public String getDevice_id() {
        return deviceId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Float getLongitude() {
        return longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    //    set方法
    public void setEvent_id(Integer event_id) {
        this.eventId = event_id;
    }

    public void setDevice_id(String device_id) {
        this.deviceId = device_id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
    //tostring
    @Override
    public String toString() {
        return "Events{" +
                "event_id=" + eventId +
                ", device_id='" + deviceId + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
