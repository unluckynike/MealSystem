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
<title>菜品管理</title>
</head>
<body>

	<%@ include file="../include/top.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-sm">

				<form action="${pageContext.request.contextPath}/FoodListQuery.do" method="post">
					<div class="input-group mb-3">
						<input type="text" name="searchfood" class="form-control"
							placeholder="foodname" aria-label="Recipient's "
							aria-describedby="basic-addon2">
						<div class="input-group-append">
							<input type="submit" class="btn btn-success" id="basic-addon2"
								value="查询菜品">
						</div>
					</div>
				</form>

			</div>
			<div class="col-sm">
				<div class="mybtn14_3" style="float: left">
					<a href="${pageContext.request.contextPath}/.do"
						class="btn btn-success" style="">添加新菜品</a>
				</div>
				<div class="mybtn14_3" style="float: left; margin-left: 10px;">
					<a href="${pageContext.request.contextPath}/.do"
						class="btn btn-success" style="">分类管理</a>
				</div>
				<div class="mybtn14_3" style="float: left; margin-left: 10px;">
					<a href="${pageContext.request.contextPath}/BackAdminIndex.do"
						class="btn btn-success" style="">回到首页</a>
				</div>

			</div>
			<div class="alert alert-danger" role="alert">
				每次进行完管理操作请点击查询菜品按钮以确认操作成功</div>
		</div>
	</div>


	<table class="table table-bordered" >
		<thead class="thead-light">
			<tr>
				<th scope="col">id</th>
				<th scope="col">菜名</th>
				<th scope="col">特色</th>
				<th scope="col">食材</th>
				<th scope="col">价格</th>
				<th scope="col">种类</th>
				<th scope="col">图片</th>
				<th scope="col">销量</th>
				<th scope="col">评价</th>
				<th scope="col">操作</th>
			</tr>
		</thead>
		<c:forEach items="${foodlist}" var="food" varStatus="vs">
			<tbody>
				<tr>
					<th scope="row">${food.id }</th>
					<td>${food.foodnameString }</td>
					<td>${food.featureString }</td>
					<td>${food.materialString }</td>
					<td>${food.price }&nbsp;元</td>
					<td>${food.type }</td>
					<td><img src="${pageContext.request.contextPath}/${food.pictureString }" ></td>
					<td>${food.hits }</td>
					<td>${food.comment }</td>
					<td>
						<form action="${pageContext.request.contextPath}/.do"
							method="post">
							<input type=hidden name=id value="${food.id }"> <input
								type="submit" class="btn btn-danger" value="删除">
						</form>

						<form action="${pageContext.request.contextPath}/.do"
							method="post">
							<input type=hidden name=id value="${food.id }"> <input
								type="submit" class="btn btn-primary" value="修改">
						</form>
					</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>