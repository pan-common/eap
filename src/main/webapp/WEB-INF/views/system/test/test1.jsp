<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
</head>
<style type="text/css">
    .image-preview{
        width: auto;
        height: auto;
        max-width: 20%;
        max-height: 20%;
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
    }
</style>
<body>
<form class="layui-form">
    <table class="layui-table">
        <tr>
            <td>
                <select id="commonSelect" name="select_type" layfilter="select_type">
                </select>
            </td>
        </tr>
        <tr>
            <td>
                <div id="district" class="layui-form-item">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div>
                    <button id="uploadBtn" type="button" class="layui-btn"><i class="fa fa-image">上传图片</i></button>
                    <img id="imageview" class="image-preview">
                </div>
            </td>
        </tr>
    </table>
</form>

</body>
<script src="${pageContext.request.contextPath}/resources/eap/system/library/CommonSelect.js"></script>
<script src="${pageContext.request.contextPath}/resources/eap/system/library/District.js"></script>
<script type="text/javascript">
    layui.use(['upload','layer','form'],function () {
        var form = layui.form;
        var layer = layui.layer;
        var upload = layui.upload;

        //通用下拉框用法
        $("#commonSelect").CommonSelect("init",{
            layuiForm:form,
            layer:layer,
            datasource:"dictionary",
            params:"100",
            onSelect:function (data) {
                alert(data.value);
            }
        });

        //三级区划
        $('#district').District('init',{
            layuiForm:form,
            layer:layer,
            onSelect:function (level,value) {
//                alert("级别:"+level+"   代码:"+value);
            }
        })

        //弹出录入框
        function showModel(title,url) {
            layer.open({
                id:"model",
                type:2,
                title:title,
                content:url,
                area:["550px","550px"],
                offset: '20px',
                shade:false,
                maxmin:true,
                success:function (layero, index) {

                }
            })
        };

        $("#uploadBtn").bind('click',function () {
            showModel("图片上传","${pageContext.request.contextPath}/sysResource/link?url=system/common/module/ImageUpload");
        });

    });
</script>
</html>