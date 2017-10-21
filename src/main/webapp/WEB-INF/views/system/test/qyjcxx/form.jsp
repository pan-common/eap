<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>qyjcxx</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table class="layui-table">
        <tr>
                            <td><label class="layui-form-label">监测日期</label></td>
            <td colspan="2">
                <input type="text" name="jcrq"  lay-verify="" placeholder="请输入监测日期" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">省</label></td>
            <td colspan="2">
                <input type="text" name="shen"  lay-verify="" placeholder="请输入省" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">市</label></td>
            <td colspan="2">
                <input type="text" name="shi"  lay-verify="" placeholder="请输入市" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">县</label></td>
            <td colspan="2">
                <input type="text" name="xian"  lay-verify="" placeholder="请输入县" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">企业名称</label></td>
            <td colspan="2">
                <input type="text" name="qymc"  lay-verify="" placeholder="请输入企业名称" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">行业类型</label></td>
            <td colspan="2">
                <input type="text" name="hylx"  lay-verify="" placeholder="请输入行业类型" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">污染防治设施是否正常运行</label></td>
            <td colspan="2">
                <input type="text" name="wrfzss"  lay-verify="" placeholder="请输入污染防治设施是否正常运行" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">运行问题描述</label></td>
            <td colspan="2">
                <input type="text" name="yxwtms"  lay-verify="" placeholder="请输入运行问题描述" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">是否存在数据造假行为</label></td>
            <td colspan="2">
                <input type="text" name="sfczsjzj"  lay-verify="" placeholder="请输入是否存在数据造假行为" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">造假问题描述</label></td>
            <td colspan="2">
                <input type="text" name="zjwtms"  lay-verify="" placeholder="请输入造假问题描述" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">是否存在严重跑冒滴漏</label></td>
            <td colspan="2">
                <input type="text" name="sfczyzpmdl"  lay-verify="" placeholder="请输入是否存在严重跑冒滴漏" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">跑冒滴漏问题描述</label></td>
            <td colspan="2">
                <input type="text" name="pmdlwtms"  lay-verify="" placeholder="请输入跑冒滴漏问题描述" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
            <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
        </tr>
    </table>

    <input id="id" type="hidden" name="id">
    <input id="parentId" type="hidden" name="parentId">
</form>
</body>
<script type="text/javascript">
        var id = ${param.id};
    var url = "${pageContext.request.contextPath}/qyjcxx/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(id){
            url = "${pageContext.request.contextPath}/qyjcxx/edit";
            $.get("${pageContext.request.contextPath}/qyjcxx/selectOne",{
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