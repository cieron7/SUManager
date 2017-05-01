<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div>
				<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">
					<tr>
						<th>机构编号</th>
						<th>机构名称</th>
						<th>logo</th>
						<th>操作</th>
					</tr>
						<tr>
							<td>${organization.id }</td>
							<td>${organization.name }</td>
							<td>${organization.logo }</td>
							<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/organization/update?orgId=${organization.id }'">修改</button>&nbsp;
								<button type="button" class="btn btn-danger btn-xs" onclick="studentDelete(${student.id })">删除</button></td>
						</tr>
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







