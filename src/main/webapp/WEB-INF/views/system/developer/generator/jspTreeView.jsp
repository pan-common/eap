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
<ul id="tables"></ul>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {

        $.get("${pageContext.request.contextPath}/generator/jspTreeView",{

        },function (data,status) {
            if(status=="success"){
                if(data.body.resultCode=="0"){
                    layui.tree({
                        elem: '#tables', //传入元素选择器
                        nodes:data.body.entity,
                        click: function(node){
                            if(node.type=="05"){
                                //关闭录入窗口
                                parent.pagePath.val(node.packageName);
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.layer.close(index);
                            }
                        }
                    });
                }else {
                    layer.msg(data.body.resultContent, {icon: 5});
                }
            }else {
                layer.msg('网络错误', {icon: 5});
            }
        });
    });
</script>
</html>