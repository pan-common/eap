<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-19
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../views/system/common/easyui_base.jsp"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="main_layout" class="easyui-layout" style="width: 1500px;height: 800px">
    <div region="west" split="true" title="企业信息" style="width:200px;">
        <ul class="easyui-tree tree" id="qyxxtree"></ul>
    </div>
    <div region="center" title="监测点位信息" style="padding:5px;">
        <div id="tbar" align="right">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">添加监测点位</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="removeit()">删除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="accept()">保存</a>
        </div>
        <table class="easyui-datagrid" id="datagrid" style="height: 680px">
        </table>
    </div>
    <div region="north" split="true" title="检测结果录入" style="width:150px;">
    </div>
    <div region="south" title="底部区域" style="padding:5px;">
    </div>
</div>
</body>
<script type="text/javascript">

    //设置自适应浏览器宽度和高度
    //    setLayoutHeight();
    function setLayoutHeight() {
        var height = $(window).height()-20;
        $("#main_layout").attr("style", "width:100%;height:" + height + "px");
        $("#main_layout").layout("resize", {
            width: "100%",
            height: height + "px"
        });
    }
    //显示企业信息
    $('#qyxxtree').tree({
        url: "${pageContext.request.contextPath}/qyjcxx/treeView",
        method:'GET',
        loadFilter: function(data){
            return data.body.entity;
        },
        onBeforeLoad:function (node, param) {
            param.parentId = 0;
        }
    });

    //================创建数据网格===================
    $("#datagrid").datagrid({
        url:"${pageContext.request.contextPath}/test/list",
        method:"GET",
        fitColumns:false,//设置为true防止水平滚动
        autoRowHeight:true,//适应内容高度
        toolbar: '#tbar',
        striped:true,//条文化
        nowrap:false,//设置true单行显示
        idField:'id',//设置主键
        loadMsg:"数据加载中……",
        pagination:true,//显示底部分页工具栏
        rownumbers:false,//带行号
        singleSelect:true,//单行选中
        checkOnSelect:true,//行点击选中
        pagePosition:'bottom',//定义分页栏位置  top bottom both
        pageNumber:1,//初始页码
        pageSize:15,//初始每页行数
        pageList:[10,15,30,50,100],//每页行数选择
        queryParams:{
            //额外参数
        },
        sortName:'test1',//排序列
        sortOrder:'asc',//排序列顺序
        multiSort:true,//是否多列排序
        remoteSort:true,//是否服务器排序
        showHeader:true,//是否显示头部
        showFooter:true,//是否显示底部
        scrollbarSize:200,//滚动条大小
        rowStyler:function (index,row) {
            //设置样式
            return '';
        },
        columns:[[
            {
                field:'jcdw',//字段名
                title:'监测点位',//列名
                width:150,//列宽
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:'textbox'
            },
            {
                field:'sfkzjc',
                title:'是否开展监测',
                width:120,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'jcptsfaq',
                title:'检测平台是否安全',
                width:150,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'jcdwsfgf',
                title:'监测点位是否规范',
                width:150,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'jcyz',
                title:'监测因子',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'sgjcsj',
                title:'手工监测时间',
                width:120,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:"datetimebox"
            },
            {
                field:'sgjcjg',
                title:'手工监测结果',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:'textbox'
            },
            {
                field:'bzbh',
                title:'标准编号',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:'textbox'
            },
            {
                field:'bzxz',
                title:'标准限值',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:true,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:'textbox'
            },
            {
                field:'sfcb',
                title:'是否超标',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:false,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'sfazzxjc',
                title:'是否安装在线监测',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:false,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'sflw',
                title:'是否联网',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:false,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:{
                    type:'combobox',
                    options:{
                        valueField:'keystone',
                        textField:'value',
                        method:'get',
                        url:'${pageContext.request.contextPath}/dictionary/listByPid?parentId=34',
                        loadFilter:function (data) {
                            return data.body.entity;
                        }
                    }
                }
            },
            {
                field:'tbzxjcjg',
                title:'同步在线监测结果',
                width:100,
                rowspan:1,//一个单元格占行数
                colspan:1,//一个单元格占列数
                align:'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign:'center',//列头对齐方式
                sortable:false,//是否允许列排序
                order:'asc',//默认排序顺序
                resizable:true,//尺寸可调整
                fixed:false,
                hidden:false,//隐藏列
                checkbox:false,//设为true显示checkbox
                formatter:function (value,rowData,rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return '';
                },
                editor:'textbox'
            }
        ]],
        onBeforeLoad:function (param) {
            var page = param.page;
            var rows = param.rows;
            delete param.page;
            delete param.rows;
            param.pageNum = page;
            param.pageSize = rows;
        },
        loadFilter:function (data) {
            var list = data.list;
            delete data.list;
            data.rows = list;
            return data;
        },
        onLoadSuccess:function (data) {
            $('#datagrid').datagrid('mergeCells',{
                index: 1,
                field: 'jcdw',
                rowspan: 2
            });
        },
        onLoadError:function () {

        },
        onClickCell:function (index, field) {
            if (editIndex != index){
                if (endEditing()){
                    $('#datagrid').datagrid('selectRow', index)
                        .datagrid('beginEdit', index);
                    var ed = $('#datagrid').datagrid('getEditor', {index:index,field:field});
                    if (ed){
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    setTimeout(function(){
                        $('#datagrid').datagrid('selectRow', editIndex);
                    },0);
                }
            }
        }
    });

    var editIndex = undefined;
    function endEditing(){
        if (editIndex == undefined){return true}
        if ($('#datagrid').datagrid('validateRow', editIndex)){
            $('#datagrid').datagrid('endEdit', editIndex);
            editIndex = undefined;
            return true;
        } else {
            return false;
        }
    }
    function onEndEdit(index, row){
        var ed = $(this).datagrid('getEditor', {
            index: index,
            field: 'productid'
        });
        row.productname = $(ed.target).combobox('getText');
    }
    function append(){
        if (endEditing()){
            $('#datagrid').datagrid('appendRow',{status:'P'});
            editIndex = $('#datagrid').datagrid('getRows').length-1;
            $('#datagrid').datagrid('selectRow', editIndex)
                .datagrid('beginEdit', editIndex);
        }
    }
    function removeit(){
        if (editIndex == undefined){return}
        $('#datagrid').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }
    function accept(){
        if (endEditing()){
            $('#datagrid').datagrid('acceptChanges');
        }
    }
    function reject(){
        $('#datagrid').datagrid('rejectChanges');
        editIndex = undefined;
    }
    function getChanges(){
        var rows = $('#datagrid').datagrid('getChanges');
        alert(rows.length+' rows are changed!');
    }
</script>
</html>
