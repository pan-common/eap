<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-9-22
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="/WEB-INF/tld/eap.tld" prefix="dic"%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">

<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/eap/base/image/computer.png" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap-table/css/bootstrap-table.min.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap3-editable/css/bootstrap-editable.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui-v1.09/css/layui.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui-v1.09/css/global.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/font-awesome/css/font-awesome.min.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/ztree/css/metroStyle/metroStyle.css" media="all">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/eap/base/css/base.css" media="all">



<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.form.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui-v1.09/layui.all.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/layui-v1.09/js/validator.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-table/js/bootstrap-table.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-table/js/bootstrap-table-editable.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ztree/js/jquery.ztree.all.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/ztree/js/jquery.ztree.exhide.min.js"></script>
<script type="text/javascript">
    var baseServerUrl = "${pageContext.request.contextPath}/";
</script>
