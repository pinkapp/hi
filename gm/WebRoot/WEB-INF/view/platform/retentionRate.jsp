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

<title>玩家留存率</title>

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
<script type="text/javascript" src="Charts/FusionCharts.js"></script>
<script type="text/javascript">
		var param = {};
		function query(){
			var minDate_ = $('#minDate_').val();
			var maxDate_ = $('#maxDate_').val();
			var minDate = $('#minDate').datebox('getValue');
			var maxDate = $('#maxDate').datebox('getValue');
		    $('#info').html('');
			if(minDate < minDate_){
				$('#info').html(' 最小日期不能小于' + minDate);
				return;
			}
			if(maxDate > maxDate_){
				$('#info').html(' 最大日期不能大于' + maxDate);
				return;
			}
			param.minDate = minDate;
			param.maxDate = maxDate;
			$('#tab').datagrid({
			    title:'玩家留存率',
			    queryParams:param,
				singleSelect:true,
				idField:'date',
				fitColumns:true,
				toolbar:'#tb',
				height:400,
				url:'gets/retentionRate',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'date',title:'日期',width:20},
					{field:'count',title:'注册总数',width:20},
					{field:'rate1',title:'次日留存率',width:20},
					{field:'rate3',title:'三日留存率',width:20},
					{field:'rate7',title:'七日留存率',width:20}
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
		function chart() {
			$('<div id="chartdiv"/>').window({
				modal : true,
				title : '图表',
				width : 800,
				height : 400,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				onClose : function() {
					$(this).window('destroy');
				}
			});
			var chart = new FusionCharts("Charts/MSColumn2D.swf", "ChartId", "100%", "100%", "0", "0");
		   	chart.setXMLUrl("chart/retentionRate?minDate=" + param.minDate + "&maxDate=" + param.maxDate);
		   	//chart.setXMLData(XMLData);
		    chart.render("chartdiv");
		}
		function expExcel(){
			window.location.href="export/retentionRate?minDate=" + param.minDate + "&maxDate=" + param.maxDate;
		}
	</script>
</head>
<body>
	<div id="title">
		<label>运营平台&gt;&gt;玩家留存率</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>查询条件</legend>
			<input id="minDate_" type="hidden" value="${minDate }"> <input
				id="maxDate_" type="hidden" value="${maxDate }"> <label
				for="minDate">日期段：</label><input id="minDate" type="text"
				name="minDate" class="easyui-datebox" value="${minDate }">&nbsp;-&nbsp;<input
				id="maxDate" type="text" name="maxDate" class="easyui-datebox"
				value="${maxDate }">&nbsp;&nbsp;
			<button type="button" onclick="query();">查询</button>
			<br />&nbsp;&nbsp;<label id="info" style="color: red;"></label>
		</fieldset>
	</div>
	<table id="tab"></table>
	<div id="tb" style="display: none;">
		<a href="javascript:void(chart());" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">图表</a> <a
			href="javascript:void(expExcel());" class="easyui-linkbutton"
			iconCls="icon-print" plain="true">导出</a>
	</div>
</body>
</html>
