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

<title>玩家登录查询</title>

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
			var type = $('input[name="type"]:checked').val();
			var isValid = $('#player').validatebox('isValid');
			if(!isValid){
			    //$('#player').validatebox('validate');
				return;
			}
			var player = $('#player').val();
			var minTime = $('#minTime').datetimebox('getValue');
			var maxTime = $('#maxTime').datetimebox('getValue');
			param.type = type;
			param.player = player;
			param.minTime = minTime;
			param.maxTime = maxTime;
			$('#tab').datagrid({
			    title:'玩家登录记录',
			    queryParams:param,
				singleSelect:true,
				idField:'player',
				pagination:true,
				fitColumns:true,
				toolbar:'#tb',
				height:400,
				url:'gets/loginLog',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				    if(data.total == 0){
				    	$('#info').html('无登录记录');
				    }else{
				    	$('#info').html('共找到' + data.total + '个登录记录');
				    }
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'logId',title:'记录ID',width:10,sortable:true},
					{field:'ipAddress',title:'IP地址',width:25,sortable:true},
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
			window.location.href=encodeURI(encodeURI("export/loginLog?type=" + param.type + "&player=" + param.player + "&minTime=" + param.minTime + "&maxTime=" + param.maxTime));
		}
	</script>
</head>

<body>
	<div id="title">
		<label>玩家管理&gt;&gt;玩家登录查询</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<s:radio list="#{1:'玩家ID',2:'玩家昵称：'}" name="type" value="1" id="type"></s:radio>
			<input id="player" type="text" name="player" value=""
				data-options="required:true" class="easyui-validatebox"> <label
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
