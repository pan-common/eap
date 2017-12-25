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
        onSelect:function (level,value) {

        }
    };
    /**
     * 方法
     * @type {{init: init, destory: destory}}
     */
    var methods = {
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
                var settings = $.extend({},defaults, options);

                $.get(baseServerUrl+"area/treeView",{
                    parentId : 1
                },function (data,status) {
                    if(status=="success"){
                        if(data.body.resultCode=='0'){
                            settings.areas = data.body.entity;
                            settings.citys = data.body.entity[0].children;
                            settings.districts = data.body.entity[0].children[0].children;

                            var areaOptions = [];
                            var citysOptions = [];
                            var districtOptions = [];
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
                            $this.append(districtHtml);

                            $('#provinceSelect').append(areaOptions.join(''));
                            $('#citySelect').append(citysOptions.join(''));
                            $('#districtSelect').append(districtOptions.join(''));

                            settings.layuiForm.render();

                            settings.layuiForm.on('select(province)',function (selectData) {
                                //选择省
                                var province = selectData.value;
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
                                }else {
                                    $('#citySelect').empty();
                                    $('#districtSelect').empty();
                                    citysOptions.length = 0;
                                    districtOptions.length = 0;
                                    citysOptions.push('<option value="">请选择市</option>');
                                    districtOptions.push('<option value="">请选择县</option>');
                                    $('#citySelect').append(citysOptions.join(''));
                                    $('#districtSelect').append(districtOptions.join(''));
                                    settings.layuiForm.render();
                                }
                            });
                            settings.layuiForm.on('select(city)',function (selectData) {
                                //选择市
                                var city = selectData.value;
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
                                }else {
                                    $('#districtSelect').empty();
                                    districtOptions.length = 0;
                                    districtOptions.push('<option value="">请选择县</option>');
                                    $('#districtSelect').append(districtOptions.join(''));
                                    settings.layuiForm.render();
                                }
                            });
                            settings.layuiForm.on('select(district)',function (selectData) {
                                //选择县
                                var district = selectData.value;
                                settings.onSelect(3,district);
                            })

                        }else {
                            settings.layer.msg(data.body.resultContent, {icon: 5});
                        }
                    }else {
                        settings.layer.msg('网络错误', {icon: 5});
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