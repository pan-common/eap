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
<div id="bing" style="width: 1000px;height: 400px">
</div>
<div id="radar" style="width: 1000px;height: 400px">
</div>
</body>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var chart = echarts.init(document.getElementById('main'),"green");

    var bingChart = echarts.init(document.getElementById('bing'),'green');

    var radarChart = echarts.init(document.getElementById('radar'),'green');

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
        toolbox: {
            show: true,
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                dataView: {readOnly: false},
                magicType: {type: ['line', 'bar']},
                restore: {},
                saveAsImage: {}
            }
        },
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

    var bingOption = {
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b}: {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data:['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        series: [
            {
                name:'访问来源',
                type:'pie',
                radius: ['50%', '70%'],
                avoidLabelOverlap: false,
                label: {
                    normal: {
                        show: false,
                        position: 'center'
                    },
                    emphasis: {
                        show: true,
                        textStyle: {
                            fontSize: '30',
                            fontWeight: 'bold'
                        }
                    }
                },
                labelLine: {
                    normal: {
                        show: false
                    }
                },
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}
                ]
            }
        ]
    };
    bingChart.setOption(bingOption);

    var radarOption = {
        title: {
            text: '基础雷达图'
        },
        tooltip: {
            formatter:function (params,a) {
                console.info(radarOption.radar.indicator[params.dataIndex].name);
            }
        },
        legend: {
            data: ['预算分配（Allocated Budget）']
        },
        radar: {
            // shape: 'circle',
            name: {
                textStyle: {
                    color: '#fff',
                    backgroundColor: '#999',
                    borderRadius: 3,
                    padding: [3, 5]
                }
            },
            indicator: [
                { name: '销售（sales）', max: 6500},
                { name: '管理（Administration）', max: 16000},
                { name: '信息技术（Information Techology）', max: 30000},
                { name: '客服（Customer Support）', max: 38000},
                { name: '研发（Development）', max: 52000},
                { name: '市场（Marketing）', max: 25000}
            ]
        },
        series: [{
            name: '预算 vs 开销（Budget vs spending）',
            type: 'radar',
            // areaStyle: {normal: {}},
            data : [
                {
                    value : [4300, 10000, 28000, 35000, 50000, 19000],
                    name : '预算分配（Allocated Budget）'
                }
            ]
        }]
    };
    radarChart.setOption(radarOption)

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
