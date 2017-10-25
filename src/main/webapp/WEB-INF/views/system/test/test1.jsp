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
<form class="layui-form">
    <div class="layui-form-item">
        <label class="layui-form-label"><span style="color: #cf0000;">*</span>收货地址</label>
        <div class="layui-input-inline">
            <select id="province" name="province" class="state" lay-filter="province">
                <option value=""></option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select id="city" name="city" class="state" lay-filter="city">
                <option value=""></option>
            </select>
        </div>
        <div class="layui-input-inline">
            <select id="district" name="district" class="state" lay-filter="district">
                <option value=""></option>
            </select>
        </div>
    </div>
</form>
</body>
<script type="text/javascript">
    layui.use(['layer','form'],function () {
        var form = layui.form;
        var areas;
        $.ajax({
            url:baseServerUrl+"area/treeView",
            dataType:"json",
            async:false,
            data:{
                parentId:1
            },
            type:"GET",
            success:function (data) {
                areas = data.body.entity;
            },
            error:function () {

            }
        });
        $("#province").empty();
        $("#city").empty();
        $("#district").empty();
//        $("#province").append('<option value=""></option>');
//        $("#city").append('<option value=""></option>');
//        $("#district").append('<option value=""></option>');
        var citys = areas[0].children;
        var districts = citys[0].children;

        for (var i = 0; i < areas.length; i++) {
            var province = '<option value="'+areas[i].areaId+'">'+areas[i].name+'</option>';
            $("#province").append(province);
        }
        for (var i = 0; i < citys.length; i++) {
            var city = '<option value="'+citys[i].areaId+'">'+citys[i].name+'</option>';
            $("#city").append(city);
        }
        for (var i = 0; i < districts.length; i++) {
            var district = '<option value="'+districts[i].areaId+'">'+districts[i].name+'</option>';
            $("#district").append(district);
        }
        form.render();
        form.on('select(province)', function(data){
            //监听省选择
            citys = selectCitysByAreaId(data.value)
            $("#city").empty();
            for (var i = 0; i < citys.length; i++) {
                var city = '<option value="'+citys[i].areaId+'">'+citys[i].name+'</option>';
                $("#city").append(city);
            }
            $("#district").empty();
            var districts = citys[0].children;
            for (var i = 0; i < districts.length; i++) {
                var district = '<option value="'+districts[i].areaId+'">'+districts[i].name+'</option>';
                $("#district").append(district);
            }
            form.render();
        });
        form.on('select(city)', function(data){
            //监听市选择
            districts = selectDistrictByAreaId(data.value);
            $("#district").empty();
            for (var i = 0; i < districts.length; i++) {
                var district = '<option value="'+districts[i].areaId+'">'+districts[i].name+'</option>';
                $("#district").append(district);
            }
            form.render();
        });

        function selectCitysByAreaId(areaId) {
            var result;
            for (var i = 0; i < areas.length; i++) {
                if(areaId==areas[i].areaId){
                    result = areas[i].children;
                }
            }
            return result;
        }

        function selectDistrictByAreaId(areaId) {
            var result;
            for (var i = 0; i < citys.length; i++) {
                if(areaId==citys[i].areaId){
                    result = citys[i].children;
                }
            }
            return result;
        }

    });
</script>
</html>