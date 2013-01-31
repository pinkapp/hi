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
		      alert("亲，管理员不能被删除哦");
		      return;
		   }
		   if(checkboxs[i].value == userId.value){
		   	  alert("亲，不能删除自己哦");
		   	  return;
		   }
		};
	}
	if(arr==''){
	   alert("亲，您没选择哦");
	   return;
	}
	if(confirm('亲，确认要删除么？删除后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/user_batchDelete?userIds="+ arr.toString();
	   myform.submit();
	}
	
}
function del(uid)
{
    var userId = document.getElementById("userId");
    if(uid == 1){
	alert("亲，管理员不能被删除哦");
	return;
	}
	if(uid == userId.value){
	alert("亲，不能删除自己哦");
	return;
	}
	if(confirm('亲，确认要删除么？删除后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/user_delete?userId="+ uid;
	   myform.submit();
	}
	
}
</script>
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;">
  <s:hidden id="userId" name="userId" />
  <s:form id="myform" action="user_manage" namespace="/admin">
  <div class="container">
  &nbsp;&nbsp;
  <label>登录名：</label><s:textfield name="userVo.username" />
  &nbsp;&nbsp;
  <label>角色：</label><s:select name="userVo.rolename" list="rs" listKey="rolename" listValue="rolename" headerValue="全部" headerKey=""></s:select>
  &nbsp;&nbsp;
  <s:submit value="查询" />
  </div>
  <div class="container">
  &nbsp;&nbsp;<input type="checkbox" name="all" onclick="check_all(this,'c')" />全选/全不选
  &nbsp;&nbsp;<s:a namespace="/user" action="register" target="_blank" >注册用户</s:a>&nbsp;&nbsp;<s:a href="javascript:batchDelete('c');">删除用户</s:a>&nbsp;&nbsp;<s:label name="message" cssClass="highLightInfo"/>
  </div>
  <div class="container">
    <table class="datatable">
  <!--<caption>Student List</caption>
  --><tr>
    <th scope="col">选择</th>
    <th scope="col">状态</th>
    <th scope="col">登录名</th>
    <th scope="col">上次登录IP</th>
    <th scope="col">上次登录时间</th>
    <th scope="col">登录次数</th>
    <th scope="col">角色</th>
    <th scope="col">电子邮件</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="users">
  <tr>
    <td><input type="checkbox" name="c" value="${user_id }"></td>
    <td><s:if test="state==0">正常</s:if><s:else>未知</s:else></td>
    <td>${username }</td>
    <td>${ip }</td>
    <td>${lastTime }</td>
    <td>${logincount }</td>
    <td><s:if test="rolename==null">默认用户</s:if><s:else>${rolename }</s:else></td>
    <td>${email }</td>
    
    <td><s:if test="user_id!=1"><a href="javascript:del(${user_id });">删除</a></s:if>
    <!--<s:a action="user_delete" namespace="/admin" >删除<s:param name="userId" value="%{user_id }"></s:param></s:a>
    --></td>
  </tr>
  </s:iterator>
</table>
</div>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
