<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button class="navbar-toggle collapsed" type="button" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand hidden-sm" href="/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'navbar-首页'])">学生会信息管理平台</a>
    </div>
    <div class="navbar-collapse collapse" role="navigation" style="float: right">
      <ul class="nav navbar-nav">
        <li><a href="#" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'expo'])">网络部-蔡蔡</a></li>
        <li><a href="/manage/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'expo'])">进入后台</a></li>
        <li><a href="/" target="_blank" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'expo'])">退出</a></li>
      </ul>
      <!--<ul class="nav navbar-nav navbar-right hidden-sm">-->
      <!--<li><a href="/about/" onclick="_hmt.push(['_trackEvent', 'navbar', 'click', 'about'])">关于</a></li>-->
      <!--</ul>-->
    </div>
  </div>
</div>