<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-6
  Time: 8:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/react/css/district.css" media="all">
<html>
<head>
    <title>Title</title>
    <%--<script src="https://cdn.bootcss.com/react/15.4.2/react.min.js"></script>--%>
    <%--<script src="https://cdn.bootcss.com/react/15.4.2/react-dom.min.js"></script>--%>

    <%--<script src="https://cdn.bootcss.com/babel-standalone/6.22.1/babel.min.js"></script>--%>
</head>
<body>
<div>
    <button>

    </button>
</div>
<div id="example"></div>
<div id="root"></div>
<form id="form" class="layui-form">
    <div id="district">
    </div>
    <button class="layui-btn" lay-submit lay-filter="submitBtn">
        立即提交
    </button>
</form>
</body>
<script src="${pageContext.request.contextPath}/resources/react/js/react.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/js/react-dom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/helloword.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/test.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/district.js"></script>
<script type="text/javascript">
    layui.use(['layer','form'],function () {
        var form = layui.form;
        ReactDOM.render(
            React.createElement(District,
                {
                    url: "area/treeView",
                    layuiForm:form,
                    title:"公司地址",
                    name:"address",
                    province:"140000",
                    onSelect:function (value) {

                    }
                }
            ), document.getElementById('district'));
        form.on("submit(submitBtn)",function (data,status) {
            $.post(baseServerUrl+"test/getAddress",$("#form").serializeArray(),
                function (data,status) {

                });
            return false;
        });
    })
</script>
</html>
