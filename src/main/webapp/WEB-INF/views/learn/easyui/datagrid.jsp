<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-19
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../views/system/common/easyui_base.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main_layout" class="easyui-layout">
    <div region="west" split="true" title="菜单区域" style="width:200px;">
    </div>
    <div region="center" title="主页面" style="padding:5px;">
        <table id="datagrid">
        </table>
    </div>
    <div region="north" split="true" title="导航" style="width:150px;">
    </div>
    <div region="south" title="底部区域" style="padding:5px;">
    </div>
</div>
</body>
<script type="text/javascript">
    //设置自适应浏览器宽度和高度
    setLayoutHeight();
    function setLayoutHeight() {
        var height = $(window).height()-20;
        $("#main_layout").attr("style", "width:100%;height:" + height + "px");
        $("#main_layout").layout("resize", {
            width: "100%",
            height: height + "px"
        });
    }
    //================创建数据网格===================
    $("#datagrid").datagrid({
        url:"",
        columns:[[
            {field:'code',title:'Code',width:100},
            {field:'name',title:'Name',width:100},
            {field:'price',title:'Price',width:100,align:'right'}
        ]]
    });
</script>
</html>
