<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ include file="../common/home_base.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>软件开发平台</title>
</head>
<body>
<div class="layui-layout layui-layout-admin"
     style="border-bottom: solid 5px #1aa094;">
    <div class="layui-header header header-demo">
        <div class="layui-main">
            <div class="admin-login-box">
                <a class="logo" style="left: 0;" href="#">
                    <span style="font-size: 18px;">软件开发平台</span>
                </a>
                <div class="admin-side-toggle" title="<spring:message code="main.sidebarExtension"/>">
                    <i class="layui-icon">&#xe64e;</i>
                </div>
                <div class="admin-side-full" title="<spring:message code="main.fullScreen"/>">
                    <i class="layui-icon">&#xe626;</i>
                </div>
            </div>
            <ul class="layui-nav admin-header-item">
                <li class="layui-nav-item">
                    <a class="admin-header-user">
                        <i class="fa fa-flag-checkered"></i>
                        <spring:message code="system.language"></spring:message>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a class="language" href="javascript:;" name="zh_cn">简体中文</a>
                        </dd>
                        <dd>
                            <a class="language" href="javascript:;" name="zh_tw">繁体中文</a>
                        </dd>
                        <dd>
                            <a class="language" href="javascript:;" name="en_us">Englise</a>
                        </dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <font id="time" color="#212121" style="font-weight: bold;">2017年7月29日23:51:23</font>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;" class="admin-header-user">
                        <img src="${pageContext.request.contextPath}/resources/layui/images/0.jpg"/>
                        <span> [<shiro:principal property="userName"/>]</span>
                    </a>
                    <dl class="layui-nav-child">
                        <dd>
                            <a href="${pageContext.request.contextPath}/user/logout">
                                <i class="fa fa-sign-out" aria-hidden="true"></i>
                                <spring:message code="main.logout"></spring:message>
                            </a>
                        </dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-side layui-bg-black" id="admin-side">
        <div class="layui-side-scroll" id="admin-navbar-side" lay-filter="side"></div>
    </div>

    <div class="layui-body" style="bottom: 0; border-left: solid 2px #1AA094;" id="admin-body">
        <div class="layui-tab admin-nav-card layui-tab-brief" lay-filter="admin-tab">
            <ul class="layui-tab-title">
                <li class="layui-this">
                    <i class="fa fa-dashboard" aria-hidden="true"></i>
                    <cite>
                        <spring:message code="main.homePage"/>
                    </cite>
                </li>
            </ul>
            <div class="layui-tab-content"
                 style="min-height: 150px; padding: 5px 0 0 0;">
                <div class="layui-tab-item layui-show">
                    <iframe id="iframe" src=""></iframe>
                </div>
            </div>
        </div>
    </div>

    <div class="layui-footer footer footer-demo" id="admin-footer">
        <div class="layui-main">
            <div class="row" align="center">2017 &copy; 工程技术中心软件开发部
                &nbsp;&nbsp; 潘宏智(panhz@taiji.com.cn)
            </div>
        </div>
    </div>

    <div class="site-tree-mobile layui-hide">
        <i class="layui-icon">&#xe602;</i>
    </div>
    <div class="site-mobile-shade"></div>

    <!--锁屏模板 start-->
    <script type="text/template" id="lock-temp">
        <div class="admin-header-lock" id="lock-box">
            <div class="admin-header-lock-img">
                <img src="${pageContext.request.contextPath}/resources/layui/images/0.jpg"/>
            </div>
            <div class="admin-header-lock-name" id="lockUserName">beginner</div>
            <input type="text" class="admin-header-lock-input" value="输入密码解锁.." name="lockPwd" id="lockPwd"/>
            <button class="layui-btn layui-btn-small" id="unlock">解锁</button>
        </div>
    </script>
    <!--锁屏模板 end -->

</div>
</body>
<script type="text/javascript">
    $(function(){
        document.getElementById('time').innerHTML =new Date().Format("yyyy-MM-dd hh:mm:ss");
        setInterval('document.getElementById("time").innerHTML=new Date().Format("yyyy-MM-dd hh:mm:ss")', 1000);
    });
    var contextPath="${pageContext.request.contextPath}/";
    var tab;
    layui.config({
        base: '${pageContext.request.contextPath}/resources/layui/js/',
        version:new Date().getTime()
    }).use(['element', 'layer', 'navbar', 'tab'], function() {
        var element = layui.element(),
            $ = layui.jquery,
            layer = layui.layer,
            navbar = layui.navbar();
        tab = layui.tab({
            elem: '.admin-nav-card' //设置选项卡容器
            ,
            //maxSetting: {
            //	max: 5,
            //	tipMsg: '只能开5个哇，不能再开了。真的。'
            //},
            contextMenu:true
        });
        //iframe自适应
        $(window).on('resize', function() {
            var $content = $('.admin-nav-card .layui-tab-content');
            $content.height($(this).height() - 147);
            $content.find('iframe').each(function() {
                $(this).height($content.height());
            });
        }).resize();

        $
            .get(
                '${pageContext.request.contextPath}/resource/selectTreeMenu',
                function (data, status) {
                    if ("success" == status) {
                        if (data.body.resultCode == "0") {
                            var navs = data.body.entity;
                            //渲染navbar
                            navbar.set({
                                spreadOne: true,
                                elem: '#admin-navbar-side',
                                cached: false,
                                data: navs
                            });
                            navbar.render();
                            //监听点击事件
                            navbar.on('click(side)', function (data) {
                                tab.tabAdd(data.field);
                            });
                        }
                    }

                });

        $('.admin-side-toggle').on('click', function() {
            var sideWidth = $('#admin-side').width();
            if(sideWidth === 200) {
                $('#admin-body').animate({
                    left: '0'
                }); //admin-footer
                $('#admin-footer').animate({
                    left: '0'
                });
                $('#admin-side').animate({
                    width: '0'
                });
            } else {
                $('#admin-body').animate({
                    left: '200px'
                });
                $('#admin-footer').animate({
                    left: '200px'
                });
                $('#admin-side').animate({
                    width: '200px'
                });
            }
        });
        $('.admin-side-full').on('click', function() {
            var docElm = document.documentElement;
            //W3C
            if(docElm.requestFullscreen) {
                docElm.requestFullscreen();
            }
            //FireFox
            else if(docElm.mozRequestFullScreen) {
                docElm.mozRequestFullScreen();
            }
            //Chrome等
            else if(docElm.webkitRequestFullScreen) {
                docElm.webkitRequestFullScreen();
            }
            //IE11
            else if(elem.msRequestFullscreen) {
                elem.msRequestFullscreen();
            }
            layer.msg('按Esc即可退出全屏');
        });

        //锁屏
        $(document).on('keydown', function() {
            var e = window.event;
            if(e.keyCode === 76 && e.altKey) {
                alert("你按下了alt+l");
                lock($, layer);
            }
        });
        $('#lock').on('click', function() {
            lock($, layer);
        });

        //手机设备的简单适配
        var treeMobile = $('.site-tree-mobile'),
            shadeMobile = $('.site-mobile-shade');
        treeMobile.on('click', function() {
            $('body').addClass('site-mobile');
        });
        shadeMobile.on('click', function() {
            $('body').removeClass('site-mobile');
        });
    });


    var isShowLock = false;
    function lock($, layer) {
        if(isShowLock)
            return;
        //自定页
        layer.open({
            title: false,
            type: 1,
            closeBtn: 0,
            anim: 6,
            content: $('#lock-temp').html(),
            shade: [0.9, '#393D49'],
            success: function(layero, lockIndex) {
                isShowLock = true;
                //给显示用户名赋值
                layero.find('div#lockUserName').text('admin');
                layero.find('input[name=lockPwd]').on('focus', function() {
                    var $this = $(this);
                    if($this.val() === '输入密码解锁..') {
                        $this.val('').attr('type', 'password');
                    }
                })
                    .on('blur', function() {
                        var $this = $(this);
                        if($this.val() === '' || $this.length === 0) {
                            $this.attr('type', 'text').val('输入密码解锁..');
                        }
                    });
                //在此处可以写一个请求到服务端删除相关身份认证，因为考虑到如果浏览器被强制刷新的时候，身份验证还存在的情况
                //do something...
                //e.g.
                /*
                 $.post(url,params,callback,'json');
                 */
                //绑定解锁按钮的点击事件
                layero.find('button#unlock').on('click', function() {
                    var $lockBox = $('div#lock-box');

                    var userName = $lockBox.find('div#lockUserName').text();
                    var pwd = $lockBox.find('input[name=lockPwd]').val();
                    if(pwd === '输入密码解锁..' || pwd.length === 0) {
                        layer.msg('请输入密码..', {
                            icon: 2,
                            time: 1000
                        });
                        return;
                    }
                    unlock(userName, pwd);
                });
                /**
                 * 解锁操作方法
                 * @param {String} 用户名
                 * @param {String} 密码
                 */
                var unlock = function(un, pwd) {
                    //这里可以使用ajax方法解锁
                    /*$.post('api/xx',{username:un,password:pwd},function(data){
                         //验证成功
                        if(data.success){
                            //关闭锁屏层
                            layer.close(lockIndex);
                        }else{
                            layer.msg('密码输入错误..',{icon:2,time:1000});
                        }
                    },'json');
                    */
                    isShowLock = false;
                    //演示：默认输入密码都算成功
                    //关闭锁屏层
                    layer.close(lockIndex);
                };
            }
        });
    };
    $(".language").click(function(){
        $.get('${pageContext.request.contextPath}/setLanguage?language='+$(this).attr("name"),function(data,status){
            if(data=="success"){
                location.reload() ;
            }
        });
    });
    Date.prototype.Format = function (fmt) { //author: meizz
        var o = {
            "M+": this.getMonth() + 1, //月份
            "d+": this.getDate(), //日
            "h+": this.getHours(), //小时
            "m+": this.getMinutes(), //分
            "s+": this.getSeconds(), //秒
            "q+": Math.floor((this.getMonth() + 3) / 3), //季度
            "S": this.getMilliseconds() //毫秒
        };
        if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
        for (var k in o)
            if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
        return fmt;
    }
</script>
</html>