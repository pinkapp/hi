<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>玩家建筑信息</title>

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
		function query(type){
			var arr = $('#thisform').serializeArray();
			var param = {};
			if(type == 1){
				var player = $('#player').val();
				param.player = player;
			}else if(type == 2){
				var nickname = $('#nickname').val();
				param.nickname = nickname;
			}else{return};
			$('#tab').datagrid({
			    title:'商业性建筑',
			    queryParams:param,
			    singleSelect:true,
				fitColumns:true,
				height:180,
				url:'gets/buildInfo?type=' + type,
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
			    	$('#info').html('找到' + data.total + '个商业性建筑');
				},
				onLoadError:function(){
				    alert('数据加载错误');
				},
				columns:[[
					{field:'id',title:'建筑ID',width:15},
					{field:'kind',title:'建筑SID',width:20},
					{field:'x',title:'X坐标',width:10},
					{field:'y',title:'Y坐标',width:10},
					{field:'aspect',title:'方向',width:10},
					{field:'warehoused',title:'是否在仓库',width:20},
					{field:'progress',title:'建造进度',width:20},
					{field:'lastReap',title:'最后一次收获时间',width:20}
				]]
			});
			$('#tab2').datagrid({
			    title:'功能性建筑',
			    queryParams:param,
			    singleSelect:true,
				fitColumns:true,
				height:180,
				url:'gets/buildInfo2?type=' + type,
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
			    	$('#info2').html('找到' + data.total + '个功能性建筑');
				},
				onLoadError:function(){
				    alert('数据加载错误');
				},
				columns:[[
					{field:'id',title:'建筑ID',width:15},
					{field:'kind',title:'建筑SID',width:20},
					{field:'x',title:'X坐标',width:10},
					{field:'y',title:'Y坐标',width:10},
					{field:'aspect',title:'方向',width:10},
					{field:'level',title:'建筑等级',width:20},
					{field:'progress',title:'建造进度',width:20},
					{field:'lastReap',title:'最后一次收获时间',width:20}
				]]
			});
		}
	</script>
</head>

<body>
	<div id="title">
		<label>数据查询&gt;&gt;玩家建筑信息</label>
	</div>
	<form id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<label for="player">&nbsp;&nbsp;按玩家ID：</label><input id="player"
				type="text" name="player" value="" data-options="min:1,precision:0"
				class="easyui-numberbox">&nbsp;&nbsp;
			<button type="button" onclick="query(1);">查询</button>
			<br /> <label for="nickname">按玩家昵称：</label><input id="nickname"
				type="text" name="nickname" value="">&nbsp;&nbsp;
			<button type="button" onclick="query(2);">查询</button>
			<br /> &nbsp;&nbsp;<label id="info" style="color: red;"></label><br />
			&nbsp;&nbsp;<label id="info2" style="color: red;"></label>
		</fieldset>
	</form>
	<table id="tab"></table>
	<table id="tab2"></table>
</body>
</html>
