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
    
    <title>友情链接修改</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
  </head>
  <body>
  <div class="title1">首页相关 &gt;&gt; 修改友情链接</div>
<s:form id="myform" action="friendlyLink_edit" method="post" namespace="/admin" enctype="multipart/form-data" >
<table class="infotable">
    <s:label name="message" cssClass="highLightInfo"/>
    <tr>
    <td width="80">网站名称：</td>
    <td><s:hidden name="flk.siteId"/><s:textfield id="sitename" name="flk.sitename" /></td>
    </tr>
    <tr>
    <td width="80">网站链接：</td>
    <td><s:textfield id="siteurl" name="flk.siteurl" /></td>
    </tr>
    <tr>
    <td>网站LOGO：</td>
    <td><s:file name="image" /></td>
    </tr>
    <tr>
    <td>&nbsp;</td>
	<td>
	<input type="submit"" value="提交"/><s:a namespace="/admin" action="friendlyLink_manage">返回</s:a>
	<s:token />
	</td>
	</tr>
</table> 
</s:form>
</DIV>
</DIV>
</body>
</html>
