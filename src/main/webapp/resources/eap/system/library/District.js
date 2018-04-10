;(function ($,window,document,undefined) {
    /**
     * 默认值
     * @type {{}}
     */
    var defaults = {
        layuiForm:new Object(),
        layer:new Object(),
        areas:[],
        citys:[],
        districts:[],
        province:0,
        city:0,
        district:0,
        level:3,
        onSelect:function (level,value) {

        },
        onSelectResult:function (sheng,shi,xian) {

        }
    };

    var settings;

    var province = null;//当前选中省
    var city = null;//当前选中市
    var district = null;//当前选中县

    var areaOptions = [];//省列表
    var citysOptions = [];//市列表
    var districtOptions = [];//区县列表

    /**
     * 方法
     * @type {{init: init, destory: destory}}
     */
    var methods = {
        setValue:function (sheng,shi,xian) {
            $("#provinceSelect").val(sheng);
            province = sheng;
            selectProvince(province);
            $("#citySelect").val(shi);
            city = shi;
            selectCity(city);
            $("#districtSelect").val(xian);
            district = xian;
            selectDistrict(xian);
            settings.onSelectResult(sheng,shi,xian);
        },
        init:function (options) {
            return this.each(function () {
                var $this = $(this);
                var data = $this.data('district');
                //检测是否初始化，如果未初始化执行初始化代码（类似java的单例模式）
                if(!data){
                    $(this).data('district', {
                        target: $this,
                        district: district
                    });
                };
                settings = $.extend({},defaults, options);

                $.ajax({
                    type:'get',
                    url:baseServerUrl+"area/treeView",
                    cache:false,
                    async:false,
                    data:{
                        parentId : 1
                    },
                    success:function (data,status) {
                        if(status=="success"){
                            if(data.body.resultCode=='0'){
                                settings.areas = data.body.entity;
                                settings.citys = data.body.entity[0].children;
                                settings.districts = data.body.entity[0].children[0].children;

                                areaOptions.push('<option value="">请选择省</option>');
                                citysOptions.push('<option value="">请选择市</option>');
                                districtOptions.push('<option value="">请选择县</option>');
                                for (var i in settings.areas) {
                                    areaOptions.push('<option value="'+settings.areas[i].areaId+'">'+settings.areas[i].name+'</option>');
                                };
                                for (var i in settings.citys) {
                                    citysOptions.push('<option value="'+settings.citys[i].areaId+'">'+settings.areas[i].name+'</option>');
                                };
                                for (var i in settings.districts) {
                                    districtOptions.push('<option value="'+settings.districts[i].areaId+'">'+settings.districts[i].name+'</option>');
                                };

                                var areaHtml = '<div class="layui-input-inline">' +
                                    '<select id="provinceSelect" lay-filter="province" class="select-title" lay-search>' +
                                    '</select>'+
                                    '</div>';
                                var cityHtml = '<div class="layui-input-inline">' +
                                    '<select id="citySelect" lay-filter="city" class="select-title" lay-search>' +
                                    '</select>'+
                                    '</div>';
                                var districtHtml = '<div class="layui-input-inline">' +
                                    '<select id="districtSelect" lay-filter="district" class="select-title" lay-search>' +
                                    '</select>'+
                                    '</div>';
                                $this.append(areaHtml);
                                $this.append(cityHtml);
                                if(settings.level==3){
                                    $this.append(districtHtml);
                                }
                                $('#provinceSelect').append(areaOptions.join(''));
                                $('#citySelect').append(citysOptions.join(''));
                                $('#districtSelect').append(districtOptions.join(''));

                                settings.layuiForm.render();

                                settings.layuiForm.on('select(province)',function (selectData) {
                                    //选择省
                                    province = selectData.value;
                                    selectProvince(province);
                                });
                                settings.layuiForm.on('select(city)',function (selectData) {
                                    //选择市
                                    city = selectData.value;
                                    selectCity(city);
                                });
                                settings.layuiForm.on('select(district)',function (selectData) {
                                    //选择县
                                    district = selectData.value;
                                    selectDistrict(selectData.value);
                                })

                            }else {
                                settings.layer.msg(data.body.resultContent, {icon: 5});
                            }
                        }else {
                            settings.layer.msg('网络错误', {icon: 5});
                        }
                    }
                });

            });
        },
        destory:function () {
            return this.each(function () {
                var $this = $(this),
                    data = $this.data('district');
                $(window).unbind('.district');
                data.district.remove();
                $this.removeData('tooltip');
            });
        }
    };
    //选择省
    function selectProvince(province) {
        if(province){
            for (var i = 0; i < settings.areas.length; i++) {
                if(province==settings.areas[i].areaId){
                    $('#citySelect').empty();
                    $('#districtSelect').empty();
                    settings.citys = settings.areas[i].children;
                    settings.districts = settings.areas[i].children[0].children;
                    citysOptions.length = 0;
                    districtOptions.length = 0;
                    citysOptions.push('<option value="">请选择市</option>');
                    districtOptions.push('<option value="">请选择县</option>');
                    for (var i in settings.citys) {
                        citysOptions.push('<option value="'+settings.citys[i].areaId+'">'+settings.citys[i].name+'</option>');
                    };
                    for (var i in settings.districts) {
                        districtOptions.push('<option value="'+settings.districts[i].areaId+'">'+settings.districts[i].name+'</option>');
                    };

                    $('#citySelect').append(citysOptions.join(''));
                    $('#districtSelect').append(districtOptions.join(''));
                    settings.layuiForm.render();
                    break;
                }
            }
            settings.onSelect(1,province);
            settings.onSelectResult(province,null,null);
        }else {
            $('#citySelect').empty();
            $('#districtSelect').empty();
            citysOptions.length = 0;
            districtOptions.length = 0;
            citysOptions.push('<option value="">请选择市</option>');
            districtOptions.push('<option value="">请选择县</option>');
            $('#citySelect').append(citysOptions.join(''));
            $('#districtSelect').append(districtOptions.join(''));
            settings.onSelectResult(null,null,null);
            settings.layuiForm.render();
        }
    }
    //选择市
    function selectCity(city) {
        if(city){
            for (var i = 0; i < settings.citys.length; i++) {
                if(city==settings.citys[i].areaId){

                    $('#districtSelect').empty();
                    settings.districts = settings.citys[i].children;
                    districtOptions.length = 0;
                    districtOptions.push('<option value="">请选择县</option>');
                    for (var i in settings.districts) {
                        districtOptions.push('<option value="'+settings.districts[i].areaId+'">'+settings.districts[i].name+'</option>');
                    };
                    $('#districtSelect').append(districtOptions.join(''));
                    settings.layuiForm.render();
                    break;
                }
            }
            settings.onSelect(2,city);
            settings.onSelectResult(province,city,null)
        }else {
            $('#districtSelect').empty();
            districtOptions.length = 0;
            districtOptions.push('<option value="">请选择县</option>');
            $('#districtSelect').append(districtOptions.join(''));
            settings.onSelectResult(province,null,null)
            settings.layuiForm.render();
        }
    }
    //选择县
    function selectDistrict(district) {
        settings.onSelect(3,district);
        settings.onSelectResult(province,city,district)
    }

    $.fn.District = function (method,options) {
        // 方法调用
        if (methods[method]) {
            return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
        } else if (typeof method === 'object' || !method) {
            return methods.init.apply(this, arguments);
        } else {
            $.error('Method' + method + 'does not exist on jQuery.tooltip');
        }
    };
})(jQuery,window,document);