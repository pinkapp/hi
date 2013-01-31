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
    
    <title>用户充值总额排行</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="<%=basePath%>Charts/FusionCharts.js"></script>
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
    <div class="title1">平台统计 &gt;&gt; 用户充值总排行</div>
    <div style="padding: 10px;">
    <div id="chartdiv" style="float: left;width: 50%;" >正在加载...</div>
    <div style="float: right;width: 50%;">
    <s:a namespace="/admin" action="user_all_chargeRank_export">导出数据</s:a>
    <table class="datatable" width="100%">
   <tr>
    <th scope="col">排行</th>
    <th scope="col">用户</th>
    <th scope="col">充值总额</th>
   </tr>
   <s:iterator value="userChargeRanklist" status="status">
   <tr>
     <td>${rank }</td>
     <td>${username }</td>
     <td>${chargetotal }</td>
   </tr>
   </s:iterator>
    </table>
    </div>
    <input type="hidden" value="${dataString }" id="dataString" />
    </div>
        <script type="text/javascript">
           var chart = new FusionCharts("<%=basePath%>Charts/Bar2D.swf", "ChartId", "560", "400", "0", "0");
		   chart.setXMLData( document.getElementById("dataString").value );
		   chart.render("chartdiv");
		</script>
  </body>
</html>
