package com.glodon.util;

import com.alibaba.fastjson.JSONObject;

public class JSONUtil {
    public static String getJSONString(Integer event_id, String device_id, String timestamp, Float longitude, Float latitude) {
        JSONObject json = new JSONObject(true);
        json.put("event_id", event_id);
        json.put("device_id", device_id);
        json.put("timestamp", timestamp);
        json.put("longitude", longitude);
        json.put("latitude", latitude);
        return json.toJSONString();
    }

    public static String getJSONString(Float longitude, Float latitude, int count) {
        JSONObject json = new JSONObject(true);
        json.put("longitude", longitude);
        json.put("latitude", latitude);
        json.put("count", count);
        return json.toJSONString();
    }

    public static String getJSONString(int code, String location) {
        JSONObject json = new JSONObject(true);
        json.put("code", code);
        json.put("location", location);
        return json.toJSONString();
    }
}
