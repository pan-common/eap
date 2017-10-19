<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>test</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table class="layui-table">
        <tr>
            <td><label class="layui-form-label">测试1</label></td>
            <td colspan="2">
                <input type="text" name="test1"  lay-verify="required" placeholder="请输入测试1" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">测试2</label></td>
            <td colspan="2">
                <dic:selectTag parentId="43" id="01" nullName="请选择" selectName="test2" layfilter="test2"/>
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">测试3</label></td>
            <td colspan="2">
                <dic:checkboxTag name="test3" parentId="43" />
            </td>
            <td><label class="layui-form-label">测试4</label></td>
            <td colspan="2">
                <input type="checkbox" name="test4" lay-skin="switch" lay-text="开|关">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">测试5</label></td>
            <td colspan="2">
                <dic:radioTag parentId="23" name="test5"></dic:radioTag>
            </td>
            <td><label class="layui-form-label">测试6</label></td>
            <td colspan="2">
                <input type="text" name="test6"  lay-verify="required" placeholder="请输入测试6" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">测试7</label></td>
            <td colspan="2">
                <dic:selectTag parentId="43" id="01" nullName="请选择" selectName="test7" layfilter="test7"/>
            </td>
            <td><label class="layui-form-label">测试8</label></td>
            <td colspan="2">
                <dic:checkboxTag name="test8" parentId="43" checkPositions="all" />
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">测试9</label></td>
            <td colspan="2">
                <dic:radioTag parentId="34" name="test9"></dic:radioTag>
            </td>
        <tr>
            <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
            <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
        </tr>
    </table>

    <input id="id" type="hidden" name="id">
</form>
</body>
<script type="text/javascript">
    var id = ${param.id};
    var url = "${pageContext.request.contextPath}/test/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(id){
            url = "${pageContext.request.contextPath}/test/edit";
            $.get("${pageContext.request.contextPath}/test/selectOne",{
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