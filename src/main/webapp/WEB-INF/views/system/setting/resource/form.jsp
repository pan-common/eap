<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-9-22
  Time: 11:31
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
    <div class="layui-form-item">
        <label class="layui-form-label">序号</label>
        <div class="layui-input-block" style="margin-right: 10px">
            <input type="text" name="seq" required  lay-verify="number" placeholder="请输入序号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">资源名称</label>
        <div class="layui-input-block" style="margin-right: 10px">
            <input type="text" name="name" required  lay-verify="required" placeholder="请输入资源名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">选择资源类型</label>
        <div class="layui-input-block" style="margin-right: 10px">
            <dic:selectTag parentId="23" id="typeCode" nullName="请选择" selectName="typeCode" layfilter="typeCode"/>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">资源图标</label>
        <div class="layui-input-block" style="margin-right: 10px">
            <input type="text" name="icon" placeholder="请输入资源图标代码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">链接</label>
        <div class="layui-input-block" style="margin-right: 10px">
            <input type="text" name="link" required  lay-verify="required" placeholder="请输入链接" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">备注</label>
        <div class="layui-input-block" style="margin-right: 10px">
            <input type="text" name="note" placeholder="请输入备注" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <input id="resourceId" type="hidden" name="resourceId">
    <input id="parentId" type="hidden" name="parentId">
    <input id="typeDesc" type="hidden" name="typeDesc">
</form>
</body>
<script type="text/javascript">
    var resourceId = ${param.resourceId};
    var url = "${pageContext.request.contextPath}/resource/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render('select','form');

        $("#typeDesc").val($("#typeCode").find("option:selected").text());

        if(resourceId){
            url = "${pageContext.request.contextPath}/resource/edit";
            $.get("${pageContext.request.contextPath}/resource/selectOne",{
                resourceId:resourceId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $('#form').clearForm();
                        $('#form').form('load',data.body.entity);
                        form.render('select','form');
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    parent.layer.msg('网络错误', {icon: 5});
                }
            })
        }

        $("#parentId").val(parent.currentId);
        form.on("submit(submitBtn)",function (data,status) {
            $.post(url,data.field,function (data,status) {
                if(status=='success'){
                    if(data.body.resultCode=="0"){
                        //关闭录入窗口
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.refreshTable();
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    parent.layer.msg('网络错误', {icon: 5});
                }
            }).error(function (e) {
                parent.layer.msg('网络错误'+e.status, {icon: 5});
            });
            return false;
        });
        form.on('select(typeCode)', function(data){
            var value = data.value;
            var text = data.elem.options[data.elem.options.selectedIndex].text;
            $("#typeDesc").val(text);
        });
    });
</script>
</html>
