<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-19
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/mdEditor/css/editormd.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/eap/system/css/helpedit.css" />
<html>
<head>
    <header>
        <title>文档编辑</title>
    </header>
</head>
<body>
<div class="row">
    <div class="col-md-11">
        <h1 id="documentTitle" class="site-h1"></h1>
    </div>
    <button id="saveBtn" class="layui-btn" style="margin-top: 20px">保存</button>
</div>
<%--<div id="toc-container" class="markdown-body editormd-preview-container">--%>

<%--</div>--%>
<div class="editormd" id="test-editormd">
    <textarea class="editormd-markdown-textarea" name="test-editormd-markdown-doc"></textarea>
    <!-- 第二个隐藏文本域，用来构造生成的HTML代码，方便表单POST提交，这里的name可以任意取，后台接受时以这个name键为准 -->
    <textarea class="editormd-html-textarea" name="text"></textarea>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/mdEditor/js/editormd.min.js"></script>
<script type="text/javascript">
    var documentId = ${param.documentId};
    layui.use(['layer','form'],function () {
        var layer = layui.layer;
        var form =  layui.form;

        $("#saveBtn").click(function () {
            var markdownText = currEditor.getMarkdown();
            var markdownHtml = currEditor.getHTML();
            $.post(baseServerUrl+"document/edit",{
                documentId:documentId,
                documentMdContent:markdownText
            },function (data,status) {
                if(status=="success"){
                    if(data.body.resultCode=="0"){
                        layer.confirm('保存成功，是否关闭当前编辑窗口？', {
                            btn: ['关闭','取消'] //按钮
                        }, function(){
                            window.close();
                        }, function(){
                            layer.close(layer.index);
                        });
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            })
        });

        var currEditor = editormd("test-editormd", {
            width   : "90%",
            height  : "80%",
            syncScrolling : "single",
            //你的lib目录的路径，我这边用JSP做测试的
            path    : "${pageContext.request.contextPath}/resources/mdEditor/lib/",
            //这个配置在simple.html中并没有，但是为了能够提交表单，使用这个配置可以让构造出来的HTML代码直接在第二个隐藏的textarea域中，方便post提交表单。
            imageUpload : true,
            imageFormats : ["jpg","JPG", "jpeg","JPEG", "gif","GIF", "png","PNG","bmp","BMP","webp","WEBP"],
            imageUploadURL : baseServerUrl+"file/editormdFileUpload",
            crossDomainUpload:false,
            saveHTMLToTextarea : true,
            tex: true, // 默认不解析
            flowChart: true, // 默认不解析
            sequenceDiagram: true, // 默认不解析
            tocContainer : "#toc-container",
            tocDropdown : true,
            tocTitle: "目录",
            onload:function () {
                if(documentId){
                    $.get("${pageContext.request.contextPath}/document/selectOne",{
                        documentId:documentId
                    },function (data,status) {
                        if(status=="success"){
                            if(data.body.resultCode=="0"){
                                $("#documentTitle").text(data.body.entity.documentTitle);
                                this.setMarkdown(data.body.entity.documentMdContent);
                            }else {
                                parent.layer.msg(data.body.resultContent, {icon: 5});
                            }
                        }else {
                            parent.layer.msg('网络错误', {icon: 5});
                        }
                    }.bind(this));
                }
            }
        });
    });

</script>
</html>
