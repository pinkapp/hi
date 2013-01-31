<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>创建玩家</title>

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
	<div id="title">
		<label>测试工具&gt;&gt;创建玩家</label>
	</div>
	<form id="ff" action="do/createPlayer" method="post">
		<table class="ftable">
			<tr>
				<td><label for="nickname">昵称：</label></td>
				<td><input id="nickname" name="nickname"
					data-options="required:true" class="easyui-validatebox" /></td>
			</tr>
			<tr>
				<td><label for="sex">性别：</label></td>
				<td><s:radio id="sex" name="sex" list="#{0:'女',1:'男'}"
						value="1"></s:radio></td>
			</tr>
			<tr>
				<td>&nbsp;</td>
				<td><input type="submit" value="创建" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
