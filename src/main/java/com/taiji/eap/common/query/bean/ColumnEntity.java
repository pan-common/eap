package com.taiji.eap.common.query.bean;

public class ColumnEntity {

    private String fieldName;
    private String title;
    private Integer width;

    public ColumnEntity(String fieldName, String title, Integer width) {
        this.fieldName = fieldName;
        this.title = title;
        this.width = width;
    }

    public ColumnEntity() {
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "ColumnEntity{" +
                "fieldName='" + fieldName + '\'' +
                ", title='" + title + '\'' +
                ", width=" + width +
                '}';
    }
}
