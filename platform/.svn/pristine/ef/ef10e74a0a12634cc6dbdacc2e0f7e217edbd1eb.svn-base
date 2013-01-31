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
    
    <title>每日登录用户统计</title>
    
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
    <div class="title1">平台统计 &gt;&gt; 每日登录用户统计</div>
    <s:form namespace="/admin" action="user_dailyUserloginUserCount">
    <table class="searchtable">
    <tr><th><label>月份：</label></th><td width="120px;"><s:textfield cssClass="Wdate" cssStyle="width: 80px;" name="month" onFocus="WdatePicker({isShowClear:false,readOnly:true,dateFmt:'yyyy-MM'})"/></td><td align="left"><s:submit value="查询" /></td></tr>
    </table>
    </s:form>
    <div style="padding: 10px;">
    <div id="chartdiv">正在加载...</div>
    <div>
    <s:a namespace="/admin" action="user_dailyUserloginUserCount_export"><s:param name="month">${month }</s:param>导出数据</s:a>
    <table class="datatable" width="100%">
   <tr>
    <th scope="col">登录日期</th>
    <th scope="col">登录用户数</th>
   </tr>
   <s:iterator value="dailyUserloginUserCounts">
   <tr>
     <td>${logintime }</td>
     <td>${usercount }</td>
   </tr>
   </s:iterator>
   
    </table>
    </div>
    <input type="hidden" value="${dataString }" id="dataString" />
    </div>
        <script type="text/javascript">
            //if (GALLERY_RENDERER && GALLERY_RENDERER.search(/javascript|flash/i)==0) 
            //FusionCharts.setCurrentRenderer('javascript'); 
            //alert(document.getElementById("sss").value);
            var chart = new FusionCharts("<%=basePath%>Charts/Line.swf", "ChartId", "100%", "400", "0", "0");
		   chart.setXMLData( document.getElementById("dataString").value );
		   chart.render("chartdiv");
		</script>
  </body>
</html>
