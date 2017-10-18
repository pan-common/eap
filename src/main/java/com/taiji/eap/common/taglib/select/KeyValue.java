package com.taiji.eap.common.taglib.select;

import java.io.Serializable;

public abstract class KeyValue implements Serializable{

    private static final long serialVersionUID = -4927934411976965060L;

    protected String key;
    protected String value;

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public KeyValue() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
