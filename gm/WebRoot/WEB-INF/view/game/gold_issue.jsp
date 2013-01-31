<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>踢人</title>

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
			$('#ff').form({
				success:function(data){
					$.messager.alert('信息', data, 'info');
				}
			});
		});
	</script>
</head>

<body>
	<form id="ff" action="do/doKick" method="post">
		<table class="formtable">
			<tr>
				<td><label for="player">玩家ID</label></td>
				<td><input name="player" data-options="min:0,precision:0"
					class="easyui-numberbox" value="0" /></td>
			</tr>
			<tr>
				<td><label for="gold">金币</label></td>
				<td><input name="gold" data-options="min:0,precision:0"
					class="easyui-numberbox" value="0" /></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="发放" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
