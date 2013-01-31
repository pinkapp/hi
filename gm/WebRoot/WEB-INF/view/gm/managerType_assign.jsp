<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<form id="ff" action="do/managerType_doAssign" method="post">
	<table class="formtable2">
		<tr>
			<th><label for="typeName">角色名</label></th>
			<td><label>${userType.typeName }</label></td>
		</tr>
		<tr>
			<th valign="top"><label for="rights">拥有权限</label></th>
			<td><div
					style="border: 1px solid #dadada; height: 200px; overflow: auto">
					<ul id="rightstree"></ul>
				</div></td>
		</tr>
		<tr>
			<th>&nbsp;<input id="typeId" name="typeId" type="hidden"
				value="${userType.typeId }" /><input id="rights" name="rights"
				type="hidden" value="${userType.rights }" /></th>
			<td><input type="submit" value="提交" /></td>
		</tr>
	</table>
</form>
<script type="text/javascript">
$(function(){
	$('#rightstree').tree({
	    checkbox:true,
		url:'gets/right',
        onLoadSuccess: function(err){
            //console.log('数据加载完成');
            var rights = $('#rights').val();
			var checkIds = rights.split(',');
			for(var i in checkIds){ 
			    var node = $('#rightstree').tree('find',checkIds[i]);
			    if(node!=null){
				    var b = $('#rightstree').tree('isLeaf',node.target);
				    if(b)$('#rightstree').tree('check',node.target);
			    }
			}
        }
	});
	
	$('#ff').form({
	    onSubmit:function(){
	    	var nodes = $('#rightstree').tree('getChecked');
	    	var ns = $('#rightstree').tree('getChecked', 'indeterminate');
	    	var ids = new Array();
	    	for(var i in ns){
	    		ids.push(ns[i].id);
	    	}
	    	for(var i in nodes){
	    		ids.push(nodes[i].id);
	    	}
	    	$('#rights').val(ids.toString());
	    	return true;
	    },
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