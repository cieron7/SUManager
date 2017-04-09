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

			<div class="row search" >
				<div class="col-md-6">
					<form action="${pageContext.request.contextPath}/teacher?action=list" method="post">
						<div class="input-group" style="width: 300px">
							<input type="text" class="form-control" name="s_userName"  value="${s_teacher.userName }" placeholder="请输入要查询的用户名...">
							<span class="input-group-btn">
		        <button class="btn btn-default" type="submit"><span class="glyphicon glyphicon-search"></span>&nbsp;查询</button>
		      </span>
						</div>
					</form>
				</div>
				<div class="col-md-6" >
					<button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher?action=preSave'">添加</button>
				</div>
			</div>

			<div>


				<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">


					<tr>
						<th>学号</th>
						<th>真实姓名</th>
						<th>电话</th>
						<th>昵称</th>
						<th>账号类型</th>
						<th>操作</th>
					</tr>
					<c:forEach var="account" items="${accountList }" varStatus="status">
						<tr>
							<td>${account.id }</td>
							<td>${account.username }</td>
							<td>${account.mobile }</td>
							<td>${account.screenName }</td>
                            <td>${account.type }</td>
							<td><button type="button" class="btn btn-info btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher?action=preSave&id=${teacher.id }'">修改</button>&nbsp;
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

<script type="text/javascript">
	function teacherDelete(id){
		if(confirm("确认要删除这条记录吗？")){
			$.post("${pageContext.request.contextPath}/teacher?action=delete",{id:id},
				function(result){
					var result=eval('('+result+')');
					if(result.success){
						alert("删除成功!");
						window.location.href="${pageContext.request.contextPath}/teacher?action=list";
					}else{
						alert(result.errorInfo);
					}
				}
			);
		}
	}
</script>





