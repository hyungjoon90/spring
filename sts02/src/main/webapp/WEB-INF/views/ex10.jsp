<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인(${sessionScope.login })</h1>
	<form action="lec02">
		id:<input type="text" name="id"/>
		pw:<input type="text" name="pw"/>
		<button type="submit">로그인</button>
	</form>
</body>
</html>