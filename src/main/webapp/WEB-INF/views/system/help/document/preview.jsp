<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-20
  Time: 16:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mdEditor/css/editormd.min.css" />
<html>
<head>
    <title>Document</title>
</head>
<style type="text/css">
    .catalog-layout{
        margin: 5px;
        border:1px solid #ddd;
        background-color:#fff;
        padding:20px;
        box-shadow:0 0 10px rgba(0,0,0,0.1);
    }
    .preview-layout{
        margin-top: 5px;
        border:1px solid #ddd;
        background-color:#fff;
        padding:20px;
        box-shadow:0 0 10px rgba(0,0,0,0.1);
    }
</style>
<body>
<div class="row">
    <div id="catalog-view" class="col-md-3 catalog-layout" style="margin-left: 65px;overflow: auto;overflow-x:hidden">
        <ul id="ztree" class="ztree">
        </ul>
    </div>
    <div id="preview-view" class="col-md-8 preview-layout" >
        <div class="row">
            <%--<div class="col-md-2" id="toc-container">--%>
            <%--</div>--%>
            <div class="col-md-10" style="text-align: center">
                <h1 id="documentTitle" class="site-h1">文档</h1>
            </div>
            <div class="col-md-2" id="tool-view" style="float: right;padding-bottom: 20px">
                <button id="editBtn" class="layui-btn" ><i class="fa fa-edit"></i></button>
                <button id="refreshBtn" class="layui-btn"><i class="fa fa-refresh"></i></button>
            </div>
        </div>
        <div  id="editormd-view" style="overflow: auto;overflow-x:hidden">
            <textarea style="display:none;" name="test-editormd-markdown-doc"></textarea>
        </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/marked.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/prettify.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/raphael.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/underscore.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/sequence-diagram.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/flowchart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/lib/jquery.flowchart.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/js/editormd.min.js"></script>
<script type="text/javascript">
    var mainTree;

    layui.use([ 'layer', 'form' ], function(layer, form) {

        $("#editormd-view").height($(window).height()-$("#tool-view").height()-80);
        $("#catalog-view").height($(window).height()-60);

        var setting = {
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
            check:{
                enable: true,
                chkStyle: "radio",
                radioType: "all"
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
                beforeCheck:function (treeId,treeNode) {
                    return treeNode.documentType=='02'?true:false;
                },
                beforeClick:function (treeId,treeNode,clickFlag) {
                    return treeNode.documentType=='02'?true:false;
                },
                onClick:function (event,treeId,treeNode,clickFlag) {
                    mainTree.checkNode(treeNode,!treeNode.checked);
                    $('#editormd-view').empty();
                    if(treeNode.checked){
                        getDocumentContent(treeNode.documentId)
                    }
                },
                onCheck:function (event,treeId,treeNode) {
                    $('#editormd-view').empty();
                    if(treeNode.checked){
                        getDocumentContent(treeNode.documentId)
                    }
                }
            }
        };

        function getDocumentContent(documentId) {
            $.get("${pageContext.request.contextPath}/document/selectOne",{
                documentId:documentId
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        $("#documentTitle").text(data.body.entity.documentTitle);

                        editormd.markdownToHTML("editormd-view", {
                            markdown: data.body.entity.documentMdContent ,
                            htmlDecode: "style,script,iframe",
                            emoji: true,
                            taskList: true,
                            tex: true, // 默认不解析
                            flowChart: true, // 默认不解析
                            sequenceDiagram: true, // 默认不解析
                            codeFold: true,
                        });
                    }else {
                        parent.layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    parent.layer.msg('网络错误', {icon: 5});
                }
            });
        };

        $("#editBtn").bind("click",function () {
            if(mainTree.getCheckedNodes().length==1){
                var documentId = mainTree.getCheckedNodes()[0].documentId;
                window.open (baseServerUrl+"sysResource/link?url=system/help/helpEdit&documentId="+documentId);
            }else {
                layer.msg("请选中要编辑的节点",{icon:5});
            }
        });

        $("#refreshBtn").bind("click",function () {
            if(mainTree.getCheckedNodes().length==1){
                $('#editormd-view').empty();
                var documentId = mainTree.getCheckedNodes()[0].documentId;
                getDocumentContent(documentId)
            }
        });

        $.get("${pageContext.request.contextPath}/document/treeView",{
            parentId:0
        },function (data,status) {
            if(status=="success"){
                if(data.body.resultCode=="0"){
                    mainTree = $.fn.zTree.init($("#ztree"), setting,data.body.entity);
                    mainTree.expandAll(true);
                }else {
                    layer.msg(data.body.resultContent, {icon: 5});
                }
            }else {
                layer.msg('网络错误', {icon: 5});
            }
        });



    });
</script>
</html>
