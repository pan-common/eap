<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>zxjg</title>
</head>
<body>
<div style="margin: 15px;">
    <div id="topLayout">
        <div  id="toolbar">
            <form class="layui-form">
                <table class="layui-table" lay-skin="line">
                    <tr>
                        <td>
                            <button id='addBtn' class="layui-btn layui-btn-small">
                                <i class="layui-icon">&#xe608;</i> 添加
                            </button>
                        </td>
                        <td width="70px">
                            <label>企业</label>
                        </td>
                        <td width="250px">
                            <dic:commonSelectTag id="selectQy" dataSource="qyjbxx" nullName="请选择"
                                                 name="qybh" param="" layfilter="selectQy"/>
                        </td>
                        <td width="80px">
                            <label>监测点</label>
                        </td>
                        <td width="200px">
                            <dic:selectTag parentId="110" id="01"  selectName="jcdfl" layfilter="selectJcdfl" nullName="请选择" />
                        </td>
                        <td width="100px">
                            <label>日期范围</label>
                        </td>
                        <td width="200">
                            <input type="text" class="layui-input" name="" id="selectDate">
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <table id='bootstrapTable'>
    </table>
</div>
</body>
<script type="text/javascript">
    layui.use([ 'layer', 'form','laydate' ], function(layer, form) {
        var layer = layui.layer;
        var form =  layui.form;
        var laydate = layui.laydate;

        laydate.render({
            elem:'#selectDate',
            range:true
        });
        form.render();

        $("#addBtn").click(function () {
            showModel("新增","${pageContext.request.contextPath}/sysResource/link?url=biz/zxjg/form&zxjgId=0","800px","550px");
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
            url:"${pageContext.request.contextPath}/zxjg/list",
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
            uniqueId : "zxjgId", //每一行的唯一标识，一般为主键列
            singleSelect : true,//设置true禁止多选
            showToggle : false, //是否显示详细视图和列表视图的切换按钮
            cardView : false, //是否显示详细视图
            detailView : false, //是否显示父子表
            showHeader : true,//是否显示列头
            showFooter : false,//是否显示列脚
            contentType : "application/x-www-form-urlencoded", //解决POST提交问题
            columns : [
                {
                    title:"监测点名称",
                    field:"jcdmc",
                    width:160
                },
                {
                    title:"时间",
                    field:"sj",
                    width:140
                },
                {
                    title:"浓度",
                    field:"klwnd",
                    width:50
                },
                {
                    title:"折算浓度",
                    field:"klwzsnd",
                    width:50
                },
                {
                    title:"总量",
                    field:"klwzl",
                    width:50
                },
                {
                    title:"浓度",
                    field:"eyhlnd",
                    width:50
                },
                {
                    title:"折算浓度",
                    field:"eyhlzsnd",
                    width:50
                },
                {
                    title:"总量",
                    field:"eyhlzl",
                    width:50
                },
                {
                    title:"浓度",
                    field:"dyhwnd",
                    width:50
                },
                {
                    title:"折算浓度",
                    field:"dyhwzsnd",
                    width:50
                },
                {
                    title:"总量",
                    field:"dyhwzl",
                    width:50
                },
                {
                    title:"标杆流量",
                    field:"bgll",
                    width:50
                },
                {
                    title:"氧量",
                    field:"yl",
                    width:50
                },
                {
                    title:"烟温",
                    field:"yw",
                    width:50
                },
                {
                    title:"含湿量",
                    field:"hsl",
                    width:50
                },
                {
                    title : "操作",
                    align : "center",
                    events : {
                        'click .edit' : function(e, value, row, index) {
                            $('#bootstrapTable').bootstrapTable('check',index);
                            showModel("编辑","${pageContext.request.contextPath}/sysResource/link?url=biz/zxjg/form&zxjgId="+row.zxjgId,"550px","550px");
                        }
                    },
                    formatter : function () {
                        var buttons=[];
                        buttons.push('<button type="button" class="edit layui-btn layui-btn-small"><i class="fa fa-edit"></i></button>&nbsp;');
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

    function del(zxjgId) {
        layer.confirm("删除数据不可恢复，请确认？",{
            btn: ['确定','取消'],
            offset: '150px',
        },function () {
            $.post('${pageContext.request.contextPath}/zxjg/delete',
                {zxjgId : zxjgId},
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