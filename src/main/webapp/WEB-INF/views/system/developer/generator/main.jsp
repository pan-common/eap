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
                <form id="form" class="layui-form" style="margin-top: 20px" lay-filter="form">
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <label class="layui-form-label">数据库</label>
                            <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                                <input type="text" id="schema" name="schema"  lay-verify="required" readOnly="true" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-input-inline">
                            <label class="layui-form-label">表名</label>
                            <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                                <input type="text" id="tableName" name="tableName"  lay-verify="required" readOnly="true" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-form-item">
                            <label class="layui-form-label">包名</label>
                            <div class="layui-input-inline" style="margin-right: 10px;width: 300px">
                                <input type="text" name="packageName" required  lay-verify="required"  class="layui-input">
                            </div>
                            <div class="layui-form-mid layui-word-aux">
                                <button id="selectPackage" class="layui-btn layui-btn-small">选择</button>
                            </div>
                        </div>
                    </div>
                    <div class="layui-inline">
                        <div class="layui-input-inline">
                            <label class="layui-form-label">别名</label>
                            <div class="layui-input-block" style="margin-right: 10px;width: 300px">
                                <input type="text" name="alias" required  lay-verify="required" placeholder="请输入别名" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                    </div>
                    <div class="layui-form-item">
                        <div class="layui-input-block" style="margin-right: 10px">
                            <button class="layui-btn" lay-submit lay-filter="submitBtn">立即提交</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="row">
                <table id='bootstrapTable'>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
<script type="text/javascript">
    var url = "${pageContext.request.contextPath}/generator/execute";
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var schema = "";
        var table = "";

        var form = layui.form();
        form.render('select','form');

        $("#selectPackage").click(function () {
            showModel("选择包目录","${pageContext.request.contextPath}/resource/link?url=system/developer/generator/treeView");
        });
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
            $.post(url,data.field,function (data,status) {
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
                                $("#schema").val(schema);
                                $("#tableName").val(table);
                                refreshTable();
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
    });

    function refreshTable() {
        $('#bootstrapTable').bootstrapTable('refresh');
    }

    function selectPackage() {

    }
</script>
</html>