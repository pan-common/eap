var layerIndex;
$(document).ajaxStart(function () {
    layerIndex = layer.msg('加载中', {icon: 16, shade: [0.5, '#f5f5f5'], scrollbar: false, time: 100000});
});
$(document).ajaxComplete(function () {
    layer.close(layerIndex);
});
$(document).ajaxSuccess(function () {
    layer.close(layerIndex);
});
$(document).ajaxError(function () {
    layer.close(layerIndex);
});