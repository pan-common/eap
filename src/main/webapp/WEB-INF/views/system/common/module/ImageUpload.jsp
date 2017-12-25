<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-22
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<style type="text/css">
    .image-preview{
        width: auto;
        height: auto;
        max-width: 100%;
        max-height: 100%;
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
        vertical-align:middle;
    }
</style>
<body>
<div style="height: 445px;overflow-y: scroll">
    <table class="layui-table">
        <tbody id="previewTable">
        <tr style="height: 140px">
            <td id="addImageBtn" title="添加图片" style="height: auto;width: 150px;text-align: center;cursor: pointer">
                <i class="fa fa-image fa-5x"></i>
            </td>
        </tr>
        </tbody>
    </table>
</div>
<div align="center">
    <button id="sureBtn" class="layui-btn" style="margin: 10px">确定</button>
    <button id="cancelBtn" class="layui-btn" style="margin: 10px">取消</button>
</div>
</body>
<script type="text/javascript">
    layui.use(['upload'],function () {
        var upload = layui.upload;

        $("#cancelBtn").bind("click",function () {
            //关闭录入窗口
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });

        var uploadInst = upload.render({
            elem:"#addImageBtn",
            url:baseServerUrl+"file/batchPicUpload?v="+$.getUUID(),
            auto:false,
            bindAction:"#sureBtn",
            multiple: true,
            choose:function (obj) {
                var files = obj.pushFile();
                obj.preview(function (index,file,result) {
                    //索引  文件对象  base64编码
                    var fileInfo = file.name+"("+file.size/1000+"KB)";
                    var trs = $("#previewTable").children("tr");
                    if($(trs[trs.length-1]).children("td").length<3){
                        $(trs[trs.length-1]).append('<td style="height: auto;width: 150px">' +
                            '<img class="image-preview" src='+result+'><br><b style="font-size: 10px">'+fileInfo+'</b></td>');
                    }else{
                        $("#previewTable").append('<tr style="height: 140px"><td style="height: auto;width: 150px">' +
                            '<img class="image-preview" src='+result+'><br><label style="font-size: 10px">'+fileInfo+'</label></td></tr>');
                    }
                });
            },
            done:function (response,index,upload) {
                //服务端响应信息、当前文件索引、重新上传方法
                alert(response);
            },
            allDone:function (obj) {
                console.log(obj.total); //得到总文件数
                console.log(obj.successful); //请求成功的文件数
                console.log(obj.aborted); //请求失败的文件数
            },
            error:function (index, upload) {

            }
        });

    });
</script>
</html>
