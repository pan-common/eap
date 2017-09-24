<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link
	href="${pageContext.request.contextPath}/resources/layui/css/layui.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/icheck/skins/square/blue.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/resources/eap/system/css/login.css"
	rel="stylesheet">
<title>Home</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row"></div>
		<div class="row">
			<div class="loginFormBg row col-md-offset-8">
				<form id="loginForm" class="Loginform">
					<table>
						<tr style="height: 66px;">
							<td valign="top" colspan="2"><div class="loginput"
									style="background: url(${pageContext.request.contextPath}/resources/eap/system/image/icon_user_pre.png)no-repeat 10px;">
									<input class="input" id="userName" name="userName"
										type="text" placeholder="用户名">
								</div></td>
						</tr>
						<tr style="height: 80px;">
							<td valign="top" colspan="2"><div class="loginput"
									style="background: url(${pageContext.request.contextPath}/resources/eap/system/image/icon_password_pre.png)no-repeat 10px;">
									<input class="input" id="password" name="password"
										type="password" placeholder="密码">
								</div> <span id="msg" style="color: red"></span></td>
						</tr>
						<tr>
							<td style="color: #0ea4ea;"><input type="checkbox"
								name="remember" value="1">&nbsp&nbsp记住密码</td>
						</tr>
						<tr style="height: 60px">
							<td colspan="2"><button onclick="login()"
									type="button" class="LoginButton">登录</button></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</body>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.2.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/layui/layui.js">
	
</script>
<script
	src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js">
	
</script>
<script
	src="${pageContext.request.contextPath}/resources/icheck/js/icheck.min.js">
	
</script>

<script type="text/javascript">
	$('input').iCheck({
		checkboxClass : 'icheckbox_square-blue',
		radioClass : 'iradio_square-blue',
		increaseArea : '20%' // optional
	});
	//一般直接写在一个js文件中
	layui.use([ 'layer', 'form', 'element', 'tree' ], function(layer, form) {

	});

	function login() {
		$.post("${pageContext.request.contextPath}/sysuser/login", 
				$("#loginForm").serialize(),
				function(data, state) {
			if(state=="success"){
				if(data.body.resultCode=="0"){
					
				}else{
					alert(data.body.resultContent);
				}
			}else{
				
			}
		});
	}
</script>
</html>
