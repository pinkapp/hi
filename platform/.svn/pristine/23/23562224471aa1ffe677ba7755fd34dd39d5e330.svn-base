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
	<script type="text/javascript" src="<%=basePath%>js/ywxm.js"></script>
	<script type="text/javascript">
	function validator(){
		var oldpass = document.getElementById("oldpass").value;
		var newpass = document.getElementById("newpass").value;
		var confirmpass = document.getElementById("confirmpass").value;
		if(oldpass==''){
		   alert('<s:text name="user_editpass.pleaseinputoldpassword"/>');
		   return false;
		}
		if(newpass == ''){
		   alert('<s:text name="user_editpass.pleaseinputnewpassword"/>');
		   return false;
		}
		var b = check(newpass,"password");
		if(!b){
		   alert('<s:text name="user_editpass.passwordmust"/>');
		   return false;
		}
		if(newpass!=confirmpass){
		   alert('<s:text name="user_editpass.twicemustsame"/>');
		   return false;
		}
		document.getElementById("myform").submit();
	}
	</script>
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;"><s:text name="user_editpass.personcenter"/></label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1"><s:text name="user_editpass.userinfo"/>&gt;&gt;<s:text name="user_editpass.editpassword"/></div>
	    <div class="contentbody">
        <s:form id="myform" action="editpass" namespace="/user">
        <table class="infotable">
        <tr><s:label name="message" cssClass="highLightInfo"/></tr>
        <tr><td width="100"><label><s:text name="user_editpass.username"/></label></td><td>${user.username }</td></tr>
        <tr><td><label><s:text name="user_editpass.oldpassword"/></label></td><td><s:password id="oldpass" name="oldpass"/></td></tr>
        <tr><td><label><s:text name="user_editpass.newpassword"/></label></td><td><s:password id="newpass" name="newpass"/></td></tr>
        <tr><td><label><s:text name="user_editpass.confirmpasswrod"/></label></td><td><s:password id="confirmpass"/></td></tr>
        <tr><td><input type="button" value='<s:text name="user_editpass.confirmedit"/>' onclick="validator();" /></td></tr>
        </table>
        </s:form>
        </div>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
