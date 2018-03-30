<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-3-2
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <blockquote class="layui-elem-quote">老师</blockquote>
    <div class="layui-form-item">
        <div class="layui-inline">
            <select id="teacher_city" name="teacher_city" layfilter="select_city">
                <option value="">请选择一个城市</option>
            </select>
        </div>
        <div class="layui-inline">
            <select id="teacher_school" name="teacher_school" layfilter="select_school">
                <option value="">请选择一个学校</option>
            </select>
        </div>
        <div class="layui-inline">
            <select id="teacher_room" name="teacher_room" layfilter="select_room">
                <option value="">请选择一个教室</option>
            </select>
        </div>
    </div>
    <blockquote class="layui-elem-quote">学生</blockquote>
    <div class="layui-form-item">
        <div class="layui-inline">
            <select id="student_city" name="student_city" layfilter="select_city">
                <option value="">请选择一个城市</option>
            </select>
        </div>
        <div class="layui-inline">
            <select id="student_school" name="student_school" layfilter="select_school">
                <option value="">请选择一个学校</option>
            </select>
        </div>
        <div class="layui-inline">
            <select id="student_room" name="student_room" layfilter="select_room">
                <option value="">请选择一个教室</option>
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <input type="text" name="title" style="width: 200px" required  lay-verify="required" placeholder="请输入推流地址" autocomplete="off" class="layui-input">
    </div>
</form>
</body>
<script type="text/javascript">

    layui.use([ 'layer', 'form' ], function(layer, form) {
        form.render();



    });

</script>
</html>
