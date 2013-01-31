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
    
    <title>用户支付方式统计</title>
    
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
    <div class="title1">平台统计 &gt;&gt; 用户支付方式统计</div>
    <div style="padding: 10px;" class="clearfix">
    <table>
        <tr>
        <td>
	    	<div id="chartdiv">正在加载...</div>
	    </td>
	    <td>
	        <div id="chartdiv2">正在加载...</div>
	    </td>
        </tr>
        <tr>
        <td valign="top">
	    	<s:a namespace="/admin" action="user_paywayCount_export"><s:param name="part">1</s:param>导出数据</s:a>
		    <table class="datatable" width="100%">
			   <tr>
			    <th scope="col">支付方式</th>
			    <th scope="col">使用次数</th>
			    <th scope="col">百分比</th>
			   </tr>
			   <s:iterator value="userPaywayCounts">
			   <tr>
			     <td>${wayname }</td>
			     <td>${paycount }</td>
			     <td>${percent }</td>
			   </tr>
			   </s:iterator>
		    </table>
	    </td>
	    <td valign="top">
		    <s:a namespace="/admin" action="user_paywayCount_export"><s:param name="part">2</s:param>导出数据</s:a>
		    <table class="datatable" width="100%">
			   <tr>
			    <th scope="col">支付方式</th>
			    <th scope="col">使用次数</th>
			    <th scope="col">百分比</th>
			   </tr>
			   <s:iterator value="userPaybankCounts">
			   <tr>
			     <td>${bankname }</td>
			     <td>${paycount }</td>
			     <td>${percent }</td>
			   </tr>
			   </s:iterator>
		    </table>
	    </td>
        </tr>
    <input type="hidden" value="${dataString }" id="dataString" />
    <input type="hidden" value="${dataString2 }" id="dataString2" />
    </div>
        <script type="text/javascript">
           var chart = new FusionCharts("<%=basePath%>Charts/Pie2D.swf", "ChartId", "560", "400", "0", "0");
		   chart.setXMLData( document.getElementById("dataString").value );
		   chart.render("chartdiv");
           var chart = new FusionCharts("<%=basePath%>Charts/Pie2D.swf", "ChartId", "560", "400", "0", "0");
		   chart.setXMLData( document.getElementById("dataString2").value );
		   chart.render("chartdiv2");
		</script>
  </body>
</html>
