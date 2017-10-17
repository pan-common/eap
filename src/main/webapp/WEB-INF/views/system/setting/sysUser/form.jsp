<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>sysUser</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">排序</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="seq"  lay-verify="required" placeholder="请输入排序" autocomplete="off" class="layui-input">
        </div>
    </div>
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="userName"  lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
    </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
        <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                            <input type="text" name="password"  lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
        </div>
    </div>
        </div>
    </div>
        </div>
    </div>
        </div>
    </div>
        </div>
    </div>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block" style="margin-right: 10px">
            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>

    <input id="userId" type="hidden" name="userId">
    <input id="salt" type="hidden" name="salt">
    <input id="locked" type="hidden" name="locked">
    <input id="createTime" type="hidden" name="createTime">
    <input id="updateTime" type="hidden" name="updateTime">
    <input id="valid" type="hidden" name="valid">
    <input id="creater" type="hidden" name="creater">
</form>
</body>
<script type="text/javascript">
    var userId = ${param.userId};
    var url = "${pageContext.request.contextPath}/sysUser/add";
    layui.use(['form'],function () {
        var form = layui.form();
        form.render('select','form');

        if(userId){
            url = "${pageContext.request.contextPath}/sysUser/edit";
            $.get("${pageContext.request.contextPath}/sysUser/selectOne",{
                userId:userId
            },function (data,status) {
                    if(status=="success"){
                        if(data.body.resultCode=="0"){
                            $('#form').clearForm();
                            $('#form').form('load',data.body.entity);
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