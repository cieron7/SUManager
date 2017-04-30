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

			<div>
                <h3>部门名称：${department.name}</h3><h3>部门负责人：${manager.username}</h3>
				<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">


					<tr>
						<th>学号</th>
						<th>真实姓名</th>
						<th>电话</th>
						<th>昵称</th>
						<th>操作</th>
					</tr>
					<c:forEach var="account" items="${accountList }" varStatus="status">
						<tr>
							<td>${account.id }</td>
							<td>${account.username }</td>
							<td>${account.mobile }</td>
							<td>${account.screenName }</td>
							<td><button type="button" class="btn btn-danger btn-xs" onclick="accountDelete(${account.id })">删除</button></td>
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

<!--添加账号 -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="myModalLabel">账号信息</h4>
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
						<label class="col-sm-2 control-label">性别</label>
						<div class="checkbox-inline">
							<label>
								<input type="radio" id="sex1" name="sex" value="1" checked> 男
							</label>
						</div>
						<div class="checkbox-inline">
							<label>
								<input type="radio" id="sex2" name="sex" value="2"> 女
							</label>
						</div>
					</div>
					<div class="form-group">
						<label for="mobile" class="col-sm-2 control-label">手机号码</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="mobile" id="mobile" placeholder="请输入手机号码">
						</div>
					</div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮件地址</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="email" id="email" placeholder="邮件地址">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="screenName" class="col-sm-2 control-label">昵称</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="screenName" id="screenName" placeholder="昵称">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="type" class="col-sm-2 control-label">账号类型</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="type" id="type" placeholder="账号类型">
                        </div>
                    </div>



				</form>

			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
				<button id="account_add_submit" type="button" class="btn btn-primary" data-dismiss="modal">提交</button>
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
                url: '/account/add',
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

    /*查看学生详情*/
    function detail(accountId) {
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: '/account/detail',
            data: {"account_id": accountId},
            success: function(obj) {
                if(obj.success == true){
                    $("#account_add_btn").click();

                    $("#account_id").val(obj.data.id);
                    $('#account_id').attr("disabled","false");

                    $("#username").val(obj.data.username);
                    $('#username').attr("disabled","false");

                    if(obj.data.sex == "1"){
                        $('#sex1').attr("checked","true");
                    }else{
                        $('#sex2').attr("checked","true");
                    }

                    $("#mobile").val(obj.data.mobile);
                    $('#mobile').attr("disabled","false");

                    $("#email").val(obj.data.email);
                    $('#email').attr("disabled","false");

                    $("#screenName").val(obj.data.screenName);
                    $('#screenName').attr("disabled","false");

                    $("#username").val(obj.data.username);
                    $('#username').attr("disabled","false");

                    if(obj.data.type == 2){
                        $("#type").val("部长");
                    }else if(obj.data.type == 3){
                        $("#type").val("学生");
                    }
                    $("#type").attr("disabled","false");

                    $("#account_add_submit").remove();
                }else{
                    alert(obj.message);
                }
            }
        });
    }

    /*查看学生详情*/
    function update(accountId) {
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: '/account/detail',
            data: {"account_id": accountId},
            success: function(obj) {
                if(obj.success == true){
                    $("#account_add_btn").click();

                    $("#account_id").val(obj.data.id);
                    $('#account_id').attr("readonly","true");

                    $("#username").val(obj.data.username);

                    if(obj.data.sex == "1"){
                        $('#sex1').attr("checked","true");
                    }else{
                        $('#sex2').attr("checked","true");
                    }

                    $("#mobile").val(obj.data.mobile);

                    $("#email").val(obj.data.email);

                    $("#screenName").val(obj.data.screenName);

                    $("#username").val(obj.data.username);

                    $("#type").val("不可更改");
                    $("#type").attr("disabled","false");
                }else{
                    alert(obj.message);
                }
            }
        });
    }

    function accountDelete(accountId){
        if(confirm("确认要删除这条记录吗？")){
            $.ajax({
                type: 'get',
                dataType: 'json',
                url: '/departmentMember/delete',
                data: {"accountId": accountId, "departmentId":${department.id} },
                success: function(obj) {
                    if(obj.success == true){
                        window.location.reload();
                    }else{
                        alert(obj.message);
                    }
                }
            });
        }
    }

</script>









