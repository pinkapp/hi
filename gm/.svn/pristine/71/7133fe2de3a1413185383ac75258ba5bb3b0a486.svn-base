<%@page contentType="text/html;charset=utf-8" isErrorPage="true"%>
<html>
<head><title>出现错误</title>
</head>
<body>
	<div id="errorInfo" style="display: none">
	<% 
	try {
		// The Servlet spec guarantees this attribute will be available
		//Throwable exception = (Throwable) request.getAttribute("javax.servlet.error.exception"); 
		if (exception != null) {
			if (exception instanceof ServletException) {
				// It's a ServletException: we should extract the root cause
				ServletException sex = (ServletException) exception;
				Throwable rootCause = sex.getRootCause();
				if (rootCause == null)
					rootCause = sex;
				out.println("** Root cause is: "+ rootCause.getMessage());
				rootCause.printStackTrace(new java.io.PrintWriter(out)); 
			}
			else {
				// It's not a ServletException, so we'll just show it
				exception.printStackTrace(new java.io.PrintWriter(out)); 
			}
		} 
		else  {
	    	out.println("No error information available");
		} 
	
		// Display cookies
		out.println("<br/>Cookies:\n<br/>");
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
	    	for (int i = 0; i < cookies.length; i++) {
	      		out.println(cookies[i].getName() + "=[" + cookies[i].getValue() + "]");
			}
		}
		    
	} catch (Exception ex) { 
		ex.printStackTrace(new java.io.PrintWriter(out));
	}
	%>
	</div>
     <H2><a href="javascript:void(0);" title="查看详情" onclick="dd();">糟糕，出错了</a>
	     <script type="text/javascript">
			function dd(){
				myWindow=window.open('','','width=800,height=600');
				var div = document.getElementById('errorInfo');
				myWindow.document.write(div.innerHTML);
				myWindow.focus();
			}
		</script>
     </H2>
</body>
</html>