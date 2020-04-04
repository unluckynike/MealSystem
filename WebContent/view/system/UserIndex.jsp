<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
	<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>index</title>
	<link rel="stylesheet" href="https://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<style type="text/css">
.box {
	width: 20px;
	height: 20px;
	padding: 2px;
	border: 1px solid #ccc;
	border-radius: 2px;
}
</style>
	</head>
	<body>
<h1 style="text-align: center">欢迎进入点餐系统</h1>
<div class="container">
      <div class="row">
    <div class="col-md-12" style="padding:2em 0;">
   
          <div class="table-responsive">
        <table class="table table-bordered table-striped" id="mytable">
              <thead>
            <tr>
                  <td>姓名</td>
                  <td>年龄</td>
                  <td>邮箱</td>
                </tr>
          </thead>
              <tbody>
            <tr>
                  <td>张三</td>
                  <td>11</td>
                  <td>11@qq.com</td>
                </tr>
            <tr>
                  <td>李四</td>
                  <td>12</td>
                  <td>12@qq.com</td>
                </tr>
            <tr>
                  <td>王五</td>
                  <td>13</td>
                  <td>13@qq.com</td>
                </tr>
          </tbody>
            </table>
      </div>
        </div>
    <div class="col-md-12"  style="padding-bottom:2em;">
          <button class="btn btn-info" id="add"><i class="fa fa-plus"></i> 添加新的表格行</button>
        </div>
  </div>
    </div>
<script src="../../js/jquery.min.js"></script> 
<script type="text/javascript" src="../../js/bootstable.js"></script> 
<script type="text/javascript">
		$('#mytable').SetEditable({
			$addButton: $('#add')
		});
	</script>
</body>
</html>