<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<link
	href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<title>用首页</title>
</head>
<body>

	<%@ include file="../include/top.jsp"%>
	<ul class="nav nav-pills nav-justified">
		<li class="nav-item"><a class="nav-link active"
			href="UserOrder.do">去点餐</a></li>
		<li class="nav-item"><a class="nav-link " href="#">用户:&nbsp;${username}</a></li>
		<li class="nav-item"><a class="nav-link active"
			href="UserCheckOrder.do">查看购物车</a></li>
		<li class="nav-item"><a class="nav-link " href="UserInfor.do">个人资料</a></li>
		<li class="nav-item"><a class="nav-link active" href="Exit.do">退出</a></li>
	</ul>

	<div class="panel panel-success">
		<div class="panel-heading">
			<h3 class="panel-title" style="text-align: center;">热点菜品</h3>
		</div>
		<div class="panel-body">
			<div id="myCarousel" class="carousel slide">
				<!-- 轮播（Carousel）指标 -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
				<!-- 轮播（Carousel）项目 -->
				<div class="carousel-inner">
					<div class="item active">
						<table>
							<tr>
								<td><img src="images/1.png" alt="First slide1"
									class="img-thumbnail" style="margin-left: 30px;"></td>
								<td><img src="images/2.jpg" alt="First slide2"
									class="img-thumbnail" style="margin-left: 30px;"></td>
								<td><img src="images/3.jpg" alt="First slide3"
									class="img-thumbnail" style="margin-left: 30px;"></td>
							</tr>
						</table>
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<table>
							<tr>
								<td><img src="images/4.jpg" alt="First slide4"
									class="img-thumbnail" style="margin-left: 30px;"></td>
								<td><img src="images/5.jpg" alt="First slide5"
									class="img-thumbnail" style="margin-left: 30px;"></td>
								<td><img src="images/6.jpg" alt="First slide6"
									class="img-thumbnail" style="margin-left: 30px;"></td>
							</tr>
						</table>
						<div class="carousel-caption"></div>
					</div>
					<div class="item">
						<table>
							<tr>
								<td><img src="images/7.jpg" alt="First slide7"
									class="img-thumbnail" style="margin-left: 30px;"></td>
								<td><img src="images/8.jpg" alt="First slide8"
									class="img-thumbnail" style="margin-left: 30px;"></td>
								<td><img src="images/9.jpg" alt="First slide9"
									class="img-thumbnail" style="margin-left: 30px;"></td>
							</tr>
						</table>
						<div class="carousel-caption"></div>
					</div>
				</div>
				<!-- 轮播（Carousel）导航 -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev" da> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
		</div>
	</div>
	</div>
	<div class="panel panel-info">
		<div class="panel-heading">
			<h3 class="panel-title" style="text-align: center;">今日特价</h3>
		</div>
		<div class="panel-body">
			<table>
				<tr>
					<td><img src="images/A.jpg" class="img-circle img-responsive"
						style="margin-left: 30px; margin-right: 30px;"></td>
					<td><img src="images/C.jpg" class="img-circle img-responsive"
						style="margin-left: 30px; margin-right: 30px;"></td>
					<td><img src="images/D.jpg" class="img-circle img-responsive"
						style="margin-left: 30px; margin-right: 30px;"></td>
				</tr>
				<tr>
					<td style="text-align: center; font-size: large; margin-top: 10px;">剁椒鱼头&nbsp;&nbsp;&nbsp;&nbsp;25元</td>
					<td style="text-align: center; font-size: large; margin-top: 10px;">麻辣小龙虾&nbsp;&nbsp;&nbsp;&nbsp;45元</td>
					<td style="text-align: center; font-size: large; margin-top: 10px;">红烧肉&nbsp;&nbsp;&nbsp;&nbsp;30元</td>
				</tr>
			</table>
		</div>
	</div>
	<div class="panel panel-warning">
		<div class="panel-heading">
			<h3 class="panel-title" style="text-align: center;">厨师推荐</h3>
		</div>
		<div class="panel-body">
			<table>
				<tr>
					<td><img src="images/A1.jpg" class="img-thumbnail"></td>
					<td><img src="images/A2.jpg" class="img-thumbnail"></td>
					<td><img src="images/A3.jpg" class="img-thumbnail"></td>
					<td><img src="images/A4.jpg" class="img-thumbnail"></td>
				</tr>
				<tr
					style="text-align: center; font-size: large; font-family: Arial, Helvetica, sans-serif;">
					<td>铁板鸡丁&nbsp;&nbsp;&nbsp;&nbsp;25元</td>
					<td>香菇炒肉&nbsp;&nbsp;&nbsp;&nbsp;20元</td>
					<td>鱼香茄子&nbsp;&nbsp;&nbsp;&nbsp;15元</td>
					<td>孜然排骨&nbsp;&nbsp;&nbsp;&nbsp;25元</td>
				</tr>
			</table>
		</div>
	</div>

	<%@ include file="../include/footer.jsp"%>
	<script type="text/javascript" pointColor="255,64,64" color="255,64,64"
		opacity='1' zIndex="-1" count="100"
		src="https://cdn.bootcdn.net/ajax/libs/canvas-nest.js/2.0.4/canvas-nest.js"></script>
	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script
		src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>