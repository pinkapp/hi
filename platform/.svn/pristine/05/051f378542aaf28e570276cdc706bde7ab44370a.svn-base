<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8" />
	<title>通用货币发放</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<link rel="stylesheet" href="<%=basePath%>css/jquery.ui.all.css">
	<script src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
	<script src="<%=basePath%>js/ui/jquery.ui.core.js"></script>
	<script src="<%=basePath%>js/ui/jquery.ui.widget.js"></script>
	<script src="<%=basePath%>js/ui/jquery.ui.position.js"></script>
	<script src="<%=basePath%>js/ui/jquery.ui.autocomplete.js"></script>
		<script>
			function doSubmit() {
				var myform = document.getElementById("myform");
				myform.submit();
			}
</script>
		<script>
	$(function() {
		function split( val ) {
			return val.split( /,\s*/ );
		}
		function extractLast( term ) {
			return split( term ).pop();
		}

		$( "#receiver" )
			// don't navigate away from the field on tab when selecting an item
			.bind( "keydown", function( event ) {
				if ( event.keyCode === $.ui.keyCode.TAB &&
						$( this ).data( "autocomplete" ).menu.active ) {
					event.preventDefault();
				}
			})
			.autocomplete({
				minLength: 0,
				source: function( request, response ) {
					$.getJSON( "<%=basePath%>json/searchUsername", {
						term: extractLast( request.term )
					}, response );
				},
				focus: function() {
					// prevent value inserted on focus
					return false;
				},
				select: function( event, ui ) {
					var terms = split( this.value );
					// remove the current input
					terms.pop();
					// add the selected item
					terms.push( ui.item.value );
					// add placeholder to get the comma-and-space at the end
					terms.push( "" );
					this.value = terms.join( ", " );
					return false;
				}
			});
	});
	</script>
	</head>
<body>
    <div>
    <div class="title1">信息中心&gt;&gt;通用货币发放</div>
    <div class="admin_content">
	
	   <table width="100%" cellpadding="0" cellspacing="0" >
	   <tr><td colspan="2"><s:label name="message" cssClass="highLightInfo"/></td></tr>
	   <form method="post" action="admin/moneyAssign_assign" id="myform">
	   <tr>
	   <td valign="top" height="60px;" width="100px;"><label>接收人：</label></td>
	   <td valign="top" ><input id="receiver" name="moneyAssign.receiver" style="width: 696px;height: 20px;" /><br/><label style="font-size: 12px;">多个用户使用逗号分开</label></td>
	   </tr>
	   <tr>
	   <td valign="top"><label>通用货币：</label></td>
	   <td ><s:textfield name="moneyAssign.money" /></td>
	   </tr>
	   <tr>
	   <td valign="top" height="60px;" width="100px;"><label>发放原因：</label></td>
	   <td valign="top" ><s:textarea cssStyle="width:700px;height:200px;" name="moneyAssign.assignreason" style="width: 696px;height: 20px;" /></td>
	   </tr>
	   <tr>
	   <td height="40px;">&nbsp;</td>
	   <td ><input type="button" value="发放" onclick="doSubmit();"/></td>
	   </tr>
	   </form>
	   <s:form namespace="/admin" action="moneyAssign_bassign" enctype="multipart/form-data" method="POST">
	   <tr>
	   <td><s:file name="file" /></td>
	   <td ><s:submit value="批量发放"/><s:a action="download_template" namespace="/">下载模板文件<s:param name="filename">moneyAssign.xls</s:param></s:a></td>
	   </tr>
	   </s:form>
	  </table>
	
	</div>
</body>
</html>