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
	var clickfunction = null;
	/**
	 * 功能：延时激活发送按钮 delay 延时时间，单位秒
	 */
	function delayButton(delay) {
		var sendButton = document.getElementById("sendButton");
		if (sendButton.onclick != null) {
			clickfunction = sendButton.onclick;
			sendButton.onclick = null;
		}
		;
		if (delay > 0) {
			sendButton.value = delay + "秒后可重新发送";
			delay--;
			setTimeout("delayButton(" + delay + ")", 1000);
		} else {
			sendButton.onclick = clickfunction;
			sendButton.value = "免费获取验证码";
		}
	}
	/**
	 * 功能：手机发送验证码
	 */
	function sendVerifyCode() {
		var phone = document.getElementById("phone").value;
		if (phone == '') {
			alert("请您先输入手机号码");
			return false;
		}
		var b = check(phone, "phone");
		if (!b) {
			alert("不正确的手机号码");
			return false;
		}
		$.ajax({
			type : 'POST',
			url : 'json/sendMobileVerifyCode',
			data : {
				phone : phone
			},
			async : false,
			success : function(data) {
				alert('验证码已发送到手机');
			}
		});
		delayButton(60);
	}

	function validator() {
		var password = document.getElementById("password").value;
		var confirm = document.getElementById("confirm").value;
		var b = check(password, "password");
		if (!b) {
			alert("密码必须是6-16位数字或字母或下划线组成");
			return false;
		}
		if (password != confirm) {
			alert("密码不相同");
			return false;
		}
		$("#myform").submit();
		return true;
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
	    <div class="title1">帐号信息&gt;&gt;手机绑定</div>
	    <s:if test="phone!=null&&phone!=''">
	    <div style="text-align: center;">
	    <label style="font-size: medium;">您的手机号码${phone }，已绑定</label><s:a namespace="/user" cssStyle="color:blue" action="mobile_update">修改</s:a>
	    </div>
	    </s:if>
	    <s:else>
        <s:form action="mobile_verify" namespace="/user">
        <table class="infotable">
        <tr><td colspan="2"><s:label name="message" cssClass="highLightInfo"/></td></tr>
        <tr><td width="140"><label>输入要绑定的手机号：</label></td><td><s:textfield name="phone" id="phone"/></td></tr>
        <tr><td><label>免费验证码：</label></td><td><input id="sendButton" type="button" value="免费获取验证码" onclick="sendVerifyCode()"/></td></tr>
        <tr><td><label>输入手机验证码：</label></td><td><s:textfield name="phoneVerifyCode" /></td></tr>
        <tr><td></td><td><s:submit value="绑定手机"/></td></tr>
        </table>
        </s:form>
        </s:else>
	   <div class="title2">温馨提示：</div>       
       <p>绑定手机是找回密码，保证账号安全的最重要途径，请您认真填写自己的手机号码，杜绝安全隐患。</p> 
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
