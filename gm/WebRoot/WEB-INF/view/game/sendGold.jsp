<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>发金币</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="keywords" content="英雄领域,亿网星漫">
<meta http-equiv="description" content="Online Charge System">
<link id="easyuiTheme" rel="stylesheet" type="text/css"
	href="easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="easyUI/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="easyUI/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">
		$(function(){
			$('form').form({
				success:function(data){
					$.messager.alert('信息', data, 'info');
				}
			});
		});
		function switchType(type){
	        var receiver1 = $('#receiver1');
	        var receiver2 = $('#receiver2');
	        var receiver_ = $('#receiver_');
	        debugger;
			switch(type){
			    case '1':
			    	receiver2.hide();
				    receiver1.show();
				    receiver1.validatebox({required:true});
				    receiver_.attr('for','receiver1');
			    break;
			    case '2':
				    receiver1.hide();
				    receiver1.validatebox({required:false});
				    receiver2.show();
				    receiver_.attr('for','receiver2');
			    break;
			    default:
			    break;
			}
			//alert(type);
		}
	</script>
</head>

<body>
	<div id="title">
		<label>基本管理&gt;&gt;发金币</label>
	</div>
	<div id="thisform">
		<s:radio list="#{1:'指定玩家',2:'批量'}" name="type"
			onchange="switchType(this.value)" value="1"></s:radio>
		<form action="do/sendLetter">
			<table class="formTable">
				<tr>
					<td><label for="receiver1" id="receiver_">接收人：</label></td>
					<td><input id="receiver1" name="receiver1"
						data-options="required:true" class="easyui-validatebox" />
					<s:file id="receiver2" name="receiver2" cssStyle="display: none;" /></td>
				</tr>
				<tr>
					<td><label for="gold">金币：</label></td>
					<td><input id="gold" name="gold"
						data-options="min:0,max:1000,precision:0,required:true"
						class="easyui-numberbox" value="10" /></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="发金币" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
