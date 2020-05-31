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
</head>
<body>
	<%@ include file="../include/top.jsp"%>

	<div class="container"  >
		<div class="row">
			<div class="col">
				<img src="${pageContext.request.contextPath}/images/food0.jpg"
					class="img-thumbnail">
			</div>
			<div class="col">

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
		</div>
	</div>


	<%@ include file="../include/footer.jsp"%>
</body>
</html>