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
<title>代码生成器</title>
</head>
<body>
	<div class="layui-fluid">
		<div class="layui-row layui-col-space22">
			<div class="layui-col-md2">
				<div class="layui-row">
					<blockquote class="layui-elem-quote">表</blockquote>
				</div>
				<div class="layui-row">
					<blockquote class="layui-elem-quote">视图</blockquote>
				</div>
			</div>
			<div class="layui-col-md10">
				<blockquote class="layui-elem-quote">代码生成器</blockquote>
				<div class="layui-row">
					<div class="layui-col-md10 layui-col-md-offset1">
						<form id="form" class="layui-form layui-form-pane" method="post">
							<div class="layui-form-item">
								<label class="layui-form-label">保存路径</label>
								<div class="layui-input-inline">
									<input type="text" name="savePath" required
										lay-verify="required" placeholder="请输入保存路径" autocomplete="off"
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux"></div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">基准包</label>
								<div class="layui-input-inline">
									<input type="text" name="basePackage" required
										lay-verify="required" placeholder="请输入基准包" autocomplete="off"
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux"></div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">模块名</label>
								<div class="layui-input-inline">
									<input type="text" name="moduleName" required
										lay-verify="required" placeholder="请输入模块名" autocomplete="off"
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux"></div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">表名</label>
								<div class="layui-input-inline">
									<input type="text" name="tableName" required
										lay-verify="required" placeholder="请输入表名" autocomplete="off"
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux"></div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">别名</label>
								<div class="layui-input-inline">
									<input type="text" name="anotherName" required
										lay-verify="required" placeholder="请输入别名" autocomplete="off"
										class="layui-input">
								</div>
								<div class="layui-form-mid layui-word-aux"></div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">生成文件</label>
								<div class="layui-input-block">
									<input type="checkbox" name="dao" title="dao" value="1" checked>
									<input type="checkbox" name="service" title="service" value="1"
										checked> <input type="checkbox" name="action"
										title="action" value="1" checked> <input
										type="checkbox" name="list" title="list" value="1" checked>
								</div>
								<div class="layui-input-block">
									<input type="checkbox" name="add" title="add" value="1" checked>
									<input type="checkbox" name="update" title="update" value="1"
										checked> <input type="checkbox" name="detail"
										title="detail" value="1" checked> <input
										type="checkbox" name="js" title="js" value="1" checked>
									<input type="checkbox" name="css" title="css" value="1" checked>
								</div>
							</div>
						</form>
						<button type="button" class="layui-btn" onclick="submit()">提交</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script
	src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/jquery/jquery-3.2.1.min.js"></script>
<script type="text/javascript">
	layui.use([ 'layer', 'form' ], function(layer, form) {
		
	});
	
	function submit(){
		$.post("${pageContext.request.contextPath}/generator/createCode",$("#form").serialize(),
				   function(data){
				   
				   }, "json");
		return false;
	}
</script>
</html>