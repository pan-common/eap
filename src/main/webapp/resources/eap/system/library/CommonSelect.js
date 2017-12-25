;(function ($,window,document,undefined) {
    /**
     * 默认值
     * @type {{}}
     */
    var defaults = {
        layuiForm:new Object(),
        layer:new Object(),
        dataSource:"",
        params:"",
        onSelect:function () {

        },
    };
    /**
     * 方法
     * @type {{init: init, destory: destory}}
     */
    var methods = {
        init:function (options) {
            return this.each(function () {
                var $this = $(this);
                var data = $this.data('commonSelect');
                //检测是否初始化，如果未初始化执行初始化代码（类似java的单例模式）
                if(!data){
                    $(this).data('commonSelect', {
                        target: $this,
                    });
                };
                var settings = $.extend({},defaults, options);

                $.get(baseServerUrl+"common/getCommonSelectData",{
                    datasource:settings.datasource,
                    params:settings.params
                },function (data,status) {
                    if(status=="success"){
                        if(data.body.resultCode=="0"){
                            var items = [];
                            items.push('<option value=""></option>');
                            for (var i in data.body.entity) {
                                items.push('<option value="'+data.body.entity[i].key+'">'+data.body.entity[i].value+'</option>')
                            }
                            $this.append(items.join(''));
                            settings.layuiForm.render();
                            settings.layuiForm.on('select('+this.name+')',function (data) {
                                settings.onSelect(data);
                            });
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
                    data = $this.data('commonSelect');
                $(window).unbind('.commonSelect');
                $this.removeData('commonSelect');
            });
        }
    };

    $.fn.CommonSelect = function (method,options) {
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