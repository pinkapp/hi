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

<title>玩家充值</title>

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
			    onSubmit:function(){
			        var b = $('form').form('validate');
			        if(b){
			        	return confirm("确定这样做?")
			        }else{
			        	return false;
			        }
			    },
				success:function(data){
					$.messager.alert('信息', data, 'info');
				}
			});
		});
	</script>
</head>

<body>
	<div id="title">
		<label>充值管理&gt;&gt;玩家充值</label>
	</div>
	<div id="thisform">
		<form action="do/playerRecharge" method="post">
			<table class="ftable">
				<tr>
					<td align="right"><label for="player">玩家：</label></td>
					<td><input id="player" name="player"
						data-options="required:true" class="easyui-validatebox"
						title="玩家ID或昵称" /></td>
				</tr>
				<tr>
					<td align="right"><label for="value">充值金额：</label></td>
					<td><input id="value" name="value"
						data-options="min:1,max:1000000,precision:0,required:true"
						class="easyui-numberbox" value="0" /></td>
				</tr>
			</table>
			<input type="submit" value="确定修改" /><br/>
			<label>备注：充值金额最小1，最大100W。</label>
			
		</form>
	</div>
</body>
</html>
