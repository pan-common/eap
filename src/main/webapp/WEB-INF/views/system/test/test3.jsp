<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-10-17
  Time: 13:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<style type="text/css">
    .jcTable {border-left: 1px solid #666; border-bottom: 1px solid #666;}
    .jcTable td{border-right:1px solid #666;border-top: 1px solid #666;padding: 2px;text-align: center}
    .jcTable .table-input{
        padding-left: 10px;
        padding-right: 10px;
        padding-bottom: 5px;
        padding-top: 5px;
    }
    /*参与比较*/
    .compare{

    }
    /*占6行*/
    .single-show-6{

    }
    /*占3行*/
    .single-show-3{

    }
    /*检测结果*/
    .check-result{

    }
    /*是否超标*/
    .is-cb{

    }
    /*是否合格*/
    .is-hg{

    }
    /*计算超标*/
    .overproof{

    }
</style>
<head>
    <title>Title</title>
</head>
<body>

<table>
    <tr>
        <td><label>企业名称:</label></td>
        <td><input id="qymc" type="text" name="hbJczfZfxxlr.qymc"></td>
        <td><label>监测点位:</label></td>
        <td><input type="text" name="hbJczfZfxxlr.jcdw"></td>
    </tr>
    <tr>
        <td><label>行业类别:</label></td>
        <td><input type="text" name="hbJczfZfxxlr.hylb"></td>
        <td><label>是否比较:</label></td>
        <td>
            <input type="radio" name="hbJczfZfxxlr.sfdb" value="1" >是
            <input type="radio" name="hbJczfZfxxlr.sfdb" value="2" checked>否
        </td>
    </tr>
    <tr>
        <td><label>检测日期:</label></td>
        <td><input type="text" name="hbJczfZfxxlr.jcrq"></td>
        <td><label>录入日期:</label></td>
        <td><input type="text" name="hbJczfZfxxlr.lrrq"></td>
    </tr>
    <tr>
        <td><label>录入人:</label></td>
        <td><input type="text" name="hbJczfZfxxlr.lrrmc"></td>
        <td><label>备注:</label></td>
        <td><textarea name="hbJczfZfxxlr.bz" id="" cols="30" rows="2"></textarea></td>
    </tr>
</table>
<label>监测项目和结果</label>
<table class="jcTable">
    <thead>
    <tr>
        <td rowspan="2">项目</td><td rowspan="2" class="check-result">检测结果</td><td rowspan="2">录入结果</td><td colspan="2">限值</td><td rowspan="2">标准</td><td rowspan="2" class="is-cb">是否超标</td><td rowspan="2" class="is-hg">是否合格</td>
    </tr>
    <tr>
        <td>最小值</td><td>最大值</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td rowspan="6" class="single-show-6">二氧化硫</td>
        <td class="table-input check-result"><input id="eyhl_check_result_1" name="hbJczfZfxxlr.eyhlCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="eyhl_input_result_1" name="hbJczfZfxxlr.eyhlInputResult1" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6"><input class="overproof" id="eyhl_min" name="hbJczfZfxxlr.eyhlMin" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6"><input class="overproof" id="eyhl_max" name="hbJczfZfxxlr.eyhlMax" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6"><input id="eyhl_bz" name="hbJczfZfxxlr.eyhlBz" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 is-cb"><input id="eyhl_is_cb" type="text" style="width: 100px" readonly></td>
        <td rowspan="6" class="table-input single-show-6 is-hg"><input type="text" style="width: 100px" readonly></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="eyhl_check_result_2" name="hbJczfZfxxlr.eyhlCheckResult2" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="eyhl_input_result_2" name="hbJczfZfxxlr.eyhlInputResult2" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="eyhl_check_result_3" name="hbJczfZfxxlr.eyhlCheckResult3" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="eyhl_input_result_3" name="hbJczfZfxxlr.eyhlInputResult3" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="eyhl_check_result_4" name="hbJczfZfxxlr.eyhlCheckResult4" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="eyhl_input_result_4" name="hbJczfZfxxlr.eyhlInputResult4" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="eyhl_check_result_5" name="hbJczfZfxxlr.eyhlCheckResult5" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="eyhl_input_result_5" name="hbJczfZfxxlr.eyhlInputResult5" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="eyhl_check_result_6" name="hbJczfZfxxlr.eyhlCheckResult6" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="eyhl_input_result_6" name="hbJczfZfxxlr.eyhlInputResult6" type="text" style="width: 100px"></td>
    </tr>

    <tr>
        <td rowspan="6" class="single-show-6">氮氧化物</td>
        <td class="table-input check-result"><input id="dyhw_check_result_1" name="hbJczfZfxxlr.dyhwCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="dyhw_input_result_1" name="hbJczfZfxxlr.dyhwInputResult1" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6" single-show><input class="overproof" id="dyhw_min" name="hbJczfZfxxlr.dyhwMin" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6"><input class="overproof" id="dyhw_max" name="hbJczfZfxxlr.dyhwMax" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6"><input id="dyhw_bz" name="hbJczfZfxxlr.dyhwBz" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 is-cb"><input id="dyhw_is_cb" type="text" style="width: 100px" readonly></td>
        <td rowspan="6" class="table-input single-show-6 is-hg"><input type="text" style="width: 100px" readonly></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="dyhw_check_result_2" name="hbJczfZfxxlr.dyhwCheckResult2" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="dyhw_input_result_2" name="hbJczfZfxxlr.dyhwInputResult2" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="dyhw_check_result_3" name="hbJczfZfxxlr.dyhwCheckResult3" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="dyhw_input_result_3" name="hbJczfZfxxlr.dyhwInputResult3" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="dyhw_check_result_4" name="hbJczfZfxxlr.dyhwCheckResult4" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="dyhw_input_result_4" name="hbJczfZfxxlr.dyhwInputResult4" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="dyhw_check_result_5" name="hbJczfZfxxlr.dyhwCheckResult5" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="dyhw_input_result_5" name="hbJczfZfxxlr.dyhwInputResult5" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="dyhw_check_result_6" name="hbJczfZfxxlr.dyhwCheckResult6" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="dyhw_input_result_6" name="hbJczfZfxxlr.dyhwInputResult6" type="text" style="width: 100px"></td>
    </tr>

    <tr>
        <td rowspan="3" class="single-show-3">颗粒物</td>
        <td class="table-input check-result"><input id="klw_check_result_1" name="hbJczfZfxxlr.klwCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="klw_input_result_1" name="hbJczfZfxxlr.klwInputResult1" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3"><input class="overproof" id="klw_min" name="hbJczfZfxxlr.klwMin" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3"><input class="overproof" id="klw_max" name="hbJczfZfxxlr.klwMax" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3"><input id="klw_bz" name="hbJczfZfxxlr.klwBz" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3 is-cb"><input id="klw_is_cb" type="text" style="width: 100px" readonly></td>
        <td rowspan="3" class="table-input single-show-3 is-hg"><input type="text" style="width: 100px" readonly></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="klw_check_result_2" name="hbJczfZfxxlr.klwCheckResult2" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="klw_input_result_2" name="hbJczfZfxxlr.klwInputResult2" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input id="klw_check_result_3" name="hbJczfZfxxlr.klwCheckResult3" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="klw_input_result_3" name="hbJczfZfxxlr.klwInputResult3" type="text" style="width: 100px"></td>
    </tr>
    <tr>
        <td>非甲烷总烃</td>
        <td class="table-input check-result"><input id="fjwzt_check_result_1" name="hbJczfZfxxlr.fjwztCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="fjwzt_input_result_1" name="hbJczfZfxxlr.fjwztInputResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="fjwzt_min" name="hbJczfZfxxlr.fjwztMin" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="fjwzt_max" name="hbJczfZfxxlr.fjwztMax" type="text" style="width: 100px"></td>
        <td class="table-input"><input id="fjwzt_bz" name="hbJczfZfxxlr.fjwztBz" type="text" style="width: 100px"></td>
        <td class="table-input is-cb"><input id="fjwzt_is_cb" type="text" style="width: 100px" readonly></td>
        <td class="table-input is-hg"><input type="text" style="width: 100px" readonly></td>
    </tr>
    </tbody>
</table>

</body>
<script type="text/javascript">
    $(document).ready(function(){
        doQuery();
        $('input[name="hbJczfZfxxlr.sfdb"]').each(function(){
            $(this).click(function(){
                var discount = $(this).val();
                isCompare(discount);
            });
        });
        isCompare("2");
    });

    function doQuery() {
        $.ajax({
            type: "post",
            url: "<%=basePath%>hbJczfZfxxlr/select.action",
            data:{
                "id":"<%=id%>"
            },
            async: false,
            dataType: "json",
            success:function (data) {
                $("#qymc").val(data.obj.qymc);//企业名称
                $("#jcdw").val(data.obj.jcdw);//监测点位
                $("#hylb").val(data.obj.hylb);//行业类别
//                $("#sfdb").val(data.obj.sfdb);//是否比较
                $("#jcrq").val(data.obj.jcrq);//检测日期
                $("#lrrq").val(data.obj.lrrq);//录入日期
                $("#lrrmc").val(data.obj.lrrmc);//录入人名称
                $("#bz").val(data.obj.bz);//备注
                $("#eyhl_check_result_1").val(data.obj.eyhlCheckResult1);//行业类别
                $("#eyhl_input_result_1").val(data.obj.eyhlInputResult1);//行业类别
                $("#eyhl_check_result_2").val(data.obj.eyhlCheckResult2);//行业类别
                $("#eyhl_input_result_2").val(data.obj.eyhlInputResult2);//行业类别
                $("#eyhl_check_result_3").val(data.obj.eyhlCheckResult3);//行业类别
                $("#eyhl_input_result_3").val(data.obj.eyhlInputResult3);//行业类别
                $("#eyhl_check_result_4").val(data.obj.eyhlCheckResult4);//行业类别
                $("#eyhl_input_result_4").val(data.obj.eyhlInputResult4);//行业类别
                $("#eyhl_check_result_5").val(data.obj.eyhlCheckResult5);//行业类别
                $("#eyhl_input_result_5").val(data.obj.eyhlInputResult5);//行业类别
                $("#eyhl_check_result_6").val(data.obj.eyhlCheckResult6);//行业类别
                $("#eyhl_input_result_6").val(data.obj.eyhlInputResult6);//行业类别
                $("#eyhl_min").val(data.obj.eyhlMin);//行业类别
                $("#eyhl_max").val(data.obj.eyhlMax);//行业类别
                $("#eyhl_bz").val(data.obj.eyhlBz);//行业类别

                $("#dyhw_check_result_1").val(data.obj.dyhwCheckResult1);//行业类别
                $("#dyhw_input_result_1").val(data.obj.dyhwInputResult1);//行业类别
                $("#dyhw_check_result_2").val(data.obj.dyhwCheckResult2);//行业类别
                $("#dyhw_input_result_2").val(data.obj.dyhwInputResult2);//行业类别
                $("#dyhw_check_result_3").val(data.obj.dyhwCheckResult3);//行业类别
                $("#dyhw_input_result_3").val(data.obj.dyhwInputResult3);//行业类别
                $("#dyhw_check_result_4").val(data.obj.dyhwCheckResult4);//行业类别
                $("#dyhw_input_result_4").val(data.obj.dyhwInputResult4);//行业类别
                $("#dyhw_check_result_5").val(data.obj.dyhwCheckResult5);//行业类别
                $("#dyhw_input_result_5").val(data.obj.dyhwInputResult5);//行业类别
                $("#dyhw_check_result_6").val(data.obj.dyhwCheckResult6);//行业类别
                $("#dyhw_input_result_6").val(data.obj.dyhwInputResult6);//行业类别
                $("#dyhw_min").val(data.obj.dyhwMin);//行业类别
                $("#dyhw_max").val(data.obj.dyhwMax);//行业类别
                $("#dyhw_bz").val(data.obj.dyhwBz);//行业类别
                $("#klw_check_result_1").val(data.obj.klwCheckResult1);//行业类别
                $("#klw_input_result_1").val(data.obj.klwInputResult1);//行业类别
                $("#klw_check_result_2").val(data.obj.klwCheckResult2);//行业类别
                $("#klw_input_result_2").val(data.obj.klwInputResult2);//行业类别
                $("#klw_check_result_3").val(data.obj.klwCheckResult3);//行业类别
                $("#klw_input_result_3").val(data.obj.klwCheckResult3);//行业类别

                $("#fjwzt_check_result_1").val(data.obj.fjwztCheckResult1);//行业类别
                $("#fjwzt_input_result_1").val(data.obj.fjwztInputResult1);//行业类别
                $("#fjwzt_min").val(data.obj.fjwztMin);//行业类别
                $("#fjwzt_max").val(data.obj.fjwztMax);//行业类别
                $("#fjwzt_bz").val(data.obj.fjwztBz);//行业类别
            }
        })
    }

    function isCompare(discount) {
        if(discount=="1"){
            $('tr.compare').show();
            $('td.single-show-6').attr("rowspan","6");
            $('td.single-show-3').attr("rowspan","3");
            $('td.check-result').show();

            $('td.is-cb').hide();
            $('td.is-hg').show();
        }else {
            $('tr.compare').hide();
            $('td.single-show-6').attr("rowspan","1");
            $('td.single-show-3').attr("rowspan","1");
            $('td.check-result').hide();

            $('td.is-cb').show();
            $('td.is-hg').hide();
        }
    }
    //    计算超标
    $('input.overproof').blur(function(){
        overproof();
    });
    function overproof() {
        var val=$('input:radio[name="hbJczfZfxxlr.sfdb"]:checked').val();
        if(val=="2"){
            //获取二氧化硫录入结果、最小值、最大值
            var eyhl_input_result_1 = $("#eyhl_input_result_1").val();
            var eyhl_min = $("#eyhl_min").val();
            var eyhl_max = $("#eyhl_max").val();
            if(eyhl_input_result_1&&eyhl_min&&eyhl_max){
                if(!isNaN(parseFloat(eyhl_input_result_1))&&!isNaN(parseFloat(eyhl_min))&&!isNaN(parseFloat(eyhl_max))){
                    if(parseFloat(eyhl_input_result_1)>=parseFloat(eyhl_min)&&parseFloat(eyhl_input_result_1)<=parseFloat(eyhl_max)){
                        $("#eyhl_is_cb").val("否")
                    }else {
                        $("#eyhl_is_cb").val("是")
                    }
                }else {
                    $("#eyhl_is_cb").val("数值错误")
                }
            }else {
                $("#eyhl_is_cb").val("")
            }
            //获取氮氧化物录入结果
            var dyhw_input_result_1 = $("#dyhw_input_result_1").val();
            var dyhw_min = $("#dyhw_min").val();
            var dyhw_max = $("#dyhw_max").val();
            if(dyhw_input_result_1&&dyhw_min&&dyhw_max){
                if(!isNaN(parseFloat(dyhw_input_result_1))&&!isNaN(parseFloat(dyhw_min))&&!isNaN(parseFloat(dyhw_max))){
                    if(parseFloat(dyhw_input_result_1)>=parseFloat(dyhw_min)&&parseFloat(dyhw_input_result_1)<=parseFloat(dyhw_max)){
                        $("#dyhw_is_cb").val("否")
                    }else {
                        $("#dyhw_is_cb").val("是")
                    }
                }else {
                    $("#dyhw_is_cb").val("数值错误")
                }
            }else {
                $("#dyhw_is_cb").val("")
            }
            //颗粒物计算
            var klw_input_result_1 = $("#klw_input_result_1").val();
            var klw_min = $("#klw_min").val();
            var klw_max = $("#klw_max").val();
            if(klw_input_result_1&&klw_min&&klw_max){
                if(!isNaN(parseFloat(klw_input_result_1))&&!isNaN(parseFloat(klw_min))&&!isNaN(parseFloat(klw_max))){
                    if(parseFloat(klw_input_result_1)>=parseFloat(klw_min)&&parseFloat(klw_input_result_1)<=parseFloat(klw_max)){
                        $("#klw_is_cb").val("否")
                    }else {
                        $("#klw_is_cb").val("是")
                    }
                }else {
                    $("#klw_is_cb").val("数值错误")
                }
            }else {
                $("#klw_is_cb").val("")
            }
            //非甲烷总烃
            var fjwzt_input_result_1 = $("#fjwzt_input_result_1").val();
            var fjwzt_min = $("#fjwzt_min").val();
            var fjwzt_max = $("#fjwzt_max").val();
            if(fjwzt_input_result_1&&fjwzt_min&&fjwzt_max){
                if(!isNaN(parseFloat(fjwzt_input_result_1))&&!isNaN(parseFloat(fjwzt_min))&&!isNaN(parseFloat(fjwzt_max))){
                    if(parseFloat(fjwzt_input_result_1)>=parseFloat(fjwzt_min)&&parseFloat(fjwzt_input_result_1)<=parseFloat(fjwzt_max)){
                        $("#fjwzt_is_cb").val("否")
                    }else {
                        $("#fjwzt_is_cb").val("是")
                    }
                }else {
                    $("#fjwzt_is_cb").val("数值错误")
                }
            }else {
                $("#fjwzt_is_cb").val("")
            }
        }
    }
</script>
</html>
