<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>sysRole</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">排序</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="seq"  lay-verify="number" placeholder="请输入排序" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">角色名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="name"  lay-verify="required" placeholder="请输入角色名称" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="roleId" type="hidden" name="roleId">
    <input id="updateTime" type="hidden" name="updateTime">
    <input id="parentId" type="hidden" name="parentId">
    <input id="createTime" type="hidden" name="createTime">
    <input id="valid" type="hidden" name="valid">
    <input id="creater" type="hidden" name="creater">
</form>
</body>
<script type="text/javascript">
    ;
    var roleId = ${param.roleId};
    var url = "${pageContext.request.contextPath}/sysRole/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render('select','form');

        if(roleId){
            url = "${pageContext.request.contextPath}/sysRole/edit";
            $.get("${pageContext.request.contextPath}/sysRole/selectOne",{
                roleId:roleId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $('#form').clearForm();
                        $('#form').form('load',data.body.entity);
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