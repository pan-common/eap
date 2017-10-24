package com.taiji.eap.common.echart.bean;

import java.util.List;

public class SeriesData {

    private String name;

    private String type;

    private List<Integer> data;

    public SeriesData(String name, String type, List<Integer> data) {
        this.name = name;
        this.type = type;
        this.data = data;
    }

    public SeriesData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Integer> getData() {
        return data;
    }

    public void setData(List<Integer> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "SeriesData{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
