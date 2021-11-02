<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>歡迎來到JavaWeb</title>
<style>
	span{
	 color:red;
	}
</style>
</head>
<body>
	<!-- 透過getSession().getAttribute方法返回接收指定屬姓名(user)的屬性值 -->
	<h1><%=request.getSession().getAttribute("user")%>,歡迎您!!</h1>
	<span id="time">10</span>秒後,為您跳轉至JavaWeb遊戲天地!
	
	<script>
	var second = 10;
	var time = document.getElementById("time");
	//定義方法,獲取span標籤,修改span的標籤內容,時間倒數--
	function showTime(){
		second --;
		if(second <= 0){
			//跳轉頁面
			location.href = "TicTacToeGame.jsp";
		}
		time.innerHTML = second + "";
	}
		//設置定時器,1秒執行該方法
		setInterval(showTime,1000);
	</script>
</body>
</html>