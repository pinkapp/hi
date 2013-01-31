<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>亿网星漫</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;">个人中心</label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1">充值中心&gt;&gt;充值历史</div>
		<s:if test="orders==null">
		您尚未有充值记录.<a href="<%=basePath%>order/recharge" class="primaryColor">马上充值&gt;&gt;</a>  
		</s:if>
		<s:else>
		  <table class="datatable">
		  <tr>
		    <th scope="col">充值时间</th>
		    <th scope="col">金额</th>
		    <th scope="col">支付方式</th>
		    <th scope="col">银行</th>
		    <th scope="col">操作</th>
		  </tr>
		  <s:iterator value="orders">
		  <tr>
		    <td>${ordertime }</td>
		    <td>${ordermoney }</td>
		    <td>${wayname }</td>
		    <td>${bankname }</td>
		    <td><a href="javascript:edit(${order_id })">尚未支付</a>
		    </td>
		  </tr>
		  </s:iterator>
		</table>
		<s:form id="myform" action="history" namespace="/order">
		<jsp:include page="../commons/page.jsp"></jsp:include>
		</s:form>
		</s:else>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
