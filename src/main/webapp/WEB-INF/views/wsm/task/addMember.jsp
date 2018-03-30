<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2018-3-5
  Time: 17:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <table id='bootstrapTable'>
        </table>
    </div>
    <div class="layui-row">
        <button id="sureBtn" type="button" class="layui-btn" style="width: 200px">确定</button>
        <button id="cancelBtn" type="button" class="layui-btn" style="width: 200px">取消</button>
    </div>
</div>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {

        $("#sureBtn").click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
            var data = $('#bootstrapTable').bootstrapTable('getAllSelections');
            parent.addMember(data);
        });

        $("#cancelBtn").click(function () {
            var index = parent.layer.getFrameIndex(window.name);
            parent.layer.close(index);
        });

        $('#bootstrapTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/baseInfo/list",
            method:'GET',
            height:$(window).height()-$("#topLayout").height()-70,
            toolbar:"#toolbar",
            striped : true, //是否显示行间隔色
            cache : true, //是否使用缓存
            pagination : true, //是否显示分页（*）
            queryParams : queryParams,//传递参数（*）
            queryParamsType : 'limit',
            sidePagination : 'server', //分页方式
            pageNumber : 1, //初始化加载第一页，默认第一页
            pageSize : 15, //每页的记录行数（*）
            pageList : [ 10, 15, 20, 50 ], //可供选择的每页的行数（*）
            search : true,//是否显示表格搜索
            searchAlign : "right",//指定搜索框位置
            dataField:"list",
            totalField:"total",
            searchOnEnterKey : true,
            strictSearch : true,
            showRefresh : true, //是否显示刷新按钮
            showColumns : false, //是否显内容列下拉框
            showPaginationSwitch : false,//是否显示 数据条数选择框
            minimumCountColumns : 2, //最少允许的列数
            clickToSelect : true, //是否启用点击选中行
            uniqueId : "baseId", //每一行的唯一标识，一般为主键列
            singleSelect : false,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title:"姓名",
                    field:"fullName",
                    width:100
                },
                {
                    title:"性别",
                    field:"gender",
                    width:100
                },
                {
                    title:"电话号码",
                    field:"phoneNumber",
                    width:100
                }],
            onLoadError : function(status) { //加载失败时执行
                $.messager.show({
                    title : 'Error',
                    msg : "数据加载失败"
                });
            },
            formatSearch: function () {
                return '输入关键字查询';
            }
        });
        function queryParams(params) {
            var param = {
                pageSize : params.limit, //页面大小
                pageNum : this.pageNumber, //页码
                searchText : params.search,
            }
            return param;
        }

    });
</script>
</html>
