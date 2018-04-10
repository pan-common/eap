<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>ConfigTree</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">排序</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="seq"  lay-verify="" placeholder="请输入序号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="title"  lay-verify="" placeholder="请输入标题" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">图标图片</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="image"  lay-verify="" placeholder="请输入图标图片" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">跳转页面 类名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="jumpPage"  lay-verify="" placeholder="请输入跳转页面 类名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">类型</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:selectTag parentId="252" id="01"  selectName="configType" nullName="请选择" layfilter="type"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">使用的view类名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="view"  lay-verify="" placeholder="请输入使用的view类名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="id" type="hidden" name="id">
    <input id="parentId" type="hidden" name="parentId">
</form>
</body>
<script type="text/javascript">
    var id = "${param.id}";
    var url = "${pageContext.request.contextPath}/ConfigTree/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(id!='0'){
            url = "${pageContext.request.contextPath}/ConfigTree/edit";
            $.get("${pageContext.request.contextPath}/ConfigTree/selectOne",{
                id:id
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
        $("#parentId").val(parent.currentId);
        form.on("submit(submitBtn)",function (data,status) {
            $.post(url,$("#form").serializeArray(),function (data,status) {
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

    });
</script>
</html>