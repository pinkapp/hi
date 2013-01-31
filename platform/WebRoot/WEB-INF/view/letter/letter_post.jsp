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
	<title>发送信息</title>
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
	<script charset="utf-8" src="<%=basePath%>kindeditor/kindeditor-min.js"></script>
		<script charset="utf-8" src="<%=basePath%>kindeditor/lang/zh_CN.js"></script>
		<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="letter.lettercontent"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons', 'image', 'link']
				});
			});
			
			function doSubmit() {
				var receiver = document.getElementById("receiver").value;
				var subject = document.getElementById("subject").value;
				if (subject == '') {
					alert("主题不能为空");
					return false;
				}
				if (receiver == '') {
					if (!confirm('未指定收件人，确定发给所有用户？')) {
						return false;
					}
				}
				editor.sync();
				var myform = document.getElementById("myform");
				myform.submit();
			}
		
			function setAll() {
				var receiver = document.getElementById("receiver");
				receiver.disabled = "disabled";
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
    <div class="title1">信息中心&gt;&gt;发送信息</div>
    <div class="admin_content">
	<form method="post" action="admin/letter_post" id="myform">
	   <table width="100%" cellpadding="0" cellspacing="0" >
	   <tr><td colspan="2"><s:label name="message" cssClass="highLightInfo"/></td></tr>
	   <tr>
	   <td valign="top" height="60px;" width="100px;"><label>收件人：</label></td>
	   <td valign="top" ><input id="receiver" name="letter.receiver" style="width: 696px;height: 20px;" /><br/><label style="font-size: 12px;">多个用户使用逗号分开,未指定收件人将发送给全部用户</label></td>
	   </tr>
	   <tr>
	   <td valign="top" height="60px;" width="100px;"><label>主题：</label></td>
	   <td valign="top" ><input id="subject" name="letter.subject" style="width: 696px;height: 20px;" /></td>
	   </tr>
	   <tr>
	   <td valign="top"><label>内容：</label></td>
	   <td ><textarea name="letter.lettercontent" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td>
	   </tr>
	   <tr>
	   <td height="40px;">&nbsp;</td>
	   <td ><input type="button" value="提交内容" onclick="doSubmit();"/></td>
	   </tr>
	  </table>
	</form>
	</div>
</body>
</html>