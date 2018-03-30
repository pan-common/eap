<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>dmsctest</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">测试名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="testName"  lay-verify="${column.verify}" placeholder="请输入测试名称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">测试1</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="test1"  lay-verify="${column.verify}" placeholder="请输入测试1" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">测试2</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="test2"  lay-verify="${column.verify}" placeholder="请输入测试2" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">测试3</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="test3"  lay-verify="${column.verify}" placeholder="请输入测试3" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">测试4</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="test4"  lay-verify="${column.verify}" placeholder="请输入测试4" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="testId" type="hidden" name="testId">
</form>
</body>
<script type="text/javascript">
        var testId = ${param.testId};
    var url = "${pageContext.request.contextPath}/dmsctest/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(testId){
            url = "${pageContext.request.contextPath}/dmsctest/edit";
            $.get("${pageContext.request.contextPath}/dmsctest/selectOne",{
                testId:testId
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