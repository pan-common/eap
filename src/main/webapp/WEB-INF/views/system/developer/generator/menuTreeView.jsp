<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-13
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>Title</title>
</head>
<body>
<ul id="tables"></ul>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {
        $.get("${pageContext.request.contextPath}/sysResource/treeView",{
            parentId:0
        },function (data,status) {
            if(status=="success"){
                if(data.body.resultCode=="0"){
                    layui.tree({
                        elem: '#tables', //传入元素选择器
                        nodes:data.body.entity,
                        click: function(node){
                                //关闭录入窗口
                                parent.menuLabel.val(node.name);
                                parent.menuId.val(node.resourceId);
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                        }
                    });
                }
            }else {
                layer.msg('网络错误', {icon: 5});
            }
        })
    });
</script>
</html>
