<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>qyjbxx</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">企业名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input id="qymc" type="text" name="qymc"  lay-verify="required" placeholder="请输入企业名称"
                   autocomplete="off" class="layui-input" onblur="">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">企业编号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <select id="qybh" name="qybh" layfilter="select_qybh"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">爬虫模块</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:commonSelectTag  name="spiderId"  id="01"  dataSource="spider" nullName="请选择" layfilter="spiderId"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">登陆名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="loginName"  lay-verify="required" placeholder="请输入登陆名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="loginPw"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="id" type="hidden" name="id">
</form>
</body>
<script src="${pageContext.request.contextPath}/resources/eap/system/library/CommonSelect.js"></script>
<script type="text/javascript">
    var id = ${param.id};
    var url = "${pageContext.request.contextPath}/qyjbxx/add";
    layui.use(['layer','form'],function () {
        var form = layui.form;
        form.render();

        $("#qymc").blur(function () {
            var qymc = $(this).val();
            $("#qybh").CommonSelect("init",{
                layuiForm:form,
                layer:layer,
                datasource:"qybh",
                params:qymc,
                onSelect:function (data) {

                }
            });
        });

        if(id){
            url = "${pageContext.request.contextPath}/qyjbxx/edit";
            $.get("${pageContext.request.contextPath}/qyjbxx/selectOne",{
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