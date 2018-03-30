<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>jcxm</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">监测项目名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="jcxmmc"  lay-verify="required" placeholder="请输入监测项目名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">监测项目编号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <select id="jcxmbh" name="jcxmbh" layfilter="select_jcxmbh"></select>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">污染物编号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:selectTag parentId="113" id="01"  selectName="wrwbm" nullName="请选择" layfilter="wrwbm" laySearch="true"/>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="jcxmId" type="hidden" name="jcxmId">
    <input id="qybh" type="hidden" name="qybh">
    <input id="jcdbh" type="hidden" name="jcdbh">
</form>
</body>

<script src="${pageContext.request.contextPath}/resources/eap/system/library/CommonSelect.js"></script>
<script type="text/javascript">
    var jcxmId = ${param.jcxmId};
    var url = "${pageContext.request.contextPath}/jcxm/add";
    layui.use(['layer','form'],function () {
        var form = layui.form;
        var layer = layui.layer;
        form.render();

        $("#jcxmbh").CommonSelect("init",{
            layuiForm:form,
            layer:layer,
            datasource:"jcxm",
            params:parent.qybh+","+parent.jcdid,
            onSelect:function (data) {

            }
        });

        if(jcxmId){
            url = "${pageContext.request.contextPath}/jcxm/edit";
            $.get("${pageContext.request.contextPath}/jcxm/selectOne",{
                jcxmId:jcxmId
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
            $("#qybh").val(parent.qybh);
            $("#jcdbh").val(parent.jcdid);
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