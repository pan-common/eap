<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-2-5
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>企业相关功能维护界面</title>
</head>
<body>
<div style="margin: 15px;">
    <div id="topLayout">
        <div  id="toolbar">
            <form class="layui-form">
                <table class="layui-table">
                    <tr>
                        <td>
                            <button id='addBtn' type="button" class="layui-btn layui-btn-small">
                                <i class="layui-icon">&#xe608;</i> 添加
                            </button>
                        </td>
                        <td>
                            <input type="text" name="title" placeholder="输入企业名称" autocomplete="off" class="layui-input">
                        </td>
                        <td>
                            <button id='searchBtn' class="layui-btn layui-btn-small" type="button">
                                <i class="fa fa-search "></i> 搜索
                            </button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <table id='table' lay-filter="table">
    </table>
</div>
</body>
<script type="text/javascript">
    layui.use([ 'table','layer', 'form' ], function(layer, form) {
        var layer = layui.layer;
        var form =  layui.form;
        var table = layui.table;

        table.render({
            elem:'#table',
            height: 'full-80',
            url:'${pageContext.request.contextPath}/hbSjcjQyJbxx/list',
            method:'get',
            request:{
                pageName:'pageNum',
                limitName:'pageSize'
            },
            response:{
                dataName:'list',
                countName:'total'
            },
            page:true,
            limit:20,
            limits:[10,20,30,50,100],
            loading:true,//是否显示加载条
            text:{
                none:'暂无数据'
            },//修改内置文本提示信息
            initSort:{
                field: 'seq',
                type: 'desc'
            },//初始按某个字段排序
            skin:'row',
            even:true,
            cols:[[
                {
                    type:'checkbox',
                    width:'5%',
                },
                {
                    field:'id',
                    title:'企业ID',
                    width:'30%',
                    sort:true,
                    align:'center'
                },
                {
                    field:'qymc',
                    title:'企业名称',
                    width:'40%',
                    sort:false,
                    align:'center'
                },
                {
                    title:'操作',
                    width:'15%',
                    align:'center',
                    toolbar:'#opbar'
                }
            ]],
            done:function (res,curr,count) {
                res.code = 0;
                res.msg = "请求成功";
                return res;
            }
        });

    });
</script>
<script type="text/html" id="opbar">
    <button class="layui-btn layui-btn-sm" lay-event="edit">生成方案</button>
</script>
</html>
