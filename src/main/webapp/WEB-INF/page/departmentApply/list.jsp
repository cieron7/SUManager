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
				<table class="table table-hover  table-bordered table-striped" style="margin-bottom: 0px;">


					<tr>
						<th>申请编号</th>
						<th>申请部门</th>
						<th>申请职位</th>
						<th>操作</th>
					</tr>
					<c:forEach var="apply" items="${applyList }" varStatus="status">
						<tr>
							<td>${apply.id }</td>
							<td>${apply.departmentName }</td>
							<td>${apply.typeName }</td>
							<td><button type="button" class="btn btn-primary btn-xs" onclick="javascript:window.location.href='${pageContext.request.contextPath}/departmentApply/detail?applyId=${apply.id}'">详情</button>&nbsp;
								<button type="button" class="btn btn-danger btn-xs" onclick="applyDelete(${apply.id})">删除</button></td>
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

    function applyDelete(applyId){
        if(confirm("确认要删除这条记录吗？")){
            $.ajax({
                type: 'get',
                dataType: 'json',
                url: '/departmentApply/delete',
                data: {"applyId": applyId},
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









