<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>registItem</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <div class="layui-form-item">
        <label class="layui-form-label">名称</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:selectTag parentId="69" id="01"  selectName="name" layfilter="name"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">数量</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="quantity"  lay-verify="number" placeholder="请输入数量" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">登记类型</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <dic:selectTag parentId="74" id="01"  selectName="type" nullName="请选择" layfilter="type"/>
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">登记时间</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="registerTime" id="registerTime"  lay-verify="date" placeholder="请输入登记时间" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="id" type="hidden" name="id">
</form>
</body>
<script type="text/javascript">
    var id = ${param.id};
    var url = "${pageContext.request.contextPath}/registItem/add";
    layui.use(['laydate','form'],function () {
        var form = layui.form;
        var laydate = layui.laydate;
        form.render();

        //执行一个laydate实例
        laydate.render({
            elem: '#registerTime',//指定元素
            type:'date'
        });

        if(id){
            url = "${pageContext.request.contextPath}/registItem/edit";
            $.get("${pageContext.request.contextPath}/registItem/selectOne",{
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