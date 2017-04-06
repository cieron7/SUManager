<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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
						<th>序号</th>
						<th>用户名</th>
						<th>密码</th>
						<th>真实姓名</th>
						<th>学号</th>
						<th>专业</th>
						<th>操作</th>
					</tr>
					<c:forEach var="student" items="${studentList }" varStatus="status">
						<tr>
							<td>${status.index+1 }</td>
							<td>${student.userName }</td>
							<td>${student.password }</td>
							<td>${student.trueName }</td>
							<td>${student.stuNo }</td>
							<td>${student.professional }</td>
							<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/student?action=preSave&id=${student.id }'">修改</button>&nbsp;
								<button type="button" class="btn btn-danger btn-xs" onclick="studentDelete(${student.id })">删除</button></td>
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







