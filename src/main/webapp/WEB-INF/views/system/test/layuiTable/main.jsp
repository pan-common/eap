<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>sysUser</title>
</head>
<body>
<div style="margin: 15px;">
    <div id="topLayout">
        <div  id="toolbar">
            <button id='addBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 添加
            </button>
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
           url:'${pageContext.request.contextPath}/sysUser/list',
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
                   field:'seq',
                   title:'排序',
                   width:'10%',
                   sort:true,
                   align:'center'
               },
               {
                   field:'userId',
                   title:'用户ID',
                   width:'10%',
                   sort:false,
                   align:'center'
               },
               {
                   field:'userName',
                   title:'用户名',
                   width:'10%',
                   sort:false,
                   align:'center'
               },
               {
                   field:'password',
                   title:'密码',
                   width:'20%',
                   sort:false,
                   align:'center'
               },
               {
                   field:'salt',
                   title:'盐值',
                   width:'20%',
                   sort:false,
                   align:'center'
               },
               {
                   field:'locked',
                   title:'是否被锁住',
                   width:'10%',
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
    <a class="layui-btn layui-btn-sm" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-sm" lay-event="del">删除</a>
</script>
</html>