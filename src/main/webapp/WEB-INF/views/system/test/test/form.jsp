<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>test</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table class="layui-table">
        <tr>
                            <td><label class="layui-form-label">监测点位</label></td>
            <td colspan="2">
                <input type="text" name="jcdw"  lay-verify="" placeholder="请输入监测点位" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">是否开展监测</label></td>
            <td colspan="2">
                <input type="text" name="sfkzjc"  lay-verify="" placeholder="请输入是否开展监测" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">监测平台是否安全</label></td>
            <td colspan="2">
                <input type="text" name="jcptsfaq"  lay-verify="" placeholder="请输入监测平台是否安全" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">监测点位是否规范</label></td>
            <td colspan="2">
                <input type="text" name="jcdwsfgf"  lay-verify="" placeholder="请输入监测点位是否规范" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">监测因子</label></td>
            <td colspan="2">
                <input type="text" name="jcyz"  lay-verify="" placeholder="请输入监测因子" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">手工监测时间</label></td>
            <td colspan="2">
                <input type="text" name="sgjcsj"  lay-verify="" placeholder="请输入手工监测时间" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">手工监测结果</label></td>
            <td colspan="2">
                <input type="text" name="sgjcjg"  lay-verify="" placeholder="请输入手工监测结果" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">标准编号</label></td>
            <td colspan="2">
                <input type="text" name="bzbh"  lay-verify="" placeholder="请输入标准编号" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">标准限值</label></td>
            <td colspan="2">
                <input type="text" name="bzxz"  lay-verify="" placeholder="请输入标准限值" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">是否超标</label></td>
            <td colspan="2">
                <input type="text" name="sfcb"  lay-verify="" placeholder="请输入是否超标" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">是否安装在线监测</label></td>
            <td colspan="2">
                <input type="text" name="sfazzxjc"  lay-verify="" placeholder="请输入是否安装在线监测" autocomplete="off" class="layui-input">
            </td>
                            <td><label class="layui-form-label">是否联网</label></td>
            <td colspan="2">
                <input type="text" name="sflw"  lay-verify="" placeholder="请输入是否联网" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
                            <td><label class="layui-form-label">同步在线监测结果</label></td>
            <td colspan="2">
                <input type="text" name="tbzxjcjg"  lay-verify="" placeholder="请输入同步在线监测结果" autocomplete="off" class="layui-input">
            </td>
        <tr>
            <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
            <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
        </tr>
    </table>

    <input id="id" type="hidden" name="id">
</form>
</body>
<script type="text/javascript">
        var id = ${param.id};
    var url = "${pageContext.request.contextPath}/test/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(id){
            url = "${pageContext.request.contextPath}/test/edit";
            $.get("${pageContext.request.contextPath}/test/selectOne",{
                id:id
            },function (data,status) {
                    if(status=="success"){
                        if(data.body.resultCode=="0"){
                            $('#form').clearForm();
                            $('#form').form('load',data.body.entity);
                            form.render();
                        }else {
                            parent.layer.msg(data.body.resultContent, {icon: 5});
                        }
                    }else {
                        parent.layer.msg('网络错误', {icon: 5});
                    }
                })
            }
        form.on("submit(submitBtn)",function (data,status) {
            $.post(url,$("#form").serializeArray(),function (data,status) {
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