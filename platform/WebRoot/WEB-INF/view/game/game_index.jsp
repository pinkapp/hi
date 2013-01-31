<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>亿网星漫</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
  </head>
  <body>
  <jsp:include page="../commons/header.jsp"></jsp:include>
<div class="details clearfix">
<DIV class=widget >
<DIV class=header>
<DIV class=title>游戏大厅</DIV></DIV>
<DIV class=body>
<s:iterator value="games">
<DIV class=order_choose_img>
<A class=order_choose_img_link title="${gamename }" href="#"><IMG alt="" src="<%=basePath%>upload/gamelogo/${gameLogo}"></A>
</DIV>
</s:iterator>
</DIV>
</DIV>
</div>
  <jsp:include page="../commons/footer.jsp"></jsp:include>
  </body>
</html>
