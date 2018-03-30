<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>jcxmjg</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">主键</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="id"  lay-verify="${column.verify}" placeholder="请输入主键" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">在线结果ID</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="zxjgId"  lay-verify="${column.verify}" placeholder="请输入在线结果ID" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">污染物编码</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="wrwbm"  lay-verify="${column.verify}" placeholder="请输入污染物编码" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">浓度</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="nd"  lay-verify="${column.verify}" placeholder="请输入浓度" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">折算浓度</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="zsnd"  lay-verify="${column.verify}" placeholder="请输入折算浓度" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">总量</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="zl"  lay-verify="${column.verify}" placeholder="请输入总量" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

</form>
</body>
<script type="text/javascript">
        var id = ${param.id};
    var url = "${pageContext.request.contextPath}/jcxmjg/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(id){
            url = "${pageContext.request.contextPath}/jcxmjg/edit";
            $.get("${pageContext.request.contextPath}/jcxmjg/selectOne",{
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