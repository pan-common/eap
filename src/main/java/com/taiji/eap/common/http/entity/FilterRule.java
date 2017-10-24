package com.taiji.eap.common.http.entity;

public class FilterRule {

    private String field;
    private String value;

    public FilterRule(String field, String value) {
        this.field = field;
        this.value = value;
    }

    public FilterRule() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "FilterRule{" +
                "field='" + field + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
