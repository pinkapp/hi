<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>角色管理</title>

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
				idField:'typeId',
				pagination:false,
				fitColumns:true,
				toolbar:'#tb',
				height:450,
				url:'gets/managerType',
				columns:[[
					{field:'typeId',title:'ID',width:10},
					{field:'typeName',title:'角色名',width:40},
					{field:'note',title:'备注',width:40},
					{field:'action',title:'操作',width:20,align:'center',
						formatter:function(value,row,index){
						    if(row.typeId != 1){
								var a = '<a href="javascript:void(0);" onclick="assign(this);">分派权限</a> ';
								var u = '<a href="javascript:void(0);" onclick="edit(this);">修改</a> ';
								var d = '<a href="javascript:void(0);" onclick="remove(this);">删除</a> ';
								return a + u + d;
							}
						}
					}
				]]
			});
		});
		function query(){
			var arr = $('#thisform').serializeArray();
			var param = {};
			$.each(arr, function(index) {
			    if(this['value'] != ''){
					if (param[this['name']]) {
						param[this['name']] = param[this['name']] + "," + this['value'];
					} else {
						param[this['name']] = this['value'];
					}
				}
			});
			$('#tt').datagrid('load',param);
		}
		function getRowIndex(target){
			var tr = $(target).closest('tr.datagrid-row');
			return parseInt(tr.attr('datagrid-row-index'));
		}
		
		function add(){
			$('<div/>').window({
				modal : true,
				title : '添加角色',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/managerType_add',
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
				title : '修改角色',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/managerType_edit?typeId=' + row.typeId,
				onClose : function() {
					$(this).window('destroy');
					query();
				}
			});
		}
		function assign(target) {
		    $('#tt').datagrid('selectRow',getRowIndex(target));
		    var row = $('#tt').datagrid('getSelected');
			$('<div/>').window({
				modal : true,
				title : '分派权限',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/managerType_assign?typeId=' + row.typeId,
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
					    url     :'do/managerType_remove',
					    data    :{typeId:row.typeId},
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
	</script>
</head>
<body>
	<div id="title">
		<label>角色管理</label>
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