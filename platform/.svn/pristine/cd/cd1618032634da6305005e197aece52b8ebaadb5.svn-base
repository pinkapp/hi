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
    <script type="text/javascript" src="<%=basePath%>js/lhgdialog/lhgcore.lhgdialog.min.js"></script>
	<script type="text/javascript">
	function view(rid){
	$.dialog({title:'查看角色功能',content: 'url:<%=basePath%>admin/role_view_function?roleId='+rid});
	}
	function edit(rid){
	if(rid==1){
	alert("亲，超级管理员不能被修改哦");
	return;
	}
	$.dialog({title:'修改角色功能',content: 'url:<%=basePath%>admin/role_edit_function?roleId='+rid});
	}
	</script>
  </head>
  <body>
  <div class="title1">系统管理 &gt;&gt; 角色功能管理</div>
  <s:hidden id="roleId" name="roleId" />
  <s:form id="myform" action="role_manage" namespace="/admin">
  <table class="datatable">
  <tr>
    <th scope="col">角色名称</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="rs">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td>${rolename }</td>
    <td><s:if test="roleId!=1"><a href="javascript:edit(${roleId })">修改功能</a></s:if>
    &nbsp;&nbsp;<a href="javascript:view(${roleId })">查看功能</a>
    </td>
  </tr>
  </s:iterator>
</table>
</s:form>
  </body>
</html>
