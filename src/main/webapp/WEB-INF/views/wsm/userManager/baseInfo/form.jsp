<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>baseInfo</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table class="layui-table">
        <tr>
            <td><label class="layui-form-label">姓名</label></td>
            <td colspan="2">
                <input type="text" name="fullName"  lay-verify="required" placeholder="请输入姓名" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">电话号码</label></td>
            <td colspan="2">
                <input type="text" name="phoneNumber"  lay-verify="phone" placeholder="请输入电话号码" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">单位</label></td>
            <td colspan="2">
                <dic:selectTag parentId="227" id="01" nullName="请选择" selectName="organId" layfilter="nation"/>
            </td>
            <td><label class="layui-form-label">职称</label></td>
            <td colspan="2">
                <dic:selectTag parentId="218" id="02" nullName="请选择" selectName="jobTitle" layfilter="education"/>
            </td>
        </tr>

        <tr>
            <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
            <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
        </tr>
    </table>

    <input id="baseId" type="hidden" name="baseId">
    <input id="valid" type="hidden" name="valid" value="1">
</form>
</body>
<script type="text/javascript">
    var baseId = "${param.baseId}";
    var url = "${pageContext.request.contextPath}/baseInfo/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(baseId&&baseId!='0'){
            url = "${pageContext.request.contextPath}/baseInfo/edit";
            $.get("${pageContext.request.contextPath}/baseInfo/selectOne",{
                baseId:baseId
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
            $("#baseId").val(baseId);
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