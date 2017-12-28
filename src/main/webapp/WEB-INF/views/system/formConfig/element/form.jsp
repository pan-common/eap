<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>element</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">元素名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="elementName"  lay-verify="required" placeholder="请输入元素名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">元素类型</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:selectTag parentId="97" id="01"  selectName="elementType" nullName="请选择" layfilter="elementType"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">js模板路径</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="jsTemplatePath"  lay-verify="" placeholder="请输入js模板路径" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">html模板路径</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="htmlTemplatePath"  lay-verify="" placeholder="请输入html模板路径" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">元素处理类</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="elementClass"  lay-verify="" placeholder="请输入元素处理类" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="elementId" type="hidden" name="elementId">
    <input id="parentId" type="hidden" name="parentId">
    <input id="createTime" type="hidden" name="createTime">
    <input id="updateTime" type="hidden" name="updateTime">
    <input id="creater" type="hidden" name="creater">
    <input id="valid" type="hidden" name="valid">
</form>
</body>
<script type="text/javascript">
    var elementId = ${param.elementId};
    var url = "${pageContext.request.contextPath}/element/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(elementId){
            url = "${pageContext.request.contextPath}/element/edit";
            $.get("${pageContext.request.contextPath}/element/selectOne",{
                elementId:elementId
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

            $.ajax({
                url:baseServerUrl+'qyjcxx/easyuiSubmitData',
                data:JSON.stringify(effectRow),
                type:'post',
                dataType:'json',
                headers:{
                    Accept:"application/json",
                    "Content-Type":"application/json"
                },
                processData:false,
                cache:false,
                success:function (data) {
                    if (data.body.resultCode == "0") {
                        $('#datagrid').datagrid('reload');
                    }else {
                        $.messager.alert('提示',body.resultContent);
                    }
                },
                error:function (e) {
                    $.messager.alert('提示',e.message);
                }
            });
            return false;
        });

    });
</script>
</html>