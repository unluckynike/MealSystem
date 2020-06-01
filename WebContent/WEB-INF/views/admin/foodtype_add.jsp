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
<title>添加菜品分类</title>
<style>
body {
	/*background-color: #eaeaea;*/
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
	


	<div class="container-xl" style="margin-top:250px">
	
	
				<div class="card mb-3" style="max-width: 540px;">
					<div class="row no-gutters">
						<div class="col-md-4">
							<img src="${pageContext.request.contextPath}/images/chef.jpg"
								class="img-thumbnail">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">添加新的种类</h5>
								<p class="card-text">
									<small class="text-muted">输入下列信息用以添加菜品种类</small>
								</p>
								<form action="${pageContext.request.contextPath}/FoodTypeAddDo.do" method="post">

									<div class="input-group mb-3">
										<div class="input-group-prepend">
											<span class="input-group-text" id="inputGroup-sizing-default">新的分类</span>
										</div>
										<input type="text" name="newfoodtype" class="form-control"
											aria-label="Sizing example input"
											aria-describedby="inputGroup-sizing-default">
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
				</div>
				
	
	</div>

	<%@ include file="../include/footer.jsp"%>
</body>
</html>