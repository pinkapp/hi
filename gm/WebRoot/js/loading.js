window.onload = function() {
	var a = document.getElementById("loading");
	a.parentNode.removeChild(a);
};

function getRootPath() {
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	return (prePath + postPath);
}

document
		.write('<div id="loading" style="position:absolute;z-index:99999;width:100%; height:100%; background-color:#ddd; filter:alpha(opacity=50); opacity:0.5; text-align:center; margin:auto; padding-top:280px;" ><img src="'
				+ getRootPath() + '/images/loading.gif"/></div>');

document.body.style.cssText = "padding:0; margin:0;";