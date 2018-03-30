<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-1-15
  Time: 17:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-col-md-offset3 layui-col-md6">
        <form id="form" class="layui-form">
            <table class="layui-table">
                <tr>
                    <td>
                        <input type="text" name="schema" required lay-verify="required" placeholder="请输入数据库名称"
                               autocomplete="off" class="layui-input">
                    </td>
                    <td>
                        <input type="text" name="table" required lay-verify="required" placeholder="请输入表名"
                               autocomplete="off" class="layui-input">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                    <button lay-submit lay-filter="sync_btn" class="layui-btn layui-btn-fluid">生成同步sql</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>

    <div class="layui-col-md-offset3 layui-col-md6" style="margin-top: 20px">
            <textarea id="sync_sql" name="sync_sql" placeholder="生成同步sql" class="layui-textarea">
            </textarea>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.use(['layer','form'],function (layer,form) {
        var form = layui.form;
        var layer = layui.layer;
        form.render();
        form.on("submit(sync_btn)",function (data,status) {
            $.post("${pageContext.request.contextPath}/generator/syncSql.vm",$("#form").serializeArray(),function (data,status) {
                if(status=='success'){
                    if (data.body.resultCode == "0") {
                        $("#sync_sql").val(data.body.entity);
                    } else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            }).error(function (e) {
                layer.msg('网络错误' + e.status, {icon: 5});
            });
            return false;
        });

    });
</script>
</html>
