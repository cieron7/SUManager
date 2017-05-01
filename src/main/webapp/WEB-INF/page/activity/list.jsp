<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/include.jsp"/>
<body>
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<jsp:include page="../common/head.jsp"/>
		</div>
	</div>
	<div class="row" style="padding-top: 45px;">
		<div class="col-md-3">
			<jsp:include page="../common/menu.jsp"/>
		</div>
		<div class="col-md-9">
            <jsp:include page="../common/breadcrumbs.jsp"/>

			<div class="row search" >
				<div class="col-md-6">
				</div>
				<div class="col-md-6" >
					<button id="department_add_btn" class="btn btn-primary"  style="float: right;" onclick="javascript:window.location.href='${pageContext.request.contextPath}/activity/add'">添加</button>
				</div>
			</div>
			<div>
				<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
					<tr>
						<th>活动编号</th>
						<th>活动标题</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>操作</th>
					</tr>
					<c:forEach var="activity" items="${activityList }" varStatus="status">
						<tr>
							<td>${activity.id }</td>
							<td>${activity.title }</td>
							<td><fmt:formatDate value="${activity.startTime}" pattern="yyyy/MM/dd HH:mm"/></td>
							<td><fmt:formatDate value="${activity.endTime}" pattern="yyyy/MM/dd HH:mm"/></td>
							<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/activity/detail?activityId=${activity.id }'">详情</button>&nbsp;
								<button type="button" class="btn btn-danger btn-xs" onclick="teacherDelete(${teacher.id })">删除</button></td>
						</tr>
					</c:forEach>


				</table>
				<nav >
					<ul class="pagination">
						${pageCode }
					</ul>
				</nav>
			</div>

		</div>
	</div>

	<div class="row">
		<div class="col-md-12">
			<jsp:include page="../common/foot.jsp"/>
		</div>
	</div>
</div>
</body>
</html>







