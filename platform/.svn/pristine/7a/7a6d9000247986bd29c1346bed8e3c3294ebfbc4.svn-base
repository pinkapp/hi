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
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;"><s:text name="user_edit.personcenter"/></label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1"><s:text name="user_edit.userinfo"/>&gt;&gt;<s:text name="user_edit.editinfo"/></div>
	    <div class="contentbody">
		<s:form action="edit" namespace="/user">
		<table class="infotable">
		<tr><td><label><s:text name="user_edit.username"/>${user.username }</label></td></tr>
		<tr><td><label><s:text name="user_edit.nickname"/></label><s:textfield name="user.nickname"/></td></tr>
		<tr><td><label><s:text name="user_edit.sex"/></label><s:radio list="sexs" name="user.sex" listKey="key" listValue="value"/></td></tr>
		<tr><td><label><s:text name="user_edit.birthday"/></label><s:textfield cssClass="Wdate" name="user.birthday" onFocus="WdatePicker({isShowClear:false,readOnly:true})"/></td></tr>
		<tr><td class="doubleselect"><label><s:text name="user_edit.area"/></label><s:doubleselect name="user.province" list="provinces" listKey="proName" listValue="proName" doubleList="top.cities" doubleName="user.city" doubleListKey="cityName" doubleListValue="cityName" theme="simple"/></td></tr>
		<tr><td><label><s:text name="user_edit.career"/></label><s:select list="careers" listKey="id" listValue="careeName" name="user.careerId"/></td></tr>
		<tr><td><s:submit key="user_edit.confirm"/></td></tr>
		</table>
		</div>
		</s:form>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
