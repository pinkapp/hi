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
function del(uid)
{
	if(confirm('亲，确认要删除么？删除后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/game_delete?gameId="+ uid;
	   myform.submit();
	}
	
}
</script>
  </head>
  <body>
  <div class="title1">首页相关 &gt;&gt; 游戏管理</div>
  <s:hidden id="gameId" name="gameId" />
  <s:form id="myform" action="game_manage" namespace="/admin">
  &nbsp;&nbsp;
  <label>游戏名称：</label><s:textfield name="gameVo.gamename" />
  &nbsp;&nbsp;
  <s:submit value="查询" />
  &nbsp;&nbsp;<s:a namespace="/admin" action="game_add" >添加游戏</s:a>&nbsp;&nbsp;<s:label name="message" cssClass="highLightInfo"/>
    <table class="datatable">
    <tr>
    <th scope="col">游戏名称</th>
    <th scope="col">官方网站</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="games">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td>${gamename }</td>
    <td>${game_url }</td>
    <td><a href="javascript:del(${game_id });">删除</a>
    <s:a action="game_edit" namespace="/admin" >修改<s:param name="gameId" value="%{game_id }"></s:param></s:a>
    </td>
  </tr>
  </s:iterator>
</table>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
