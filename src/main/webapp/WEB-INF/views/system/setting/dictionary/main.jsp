<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <title>数据字典</title>
</head>
<body>
<div style="margin: 15px;">
    <div id="topLayout">
        <div class="span6">
            <ul class="breadcrumb"></ul>
        </div>
        <div  id="toolbar">
            <button id='addBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 添加菜单
            </button>
        </div>
    </div>
    <table id='bootstrapTable'>
    </table>
</div>
</body>
<script type="text/javascript">
    var currentId = 0;
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var layer = layui.layer;
        var form =  layui.form;
        $("#addBtn").click(function () {
            showModel("新增字典","${pageContext.request.contextPath}/resource/link?url=system/setting/dictionary/form&dicId=0");
        });

        //弹出录入框
        function showModel(title,url) {
            layer.open({
                id:"model",
                type:2,
                title:title,
                content:url,
                area:["1000px","550px"],
                offset: '0px',
                shade:false,
                maxmin:true,
                success:function (layero, index) {

                }
            })
        };

        $('#bootstrapTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/dictionary/list",
            height:$(window).height()-$("#topLayout").height()-30,
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
            strictSearch : true,
            showRefresh : true, //是否显示刷新按钮
            showColumns : false, //是否显内容列下拉框
            showPaginationSwitch : false,//是否显示 数据条数选择框
            minimumCountColumns : 2, //最少允许的列数
            clickToSelect : true, //是否启用点击选中行
            uniqueId : "resourceId", //每一行的唯一标识，一般为主键列
            singleSelect : true,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title : "序号",
                    field : "seq",
                },{
                    title : "ID",
                    field : "dicId",
                },{
                    title : "键",
                    field : "keystone"
                },{
                    title : "值",
                    field : "value"
                },{
                    title : "参数一",
                    field : "param1"
                },{
                    title : "参数二",
                    field : "param2"
                },{
                    title : "参数三",
                    field : "param3"
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
                parentId:currentId
            }
            return param;
        }

        loadPath();
    });

    function del(dic_id) {
        layer.confirm("该操作将删除节点下全部数据，请确认？",{
            btn: ['确定','取消'],
            offset: '150px',
        },function () {
            $.post('${pageContext.request.contextPath}/dictionary/delete',
                {
                    dicId : dic_id
                },
                function (data, status) {
                    if (status == "success") {
                        if (data.body.resultCode == "0") {
                            refreshTable();
                        }else {
                            layer.msg(data.body.resultContent);
                        }
                    }else {
                        layer.msg("网络错误");
                    }
                }).error(function (e) {
                layer.msg("网络错误："+e.status);
            })
        },function () {

        });

    }

    function loadPath() {
        $.get('${pageContext.request.contextPath}/dictionary/getPath/',
            {
                dicId : currentId
            }, function(data, status) {
                if (status == "success") {
                    if (data.body.resultCode == "0") {
                        var result = data.body.entity;
                        var $breadcrumb = $(".breadcrumb");
                        $breadcrumb.empty();
                        var html = "";
                        for (var i = 0; i < result.length; i++) {
                            $breadcrumb.append("<li><a class='clickEffect' name='"+result[i].dicId+"'>"
                                + result[i].value
                                + "</a></li>");
                            $("a[name=" + result[i].dicId + "]").bind("click", {
                                index : i
                            }, clickHandler);
                        }
                        function clickHandler(event) {
                            var i = event.data.index;
                            currentId = result[i].dicId;
                            refreshTable();
                            loadPath();
                        }
                    }
                }
            });
    }

    function refreshTable() {
        $('#bootstrapTable').bootstrapTable('refresh');
    }
</script>
</html>