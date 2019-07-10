package com.glodon.Bean;

import org.springframework.stereotype.Component;

@Component
public class MobileEvents {
    private long event_id ;
    private String device_id;
    private String timestamp;
    private long longitude;
    private long latitude;

    //get方法
    public long getEvent_id() {
        return event_id;
    }

    public String getDevice_id() {
        return device_id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public long getLongitude() {
        return longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    //    set方法
    public void setEvent_id(long event_id) {
        this.event_id = event_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
    //tostring
    @Override
    public String toString() {
        return "Events{" +
                "event_id=" + event_id +
                ", device_id='" + device_id + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
