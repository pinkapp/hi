<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cc.ywxm.constant.Const"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%

String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>英雄领域游戏后台</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<link id="easyuiTheme" class="aa" rel="stylesheet" type="text/css"
	href="./easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="./easyUI/themes/icon.css">
<script type="text/javascript" src="./easyUI/jquery-1.8.0.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./easyUI/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="./easyUI/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/jquery.cookie.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/syUtil.js" charset="utf-8"></script>
<!--<script type="text/javascript">
		function changeDB(datasource){
			$.ajax({
				url:'do/chdbsrv',
				data:{'dbsrv':datasource},
				success:function(data){
				    window.location.reload();
					//alert(data);
				}
			});
		}
	</script>
	-->
<style type="text/css">
* {
	padding: 0;
	margin: 0
}
</style>
</head>

<body class="easyui-layout">
	<!-- 北-start -->
	<div data-options="region:'north',border:false"
		style="height: 60px; padding: 10px">
		<h1>英雄领域游戏后台</h1>
		<div id="sessionInfoDiv"
			style="position: absolute; right: 5px; top: 10px;">
			[<strong>${userName }</strong>]，欢迎你！您正在使用IP[<strong>${ipAddress
				}</strong>]登录<label style="color: red;"> [当前服务器:<%=request.getServerName() %>]
			</label>
		</div>
		<div style="position: absolute; right: 0px; bottom: 0px;">
			<a href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_dbMenu" iconCls="icon-ok">更换服务器</a> <a
				href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_pfMenu" iconCls="icon-ok">更换皮肤</a> <a
				href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_kzmbMenu" iconCls="icon-help">控制面板</a> <a
				href="javascript:void(0);" class="easyui-menubutton"
				menu="#layout_north_zxMenu" iconCls="icon-back">注销</a>
		</div>
		<div id="layout_north_dbMenu" style="width: 120px; display: none;">
			<s:iterator value="servers">
				<div onclick="changeDB('${id}');">${name}</div>
			</s:iterator>
		</div>
		<div id="layout_north_pfMenu" style="width: 120px; display: none;">
			<div onclick="sy.changeTheme('default');">default</div>
			<div onclick="sy.changeTheme('gray');">gray</div>
			<div onclick="sy.changeTheme('metro');">metro</div>
		</div>
		<div id="layout_north_kzmbMenu" style="width: 100px; display: none;">
			<div onclick="showUserInfo();">个人信息</div>
			<div class="menu-sep"></div>
			<div>
				<span>更换主题</span>
				<div style="width: 120px;">
					<div onclick="sy.changeTheme('default');">default</div>
					<div onclick="sy.changeTheme('gray');">gray</div>
					<div onclick="sy.changeTheme('metro');">metro</div>
				</div>
			</div>
		</div>
		<div id="layout_north_zxMenu" style="width: 100px; display: none;">
			<div onclick="logout(true);">锁定窗口</div>
			<div class="menu-sep"></div>
			<div onclick="logout(true);">注销用户</div>
		</div>
		<script type="text/javascript" charset="utf-8">
		function logout(b) {
			$.post('do/logout', function() {
			    location.replace('');
			});
		}
	
		function showUserInfo() {
			$('<div/>').window({
				modal : true,
				title : '用户信息',
				width : 350,
				height : 300,
				collapsible : false,
				minimizable : false,
				maximizable : false,
				href : 'mods/managerInfo',
				onClose : function() {
					$(this).window('destroy');
				}
			});
		}
		</script>
	</div>
	<!-- 北-end -->
	<!-- 西-start -->
	<div data-options="region:'west',split:true,title:''"
		style="width: 200px; padding: 0px;">
		<div class="easyui-accordion" style="padding: 0; margin: 0;"
			border="false">
			<div title="功能导航" data-options="selected:true"
				style="overflow: auto; padding: 10px;">
				<ul id="menu-tree"></ul>
				<script type="text/javascript" charset="utf-8">
					$(function()
					{
					  $('#menu-tree').tree(
					  {
					    url:'gets/managerType_right',
						onSelect: function(node)
						{  
						  if(node.attributes.rlink != '')
						  {
						    //$('#ss').panel({'title' : 'Online Charge Syste >>' + node.text});
				            $('#center').attr('src', node.attributes.rlink); 
				            $('#center').load(function(){
				            	var themeName = $.cookie('easyuiThemeName');//设置主题
				            	var $easyuiTheme = $('#center').contents().find('#easyuiTheme');
								if(themeName){
									var url = $easyuiTheme.attr('href');
									var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
									$easyuiTheme.attr('href', href);
								}
				            });
				          }			
				        },
				        onLoadError: function(err){
				          //alert('数据加载错误');
				        }
				      });
					});
				</script>
			</div>
			<s:if test="userType==1">
				<div title="系统菜单" style="padding: 10px;">
					<ul id="sysmenu-tree"></ul>
					<script type="text/javascript" charset="utf-8">
		        	var data = [{'id':1,'text':'用户管理',attributes:{'rlink':'mods/manager'}},
		        				{'id':2,'text':'角色管理',attributes:{'rlink':'mods/managerType'}},
		        				{'id':3,'text':'菜单管理',attributes:{'rlink':'mods/right'}},
		        				{'id':4,'text':'操作日志',attributes:{'rlink':'mods/operateLog'}},
		        				{'id':5,'text':'系统配置',attributes:{'rlink':''}}];
					$(function()
					{
					  $('#sysmenu-tree').tree(
					  {
					    data:data,
						onSelect: function(node)
						{  
						  if(node.attributes.rlink != '')
						  {
				            $('#center').attr('src', node.attributes.rlink); 
				            $('#center').load(function(){
				            	var themeName = $.cookie('easyuiThemeName');//设置主题
				            	var $easyuiTheme = $('#center').contents().find('#easyuiTheme');
								if(themeName){
									var url = $easyuiTheme.attr('href');
									var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
									$easyuiTheme.attr('href', href);
								}
				            });
				          }			
				        }
				      });
					});
				</script>
				</div>
			</s:if>
		</div>
	</div>
	<!-- 西-end -->
	<!-- 东-start -->
	<!--<div data-options="region:'east',split:true,title:'日历'" style="width:180px;">
		<div class="easyui-layout" fit="true" border="false">
			<div region="north" border="false" style="height:180px;overflow: hidden;">
				<div id="calendar"></div>
			</div>
			<div region="center" border="false" style="overflow: hidden;">
				<div id="onlinePanel" fit="true" border="false" title="用户在线列表">
					<table id="onlineDatagrid"></table>
				</div>
			</div>
			<div id="userOnlineInfoDialog" style="display: none;width: 250px;height: 130px;">
				<table id="userOnlineInfoDataGrid"></table>
			</div>
		</div>
		<script type="text/javascript" charset="utf-8">
		$('#calendar').calendar(
	      {
	      	current:new Date(),
	      	border:false
	      });
		</script>
	</div>
	-->
	<!-- 东-end -->
	<!-- 南-start -->
	<div data-options="region:'south',border:false"
		style="height: 50px; padding: 10px;">
		<span style="position: absolute; right: 50px; top: 10px;">&#169;
			2012 亿网星漫（软件）公司 版权所有</span>
	</div>
	<!-- 南-end -->
	<!-- 中-start -->
	<div data-options="region:'center',title:'工作台'"
		style="overflow: hidden">
		<iframe id="center" scrolling="auto" frameborder="0"
			style="width: 100%; height: 100%"></iframe>
	</div>
	<!-- 中-end -->
</body>
</html>
