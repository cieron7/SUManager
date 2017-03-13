<%--
  Created by IntelliJ IDEA.
  User: CAI
  Date: 2017/3/10
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>

    </style>
    <title>登陆</title>
    <link rel='stylesheet prefetch' href='${pageContext.request.contextPath} /css/bootstrap.min.css'>

    <link rel="stylesheet" href="${pageContext.request.contextPath} /css/style.css">
</head>
<body>
<div class="wrapper">
    <form class="form-signin" action="" method="post">
        <h2 class="form-signin-heading">欢迎使用</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名" required="" autofocus="" />
        <input type="password" class="form-control" name="password" placeholder="密码" required=""/>
        <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> 记住我
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </form>
</div>


</body>
</html>
