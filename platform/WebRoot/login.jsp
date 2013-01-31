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
		<title>亿网星漫游戏平台-用户登录</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="ywxm,亿网星漫">
		<meta http-equiv="description" content="亿网星漫">
	    <link rel="stylesheet" href="css/login.css">	
	</head>
	<body>
	    <div id="page" >
		<jsp:include page="WEB-INF/view/commons/header.jsp"></jsp:include>
		<div id="content" class="clearfix">
        <!--标准登录框-->
	    <div id="login-box">
		    <form action="login" method="post">
		        <div class="field username-field">
		            <label for="userName">用户名</label>
		            <input type="text" name="username" id="userName" class="login-text" value="" maxlength="32" tabindex="1">            	
		        </div>
				<div class="field">
					<label for="password">密　码</label>
					<input type="password" name="password" id="password" class="login-text" value="" maxlength="20" tabindex="2">
				</div>
				<!--<div class="field">
					<label for="rand">验证码</label>
					<input name="rand" id="rand" class="login-text" tabindex="3">
				</div>
				<div class="field">
					<label for="rand" style="width: 100"></label>
					<img src="rand.action" onclick="changeValidateCode(this)" alt="点击刷新" />
					<script type="text/javascript">
					    function changeValidateCode(obj) {   
					        var currentTime= new Date().getTime();   
					        obj.src = "rand.action?d=" + currentTime;   
					    }   
					</script>
				</div>
		        -->
		        <div class="submit">
		            <input type="hidden" name="action">
		            <input type="submit" class="login-submit" tabindex="5" />
		            <a href="reg.jsp">注册</a>
		            <!--<input type="checkbox"  name="autoLogin" value="true"><label>自动登录</label>-->
		       </div>
		       <div id="message"><s:label name="message" cssClass="highLightInfo" /></div>
		    </form>
		</div>
		<div id="login-bg">
			<div class="pic" style="height: 400px;width: 400px;">
			PICTURE...
            </div>
   		</div>
		</div>
		<jsp:include page="WEB-INF/view/commons/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
