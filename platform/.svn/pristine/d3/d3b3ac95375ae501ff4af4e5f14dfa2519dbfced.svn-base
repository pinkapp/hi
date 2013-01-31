<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>分页</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function query(){
	   document.getElementById("myform").submit();
	}
	function first(){
	    var currentPage = document.getElementById("currentPage");
	    currentPage.value = 1;
	    query();
	}
	function previous(){
	   var currentPage = document.getElementById("currentPage");
	   if (!isNaN(currentPage.value)){
	    if(Number(currentPage.value) <= 1){
	       alert("已经第一页了");
	       return;
	    }
	    currentPage.value = Number(currentPage.value) - 1;
	   }else{
	    currentPage.value = 1;
	   }
	    query();
	   
	}
	function next(){
	   var currentPage = document.getElementById("currentPage");
	   var totalPage = document.getElementById("totalPage");
	   if (!isNaN(currentPage.value)){
	    if(Number(currentPage.value) >= totalPage.value ){
	       alert("已经最后一页了");
	       return;
	    }
	    currentPage.value = Number(currentPage.value) + 1;
	   }else{
	    currentPage.value = 1;
	   }
	   query();
	}
	function last(){
	    var totalPage = document.getElementById("totalPage");
	    var currentPage = document.getElementById("currentPage");
	    currentPage.value = totalPage.value;
	    query();
	}
	function go(){
	    var currentPage = document.getElementById("currentPage");
	    var totalPage = document.getElementById("totalPage");
	    if (isNaN(currentPage.value)){
	      alert("页数有误");
	      return;
	  	}
	    if(Number(currentPage.value) <= 0){
	      alert("页数必须是正整数");
	      return;
	    };
	    if(Number(currentPage.value) > Number(totalPage.value)){
	      alert("页数大于总页数");
	      return;
	    };
	    query();
	}
	</script>

  </head>
  <body>
<div style="clear: both;">
<input type="hidden" id="totalPage" value="${totalPageCount }" />
<table width="100%"><tr><td align="left">第<label>${pageNo }</label>页，共<label>${totalPageCount }</label>页</td><td align="right"><a onclick="first();">首页</a>&nbsp;&nbsp;<a onclick="previous();">上一页</a>&nbsp;&nbsp;<a onclick="next();">下一页</a>&nbsp;&nbsp;<a onclick="last();">尾页</a>&nbsp;&nbsp;跳转到<input id="currentPage" name="pageNo" value="${pageNo }" type="text" style="width: 40px;" />页&nbsp;&nbsp;<input type="button" value="转到" onclick="go();"> </td></tr></table>
</div>
  </body>
</html>
