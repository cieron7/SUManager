<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
					<button type="button"  style="float: right;" class="btn btn-primary" onclick="javascript:window.location.href='${pageContext.request.contextPath}/teacher?action=preSave'">批量导入</button>
					<button class="btn btn-primary"  style="float: right;" data-toggle="modal" data-target="#myModal">添加</button>
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

<!--添加账号 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">添加账号</h4>
			</div>
			<div class="modal-body">
				<form id="account_add_from" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="account_id" class="col-sm-2 control-label">学号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="account_id" name="account_id" placeholder="请输入学号">
						</div>
					</div>
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">名字</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="username" id="username" placeholder="请输入名字">
						</div>
					</div>

					<div class="form-group">
						<label for="sex" class="col-sm-2 control-label">性别</label>
						<div class="checkbox-inline">
							<label>
								<input type="radio" id="sex" name="sex" value="1" checked> 男
							</label>
						</div>
						<div class="checkbox-inline">
							<label>
								<input type="radio" id="sex" name="sex" value="2"> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="mobile" class="col-sm-2 control-label">手机号码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="mobile" id="mobile" placeholder="请输入手机号码">
						</div>
					</div>

				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button id="account_add_submit" type="button" class="btn btn-primary" data-dismiss="modal">提交更改</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
<!-- 添加账号结束 -->
<script type="text/javascript">
    $(function(){
        $("#account_add_submit").click(function(){
            $.ajax({
                type: 'post',
                dataType: 'json',
                url: '/accountRedirectController.do?action=add',
                data: $("#account_add_from").serialize(),
                success: function(obj) {
                    if(obj.success == true){
                        window.location.reload();
					}else{
                        alert(obj.message);

					}
                }
            });
        });
    });

</script>









