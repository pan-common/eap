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
<form id="form" class="layui-form" style="margin-left: 20px;margin-right: 20px">
    <div id="element_extend">

    </div>
    <div>
        <table style="width: 100%;margin-top: 20px">
            <tr style="text-align: center">
                <td style="margin-left: 20px;margin-right: 20px">
                    <button id="submitBtn" lay-submit lay-filter="submitBtn" style="width: 200px" class="layui-btn">提交</button>
                </td>
                <td style="margin-left: 20px;margin-right: 20px">
                    <button id="cancelBtn" type="button" style="width: 200px" class="layui-btn">取消</button>
                </td>
            </tr>
        </table>
    </div>
</form>
</body>
<script src="${pageContext.request.contextPath}/resources/react/js/react.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/js/react-dom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/react-eap.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/TableEdit.js"></script>
<script type="text/javascript">
    var elementId = ${param.elementId};

    layui.use(['layer','form'],function () {
        var form = layui.form;
        var layer = layui.layer;

        var tableEdit = ReactDOM.render(React.createElement(TableEdit,{
            layuiForm:form,
            layuiLayer:layer,
            url:"elementExtend/elementExtendList",
            method:"GET",
            queryParams:function () {
                var params = {
                    elementId:elementId
                };
                return params;
            },
            columns:[
                {
                    title:"属性字段",
                    field:"extendField",
                    width:100,
                    inputType:"text"
                },
                {
                    title:"属性名",
                    field:"extendName",
                    width:140,
                    inputType:"text"
                },
                {
                    title:"字段类型",
                    field:"extendType",
                    width:200,
                    inputType:"text"
                },
                {
                    title:"备注",
                    field:"note",
                    width:100,
                    inputType:"text"
                }
            ]
        }),document.getElementById('element_extend'));

        $("#cancelBtn").click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });

        form.on("submit(submitBtn)",function (data,status) {
            $.ajax({
                url:baseServerUrl+'elementExtend/addList',
                data:$("#form").serializeArray(),
                type:'post',
                dataType:'json',
                headers:{
                    Accept:"application/json",
                    "Content-Type":"application/json"
                },
                processData:false,
                cache:false,
                success:function (data) {
                    if(data.body.resultCode=="0"){
                        //关闭录入窗口
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.refreshTable();
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                },
                error:function (e) {
                    parent.layer.msg('错误'+e.message, {icon: 5});
                }
            });

            $.post(baseServerUrl+"elementExtend/addList",$("#form").serializeArray(),function (data,status) {
                if(status=='success'){
                    if(data.body.resultCode=="0"){
                        //关闭录入窗口
                        var index = parent.layer.getFrameIndex(window.name);
                        parent.layer.close(index);
                        parent.refreshTable();
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    parent.layer.msg('网络错误', {icon: 5});
                }
            }).error(function (e) {
                parent.layer.msg('网络错误'+e.status, {icon: 5});
            });
            return false;
        });

    });

</script>
</html>
