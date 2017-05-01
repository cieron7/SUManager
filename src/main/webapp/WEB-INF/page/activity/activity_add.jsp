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
                    <label for="title" class="col-sm-2 control-label">标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="title" id="title" placeholder="请输入标题">
                    </div>
                </div>

                <div class="form-group">
                    <label for="subTitle" class="col-sm-2 control-label">副标题</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="subTitle" id="subTitle" placeholder="请输入副标题">
                    </div>
                </div>


                <div class="form-group">
                    <label class="col-sm-2 control-label">开始时间</label>
                    <div class="col-sm-10">
                        <div class="input-group date form_datetime_startTime col-md-5"  data-date-format="yyyy MM dd - HH:ii p" data-link-field="startTime">
                            <input class="form-control" size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="startTime" name="startTime" value="" /><br/>
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">结束时间</label>
                    <div class="col-sm-10">
                        <div class="input-group date form_datetime_endTime col-md-5"  data-date-format="yyyy MM dd - HH:ii p" data-link-field="endTime">
                            <input class="form-control"  size="16" type="text" value="" readonly>
                            <span class="input-group-addon"><span class="glyphicon glyphicon-th"></span></span>
                        </div>
                        <input type="hidden" id="endTime" name ="endTime" value="" /><br/>
                    </div>
                </div>



                <div class="form-group">
                    <label for="limitNum" class="col-sm-2 control-label">活动人数</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="limitNum" id="limitNum" placeholder="请输入活动人数">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">活动内容</label>
                    <div class="col-sm-10">
                        <div><script id="editor" type="text/plain" style=height:400px;"></script></div>
                    </div>
                </div>

            </form>

            <div class="modal-footer">
                <button id="activity_add_submit" type="button" class="btn btn-primary" data-dismiss="modal">提交</button>
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
    $('.form_datetime_startTime').datetimepicker({
    //language:  'en',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
    });
    $('.form_datetime_endTime').datetimepicker({
    //language:  'zh-CN',
    weekStart: 1,
    todayBtn:  1,
    autoclose: 1,
    todayHighlight: 1,
    startView: 2,
    forceParse: 0,
    showMeridian: 1
    });

    var ue = UE.getEditor('editor');


    $(function () {
        $("#activity_add_submit").click(function () {

            var title = $("#title").val();
            if(title == ''){
                alert("请填写标题");
                return;
            }
            var subTitle = $("#subTitle").val();
            var startTime = $("#startTime").val();
            if(startTime == ''){
                alert("请选择活动开始日期");
                return;
            }


            var limitNum = $("#limitNum").val();
            var endTime = $("#endTime").val();
            if(endTime == ''){
                alert("请选择活动结束日期");
                return;
            }

            var content = UE.getEditor('editor').getContent();
            if (content == "") {
                alert("您还没有填写任何");
                return;
            }
            $.ajax({
                type: 'POST',
                url: "/activity/addActivity",
                dataType: "json",
                data: {
                    "title": title,
                    "subTitle":subTitle,
                    "limitNum":limitNum,
                    "startTime":startTime,
                    "endTime":endTime,
                    "content": content},
                success: function (obj) {
                    if(obj.success == true){
                        alert("提交申请成功！");
                        window.location.href="/activity/list";
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









