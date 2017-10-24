<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-24
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/echart_base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main" style="width: 1000px;height:400px;"></div>
</body>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var chart = echarts.init(document.getElementById('main'),"green");

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 入门示例',//标题
            subtext:'测试',//副标题
            padding:[5,10,5,10],//边距  上右下左
            itemGap:10,//主标题副标题间距
            left:"20%",
            top:10
        },
        tooltip: {},
        legend: {//图例组件
            type:'scroll',
            left:"center",
            selectedMode:false,//图例选择模式
            data: []
        },
        xAxis: {
            type:'category',
            name:'产品',
            data: []
        },
        yAxis: {
            name:'销量',
        },
        series: []
    };
    // 使用刚指定的配置项和数据显示图表。
    chart.setOption(option);

    chart.showLoading();
    $.get(baseServerUrl+"echart/getEChartOption",{

    },function (data,status) {
        chart.hideLoading();
        if (status == "success") {
            if (data.body.resultCode == "0") {
                chart.setOption({
                    xAxis: {
                        data: data.body.entity.xAxisData
                    },
                    series: data.body.entity.seriesData,
                    legend: {//图例组件
                        data: data.body.entity.seriesData
                    },
                })
            }else {

            }
        }else {

        }
    });

</script>
</html>
