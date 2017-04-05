<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生会信息管理平台</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/su.css">
<style type="text/css">
	.navbar-inverse {
		background-color: #337ab7; 
		border-color: #337ab7; 
	}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

</head>
<body >
${mainPage}
<div class="container">
<div class="row">
	<div class="col-md-12">
		<jsp:include page="common/head.jsp"/>
	</div>
</div>

<div class="row" style="padding-top: 45px;">
	<div class="col-md-3">
		<jsp:include page="common/menu.jsp"/>
	</div>
	<div class="col-md-9">
		<div>
			<ol class="breadcrumb">
			  <li><span class="glyphicon glyphicon-home"></span>&nbsp;<a href="${pageContext.request.contextPath}/main.jsp">主页</a></li>
			  <li class="active">我谢谢你${modeName }</li>
			</ol>
		</div>
		<%--<jsp:include page="<%=mainPage %>"/>--%>
        <c:if test="${not empty mainPage}">
            <jsp:include page="${mainPage}"/>
        </c:if>
	</div>
</div>

<div class="row">
	<div class="col-md-12">
		<jsp:include page="common/foot.jsp"/>
	</div>
</div>
</div>
</body>
</html>