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

<title>修改服务器时间</title>

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
		<label>测试工具&gt;&gt;修改服务器时间</label>
	</div>
	<div id="thisform">
		<form action="do/baseInfoEdit" method="post">
			<table class="ftable">
				<tr>
					<td align="right"><label for="player">当前服务器时间：</label></td>
					<td><input id="player" name="player"
						data-options="required:true" class="easyui-datetimebox"
						title="点击修改" value="${time}" style="width: 150px"/></td>
				</tr>
			</table>
			<input type="submit" value="确定修改" /><br/>
		</form>
	</div>
</body>
</html>
