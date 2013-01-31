<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>角色修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;">
<div class="title1">系统管理 &gt;&gt; 修改角色</div>
<s:form id="myform" action="role_edit" method="post" namespace="/admin" >
<table class="infotable">
    <s:label name="message" cssClass="highLightInfo"/>
    <tr>
    <td width="80">角色名称：</td>
    <td><s:hidden name="role.roleId"/><s:textfield id="rolename" name="role.rolename" /></td>
    </tr>
    <td>&nbsp;</td>
	<td>
	<input type="submit"" value="提交"/><s:a namespace="/admin" action="role_manage">返回</s:a>
	<s:token />
	</td>
	</tr>
</table> 
</s:form>
</body>
</html>
