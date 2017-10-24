/**
 * 通过key获取value
 */
function getValueByKey(keystone,parentId) {
    var value;
    $.ajax({
        url:baseServerUrl+"dictionary/getValueByKey",
        dataType:"json",
        async:false,
        data:{
            "keystone":keystone,
            "parentId":parentId
        },
        type:"GET",
        success:function (data) {
            value = data.body.entity;
        },
        error:function () {

        }
    });
    return value;
}