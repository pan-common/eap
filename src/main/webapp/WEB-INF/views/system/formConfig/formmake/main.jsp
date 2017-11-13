<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-9
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6">
            <form class="layui-form">
                <table class="layui-table" lay-skin="line">
                    <tr>
                        <td><label>表单：</label></td>
                        <td>
                            <dic:commonSelectTag id="selectForm" dataSource="formconf" nullName="请选择"
                                                 name="formconfId" param="" layfilter="selectForm"/>
                        </td>
                        <td><label>版本：</label></td>
                        <td>
                            <%--<dic:commonSelectTag id="selectFormVersion" dataSource="formVersion" nullName="请选择"--%>
                            <%--name="formVersionId" param="" layfilter="selectFormVersion"/>--%>
                            <div id="selectFormVersion"></div>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3" style="text-align: center">
            <button id="selectTableBtn" class="layui-btn layui-btn-big" align="center">
                <i class="fa fa-plus"></i>&nbsp;&nbsp;添加数据库表
            </button>
        </div>
        <div class="col-md-9">

        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/react/js/react.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/js/react-dom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/react-eap.js"></script>
<script type="text/javascript">
    var formconfId = 0;
    var formVersionId = 0;
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var layer = layui.layer;
        var form = layui.form;

        var formVersionSelect = ReactDOM.render(React.createElement(CommonSelect,{
            layuiForm:form,
            dataSource:"formVersion",
            params:"",
            onSelect:function (value) {
                formVersionId = value;
            }
        }),document.getElementById('selectFormVersion'));

        form.on("select(selectForm)",function (data) {
            formVersionSelect.refreshData(data.value);
        });

        $("#selectTableBtn").click(function () {
            if(formVersionId){
                showSelectTableModel("添加数据库表","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/formmake/selectTable",
                    $(window).width(),$(window).height());
            }else {
                layer.msg("请选择表单和对应版本", {icon: 5});
            }
        });

        //选择数据库表弹窗
        function showSelectTableModel(title,url,width,height) {
            layer.open({
                id:"model",
                type:2,
                title:title,
                content:url,
                area:[width,height],
                offset: '0px',
                shade:false,
                maxmin:true,
                success:function (layero, index) {

                }
            })
        }

    });
</script>
</html>
