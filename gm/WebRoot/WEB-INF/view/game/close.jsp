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

<title>封账号</title>

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
			$('form').form({
			    onSubmit:function(){
			        if(this.id == "type1"){
				     	var b = $('#type1').form('validate');
				        if(b){
				        	return confirm("确定这样做?")
				        }else{
				        	return false;
				        }
			        } else if(this.id == "type2"){
				     	var b = $('#type2').form('validate');
				        if(b){
				        	return confirm("确定这样做?")
				        }else{
				        	return false;
				        }
			        }else{
			        	return confirm("确定这样做?");
			        }
			    },
				success:function(data){
					$.messager.alert('信息', data, 'info');
				}
			});
		});
		function query(type){
			var param = {};
			var player = $('#player').val();
			var nickname = $('#nickname').val();
			param.player = player;
			param.nickname = nickname;
			$('#info').html('');
			$('#tab').datagrid({
			    title:'封号记录',
			    queryParams:param,
				singleSelect:true,
				idField:'player',
				pagination:true,
				fitColumns:true,
				height:400,
				url:'gets/close',
				loadMsg:'正在查询...',
				onLoadSuccess:function(data){
				    if(data.total == 0){
				    	$('#info').html('无记录');
				    }else{
				    	$('#info').html('共找到' + data.total + '条记录');
				    }
				},
				onLoadError:function(){
				    alert('数据加载错误');
				},
				columns:[[
					{field:'player',title:'玩家ID',width:15,sortable:true},
					{field:'nickname',title:'玩家昵称',width:25},
					{field:'sex',title:'原因',width:10},
					{field:'level',title:'截止时间',width:20}
				]]
			});
		}
	</script>
</head>

<body>
	<div id="title">
		<label>基本管理&gt;&gt;封账号</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>永久</legend>
			<form action="do/close?type=1" method="post" id="type1">
				<table class="ftable">
					<tr>
						<td align="right"><label for="player">&nbsp;&nbsp;&nbsp;玩家：</label></td>
						<td><input id="player" name="player"
							data-options="required:true" class="easyui-validatebox"
							title="玩家ID或昵称" /></td>
					</tr>
					<tr>
						<td align="right" valign="top"><label for="reason">封号原因：</label></td>
						<td><s:textarea id="reason" name="reason" /></td>
					</tr>
				</table>
				&nbsp;&nbsp;<input type="submit" value="确定" />
			</form>
		</fieldset>
		<fieldset>
			<legend>指定时间</legend>
			<form action="do/close?type=2" method="post" id="type2">
				<table class="ftable">
					<tr>
						<td align="right"><label for="player">&nbsp;&nbsp;&nbsp;玩家：</label></td>
						<td><input id="player" name="player"
							data-options="required:true" class="easyui-validatebox"
							title="玩家ID或昵称" /></td>
					</tr>
					<tr>
						<td align="right"><label for="enddate">截止日期：</label></td>
						<td><input id="enddate" name="enddate"
							data-options="required:true" class="easyui-datebox" /></td>
					</tr>
					<tr>
						<td align="right" valign="top"><label for="reason">封号原因：</label></td>
						<td><s:textarea id="reason" name="reason" /></td>
					</tr>
				</table>
				&nbsp;&nbsp;<input type="submit" value="确定" />
			</form>
		</fieldset>
		<fieldset>
			<legend>记录查询</legend>
			<label for="player">&nbsp;&nbsp;&nbsp;玩家：</label><input id="player"
				name="player" data-options="required:true"
				class="easyui-validatebox" title="玩家ID或昵称" />&nbsp;&nbsp;
			<button type="button" onclick="query(1);">查询</button>
			<br /> &nbsp;&nbsp;<label id="info" style="color: red;"></label>
			<table id="tab"></table>
		</fieldset>
	</div>
</body>
</html>
