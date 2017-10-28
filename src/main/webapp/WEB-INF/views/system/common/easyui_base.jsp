<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-19
  Time: 18:30
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

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/icheck/skins/square/green.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/eap/base/css/base.css" media="all">


<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/js/datagrid-filter.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/icheck/js/icheck.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/eap/base/js/eap.js"></script>

<script type="text/javascript">
    var baseServerUrl = "${pageContext.request.contextPath}/";
</script>