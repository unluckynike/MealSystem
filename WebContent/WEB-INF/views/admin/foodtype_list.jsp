<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>分类管理</title>
</head>
<body>

	<%@ include file="../include/top.jsp"%>


	<div class="container">
		<div class="row">
			<div class="col-sm">

				<form
					action="${pageContext.request.contextPath}/FoodTypeListQuery.do"
					method="post">
					<div class="input-group mb-3">
						<input type="text" name="searchfoodtype" class="form-control"
							placeholder="foodtypename" aria-label="Recipient's "
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<input type="submit" class="btn btn-success" id="basic-addon2"
								value="查询分类">
						</div>
					</div>
				</form>

			</div>
			<div class="col-sm">
				<div class="mybtn14_3" style="float: left">
					<a href="${pageContext.request.contextPath}/.do"
						class="btn btn-success" style="">添加新分类</a>
				</div>
				<div class="mybtn14_3" style="float: left; margin-left: 10px;">
					<a href="${pageContext.request.contextPath}/BackAdminIndex.do"
						class="btn btn-success" style="">回到首页</a>
				</div>

			</div>
			<div class="alert alert-primary" role="alert">
				每次进行完管理操作请点击查询分类按钮以确认操作成功</div>
		</div>
	</div>

	<div class="container-sm">

		<table class="table table-bordered">
			<thead class="thead-light">
				<tr>
					<th scope="col">id</th>
					<th scope="col">分类</th>
					<th scope="col">操作</th>
				</tr>
			</thead>
			<c:forEach items="${foodtypelist}" var="foodtype" varStatus="vs">
				<tbody>
					<tr>
						<th scope="row">${foodtype.id }</th>
						<td>${foodtype.typenameString }</td>
						<td>

							<form action="${pageContext.request.contextPath}/.do"
								method="post">
								<input type=hidden name=id value="${foodtype.id }"> <input
									style="float: left;" type="submit" class="btn btn-danger"
									value="删除">
							</form>


							<form action="${pageContext.request.contextPath}/.do"
								method="post">
								<input type=hidden name=id value="${foodtype.id }"> <input
									style="float: left; margin-right: 10px;" type="submit"
									class="btn btn-primary" value="修改">
							</form>

						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

	<%@ include file="../include/footer.jsp"%>


</body>
</html>