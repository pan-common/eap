<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-9
  Time: 15:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-4">
            <form class="layui-form">
                <table class="layui-table">
                    <tr>
                        <td>
                            <dic:commonSelectTag id="selectDatasource" dataSource="datasource"
                                                 name="datasource" layfilter="selectDatasource" nullName="请选择数据源"
                                                 param=""/>
                        </td>
                        <td>
                            <button id="createBtn" type="button" class="layui-btn layui-btn-small">
                                <i class="fa fa-plus"></i>&nbsp;&nbsp;创建
                            </button>
                        </td>
                        <td>
                            <button id="changeBtn" type="button" class="layui-btn layui-btn-small">
                                <i class="fa fa-refresh"></i>&nbsp;&nbsp;切换
                            </button>
                        </td>
                    </tr>
                </table>
                <ul id="datasourceTrees" style="height: 550px;overflow:auto;">
                </ul>
            </form>
        </div>
        <div class="col-md-8">
            <table id='bootstrapTable'>
            </table>
        </div>
    </div>
</div>
</body>
<script src="${pageContext.request.contextPath}/resources/react/js/react.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/js/react-dom.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/react/build/react-eap.js"></script>
<script type="text/javascript">
    var datasource;
    layui.use(['layer', 'form'], function (layer, form) {
        $("#datasourceTrees").height($(window).height()-100);

        var layer = layui.layer;
        var form = layui.form;
        form.render();

        var schema = "";//当前选中的schema
        var table = "";//当前选中的表

        form.on("select(selectDatasource)", function (data) {
            datasource = data.value;
            if (datasource) {
                $.get("${pageContext.request.contextPath}/dataSource/changeDataSource", {
                    datasource: datasource
                }, function (data, status) {
                    if (status == "success") {
                        if (data.body.resultCode == "0") {

                        } else {
                            parent.layer.msg(data.body.resultContent, {icon: 5});
                        }
                    } else {
                        parent.layer.msg('网络错误', {icon: 5});
                    }
                });
            }
        });

        $("#createBtn").click(function () {

        });

        $("#changeBtn").click(function () {
            if (datasource) {
                $.get("${pageContext.request.contextPath}/dataSource/tableTree", {
                    datasource: datasource
                }, function (data, status) {
                    if (status == "success") {
                        if (data.body.resultCode == "0") {
                            $("#datasourceTrees").empty();
                            layui.tree({
                                elem: '#datasourceTrees', //传入元素选择器
                                nodes: data.body.entity,
                                click: function (node) {
                                    if (node.type == "03") {
                                        schema = node.tSchema;
                                        table = node.tName;
                                        refreshTable();
                                    }
                                }
                            });
                        } else {
                            parent.layer.msg(data.body.resultContent, {icon: 5});
                        }
                    } else {
                        parent.layer.msg('网络错误', {icon: 5});
                    }
                });
            } else {
                layer.msg("请先选择数据源!", {icon: 5});
            }
        });
        //表结构
        $('#bootstrapTable').bootstrapTable({
            url: "${pageContext.request.contextPath}/generator/getColumns",
            height: $(window).height() - 100,
            method: 'GET',
            toolbar: "#toolbar",
            striped: true, //是否显示行间隔色
            cache: false, //是否使用缓存
            pagination: false, //是否显示分页（*）
            queryParams: queryParams,//传递参数（*）
            queryParamsType: 'limit',
            sidePagination: 'server', //分页方式
            pageNumber: 1, //初始化加载第一页，默认第一页
            pageSize: 15, //每页的记录行数（*）
            pageList: [10, 15, 20, 50], //可供选择的每页的行数（*）
            search: false,//是否显示表格搜索
            searchAlign: "right",//指定搜索框位置
            dataField: "list",
            totalField: "total",
            searchOnEnterKey: false,
            strictSearch: false,
            showRefresh: true, //是否显示刷新按钮
            showColumns: false, //是否显内容列下拉框
            showPaginationSwitch: false,//是否显示 数据条数选择框
            minimumCountColumns: 2, //最少允许的列数
            clickToSelect: false, //是否启用点击选中行
            uniqueId: "resourceId", //每一行的唯一标识，一般为主键列
            singleSelect: false,//设置true禁止多选
            showToggle: false, //是否显示详细视图和列表视图的切换按钮
            cardView: false, //是否显示详细视图
            detailView: false, //是否显示父子表
            showHeader: true,//是否显示列头
            showFooter: false,//是否显示列脚
            contentType: "application/x-www-form-urlencoded", //解决POST提交问题
            columns: [{checkbox: true},
                {
                    title: "序号",
                    field: "ordinalPosition",
                }, {
                    title: "列名",
                    field: "columnName",
                }, {
                    title: "是否可为空",
                    field: "isNullAble"
                }, {
                    title: "数据类型",
                    field: "columnType"
                }, {
                    title: "注释",
                    field: "columnComment"
                }, {
                    title: "主键",
                    field: "columnKey"
                }],
            onLoadError: function (status) { //加载失败时执行
                $.messager.show({
                    title: 'Error',
                    msg: "数据加载失败"
                });
            },
            formatSearch: function () {
                return '输入权限名称或权限表达式查询';
            }
        });

        function queryParams(params) {
            var param = {
                pageSize: params.limit, //页面大小
                pageNum: this.pageNumber, //页码
                searchText: params.search,
                schema: schema,
                table: table,
            }
            return param;
        }

        function refreshTable() {
            $('#bootstrapTable').bootstrapTable('refresh');
        }

    });
</script>
</html>
