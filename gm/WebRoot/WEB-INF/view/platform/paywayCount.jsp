<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE>
<html>
<head>
<base href="<%=basePath%>">

<title>支付方式统计</title>
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
	    $(function(){
	    	query();
	    });
	    var XMLData;
	    var XMLData1;
	    var param = {};
		function query(){
			$('#tab').datagrid({
			    title:'按第三方支付平台统计',
				singleSelect:true,
				idField:'date',
				fitColumns:true,
				toolbar:'#tb',
				height:250,
				url:'gets/paywayCount',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'payway',title:'第三方支付平台',width:100},
					{field:'total',title:'支付次数',width:100}
				]]
			});
			
			$.ajax({
				  type: 'POST',
				  url: 'chart/paywayCount',
				  dataType:'json',
				  async: false,
				  success: function(data) {
				  	 XMLData = data;
				  }
			});
			
			$('#tab1').datagrid({
			    title:'按支付银行统计',
				singleSelect:true,
				idField:'date',
				fitColumns:true,
				toolbar:'#tb1',
				height:250,
				url:'gets/paywayCount1',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'payway',title:'支付银行',width:100},
					{field:'total',title:'支付次数',width:100}
				]]
			});
			
			$.ajax({
				  type: 'POST',
				  url: 'chart/paywayCount1',
				  dataType:'json',
				  async: false,
				  success: function(data) {
				  	 XMLData1 = data;
				  }
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
				width : 560,
				height : 400,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				onClose : function() {
					$(this).window('destroy');
				}
			});
			var chart = new FusionCharts("Charts/Pie2D.swf", "ChartId", "100%", "100%", "0", "0");
		   	chart.setXMLData(XMLData);
		    chart.render("chartdiv");
		}
		function expExcel(){
			window.location.href="export/paywayCount";
		}
		function chart1() {
			$('<div id="chartdiv"/>').window({
				modal : true,
				title : '图表',
				width : 560,
				height : 400,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				onClose : function() {
					$(this).window('destroy');
				}
			});
			var chart = new FusionCharts("Charts/Pie2D.swf", "ChartId", "100%", "100%", "0", "0");
		   	chart.setXMLData(XMLData1);
		    chart.render("chartdiv");
		}
		function expExcel1(){
			window.location.href="export/paywayCount1";
		}
	</script>
</head>

<body>
	<div id="title">
		<label>运营平台&gt;&gt;支付方式统计</label>
	</div>
	<table id="tab"></table>
	<div id="tb" style="display: none;">
		<a href="javascript:void(chart());" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">图表</a> <a
			href="javascript:void(expExcel());" class="easyui-linkbutton"
			iconCls="icon-print" plain="true">导出</a>
	</div>
	<table id="tab1"></table>
	<div id="tb1" style="display: none;">
		<a href="javascript:void(chart1());" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">图表</a> <a
			href="javascript:void(expExcel1());" class="easyui-linkbutton"
			iconCls="icon-print" plain="true">导出</a>
	</div>
</body>
</html>
