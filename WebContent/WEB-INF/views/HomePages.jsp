<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>首页</title>
<style>
body {
	background: linear-gradient(60deg, rgba(255, 165, 150, 0.01) 5%,
		rgba(208, 255, 0, 0.151)) 0% 0%/cover,
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/cutlery-948563_1920.jpg"),
		url("https://cdn.jsdelivr.net/gh/unluckynike/blogimg/images/cutlery-948563_1920.jpg")
		0px 0px;
	background-attachment: fixed;
	margin: 0;
	color: #34495e;
}
</style>
</head>
<body>

	<div class="jumbotron jumbotron-fluid bg-secondary text-white p-1">
		<div class="container">
			<h1 class="display-3">i-eat</h1>
			<br> <a href="${pageContext.request.contextPath}/Login.do"
				class="btn btn-success">登录</a> <a
				href="${pageContext.request.contextPath}/Register.do"
				class="btn btn-success">注册</a>
			<p class="lead">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎来到点餐系统</p>
		</div>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm">
				<h3 class="nav-link active">家常</h3>
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">菠菜炒鸡蛋</h5>
						<img src="/zhouhailin0506_MealSystem/images/jiachang/01.jpg"
							style="display: block; padding: 1px; background: white; border: 1px solid black;">
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<form action="${pageContext.request.contextPath}/QueryFood.do"
							method="post">
							<input type="hidden" name="id" value=1> <input
								type="submit" class="btn btn-primary" value="Go Somewhere">
						</form>
					</div>
				</div>

				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">韭菜炒鸡蛋</h5>
						<img src="/zhouhailin0506_MealSystem/images/jiachang/02.jpg"
						style="display: block; padding: 1px; background: white; border: 1px solid black;">
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<form action="${pageContext.request.contextPath}/QueryFood.do"
							method="post">
							<input type="hidden" name="id" value=2> <input
								type="submit" class="btn btn-primary" value="Go Somewhere">
						</form>
					</div>
				</div>


			</div>
			<div class="col-sm">
				<h3 class="nav-link active">涼菜</h3>
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">小葱拌豆腐</h5>
						<img src="/zhouhailin0506_MealSystem/images/liangcai/1.jpg"
						style="display: block; padding: 1px; background: white; border: 1px solid black;">
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<form action="${pageContext.request.contextPath}/QueryFood.do"
							method="post">
							<input type="hidden" name="id" value=11> <input
								type="submit" class="btn btn-primary" value="Go Somewhere">
						</form>
					</div>
				</div>

				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">泡椒凤爪</h5>
						<img src="/zhouhailin0506_MealSystem/images/liangcai/2.jpg"
						style="display: block; padding: 1px; background: white; border: 1px solid black;">
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<form action="${pageContext.request.contextPath}/QueryFood.do"
							method="post">
							<input type="hidden" name="id" value=12> <input
								type="submit" class="btn btn-primary" value="Go Somewhere">
						</form>
					</div>
				</div>


			</div>
			<div class="col-sm">
				<h3 class="nav-link active">主食</h3>
				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">四川酸辣粉</h5>
						<img src="/zhouhailin0506_MealSystem/images/zhushi/1.jpg"
						style="display: block; padding: 1px; background: white; border: 1px solid black;">
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<form action="${pageContext.request.contextPath}/QueryFood.do"
							method="post">
							<input type="hidden" name="id" value=21> <input
								type="submit" class="btn btn-primary" value="Go Somewhere">
						</form>
					</div>
				</div>

				<div class="card" style="width: 18rem;">
					<div class="card-body">
						<h5 class="card-title">蛋包饭</h5>
						<img src="/zhouhailin0506_MealSystem/images/zhushi/2.jpg"
						style="display: block; padding: 1px; background: white; border: 1px solid black;">
						<p class="card-text">With supporting text below as a natural
							lead-in to additional content.</p>
						<form action="${pageContext.request.contextPath}/QueryFood.do"
							method="post">
							<input type="hidden" name="id" value=22> <input
								type="submit" class="btn btn-primary" value="Go Somewhere">
						</form>
					</div>
				</div>

			</div>
		</div>
	</div>

	<%@ include file="include/footer.jsp"%>

	<script type="text/javascript" pointColor="255,64,64" color="1,90,230"
		opacity='1' zIndex="-1" count="200"
		src="https://cdn.bootcdn.net/ajax/libs/canvas-nest.js/2.0.4/canvas-nest.js"></script>
	<script type="text/javascript" pointColor="255,64,64" color="255,64,64"
		opacity='1' zIndex="-1" count="200"
		src="https://cdn.bootcdn.net/ajax/libs/canvas-nest.js/2.0.4/canvas-nest.js"></script>
	<script color="0,0,0" opacity="0.8" count="200"
		src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js"
		type="text/javascript" charset="utf-8"></script>

</body>
</html>