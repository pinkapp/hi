<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>数据汇总</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>Charts/FusionCharts.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<!--[if IE 6]>
        <script type="text/javascript" src="../assets/ui/js/DD_belatedPNG_0.0.8a-min.js"></script>
        <script>
          /* select the element name, css selector, background etc */
          DD_belatedPNG.fix('img');

          /* string argument can be any CSS selector */
        </script>
		  <p>&nbsp;</p>
		  <P align="center"></P>
        <![endif]-->

  </head>
  
  <body>
    <div class="title1">平台统计 &gt;&gt; 数据汇总</div>
    <div style="padding: 10px;" class="clearfix">
    <s:form namespace="/admin" action="summary">
    <table class="searchtable">
    <tr><th><label>月份：</label></th><td width="120px;"><s:textfield cssClass="Wdate" cssStyle="width: 80px;" name="month" onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM'})"/></td><td align="left"><s:submit value="查询" /><s:label name="message" cssClass="highLightInfo"/></td></tr>
    </table>
    </s:form>
    <table>
        <tr>
	    <td width="50%" valign="top">
	    <s:a namespace="/admin" action="summary_export">导出数据<s:param name="month">${month }</s:param></s:a>
		    <table class="datatable" width="100%">
			   <tr>
			    <th scope="col">日期</th>
			    <th scope="col">日注册用户数</th>
			    <th scope="col">总注册用户数</th>
			    <th scope="col">日登录用户数</th>
			    <th scope="col">日充值货币金额</th>
			    <th scope="col">日充值用户数</th>
			    <th scope="col">日ARPU</th>
			    <th scope="col">日兑换货币金额</th>
			    <th scope="col">日剩余货币金额</th>
			   </tr>
			   <s:iterator value="summaries">
			   <tr>
			     <td>${time }</td>
			     <td>${registerUsersPerday }</td>
			     <td>${registerUsers }</td>
			     <td>${loginUsersPerDay }</td>
			     <td>${rechargeMoneyPerday }</td>
			     <td>${rechargeUsersPerday }</td>
			     <td>${ARPUPerday }</td>
			     <td>${exchangeGameMoneyPerday }</td>
			     <td>${surplusMoney }</td>
			   </tr>
			   </s:iterator>
		    </table>
	    </td>
        </tr>
        </table>
    </div>
  </body>
</html>
