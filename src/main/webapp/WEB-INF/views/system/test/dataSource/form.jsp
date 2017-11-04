<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>dataSource</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">Data Source</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <dic:selectTag parentId="78" id="01"  selectName="datasourceType" nullName="请选择" layfilter="datasourceType"/>
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">springBean名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="beanName"  lay-verify="required" placeholder="请输入springBean名称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">连接名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="connectName"  lay-verify="required" placeholder="请输入连接名称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">驱动名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="driverClassName"  lay-verify="required" placeholder="请输入驱动名称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">链接地址</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="url"  lay-verify="required" placeholder="请输入链接地址" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="username"  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="password"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="datasourceId" type="hidden" name="datasourceId">
</form>
</body>
<script type="text/javascript">
        var datasourceId = ${param.datasourceId};
    var url = "${pageContext.request.contextPath}/dataSource/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(datasourceId){
            url = "${pageContext.request.contextPath}/dataSource/edit";
            $.get("${pageContext.request.contextPath}/dataSource/selectOne",{
                datasourceId:datasourceId
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