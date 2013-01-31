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
	<link rel="stylesheet" type="text/css" href="<%=basePath%>imgareaselect/css/imgareaselect-animated.css">
	<SCRIPT type=text/javascript src="<%=basePath %>imgareaselect/scripts/jquery.min.js"></SCRIPT>
    <SCRIPT type=text/javascript src="<%=basePath %>imgareaselect/scripts/jquery.imgareaselect.pack.js"></SCRIPT>
	<SCRIPT type=text/javascript>
function preview(img, selection) {
    if (!selection.width || !selection.height)
        return;
    
    var scaleX = 100 / selection.width;
    var scaleY = 100 / selection.height;

    $('#preview img').css({
        width: Math.round(scaleX * 300),
        height: Math.round(scaleY * 300),
        marginLeft: -Math.round(scaleX * selection.x1),
        marginTop: -Math.round(scaleY * selection.y1)
    });

    $('#x1').val(selection.x1);
    $('#y1').val(selection.y1);
    $('#x2').val(selection.x2);
    $('#y2').val(selection.y2);
    $('#w').val(selection.width);
    $('#h').val(selection.height);    
}

$(function () {
    $('#photo').imgAreaSelect({ aspectRatio: '1:1', handles: true,
        fadeSpeed: 200, onSelectChange: preview });
});
</SCRIPT>
<script type="text/javascript">
function save(){
		if($('#x1').val()==''){
		  alert("亲，请拖动照片以裁剪满意的头像");
		}else{
			$("#myform").submit();
		}
	}
</script>
	
  </head>
  <body>
<div id="container">
  <div id="header"><jsp:include page="../commons/header.jsp"></jsp:include></div>
  <div id="menu"><label style="font-size: 18px;font-weight: bold;padding-left: 30px;"><s:text name="user_edit_portrait.personcenter"/></label></div>
  <div id="mainContent">
    <div id="sidebar"><jsp:include page="../commons/leftcontent.jsp" /></div>
    <div id="content">
	    <div class="title1"><s:text name="user_edit_portrait.userinfo"/>&gt;&gt;<s:text name="user_edit_portrait.editportrait"/></div>
		<div class="body clearfix">
		<div style="width: 64%; float: left;">
		<s:if test="imageFileName==null">
		<div class="linetitle"><b><s:text name="user_edit_portrait.currentportrait"/></b></div>
		<div class="frame" style="margin: 0px 1em; width: 100px; height: 100px;" >
		<DIV>
		<s:if test="user.portraitUrl==null||user.portraitUrl==''">
		<IMG src="<%=basePath %>images/noavatar_middle.gif" style="width: 100px; height: 100px;" />
		</s:if>
		<s:else>
		<IMG src="<%=basePath %>upload/portrait/${user.portraitUrl}" style="width: 100px; height: 100px;" />
		</s:else>
		</DIV>
		</div>
		</s:if>
		<!-- 图片上传后 -->
		<s:else>
		<div class="linetitle"><b><s:text name="user_edit_portrait.cutpicture"/></b></div>
		<div class="tooltip"><s:text name="user_edit_portrait.tooltip2"/></div>
		<div class="frame" style="float: left; margin: 0px 0.3em; width: 300px; height: 300px;">
		<IMG id=photo src="<%=basePath %>upload/tmp/${imageFileName}" complete="complete" unselectable="on" jQuery16104489641878836478="2" style="height: 300px;width: 300px"> 
		</div>
		<div class="frame" style="float: left; margin: 0px 1em; width: 100px; height: 100px;">
		<DIV style="WIDTH: 100px; HEIGHT: 100px; OVERFLOW: hidden" id=preview>
		<IMG style="MARGIN-TOP: -55px; WIDTH: 207px; HEIGHT: 207px; MARGIN-LEFT: -44px" src="<%=basePath %>upload/tmp/${imageFileName}" complete="complete"/>
		</DIV>
		</div>
		<div style="margin: 0px 0.3em;padding-top: 0.3em;clear: both;">
		<s:form id="myform" action="cut" method="post" namespace="/portrait">
		<s:hidden id="x1" name="x1" />
		<s:hidden id="y1" name="y1"/>
		<s:hidden id="x2" name="x2"/>
		<s:hidden id="y2" name="y2"/>
		<s:hidden id="w" name="w"/>
		<s:hidden id="h" name="h"/>
		<s:hidden name="imageFileName"/>
		<input type="button" value='<s:text name="user_edit_portrait.save"/>' onclick="save();" />
		</s:form>
		</div>
		</s:else>
		</div>
		<div style="width: 30%; float: left; margin-left:20px;">
		<div class="linetitle"><b><s:text name="user_edit_portrait.replaceportrait"/></b></div>
		<div class="tooltip"><s:text name="user_edit_portrait.tooltip"/></div>
		<div>
		<s:form action="selectUpload" method="post" namespace="/portrait" enctype="multipart/form-data">
		<s:file name="image" accept="image/*" />
		<s:submit key="user_edit_portrait.upload"/><br/>
		<s:label name="message" cssClass="highLightInfo"/>
		</s:form>
		</div>
		</div>
    </div>
  </div>
  <div id="footer"><jsp:include page="../commons/footer.jsp"></jsp:include></div>
</div>
  </body>
</html>
