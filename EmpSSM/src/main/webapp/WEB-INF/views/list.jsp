<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>list</title>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>static/" />
<!-- 路径问题
1.不以/开头的路径，是以当前路径为基准的
2.以/开头的路径，是以当前服务器根路径为基准的（http:localhost:8080）

 -->
<!-- 引入樣式 -->
<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

	<!-- 新增员工按钮的Modal（模态框） -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">员工添加</h4>
				</div>
				<div class="modal-body">
					<!-- form表单 -->
					<form class="form-horizontal">
						<div class="form-group">
							<label for="ename_add_input" class="col-sm-2 control-label">ename</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="ename_add_input"
									placeholder="ename">
							</div>
						</div>
						<div class="form-group">
							<label for="job_add_input" class="col-sm-2 control-label">job</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="job_add_input"
									placeholder="job">
							</div>
						</div>
						<div class="form-group">
							<label for="mgr_add_input" class="col-sm-2 control-label">mgr</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="mgr_add_input"
									placeholder="mgr">
							</div>
						</div>
						<div class="form-group">
							<label for="hiredate_add_input" class="col-sm-2 control-label">hiredate</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="hiredate_add_input"
									placeholder="hiredate">
							</div>
						</div>
						<div class="form-group">
							<label for="sal_add_input" class="col-sm-2 control-label">sal</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="sal_add_input"
									placeholder="sal">
							</div>
						</div>
						<div class="form-group">
							<label for="comm_add_input" class="col-sm-2 control-label">comm</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="comm_add_input"
									placeholder="comm">
							</div>
						</div>
						<div class="form-group">
							<label for="comm_add_input" class="col-sm-2 control-label">deptno</label>
							<div class="col-sm-4">
								<select class="form-control">
									<option>1</option>
									<option>2</option>
									<option>3</option>
									<option>4</option>
									<option>5</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>

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
				<button class="btn btn-primary" id="emp_add_modal_btn">新增</button>
				<button class="btn btn-danger">删除</button>
			</div>
		</div>
		<!-- 显示表格数据 -->
		<div class="row">
			<div class="col-md-12">
				<table class="table table-hover">
					<tr>
						<th><input type="checkbox" /></th>
						<th>ename</th>
						<th>job</th>
						<th>mgr</th>
						<th>hiredate</th>
						<th>sal</th>
						<th>comm</th>
						<th>操作</th>
					</tr>
					<c:forEach items="${pageInfo.list }" var="emp">
						<tr>
							<th><input type="checkbox" /></th>
							<th>${emp.ename }</th>
							<th>${emp.job }</th>
							<th>${emp.mgr }</th>
							<th>${emp.hiredate }</th>
							<th>${emp.sal }</th>
							<th>${emp.comm }</th>
							<th>
								<button class="btn btn-primary btn-sm">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
								</button>
								<button class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
								</button>
							</th>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6">当前第${pageInfo.pageNum }页，共${pageInfo.pages }页，${pageInfo.total }条记录
			</div>
			<!-- 分页条信息 -->
			<div class="col-md-6">
				<nav aria-label="Page navigation">
				<ul class="pagination">
					<li><a href="<%=basePath%>list.html?pn=1">首页</a></li>
					<c:if test="${pageInfo.hasPreviousPage }">
						<li><a
							href="<%=basePath %>list.html?pn=${pageInfo.pageNum-1 }"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
					</c:if>
					<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
						<c:if test="${page_Num == pageInfo.pageNum }">
							<li class="active"><a>${page_Num }</a></li>
						</c:if>
						<c:if test="${page_Num != pageInfo.pageNum }">
							<li><a href="<%=basePath %>list.html?pn=${page_Num }">${page_Num }</a></li>
						</c:if>
					</c:forEach>
					<c:if test="${pageInfo.hasNextPage }">
						<li><a
							href="<%=basePath %>list.html?pn=${pageInfo.pageNum+1 }"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</c:if>
					<li><a href="<%=basePath %>list.html?pn=${pageInfo.pages }">尾页</a></li>
				</ul>
				</nav>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$("#emp_add_modal_btn").click(function() {
			$("#empAddModal").modal({
				backdrop : "static"
			});
		});
	</script>
</body>
</html>