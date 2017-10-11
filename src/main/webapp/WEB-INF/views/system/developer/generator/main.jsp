<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title></title>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-3">
            <ul id="tables"></ul>
        </div>
        <div class="col-md-9">
            <div class="row">
                <div class="layui-tab layui-tab-card">
                    <ul class="layui-tab-title">
                        <li class="layui-this">全局参数配置</li>
                        <li>数据库属性</li>
                        <li>页面属性</li>
                        <li>表单属性</li>
                    </ul>
                    <div id="tab_content" class="layui-tab-content">
                        <div class="layui-tab-item layui-show">
                            <form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
                                <table>
                                    <tr>
                                        <td><label class="layui-form-label">数据库</label></td>
                                        <td colspan="2"><input type="text" id="schema" name="schema" readOnly="true" class="layui-input"></td>

                                        <td><label class="layui-form-label">表名</label></td>
                                        <td colspan="2"><input type="text" id="tableName" name="tableName" readOnly="true" class="layui-input"></td>
                                    </tr>
                                    <tr>
                                        <td><label class="layui-form-label">包名</label></td>
                                        <td><input id="packageName" type="text" name="packageName" readOnly="true"  class="layui-input"></td>
                                        <td><button id="selectPackage" class="layui-btn layui-btn-small">选择</button></td>

                                        <td><label class="layui-form-label">页面路径</label></td>
                                        <td><input id="pagePath" type="text" name="pagePath"  readOnly="true"  class="layui-input"></td>
                                        <td><button id="selectPagePath" class="layui-btn layui-btn-small">选择</button></td>
                                    </tr>
                                    <tr>
                                        <td><label class="layui-form-label">删除方式</label></td>
                                        <td colspan="2">
                                            <div>
                                                <input required  lay-verify="required" type="radio" name="deleteWay" value="01" title="逻辑">
                                                <input required  lay-verify="required" type="radio" name="deleteWay" value="02" title="物理" checked>
                                            </div>
                                        </td>

                                        <td><label class="layui-form-label">别名</label></td>
                                        <td><input type="text" name="alias" placeholder="请输入别名" required  lay-verify="required" class="layui-input"></td>
                                        <td>
                                            <label class="layui-form-label">作为包名</label>
                                            <input type="checkbox" name="aliasUse" lay-skin="switch" lay-text="开|关" value="1" checked>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td><label class="layui-form-label">生成项</label></td>
                                        <td colspan="5">
                                            <dic:checkboxTag name="generateItems" parentId="37" checkPositions="all" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" align="center"><button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button></td>
                                        <td colspan="3" align="center"><button type="reset" class="layui-btn layui-btn-primary">重置</button></td>
                                    </tr>
                                </table>
                                <input type="hidden" id="driverClass" name="driverClass">
                                <input type="hidden" id="connectionURL" name="connectionURL">
                                <input type="hidden" id="userId" name="userId">
                                <input type="hidden" id="password" name="password">
                            </form>
                        </div>
                        <div class="layui-tab-item">
                            <table id='bootstrapTable'>
                            </table>
                        </div>
                        <div id="topLayout" class="layui-tab-item">
                            <div  id="toolbar">
                                <button id='initBtn' class="layui-btn layui-btn-small">
                                    <i class="layui-icon">&#xe608;</i> 初始化
                                </button>
                            </div>
                            <table id='ColumnExtendTable'>
                            </table>
                        </div>
                        <div class="layui-tab-item">
                            <table id='ColumnExtendFormTable'>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    var url = "${pageContext.request.contextPath}/generator/execute";
    var packageName = $("#packageName");
    var pagePath = $("#pagePath");
    $("#tab_content").height($(window).height()-80);
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var schema = "";
        var table = "";

        var form = layui.form();
        form.render();

        $("#initBtn").click(function () {
            $.post("${pageContext.request.contextPath}/generator/init",{
                schema:schema,
                table:table
            },function (data,status) {
                if(status=='success'){
                    if(data.body.resultCode=="0"){
                        layer.msg("初始化成功");
                        refreshColumnExtendTable();
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            }).error(function (e) {
                layer.msg('网络错误'+e.status, {icon: 5});
            });
        })

        $("#selectPackage").click(function () {
            showModel("选择包目录","${pageContext.request.contextPath}/resource/link?url=system/developer/generator/treeView");
        });

        $("#selectPagePath").click(function () {
            showModel("选择包目录","${pageContext.request.contextPath}/resource/link?url=system/developer/generator/jspTreeView");
        })

        //弹出录入框
        function showModel(title,url) {
            layer.open({
                id:"model",
                type:2,
                title:title,
                content:url,
                area:["500px","550px"],
                offset: '0px',
                shade:false,
                maxmin:true,
                success:function (layero, index) {

                }
            })
        };

        form.on("submit(submitBtn)",function (data,status) {
            $.post(url,$("#form").serializeArray(),function (data,status) {
                if(status=='success'){
                    if(data.body.resultCode=="0"){
                        layer.msg("提交成功");
                    }else {
                        layer.msg(data.body.resultContent, {icon: 5});
                    }
                }else {
                    layer.msg('网络错误', {icon: 5});
                }
            }).error(function (e) {
                layer.msg('网络错误'+e.status, {icon: 5});
            });
            return false;
        })

        $.get("${pageContext.request.contextPath}/generator/getTables",{

        },function (data,status) {
            if(status=="success"){
                if(data.body.resultCode=="0"){
                    layui.tree({
                        elem: '#tables', //传入元素选择器
                        nodes:data.body.entity,
                        click: function(node){
                            if(node.type=="03"){
                                schema = node.tSchema;
                                table = node.tName;
                                $("#driverClass").val(node.driverClass);
                                $("#connectionURL").val(node.connectionURL);
                                $("#userId").val(node.userId);
                                $("#password").val(node.password);
                                $("#schema").val(schema);
                                $("#tableName").val(table);
                                refreshTable();
                                refreshColumnExtendTable();
                                refreshColumnExtendFormTable();
                            }
                        }
                    });
                }else {
                    parent.layer.msg(data.body.resultContent, {icon: 5});
                }
            }else {
                parent.layer.msg('网络错误', {icon: 5});
            }
        });

        $('#bootstrapTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/generator/getColumns",
            height:$(window).height()-100,
            method:'GET',
            toolbar:"#toolbar",
            striped : true, //是否显示行间隔色
            cache : false, //是否使用缓存
            pagination : false, //是否显示分页（*）
            queryParams : queryParams,//传递参数（*）
            queryParamsType : 'limit',
            sidePagination : 'server', //分页方式
            pageNumber : 1, //初始化加载第一页，默认第一页
            pageSize : 15, //每页的记录行数（*）
            pageList : [ 10, 15, 20, 50 ], //可供选择的每页的行数（*）
            search : false,//是否显示表格搜索
            searchAlign : "right",//指定搜索框位置
            dataField:"list",
            totalField:"total",
            searchOnEnterKey : false,
            strictSearch : false,
            showRefresh : false, //是否显示刷新按钮
            showColumns : false, //是否显内容列下拉框
            showPaginationSwitch : false,//是否显示 数据条数选择框
            minimumCountColumns : 2, //最少允许的列数
            clickToSelect : false, //是否启用点击选中行
            uniqueId : "resourceId", //每一行的唯一标识，一般为主键列
            singleSelect : false,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title : "序号",
                    field : "ordinalPosition",
                },{
                    title : "列名",
                    field : "columnName",
                },{
                    title : "是否可为空",
                    field : "isNullAble"
                },{
                    title : "数据类型",
                    field : "dateType"
                },{
                    title : "注释",
                    field : "columnComment"
                },{
                    title : "主键",
                    field : "columnKey"
                } , {
                    title : "操作",
                    align : "center",
                    events : {
                        'click .enter': function (e, value, row, index) {
                            currentId = row.dicId;
                            refreshTable();
                            loadPath();
                        },
                        'click .edit' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            showModel("编辑字典","${pageContext.request.contextPath}/resource/link?url=system/setting/dictionary/form&dicId="+row.dicId);
                        },
                        'click .delete' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            del(row.dicId);
                        }
                    },
                    formatter : function () {
                        return [ '<button type="button" class="enter layui-btn layui-btn-small">进入</button>&nbsp;&nbsp;&nbsp;',
                            '<button type="button" class="edit layui-btn layui-btn-small">编辑</button>&nbsp;&nbsp;&nbsp;',
                            '<button type="button" class="delete layui-btn layui-btn-small">删除</button>&nbsp;&nbsp;&nbsp;',].join('');
                    }
                }],
            onLoadError : function(status) { //加载失败时执行
                $.messager.show({
                    title : 'Error',
                    msg : "数据加载失败"
                });
            },
            formatSearch: function () {
                return '输入权限名称或权限表达式查询';
            }
        });
        function queryParams(params) {
            var param = {
                pageSize : params.limit, //页面大小
                pageNum : this.pageNumber, //页码
                searchText : params.search,
                schema:schema,
                table:table,
            }
            return param;
        }

        //======================================页面属性===========================================================
        $('#ColumnExtendTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/generator/columnExtendlist",
            height:$(window).height()-$("#topLayout").height()-140,
            method:'GET',
            toolbar:"#toolbar",
            striped : true, //是否显示行间隔色
            cache : false, //是否使用缓存
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
            strictSearch : false,
            showRefresh : false, //是否显示刷新按钮
            showColumns : false, //是否显内容列下拉框
            showPaginationSwitch : false,//是否显示 数据条数选择框
            minimumCountColumns : 2, //最少允许的列数
            clickToSelect : true, //是否启用点击选中行
            uniqueId : "id", //每一行的唯一标识，一般为主键列
            singleSelect : true,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title:"排序",
                    field:"seq",
                    editable:{
                        type: 'text',
                        title: '排序',
                        validate: function (v) {
                            if (isNaN(v)) return '序号必须是数字';
                            var age = parseInt(v);
                            if (age <= 0) return '序号必须是正整数';
                        }
                    }
                },
                {
                    title:"列名",
                    field:"columnName",
                },
                {
                    title:"注释",
                    field:"columnComment",
                },
                {
                    title:"是否查询",
                    field:"isQuery",
                    editable: {
                        type: 'select',
                        title: '是否查询',
                        source: function () {
                            var result = [];
                            $.ajax({
                                url: '${pageContext.request.contextPath}/dictionary/listByPid',
                                async: false,
                                type: "get",
                                data: {
                                    parentId:34
                                },
                                success: function (data, status) {
                                    if (status == "success") {
                                        if (data.body.resultCode == "0") {
                                            $.each(data.body.entity, function (key, value) {
                                                result.push({ value: value.keystone, text: value.value });
                                            });
                                        }else {
                                            layer.msg(data.body.resultContent);
                                        }
                                    }else {
                                        layer.msg("网络错误");
                                    }
                                }
                            });
                            return result;
                        }
                    }
                },
                {
                    title:"列表显示",
                    field:"listShow",
                    editable: {
                        type: 'select',
                        title: '列表显示',
                        source: function () {
                            var result = [];
                            $.ajax({
                                url: '${pageContext.request.contextPath}/dictionary/listByPid',
                                async: false,
                                type: "get",
                                data: {
                                    parentId:34
                                },
                                success: function (data, status) {
                                    if (status == "success") {
                                        if (data.body.resultCode == "0") {
                                            $.each(data.body.entity, function (key, value) {
                                                result.push({ value: value.keystone, text: value.value });
                                            });
                                        }else {
                                            layer.msg(data.body.resultContent);
                                        }
                                    }else {
                                        layer.msg("网络错误");
                                    }
                                }
                            });
                            return result;
                        }
                    }
                },
                {
                    title:"表单显示",
                    field:"formShow",
                    editable: {
                        type: 'select',
                        title: '表单显示',
                        source: function () {
                            var result = [];
                            $.ajax({
                                url: '${pageContext.request.contextPath}/dictionary/listByPid',
                                async: false,
                                type: "get",
                                data: {
                                    parentId:34
                                },
                                success: function (data, status) {
                                    if (status == "success") {
                                        if (data.body.resultCode == "0") {
                                            $.each(data.body.entity, function (key, value) {
                                                result.push({ value: value.keystone, text: value.value });
                                            });
                                        }else {
                                            layer.msg(data.body.resultContent);
                                        }
                                    }else {
                                        layer.msg("网络错误");
                                    }
                                }
                            });
                            return result;
                        }
                    }
                }],
            onEditableSave:function (field, row, oldValue, $el) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/columnExtend/edit",
                    data: row,
                    dataType: 'JSON',
                    success: function (data, status) {
                        if (status == "success") {
                            if (data.body.resultCode != "0") {
                                layer.msg(data.body.resultContent);
                            }
                        }else {
                            layer.msg("网络错误");
                        }
                    },
                    error: function () {
                        alert('编辑失败');
                    },
                    complete: function () {

                    }
                });
            },
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
        //======================================表单属性===========================================================
        $('#ColumnExtendFormTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/generator/columnExtendFormlist",
            height:$(window).height()-140,
            method:'GET',
            striped : true, //是否显示行间隔色
            cache : false, //是否使用缓存
            pagination : true, //是否显示分页（*）
            queryParams : queryParams,//传递参数（*）
            queryParamsType : 'limit',
            sidePagination : 'server', //分页方式
            pageNumber : 1, //初始化加载第一页，默认第一页
            pageSize : 15, //每页的记录行数（*）
            pageList : [ 10, 15, 20, 50 ], //可供选择的每页的行数（*）
            search : false,//是否显示表格搜索
            searchAlign : "right",//指定搜索框位置
            dataField:"list",
            totalField:"total",
            searchOnEnterKey : false,
            strictSearch : false,
            showRefresh : true, //是否显示刷新按钮
            showColumns : false, //是否显内容列下拉框
            showPaginationSwitch : false,//是否显示 数据条数选择框
            minimumCountColumns : 2, //最少允许的列数
            clickToSelect : true, //是否启用点击选中行
            uniqueId : "id", //每一行的唯一标识，一般为主键列
            singleSelect : true,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title:"排序",
                    field:"seq",
                    editable:{
                        type: 'text',
                        title: '排序',
                        validate: function (v) {
                            if (isNaN(v)) return '序号必须是数字';
                            var age = parseInt(v);
                            if (age <= 0) return '序号必须是正整数';
                        }
                    }
                },
                {
                    title:"列名",
                    field:"columnName",
                },
                {
                    title:"注释",
                    field:"columnComment",
                },
                {
                    title:"控件类型",
                    field:"inputType",
                    editable: {
                        type: 'select',
                        title: '控件类型',
                        source: function () {
                            var result = [];
                            $.ajax({
                                url: '${pageContext.request.contextPath}/dictionary/listByPid',
                                async: false,
                                type: "get",
                                data: {
                                    parentId:43
                                },
                                success: function (data, status) {
                                    if (status == "success") {
                                        if (data.body.resultCode == "0") {
                                            $.each(data.body.entity, function (key, value) {
                                                result.push({ value: value.keystone, text: value.value });
                                            });
                                        }else {
                                            layer.msg(data.body.resultContent);
                                        }
                                    }else {
                                        layer.msg("网络错误");
                                    }
                                }
                            });
                            return result;
                        }
                    }
                },
                {
                    title:"是否必填",
                    field:"required",
                    editable: {
                        type: 'select',
                        title: '是否必填',
                        source: function () {
                            var result = [];
                            $.ajax({
                                url: '${pageContext.request.contextPath}/dictionary/listByPid',
                                async: false,
                                type: "get",
                                data: {
                                    parentId:34
                                },
                                success: function (data, status) {
                                    if (status == "success") {
                                        if (data.body.resultCode == "0") {
                                            $.each(data.body.entity, function (key, value) {
                                                result.push({ value: value.keystone, text: value.value });
                                            });
                                        }else {
                                            layer.msg(data.body.resultContent);
                                        }
                                    }else {
                                        layer.msg("网络错误");
                                    }
                                }
                            });
                            return result;
                        }
                    }
                },
                {
                    title:"校验规则",
                    field:"verify",
                    editable: {
                        type: 'select',
                        title: '校验规则',
                        source: function () {
                            var result = [];
                            $.ajax({
                                url: '${pageContext.request.contextPath}/dictionary/listByPid',
                                async: false,
                                type: "get",
                                data: {
                                    parentId:49
                                },
                                success: function (data, status) {
                                    if (status == "success") {
                                        if (data.body.resultCode == "0") {
                                            $.each(data.body.entity, function (key, value) {
                                                result.push({ value: value.keystone, text: value.value });
                                            });
                                        }else {
                                            layer.msg(data.body.resultContent);
                                        }
                                    }else {
                                        layer.msg("网络错误");
                                    }
                                }
                            });
                            return result;
                        }
                    }
                },{
                    title:"参数",
                    field:"param",
                    editable:{
                        type: 'text',
                        title: '参数',
                        validate: function (v) {

                        }
                    }
                }],
            onEditableSave:function (field, row, oldValue, $el) {
                $.ajax({
                    type: "post",
                    url: "${pageContext.request.contextPath}/columnExtend/edit",
                    data: row,
                    dataType: 'JSON',
                    success: function (data, status) {
                        if (status == "success") {
                            if (data.body.resultCode != "0") {
                                layer.msg(data.body.resultContent);
                            }
                        }else {
                            layer.msg("网络错误");
                        }
                    },
                    error: function () {
                        alert('编辑失败');
                    },
                    complete: function () {

                    }
                });
            },
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
    });



    function refreshTable() {
        $('#bootstrapTable').bootstrapTable('refresh');
    }

    function refreshColumnExtendTable() {
        $('#ColumnExtendTable').bootstrapTable('refresh');
    }

    function refreshColumnExtendFormTable() {
        $('#ColumnExtendFormTable').bootstrapTable('refresh');
    }
</script>
</html>