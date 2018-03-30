<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-2-14
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .center-in-center{
            position: absolute;
            top: 40%;
            left: 40%;
            -webkit-transform: translate(-50%, -50%);
            -moz-transform: translate(-50%, -50%);
            -ms-transform: translate(-50%, -50%);
            -o-transform: translate(-50%, -50%);
            transform: translate(-50%, -50%);
        }
    </style>
</head>
<body>
<form id="form" class="center-in-center" enctype="multipart/form-data" method="post" action="${pageContext.request.contextPath}/yhysje/importExcel">
    <table class="table table-bordered">
        <tr>
            <td><h4 style="width: 100px">借款数据：</h4></td>
            <td><input id="jk_upload" name="jk_upload" type="file" data-show-caption="true"></td>
        </tr>
        <tr>
            <td><h4 style="width: 100px">贷款数据：</h4></td>
            <td><input id="dk_upload" name="dk_upload" type="file" data-show-caption="true"></td>
        </tr>
    </table>
    <div align="right">
        <button onclick="uploadImage()" type="button" class="btn btn-primary" iconCls="icon-ok"
                style="width: 90px">提交</button>
        <button href="javascript:void(0)" class="btn btn-primary"
                iconCls="icon-ok" onclick="cancel()" style="width: 90px">取消</button>
    </div>
</form>
</body>
<script type="text/javascript">
    $("#jk_upload").fileinput({
        language : 'zh',//设置语言
        allowedPreviewTypes : [ 'object' ],//允许的预览类型
        allowedFileTypes : [ 'object' ],//允许的文件类型
        allowedFileExtensions : [ 'docx', 'doc','xlsx' ],//允许的文件后缀
        showUpload : false,//是否显示上传按钮
        showCaption : true,//是否显示标题
        browseClass : "btn btn-primary", //按钮样式
        showPreview:true,
        maxFileSize : 20000,//文件最大kb
        maxFileCount : 1,//文件最大数量
        uploadAsync: false,//是否异步上传
    });

    $("#dk_upload").fileinput({
        language : 'zh',//设置语言
        allowedPreviewTypes : [ 'object' ],//允许的预览类型
        allowedFileTypes : [ 'object' ],//允许的文件类型
        allowedFileExtensions : [ 'docx', 'doc','xlsx' ],//允许的文件后缀
        showUpload : false,//是否显示上传按钮
        showCaption : true,//是否显示标题
        browseClass : "btn btn-primary", //按钮样式
        showPreview:true,
        maxFileSize : 20000,//文件最大kb
        maxFileCount : 1,//文件最大数量
        uploadAsync: false,//是否异步上传
    });
    function uploadImage(){
        $("#form").ajaxSubmit(function(data) {
            // 对于表单提交成功后处理，message为返回内容
            alert(data.body.resultContent);
        });
        return false;
    }
</script>
</html>
