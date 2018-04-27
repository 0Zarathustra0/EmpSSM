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
	pageContext.setAttribute("APP_PATH", request.getContextPath());
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
				<table class="table table-hover" id="emps_table">
					<thead>
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
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		<!-- 显示分页信息 -->
		<div class="row">
			<!-- 分页文字信息 -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">

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

		//1.页面加载完成之后，直接发送一个ajax请求，取到分页数据
		$(function() {
			//去首页
			to_page(1);
		});
		function to_page(pn){
			$.ajax({
				url : "${APP_PATH}/list.html",
				data : "pn="+pn,
				type : "get",
				//请求成功的回调函数
				success : function(result) {
					console.log(result);
					//字符串转化为json
					var result = JSON.parse(result);
					//1.解析并显示员工数据
					build_emps_table(result);
					//2.解析并显示分页信息
					build_page_info(result);
					//3.解析并显示分页条数据
					build_page_nav(result);
				}
			});
		}
		function build_emps_table(result) {
			//首先清空表格
			$("#emps_table tbody").empty();
			var emps = result.extend.pageInfo.list;
			$.each(emps, function(index, item) {
// 				alert(item.ename);
				var checkTd = $("<td></td>").append("<input type='checkbox' />");
				var enameTd = $("<td></td>").append(item.ename);
				var jobTd = $("<td></td>").append(item.job);
				var mgrTd = $("<td></td>").append(item.mgr);
				var hiredateTd = $("<td></td>").append(item.hiredate);
				var salTd = $("<td></td>").append(item.sal);
				var commTd = $("<td></td>").append(item.comm);
// 				<button class="btn btn-primary btn-sm">
// 					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>编辑
// 				</button>
// 				<button class="btn btn-danger btn-sm">
// 					<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>删除
// 				</button>
				var editBtn = $("<button></button>").addClass("btn btn-primary")
								.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
								.append("编辑");
				var delBtn = $("<button></button>").addClass("btn btn-danger btn-sm")
								.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
								.append("删除");
				var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
				//append方法执行完成后，还会返回原来的元素
				$("<tr></tr>").append(checkTd)
					.append(enameTd)
					.append(jobTd)
					.append(mgrTd)
					.append(hiredateTd)
					.append(salTd)
					.append(commTd)
					.append(btnTd)
					.appendTo("#emps_table tbody");
			});
		}
		
		//解析显示分页信息
		function build_page_info(result) {
			$("#page_info_area").empty();
			$("#page_info_area").append("当前第"+result.extend.pageInfo.pageNum+"页，共"+
					result.extend.pageInfo.pages+"页,"+
					result.extend.pageInfo.total+"条记录");
		}
		
		//解析显示分页条
		function build_page_nav(result) {
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum - 1);
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("尾页"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				nextPageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum + 1);
				});
			}
			//添加“首页”和前一页的显示
			ul.append(firstPageLi).append(prePageLi);
			//遍历页码
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				var numLi =  $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和“尾页”的显示
			ul.append(nextPageLi).append(lastPageLi);
			//把ul添加到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
	</script>
</body>
</html>