<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-1-23
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
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table id="table" class="layui-table">
        <thead>
        <tr>
            <td>方案编号</td>
            <td>方案名称</td>
            <td>方案版本号</td>
            <td>方案开始时间</td>
            <td>方案状态</td>
            <td width="100px">选择</td>
        </tr>
        </thead>
        <tbody id="tbody" class="layui-table-body">

        </tbody>
    </table>
</form>
<script type="text/javascript">
    var qybh = "${param.qybh}";
    var vid = "${param.vid}";
    layui.use(['layer','form'],function () {
        var form = layui.form;
        $.get("${pageContext.request.contextPath}/qyjbxx/selectQyfaxx",{
            qybh:qybh
        },function (data,status) {
            if(status=="success"){
                if(data.body.resultCode=="0"){
                    $("#tbody").empty();
                    var qyfaxxs = data.body.entity;
                    var trs = [];
                    var checked = "";
                    for (var i = 0; i < qyfaxxs.length; i++) {
                        if(vid){
                            if(qyfaxxs[i].vid==vid){
                                checked = "checked";
                            }else {
                                checked = "";
                            }
                        }else {
                            if(i==0){
                                checked = "checked";
                            }else {
                                checked = "";
                            }
                        }
                        trs.push('<tr><td>'+qyfaxxs[i].vid+'</td><td>'+qyfaxxs[i].famc+'</td><td>'
                            +qyfaxxs[i].version+'</td><td>'+qyfaxxs[i].fakssj+'</td><td>'
                            +qyfaxxs[i].zt+'</td><td width="100px"><input type="radio" name="vid" value="'+qyfaxxs[i].vid+'" lay-filter="vid" '+checked+'></td></tr>');
                    }
                    $("#tbody").append(trs.join(""));
                    form.render();

                    form.on('radio(vid)',function (data) {
                        $.post("${pageContext.request.contextPath}/qyjbxx/updateQyfaxx",{
                            vid:data.value,
                            qybh:qybh
                        },function (data,status) {
                            if(status=="success"){
                                if(data.body.resultCode=="0"){
                                    layer.msg(data.body.entity, {icon: 1});
                                }else {
                                    parent.layer.msg(data.body.resultContent, {icon: 5});
                                }
                            }else {
                                parent.layer.msg('网络错误', {icon: 5});
                            }
                        })
                    });

                }else {
                    parent.layer.msg(data.body.resultContent, {icon: 5});
                }
            }else {
                parent.layer.msg('网络错误', {icon: 5});
            }
        });

    })
</script>
</body>
</html>
