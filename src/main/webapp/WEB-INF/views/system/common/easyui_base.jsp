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

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/easyui/themes/default/easyui.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/easyui/themes/icon.css" media="all" />

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
    var baseServerUrl = "${pageContext.request.contextPath}/";
</script>