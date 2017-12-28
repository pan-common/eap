<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>element</title>
</head>
<body>
<div style="margin: 15px;">
        <div id="topLayout">
        <div class="span6">
            <ul class="breadcrumb"></ul>
        </div>
        <div  id="toolbar">
            <button id='addBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 添加
            </button>
            <button id='showTreeView' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe62e;</i> 显示树
            </button>
            <button id='showZTree' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe62e;</i> zTree显示
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
            showModel("新增","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/element/form&elementId=0","550px","550px");
        });
        $("#showTreeView").click(function () {
            showModel("显示树","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/element/treeView","550px",$(window).height())
        });
        $("#showZTree").click(function () {
            showModel("显示树","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/element/zTree","550px",$(window).height())
        });
        //弹出录入框
        function showModel(title,url,width,height) {
            layer.open({
                id:"model",
                type:2,
                title:title,
                content:url,
                area:[width,height],
                offset: '0px',
                shade:false,
                maxmin:true,
                success:function (layero, index) {

                }
            })
        };

        $('#bootstrapTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/element/list",
            method:'GET',
            height:$(window).height()-$("#topLayout").height()-30,
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
            uniqueId : "elementId", //每一行的唯一标识，一般为主键列
            singleSelect : true,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title:"元素名称",
                    field:"elementName",
                    width:100
                },
                {
                    title:"元素类型",
                    field:"elementType",
                    width:50
                },
                {
                    title:"上级元素ID",
                    field:"parentId",
                    width:50
                },
                {
                    title:"js模板路径",
                    field:"jsTemplatePath",
                    width:100
                },
                {
                    title:"html模板路径",
                    field:"htmlTemplatePath",
                    width:100
                },
                {
                    title:"元素处理类",
                    field:"elementClass",
                    width:200
                },
                {
                    title:"修改时间",
                    field:"updateTime",
                    width:100
                },
                {
                    title : "操作",
                    align : "center",
                    width:250,
                    events : {
                        'click .enter': function (e, value, row, index) {
                            currentId = row.elementId;
                            refreshTable();
                            loadPath();
                        },
                        'click .setting':function (e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            showModel("属性","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/element/extend&elementId="+row.elementId,"800px","650px")
                        },
                        'click .edit' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            showModel("编辑","${pageContext.request.contextPath}/sysResource/link?url=system/formConfig/element/form&elementId="+row.elementId,"550px","550px");
                        },
                        'click .delete' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            del(row.elementId);
                        }
                    },
                    formatter : function (value,row,index) {
                        var buttons = [];
                        buttons.push('<button type="button" class="enter layui-btn layui-btn-small">进入</button>&nbsp;');
                        if(row.elementType=='元素')
                            buttons.push('<button type="button" class="setting layui-btn layui-btn-small">属性</button>&nbsp;');
                        buttons.push('<button type="button" class="edit layui-btn layui-btn-small">编辑</button>&nbsp;');
                        buttons.push('<button type="button" class="delete layui-btn layui-btn-small">删除</button>&nbsp;');
                        return buttons.join('');
                    }
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
                parentId:currentId
            }
            return param;
        }
        loadPath();
    });

    function del(elementId) {
        layer.confirm("删除数据不可恢复，请确认？",{
            btn: ['确定','取消'],
            offset: '150px',
        },function () {
            $.post('${pageContext.request.contextPath}/element/delete',
                    {elementId : elementId},
                    function (data, status) {
                        if (status == "success") {
                            if (data.body.resultCode == "0") {
                                layer.close(layer.index);
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
        $.get('${pageContext.request.contextPath}/element/getPath/',
                {
                    elementId : currentId
                }, function(data, status) {
                    if (status == "success") {
                        if (data.body.resultCode == "0") {
                            var result = data.body.entity;
                            $(".breadcrumb").empty();
                            var html = "";
                            for (var i = 0; i < result.length; i++) {
                                 var html = '<li><a class="clickEffect" name="'
                                +result[i].elementId+'">'+ result[i].elementName+'</a></li>';
                                $(".breadcrumb").append(html);
                                $("a[name=" + result[i].elementId + "]").bind("click", {
                                    index : i
                                }, clickHandler);
                            }
                            function clickHandler(event) {
                                var i = event.data.index;
                                currentId = result[i].elementId;
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