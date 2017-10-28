<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-25
  Time: 10:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/easyui_base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table id="datagrid">
</table>
</body>
<script type="text/javascript">
    $.get('${pageContext.request.contextPath}/query/queryView',
        {
            tableName:'${param.tableName}'
        },
        function (data, status) {
            if (status == "success") {

                $("#datagrid").datagrid({
                    url:"${pageContext.request.contextPath}/query/queryData",
                    method:"GET",
                    fitColumns:false,//设置为true防止水平滚动
                    autoRowHeight:true,//适应内容高度
                    toolbar: '#tbar',
                    striped:true,//条文化
                    nowrap:false,//设置true单行显示
                    idField:'id',//设置主键
                    loadMsg:"数据加载中……",
                    pagination:true,//显示底部分页工具栏
                    rownumbers:true,//带行号
                    singleSelect:true,//单行选中
                    checkOnSelect:true,//行点击选中
                    pagePosition:'bottom',//定义分页栏位置  top bottom both
                    pageNumber:1,//初始页码
                    pageSize:15,//初始每页行数
                    pageList:[10,15,30,50,100],//每页行数选择
                    queryParams:{
                        //额外参数
                        tableName:'${param.tableName}'
                    },
                    sortName:'',//排序列
                    sortOrder:'asc',//排序列顺序
                    multiSort:true,//是否多列排序
                    remoteSort:true,//是否服务器排序
                    showHeader:true,//是否显示头部
                    showFooter:true,//是否显示底部
                    scrollbarSize:200,//滚动条大小
                    rowStyler:function (index,row) {
                        //设置样式
                    },
                    columns:data
                });

            }else {

            }
        }).error(function (e) {

    });
</script>
</html>
