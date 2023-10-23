<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>미지의 세계</h1>
<script>
function fPostAjax(){
	let testVO = {
		"name":"감자",
		"age":"20",
		"alias":"멍청함"
	};
	
	let xhr = new XMLHttpRequest();
	xhr.open("delete","/merong/silver/rain",true);
	// 보내는 데이터가 json형태의 문자열임을 알려줘야 함
	xhr.setRequestHeader("Content-Type","application/json")
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			console.log(JSON.parse(xhr.responseText));
		}
	}
	// get방식 이외에는 보내는 데이터를 send()안에 매개변수로 보내야함
	xhr.send(JSON.stringify(testVO));	// 꼭 문자열로
}
fPostAjax();

function fPostAjax1(){
	let myList = [
		"채현",
		"21",
		"강남스타일"
	];
	
	let xhr = new XMLHttpRequest();
	xhr.open("post","/merong/silver/rain",true);
	// 보내는 데이터가 json형태의 문자열임을 알려줘야 함
	xhr.setRequestHeader("Content-Type","application/json")
	xhr.onreadystatechange = function(){
		if(xhr.readyState == 4 && xhr.status == 200){
			console.log(xhr.responseText);
			console.log(JSON.parse(xhr.responseText));
		}
	}
	// get방식 이외에는 보내는 데이터를 send()안에 매개변수로 보내야함
	xhr.send(JSON.stringify(myList));	// 꼭 문자열로
}
fPostAjax1();
</script>
</body>
</html>