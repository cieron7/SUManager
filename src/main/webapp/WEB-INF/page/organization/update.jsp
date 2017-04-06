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
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">${actionName }</h3>
					</div>
					<div class="panel-body">
						<form class="form-horizontal" role="form" method="post"  action="${pageContext.request.contextPath}/organizationRedirectController.do?action=save" onsubmit="return checkForm()" >
							<div class="form-group">
								<label  class="col-md-2 control-label">机构编号：</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="orgId"  name="orgId" style="width: 300px;"  value="${organization.id }" readonly="readonly">
								</div>
							</div>
							<div class="form-group">
								<label  class="col-md-2 control-label">机构名称：</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="orgName"  name="orgName" style="width: 300px;"  value="${organization.name }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-md-2 control-label">机构logo：</label>
								<div class="col-md-10">
									<input type="text" class="form-control" id="orgLogo"  name="orgLogo" style="width: 300px;"  value="${organization.logo }">
								</div>
							</div>

							<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-primary">保存</button>&nbsp;&nbsp;
									<button type="button" class="btn btn-primary" onclick="resetValue()">重置</button>&nbsp;&nbsp;
									<font color="red" id="error"></font>
								</div>
							</div>
						</form>
					</div>
				</div>
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
	function checkForm(){
		var orgName=$("#orgName").val();
		var trueName=$("#trueName").val();
		var stuNo=$("#stuNo").val();
		var professional=$("#professional").val();
		if(orgName==null||orgName==""){
			$("#error").html("机构名称不能为空！");
			return false;
		}

		return true;
	}
	
	function resetValue(){
		$("#orgName").val("");
		$("#orgLogo").val("");
    }
</script>


