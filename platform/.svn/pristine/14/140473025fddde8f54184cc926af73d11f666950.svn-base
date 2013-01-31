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
function del(sid)
{
	if(confirm('亲，确认要删除么？删除后无法恢复！')){
	   var myform = document.getElementById("myform");
	   myform.action = "admin/friendlyLink_delete?siteId="+ sid;
	   myform.submit();
	}
	
}
</script>
  </head>
  <body>
  <div class="title1">首页相关 &gt;&gt; 友情链接管理</div>
  <s:hidden id="friendlyLinkId" name="friendlyLinkId" />
  <s:form id="myform" action="friendlyLink_manage" namespace="/admin">
  &nbsp;&nbsp;
  <label>网站名称：</label><s:textfield name="flk.friendlyLinkname" />
  &nbsp;&nbsp;
  <s:submit value="查询" />
  &nbsp;&nbsp;<s:a namespace="/admin" action="friendlyLink_add" >添加友情链接</s:a>&nbsp;&nbsp;<s:label name="message" cssClass="highLightInfo"/>
    <table class="datatable">
    <tr>
    <th scope="col">网站名称</th>
    <th scope="col">网站地址</th>
    <th scope="col">操作</th>
  </tr>
  <s:iterator value="friendlyLinks">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td>${sitename }</td>
    <td>${siteurl }</td>
    <td><a href="javascript:del(${site_id });">删除</a>
    <s:a action="friendlyLink_edit" namespace="/admin" >修改<s:param name="siteId" value="%{site_id }"></s:param></s:a>
    </td>
  </tr>
  </s:iterator>
</div>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
