/*must jQuery*/
function getRootPath() {
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var pos = strFullPath.indexOf(strPath);
	var prePath = strFullPath.substring(0, pos);
	var postPath = strPath.substring(0, strPath.substr(1).indexOf('/') + 1);
	return (prePath + postPath);
}
$(function(){
	$.ajax({
		type : 'POST',
		url : getRootPath() + '/ajax/getSession',
		success : function(result) {
			if (!result) {
				window.location.href = getRootPath() + "/login.htm";
			}
		},
		error : function(error) {
		},
		dataType : 'json'
	});
});

