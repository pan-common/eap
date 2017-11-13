<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>formconfColumn</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">序号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="ordinalPosition"  lay-verify="required" placeholder="请输入序号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">列名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="columName"  lay-verify="required" placeholder="请输入列名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">列注释</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="columnComment"  lay-verify="required" placeholder="请输入列注释" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数据类型</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:selectTag parentId="92" id="01"  selectName="dataType" nullName="请选择" layfilter="dataType"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">列长度</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="columnLength"  lay-verify="${column.verify}" placeholder="请输入列长度" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">是否可以为空</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:radioTag parentId="34" name="isNullAble"></dic:radioTag>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">主键标识</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:radioTag parentId="34" name="columnKey"></dic:radioTag>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="columnId" type="hidden" name="columnId">
    <input id="tableSchema" type="hidden" name="tableSchema">
    <input id="columName" type="hidden" name="columName">
</form>
</body>
<script type="text/javascript">
    var columnId = ${param.columnId};
    var url = "${pageContext.request.contextPath}/formconfColumn/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(columnId){
            url = "${pageContext.request.contextPath}/formconfColumn/edit";
            $.get("${pageContext.request.contextPath}/formconfColumn/selectOne",{
                columnId:columnId
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