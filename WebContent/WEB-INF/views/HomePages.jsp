<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<title>首页</title>
<style>
    .footer {
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 50px;
  background-color: #f5f5f5;
}
</style>

</head>
<body>
 
    <div class="jumbotron jumbotron-fluid bg-secondary text-white p-1">
        <div class="container">
            <h1 class="display-3">i-eat  </h1><br>
            <a href="${pageContext.request.contextPath}/Login.do" class="btn btn-success">登录</a>
            <a href="${pageContext.request.contextPath}/Register.do" class="btn btn-success">注册</a>
            <p class="lead">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎来到点餐系统</p>
        </div>
    </div>

    <div class="container" >
        <div class="row">
          <div class="col-sm">
            <h3 class="nav-link active" >家常</h3>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">菠菜炒鸡蛋</h5>
                  <img src="/zhouhailin0506_MealSystem/images/jiachang/01.jpg" >
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                   <form action="${pageContext.request.contextPath}/QueryFood.do" method="post">
                    <input type="hidden" name="id" value=1>
                    <input type="submit" class="btn btn-primary" value="Go Somewhere" >
                   </form>
                </div>
              </div>

              <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">韭菜炒鸡蛋</h5>
                  <img src="/zhouhailin0506_MealSystem/images/jiachang/02.jpg" >
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <form action="${pageContext.request.contextPath}/QueryFood.do" method="post">
                    <input type="hidden" name="id" value=2>
                    <input type="submit" class="btn btn-primary" value="Go Somewhere" >
                     </form>
                </div>
              </div>


          </div>
          <div class="col-sm">
          <h3 class="nav-link active" >涼菜</h3>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">小葱拌豆腐</h5>
                  <img src="/zhouhailin0506_MealSystem/images/liangcai/1.jpg" >
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <form action="${pageContext.request.contextPath}/QueryFood.do" method="post">
                    <input type="hidden" name="id" value=11>
                    <input type="submit" class="btn btn-primary" value="Go Somewhere" >
                     </form>
                </div>
              </div>

              <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">泡椒凤爪</h5>
                  <img src="/zhouhailin0506_MealSystem/images/liangcai/2.jpg" >
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <form action="${pageContext.request.contextPath}/QueryFood.do" method="post">
                    <input type="hidden" name="id" value=12>
                    <input type="submit" class="btn btn-primary" value="Go Somewhere" >
                     </form>
                </div>
              </div>


          </div>
          <div class="col-sm">
           <h3 class="nav-link active" >主食</h3>
            <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">四川酸辣粉</h5>
                  <img src="/zhouhailin0506_MealSystem/images/zhushi/1.jpg" >
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <form action="${pageContext.request.contextPath}/QueryFood.do" method="post">
                    <input type="hidden" name="id" value=21>
                    <input type="submit" class="btn btn-primary" value="Go Somewhere" >
                     </form>
                </div>
              </div>

              <div class="card" style="width: 18rem;">
                <div class="card-body">
                  <h5 class="card-title">蛋包饭</h5>
                  <img src="/zhouhailin0506_MealSystem/images/zhushi/2.jpg" >
                  <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                    <form action="${pageContext.request.contextPath}/QueryFood.do" method="post">
                    <input type="hidden" name="id" value=22>
                    <input type="submit" class="btn btn-primary" value="Go Somewhere" >
                     </form>
                </div>
              </div>

          </div>
        </div>
      </div>
    
    <%@ include file="include/footer.jsp" %>
   
</body>
</html>