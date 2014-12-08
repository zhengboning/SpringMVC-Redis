<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery/jquery-1.8.0.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index 2</title>
</head>
<body>
	<h1><font color="blue">index</font></h1>
	<div><font color="red" size="10px">${returnMsg}</font></div>
	<form action="${pageContext.request.contextPath }/TestRequest/test" method="post" name="loginForm" id="loginForm">
		<div>
			用户名：<input class="username" type="text" id="username" name="username"  value=''/>
		</div>
		<div >
			密码：<input class="password" type="password" id="password" name="password" value=""/>
		</div>
		<div><input type="button" value="submit" onclick="login()" /></div>
	</form> 
<script type="text/javascript">
	
	function login(){
		var username = $("#username").val();
		var password = $("#password").val();
		$("#loginForm").submit();
	}

	document.onkeydown=function(event){ 
        e = event ? event :(window.event ? window.event : null); 
        if(e.keyCode==13){ 
        	login();
        } 
    } 
	
</script>
</body>
</html>