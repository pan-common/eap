package com.taiji.eap.common.query.bean;

public class ColumnData {

    private String field;
    private String title;
    private Integer width;
    private String align = "center";
    private String halign = "center";
    private Boolean resizable = true;

    public ColumnData(String field, String title, Integer width) {
        this.field = field;
        this.title = title;
        this.width = width;
    }

    public ColumnData() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
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

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public String getHalign() {
        return halign;
    }

    public void setHalign(String halign) {
        this.halign = halign;
    }

    public Boolean getResizable() {
        return resizable;
    }

    public void setResizable(Boolean resizable) {
        this.resizable = resizable;
    }

    @Override
    public String toString() {
        return "ColumnData{" +
                "field='" + field + '\'' +
                ", title='" + title + '\'' +
                ", width=" + width +
                ", align='" + align + '\'' +
                ", halign='" + halign + '\'' +
                ", resizable=" + resizable +
                '}';
    }
}
