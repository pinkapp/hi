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
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;">个人中心</label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1">帐号信息&gt;&gt;帐号安全</div>
	    <div class="contentbody">
        <table class="infotable">
        <tr><td><label>绑定手机：</label>
        <s:if test="user.phone!=null"><s:label name="user.phone" /></s:if>
        <s:else><s:label name="message"/><s:a href="user/mobile_verify" cssStyle="font-size: 12px;color: blue;">绑定&gt;&gt;</s:a></s:else>
        </td></tr>
        <tr><td style="font-size: 12px;">找回密码、帐号安全认证的最重要途径。</td></tr>
        <tr><td><label>绑定身份证：</label>
        <s:if test="message2==null"><s:label name="user.cardId" /></s:if>
        <s:else><s:label name="message2"/><s:a href="user/cardidauth" cssStyle="font-size: 12px;color: blue;">绑定&gt;&gt;</s:a></s:else>
        </td></tr>
        <tr><td style="font-size: 12px;">为了您的帐号安全，证件信息设置后不能更改。</td></tr>
        </table>
        </div>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
