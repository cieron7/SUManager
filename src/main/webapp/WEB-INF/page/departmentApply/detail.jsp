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
									<label class="col-sm-2 control-label">申请部门</label>
									<div class="col-sm-10">
										<button id="department_btn" type="button" class="btn btn-default">
											${apply.departmentName}
                                        </button>
									</div>
								</div>

                                <div class="form-group">
                                    <label class="col-sm-2 control-label">选择职位</label>
                                    <div class="col-sm-10">
                                        <button id="type_btn" type="button" class="btn btn-default dropdown-toggle"
                                                data-toggle="dropdown">
                                            ${apply.typeName}
                                        </button>
                                    </div>
                                </div>

								<div class="form-group">
									<label class="col-sm-2 control-label">申请内容</label>
									<div class="col-sm-10">
                                        <div>${apply.content}</div>
									</div>
								</div>

							</form>

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

