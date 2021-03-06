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

<title>玩家年龄段统计</title>
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
	    var param = {};
		function query(type){
			$('#tab').datagrid({
			    title:'玩家年龄段统计',
			    queryParams:param,
				singleSelect:true,
				idField:'date',
				fitColumns:true,
				toolbar:'#tb',
				height:400,
				url:'gets/ageGroupCount',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				},
				onLoadError:function(){
				    //alert('数据加载错误');
				},
				columns:[[
					{field:'ageGroup',title:'年龄段',width:100},
					{field:'total',title:'人数',width:100}
				]]
			});
			
			$.ajax({
				  type: 'POST',
				  url: 'chart/ageGroupCount',
				  data: param,
				  dataType:'json',
				  async: false,
				  success: function(data) {
				  	 XMLData = data;
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
				width : 800,
				height : 400,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				onClose : function() {
					$(this).window('destroy');
				}
			});
			var chart = new FusionCharts("Charts/Column2D.swf", "ChartId", "100%", "100%", "0", "0");
		   	chart.setXMLData(XMLData);
		    chart.render("chartdiv");
		}
		function expExcel(){
			window.location.href="export/ageGroupCount";
		}
	</script>
</head>

<body>
	<div id="title">
		<label>运营平台&gt;&gt;玩家年龄段统计</label>
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
