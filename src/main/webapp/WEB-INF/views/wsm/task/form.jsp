<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>创建任务</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-col-lg12">
        <fieldset class="layui-elem-field">
            <legend>创建任务</legend>
            <form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
                <div class="layui-form-item">
                    <label class="layui-form-label">任务名称</label>
                    <div class="layui-input-block" style="margin-right: 10px;width: 600px">
                        <input type="text" name="taskName"  lay-verify="required" placeholder="请输入任务名称" autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">任务内容</label>
                    <div class="layui-input-block" style="margin-right: 10px;width: 600px">
                        <textarea name="taskContent" rows="5" cols="20" class="layui-textarea" placeholder="请输入任务内容"></textarea>
                    </div>
                </div>
                <div  class="layui-form-item">
                    <label class="layui-form-label">任务行政区</label>
                    <div id="district" class="layui-input-block" style="margin-right: 10px;width: 600px">
                    </div>
                </div>
                <div class="layui-form-item" hidden="true">
                    <label class="layui-form-label">任务地区</label>
                    <div class="layui-input-inline" style="margin-right: 10px;width: 320px">
                        <div class="layui-row layui-col-space12">
                            <div class="layui-col-md8">
                                <ul id="selectTree" class="ztree">
                                </ul>
                            </div>
                            <div class="layui-col-md3">
                                <button id="selectDistrictBtn" type="button" class="layui-btn">
                                    选择
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">开始日期</label>
                    <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                        <input type="text" class="layui-input" name="startTime" id="startTime">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">主要负责人</label>
                    <div class="layui-input-inline" style="margin-right: 10px;width: 320px">
                        <div class="layui-row layui-col-space12">
                            <div class="layui-col-md8">
                                <input id="principal_name" type="text" name="principal_name"  lay-verify="required" placeholder="请选择主要负责人" autocomplete="off" class="layui-input">
                            </div>
                            <div class="layui-col-md3">
                                <button id="selectBtn" type="button" class="layui-btn">
                                    选择
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">成员</label>
                    <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                        <button id="addBtn" class="layui-btn layui-btn-sm" type="button">
                            <i class="fa fa-plus">&nbsp&nbsp添加</i>
                        </button>
                    </div>
                </div>
                <div class="layui-row">
                    <table id="memberTab" class="layui-table" style="width: 500px;margin-left: 150px">
                        <tr id="memberTr">
                        </tr>
                    </table>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">任务备注</label>
                    <div class="layui-input-block" style="margin-right: 10px;width: 600px">
                        <textarea name="remarks" rows="3" cols="20" class="layui-textarea" placeholder="请输入任务备注"></textarea>
                    </div>
                </div>
                <div class="layui-form-item">
                    <div class="layui-input-block" style="margin-right: 10px">
                        <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
                        <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                    </div>
                </div>

                <input id="taskId" type="hidden" name="taskId">
                <input id="principal" type="hidden" name="principal.userId">

                <div id="memberInputs">

                </div>

                <div id="areaInputs">

                </div>

                <input id="sheng" type="hidden" name="taskSheng">
                <input id="shi" type="hidden" name="taskShi">
                <input id="xian" type="hidden" name="taskXian">

            </form>
        </fieldset>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/eap/system/library/District.js"></script>
<script type="text/javascript">
    var taskId = "${param.taskId}";
    var url = "${pageContext.request.contextPath}/task/add";

    var startDate = moment().format('YYYY-MM-DD');

    layui.use(['form','laydate'],function () {
        var form = layui.form;
        var laydate = layui.laydate;

        laydate.render({
            elem:'#startTime',
            range:false,
            format: 'yyyy-MM-dd',
            value:moment().format('YYYY-MM-DD'),
            theme: 'grid',
            done:function (value,date) {
                startDate = value;
            }
        });

        //三级区划
        $('#district').District('init',{
            layuiForm:form,
            layer:layer,
            level:2,
            onSelect:function (level,value) {

            },
            onSelectResult:function (sheng,shi,xian) {
                $("#sheng").val(sheng);
                $("#shi").val(shi);
                $("#xian").val(xian);
            }
        });

        //选择行政区
        $("#selectDistrictBtn").click(function () {
            showModel("选择行政区划","${pageContext.request.contextPath}/sysResource/link?url=wsm/task/selectDistrict&taskId="+taskId,"800px","600px");
        });

        //选择主要负责人
        $("#selectBtn").click(function () {
            showModel("选择主要负责人","${pageContext.request.contextPath}/sysResource/link?url=wsm/task/selectUser","800px","500px");
        });
        //添加成员
        $("#addBtn").click(function () {
            showModel("添加成员","${pageContext.request.contextPath}/sysResource/link?url=wsm/task/addMember","800px","500px")
        });

        form.render();

        //弹出录入框
        function showModel(title,url,width,height) {
            var index = layer.open({
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
            });
        };

        if(taskId&&taskId!='0'){
            url = "${pageContext.request.contextPath}/task/edit";
            $.get("${pageContext.request.contextPath}/task/selectOne",{
                taskId:taskId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $('#form').clearForm();
                        $('#form').form('load',data.body.entity);

                        var sheng = data.body.entity.taskSheng;
                        var shi = data.body.entity.taskShi;
                        var xian = data.body.entity.taskXian;
                        $('#district').District("setValue",sheng,shi,xian);

                        $("#principal_name").val(data.body.entity.principal.fullName);
                        $("#principal").val(data.body.entity.principal.userId);
                        //显示成员
                        addMember(data.body.entity.baseInfos);
                        //显示区划
                        var arr = "";
                        var areas = data.body.entity.areas;
                        for (var i = 0; i < areas.length; i++) {
                            if(i==0){
                                arr+=areas[i].areaId;
                            }else {
                                arr+=","+areas[i].areaId;
                            }
                        }
                        submitArea(arr);
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

    //选择主要负责人
    function selectPrincipal(data) {
        $("#principal_name").val(data[0].fullName);
        $("#principal").val(data[0].userId);
    }

    var datas = [];
    function addMember(data) {
        $("#memberTr").empty();
        $("#memberInputs").empty();
        datas = datas.concat(data);
        for (var i = 0; i < datas.length; i++) {
            var row = '<td align="center" style="width: 50px">'+datas[i].fullName+'</td>';
            $("#memberTr").append(row);
            var input = '<input id="taskId" type="hidden" name="baseInfos['+i+'].userId" value="'+datas[i].userId+'">'
            $("#memberInputs").append(input);
        }
    }

    var selectTree;
    var selectSetting = {
        async:{
            enable: false,
            type: "get",
            dataType: "json",
            url: "",
            autoParam: [],
            otherParam: {
                "":0
            }
        },
        view:{
            selectedMulti: false,//是否允许选中多个节点
            txtSelectedEnable: true,//是否可以选择zTree DOM内的文本
            nameIsHTML: true,//设置name属性是否支持HTML脚本
        },
        data:{
            keep:{
                leaf: false,//如果设置为 true，则所有 isParent = false 的节点，都无法添加子节点。
                parent: false//如果设置为 true，则所有 isParent = true 的节点，即使该节点的子节点被全部删除或移走，依旧保持父节点状态。
            },
            key:{
                checked: "checked",//zTree 节点数据中保存 check 状态的属性名称。
                children: "children",//zTree 节点数据中保存子节点数据的属性名称。
                name: "areaName",//zTree 节点数据保存节点名称的属性名称。
                title: "",//zTree 节点数据保存节点提示信息的属性名称。
                url: "",//zTree 节点数据保存节点链接的目标 URL 的属性名称。
                icon:"zIcon"
            },
            simpleData:{
                enable: true,//确定 zTree 初始化时的节点数据为简单array数据
                idKey: "areaId",//节点数据中保存唯一标识的属性名称
                pIdKey: "parentId",//节点数据中保存其父节点唯一标识的属性名称。
                rootPId: 0//用于修正根节点父节点数据，即 pIdKey 指定的属性值
            }
        },
        callback:{

        }
    };

    /**
     * 提交区划数据
     * @param areaIds
     */
    var parentAreaIds = [];
    var parentAreaIdsStr = "";
    function submitArea(areaIds) {
        $("#areaInputs").empty();
        if(areaIds){
            parentAreaIdsStr = areaIds;
            parentAreaIds = areaIds.split(",");
        }
        if(parentAreaIds){
            for (var i = 0; i < parentAreaIds.length; i++) {
                var areaId = parentAreaIds[i];
                var input = '<input type="hidden" name="areas['+i+'].areaId" value="'+parentAreaIds[i]+'">'
                $("#areaInputs").append(input);
            }

            $.get(baseServerUrl+"area/getTreeByAreaIds",{
                areaIds:areaIds
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        selectTree = $.fn.zTree.init($("#selectTree"), selectSetting,data.body.entity);
                        selectTree.expandAll(false);
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            })
        }
    }

</script>
</html>