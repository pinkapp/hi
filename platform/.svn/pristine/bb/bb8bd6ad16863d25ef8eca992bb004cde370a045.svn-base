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
	function view(letterId)
	{
		window.location.href="<%=basePath%>admin/letter_outbox_view?letterId="+letterId;
	}
	function batchDelete(cName)
	{
	    var arr = new Array();
	    var checkboxs = document.getElementsByName(cName);
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked){
			   arr.push(checkboxs[i].value);
			};
		}
		if(arr==''){
		   alert("亲，您没选择哦");
		   return;
		}
		if(confirm('亲，确认要删除么？')){
		   var myform = document.getElementById("myform");
		   myform.action = "admin/letter_outbox_bdelete?letterIds="+ arr.toString();
		   myform.submit();
		}
		
	}
	</script>
  </head>
  <body>
  <div class="title1">信息中心 &gt;&gt; 发件箱</div>
  <s:hidden id="letterId" name="letterId" />
  <s:form id="myform" action="letter_inbox" namespace="/admin">
  &nbsp;<a href="javascript:batchDelete('c');">删除</a>
  <s:label name="message" cssClass="highLightInfo"/>
<table class="datatable">
   <tr>
    <th width="40px;" scope="col"><input type="checkbox" name="all" onclick="check_all(this,'c')" /></th>
    <th width="100px;" scope="col">收件人</th>
    <th scope="col">主题</th>
    <th width="150px;" scope="col">时间</th>
  </tr>
  <s:iterator value="outboxes">
  <tr onmouseover="this.style.backgroundColor='#EEEEEE'" onmouseout="this.style.backgroundColor=''">
    <td><input type="checkbox" name="c" value="${letter_id }"></td>
    <td onclick="view(${letter_id });">${receiver }</td>
    <td onclick="view(${letter_id });">${subject }</td>
    <td onclick="view(${letter_id });">${posttime }</td>
  </tr>
  </s:iterator>
</table>
<jsp:include page="../commons/page.jsp"></jsp:include>
</s:form>
  </body>
</html>
