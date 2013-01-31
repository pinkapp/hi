<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>用户管理</title>

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
			$('#tt').datagrid({
				iconCls:'icon-search',
				singleSelect:true,
				idField:'userId',
				pagination:true,
				fitColumns:true,
				height:400,
				toolbar:'#tb',
				url:'gets/manager',
				columns:[[
					{field:'userId',title:'ID',width:10},
					{field:'userName',title:'用户名',width:40},
					{field:'userType',title:'角色',width:40},
					{field:'note',title:'备注',width:40},
					{field:'action',title:'操作',width:20,align:'center',
						formatter:function(value,row,index){
						    if(row.userId != 1){
								var u = '<a href="javascript:void(0);" onclick="edit(this);">修改</a> ';
								var d = '<a href="javascript:void(0);" onclick="remove(this);">删除</a> ';
								return u + d;
							}
						}
					}
				]]
			});
		});
		function query(){
			var param = {};
			var userName = $('#userName').val();
			param.userName = userName;
			$('#tt').datagrid('load',param);
		}
		function getRowIndex(target){
			var tr = $(target).closest('tr.datagrid-row');
			return parseInt(tr.attr('datagrid-row-index'));
		}
		
		function add(){
			$('<div/>').window({
				modal : true,
				title : '添加用户',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/manager_add',
				onClose : function() {
					$(this).window('destroy');
					query();
				}
			});
		}
		function edit(target) {
		    $('#tt').datagrid('selectRow',getRowIndex(target));
		    var row = $('#tt').datagrid('getSelected');
			$('<div/>').window({
				modal : true,
				title : '修改用户',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/manager_edit?userId=' + row.userId,
				onClose : function() {
					$(this).window('destroy');
					query();
				}
			});
		}
		function remove(target){
		    $('#tt').datagrid('selectRow',getRowIndex(target))
		    var row = $('#tt').datagrid('getSelected');
			$.messager.confirm('确认','Are you sure?',function(r){
				if (r){
				    $.ajax({
					    type    :'POST',
					    url     :'do/manager_remove',
					    data    :{userId:row.userId},
					    success :function(result){
					        if(result=='删除成功'){
					        	$('#tt').datagrid('deleteRow', getRowIndex(target));
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
		<label>用户管理</label>
	</div>
	<div id="thisform">
		<fieldset style="width: 400px;">
			<legend>查询条件</legend>
			<label for="userName">用户名：</label><input id="userName" type="text"
				name="userName" value="" tabindex="1">
			<button type="button" onclick="query();">查询</button>
		</fieldset>
	</div>
	<table id="tt"></table>
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