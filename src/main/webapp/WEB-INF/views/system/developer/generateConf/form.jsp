<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>generateConf</title>
</head>
<body>
<form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
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

    <input id="tableName" type="hidden" name="tableName">
    <input id="alias" type="hidden" name="alias">
    <input id="aliasUse" type="hidden" name="aliasUse">
    <input id="packageName" type="hidden" name="packageName">
    <input id="projectPath" type="hidden" name="projectPath">
    <input id="pagePath" type="hidden" name="pagePath">
    <input id="isTree" type="hidden" name="isTree">
    <input id="configId" type="hidden" name="configId">
    <input id="driverClass" type="hidden" name="driverClass">
    <input id="connectionUrl" type="hidden" name="connectionUrl">
    <input id="userId" type="hidden" name="userId">
    <input id="tableSchema" type="hidden" name="tableSchema">
    <input id="filePath" type="hidden" name="filePath">
    <input id="deleteWay" type="hidden" name="deleteWay">
    <input id="pageFilePath" type="hidden" name="pageFilePath">
    <input id="generateItems" type="hidden" name="generateItems">
    <input id="parentField" type="hidden" name="parentField">
    <input id="nameField" type="hidden" name="nameField">
    <input id="formColumnNum" type="hidden" name="formColumnNum">
    <input id="menuId" type="hidden" name="menuId">
    <input id="password" type="hidden" name="password">
    <input id="menuName" type="hidden" name="menuName">
    <input id="columnExtendId" type="hidden" name="columnExtendId">
</form>
</body>
<script type="text/javascript">
    ;
    var configId = ${param.configId};
    var url = "${pageContext.request.contextPath}/generateConf/add";
    layui.use(['form'],function () {
        var form = layui.form;
        form.render('select','form');

        if(configId){
            url = "${pageContext.request.contextPath}/generateConf/edit";
            $.get("${pageContext.request.contextPath}/generateConf/selectOne",{
                configId:configId
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