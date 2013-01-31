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
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
  </head>
  <body>
  <div class="title1">账号管理 &gt;&gt; 封号</div>
  <s:form id="myform" action="user_close" namespace="/admin">
  <table class="searchtable" border="0">
  <tr><th><label>UID：</label></th><td><s:hidden name="user2.user_id" /><s:label name="user2.user_id" /></td></tr>
  <tr><th><label>账号：</label></th><td><s:label name="user2.username" /></td></tr>
  <tr><th><label>封号原因：</label></th><td><s:textarea cssStyle="width:700px;height:200px;" name="user2.closeReason" /></td></tr>
  <tr><th><label>封号类型：</label></th><td><s:select name="user2.closeType" list="#{0:'临时封',1:'永久封' }" listKey="key" listValue="value" value="0"/></td></tr>
  <tr><th><label>截止时间：</label></th><td><s:textfield cssClass="Wdate" name="user2.closeEndtime" onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM-dd HH:mm:ss'})"/></td></tr>
  <tr><th>&nbsp;</th><td><s:submit value="提交" /><s:a namespace="/admin" action="user_manage">返回</s:a></td></tr>
  <tr><td>&nbsp;</td>
  <td><s:label name="message" cssClass="highLightInfo"/></td></tr>
  </table>
</s:form>
  </body>
</html>
