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
		<base href="<%=basePath%>">
		<title>亿网星漫游戏-客服中心</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="ywxm,亿网星漫">
		<meta http-equiv="description" content="亿网星漫">
		<link rel="stylesheet" type="text/css"
			href="css/styles.css">
	</head>
	<body>
		<div id="page">
			<jsp:include page="commons/header.jsp"></jsp:include>
			<div id="body">
				<div>
					<div class="widget">
						<div class="header">
							<div class="title">
								客服中心
							</div>
						</div>
						<div class="body">
							<s:iterator value="games">
								<div class="order_choose_img">
									<a class="order_choose_img_link" title="${gamename }" href="#"><img
											alt="" src="<%=basePath%>images/${gameLogo}"> </a>
								</div>
							</s:iterator>
						</div>
					</div>
				</div>
			</div>
			<jsp:include page="commons/footer.jsp"></jsp:include>
		</div>
	</body>
</html>
