<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-14
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>表单元素扩展属性</title>
</head>
<body>
<form class="layui-form" style="margin-left: 20px;margin-right: 20px">
    <div id="element_extend">

    </div>
</form>
</body>
<script src="${pageContext.request.contextPath}/resources/react/js/react.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/js/react-dom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/react-eap.js"></script>
<script type="text/javascript">
    var elementId = ${param.elementId};

    layui.use(['layer','form'],function () {
        var form = layui.form;
        var layer = layui.layer;

        var elementExtend = ReactDOM.render(React.createElement(ElementExtend,{
            layuiForm:form
        }),document.getElementById('element_extend'));



    });

</script>
</html>
