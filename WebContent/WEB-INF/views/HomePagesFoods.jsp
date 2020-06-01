<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<title>${name}</title>
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
</head>
<body>

	<%@ include file="include/top.jsp"%>


	<div class="container">
		<div class="row">
			<div class="col-sm">

				<img src="${pageContext.request.contextPath}/${img}"
					class="card-img-top" style="display: block; padding: 1px; background: white; border: 1px solid black;">
				<div class="card-body">
					<h5 class="card-title">菜品： ${name}</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				</div>

			</div>
			<div class="col-sm">

				<div class="card" style="width: 18rem;">

					<ul class="list-group list-group-flush">
						<li class="list-group-item">菜品：${ name}</li>
						<li class="list-group-item">特色：${ feature}</li>
						<li class="list-group-item">食材：${ material}</li>
						<li class="list-group-item">价格：${ price}&nbsp;元</li>
						<li class="list-group-item">种类：${ type}</li>
						<li class="list-group-item">点击率：${ hits}</li>
						<li class="list-group-item">评价：${ comment}</li>
					</ul>
					<div class="card-body">
						<a href="${pageContext.request.contextPath}/Login.do"
							class="card-link">去下单</a> <a href="HomePages.do"
							class="card-link">返回</a>
					</div>
				</div>
			</div>

		</div>
	</div>

	<script color="0,0,0" opacity="0.8" count="200"
		src="https://cdn.bootcss.com/canvas-nest.js/1.0.1/canvas-nest.js"
		type="text/javascript" charset="utf-8"></script>

	<%@ include file="include/footer.jsp"%>

</body>
</html>