<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<script type="text/javascript">
	function check_all(obj,cName)
	{
		var checkboxs = document.getElementsByName(cName);
		for(var i=0;i<checkboxs.length;i++){checkboxs[i].checked = obj.checked;}
	}
	function save(cName)
	{
	    var arr = new Array();
	    var checkboxs = document.getElementsByName(cName);
		for(var i=0;i<checkboxs.length;i++){
			if(checkboxs[i].checked){
			   arr.push(checkboxs[i].value);
			};
		}
		var myform = document.getElementById("myform");
		myform.action = "admin/role_edit_function?functionIds="+ arr.toString();
		myform.submit();
	}
	/**
	 * 功能：数组中添加contains函数
	 * @return boolean
	 */
	Array.prototype.contains = function (element) { 
	for (var i = 0; i < this.length; i++) { 
		if (this[i] == element) { 
		return true; 
		} 
	} 
	return false; 
	};
	function doChecked(){
	  var checkedFuncs=document.getElementById("checkedFuncs").value;
	  var arr = new Array();
	  if(checkedFuncs != ''){
	     arr = checkedFuncs.split(',');
	  }
	  var checkboxs = document.getElementsByName('c');
	    for(var i=0;i<checkboxs.length;i++){
			if(arr.contains(Number(checkboxs[i].value))){
			    checkboxs[i].checked=true;
			};
		}
	}
	</script>
  </head>
  <body style="margin: 0px;padding: 0px;overflow: auto;" onload="doChecked();">
  <div class="container">
  &nbsp;&nbsp;<input type="checkbox" name="all" onclick="check_all(this,'c')" />全选/全不选
  </div>
  <div class="container">
  <s:form id="myform" action="user_grant" namespace="/admin">
  <s:hidden name="roleId" />
  <s:hidden id="checkedFuncs" name="checkedFuncs" />
  <table class="datatable"> 
  <tr>
    <th scope="col">选择</th>
    <th scope="col">功能</th>
    <th scope="col">分类</th>
  </tr>
	<s:iterator value="functions" status="stat" > 
	<tr> 
	<td> 
	  <input type="checkbox" name="c" value="${functionId }">
	</td> 
	<td> 
	  ${functionname }
	</td> 
	<td> 
	  ${functiontype }
	</td> 
	</s:iterator> 
  </table>
  <input type="button" value="确认" onclick="save('c');" /><s:label name="message" cssClass="highLightInfo"/>
  </s:form> 
  </div>
  </body>
</html>
