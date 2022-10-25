<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<h2>클라이언트와 서버의 정보 읽기</h2>
	<a href="./requestWebInfo.jsp?eng=ezen&city=이젠">GET 방식 전송</a>  <!-- GET 방식 요청 -->
	
	<h2>클라이언트의 요청 매개변수 읽기</h2>
	<form action="request
	Parameter.jsp" method="post">				  <!--  POST 방식으로 요청 -->
		아이디 : <input type="text" name="id" value=""><br/>
		성별 : 
			<input type="radio" name="gender" value="man">남자
			<input type="radio" name="gender" value="woman">여자
			<br/>
		관심사항 : 
			<input type = "checkbox" name="fovo" value"eco">경제
			<input type = "checkbox" name="fovo" value"pol">정치
			<input type = "checkbox" name="fovo" value"ent">연애  
			<br/>
		자기소개 :
			<textarea rows="4" cols="30" name="intro">
			</textarea>
			<input type = "submit" value="전송하기">
			<br/>
		
		
	</form>
</body>
</html>