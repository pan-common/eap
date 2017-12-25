<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-2
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/eap/base/css/login.css" media="all">

<html>
<head>
    <title>后台登陆</title>
</head>
<body>
<div class="login-main" id="login">
    <header class="layui-elip">后台登陆</header>
    <form class="layui-form" id="loginform">
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="userName" lay-verify="required" placeholder="请输入登录用户名"  type="text" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <input name="password" lay-verify="required" placeholder="请输入登录密码"  type="password" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-input-inline login-btn">
            <button type="submit" lay-submit="" lay-filter="login" class="layui-btn">登录</button>
        </div>
        <hr/>
        <p><a class="fl">注册账号</a><a class="fr">忘记密码？</a></p>
    </form>
</div>
</body>
<script type="text/javascript">
    layui.use(['layer','form'],function () {
        var form = layui.form;
        var layer = layui.layer;
        form.render();

        form.on("submit(login)",function () {
            $.post(baseServerUrl+"sysUser/doLogin",$("#loginform").serializeArray(),function (data,status) {
                if(status=='success'){
                    if(data.body.resultCode=="0"){
                        window.location.href = baseServerUrl+"system/home";
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            }).error(function (e) {
                layer.msg('网络错误'+e.status, {icon: 5});
            });
            return false;
        });

    });
</script>
</html>
