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
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	jQuery(function($){
		var $li = $('.tabbox>ul>li');
		var $div = $('.tabbox').children('div.tabtext');
		$li.children('a').click(function(e){
			e.stopPropagation();
			e.preventDefault();
		});
		$li.mouseover(function(e){
			$(this).parent().children('li').removeClass('hover');
			$(this).addClass('hover');
			var ref = $(this).children('a').attr('href');
			if(ref!=undefined && ref!=''){
				$(ref).parent().children('div.tabtext').hide();
				$(ref).show();
			}
		});
	});
	function isNumber(value){
	   var reg = /^{0-9}+$/;
	   return reg.test(value);
	}
	function calculate(money){
	     var gamecoin = document.getElementById("gamecoin");
	     if(isNaN(money))return false;
	     gamecoin.innerHTML = money * 100;
	}
	function doSubmit(){
		var money = document.getElementById("money").value;
		alert(money);
	}
	function doClick(val){
	    document.getElementById("radio"+val).checked = true;
	}
	</script>
	<style type="text/css">
.tabbox { width:880px;height:auto;margin:20px auto;border:1px #DDD solid;padding:10px;overflow:hidden;zoom:1;}
.tabbox ul { list-style-type:none;width:130px;float:left;position:relative;z-index:20;margin-top:8px;}
.tabbox ul li { display:block;float:none;clear:both;height:26px;line-height:26px;padding:0 15px;position:relative;z-index:21;left:1px;}
.tabbox ul li a { text-decoration:none;}
.tabbox ul li.hover { border:1px #999 solid;border-right:1px #FFF solid;}
.tabbox .tabtext { display:none;width:650px;height:400px;float:left;position:relative;z-index:15;border:1px #999 solid;padding:8px;}
	</style>
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;">个人中心</label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
		<div class="tabbox">
		<ul>
		<li><a href="#d1">支付宝网银充值</a></li>
		<li class="hover"><a href="#d2">财付通网银充值</a></li>
		<li><a href="#d3">支付宝快捷支付</a></li>
		<li><a href="#d4">神州行充值</a></li>
		<li><a href="#d5">电信卡充值</a></li>
		<li><a href="#d6">联通卡充值</a></li>
		<li><a href="#d7">游戏点卡充值</a></li>
		<li><a href="#d8">礼券充值</a></li>
		</ul>
		<div id="d1" class="tabtext">
		<div class="title1"> 支付宝网银充值</div>
		<s:form id="myform" namespace="/order" action="recharge">
		<s:hidden name="step" value="3" />
		<s:hidden name="od.gameId" value="%{game.gameId }" />
		<s:hidden name="od.wayId" value="1" />
		<table border="0" width="100%" cellpadding="0" cellspacing="0">
		<tr>
		<td width="20%">&nbsp;</td><td align="right">&nbsp;</td><td>&nbsp;</td>
		</tr>
		<tr>
		<td>&nbsp;</td><td align="right">充值金额：</td>
		<td><input name="od.ordermoney" id="money" onKeyUp="this.value=this.value.replace(/\D/g,'');calculate(this.value);" onafterpaste="this.value=this.value.replace(/\D/g,'');calculate(this.value);" value="100" >元人民币</td>
		</tr>
		<tr>
		<td>&nbsp;</td><td align="right">游戏币充值数量：</td>
		<td><label id="gamecoin">10000</label>两银子(通用货币)</td>
		</tr>
		<tr>
		<td>&nbsp;</td><td align="right">选择银行：</td><td>&nbsp;</td>
		</tr>
		<tr>
		<td>&nbsp;</td><td align="left" colspan="2">
		<s:iterator value="banks1" status="status">
		<s:if test="#status.count==1">
		<input id="radio${bank_id }" checked="checked" type="radio" name="od.bankId" value="${bank_id }" /><img src="<%=basePath%>images/bank/${banklogo}" onclick="doClick(${bank_id});" >
		</s:if>
		<s:else>
		<input id="radio${bank_id }" type="radio" name="od.bankId" value="${bank_id }" /><img src="<%=basePath%>images/bank/${banklogo}" onclick="doClick(${bank_id});" >
		</s:else>
		<s:if test="#status.count%3==0"><br/></s:if>
		</s:iterator>
		</td>
		</tr>
		<tr>
		<td>&nbsp;</td>
		<td align="center" colspan="2"><s:submit value="提交充值"/></td>
		</tr>
		</table>
		</s:form>
		</div>
		<div id="d2" class="tabtext" style="display:block;">
		内容2
		</div>
		<div id="d3" class="tabtext">
		内容3
		</div>
		<div id="d4" class="tabtext">
		内容4
		</div>
		<div id="d5" class="tabtext">
		内容5
		</div>
		<div id="d6" class="tabtext">
		内容6
		</div>
		<div id="d7" class="tabtext">
		内容7
		</div>
		<div id="d8" class="tabtext">
		内容8
		</div>
		</div>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
