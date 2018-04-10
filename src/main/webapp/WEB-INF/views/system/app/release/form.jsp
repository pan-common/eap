<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>release</title>
</head>
<body>
<form id="form" enctype="multipart/form-data" action="${pageContext.request.contextPath}/release/add" method="post" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">版本号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="version"  lay-verify="required" placeholder="请输入版本号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">更新内容</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="content"  lay-verify="required" placeholder="请输入更新内容" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">上传应用</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input id="upload" name="upload" type="file" multiple data-show-caption="true">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" type="button" id="submitBtn" onclick="uploadFile()">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="versionId" type="hidden" name="versionId">
    <input id="url" type="hidden" name="url">
    <input id="updatetime" type="hidden" name="updatetime">
    <input id="fileId" type="hidden" name="fileId">
</form>
</body>
<script type="text/javascript">
    var versionId = "${param.versionId}";
    var url = "${pageContext.request.contextPath}/release/add";
    layui.use(['form'],function () {
        var form = layui.form;

        form.render();
        //文件上传插件
        $("#upload").fileinput({
            language : 'zh',//设置语言
            allowedPreviewTypes : [ 'object' ],//允许的预览类型
            allowedFileTypes : [ 'object' ],//允许的文件类型
            allowedFileExtensions : [ 'docx', 'doc','xlsx' ],//允许的文件后缀
            showUpload : false,//是否显示上传按钮
            showCaption : true,//是否显示标题
            browseClass : "layui-btn", //按钮样式
            removeClass : "layui-btn",//移除按钮样式
            showPreview:false,
            maxFileSize : 0,//文件最大kb 0表示不限制文件大小
            maxFileCount : 1,//文件最大数量
            uploadAsync: false,//是否异步上传
        });

        if(versionId){
            url = "${pageContext.request.contextPath}/release/edit";
            $.get("${pageContext.request.contextPath}/release/selectOne",{
                versionId:versionId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $('#form').clearForm();
                        $('#form').form('load',data.body.entity);
                        form.render();
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    parent.layer.msg('网络错误', {icon: 5});
                }
            })
        }

    });

    function uploadFile() {
        $("#form").ajaxSubmit(function (data) {
            if(data.body.resultCode=="0"){
                //关闭录入窗口
                var index = parent.layer.getFrameIndex(window.name);
                parent.layer.close(index);
                parent.refreshTable();
            }else {
                parent.layer.msg(data.body.resultContent, {icon: 5});
            }
        });
        return false;
    }

</script>
</html>