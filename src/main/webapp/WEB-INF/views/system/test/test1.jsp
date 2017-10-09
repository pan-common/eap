<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
</head>
<body>
<div class="layui-tab layui-tab-card">
    <ul class="layui-tab-title">
        <li class="layui-this">网站设置</li>
        <li>用户管理</li>
        <li>权限分配</li>
        <li>商品管理</li>
        <li>订单管理</li>
    </ul>
    <div class="layui-tab-content" style="height: 100px;">
        <div class="layui-tab-item layui-show">1</div>
        <div class="layui-tab-item">2</div>
        <div class="layui-tab-item">3</div>
        <div class="layui-tab-item">4</div>
        <div class="layui-tab-item">5</div>
        <div class="layui-tab-item">6</div>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {

    });
</script>
</html>