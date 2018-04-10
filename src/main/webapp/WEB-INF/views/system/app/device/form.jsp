<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>device</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">设备类型（1 android 2 苹果）</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <dic:selectTag parentId="248" id="01"  selectName="deviceType" nullName="请选择" layfilter="deviceType"/>
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">设备持有人</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="deviceUser"  lay-verify="required" placeholder="请输入设备持有人" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">描述</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="describe"  lay-verify="required" placeholder="请输入描述" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="deviceId" type="hidden" name="deviceId">
    <input id="deviceBh" type="hidden" name="deviceBh">
    <input id="createTime" type="hidden" name="createTime">
    <input id="updateTime" type="hidden" name="updateTime">
</form>
</body>
<script type="text/javascript">
        var deviceId = ${param.deviceId};
    var url = "${pageContext.request.contextPath}/device/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(deviceId){
            url = "${pageContext.request.contextPath}/device/edit";
            $.get("${pageContext.request.contextPath}/device/selectOne",{
                deviceId:deviceId
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