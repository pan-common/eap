<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-12-11
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="tableTree">

</div>
</body>
<script src="${pageContext.request.contextPath}/resources/react/js/react.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/js/react-dom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/TableTree.js"></script>
<script type="text/javascript">
    layui.use(['layer','form'],function () {

        ReactDOM.render(
            React.createElement(TableTree,
                {
                    url: "sysResource/treeView",
                    param:{parentId:0}
                }
            ), document.getElementById('tableTree'));

    });
</script>
</html>
