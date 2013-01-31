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
		var spasswd = document.getElementById("spasswd").value;
		var confirmpass = document.getElementById("confirmpass").value;
		if(spasswd == ''){
		   alert('请输入二级密码');
		   return false;
		}
		var b = check(spasswd,"password");
		if(!b){
		   alert('密码必须是6-16位数字或字母或下划线组成');
		   return false;
		}
		if(spasswd!=confirmpass){
		   alert('两次输入的新密码必须相同');
		   return false;
		}
		document.getElementById("myform").submit();
	}
	</script>
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;">个人中心</label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1">账号安全&gt;&gt;二级密码</div>
	    <div class="contentbody">
	    <s:if test="yetSecondaryPassword==0">
        <s:form id="myform" action="spasswd" namespace="/user">
        <table class="infotable">
        <tr><s:label name="message" cssClass="highLightInfo"/></tr>
        <tr><td><label>二级密码</label></td><td><s:password id="spasswd" name="spasswd"/></td></tr>
        <tr><td><label>密码确认</label></td><td><s:password id="confirmpass"/></td></tr>
        <tr><td><input type="button" value='设置' onclick="validator();" /></td></tr>
        </table>
        </s:form>
        </s:if>
        <s:else>
        <lable>二级密码已经设置</lable>
        </s:else>
        </div>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
