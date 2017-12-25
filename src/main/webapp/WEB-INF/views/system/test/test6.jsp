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
    <form id="form" class="layui-form" lay-filter="form">
        <table class="layui-table">
            <tr>
                <td style="width: 100px">选择版本号</td>
                <td style="width: 300px">
                    <select id="selectVersion" name="selectVersion" layfilter="selectVersion">
                        <option>请选择版本</option>
                    </select>
                </td>
                <td colspan="5">
                    <button type="button" class="layui-btn layui-btn-small" style="background:#437E95;">加载该版本</button>
                </td>
            </tr>
        </table>

        <table class="layui-table">
            <thead>
            <tr>
                <th style="width: 10%">污染源</th>
                <th style="width: 10%">排放设备</th>
                <th style="width: 15%">监测点</th>
                <th style="width: 10%">检测项目</th>
                <th style="width: 10%">依据类型</th>
                <th style="width: 10%">标准名称</th>
                <th style="width: 5%">限值</th>
                <th style="width: 5%">监测方式</th>
                <th style="width: 8%">监测频次</th>
                <th style="width: 10%">监测设备</th>
                <th style="width: 15%">监测方法</th>
            </tr>
            </thead>
            <tbody id="">
            <tr>
                <td rowspan='9' id='5D6E8BA75B245989E05301FD10ACE9D1' class='flfq'>
                    <a title='查看详情' onclick='selFl("5D6E8BA75B245989E05301FD10ACE9D1");'>废气</a>
                </td>
                <td rowspan='7' id='5D6E8BA75B285989E05301FD10ACE9D1' class='fqsb'>
                    <a title='查看详情' onclick='selFqSb("5D6E8BA75B285989E05301FD10ACE9D1");'>排放设备1</a>
                </td>
                <td rowspan='7' id='5D6E8BA75B305989E05301FD10ACE9D1' class='fqdian'>
                    <a title='查看详情' onclick='selFqDian("5D6E8BA75B305989E05301FD10ACE9D1");'>废气监测点1</a>
                </td>
                <td rowspan='1' id='5D6E8BA75B645989E05301FD10ACE9D1' class='fqpro'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B645989E05301FD10ACE9D1");'>甲醇</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排污许可证</td>
                <td style='line-height:30px;' class='eqp'>石油化学工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>50</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'>气相色谱法——固定污染源排气中甲醇的测定气相色谱法</td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B655989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B655989E05301FD10ACE9D1");'>甲苯</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>0.1</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B665989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B665989E05301FD10ACE9D1");'>总氮（以N计）</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>15</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B675989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B675989E05301FD10ACE9D1");'>pH值</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>6—9</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B685989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B685989E05301FD10ACE9D1");'>二甲基甲酰胺（DMF..</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>0.1</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td><td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B695989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B695989E05301FD10ACE9D1");'>化学需氧量</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>60</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td><td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B6A5989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B6A5989E05301FD10ACE9D1");'>色度</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>30</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B6B5989E05301FD10ACE9D1' class='fqpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B6B5989E05301FD10ACE9D1");'>总磷（以P计）</a>
                </td>
                <td style=""><a>进口监测点</a></td>
                <td rowspan='1' id='5D6E8BA75B7E5989E05301FD10ACE9D1' class='fspro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B7E5989E05301FD10ACE9D1");'>甲醇</a>
                </td>
                <td style='line-height:30px;' class='eqp'>其他文件</td>
                <td style='line-height:30px;' class='eqp'>大气污染物综合排放标准</td>
                <td style='line-height:30px;' class='eqp'>12</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' colspan='2' id='5D6E8BA75B7F5989E05301FD10ACE9D1' class='fsdian' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selFsDian("5D6E8BA75B7F5989E05301FD10ACE9D1");'>jkjcd</a>
                </td>
                <td rowspan='1' id='5D6E8BA75B805989E05301FD10ACE9D1' class='fspro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B805989E05301FD10ACE9D1");'>氨氮（NH3-N）</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>合成革与人造革工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>3</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td><td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B825989E05301FD10ACE9D1' class='flwzz' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selFl("5D6E8BA75B825989E05301FD10ACE9D1");'>无组织</a>
                </td>
                <td rowspan='1' colspan='2' id='5D6E8BA75B835989E05301FD10ACE9D1' class='wzzdian' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selWzzDian("5D6E8BA75B835989E05301FD10ACE9D1");'>无组织监测点1</a>
                </td>
                <td rowspan='1' id='5D6E8BA75B845989E05301FD10ACE9D1' class='wzzpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B845989E05301FD10ACE9D1");'>多环芳烃</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>炼焦化学工业污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>0.05</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B855989E05301FD10ACE9D1' class='flzb' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selFl("5D6E8BA75B855989E05301FD10ACE9D1");'>周边环境</a>
                </td>
                <td rowspan='1' colspan='2' id='5D6E8BA75B865989E05301FD10ACE9D1' class='zbhjdian' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selZbDian("5D6E8BA75B865989E05301FD10ACE9D1");'>周边监测点1</a>
                </td>
                <td rowspan='1' id='5D6E8BA75B875989E05301FD10ACE9D1' class='zbhjpro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B875989E05301FD10ACE9D1");'>化学需氧量</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>电镀污染物排放标准</td>
                <td style='line-height:30px;' class='eqp'>50</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td><td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='2' id='5D6E8BA75B885989E05301FD10ACE9D1' class='flzs' style='height:60px;line-height:60px'>
                    <a title='查看详情' onclick='selFl("5D6E8BA75B885989E05301FD10ACE9D1");'>厂界噪声</a>
                </td>
                <td rowspan='2' colspan='2' id='5D6E8BA75B895989E05301FD10ACE9D1' class='cjzsdian' style='height:60px;line-height:60px'>
                    <a title='查看详情' onclick='selZsDian("5D6E8BA75B895989E05301FD10ACE9D1");'>东厂界</a>
                </td>
                <td rowspan='1' id='5D6E8BA75B8A5989E05301FD10ACE9D1' class='cjzspro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B8A5989E05301FD10ACE9D1");'>设备噪声</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>工业企业厂界环境噪声排放标准</td>
                <td style='line-height:30px;' class='eqp'>45;35</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td>
                <td style='line-height:30px;' class='eqp'></td>
            </tr>
            <tr>
                <td rowspan='1' id='5D6E8BA75B8B5989E05301FD10ACE9D1' class='cjzspro' style='height:30px;line-height:30px'>
                    <a title='查看详情' onclick='selJcxm("5D6E8BA75B8B5989E05301FD10ACE9D1");'>设备噪声</a>
                </td>
                <td style='line-height:30px;' class='eqp'>排放标准</td>
                <td style='line-height:30px;' class='eqp'>工业企业厂界环境噪声排放标准</td>
                <td style='line-height:30px;' class='eqp'>45;35</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;手工</td>
                <td style='line-height:30px;'class='eqp'>&nbsp;&nbsp;1次&nbsp;&nbsp;/&nbsp;&nbsp;1天</td>
                <td style='line-height:30px;'class='eqp'></td><td style='line-height:30px;' class='eqp'></td>
            </tr>
            </tbody>
        </table>

    </form>
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
