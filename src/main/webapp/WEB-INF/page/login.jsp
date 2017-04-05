<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生会信息管理平台</title>
    <link rel='stylesheet prefetch' href='/css/bootstrap.min.css'>

    <link rel="stylesheet" href="/css/style.css">
    <style type="text/css">
        body{
            background-image: url("/images/IMG_0005.JPG");
            background-size: 100% 100%;
        }
    </style>
</head>
<body>
<div class="wrapper">
    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">欢迎使用</h2>
        <input type="text" class="form-control" name="username" placeholder="用户名" required="" autofocus=" "/>
        <input type="password" class="form-control" name="password" placeholder="密码" required=""/>
        <label class="checkbox">
            <input type="checkbox" value="remember-me" id="rememberMe" name="rememberMe"> 记住我
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
    </form>
</div>


</body>
</html>
