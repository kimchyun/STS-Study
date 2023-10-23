<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>민우뿌~~</h1>
<form action="/sec/logout" method="post">
	<sec:csrfInput/>
	<button>로그아웃이지요!</button>
</form>
<input type="text" id="bj" value="bjMerong"><br>
<button onclick="fAjax()">아작스 전송</button>
<script>
	// csrf 토큰은 get방식에는 안 보내도 됨! (나머진 보내야 함)
	//서버에서 발행된 헤더네임과 토큰갑사 저장
	var header = '${_csrf.headerName}';
	var token =  '${_csrf.token}';
	var myBJ = document.querySelector("#bj")

	function fAjax(){
		console.log(myBJ.value);
		let xhr = new XMLHttpRequest();
		xhr.open("post","/sec/angma/yerin",true);
		//바닐라 자바스크립트 사용시 AJAX send 전에 헤더값 세팅 필요
		xhr.setRequestHeader(header, token);
		xhr.setRequestHeader("Content-Type","application/json")
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				console.log(xhr.responseText);
			}
		}
		xhr.send(myBJ.value);
	}
</script>
</body>
</html>