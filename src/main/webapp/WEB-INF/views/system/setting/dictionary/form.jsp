<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-9-24
  Time: 11:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">序号</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="seq" required  lay-verify="number" placeholder="请输入序号" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <label class="layui-form-label">键</label>
            <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                <input type="text" name="keystone" required  lay-verify="required" placeholder="请输入键名" autocomplete="off" class="layui-input">
            </div>
        </div>
        <div class="layui-input-inline">
            <label class="layui-form-label">值</label>
            <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                <input id="value" type="text" name="value" required  lay-verify="required" placeholder="请输入值名" autocomplete="off" class="layui-input">
            </div>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">参数一</label>
                <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                    <textarea name="param1" placeholder="请输入参数一" class="layui-textarea"></textarea>
                </div>
            </div>
        </div>
        <div class="layui-input-inline">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">参数二</label>
                <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                    <textarea name="param2" placeholder="请输入参数二" class="layui-textarea"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">参数三</label>
                <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                    <textarea name="param3" placeholder="请输入参数三" class="layui-textarea"></textarea>
                </div>
            </div>
        </div>
        <div class="layui-input-inline">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">参数四</label>
                <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                    <textarea name="param4" placeholder="请输入参数四" class="layui-textarea"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-inline">
        <div class="layui-input-inline">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">参数五</label>
                <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                    <textarea name="param5" placeholder="请输入参数五" class="layui-textarea"></textarea>
                </div>
            </div>
        </div>
        <div class="layui-input-inline">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">参数六</label>
                <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                    <textarea name="param6" placeholder="请输入参数六" class="layui-textarea"></textarea>
                </div>
            </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
    <input id="dicId" type="hidden" name="dicId">
    <input id="parentId" type="hidden" name="parentId">
</form>
</body>
<script type="text/javascript">
    var dicId = ${param.dicId};
    var url = "${pageContext.request.contextPath}/dictionary/add";
    layui.use(['form'],function () {
        var form = layui.form();
        form.render('select','form');
        if(dicId){
            url = "${pageContext.request.contextPath}/dictionary/edit";
            $.get("${pageContext.request.contextPath}/dictionary/selectOne",{
                dicId:dicId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $('#form').clearForm();
                        $('#form').form('load',data.body.entity);
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
            $.post(url,data.field,function (data,status) {
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
        form.on('select(typeCode)', function(data){
            var value = data.value;
            var text = data.elem.options[data.elem.options.selectedIndex].text;
            $("#typeDesc").val(text);
        });
    });
</script>
</html>
