<%--
  Created by IntelliJ IDEA.
  User: panho
  Date: 2017-12-11
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/WEB-INF/views/system/common/base.jsp"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <table>
        <tr><input id='jcxmbf' type='hidden'></tr>
        <tr>
            <td>排序序号：</td><td><input type='text' name='hbSjcjQyJyjcJcxmV.xPx' value='16'></td>
            <input id='xkz' type='hidden'  value=''>
            <td >监测项目：</td><td><input type='hidden' name='hbSjcjQyJyjcJcxmV.xId' value='637BC1E6A682834CE05302FD10ACAA6A'>
            <input style='WIDTH: 150px; HEIGHT:25PX; FONT: 10pt Arial;border-top: solid 1px #a7b5bc;border-left: solid 1px #a7b5bc; border-right: solid 1px #ced9df;border-bottom: solid 0.1px #ced9df;' id='jcxm_view'  name='jcxm_view' onmouseover='this.focus();this.select();'onkeyup='autoComplete2.hdleEvent(event);'onclick='autoComplete2.expandAllItem();' />
            <input id='jcxmbh' type='hidden' name='hbSjcjQyJyjcJcxmV.jcxmzbid' onchange='changeBz();'><lable style='color:red;'>*</lable><span id='jcxmbt' style='display:none;'><font color='red'>必填</font></span></td></tr><tr id='biaozhun'><td >依据类型：</td><td><select id='yjlx' name='hbSjcjQyJyjcJcxmV.yjlx' onchange='changeType(this);'><option value=A>排放标准</option><option value=B>排污许可证</option><option value=C>环评</option><option value=D>其他文件</option><select></td><td>检测分析方法：</td><td ><select id='jcfs' onchange='changeJcFs(this);' name='hbSjcjQyJyjcJcxmV.jcfs'><option value=A>手工</option><option value=B>在线</option></select></td></tr>

        <tr><td id='ckxxid' style='visibility:hidden'>参考下限：</td><td id='ckxxz'  style='visibility:hidden'><input id='ckxx' type='text' name='hbSjcjQyJyjcJcxmV.ckxx'  value='' style='background:#CCCCCC' disabled ></td><td >参考上限：</td><td  ><input id='cksx' type='text' name='hbSjcjQyJyjcJcxmV.cksx'  value='0.1' style='background:#CCCCCC' disabled ></tr><tr><td id='xxid' style='visibility:hidden' >下限：</td><td id='xxz'  style='visibility:hidden'><input id='xx' type='text' name='hbSjcjQyJyjcJcxmV.xx'  value='0.03' ></td><td >上限：</td><td  ><input id='sx' type='text' name='hbSjcjQyJyjcJcxmV.sx'  value='0.1' ><lable id='btts' style='color:red;'>*</lable><span id='sxbt' style='display:none;'><font color='red'>必填</font></span><span id='sxgs' style='display:none;color:#F00'></span>&nbsp;<select id='xzdw'  style='width:80px' name='hbSjcjQyJyjcJcxmV.xzdw'><option value=1>mg/L</option><option value=2>个/L</option><option value=3>倍</option><option value=4>mg/m3</option><option value=5>级</option><option value=6>mg/KG</option><option value=7>dB</option><option value=8>m3/t</option><option value=9>TEQ ng/m3</option><option value=10>ug/L</option><option value=11>ug/m3</option><option value=12>Bq/L</option><option value=13>mg/Nm3</option><option value=14>kg/t</option><option value=15>个/ml</option><option value=16>个/100ml</option><option value=17>死亡率</option><option value=18>个/kg</option><option value=19>ng/L</option><option value=20>MPN/L</option><option value=21>无量纲</option><option value=22>kg/h</option><option value=23>ng-TEQ/L</option><option value=24>g/m2</option><option value=25>%</option><option value=26>g/m3</option><option value=27>°C</option><option value=28>mL/(L·15min)</option><option value=29>根纤维/cm3</option><option value=30>度</option><option value=31>ng-TEQ/m3</option><option value=32>ug/(dm2·d)</option><option value=33>g/kWh</option><option value=34>m3/h</option><option value=35>pgTEQ/L</option><option value=36>m3/兆瓦·时</option><option value=37>m3/100米布</option><option value=38>pg/m3</option><option value=39>ng/m3</option></select></td></tr><tr ><td >项目监测开始时间：</td><td  ><input type='text' name='hbSjcjQyJyjcJcxmV.qssj' class='Wdate' onfocus='javascript:WdatePicker();' value='' ></td><td  >项目监测结束时间：</td><td ><input type='text' name='hbSjcjQyJyjcJcxmV.jssj' class='Wdate' onfocus='javascript:WdatePicker();' value='' >延迟填报天数：<select id='kyhts' style='width:50px;' name='hbSjcjQyJyjcJcxmV.kyhts' ><option value='0'>0</option><option value='1'>1</option><option value='2'>2</option><option value='3'>3</option><option value='4'>4</option><option value='5'>5</option><option value='6'>6</option><option value='7'>7</option><option value='8'>8</option><option value='9'>9</option><option value='10'>10</option></select></td></tr><tr><td >监测频次：</td><td  >1次/<input type='text' style='width:30px;'  name='hbSjcjQyJyjcJcxmV.jcpc' id='jcpcsjcj' value='1'  againCheck='hbSjcjQyJyjcJcxmV.jcpc' datatype='n' nullmsg='请输入频次！' errormsg='请输入数字！' >&nbsp;<select id='pcdw'  style='width:70px;' name='hbSjcjQyJyjcJcxmV.pcdw' ><option value=A>天</option><option value=B>周</option><option value=C>月</option><option value=D>季度</option><option value=F>半年</option><option value=E>年</option></select></td><td  id='geshu0'>采样方法及个数：</td><td  id='geshu'><input type='text' name='hbSjcjQyJyjcJcxmV.cyff' placeholder = '请输入采样方法'  value='' >&nbsp;&nbsp;<select id='geshu1' style='width:70px;'name='hbSjcjQyJyjcJcxmV.dccygs'><option value=A>至少1个</option><option value=B>至少2个</option><option value=C>至少3个</option><option value=D>至少4个</option><option value=E>至少5个</option><option value=F>多个</option><option value=G>其他</option></select>

    </table>
</div>
</body>
<script type="text/javascript">
    layui.use(['layer','form'],function () {
        var layer = layui.layer;
        var form = layui.form;

        form.render();
        form.on("select(selectVersion)",function (data) {

        });

    });
</script>
</html>
