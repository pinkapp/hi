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
function del(oid)
{
	if(confirm('亲，确认要删除么？删除后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/gameOpen_delete?openId="+ oid;
	   myform.submit();
	}
	
}
</script>
  </head>
  <body>
  <div class="title1">首页相关 &gt;&gt; 服务器管理</div>
  <s:hidden id="openId" name="openId" />
  <s:form id="myform" action="gameOpen_manage" namespace="/admin">
  &nbsp;&nbsp;<label>游戏：</label><s:select name="gameOpen.gamename" list="games" listKey="gamename" listValue="gamename" headerKey="" headerValue="全部" />
  &nbsp;&nbsp;
  <s:submit value="查询" />
  &nbsp;&nbsp;<s:a namespace="/admin" action="gameOpen_add" >添加服务器</s:a>&nbsp;&nbsp;<s:label name="message" cssClass="highLightInfo"/>
    <table class="datatable">
    <tr>
    <th scope="col">游戏</th>
    <th scope="col">服务器</th>
    <th scope="col">开服时间</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="gameOpens">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td>${gamename }</td>
    <td>${game_server }</td>
    <td>${open_time }</td>
    <td><a href="javascript:del(${open_id });">删除</a>
    <s:a action="gameOpen_edit" namespace="/admin" >修改<s:param name="openId" value="%{open_id }"></s:param></s:a>
    </td>
  </tr>
  </s:iterator>
</table>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
