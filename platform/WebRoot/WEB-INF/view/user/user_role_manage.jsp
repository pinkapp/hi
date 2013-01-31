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
	function edit(uid){
	if(uid==1){
	alert("亲，超级管理员角色不能被修改哦");
	return;
	}
	window.location.href = '<%=basePath%>admin/user_grant?userId=' + uid;
	}
	</script>
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;">
  <div class="title1">系统管理 &gt;&gt; 账号角色管理</div>
  <s:hidden id="userId" name="userId" />
  <s:form id="myform" action="user_role_manage" namespace="/admin">
  <table class="searchtable">
  <tr><th><label>角&nbsp;&nbsp;&nbsp;色：</label></th><td><s:select name="userVo1.rolename" list="rs" listKey="rolename" listValue="rolename" headerValue="全部" headerKey=""></s:select></td></tr>
  <tr><th><label>用户名：</label></th><td><s:textfield name="userVo1.username" /></td></tr>
  <tr><td>&nbsp;</td><td><s:submit value="查询" /></td></tr>
  <tr><td>&nbsp;</td><td><s:label name="message" cssClass="highLightInfo"/></td></tr>
  </table>
  <table class="datatable">
  <tr>
    <th scope="col">用户名</th>
    <th scope="col">角色</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="user1s">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td>${username }</td>
    <td><s:if test="rolename==null">默认用户</s:if><s:else>${rolename }</s:else></td>
    <td><s:if test="user_id!=1"><a href="javascript:edit(${user_id })">修改角色</a></s:if>
    </td>
  </tr>
  </s:iterator>
</table>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
