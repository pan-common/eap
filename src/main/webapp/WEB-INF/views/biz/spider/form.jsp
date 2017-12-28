<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>spider</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">模块名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="spiderName"  lay-verify="required" placeholder="请输入模块名称" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">登陆页</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="landingPage"  lay-verify="required" placeholder="请输入登陆页" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">爬虫模块类名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="spiderClass"  lay-verify="required" placeholder="请输入爬虫模块类名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="spiderId" type="hidden" name="spiderId">
</form>
</body>
<script type="text/javascript">
        var spiderId = ${param.spiderId};
    var url = "${pageContext.request.contextPath}/spider/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(spiderId){
            url = "${pageContext.request.contextPath}/spider/edit";
            $.get("${pageContext.request.contextPath}/spider/selectOne",{
                spiderId:spiderId
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