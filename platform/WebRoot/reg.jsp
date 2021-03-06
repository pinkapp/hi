<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>亿网星漫游戏平台-用户注册</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="ywxm,游戏平台">
		<meta http-equiv="description" content="游戏平台">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
		<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
		<script type="text/javascript" src="js/ywxm.js"></script>
		<script type="text/javascript">
	function validator(){
		var chckbox = $("#chckbox").attr("checked");
		if(chckbox!='checked'){
			alert("必须已经看过并同意《亿网星漫用户注册协议》");
			return;
		}
		var a = checkUsername();
		var b = checkPassword();
		var c = checkConfirm();
	    var d = checkRealname();
		var e = checkCardId();
		//var f = checkEmail();
		if(a&&b&&c&&e){
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
	 * 功能：检查密码
	 */
	function checkPassword(){
		var password = $("#password").val();
		if(password == ""){
			$("#password_info").addClass("highLightInfo");
			$("#password_info").html("请输入密码");
			return false;
		}
		var b = check(password,"password");
		if(!b){
			$("#password_info").addClass("highLightInfo");
			$("#password_info").html("密码必须是6-16位数字或字母或下划线组成");
			return false;
		}else{
			$("#password_info").html("OK");
			return true;
		}
	}
	/**
	 * 功能：检查真实姓名
	 */
	function checkRealname(){
		var realname = $("#realname").val();
		if(realname == ""){
			return true;
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
	 * 功能：检查电子邮件
	 */
	function checkEmail(){
		var email = $("#email").val();
		if(email == ""){
			$("#email_info").addClass("highLightInfo");
			$("#email_info").html("请输入邮箱");
			return false;
		}
		var b = check(email,"email");
		if(!b){
			$("#email_info").addClass("highLightInfo");
			$("#email_info").html("无效邮箱");
			return false;
		}else{
			var b = false;
			$.ajax({
				  type: 'POST',
				  url: 'json/checkEmail',
				  data: { email: email },
				  async: false,
				  success: function(data) {
				    if(data.exist){
				    	$("#email_info").addClass("highLightInfo");
				    	$("#email_info").html("邮箱已经存在");
				    	b=false;
				    }else{
				    	$("#email_info").html("OK");
				    	b=true;
				    }
				    
				  }
				});
			}
	        return b;
		}
	/**
	 * 功能：检查身份证号码
	 */
	function checkCardId(){
		var cardId = $("#cardId").val();
		if(cardId == ""){
			return true;
		}
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
	/**
	 * 功能：检查重复密码
	 */
	function checkConfirm(){
		var confirm = $("#confirm").val();
		var password = $("#password").val();
		if(password==""){
			return true;
		}else if(password == confirm){
			$("#confirm_info").html("OK");
			return true;
		}else{
			$("#confirm_info").addClass("highLightInfo");
			$("#confirm_info").html("密码不相同");
			return false;
		}
	}
	/**
	 * 功能：检查用户名
	 */
	function checkUsername(){
		var username = $("#username").val();
		if(username == ""){
			$("#username_info").addClass("highLightInfo");
			$("#username_info").html("请输入用户名");
			return false;
		}
		var b = check(username,"userName");
		if(!b){
			$("#username_info").addClass("highLightInfo");
			$("#username_info").html("用户名必须是2-20位中英文字符、数字或下划线组成");
			return false;
		}else{
			var b = false;
			$.ajax({
				  type: 'POST',
				  url: 'json/checkUsername',
				  data: { username: username },
				  async: false,
				  success: function(data) {
				    if(data.exist){
				    	$("#username_info").addClass("highLightInfo");
				    	$("#username_info").html("用户名已经存在");
				    	b=false;
				    }else{
				    	$("#username_info").html("OK");
				    	b=true;
				    }
				    
				  }
				});
			}
	        return b;
	}
	</script>
	</head>
	<body>
		<div id="page">
			<jsp:include page="WEB-INF/view/commons/header.jsp"></jsp:include>
			<div id="body">
				<div>
					<div class="widget">
						<div class="header">
							<div class="title">
								玩家注册
							</div>
						</div>
						<div class="body">
							<s:form id="myform" action="reg" method="post" namespace="/">
								<table class="formtable">
									<s:label name="message" />
									<tr>
										<td width="120">
											<label class="asterisk">
												*
											</label>
											用户名：
										</td>
										<td width="120">
											<s:textfield id="username" name="username"
												onblur="hiddenInfo('username_info');checkUsername();"
												onfocus="showInfo('username_info','2-20位中英文字符、数字或下划线组成');" />
										</td>
										<td>
											<div id="username_info" class="info usernameInfo"></div>
										</td>
									</tr>
									<tr>
										<td>
											<label class="asterisk">
												*
											</label>
											密码：
										</td>
										<td>
											<s:password id="password" name="password"
												onblur="hiddenInfo('password_info');checkPassword();"
												onfocus="showInfo('password_info','6-16位数字或字母或下划线组成');" />
										</td>
										<td>
											<div id="password_info" class="info passwordInfo"></div>
										</td>
									</tr>
									<tr>
										<td>
											<label class="asterisk">
												*
											</label>
											再次输入密码：
										</td>
										<td>
											<input type="password" id="confirm"
												onblur="hiddenInfo('confirm_info');checkConfirm();"
												onfocus="showInfo('confirm_info','请输入相同的密码');" />
										</td>
										<td>
											<div id="confirm_info" class="info confirmInfo"></div>
										</td>
									</tr>
									<tr>
										<td>
											真实姓名：
										</td>
										<td>
											<s:textfield id="realname" name="realname"
												onblur="hiddenInfo('realname_info');checkRealname();"
												onfocus="showInfo('realname_info','请输入真实姓名');" />
										</td>
										<td>
											<div id="realname_info" class="info realnameInfo"></div>
										</td>
									</tr>
									<tr>
										<td>
											身份证：
										</td>
										<td>
											<s:textfield id="cardId" name="cardId"
												onblur="hiddenInfo('realid_info');checkCardId();"
												onfocus="showInfo('realid_info','请输入15或18位有效身份证');" />
										</td>
										<td>
											<div id="realid_info" class="info realidInfo"></div>
										</td>
									</tr>
									<tr>
										<td>
											邮箱：
										</td>
										<td><!--
											<s:textfield id="email" name="email"
												onblur="hiddenInfo('email_info');checkEmail();"
												onfocus="showInfo('email_info','请输入有效电子邮件地址');" />
											-->
											<s:textfield id="email" name="email"
												onblur="hiddenInfo('email_info');"
												onfocus="showInfo('email_info','请输入有效电子邮件地址');" />
										</td>
										<td>
											<div id="email_info" class="info emailInfo"></div>
										</td>
									</tr>
									<tr>
										<td colspan="3">
										    <button type="button" onclick="validator();">立即注册</button>
											<input type="checkbox" id="chckbox" checked="checked">
											<label style="font-size: 12px;">
												我已经看过并同意
												<a href="#">《亿网星漫用户注册协议》</a>
											</label>
											<s:token />
										</td>
									</tr>
								</table>
							</s:form>
						</div>
					</div>
					<div>
						<label>
							${message }
						</label>
					</div>
				</div>
			</div>
			<jsp:include page="WEB-INF/view/commons/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
