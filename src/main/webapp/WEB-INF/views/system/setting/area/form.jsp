<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>area</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table class="layui-table">
        <tr>
            <td><label class="layui-form-label">主键</label></td>
            <td colspan="2">
                <input type="text" name="areaId"  lay-verify="required" placeholder="请输入主键" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">区划名称</label></td>
            <td colspan="2">
                <input type="text" name="areaName"  lay-verify="required" placeholder="请输入区划名称" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">上级区划代码</label></td>
            <td colspan="2">
                <input type="text" name="parentId"  lay-verify="required" placeholder="请输入上级区划代码" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">简写名称</label></td>
            <td colspan="2">
                <input type="text" name="shortName"  lay-verify="required" placeholder="请输入简写名称" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">纬度</label></td>
            <td colspan="2">
                <input type="text" name="lng"  lay-verify="required" placeholder="请输入纬度" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">经度</label></td>
            <td colspan="2">
                <input type="text" name="lat"  lay-verify="required" placeholder="请输入经度" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">1.省 2.市 3.区 4.镇</label></td>
            <td colspan="2">
                <dic:selectTag parentId="63" id="01" nullName="请选择" selectName="level" layfilter="level"/>
            </td>
            <td><label class="layui-form-label">定位</label></td>
            <td colspan="2">
                <input type="text" name="position"  lay-verify="${column.verify}" placeholder="请输入定位" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">排序</label></td>
            <td colspan="2">
                <input type="text" name="sort"  lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input">
            </td>
        <tr>
            <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
            <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
        </tr>
    </table>

</form>
</body>
<script type="text/javascript">
    var areaId = ${param.areaId};
    var url = "${pageContext.request.contextPath}/area/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(areaId){
            url = "${pageContext.request.contextPath}/area/edit";
            $.get("${pageContext.request.contextPath}/area/selectOne",{
                areaId:areaId
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