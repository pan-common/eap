<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-30
  Time: 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="layui-form">
    <dic:commonSelectTag name="datasource" id="datasource" dataSource="datasource"></dic:commonSelectTag>
</form>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var form =  layui.form;
        form.render();



    });
</script>
</html>
