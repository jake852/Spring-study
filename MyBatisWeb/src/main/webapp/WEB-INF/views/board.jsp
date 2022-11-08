<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="loginId" value="${sessionScope.id} " />
<c:set var="loginout" value="${loginId==null ? 'Login': 'Logout' }" />
<c:set var="loginoutLink" value="${loginId==null ? '/login/login' : '/login/logout' }" />    
<c:set var="SingUp" value="${loginId==null ? '': 'display:none' }" />

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<c:url value='/resources/css/menu.css' />">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
	<script src="http://code.jquery.com/jquery-1.11.3.js"></script>
	
	
	<title>게시글 조회</title>
	
	
	<style type="text/css">
		* {
			box-sizing: border-box;
			margin: 0;
			padding: 0;
			font-family: "Noto Sans KR", sans-serif;
		}
		
		.container {
			width: 50%;
			margin: auto;
		}
		
		.writing-header{
			position: relative;
			margin: 20px 0 0 0;
			padding-bottom: 10px;
			border-bottom: 1px solid #323232;
		}
		
		.frm {
			width: 100%;
		}
		
		input{
			width: 100%;
			height: 35px;
			margin: 5px 0px 10px 0px;
			border: 1px solid #e9e8e8;
			padding: 8px;
			background: #f8f8f8;
			outline-color : #e6e6e6;
		}
		
		textarea {
			width: 100%;
			background: #f8f8f8;
			margin: 5px 0px 10px 0px;
			border: 1px solid #e9e8e8;
			resize: none;
			padding: 8px;
			outline-color : #e6e6e6;
		}
		
	</style>
</head>
<body>
	<!-- 2022. 11.08 게시글 조회 -->
	<div id="menu">
		<ul>
			<li id="logo">ezen</li>
			<li><a href="<c:url value='/' />">Home</a></li>
			<li><a href="<c:url value='/board/list' />">Board</a></li>
			<li><a href="<c:url value='${loginoutLink }' />">${loginout }</a></li>
			<li style="${SingUp}"><a href="<c:url value='/register/add' />">${SingUp }</a></li>	
			<li><a href=""><i class="fa fa-search small"></i></a></li>	
		</ul>
	</div>
	
	<script type="text/javascript">
		
	</script>
	
	<div class="container">
		<h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기" }</h2>
		<form id="form" class="frm" action="post">		 
			<input type="hidden" name="bno" value="${boardDto.bno }">
			<input type="text" name="title" value="${boardDto.title }" ${mode=="new" ? "" : "readonly='readonly'" }><br/>
			<textarea rows="20" name="content" ${mode=="new" ? "" : "readonly='readonly'" }>${boardDto.content }</textarea><br/>
		</form>
	</div>

</body>
</html>