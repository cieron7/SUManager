<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
function logout(){
	if(confirm('您确定要退出系统吗？')){
		window.location.href="${pageContext.request.contextPath}/user?action=logout";
	}
}
</script>
<div class="list-group">
  <a href="#" class="list-group-item active">
    系统菜单
  </a>

	<%--<c:foreach items="${menu}" var ="li" varStatus="status">--%>
		<%--<c:if test="${status.first}">我是第一个元素</c:if>--%>
		<%--<c:if test="${status.last}">我是最后一个元素</c:if>--%>
	<%--</c:foreach>--%>
<%--<c:if test="${ currentUser.userType=='管理员'}">--%>
	  <a href="${pageContext.request.contextPath}/organizationRedirectController.do?action=list" class="list-group-item">机构信息管理</a>
	  <a href="${pageContext.request.contextPath}/accountRedirectController.do?action=list" class="list-group-item">账号信息管理</a>
	  <a href="${pageContext.request.contextPath}/course?action=list" class="list-group-item">课程信息管理</a>
  <%--</c:if>--%>
  <%--<c:if test="${ currentUser.userType=='教师'}">--%>
	  <%--<a href="${pageContext.request.contextPath}/teacher?action=showCourse" class="list-group-item">查看课程</a>--%>
	  <%--<a href="${pageContext.request.contextPath}/teacher?action=showStudent" class="list-group-item">查看学生</a>--%>
	  <%--<a href="${pageContext.request.contextPath}/teacher?action=scoreInfo" class="list-group-item">成绩录入</a>--%>
	  <%--<a href="${pageContext.request.contextPath}/teacher?action=showInfo" class="list-group-item">个人信息查看</a>--%>
	  <%--<a href="javascript:logout()" class="list-group-item">安全退出</a>--%>
  <%--</c:if>--%>
  <%--<c:if test="${ currentUser.userType=='学生'}">--%>
	  <%--<a href="${pageContext.request.contextPath}/student?action=courseList" class="list-group-item">课程信息查看</a>--%>
	  <%--<a href="${pageContext.request.contextPath}/student?action=preSelect" class="list-group-item">选择课程</a>--%>
	  <%--<a href="${pageContext.request.contextPath}/student?action=showScore" class="list-group-item">成绩查询</a>--%>
	  <%--<a href="${pageContext.request.contextPath}/student?action=showInfo" class="list-group-item">个人信息查看</a>--%>
	  <%--<a href="javascript:logout()" class="list-group-item">安全退出</a>--%>
  <%--</c:if>--%>
</div>