<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="ff" action="do/manager_doEdit" method="post">
	<table class="formtable2">
		<tr>
			<th><label for="userName">用户名</label></th>
			<td><input name="userName" id="userName"
				value="${user.userName }" /></td>
		</tr>
		<tr>
			<th><label for="password">密码</label></th>
			<td><input name="password" id="password" type="password"
				value="" /></td>
		</tr>
		<tr>
			<th><label for="userType">角色</label></th>
			<td><input name="userType" id="userType" class="easyui-combobox"
				data-options="valueField:'typeId',textField:'typeName',url:'do/userType_gets'"
				value="${user.userType }" /></td>
		</tr>
		<tr>
			<th valign="top"><label for="note">备注</label></th>
			<td><textarea name="note" id="note">${user.note }</textarea></td>
		</tr>
		<tr>
			<th>&nbsp;<input name="userId" type="hidden"
				value="${user.userId }" /></th>
			<td><input type="submit" value="提交" />[不修改密码请留空]</td>
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