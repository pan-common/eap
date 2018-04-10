<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-4-2
  Time: 16:29
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
        <label class="layui-form-label">期数</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" name="value"  lay-verify="required" placeholder="请输入期数" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">开始日期</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" class="layui-input" name="param1" id="param1">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">结束日期</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
            <input type="text" class="layui-input" name="param2" id="param2">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="dicId" type="hidden" name="dicId">
    <input id="seq" type="hidden" name="seq">
    <input id="keystone" type="hidden" name="keystone">
    <input id="parentId" type="hidden" name="parentId">
</form>
</body>
<script type="text/javascript">
    var startDate = moment().format('YYYY-MM-DD');
    var endDate = moment().format('YYYY-MM-DD');
    var dicId = ${param.dicId};
    var url = "${pageContext.request.contextPath}/task/addIssue";
    layui.use(['form','laydate'],function () {
        var form = layui.form;
        var laydate = layui.laydate;

        form.render('select','form');

        if(dicId){
            url = "${pageContext.request.contextPath}/task/editIssue";
            $.get("${pageContext.request.contextPath}/dictionary/selectOne",{
                dicId:dicId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $('#form').clearForm();
                        $('#form').form('load',data.body.entity);
                        parent.refreshTable();
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    parent.layer.msg('网络错误', {icon: 5});
                }
            });
        }

        laydate.render({
            elem:'#param1',
            range:false,
            format: 'yyyy-MM-dd',
            value:moment().format('YYYY-MM-DD'),
            theme: 'grid',
            done:function (value,date) {
                startDate = value;
            }
        });
        laydate.render({
            elem:'#param2',
            range:false,
            format: 'yyyy-MM-dd',
            value:moment().format('YYYY-MM-DD'),
            theme: 'grid',
            done:function (value,date) {
                endDate = value;
            }
        });

        $("#parentId").val(parent.currentId);
        form.on("submit(submitBtn)",function (data,status) {
            $.post(url,data.field,function (data,status) {
                if(status=='success'){
                    if(data.body.resultCode == '0'){
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



    })
</script>
</html>
