<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-30
  Time: 12:24
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
        <div class="col-md-3">
            <button id='addBtn' class="layui-btn layui-btn-small" style="margin-left: 20px">
                <i class="fa fa-plus"></i> 新增数据源
            </button>
            <div id="datasource_layout" style="overflow:auto;">
                <ul id="datasourceTree" class="ztree">

                </ul>
            </div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var layer = layui.layer;
        var form =  layui.form;

        $("#datasource_layout").height($(window).height()-40);

        $("#addBtn").click(function () {
            showModel("新增","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/datasource/dbform&datasourceId=0","550px","550px");
        });

        //弹出录入框
        function showModel(title,url,width,height) {
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
        };

        var datasourceTree;
        var datasourceTreeSetting = {
            async:{
                enable: false,
                type: "get",
                dataType: "json",
                url: "",
                otherParam: {

                }
            },
            view:{
                addDiyDom:addToolbar,
                dblClickExpand : false,
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
                    idKey: "roleId",//节点数据中保存唯一标识的属性名称
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
                onExpand:addNode,
                onClick:addNode
            }
        };

        loadDataSource();

        function loadDataSource(){
            $.get(baseServerUrl+"dataSource/dataSourceTree",{},function (data) {
                $.fn.zTree.init($("#datasourceTree"),datasourceTreeSetting,data.body.entity)
            })
        }

        function addNode(event,treeId,treeNode,clickFlag) {
            var zTree = $.fn.zTree.getZTreeObj("datasourceTree");
            if(treeNode.children.length == 0){
                var type = treeNode.type;
                if(type=="01"){
                    $.post(baseServerUrl+"dataSource/getTablesByDB",{
                        beanName:treeNode.beanName,
                        driverClassName:treeNode.driverClassName,
                        url:treeNode.url,
                        username:treeNode.username,
                        password:treeNode.password
                    },function (data) {
                        zTree.addNodes(treeNode,data.body.entity)
                    });
                }
            }
        }

        function addToolbar(treeId, treeNode) {
            var aObj = $("#" + treeNode.tId + "_a");
            if(treeNode.type=="01"){
                var toolbar = "<div class=\"layui-btn-group\">\n" +
                    "  <button class=\"layui-btn layui-btn-mini\">\n" +
                    "    <i class=\"layui-icon\">&#xe654;</i>\n" +
                    "  </button>\n" +
                    "  <button class=\"layui-btn layui-btn-mini\">\n" +
                    "    <i class=\"layui-icon\">&#xe642;</i>\n" +
                    "  </button>\n" +
                    "  <button class=\"layui-btn layui-btn-mini\">\n" +
                    "    <i class=\"layui-icon\">&#xe640;</i>\n" +
                    "  </button>\n" +
                    "  <button class=\"layui-btn layui-btn-mini\">\n" +
                    "    <i class=\"layui-icon\">&#xe602;</i>\n" +
                    "  </button>\n" +
                    "</div>";
                aObj.append(toolbar);
            }
        }

    });
</script>
</html>
