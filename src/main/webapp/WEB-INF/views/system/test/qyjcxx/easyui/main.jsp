<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/easyui_base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>qyjcxx</title>
</head>
<style type="text/css">
    .datagrid-row-selected {
        background: #00bbee;
        color: #fff;
    }
</style>
<body>
<div style="margin: 15px;">
    <div id="topLayout">
        <div class="span6">
            <ul class="breadcrumb"></ul>
        </div>
        <div id="tbar">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="update()">编辑</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="remove()">删除</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="submit()">保存</a>
            <div style="float: right;">
                <input id="search"></input>
                <div id="searchMenu" style="width:120px">
                    <div data-options="name:'qymc'">企业名称</div>
                    <div data-options="name:'hylb'">行业类别</div>
                </div>
            </div>
        </div>
        <table id="datagrid">
        </table>
        <div id="menu" class="easyui-menu" style="width: 50px; display: none;">
            <div data-options="iconCls:'icon-save'" onclick="enter()">进入</div>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">

    var searchValue = "";//搜索内容
    var searchName = "";//搜索字段名

    $('#search').searchbox({
        width:400,
        prompt:"请输入搜索内容",//输入框提示信息
        menu:'#searchMenu',
        searcher:function(value,name){
            //搜索回掉
            searchValue = value;
            searchName = name;
            refreshTable();
        },
    });

    var currentId = 0;
    $("#datagrid").height($(window).height()-$("#topLayout").height()-30);
    //浏览器窗口大小变化后，表格宽度自适应
    $(window).resize(function(){
        fitCoulms();
    });
    //表格宽度自适应，
    function fitCoulms(){
        $('#datagrid').datagrid({
            fitColumns:true
        });
    }
    $("#datagrid").datagrid({
        url:"${pageContext.request.contextPath}/qyjcxx/list",
        method:"GET",
        fitColumns:false,//设置为true防止水平滚动
        autoRowHeight:false,//适应内容高度
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
        remoteFilter:true,//启用后“filterRules”参数将被发送到远程服务器
        filterRules:[
            {
                field:"jcrq",
                type:'text',
                options:{precision:1},
                op:['equal','notequal','less','greater']
            },
            {
                field:"shen",
                type:'text',
                options:{precision:1},
                op:['equal','notequal','less','greater']
            },
            {
                field:"shi",
                type:'text',
                options:{precision:1},
                op:['equal','notequal','less','greater']
            }
        ],
        filterStringify:function (data) {
            return data;
        },
        queryParams:{
            //额外参数
        },
        sortName:'',//排序列
        sortOrder:'asc',//排序列顺序
        multiSort:true,//是否多列排序
        remoteSort:true,//是否服务器排序
        showHeader:true,//是否显示头部
        showFooter:true,//是否显示底部
        scrollbarSize:200,//滚动条大小
        rowStyler:function (index,row) {
            //设置样式
        },
        frozenColumns:[[
            {
                field:'jcrq',
                title:'监测日期',
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
                    return 'background-color:#4A87CF';
                },
                editor:{
                    type:'datebox',
                    options:{

                    }
                }
            },
            {
                field:'shen',
                title:'省',
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
                    return 'background-color:#4A87CF';
                },
                editor:'textbox'
            },
            {
                field:'shi',
                title:'市',
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
                    return value.replace(/\n/g, '<br>');
                },
                styler:function (value,rowData,rowIndex) {
                    //单元格样式函数
                    return 'background-color:#4A87CF';
                },
                editor:'textarea'
            },
            {
                field:'xian',
                title:'县',
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
                    return 'background-color:#4A87CF';
                },
                editor:'textbox'
            },
            {
                field:'qymc',
                title:'企业名称',
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
                    return 'background-color:#4A87CF';
                },
                editor:'textbox'
            },
            {
                field:'hylx',
                title:'行业类型',
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
                    return 'background-color:#4A87CF';
                },
                editor:'textbox'
            },
        ]],
        columns:[[
            {
                field:'wrfzss',
                title:'污染防治设施是否正常运行',
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
                field:'yxwtms',
                title:'运行问题描述',
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
                editor:'textbox'
            },
            {
                field:'sfczsjzj',
                title:'是否存在数据造假行为',
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
                field:'zjwtms',
                title:'造假问题描述',
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
                editor:'textbox'
            },
            {
                field:'sfczyzpmdl',
                title:'是否存在严重跑冒滴漏',
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
                field:'pmdlwtms',
                title:'跑冒滴漏问题描述',
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
                editor:'textbox'
            },
        ]],
        onBeforeLoad:function (param) {
            var page = param.page;
            var rows = param.rows;
            delete param.page;
            delete param.rows;
            param.pageNum = page;
            param.pageSize = rows;
            param.parentId=currentId;
            param.searchName = searchName;
            param.searchText = searchValue;
            endEdit();
        },
        loadFilter:function (data) {
            var list = data.list;
            delete data.list;
            data.rows = list;
            return data;
        },
        onLoadSuccess:function (data) {

        },
        onLoadError:function () {

        },
        onEndEdit:function(index, row){

            //获取选择框中的text值
            //            var ed = $(this).datagrid('getEditor', {
            //                index: index,
            //                field: 'productid'
            //            });
            //            row.productname = $(ed.target).combobox('getText');
        },
        onRowContextMenu:function (e, rowIndex, rowData) {
            e.preventDefault(); //阻止浏览器捕获右键事件
            $(this).datagrid("clearSelections"); //取消所有选中项
            $(this).datagrid("selectRow", rowIndex); //根据索引选中该行
            $('#menu').menu('show', {//显示右键菜单
                left: e.pageX,//在鼠标点击处显示菜单
                top: e.pageY
            });
        },
        onClickRow:function (index, row) {

        },
        onClickCell:function (index,field,value) {
            if (editIndex != index) {
                if (endEditing()) {
                    $('#datagrid').datagrid('selectRow', index)
                        .datagrid('beginEdit', index);
                    var ed = $('#datagrid').datagrid('getEditor', {index: index, field: field});
                    if (ed) {
                        ($(ed.target).data('textbox') ? $(ed.target).textbox('textbox') : $(ed.target)).focus();
                    }
                    editIndex = index;
                } else {
                    setTimeout(function () {
                        $('#datagrid').datagrid('selectRow', editIndex);
                    }, 0);
                }
            }
        }
    });

    $('#datagrid').datagrid('enableFilter');    // enable filter

    loadPath();

    var editIndex = undefined;//编辑行下标
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

    function append(){
        if (endEditing()){
            $('#datagrid').datagrid('insertRow',
                {
                    index:0,
                    row:{
                        status:'P'
                    }
                });//新增行
            editIndex = 0;
            //选中编辑行
            $('#datagrid').datagrid('selectRow', editIndex)
                .datagrid('beginEdit', editIndex);
        }
    }
    //取消编辑
    function remove(){
        if (editIndex == undefined){return}
        $('#datagrid').datagrid('cancelEdit', editIndex)
            .datagrid('deleteRow', editIndex);
        editIndex = undefined;
    }

    //提交修改的值
    function submit(){
        endEdit()
        if($('#datagrid').datagrid('getChanges').length){
            var inserted = $('#datagrid').datagrid('getChanges', "inserted");
            var deleted = $('#datagrid').datagrid('getChanges', "deleted");
            var updated = $('#datagrid').datagrid('getChanges', "updated");
            var effectRow =new Object();
            if (inserted.length) {
                effectRow.inserted = inserted;
            }
            if (deleted.length) {
                effectRow.deleted = deleted;
            }
            if (updated.length) {
                effectRow.updated = updated;
            }
            $.ajax({
                url:baseServerUrl+'qyjcxx/easyuiSubmitData',
                data:JSON.stringify(effectRow),
                type:'post',
                dataType:'json',
                headers:{
                    Accept:"application/json",
                    "Content-Type":"application/json"
                },
                processData:false,
                cache:false,
                success:function (data) {
                    if (data.body.resultCode == "0") {
                        $('#datagrid').datagrid('reload');
                    }else {
                        $.messager.alert('提示',body.resultContent);
                    }
                },
                error:function (e) {
                    $.messager.alert('提示',e.message);
                }
            });

        }
    }
    //编辑
    function update() {
        var row = $('#datagrid').datagrid('getSelected');
        if (row) {
            var index = $('#datagrid').datagrid('getRowIndex', row);
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
    }
    //结束编辑
    function endEdit(){
        var rows = $('#datagrid').datagrid('getRows');
        for ( var i = 0; i < rows.length; i++) {
            $('#datagrid').datagrid('endEdit', i);
        }
    }

    function loadPath() {
        $.get('${pageContext.request.contextPath}/qyjcxx/getPath/',
            {
                id : currentId
            }, function(data, status) {
                if (status == "success") {
                    if (data.body.resultCode == "0") {
                        var result = data.body.entity;
                        $(".breadcrumb").empty();
                        var html = "";
                        for (var i = 0; i < result.length; i++) {
                            var html = '<li><a class="clickEffect" name="'
                                +result[i].id+'">'+ result[i].qymc+'</a></li>';
                            $(".breadcrumb").append(html);
                            $("a[name=" + result[i].id + "]").bind("click", {
                                index : i
                            }, clickHandler);
                        }
                        function clickHandler(event) {
                            var i = event.data.index;
                            currentId = result[i].id;
                            refreshTable();
                            loadPath();
                        }
                    }
                }
            });
    }

    function enter() {
        var row = $('#datagrid').datagrid('getSelected');
        if (row) {
            currentId = row.id;
            refreshTable();
            loadPath();
        }

    }

    function refreshTable() {
        $('#datagrid').datagrid('reload');
    }
</script>
</html>