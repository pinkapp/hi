<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
	<head>
		<title>亿网星漫游戏-个人中心</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="ywxm,亿网星漫">
		<meta http-equiv="description" content="亿网星漫">
		<link rel="stylesheet" type="text/css" href="css/styles.css">
	</head>
	<script type="text/javascript">
<!--
function logout(){
  if(confirm('确认要退出？'))window.top.location.href = '<%=basePath%>logout';
}
//-->
</script>
	<body>
		<div id="page">
			<jsp:include page="commons/header.jsp"></jsp:include>
				<div class="widget">
				<div class="header">
					<div class="title">
						个人中心
					</div>
				</div>
				<div class="body clearfix">
					<div class="borderbox" style="float: left;width: 20%;height: 500px;"><jsp:include page="commons/leftcontent.jsp" /></div>
					<div class="borderbox" style="float: right;width: 75%;height: 500px;">
						<!--个人资料-->
						<div class="titleunderline">
							账号信息&gt;&gt;我的资料
						</div>
						<table>
							<tr>
								<td width="30%" valign="top" align="right">
									<s:if test="purl==null||purl==''">
										<img src="images/noavatar_middle.gif" alt="用户头像" title="用户头像" />
									</s:if>
									<s:else>
										<img src="upload/portrait/${purl}" alt="用户头像"
											title="用户头像" />
									</s:else>
								</td>
								<td valign="bottom">
									<h2>
										${username }，欢迎您
									</h2>
									<s:if test="manager==true">
										<s:a namespace="/" action="admin_main">
											进入管理 &gt;&gt;</s:a>&nbsp;&nbsp;&nbsp;&nbsp;</s:if>
									<a href="javascript:logout();" class="primaryColor">注销&gt;&gt;</a>
									<p>
										<span>上次登录:</span>${lasttime}
									</p>
								</td>
							</tr>
						</table>
						<!--安全中心-->
						<!--基本资料-->
						<div class="titleunderline">
							基本资料
						</div>
						<div class="contentbody">
							<table class="infotable">
								<tr>
									<td>
										<label>
											性别：${sex }
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>
											生日：${birth }
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>
											地区：${province }&nbsp;&nbsp;${city }
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>
											职业：${career }
										</label>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<a href="#" class="primaryColor">编辑&gt;&gt;</a>
									</td>
								</tr>
							</table>
						</div>
						<!--防沉迷-->
						<div class="titleunderline">
							防沉迷认证
						</div>
						<div class="contentbody">
							<table>
								<tr>
									<td>
										<label>
											真实姓名：${realname }
										</label>
									</td>
								</tr>
								<tr>
									<td>
										<label>
											身份证：${cid }
										</label>
									</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div id="footer"><jsp:include page="commons/footer.jsp"></jsp:include></div>
		</div>
	</body>
</html>
