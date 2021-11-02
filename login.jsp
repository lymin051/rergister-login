<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>

</head>
<body>
	<div align="center">
		<h1>登入</h1>
		<h4>使用您的 JavaWeb 學習帳戶</h4>
		<!-- 透過request.getContextPath()返回當前web應用的路徑 -->
		<form action="<%=request.getContextPath()%>/loginServlet" method="post">
		<table>
			<tr>
				<td>使用者帳號:</td>
				<td><input type="text" name="username" placeholder="請輸入您的帳號"></td>
			</tr>
			<tr>
				<td>使用者密碼:</td>
				<td><input type="password" name="password" placeholder="請輸入您的密碼"></td>
			</tr>	
		</table>
			<br>
			<input  type="submit" value="登入" style="float:center"/>
			<input type="button" value="註冊" onclick="javascript:location.href='employeeregister.html'" style="float:center"/>
			<input type="reset" value="重置" style="float:center"/>
		</form>
	</div>
	<br>
	<div style="text-align:center;color:red;"><%=request.getAttribute("login_error") == null ? "" : request.getAttribute("login_error") %></div>
</body>
</html>