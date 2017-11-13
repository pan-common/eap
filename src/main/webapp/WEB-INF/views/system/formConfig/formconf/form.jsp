<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>formconf</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">序号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="seq"  lay-verify="number" placeholder="请输入序号" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">表单名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="formName"  lay-verify="required" placeholder="请输入表单名称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">表单别名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="formAlias"  lay-verify="required" placeholder="请输入表单别名" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">表单备注</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="formNote"  lay-verify="" placeholder="请输入表单备注" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">表单类型</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <dic:selectTag parentId="87" id="01"  selectName="formType" nullName="请选择" layfilter="formType"/>
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">表单状态</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="formStatus"  lay-verify="" placeholder="请输入表单状态" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="formId" type="hidden" name="formId">
</form>
</body>
<script type="text/javascript">
        var formId = ${param.formId};
    var url = "${pageContext.request.contextPath}/formconf/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(formId){
            url = "${pageContext.request.contextPath}/formconf/edit";
            $.get("${pageContext.request.contextPath}/formconf/selectOne",{
                formId:formId
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