<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>添加菜品</title>
<style>
body {
	background: linear-gradient(60deg, rgba(255, 165, 150, 0.01) 5%,
		rgba(208, 255, 0, 0.151)) 0% 0%/cover,
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/food-3219476_1920.jpg"),
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/food-3219476_1920.jpg")
		0px 0px;
	background-attachment: fixed;
	margin: 0;
	color: #34495e;
}
</style>
</head>
<body>
	<%@ include file="../include/top.jsp"%>

	<div class="container">

		<div class="card" style="width: 30rem;">
			<div class="card-body">
				<h5 class="card-title">添加菜品</h5>
				<h6 class="card-subtitle mb-2 text-muted">输入下列信息用以增加点餐系统新的菜品</h6>
				<form action="${pageContext.request.contextPath}/FoodAddDo.do" method="post" enctype="multipart/form-data">
					<div class="input-group input-group-lg" style="margin-top: 20px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-lg">菜品名称</span>
						</div>
						<input type="text" name="foodname" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-lg">
					</div>

					<div class="input-group input-group-lg" style="margin-top: 20px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-lg">特色</span>
						</div>
						<input type="text" name="feature" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-lg">
					</div>

					<div class="input-group input-group-lg" style="margin-top: 20px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-lg">食材</span>
						</div>
						<input type="text" name="material" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-lg">
					</div>

					<div class="input-group input-group-lg" style="margin-top: 20px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-lg">价格/元</span>
						</div>
						<input type="text" name="price" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-lg">
					</div>

					<div class="input-group mb-4" style="margin-top: 20px;">
						<div class="input-group-prepend">
							<label class="input-group-text" for="inputGroupSelect01">分类</label>
						</div>
						<select class="custom-select" name="type">
							<option value="1">家常</option>
							<option value="2">凉菜</option>
							<option value="3">主食</option>
							<option value="4">饮品</option>
						</select>
					</div>
  
					<div class="input-group input-group-lg" style="margin-top: 20px;">
						<div class="input-group-prepend">
							<span class="input-group-text" id="inputGroup-sizing-lg">图片</span>
						</div>
						<input type="file" name="pitcture" id="pitcture" class="form-control"
							aria-label="Sizing example input"
							aria-describedby="inputGroup-sizing-lg">
					</div>
					
					<div style="margin-top: 20px;">
						<input type="submit" class="btn btn-success" value="确认添加"
							style="margin-right: 20px;"> <input type="reset"
							class="btn btn-primary" value="重置">
					</div>
				</form>
			</div>
		</div>

	</div>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>