<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tic Tac Teo Game</title>
</head>
<body>
<style>
	body{
		background-image:url('IT2.jpg');
		font-family:sans-serif;
	}
	
	.messagesection{
		height:50px;
		text-align:center;
		color:white;
		font-weight:bolder;
		font-size:20px;
	}
	
	.gameboard{
		position:absolute;
		top:50%;
		left:50%;
		transform:translate(-50%,-50%);
		width:300px;
		height:300px;
	}
	
	.row{
		height:32%;
	}
	
	.col{
		height:100%;
		width:32%;
		border: 2px solid white;
		float:left;
		font-size:70px;
		font-weight:bolder;
		color:white;
		text-align:center;
		cursor:pointer;
	}
	h1{
		color:yellow;
	}

</style>
<script>

	var turn = 1;
	var win = -1;
	var clickCounter = 0;
	var matrix = [
		[-1,-1,-1],
		[-1,-1,-1],
		[-1,-1,-1]
	]
	
	function playerAction(elem, row, col){
		
		if(elem.innerHTML != "") return;
		if(win != -1) return;
		
		clickCounter ++;
		
		matrix[row][col] = turn;
		if(turn == 1){
			elem.innerHTML = "X";
			document.getElementById("messagesection").innerHTML = "Play 2 turn";
			turn = 2;
		}
		else if(turn == 2){
			elem.innerHTML = "O";
			document.getElementById("messagesection").innerHTML = "Play 1 turn";
			turn = 1;
		}
		
		for(var i=0; i<3; i++){
			//設置橫行判斷
			if(matrix[i][0] == matrix[i][1] && matrix[i][1] == matrix[i][2]) win = matrix[i][0];
			//matrix[0][0] == matrix[0][1] && matrix[0][1] == matrix[0][2]
			//matrix[0][0] == matrix[0][1] == matrix[0][2]
			
			//設置直行判斷
			if(matrix[0][i] == matrix[1][i] && matrix[1][i] == matrix[2][i]) win = matrix[0][i];
			}
			
			//設置斜對角判斷
			if(matrix[0][0] == matrix[1][1] == matrix[2][2]) win = matrix[1][1];
			if(matrix[0][2] == matrix[1][1] == matrix[2][0]) win = matrix[1][1];
			
			if(win != -1){
				document.getElementById("messagesection").innerHTML = "Player"+ win + " has won the board";
			}
			
			if(clickCounter == 9 && win == -1){
				document.getElementById("messagesection").innerHTML = "Board has been drawn";
			}
		}

</script>
<h1><%=request.getSession().getAttribute("game")%>,開始對決吧!!</h1>
<br>
<div class="messagesection" id="messagesection">Play 1 turn</div>
	
	<div class="gameboard">
		
		<div class="row">
			<div class="col" onclick="playerAction(this, 0, 0)"></div>
			<div class="col" onclick="playerAction(this, 0, 1)"></div>
			<div class="col" onclick="playerAction(this, 0, 2)"></div>
		</div>
		<div class="row">
			<div class="col" onclick="playerAction(this, 1, 0)"></div>
			<div class="col" onclick="playerAction(this, 1, 1)"></div>
			<div class="col" onclick="playerAction(this, 1, 2)"></div>
		</div>
		<div class="row">
			<div class="col" onclick="playerAction(this, 2, 0)"></div>
			<div class="col" onclick="playerAction(this, 2, 1)"></div>
			<div class="col" onclick="playerAction(this, 2, 2)"></div>
		</div>
		
	</div>
	<button onclick="window.location.reload();">再玩一次</button>
	<br>
	<br>
	<input type="button" onclick="javascript:location.href='loginOutServlet'" value="登出">
</body>
</html>