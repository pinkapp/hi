<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<table style="margin: auto; font-size: 14px; width: 100%;">
	<tr>
		<td align="right"><label for="userId">UID:</label></td>
		<td><label>${user.userId }</label></td>
	</tr>
	<tr>
		<td align="right"><label for="userName">用户名:</label></td>
		<td><label>${user.userName }</label></td>
	</tr>
	<tr>
		<td align="right"><label for="userType">角色:</label></td>
		<td><label>${user.userType }</label></td>
	</tr>
	<tr>
		<td align="right"><label for="note">备注:</label></td>
		<td><textarea>${user.note }</textarea></td>
	</tr>
</table>
