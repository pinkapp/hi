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
  <script type="text/javascript">
<!--
function logout(){
  if(confirm('确认要退出？'))window.top.location.href = '<%=basePath%>user/logout';
}
//-->
</script>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;" ><s:text name="user_index.personcenter" /></label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
    <!--个人资料-->
	<div class="title1"><s:text name="user_index.userinfo" />&gt;&gt;<s:text name="user_index.myinfo" /></div>
	<table border="0" width="100%">
	<tr>
	<td width="100" valign="top">
	<s:if test="user.portraitUrl==null||user.portraitUrl==''"><img src="<%=basePath%>images/noavatar_middle.gif" class="user_avatar" /></s:if>
	<s:else><img src="<%=basePath%>upload/portrait/${user.portraitUrl}" class="user_avatar" /></s:else>
	</td>
	<td valign="bottom">
	<h2>${user.username }<s:text name="user_index.welcome" /></h2><s:if test="manager==true">
	<s:a namespace="/" action="admin_main"><s:text name="user_index.goplatform" /> &gt;&gt;</s:a>&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
	<a href="javascript:logout();" class="primaryColor"><s:text name="user_index.logout" /> &gt;&gt;</a>
	<p><span><s:text name="user_index.lasttimelogin" /></span>${user.lastTime }</p>
	<p><s:text name="user_index.nearestplay" /></p>
	<p><s:text name="user_index.newgame" /></p>
	</td>
	</tr>
	</table>
	<!--安全中心-->
	<!--基本资料-->
	<div class="title2"><s:text name="user_index.basicinfo"/></div>
	<div class="contentbody">
	<table class="infotable">
	<tr><td><label><s:text name="user_index.sex" /><s:if test="user.sex==1"><s:text name="user_index.male" /></s:if><s:if test="user.sex==0"><s:text name="user_index.female" /></s:if></label></td></tr>
	<tr><td><label><s:text name="user_index.birthday" />${user.birthday }</label></td></tr>
	<tr><td><label><s:text name="user_index.area" />${user.province }&nbsp;&nbsp;${user.city }</td></label></tr>
	<tr><td><label><s:text name="user_index.career" />${careerName }</label></td></tr>
	<tr><td colspan="2"><a href="<%=basePath%>user/edit" class="primaryColor"><s:text name="user_index.edit"/> &gt;&gt;</a></td></tr>
	</table>
	</div>
	<!--防沉迷-->
	<div class="title2"><s:text name="user_index.cardidauth" /></div>
	<div class="contentbody">
	<table>
	<tr><td><label><s:text name="user_index.realname" />${user.realname }</label></td></tr>
	<tr><td><label><s:text name="user_index.cardid" />${user.cardId }</label></td></tr>
	</table>
	</div>
	</div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
</body>
</html>
