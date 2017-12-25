<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-11-24
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>流程部署</title>
</head>
<body>
<table id='bootstrapTable'>
</table>
</body>
<script type="text/javascript">
    layui.use(['layer','form'],function () {
        var layer = layui.layer;
        var form =  layui.form;

        $('#bootstrapTable').bootstrapTable({
            url:"${pageContext.request.contextPath}/deployments/getList",
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
            uniqueId : "userId", //每一行的唯一标识，一般为主键列
            singleSelect : true,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [{checkbox : true},
                {
                    title:"流程ID",
                    field:"id",
                },
                {
                    title:"流程名称",
                    field:"name",
                },
                {
                    title:"部署时间",
                    field:"deploymentTime",
                },
                {
                    title:"类别",
                    field:"category",
                },
                {
                    title:"承租者Id",
                    field:"tenantId",
                },
                {
                    title : "操作",
                    align : "center",
                    events : {
                        'click .delete' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            del(row.id);
                        }
                    },
                    formatter : function () {
                        var buttons=[];
                        buttons.push('<button type="button" class="convert layui-btn layui-btn-small">转为模型</button>&nbsp;');
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
            }
            return param;
        };

        function del(id) {
            layer.confirm("删除数据不可恢复，请确认？",{
                btn: ['确定','取消'],
                offset: '150px',
            },function () {
                $.post('${pageContext.request.contextPath}/deployments/deleteOne',
                    {id : id},
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
        };

        function refreshTable() {
            $('#bootstrapTable').bootstrapTable('refresh');
        }
    });
</script>
</html>
