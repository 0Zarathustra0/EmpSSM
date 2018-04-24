<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<%
	pageContext.setAttribute("pagePath",request.getContextPath());
%>
<!-- 路径问题
1.不以/开头的路径，是以当前路径为基准的
2.以/开头的路径，是以当前服务器根路径为基准的（http:localhost:8080）

 -->
<!-- 引入樣式 -->
 <link href="static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="${pagePath }/WEB-INF/static/js/jquery-3.3.1.min.js" type="text/javascript"></script>
 <script src="${pagePath }/WEB-INF/static/bootstrap-3.3.7-dist/js/bootstrap.min.js" ></script>
</head>
<body>
	<div class="container">
		<!-- 标题行 -->
		<div class="row">
			<div class="col-md-12">
				<h1>SSM-CRUD</h1>
			</div>
		</div>
		<!-- 按钮 -->
		<div class="row">
			<div class="col-md-4 col-md-offset-8">
				<button class="btn btn-primary">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row"></div>
		<!-- 显示分页信息 -->
		<div class="row"></div>
	</div>

</body>
</html>