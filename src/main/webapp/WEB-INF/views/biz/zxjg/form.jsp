<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>zxjg</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
    <table class="layui-table">
        <tr>
            <td><label class="layui-form-label">颗粒物浓度</label></td>
            <td colspan="2">
                <input type="text" name="klwnd"  lay-verify="" placeholder="请输入颗粒物浓度" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">颗粒物折算浓度</label></td>
            <td colspan="2">
                <input type="text" name="klwzsnd"  lay-verify="" placeholder="请输入颗粒物折算浓度" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">颗粒物总量</label></td>
            <td colspan="2">
                <input type="text" name="klwzl"  lay-verify="" placeholder="请输入颗粒物总量" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">二氧化硫浓度</label></td>
            <td colspan="2">
                <input type="text" name="eyhlnd"  lay-verify="" placeholder="请输入二氧化硫浓度" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">二氧化硫折算浓度</label></td>
            <td colspan="2">
                <input type="text" name="eyhlzsnd"  lay-verify="" placeholder="请输入二氧化硫折算浓度" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">二氧化硫总量</label></td>
            <td colspan="2">
                <input type="text" name="eyhlzl"  lay-verify="" placeholder="请输入二氧化硫总量" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">氮氧化物浓度</label></td>
            <td colspan="2">
                <input type="text" name="dyhwnd"  lay-verify="" placeholder="请输入氮氧化物浓度" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">氮氧化物折算浓度</label></td>
            <td colspan="2">
                <input type="text" name="dyhwzsnd"  lay-verify="" placeholder="请输入氮氧化物折算浓度" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">氮氧化物总量</label></td>
            <td colspan="2">
                <input type="text" name="dyhwzl"  lay-verify="" placeholder="请输入氮氧化物总量" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">标杆流量</label></td>
            <td colspan="2">
                <input type="text" name="bgll"  lay-verify="" placeholder="请输入标杆流量" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">氧量</label></td>
            <td colspan="2">
                <input type="text" name="yl"  lay-verify="" placeholder="请输入氧量" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">烟温</label></td>
            <td colspan="2">
                <input type="text" name="yw"  lay-verify="" placeholder="请输入烟温" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">含湿量</label></td>
            <td colspan="2">
                <input type="text" name="hsl"  lay-verify="" placeholder="请输入含湿量" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">故障信息</label></td>
            <td colspan="2">
                <input type="text" name="gzxx"  lay-verify="" placeholder="请输入故障信息" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td><label class="layui-form-label">备注</label></td>
            <td colspan="2">
                <input type="text" name="bz"  lay-verify="" placeholder="请输入备注" autocomplete="off" class="layui-input">
            </td>
            <td><label class="layui-form-label">是否运行</label></td>
            <td colspan="2">
                <input type="text" name="sfyz"  lay-verify="" placeholder="请输入是否运行" autocomplete="off" class="layui-input">
            </td>
        </tr>
        <tr>
            <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
            <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
        </tr>
    </table>

    <input id="zxjgId" type="hidden" name="zxjgId">
    <input id="qybh" type="hidden" name="qybh">
    <input id="qymc" type="hidden" name="qymc">
    <input id="jcdbh" type="hidden" name="jcdbh">
    <input id="jcdmc" type="hidden" name="jcdmc">
    <input id="sj" type="hidden" name="sj">
</form>
</body>
<script type="text/javascript">
    var zxjgId = ${param.zxjgId};
    var url = "${pageContext.request.contextPath}/zxjg/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render();

        if(zxjgId){
            url = "${pageContext.request.contextPath}/zxjg/edit";
            $.get("${pageContext.request.contextPath}/zxjg/selectOne",{
                zxjgId:zxjgId
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