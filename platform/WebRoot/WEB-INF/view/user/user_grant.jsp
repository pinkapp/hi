<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<script type="text/javascript">
	  function doChecked(){
	  	var roleId = document.getElementById("rid").value;
	  	var defaultuser = document.getElementById("defaultuser");
	  	//alert(roleId);
	    if(roleId ==0){
	    	defaultuser.checked = true;
	    }
	  }
	</script>
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;" onload="doChecked();">
<div class="title1">系统管理 &gt;&gt; 修改账号角色</div>
<s:hidden id="rid" name="roleId" />
  <s:form id="myform" action="user_grant" namespace="/admin">
  <s:hidden name="userId" />
  <table>
  <s:label name="message" cssClass="highLightInfo"/>
  <tr>
  <td>
  <s:radio list="rs" name="roleId" value="roleId" listKey="roleId" listValue="rolename"></s:radio>
  <input id="defaultuser" name="roleId" type="radio" value="0" /><s:label>默认用户</s:label>
  </td>
  </tr>
  <tr>
  <td>
  <s:submit value="确认" /><s:label name="message" cssClass="highLightInfo"/>
  <s:a namespace="/admin" action="user_role_manage">返回</s:a>
  </td>
  </tr>
  </table>
</s:form>
  </body>
</html>
