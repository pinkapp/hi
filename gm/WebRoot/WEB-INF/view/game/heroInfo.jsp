<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>玩家英雄信息</title>

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
		    var isValid = $('#player').validatebox('isValid');
			if(!isValid){
				return;
			}
			var param = {};
			param.player = $('#player').val();
			$('#tab').datagrid({
			    title:'玩家英雄信息',
			    queryParams:param,
			    singleSelect:true,
				fitColumns:true,
				height:380,
				url:'gets/heroInfo',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
			    	$('#info').html('找到' + data.total + '个英雄');
				},
				onLoadError:function(){
				},
				columns:[[
					{field:'id',title:'英雄ID',width:15},
					{field:'level',title:'英雄等级',width:40},
					{field:'exp',title:'经验',width:40},
					{field:'status',title:'状态',width:40}
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
		<label>数据查询&gt;&gt;玩家英雄信息</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<label for="player">&nbsp;&nbsp;玩家：</label><input id="player"
					name="player" data-options="required:true"
					class="easyui-validatebox" title="玩家ID或昵称" />
			<button type="button" onclick="query();">查询</button>
			<br /> &nbsp;&nbsp;<label id="info" style="color: red;"></label>
		</fieldset>
	<table id="tab"></table>
    </div>
</body>
</html>
