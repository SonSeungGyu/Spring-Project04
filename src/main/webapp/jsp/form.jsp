<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="/jsp/save.jsp" method="post">
		이름: <input type="text" name="username" />
		암호: <input type="text" name ="password" />
		
		<button type="submit">전송</button>
	</form>
	
</body>
</html>