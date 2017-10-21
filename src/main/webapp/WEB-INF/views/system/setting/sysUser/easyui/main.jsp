<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-20
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../../../common/easyui_base.jsp"%>
<html>
<head>

</head>
<body>
<div id="tbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true" onclick="append()">新增</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save',plain:true" onclick="update()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true" onclick="remove()">删除</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" onclick="submit()">保存</a>
</div>
<table class="easyui-datagrid" id="datagrid" style="height: 680px">
</table>
</body>
<script type="text/javascript">
    $("#datagrid").datagrid({
        url:"${pageContext.request.contextPath}/sysUser/list",
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
                field:'seq',//字段名
                title:'排序',//列名
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
                editor:'numberbox'
            },
            {
                field:'userId',
                title:'用户ID',
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
                }
            },
            {
                field:'userName',
                title:'用户名',
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
                field:'password',
                title:'密码',
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
                field:'salt',
                title:'盐值',
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
                }
            },
            {
                field: 'locked',
                title: '是否被锁住',
                width: 120,
                rowspan: 1,//一个单元格占行数
                colspan: 1,//一个单元格占列数
                align: 'center',//内容对齐方式，可以用 'left'、'right'、'center'
                halign: 'center',//列头对齐方式
                sortable: true,//是否允许列排序
                order: 'asc',//默认排序顺序
                resizable: true,//尺寸可调整
                fixed: false,
                hidden: false,//隐藏列
                checkbox: false,//设为true显示checkbox
                formatter: function (value, rowData, rowIndex) {
                    //格式化单元格
                    return value;
                },
                styler: function (value, rowData, rowIndex) {
                    //单元格样式函数
                    return '';
                }
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
            $('#datagrid').datagrid('appendRow',{status:'P'});//新增行
            editIndex = $('#datagrid').datagrid('getRows').length-1;
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
                url:baseServerUrl+'sysUser/easyuiSubmitData',
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
</script>
</html>
