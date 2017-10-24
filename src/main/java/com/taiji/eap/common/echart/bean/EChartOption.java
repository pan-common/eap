package com.taiji.eap.common.echart.bean;

import java.util.List;

public class EChartOption {

    private List<String> xAxisData;

    private List<SeriesData> seriesData;

    public EChartOption(List<String> xAxisData, List<SeriesData> seriesData) {
        this.xAxisData = xAxisData;
        this.seriesData = seriesData;
    }

    public EChartOption() {
    }

    public List<String> getxAxisData() {
        return xAxisData;
    }

    public void setxAxisData(List<String> xAxisData) {
        this.xAxisData = xAxisData;
    }

    public List<SeriesData> getSeriesData() {
        return seriesData;
    }

    public void setSeriesData(List<SeriesData> seriesData) {
        this.seriesData = seriesData;
    }

    @Override
    public String toString() {
        return "EChartOption{" +
                "xAxisData=" + xAxisData +
                ", seriesData=" + seriesData +
                '}';
    }
}
