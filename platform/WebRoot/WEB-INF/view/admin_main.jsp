<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>亿网星漫运营平台后台管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/styles.css">
	</head>
	<frameset rows="150px,*" framespacing="1" frameborder="no">
	<frame name="top" src="topframe" style="border: 1px solid #dadada;"
		scrolling="auto">
	<frameset cols="220px,*" framespacing="1" frameborder="no">
	<frame name="left" src="frame/leftframe.jsp" noresize="yes"
		style="border: 1px solid #dadada;" scrolling="auto">
	<frame id="right" name="right" src="frame/rightframe.jsp"
		style="border: 1px solid #dadada;">
	</frameset>
	</frameset>
</html>
