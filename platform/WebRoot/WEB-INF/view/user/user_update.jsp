<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/styles.css">
	<script type="text/javascript" src="<%=basePath%>js/My97DatePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
	/**
	 * 功能：检查用户名
	 */
	function portraitDel(uid){
			$.ajax({
				  type: 'POST',
				  url: 'json/portrait_delete',
				  data: { userId: uid },
				  async: false,
				  success: function(data) {
				    if(data.b){
				    	alert("删除头像成功");
				    	$("#portraitpic").attr("src","<%=basePath%>images/noavatar_middle.gif");
				    	$("#dellink").css("display","none");
				    }else{
				    	alert("删除头像失败");
				    }
				  }
				});
	}
	</script>
  </head>
  <body>
  <div class="title1">账号管理 &gt;&gt; 账号详情</div>
  <s:form id="myform" action="user_edit" namespace="/admin">
  <table class="searchtable" border="0">
  <tr><th><label>头像：</label></th><td>
<s:if test="user.portraitUrl==null||user.portraitUrl==''">
<img src="<%=basePath%>images/noavatar_middle.gif" class="user_avatar" />
</s:if>
<s:else>
<img id="portraitpic" src="<%=basePath%>upload/portrait/${user.portraitUrl}" class="user_avatar" />
<a href="javascript:portraitDel(${user.userId });" id="dellink">删除</a>
<!--<s:a action="portrait_delete" namespace="/admin"><s:param name="userId">${user.userId }</s:param>删除</s:a>
--></s:else>
</td></tr>
  <tr><th><label>UID：</label></th><td><s:hidden name="user.userId" 	/><s:label name="user.userId" /></td></tr>
  <tr><th><label>账号：</label></th><td><s:label name="user.username" /></td></tr>
  <tr><th><label>新密码：</label></th><td><s:password name="password" /></td></tr>
  <tr><th><label>昵称：</label></th><td><s:textfield name="user.nickname" /></td></tr>
  <tr><th><label>性别：</label></th><td><s:radio list="sexs" name="user.sex" listKey="key" listValue="value"/></td></tr>
  <tr><th><label>生日：</label></th><td><s:textfield cssClass="Wdate" name="user.birthday" onFocus="WdatePicker({isShowClear:false,readOnly:true})"/></td></tr>
  <tr><th><label>职业：</label></th><td><s:select list="careers" listKey="id" listValue="careeName" name="user.careerId"/></td></tr>
  <tr><th><label>电子邮件：</label></th><td><s:textfield name="user.email" /></td></tr>
  <tr><th><label>电话：</label></th><td><s:textfield name="user.phone" /></td></tr>
  <tr><th><label>真实姓名：</label></th><td><s:textfield name="user.realname" /></td></tr>
  <tr><th><label>身份证号码：</label></th><td><s:textfield name="user.cardId" /></td></tr>
  <tr><th><label>地区：</label></th><td class="doubleselect"><s:doubleselect name="user.province" list="provinces" listKey="proName" listValue="proName" doubleList="top.cities" doubleName="user.city" doubleListKey="cityName" doubleListValue="cityName" theme="simple"/></td></tr>
  <tr><th><label>注册IP：</label></th><td><s:label name="user.registerIp" /></td></tr>
  <tr><th><label>最后登录IP：</label></th><td><s:label name="user.ip" /></td></tr>
  <tr><th><label>最后登录时间：</label></th><td><s:label name="user.lastTime" /></td></tr>
  <tr><th>&nbsp;</th><td><s:submit value="提交" /><s:a namespace="/admin" action="user_manage">返回</s:a></td></tr>
  <tr><td>&nbsp;</td>
  <td><s:label name="message" cssClass="highLightInfo"/></td></tr>
  </table>
</s:form>
  </body>
</html>
