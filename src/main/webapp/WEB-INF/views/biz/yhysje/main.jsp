<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>yhysje</title>
</head>
<body>
<div style="margin: 15px;">
        <div id="topLayout">
        <div  id="toolbar">
            <button id='addBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 添加
            </button>
            <button id='importBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 导入数据
            </button>
            <button id='exportBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 导出数据
            </button>
            <button id='dbBtn' class="layui-btn layui-btn-small">
                <i class="layui-icon">&#xe608;</i> 开始对比
            </button>
        </div>
    </div>
    <table id='bootstrapTable'>
    </table>
</div>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form' ], function(layer, form) {
        var layer = layui.layer;
        var form =  layui.form;
        $("#addBtn").click(function () {
            showModel("新增","${pageContext.request.contextPath}/sysResource/link?url=biz/yhysje/form&id=0","550px","550px");
        });

        $("#importBtn").click(function () {
            showModel("导入Excel","${pageContext.request.contextPath}/sysResource/link?url=biz/yhysje/importExcel","550px","550px");
        });

        $("#exportBtn").click(function () {
            //导出数据
            alert("导出数据");
        });

        $("#dbBtn").click(function () {
            //对比数据
            alert("对比数据");
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
            url:"${pageContext.request.contextPath}/yhysje/list",
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
                    title:"主键",
                    field:"id",
                    width:100
                },
                {
                    title:"户名",
                    field:"hm",
                    width:100
                },
                {
                    title:"账号",
                    field:"zh",
                    width:100
                },
                {
                    title:"币种",
                    field:"bz",
                    width:100
                },
                {
                    title:"科目号",
                    field:"kmh",
                    width:100
                },
                {
                    title:"单位",
                    field:"dw",
                    width:100
                },
                {
                    title:"日期",
                    field:"rq",
                    width:100
                },
                {
                    title:"时间",
                    field:"sj",
                    width:100
                },
                {
                    title:"摘要",
                    field:"zy",
                    width:100
                },
                {
                    title:"凭证批次",
                    field:"pzpc",
                    width:100
                },
                {
                    title:"凭证号码",
                    field:"pzhm",
                    width:100
                },
                {
                    title:"借方发生额",
                    field:"jffse",
                    width:100
                },
                {
                    title:"贷方发生额",
                    field:"dffse",
                    width:100
                },
                {
                    title:"余额",
                    field:"ye",
                    width:100
                },
                {
                    title:"传票号",
                    field:"cph",
                    width:100
                },
                {
                    title:"操作员",
                    field:"czyh",
                    width:100
                },
                {
                    title:"对比标识",
                    field:"dbbz",
                    width:100
                },
                {
                    title : "操作",
                    align : "center",
                    width:150,
                    events : {
                        'click .edit' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            showModel("编辑","${pageContext.request.contextPath}/sysResource/link?url=biz/yhysje/form&id="+row.id,"550px","550px");
                        },
                        'click .delete' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            del(row.id);
                        }
                    },
                    formatter : function () {
                        var buttons=[];
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
            }
            return param;
        }
    });

    function del(id) {
        layer.confirm("删除数据不可恢复，请确认？",{
            btn: ['确定','取消'],
            offset: '150px',
        },function () {
            $.post('${pageContext.request.contextPath}/yhysje/delete',
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
    }


    function refreshTable() {
        $('#bootstrapTable').bootstrapTable('refresh');
    }
</script>
</html>