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

<title>同IP查询</title>

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
		function query(){
			var param = {};
			var qip = $('#qip').val();
			param.qip = qip;
			$('#info').html('');
			$('#tab').datagrid({
			    title:'同IP玩家信息',
			    queryParams:param,
				singleSelect:true,
				fitColumns:true,
				height:400,
				url:'gets/sameIP',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
					$('#info').html('找到' + data.total + '个同IP玩家');
				},
				onLoadError:function(){
				    alert('数据加载错误');
				},
				columns:[[
					{field:'player',title:'玩家ID',width:20},
					{field:'nickname',title:'玩家昵称',width:20},
					{field:'level',title:'等级',width:20},
					{field:'gold',title:'金币',width:20}
				]]
			});
		}
		$(document).keydown(function(event){
		  switch (event.keyCode) {
		    case 13:
		        query();
				break;
			default:
				break;
		   }
		});
	</script>
</head>
<body>
	<div id="title">
		<label>玩家管理&gt;&gt;同IP查询</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<label for="qip">IP地址：</label><input id="qip" type="text" name="qip"
				value="136.56.8.21">&nbsp;&nbsp;
			<button type="button" onclick="query();">查询</button>
			<br />&nbsp;&nbsp;<label id="info" style="color: red;"></label>
		</fieldset>
	</div>
	<table id="tab"></table>
</body>
</html>
