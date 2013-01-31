<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">
		<title>亿网星漫游戏-找回密码</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="ywxm,亿网星漫">
		<meta http-equiv="description" content="亿网星漫">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/ywxm.js"></script>
		<script type="text/javascript">
		/**
		 * 功能：邮件发送验证码
		 */
		function sendVerifyCodeByEmail(){
		var email = document.getElementById("email").value;
		var username = document.getElementById("username").value;
		$.ajax({
		  type: 'POST',
		  url: 'json/sendVerifyCode',
		  data: { findway:0, email: email, username: username },
		  async: false,
		  success: function(data) {
		  alert('验证码已发送到安全邮箱');
		  }
		});
		delayButton(60);
		}
		var clickfunction = null;
		/**
		 * 功能：延时激活发送按钮 delay 延时时间，单位秒
		 */
		function delayButton(delay) {  
		    var sendButton = document.getElementById("sendButton");  
		    if(sendButton.onclick != null){
		        clickfunction = sendButton.onclick;
		    	sendButton.onclick = null;
		    };          
			if(delay > 0) {
			sendButton.value = delay + "秒后可重新发送";
			delay--;
			setTimeout("delayButton(" + delay + ")", 1000);
			}else{
			sendButton.onclick = clickfunction;
			sendButton.value="免费获取验证码";
			} 
		}
		/**
		 * 功能：手机发送验证码
		 */
		function sendVerifyCodeByPhone(){
		var phone = document.getElementById("phone").value;
		var username = document.getElementById("username").value;
		$.ajax({
		  type: 'POST',
		  url: 'json/sendVerifyCode',
		  data: { findway: 1, phone: phone, username: username },
		  async: false,
		  success: function(data) {
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
			if(password!=confirm){
				alert("密码不相同");
				return false;
			}
			$("#myform").submit();
			return true;
		}
</script>
	</head>
	<body>
		<div id="page">
			<jsp:include page="WEB-INF/view/commons/header.jsp"></jsp:include>
			<div id="body">
				<table height="100%" width="100%" cellpadding="0" cellspacing="0"
					border="0">
					<tr>
						<td align="center">
							<s:label name="message" cssClass="highLightInfo" />
							<s:form namespace="/" action="ftpasswd" id="myform">
								<s:if test="step<=1">
									<s:hidden name="step" value="2" />
									<p>
										<label style="font-size: medium; font-weight: bold;">
											请输入您的用户名
										</label>
									</p>
									<p>
										<s:textfield name="username" />
									</p>
									<p>
										<s:submit value="下一步" />
									</p>
								</s:if>
								<s:if test="step==2">
									<s:hidden name="username" />
									<s:hidden name="step" value="3" />
									<p>
										<label style="font-size: medium; font-weight: bold;">
											请选择找回密码的方式
										</label>
									</p>
									<p>
										<s:radio name="findway" list="#{0:'邮箱找回密码',1:'手机找回密码'}"
											value="0"></s:radio>
									</p>
									<p>
										<input type="button" value="上一步"
											onclick="window.location.href='ftpasswd?step=1'" />
										<s:submit value="下一步" />
									</p>
								</s:if>
								<s:if test="step==3">
									<s:hidden name="username" id="username" />
									<s:hidden name="email" id="email" />
									<s:hidden name="phone" id="phone" />
									<s:hidden name="step" value="4" />
									<s:hidden name="findway" />
									<s:if test="findway==0">
										<p>
											<label style="font-size: medium; font-weight: bold;">
												请获取验证码进行验证
											</label>
										</p>
										<p>
											<label>
												您的安全邮箱：${email }
											</label>
										</p>
										<p>
											<input id="sendButton" type="button" value="免费获取验证码"
												onclick="sendVerifyCodeByEmail()" />
										</p>
										<p>
											验证码
											<s:textfield name="verifyCode" />
										</p>
										<p>
											<input type="button" value="上一步"
												onclick="window.location.href='ftpasswd?step=2&username=${username }'" />
											<s:submit value="下一步" />
										</p>
									</s:if>
									<s:if test="findway==1">
										<p>
											<label style="font-size: medium; font-weight: bold;">
												请获取验证码进行验证
											</label>
										</p>
										<p>
											<label>
												您的安全手机：${phone }
											</label>
										</p>
										<p>
											<input id="sendButton" type="button" value="免费获取验证码"
												onclick="sendVerifyCodeByPhone()" />
										</p>
										<p>
											验证码
											<s:textfield name="verifyCode" />
										</p>
										<p>
											<input type="button" value="上一步"
												onclick="window.location.href='ftpasswd?step=2&username=${username }'" />
											<s:submit value="下一步" />
										</p>
									</s:if>
								</s:if>
								<s:if test="step==4">
									<s:hidden name="username" />
									<s:hidden name="step" value="5" />
									<p>
										<label style="font-size: medium; font-weight: bold;">
											请输入您的新密码
										</label>
									</p>
									<p>
										<label>
											新密码
										</label>
										<s:password name="password" id="password" />
									</p>
									<p>
										<label>
											确认密码
										</label>
										<s:password id="confirm" />
									</p>
									<p>
										<input type="button" value="下一步" onclick="validator();" />
									</p>
								</s:if>
								<s:if test="step==5">
									<p>
										<label
											style="font-size: medium; font-weight: bold; color: red;">
											恭喜！您的密码已经重置
										</label>
									</p>
								</s:if>
							</s:form>
						</td>
					</tr>
				</table>

			</div>
			<div id="footer"><jsp:include
					page="WEB-INF/view/commons/footer.jsp"></jsp:include>
			</div>
		</div>
	</body>
</html>
