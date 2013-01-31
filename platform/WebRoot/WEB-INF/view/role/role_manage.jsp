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
function del(rid)
{
	if(confirm('亲，确认要删除么？删除后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/role_delete?roleId="+ rid;
	   myform.submit();
	}
	
}
</script>
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;">
  <div class="title1">系统管理 &gt;&gt; 角色管理</div>
  <s:hidden id="roleId" name="roleId" />
  <s:form id="myform" action="role_manage" namespace="/admin">
  &nbsp;&nbsp;<s:a namespace="/admin" action="role_add">添加角色</s:a>&nbsp;&nbsp;<s:label name="message" cssClass="highLightInfo"/>
 <table class="datatable">
  <tr>
    <th scope="col">角色名称</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="rs">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td>${rolename }</td>
    <td>
    <s:if test="roleId!=1">
    <s:a namespace="/admin" action="role_edit"><s:param name="roleId" value="%{roleId }"/>修改</s:a>
    </s:if>
    <s:if test="roleId!=1">
    <a href="javascript:del(${roleId });">删除</a>
    </s:if>
    </td>
  </tr>
  </s:iterator>
</table>
</s:form>
  </body>
</html>
