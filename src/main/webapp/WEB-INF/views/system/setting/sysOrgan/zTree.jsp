<%--
Created by IntelliJ IDEA.
User: panho
Date: 2017-10-15
Time: 14:42
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
<table class="table table-bordered">
    <tr>
        <td align="center" rowspan="4" style="width: 200px">
            <ul id="mainTree" class="ztree">
            </ul>
        </td>
        <td style="width: 200px;text-align:center;vertical-align:middle;">
            <button class="layui-btn layui-btn-small" onclick="">全选</button>
        </td>
        <td align="center" rowspan="4" style="width: 200px">
            <ul id="selectTree" class="ztree">
            </ul>
        </td>
    </tr>
    <tr>
        <td style="width: 200px;text-align:center;vertical-align:middle;">
            <button class="layui-btn layui-btn-small" onclick="">全选</button>
        </td>
    </tr>
    <tr>
        <td style="width: 200px;text-align:center;vertical-align:middle;">
            <button class="layui-btn layui-btn-small" onclick="">全选</button>
        </td>
    </tr>
    <tr>
        <td style="width: 200px;text-align:center;vertical-align:middle;">
            <button class="layui-btn layui-btn-small" onclick="">全选</button>
        </td>
    </tr>
</table>
</body>
<script type="text/javascript">
    var userId = ${param.userId};
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var mainSetting = {
            async:{
                enable: true,
                type: "get",
                dataType: "json",
                url: "${pageContext.request.contextPath}/sysOrgan/treeView",
                otherParam: {
                    parentId:0
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
                    name: "name",//zTree 节点数据保存节点名称的属性名称。
                    title: "",//zTree 节点数据保存节点提示信息的属性名称。
                    url: ""//zTree 节点数据保存节点链接的目标 URL 的属性名称。
                },
                simpleData:{
                    enable: false,//确定 zTree 初始化时的节点数据为简单array数据
                    idKey: "organId",//节点数据中保存唯一标识的属性名称
                    pIdKey: "parentId",//节点数据中保存其父节点唯一标识的属性名称。
                    rootPId: 0//用于修正根节点父节点数据，即 pIdKey 指定的属性值
                }
            },
            check:{
                enable: true,
                chkStyle: "checkbox",
                chkboxType: { "Y": "s", "N": "s" }
            },
            callback:{
                onAsyncSuccess:function (event, treeId, treeNode, data) {
                    if(data.body.resultCode=="0"){
                        mainTree = $.fn.zTree.init($("#mainTree"), mainSetting,data.body.entity);
                        mainTree.expandAll(true);

                        $.get("",{
                            userId:userId
                        },function (data, state) {

                        });
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                },
                onCheck:function (event, treeId, treeNode) {
                    var nodes = selectTree.getNodesByParam("isHidden", true);
                    selectTree.showNodes(nodes);

                    $("selectTree").empty();
                    var mainNodes = mainTree.getCheckedNodes(true);
                    for (var i = 0;i<mainNodes.length();i++){
                        var node = mainTree.getNodeByParam("organId",mainNodes[i].organId);
                    }
                }
            }
        };

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
                    name: "name",//zTree 节点数据保存节点名称的属性名称。
                    title: "",//zTree 节点数据保存节点提示信息的属性名称。
                    url: ""//zTree 节点数据保存节点链接的目标 URL 的属性名称。
                },
                simpleData:{
                    enable: false,//确定 zTree 初始化时的节点数据为简单array数据
                    idKey: "organId",//节点数据中保存唯一标识的属性名称
                    pIdKey: "parentId",//节点数据中保存其父节点唯一标识的属性名称。
                    rootPId: 0//用于修正根节点父节点数据，即 pIdKey 指定的属性值
                }
            },
            callback:{
                onCheck:showSelectTree
            }
        };

        var mainTree;
        var selectTree;
        //显示左侧
        mainTree = $.fn.zTree.init($("#mainTree"), mainSetting);

        function showSelectTree(event, treeId, treeNode) {
            $("selectTree").empty();
            var mainNodes = mainTree.getCheckedNodes(true);
            var organIds = "";
            if(mainNodes>0) {
                for (var i = 0; i < mainNodes.length; i++) {
                    organIds += mainNodes[i].organId;
                }
            }
            $.get("",{
                organIds:organIds
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        selectTree = $.fn.zTree.init($("#selectTree"), selectSetting,data.body.entity);
                        selectTree.expandAll(true);
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            })
        }
    });

</script>
</html>
