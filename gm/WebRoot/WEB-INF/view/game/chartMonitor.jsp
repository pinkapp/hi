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

<title>实时聊天监控</title>

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
			        return confirm("确定这样做?");
			    },
				success:function(data){
					$.messager.alert('信息', data, 'info');
				}
			});
		});
	</script>
</head>

<body>
	<div id="title">
		<label>聊天管理&gt;&gt;关键词设置</label>
	</div>
	<div id="thisform">
		<fieldset>
			<legend>手动输入</legend>
			<form action="do/keywordsSetting?type=1" method="post">
				<table class="ftable">
					<tr>
						<td valign="top"><label for="player">&nbsp;&nbsp;关键词：</label></td>
						<td><s:textarea name="keywords" title="每个关键词英文逗号分隔"></s:textarea></td>
					</tr>
				</table>
				&nbsp;&nbsp;<input type="submit" value="提交" />

			</form>
		</fieldset>
		<fieldset>
			<legend>文件导入</legend>
			<form action="do/keywordsSetting?type=2" method="post"
				enctype="multipart/form-data">
				<table class="ftable">
					<tr>
						<td><s:file id="datafile" name="data" />&nbsp;&nbsp;</td>
					</tr>
					<tr>
						<td><input name="option" type="radio" checked="checked"
							value="1" /><label>不导入已经存在的词语</label><br />
						<input name="option" type="radio" value="2" /><label>使用新的设置覆盖已经存在的词语</label><br />
						<input name="option" type="radio" value="3" /><label>清空当前词表后导入新词语，此操作不可恢复，建议首先
								<a href="get/keywordsSetting" style="color: blue">导出词表</a>，做好备份。
						</label><br /></td>
					</tr>
				</table>
				&nbsp;&nbsp;<input type="submit" value="提交" /><br /> &nbsp;&nbsp;<label>备注：目前仅支持csv文件扩展名，从第二行开始，每一行第一列代表一个关键词</label>
			</form>
		</fieldset>
	</div>
</body>
</html>
