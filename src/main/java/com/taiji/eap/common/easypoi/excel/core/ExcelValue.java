package com.taiji.eap.common.easypoi.excel.core;

public class ExcelValue {

    private String position;
    private String value;

    public ExcelValue(String position, String value) {
        this.position = position;
        this.value = value;
    }

    public ExcelValue() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ExcelValue{" +
                "position='" + position + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
