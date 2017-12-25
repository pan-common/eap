;(function ($,window,document,undefined) {
    /**
     * 默认值
     * @type {{}}
     */
    var defaults = {

    };
    /**
     * 方法
     * @type {{init: init, destory: destory}}
     */
    var methods = {
        init:function (options) {
            return this.each(function () {
                var $this = $(this);
                var data = $this.data('tableEdit');
                //检测是否初始化，如果未初始化执行初始化代码（类似java的单例模式）
                if(!data){
                    $(this).data('tableEdit', {
                        target: $this,
                        tableEdit: tableEdit
                    });
                };
                var settings = $.extend({},defaults, options);
                $this.append(settings.title);
            });
        },
        destory:function () {
            return this.each(function () {
                var $this = $(this),
                    data = $this.data('tableEdit');
                $(window).unbind('.tableEdit');
                data.tableEdit.remove();
                $this.removeData('tooltip');
            });
        }
    };

    $.fn.TableEdit = function (method,options) {
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