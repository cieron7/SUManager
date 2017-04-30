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
				</div>
				<div class="col-md-6" >
					<button id="department_add_btn" class="btn btn-primary"  style="float: right;" data-toggle="modal" data-target="#myModal">添加</button>
				</div>
			</div>

			<div>
				<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">

					<tr>
						<th>部门ID</th>
						<th>部门名称</th>
						<th>职能</th>
						<th>操作</th>
					</tr>
					<c:forEach var="department" items="${departmentList }" varStatus="status">
						<tr>
							<td>${department.id }</td>
							<td>${department.name }</td>
							<td>${department.function }</td>
							<td><button type="button" class="btn btn-primary btn-xs" onclick="detail(${department.id })">详情</button>&nbsp;
                                <button type="button" class="btn btn-info btn-xs" onclick="update(${department.id })">修改</button>&nbsp;
								<button type="button" class="btn btn-danger btn-xs" onclick="departmentDelete(${department.id })">删除</button></td>
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
				<h4 class="modal-title" id="myModalLabel">部门信息</h4>
			</div>
			<div class="modal-body">
				<form id="account_add_from" class="form-horizontal" role="form">
					<div class="form-group">
						<label for="department_id" class="col-sm-2 control-label">部门编号</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="department_id" name="department_id" placeholder="请输入部门号">
						</div>
					</div>
					<div class="form-group">
						<label for="department_name" class="col-sm-2 control-label">部门名字</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="department_name" id="department_name" placeholder="请输入名字">
						</div>
					</div>


                    <div class="form-group">
                        <label for="department_function" class="col-sm-2 control-label">部门职能</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="department_function" id="department_function" placeholder="邮件地址">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="department_description" class="col-sm-2 control-label">部门描述</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="department_description" id="department_description" placeholder="部门描述">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="department_createTime" class="col-sm-2 control-label">创建日期</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" name="department_createTime" id="department_createTime" placeholder="请输入手机号码">
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
    function detail(department_id) {
        $.ajax({
            type: 'post',
            dataType: 'json',
            url: '/department/detail',
            data: {"department_id": department_id},
            success: function(obj) {
                if(obj.success == true){
                    $("#department_add_btn").click();

                    $("#department_id").val(obj.data.id);
                    $('#department_id').attr("disabled","false");

                    $("#department_name").val(obj.data.name);
                    $('#department_name').attr("disabled","false");

                    $("#department_createTime").val(obj.data.createTime);
                    $('#department_createTime').attr("disabled","false");

                    $("#department_function").val(obj.data.function);
                    $('#department_function').attr("disabled","false");

                    $("#department_description").val(obj.data.description);
                    $('#department_description').attr("disabled","false");

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
            data: {"department_id": accountId},
            success: function(obj) {
                if(obj.success == true){
                    $("#department_add_btn").click();

                    $("#department_id").val(obj.data.id);
                    $('#department_id').attr("readonly","true");

                    $("#department_name").val(obj.data.department_name);

                    if(obj.data.sex == "1"){
                        $('#sex1').attr("checked","true");
                    }else{
                        $('#sex2').attr("checked","true");
                    }

                    $("#department_createTime").val(obj.data.department_createTime);

                    $("#department_function").val(obj.data.department_function);

                    $("#screenName").val(obj.data.screenName);

                    $("#department_name").val(obj.data.department_name);

                    $("#type").val("不可更改");
                    $("#type").attr("disabled","false");
                }else{
                    alert(obj.message);
                }
            }
        });
    }

    function departmentDelete(departmentId){
        if(confirm("确认要删除这条记录吗？")){
            $.ajax({
                type: 'post',
                dataType: 'json',
                url: '/department/delete',
                data: {"department_id": departmentId},
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









