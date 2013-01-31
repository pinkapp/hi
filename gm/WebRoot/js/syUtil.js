/**
 * 包含easyui的扩展和常用的方法
 * 
 * @author 孙宇
 * 
 * @version 20120907
 */

var sy = $.extend({}, sy);/* 定义全局对象，类似于命名空间或包的作用 */

/**
 * 
 * 取消easyui默认开启的parser
 * 
 * 在页面加载之前，先开启一个进度条
 * 
 * 然后在页面所有easyui组件渲染完毕后，关闭进度条
 * 
 * @author 孙宇
 * 
 * @requires jQuery,EasyUI
 * 
 */
$.parser.auto = false;
$(function() {
	$.messager.progress({
		text : '页面加载中....',
		interval : 100
	});
	$.parser.parse(window.document);
	window.setTimeout(function() {
		$.messager.progress('close');
		if (self != parent) {
			window.setTimeout(function() {
				try {
					parent.$.messager.progress('close');
				} catch (e) {
				}
			}, 500);
		}
	}, 1);
	$.parser.auto = true;
	var themeName = $.cookie('easyuiThemeName');//设置主题
	if(themeName){
		sy.changeTheme(themeName);
	}
});

/**
 * @author 黄德财
 * 
 * @requires jQuery,EasyUI,jQuery cookie plugin
 * 
 * 更换EasyUI主题的方法
 * 
 * @param themeName
 *            主题名称
 */
sy.changeTheme = function(themeName) {
	var $easyuiTheme = $('#easyuiTheme');
	//var $easyuiTheme1 = $('iframe').contents().find("#easyuiTheme");
	var url = $easyuiTheme.attr('href');
	var href = url.substring(0, url.indexOf('themes')) + 'themes/' + themeName + '/easyui.css';
	$easyuiTheme.attr('href', href);
	//$easyuiTheme1.attr('href', href);
	var $iframe = $('iframe');
	if ($iframe.length > 0) {
		for ( var i = 0; i < $iframe.length; i++) {
			var ifr = $iframe[i];
			$(ifr).contents().find('#easyuiTheme').attr('href', href);
		}
	}

	$.cookie('easyuiThemeName', themeName, {
		expires : 7
	});
};
/**
 * @author 孙宇
 * 
 * @requires jQuery
 * 
 * 改变jQuery的AJAX默认属性和方法
 */
$.ajaxSetup({
	type : 'POST',
	error : function(XMLHttpRequest, textStatus, errorThrown) {
		$.messager.progress('close');
		$.messager.alert('错误', XMLHttpRequest.responseText);
	}
});
