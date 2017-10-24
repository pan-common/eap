package com.taiji.eap.common.echart.service.impl;

import com.taiji.eap.common.echart.bean.EChartOption;
import com.taiji.eap.common.echart.bean.SeriesData;
import com.taiji.eap.common.echart.service.EChartService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EChartServiceImpl implements EChartService{

    @Override
    public EChartOption getEChartOption() {
        EChartOption eChartOption = new EChartOption();
        List<String> xAxisData = new ArrayList<String>();
        xAxisData.add("衬衫");
        xAxisData.add("羊毛衫");
        xAxisData.add("雪纺衫");
        xAxisData.add("裤子");
        xAxisData.add("高跟鞋");
        xAxisData.add("袜子");
        eChartOption.setxAxisData(xAxisData);
        List<SeriesData> seriesData = new ArrayList<SeriesData>();
        List<Integer> data1 = new ArrayList<Integer>();
        data1.add(5);
        data1.add(20);
        data1.add(36);
        data1.add(10);
        data1.add(10);
        data1.add(20);
        seriesData.add(new SeriesData("销量","bar",data1));
        List<Integer> data2 = new ArrayList<Integer>();
        data2.add(5);
        data2.add(20);
        data2.add(36);
        data2.add(10);
        data2.add(10);
        data2.add(20);
        seriesData.add(new SeriesData("dd","bar",data2));
        eChartOption.setSeriesData(seriesData);
        return eChartOption;
    }
}
