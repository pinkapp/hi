<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>玩家基本信息</title>

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
			var param = {};
			var nickname = $('#nickname').val();
			param.nickname = nickname;
			$('#info').html('');
			$('#tab').datagrid({
			    title:'玩家基本信息',
			    queryParams:param,
				singleSelect:true,
				idField:'player',
				pagination:true,
				fitColumns:true,
				height:400,
				url:'gets/baseInfo',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				    if(data.total == 0){
				    	$('#info').html('无匹配玩家');
				    }else{
				    	$('#info').html('共找到' + data.total + '个匹配玩家');
				    }
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'player',title:'玩家ID',width:15,sortable:true},
					{field:'nickname',title:'玩家昵称',width:25},
					{field:'sex',title:'性别',width:10},
					{field:'level',title:'等级',width:20},
					{field:'exp',title:'经验',width:20},
					{field:'guildId',title:'公会',width:20},
					{field:'gold',title:'金币',width:25,sortable:true},
					{field:'silver',title:'银币',width:25,sortable:true},
					{field:'country',title:'国家',width:20},
					{field:'energy',title:'能量',width:20},
					{field:'prestige',title:'威望',width:20},
					{field:'feat',title:'功绩',width:20},
					{field:'mobility',title:'行动力',width:20},
					{field:'rechargedGold',title:'充值金币',width:20},
					{field:'progress',title:'主线节点',width:20}
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
		<label>数据查询&gt;&gt;玩家基本信息</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<label for="nickname">玩家昵称：</label><input id="nickname" type="text"
				name="nickname" value="">&nbsp;&nbsp;
			<button type="button" onclick="query();">模糊查询</button>
			<label>&nbsp;&nbsp;注:要查询所有玩家，玩家昵称请留空</label><br />&nbsp;&nbsp;<label
				id="info" style="color: red;"></label>
		</fieldset>
	</div>
	<table id="tab"></table>
</body>
</html>
