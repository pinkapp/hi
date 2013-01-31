<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>菜单管理</title>

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
			$('#treegrid').treegrid({
				iconCls:'icon-search',
				idField:'id',
				treeField:'text',
				fitColumns:true,
				height:450,
				toolbar:'#tb',
				url:'gets/right',
				columns:[[
					{field:'id',title:'ID',width:10},
					{field:'text',title:'名称',width:40},
					{field:'iconCls',title:'图标',width:40},
					{field:'rlink',title:'链接',width:40},
					{field:'rdesc',title:'描述',width:80},
					{field:'rseq',title:'排序',width:10},
					{field:'action',title:'操作',width:20,align:'center',
						formatter:function(value,row,index){
							var u = '<a href="javascript:void(0);" onclick="edit(this);">修改</a> ';
							var d = '<a href="javascript:void(0);" onclick="remove(this);">删除</a> ';
							return u + d;
						}
					}
				]]
			});
		});
		function query(){
			$('#treegrid').treegrid('reload');
		}
		function getNodeId(target){
			var tr = $(target).closest('tr.datagrid-row');
			return parseInt(tr.attr('node-id'));
		}
		
		function add(){
			$('<div/>').window({
				modal : true,
				title : '添加菜单',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/right_add',
				onClose : function() {
					$(this).window('destroy');
					query();
				}
			});
		}
		function edit(target) {
			$('<div/>').window({
				modal : true,
				title : '修改菜单',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/right_edit?rightId=' + getNodeId(target),
				onClose : function() {
					$(this).window('destroy');
					query();
				}
			});
		}
		function remove(target){
			$.messager.confirm('确认','Are you sure?',function(r){
				if (r){
				    $.ajax({
					    type    :'POST',
					    url     :'do/right_remove',
					    data    :{rightId:getNodeId(target)},
					    success :function(result){
					        if(result=='删除成功'){
					            query();
					        	//$('#treegrid').treegrid('remove', getNodeId(target));
					        }
					    	$.messager.show({
								title:'提示',
								msg:result,
								timeout:2000,
								showType:'slide'
							});
					    },
					    error   :function(error){
					        alert('error');
					    }, 
					    dataType:'html'
						});
				}
			});
		}
	</script>
</head>

<body>
	<div id="title">
		<label>菜单管理</label>
	</div>
	<label>备注：每次修改菜单为了使功能导航菜单生效，请按F5刷新页面</label>
	<table id="treegrid"></table>
	<div id="tb">
		<a href="javascript:void(add());" class="easyui-linkbutton"
			iconCls="icon-add" plain="true">添加</a> <a
			href="javascript:void(query());" class="easyui-linkbutton"
			iconCls="icon-reload" plain="true">刷新</a>
		<!--<a href="#" class="easyui-linkbutton" iconCls="icon-cut" plain="true" onclick="javascript:alert('Cut')">Cut</a>  
    <a href="#" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:alert('Save')">Save</a>  
    -->
	</div>
</body>
</html>
