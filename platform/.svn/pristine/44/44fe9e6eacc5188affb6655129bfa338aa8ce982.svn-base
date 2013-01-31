<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>看信</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<script type="text/javascript">
	function del(letterId)
	{
		if(confirm('亲，确认要删除么？')){
		    window.location.href="<%=basePath%>admin/letter_outbox_delete?letterId="+letterId;
		}
	}
	</script>
<html>
<body>
    <s:a namespace="/admin" action="letter_outbox">返回</s:a><a href="javascript:del(${outbox.letterId });">删除</a>
    <table width="100%" >
    <tr><td colspan="2"><label style="font-weight: bold;font-size: 24px;">${outbox.subject }</label></td></tr>
    <tr>
    <th width="50" align="right"><label>收件人:</label></th><td><label>${outbox.receiver }</label></td>
    </tr>
    <tr>
    <th align="right"><label>时间:</label></th><td><label>${outbox.posttime }</label></td>
    </tr>
    <tr><td colspan="2"><div style="width: 90%;height: 500px;border: 1px solid #dadada;">${outbox.lettercontent }</div></td></tr>
    </table>
</body>
</html>