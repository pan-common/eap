<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>yhysje</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">户名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="hm"  lay-verify="${column.verify}" placeholder="请输入户名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">日期</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="rq"  lay-verify="${column.verify}" placeholder="请输入日期" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">时间</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="sj"  lay-verify="${column.verify}" placeholder="请输入时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">摘要</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="zy"  lay-verify="${column.verify}" placeholder="请输入摘要" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">凭证号码</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="pzhm"  lay-verify="${column.verify}" placeholder="请输入凭证号码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">借方发生额</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="jffse"  lay-verify="${column.verify}" placeholder="请输入借方发生额" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">贷方发生额</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="dffse"  lay-verify="${column.verify}" placeholder="请输入贷方发生额" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">余额</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="ye"  lay-verify="${column.verify}" placeholder="请输入余额" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">对比标识</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="dbbz"  lay-verify="${column.verify}" placeholder="请输入对比标识" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="id" type="hidden" name="id">
    <input id="zh" type="hidden" name="zh">
    <input id="bz" type="hidden" name="bz">
    <input id="kmh" type="hidden" name="kmh">
    <input id="dw" type="hidden" name="dw">
    <input id="pzpc" type="hidden" name="pzpc">
    <input id="cph" type="hidden" name="cph">
    <input id="czyh" type="hidden" name="czyh">
</form>
</body>
<script type="text/javascript">
    var id = ${param.id};
    var url = "${pageContext.request.contextPath}/yhysje/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(id){
            url = "${pageContext.request.contextPath}/yhysje/edit";
            $.get("${pageContext.request.contextPath}/yhysje/selectOne",{
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