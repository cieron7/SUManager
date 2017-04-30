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
							<form id="account_add_from" class="form-horizontal" role="form">
								<div class="form-group">
									<label class="col-sm-2 control-label">选择部门</label>
									<div class="col-sm-10">
										<button id="department_btn" type="button" class="btn btn-default dropdown-toggle"
												data-toggle="dropdown">
											部门列表 <span class="caret"></span>
                                        </button>
										<ul class="dropdown-menu" role="menu">

											<c:forEach var="department" items="${departmentList }" varStatus="status">
                                                <li onclick="selectDepartment('${department.name }', ${department.id })"><a href="#">${department.name }</a></li>
											</c:forEach>
                                            <input type="hidden" class="form-control" id="departmentId" name="departmentId">
										</ul>
									</div>
								</div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">选择职位</label>
                                    <div class="col-sm-10">
                                        <button id="type_btn" type="button" class="btn btn-default dropdown-toggle"
                                                data-toggle="dropdown">
                                            职位列表 <span class="caret"></span>
                                        </button>
                                        <ul class="dropdown-menu" role="menu">

                                                <li onclick="selectPosition('部长', 4)"><a href="#">部长</a></li>
                                                <li onclick="selectPosition('副部长', 5)"><a href="#">副部长</a></li>
                                                <li onclick="selectPosition('部员', 6)"><a href="#">部员</a></li>
                                            <input type="hidden" class="form-control" id="position_type" name="position_type">
                                        </ul>
                                    </div>
                                </div>

								<div class="form-group">
									<label class="col-sm-2 control-label">申请内容</label>
									<div class="col-sm-10">
                                        <div><script id="editor" type="text/plain" style=height:400px;"></script></div>
									</div>
								</div>

							</form>

						<div class="modal-footer">
							<button id="apply_add_submit" type="button" class="btn btn-primary" data-dismiss="modal">提交</button>
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

    var ue = UE.getEditor('editor');


    function selectDepartment(name, id) {
        $("#department_btn").html(name);
        $("#departmentId").val(id);
    }

    function selectPosition(name, id) {
        $("#type_btn").html(name);
        $("#position_type").val(id);
    }

    $(function () {
        $("#apply_add_submit").click(function () {
            var content = UE.getEditor('editor').getContent();
            var departmentId = $("#departmentId").val();
            if(departmentId == ''){
                alert("您还没有选择部门");
                return;
            }
            var type = $("#position_type").val();
            if(type == ''){
                alert("您还没有选择职位");
                return;
            }
            if (content == "") {
                alert("您还没有填写任何");
                return;
            }
            $.ajax({
                type: 'POST',
                url: "/departmentApply/apply",
                dataType: "json",
                data: {"content": content, "departmentId":departmentId, "type":type},
                success: function (obj) {
                    if(obj.success == true){
                        alert("提交申请成功！");
                    }else{
                        alert(obj.message);
                    }
                }
            });
            // 清空数据
            UE.getEditor('editor').setContent('');
            $("#departmentId").val('');
            $("#position_type").val('');
            $("#type_btn").html('职位列表');
            $("#department_btn").html('部门');
        });

    });

</script>









