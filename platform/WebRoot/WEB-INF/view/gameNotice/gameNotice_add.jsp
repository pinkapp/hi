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
    
    <title>游戏公告添加</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;">
<div class="title1">首页相关 &gt;&gt; 添加游戏公告</div>
<s:form id="myform" action="gameNotice_add" method="post" namespace="/admin" >
<table class="infotable">
    <s:label name="message" cssClass="highLightInfo"/>
    <tr>
    <td width="80">游戏：</td>
    <td><s:select name="gn.game.gameId" list="games" listKey="gameId" listValue="gamename" /></td>
    </tr>
    <tr>
    <td>标题：</td>
    <td><s:textfield name="gn.noticetitle" /></td>
    </tr>
    <tr>
    <td>内容：</td>
    <td><s:textarea name="gn.noticecontent" /></td>
    </tr>
    <tr>
    <td>&nbsp;</td>
	<td>
	<input type="submit"" value="提交"/><s:a namespace="/admin" action="gameNotice_manage">返回</s:a>
	<s:token />
	</td>
	</tr>
</table> 
</s:form>
</body>
</html>
