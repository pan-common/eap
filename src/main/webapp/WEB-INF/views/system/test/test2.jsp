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
    /*计算合格*/
    .qualified{

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
        <td><input id="jcdw" type="text" name="hbJczfZfxxlr.jcdw"></td>
    </tr>
    <tr>
        <td><label>行业类别:</label></td>
        <td><input id="hylb" type="text" name="hbJczfZfxxlr.hylb"></td>
        <td><label>是否比较:</label></td>
        <td>
            <input type="radio" name="hbJczfZfxxlr.sfdb" value="1" >是
            <input type="radio" name="hbJczfZfxxlr.sfdb" value="2" checked>否
        </td>
    </tr>
    <tr>
        <td><label>检测日期:</label></td>
        <td><input id="jcrq" type="text" name="hbJczfZfxxlr.jcrq"></td>
        <td><label>录入日期:</label></td>
        <td><input id="lrrq" type="text" name="hbJczfZfxxlr.lrrq"></td>
    </tr>
    <tr>
        <td><label>录入人:</label></td>
        <td><input id="lrrmc" type="text" name="hbJczfZfxxlr.lrrmc"></td>
        <td><label>备注:</label></td>
        <td><textarea  name="hbJczfZfxxlr.bz" id="bz" cols="30" rows="2"></textarea></td>
    </tr>
</table>
<label>监测项目和结果</label>
<table class="jcTable">
    <thead>
    <tr>
        <td rowspan="2">项目</td><td rowspan="2" class="check-result">在线设备监测结果</td><td rowspan="2">监督性监测结果</td><td colspan="2" class="unCompare">限值</td><td rowspan="2" class="unCompare">标准</td><td rowspan="2" class="is-cb">是否超标</td><td rowspan="2" class="is-hg">是否合格</td>
    </tr>
    <tr class="unCompare">
        <td>上限</td><td>下限</td>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td rowspan="6" class="single-show-6">二氧化硫</td>
        <td class="table-input check-result"><input class="qualified" id="eyhl_check_result_1" name="hbJczfZfxxlr.eyhlCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="eyhl_input_result_1" name="hbJczfZfxxlr.eyhlInputResult1" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 unCompare"><input class="overproof" id="eyhl_min" name="hbJczfZfxxlr.eyhlMin" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 unCompare"><input class="overproof" id="eyhl_max" name="hbJczfZfxxlr.eyhlMax" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 unCompare"><input id="eyhl_bz" name="hbJczfZfxxlr.eyhlBz" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 is-cb"><input id="eyhl_is_cb" type="text" style="width: 100px" readonly></td>
        <td rowspan="6" class="table-input single-show-6 is-hg"><input id="eyhl_is_hg" type="text" style="width: 100px" readonly></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="eyhl_check_result_2" name="hbJczfZfxxlr.eyhlCheckResult2" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="eyhl_input_result_2" name="hbJczfZfxxlr.eyhlInputResult2" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="eyhl_check_result_3" name="hbJczfZfxxlr.eyhlCheckResult3" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="eyhl_input_result_3" name="hbJczfZfxxlr.eyhlInputResult3" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="eyhl_check_result_4" name="hbJczfZfxxlr.eyhlCheckResult4" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="eyhl_input_result_4" name="hbJczfZfxxlr.eyhlInputResult4" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="eyhl_check_result_5" name="hbJczfZfxxlr.eyhlCheckResult5" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="eyhl_input_result_5" name="hbJczfZfxxlr.eyhlInputResult5" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="eyhl_check_result_6" name="hbJczfZfxxlr.eyhlCheckResult6" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="eyhl_input_result_6" name="hbJczfZfxxlr.eyhlInputResult6" type="text" style="width: 100px"></td>
    </tr>

    <tr>
        <td rowspan="6" class="single-show-6">氮氧化物</td>
        <td class="table-input check-result"><input class="qualified" id="dyhw_check_result_1" name="hbJczfZfxxlr.dyhwCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="dyhw_input_result_1" name="hbJczfZfxxlr.dyhwInputResult1" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 unCompare" single-show><input class="overproof" id="dyhw_min" name="hbJczfZfxxlr.dyhwMin" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 unCompare"><input class="overproof" id="dyhw_max" name="hbJczfZfxxlr.dyhwMax" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 unCompare"><input id="dyhw_bz" name="hbJczfZfxxlr.dyhwBz" type="text" style="width: 100px"></td>
        <td rowspan="6" class="table-input single-show-6 is-cb"><input id="dyhw_is_cb" type="text" style="width: 100px" readonly></td>
        <td rowspan="6" class="table-input single-show-6 is-hg"><input id="dyhw_is_hg" type="text" style="width: 100px" readonly></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="dyhw_check_result_2" name="hbJczfZfxxlr.dyhwCheckResult2" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="dyhw_input_result_2" name="hbJczfZfxxlr.dyhwInputResult2" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="dyhw_check_result_3" name="hbJczfZfxxlr.dyhwCheckResult3" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="dyhw_input_result_3" name="hbJczfZfxxlr.dyhwInputResult3" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="dyhw_check_result_4" name="hbJczfZfxxlr.dyhwCheckResult4" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="dyhw_input_result_4" name="hbJczfZfxxlr.dyhwInputResult4" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="dyhw_check_result_5" name="hbJczfZfxxlr.dyhwCheckResult5" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="dyhw_input_result_5" name="hbJczfZfxxlr.dyhwInputResult5" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="dyhw_check_result_6" name="hbJczfZfxxlr.dyhwCheckResult6" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="dyhw_input_result_6" name="hbJczfZfxxlr.dyhwInputResult6" type="text" style="width: 100px"></td>
    </tr>

    <tr>
        <td rowspan="3" class="single-show-3">颗粒物</td>
        <td class="table-input check-result"><input class="qualified" id="klw_check_result_1" name="hbJczfZfxxlr.klwCheckResult1" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="overproof" id="klw_input_result_1" name="hbJczfZfxxlr.klwInputResult1" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3 unCompare"><input class="overproof" id="klw_min" name="hbJczfZfxxlr.klwMin" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3 unCompare"><input class="overproof" id="klw_max" name="hbJczfZfxxlr.klwMax" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3 unCompare"><input id="klw_bz" name="hbJczfZfxxlr.klwBz" type="text" style="width: 100px"></td>
        <td rowspan="3" class="table-input single-show-3 is-cb"><input id="klw_is_cb" type="text" style="width: 100px" readonly></td>
        <td rowspan="3" class="table-input single-show-3 is-hg"><input id="klw_is_hg" type="text" style="width: 100px" readonly></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="klw_check_result_2" name="hbJczfZfxxlr.klwCheckResult2" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="klw_input_result_2" name="hbJczfZfxxlr.klwInputResult2" type="text" style="width: 100px"></td>
    </tr>
    <tr class="compare">
        <td class="table-input"><input class="qualified" id="klw_check_result_3" name="hbJczfZfxxlr.klwCheckResult3" type="text" style="width: 100px"></td>
        <td class="table-input"><input class="qualified" id="klw_input_result_3" name="hbJczfZfxxlr.klwInputResult3" type="text" style="width: 100px"></td>
    </tr>
    <tr class="unCompare">
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
        $('input[name="hbJczfZfxxlr.sfdb"]').each(function(){
            $(this).click(function(){
                var discount = $(this).val();
                isCompare(discount);
            });
        });
        isCompare("2");
    });

    function isCompare(discount) {
        if(discount=="1"){
            $('tr.compare').show();
            $('tr.unCompare').hide();
            $('td.unCompare').hide();
            $('td.single-show-6').attr("rowspan","6");
            $('td.single-show-3').attr("rowspan","3");
            $('td.check-result').show();

            $('td.is-cb').hide();
            $('td.is-hg').show();
        }else {
            $('tr.compare').hide();
            $('tr.unCompare').show();
            $('td.unCompare').show();
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
            if(eyhl_input_result_1&&eyhl_max){
                if(!eyhl_min){
                    var eyhl_min = 0;
                }
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
            if(dyhw_input_result_1&&dyhw_max){
                if(!dyhw_min){
                    var dyhw_min = 0;
                }
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
            if(klw_input_result_1&&klw_max){
                if(!klw_min){
                    var klw_min = 0;
                }
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
            if(fjwzt_input_result_1&&fjwzt_max){
                if(!fjwzt_min){
                    var fjwzt_min = 0;
                }
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

    //=======================================================计算合格================================================
    $('input.qualified').blur(function(){
        qualified();
    });
    function qualified() {
        //计算二氧化硫合格===
        var eyhlhg = new Array();
        //===================================
        var eyhl_check_result_1 = $("#eyhl_check_result_1").val();
        var eyhl_input_result_1 = $("#eyhl_input_result_1").val();
        if(eyhl_check_result_1&&eyhl_input_result_1){
            if(!isNaN(parseFloat(eyhl_check_result_1))&&!isNaN(parseFloat(eyhl_input_result_1))){
                eyhlhg[0]=eyhlQualified(parseFloat(eyhl_check_result_1),parseFloat(eyhl_input_result_1));
            }
        }
        //=========================================
        var eyhl_check_result_2 = $("#eyhl_check_result_2").val();
        var eyhl_input_result_2 = $("#eyhl_input_result_2").val();
        if(eyhl_check_result_2&&eyhl_input_result_2){
            if(!isNaN(parseFloat(eyhl_check_result_2))&&!isNaN(parseFloat(eyhl_input_result_2))){
                eyhlhg[1]=eyhlQualified(parseFloat(eyhl_check_result_2),parseFloat(eyhl_input_result_2));
            }
        }
        //=========================================
        var eyhl_check_result_3 = $("#eyhl_check_result_3").val();
        var eyhl_input_result_3 = $("#eyhl_input_result_3").val();
        if(eyhl_check_result_3&&eyhl_input_result_3){
            if(!isNaN(parseFloat(eyhl_check_result_3))&&!isNaN(parseFloat(eyhl_input_result_3))){
                eyhlhg[2]=eyhlQualified(parseFloat(eyhl_check_result_3),parseFloat(eyhl_input_result_3));
            }
        }
        //=========================================
        var eyhl_check_result_4 = $("#eyhl_check_result_4").val();
        var eyhl_input_result_4 = $("#eyhl_input_result_4").val();
        if(eyhl_check_result_4&&eyhl_input_result_4){
            if(!isNaN(parseFloat(eyhl_check_result_4))&&!isNaN(parseFloat(eyhl_input_result_4))){
                eyhlhg[3]=eyhlQualified(parseFloat(eyhl_check_result_4),parseFloat(eyhl_input_result_4));
            }
        }
        //=========================================
        var eyhl_check_result_5 = $("#eyhl_check_result_5").val();
        var eyhl_input_result_5 = $("#eyhl_input_result_5").val();
        if(eyhl_check_result_5&&eyhl_input_result_5){
            if(!isNaN(parseFloat(eyhl_check_result_5))&&!isNaN(parseFloat(eyhl_input_result_5))){
                eyhlhg[4]=eyhlQualified(parseFloat(eyhl_check_result_5),parseFloat(eyhl_input_result_5));
            }
        }
        //=========================================
        var eyhl_check_result_6 = $("#eyhl_check_result_6").val();
        var eyhl_input_result_6 = $("#eyhl_input_result_6").val();
        if(eyhl_check_result_6&&eyhl_input_result_6){
            if(!isNaN(parseFloat(eyhl_check_result_6))&&!isNaN(parseFloat(eyhl_input_result_6))){
                eyhlhg[5]=eyhlQualified(parseFloat(eyhl_check_result_6),parseFloat(eyhl_input_result_6));
            }
        }
        if(eyhlhg.length>=3){
            var a = 0;
            for (var i = 0; i < eyhlhg.length; i++) {
                if(eyhlhg[i]=="是"){
                    a++;
                }
            }
            if(a>=3){
                $("#eyhl_is_hg").val("是")
            }else {
                $("#eyhl_is_hg").val("否")
            }
        }else {
            $("#eyhl_is_hg").val("")
        }
        //============计算氮氧化物合格=========
        var dyhwhg = new Array();
        //===================================
        var dyhw_check_result_1 = $("#dyhw_check_result_1").val();
        var dyhw_input_result_1 = $("#dyhw_input_result_1").val();
        if(dyhw_check_result_1&&dyhw_input_result_1){
            if(!isNaN(parseFloat(dyhw_check_result_1))&&!isNaN(parseFloat(dyhw_input_result_1))){
                dyhwhg[0]=eyhlQualified(parseFloat(dyhw_check_result_1),parseFloat(dyhw_input_result_1));
            }
        }
        //=========================================
        var dyhw_check_result_2 = $("#dyhw_check_result_2").val();
        var dyhw_input_result_2 = $("#dyhw_input_result_2").val();
        if(dyhw_check_result_2&&dyhw_input_result_2){
            if(!isNaN(parseFloat(dyhw_check_result_2))&&!isNaN(parseFloat(dyhw_input_result_2))){
                dyhwhg[1]=eyhlQualified(parseFloat(dyhw_check_result_2),parseFloat(dyhw_input_result_2));
            }
        }
        //=========================================
        var dyhw_check_result_3 = $("#dyhw_check_result_3").val();
        var dyhw_input_result_3 = $("#dyhw_input_result_3").val();
        if(dyhw_check_result_3&&dyhw_input_result_3){
            if(!isNaN(parseFloat(dyhw_check_result_3))&&!isNaN(parseFloat(dyhw_input_result_3))){
                dyhwhg[2]=eyhlQualified(parseFloat(dyhw_check_result_3),parseFloat(dyhw_input_result_3));
            }
        }
        //=========================================
        var dyhw_check_result_4 = $("#dyhw_check_result_4").val();
        var dyhw_input_result_4 = $("#dyhw_input_result_4").val();
        if(dyhw_check_result_4&&dyhw_input_result_4){
            if(!isNaN(parseFloat(dyhw_check_result_4))&&!isNaN(parseFloat(dyhw_input_result_4))){
                dyhwhg[3]=eyhlQualified(parseFloat(dyhw_check_result_4),parseFloat(dyhw_input_result_4));
            }
        }
        //=========================================
        var dyhw_check_result_5 = $("#dyhw_check_result_5").val();
        var dyhw_input_result_5 = $("#dyhw_input_result_5").val();
        if(dyhw_check_result_5&&dyhw_input_result_5){
            if(!isNaN(parseFloat(dyhw_check_result_5))&&!isNaN(parseFloat(dyhw_input_result_5))){
                dyhwhg[4]=eyhlQualified(parseFloat(dyhw_check_result_5),parseFloat(dyhw_input_result_5));
            }
        }
        //=========================================
        var dyhw_check_result_6 = $("#dyhw_check_result_6").val();
        var dyhw_input_result_6 = $("#dyhw_input_result_6").val();
        if(dyhw_check_result_6&&dyhw_input_result_6){
            if(!isNaN(parseFloat(dyhw_check_result_6))&&!isNaN(parseFloat(dyhw_input_result_6))){
                dyhwhg[5]=eyhlQualified(parseFloat(dyhw_check_result_6),parseFloat(dyhw_input_result_6));
            }
        }
        if(dyhwhg.length>=3){
            var a = 0;
            for (var i = 0; i < dyhwhg.length; i++) {
                if(dyhwhg[i]=="是"){
                    a++;
                }
            }
            if(a>=3){
                $("#dyhw_is_hg").val("是")
            }else {
                $("#dyhw_is_hg").val("否")
            }
        }else {
            $("#dyhw_is_hg").val("")
        }
        //============计算颗粒物合格=========
        var klwhg = new Array();
        //===================================
        var klw_check_result_1 = $("#klw_check_result_1").val();
        var klw_input_result_1 = $("#klw_input_result_1").val();
        if(klw_check_result_1&&klw_input_result_1){
            if(!isNaN(parseFloat(klw_check_result_1))&&!isNaN(parseFloat(klw_input_result_1))){
                klwhg[0]=klwQualified(parseFloat(klw_check_result_1),parseFloat(klw_input_result_1));
            }
        }
        //=========================================
        var klw_check_result_2 = $("#klw_check_result_2").val();
        var klw_input_result_2 = $("#klw_input_result_2").val();
        if(klw_check_result_2&&klw_input_result_2){
            if(!isNaN(parseFloat(klw_check_result_2))&&!isNaN(parseFloat(klw_input_result_2))){
                klwhg[1]=klwQualified(parseFloat(klw_check_result_2),parseFloat(klw_input_result_2));
            }
        }
        //=========================================
        var klw_check_result_3 = $("#klw_check_result_3").val();
        var klw_input_result_3 = $("#klw_input_result_3").val();
        if(klw_check_result_3&&klw_input_result_3){
            if(!isNaN(parseFloat(klw_check_result_3))&&!isNaN(parseFloat(klw_input_result_3))){
                klwhg[2]=klwQualified(parseFloat(klw_check_result_3),parseFloat(klw_input_result_3));
            }
        }
        if(klwhg.length>=2){
            var a = 0;
            for (var i = 0; i < klwhg.length; i++) {
                if(klwhg[i]=="是"){
                    a++;
                }
            }
            if(a>=2){
                $("#klw_is_hg").val("是")
            }else {
                $("#klw_is_hg").val("否")
            }
        }else {
            $("#klw_is_hg").val("")
        }

    }
    //================计算二氧化硫是否合格==================
    function eyhlQualified(check_result,input_result) {
        var flag = false;
        var min = 0;
        var max = 0;
        if(check_result>=250){
            min = check_result*0.85;
            max = check_result*1.15;
        }else if(check_result>=50&&check_result<250){
            min = check_result-20;
            max = check_result+20;
        }else if(check_result>=20&&check_result<50){
            min = check_result*0.70;
            max = check_result*1.30;
        }else if(check_result<20){
            min = check_result-6;
            max = check_result+6;
        }
        if(input_result>=min&&input_result<=max){
            flag = true;
        }
        return flag?"是":"否";
    }
    //================计算氮氧化物是否合格==================
    function dyhwQualified(check_result,input_result) {
        return eyhlQualified(check_result,input_result);
    }
    //================计算颗粒物是否合格==================
    function klwQualified(check_result,input_result) {
        var flag = false;
        var min = 0;
        var max = 0;
        if(check_result>200){
            min = check_result*0.85;
            max = check_result*1.15;
        }else if(check_result>100&&check_result<=200){
            min = check_result*0.80;
            max = check_result*1.20;
        }else if(check_result>50&&check_result<=100){
            min = check_result*0.75;
            max = check_result*1.25;
        }else if(check_result>20&&check_result<=50){
            min = check_result*0.70;
            max = check_result*1.30;
        }else if(check_result>10&&check_result<=20){
            min = check_result-6;
            max = check_result+6;
        }else if(check_result<=10){
            min = check_result+5;
            max = check_result-5;
        }
        if(input_result>=min&&input_result<=max){
            flag = true;
        }
        return flag?"是":"否";
    }
</script>
</html>
