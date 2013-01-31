<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="ff" action="do/right_doAdd" method="post">
	<table class="formtable2">
		<tr>
			<th><label for="rightName">名称</label></th>
			<td><input name="rightName" id="rightName" /></td>
		</tr>
		<tr>
			<th><label for="iconCls">图标</label></th>
			<td><input name="iconCls" id="iconCls" /></td>
		</tr>
		<tr>
			<th><label for="rlink">链接</label></th>
			<td><input name="rlink" id="rlink" /></td>
		</tr>
		<tr>
			<th><label for="rdesc">描述</label></th>
			<td><input name="rdesc" id="rdesc" /></td>
		</tr>
		<tr>
			<th><label for="rseq">排序</label></th>
			<td><input name="rseq" id="rseq" class="easyui-numberspinner"
				data-options="min:0,max:1000" value="10" /></td>
		</tr>
		<tr>
			<th><label for="parentId">上级</label></th>
			<td><input name="parentId" id="parentId"
				class="easyui-combotree" data-options="url:'do/right_gets_'"
				value="0" /></td>
		</tr>
		<tr>
			<th>&nbsp;</th>
			<td><input type="submit" value="提交" /></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$(function(){
	$('#ff').form({
		success:function(data){
			$.messager.show({
								title:'提示',
								msg:data,
								timeout:2000,
								showType:'slide'
							});
		}
	});
});
</script>