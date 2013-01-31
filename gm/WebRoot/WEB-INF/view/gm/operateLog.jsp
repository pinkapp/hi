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

<title>操作日志</title>

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
	   	var param = {};
		function query(){
			var isValid = $('#username').validatebox('isValid');
			if(!isValid){
				return;
			}
			var username = $('#username').val();
			var minTime = $('#minTime').datetimebox('getValue');
			var maxTime = $('#maxTime').datetimebox('getValue');
			param.username = username;
			param.minTime = minTime;
			param.maxTime = maxTime;
			$('#tab').datagrid({
			    title:'操作日志',
			    queryParams:param,
				singleSelect:true,
				idField:'username',
				pagination:true,
				fitColumns:true,
				toolbar:'#tb',
				height:400,
				url:'gets/operateLog',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				    if(data.total == 0){
				    	$('#info').html('无日志');
				    }else{
				    	$('#info').html('共找到' + data.total + '个日志');
				    }
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'logId',title:'日志ID',width:10,sortable:true},
					{field:'operator',title:'操作者',width:10,sortable:true},
					{field:'ipAddress',title:'IP地址',width:10,sortable:true},
					{field:'info',title:'信息',width:20,sortable:true},
					{field:'logTime',title:'时间',width:10,sortable:true}
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
		function expExcel(){
			window.location.href=encodeURI(encodeURI("export/operateLog?username=" + param.username + "&minTime=" + param.minTime + "&maxTime=" + param.maxTime));
		}
	</script>
</head>

<body>
	<div id="title">
		<label>系统菜单&gt;&gt;操作日志</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<label
				for="username">&nbsp;&nbsp;用户名：</label>
			<input id="username" name="username" data-options="required:true" class="easyui-validatebox" title="玩家ID或昵称" /><label
				for="minTime">&nbsp;&nbsp;时间段：</label><input id="minTime"
				class="easyui-datetimebox" name="minTime" value=""
				style="width: 150px">&nbsp;-&nbsp;<input id="maxTime"
				class="easyui-datetimebox" name="maxTime" value=""
				style="width: 150px"> &nbsp;&nbsp;
			<button type="button" onclick="query();">查询</button>
			<br />&nbsp;&nbsp;<label id="info" style="color: red;"></label>
		</fieldset>
	</div>
	<table id="tab"></table>
	<div id="tb" style="display: none;">
		<a href="javascript:void(expExcel());" class="easyui-linkbutton"
			iconCls="icon-print" plain="true">导出</a>
	</div>
</body>
</html>
