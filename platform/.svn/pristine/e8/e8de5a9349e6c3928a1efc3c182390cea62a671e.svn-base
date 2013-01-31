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
	<script type="text/javascript" src="<%=basePath%>js/ywxm.js"></script>
	<script type="text/javascript">
	function binding(){
		var a = checkRealname();
		var b = checkCardId();
		if(a&&b){
			$("#myform").submit();
		}
	}
	/**
	 * 功能：显示提示信息
	 */
	function showInfo(info_id, msg){
		$("#"+info_id).removeClass("highLightInfo");
		$("#"+info_id).html(msg);
	}
	/**
	 * 功能：隐藏提示信息
	 */
	function hiddenInfo(info_id){
		$("#"+info_id).html("");
	}
	/**
	 * 功能：检查真实姓名
	 */
	function checkRealname(){
		var realname = $("#realname").val();
		if(realname == ""){
		    $("#realname_info").addClass("highLightInfo");
			$("#realname_info").html("请输入真实姓名");
			return false;
		}
		var b = check(realname,"realName");
		if(!b){
			$("#realname_info").addClass("highLightInfo");
			$("#realname_info").html("真实姓名必须是中文");
			return false;
		}else{
			$("#realname_info").html("OK");
			return true;
		}
		
	}
	
	/**
	 * 功能：检查身份证号码
	 */
	function checkCardId(){
		var cardId = $("#cardId").val();
		if(cardId == ""){
		    $("#realid_info").addClass("highLightInfo");
			$("#realid_info").html("请输入有效身份证号码");
			return false;
		}
		var cardId = $("#cardId").val();
		// 验证身份证位数
		var b = check(cardId,"cardID");
		if(!b){
			$("#realid_info").addClass("highLightInfo");
			$("#realid_info").html("身份证号码必须是15位或18位");
			return false;
		}
		// 验证身份证合法性
		var b2 = IdentityCodeValid(cardId);
		if(!b2){
			$("#realid_info").addClass("highLightInfo");
			$("#realid_info").html("无效身份证号码");
			return false;
		}else{
			$("#realid_info").html("OK");
			return true;
		}
	}
	</script>
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;">个人中心</label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1">帐号信息&gt;&gt;身份证绑定（防沉迷认证）</div>  
	    <div class="contentbody">
        <s:form id="myform" name="/user" action="cardidauth" method="post">
        <table class="infotable" >
        <tr>
        <s:if test="yetCardId==1">
        <tr><td width="60px;"><label>真实姓名：</label></td>
        <td><s:label name="user.realname"/></td>
        <td>&nbsp;</td>
        </tr>
        <tr><td><label>身份证：</label></td>
        <td><s:label name="user.cardId"/></td>
        <td>&nbsp;</td>
        </tr>
        <tr>
        <td colspan="2"><s:label name="message" cssClass="highLightInfo"/></td>
        </tr>
        </s:if>
        <s:else>
        <s:label name="message" cssClass="highLightInfo"/></tr>
        <tr><td width="60px;"><label>真实姓名：</label></td>
        <td><s:textfield id="realname" name="realname" onblur="hiddenInfo('realname_info');checkRealname();" onfocus="showInfo('realname_info','请输入真实姓名');"/></td>
        <td><div id="realname_info" class="info realnameInfo" ></div></td>
        </tr>
        <tr><td><label>身份证：</label></td>
        <td><s:textfield id="cardId" name="cardId" onblur="hiddenInfo('realid_info');checkCardId();" onfocus="showInfo('realid_info','请输入有效身份证号码');"/></td>
        <td><div id="realid_info" class="info realidInfo" ></div></td>
        </tr>
        <tr>
        <td colspan="2"><input type="button" value="绑定" onclick="binding();" /></td>
        </tr>
        </s:else>
        </table>
        </s:form>
 		<div class="title2">温馨提示：</div>  
		<p>1. 身份证号码可以提高您帐号的安全性。</p>
		<p>2. 身份证号码是作为防沉迷系统判定的唯一标准。 </p>
		<p>3. 保护未成年人身心健康，未满18岁的用户将受到防沉迷系统的限制。 </p>
		<p>4. 在进行游戏的过程中，系统会提示您的累计在线时间: </p>
		<p>&nbsp;&nbsp;累计游戏时间超过 3 小时，游戏收益(经验，金钱)减半。</p>
		<p>&nbsp;&nbsp;累计游戏时间超过 5 小时，游戏收益(经验，金钱)为零。</p>
		</div>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
