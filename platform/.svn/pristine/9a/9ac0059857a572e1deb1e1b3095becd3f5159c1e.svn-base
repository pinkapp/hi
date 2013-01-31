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
function check_all(obj,cName)
{
	var checkboxs = document.getElementsByName(cName);
	for(var i=0;i<checkboxs.length;i++){checkboxs[i].checked = obj.checked;}
}
function batchDelete(cName)
{
    var arr = new Array();
    var checkboxs = document.getElementsByName(cName);
	for(var i=0;i<checkboxs.length;i++){
		if(checkboxs[i].checked){
		   arr.push(checkboxs[i].value);
		   var userId = document.getElementById("userId");
		   if(checkboxs[i].value == 1){
		      alert("亲，管理员不能被封号哦");
		      return;
		   }
		   if(checkboxs[i].value == userId.value){
		   	  alert("亲，不能封号自己哦");
		   	  return;
		   }
		};
	}
	if(arr==''){
	   alert("亲，您没选择哦");
	   return;
	}
	if(confirm('亲，确认要封号么？封号后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/user_batchDelete?userIds="+ arr.toString();
	   myform.submit();
	}
	
}
/** 封号 */
function del(uid)
{
    var userId = document.getElementById("userId");
    if(uid == 1){
	alert("亲，超级管理员不能被封号哦");
	return;
	}
	if(uid == userId.value){
	alert("亲，不能封号自己哦");
	return;
	}
	if(confirm('亲，确认要封号么？')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/user_delete?userId="+ uid;
	   myform.submit();
	}
	
}
/** 解封 */
function recover(uid)
{
	if(confirm('亲，确认要解封么？')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/user_recover?userId="+ uid;
	   myform.submit();
	}
}
</script>
  </head>
  <body>
  <div class="title1">账号管理 &gt;&gt; 账号查询</div>
  <s:hidden id="userId" name="userId" />
  <s:form id="myform" action="user_manage" namespace="/admin">
  <table class="searchtable">
  <tr><td>&nbsp;</td><td>&nbsp;</td></tr>
  <tr><th><label>账号：</label></th><td><s:textfield name="userVo.username" /></td></tr>
  <tr><th><label>昵称：</label></th><td><s:textfield name="userVo.nickname" /></td></tr>
  <tr><th><label>电子邮件：</label></th><td><s:textfield name="userVo.email" /></td></tr>
  <tr><th><label>注册IP：</label></th><td><s:textfield name="userVo.register_ip" /></td></tr>
  <tr><th><label>账号状态：</label></th><td><s:select list="#{'':'全部','0':'被封','1':'未被封'}" name="userVo.statusCode"/></td></tr>
  <tr><th>&nbsp;</th><td><s:submit value="查询" /></td></tr>
  <tr><td>&nbsp;</td><td><s:label name="message" cssClass="highLightInfo"/></td></tr>
  </table>
<table class="datatable">
   <tr>
    <!--<th scope="col">选择</th>
    --><th scope="col">账号</th>
    <th scope="col">昵称</th>
    <th scope="col">性别</th>
    <th scope="col">年龄</th>
    <th scope="col">职业</th>
    <th scope="col">地区</th>
    <th scope="col">手机</th>
    <th scope="col">注册IP</th>
    <th scope="col">上次登录IP</th>
    <th scope="col">货币余额</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="users">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <!--<td><input type="checkbox" name="c" value="${user_id }"></td>
    --><td>${username }</td>
    <td>${nickname }</td>
    <td>${sex }</td>
    <td align="right">${age }岁</td>
    <td>${careeName }</td>
    <td>${area }</td>
    <td>${phone }</td>
    <td>${register_ip }</td>
    <td>${ip }</td>
    <td align="right">${money }游戏币</td>
    <td>
    &nbsp;&nbsp;<s:a namespace="/admin" action="user_edit" title="查看详细信息"><s:param name="userId">${user_id }</s:param>详情</s:a>
    <s:if test="user_id!=1&&user_id!=userId">
    <s:if test="statusCode==0"><s:a namespace="/admin" action="user_recover" title="查看封号原因"><s:param name="userId">${user_id }</s:param>已封号</s:a></s:if>
    <s:else><s:a namespace="/admin" action="user_close" title="封号"><s:param name="userId">${user_id }</s:param>封号</s:a></s:else>
    </s:if>
    </td>
  </tr>
  </s:iterator>
</table>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
