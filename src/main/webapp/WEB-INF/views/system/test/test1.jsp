<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
</head>
<body>
<table>
    <tr>
        <td><label class="layui-form-label">包名包名</label></td>
        <td><input type="text" name="packageName" required  lay-verify="required"  class="layui-input"></td>
        <td style="padding: 2px"><button id="1" class="layui-btn layui-btn-small">选择</button></td>

        <td><label class="layui-form-label">包名</label></td>
        <td><input type="text" name="packageName" required  lay-verify="required"  class="layui-input"></td>
        <td style="padding: 2px"><button id="2" class="layui-btn layui-btn-small">选择</button></td>
    </tr>
    <tr>
        <td><label class="layui-form-label">包名</label></td>
        <td><input type="text" name="packageName" required  lay-verify="required"  class="layui-input"></td>
        <td style="padding: 2px"><button id="3" class="layui-btn layui-btn-small">选择</button></td>

        <td><label class="layui-form-label">包名</label></td>
        <td><input type="text" name="packageName" required  lay-verify="required"  class="layui-input"></td>
        <td style="padding: 2px"><button id="4" class="layui-btn layui-btn-small">选择</button></td>
    </tr>
</table>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {

    });
</script>
</html>