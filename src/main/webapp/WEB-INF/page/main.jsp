<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="common/include.jsp"/>
<body>
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
            <jsp:include page="common/breadcrumbs.jsp"/>

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