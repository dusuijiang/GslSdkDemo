package com.gls.speed.sdk.base;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseReq {
    private Map<String, Object> properties = new HashMap<String, Object>();
    private long timeMillis = System.currentTimeMillis();

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    public long getTimeMillis() {
        return timeMillis;
    }

    public void setTimeMillis(long timeMillis) {
        this.timeMillis = timeMillis;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseReq{");
        sb.append("properties=").append(properties);
        sb.append(", timeMillis=").append(timeMillis);
        sb.append('}');
        return sb.toString();
    }
}
