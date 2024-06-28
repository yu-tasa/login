<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>再登録してください</h1>
	<form action="ForgotUserServlet" method="post">
		ユーザーID：<input type="text" name="userId"><br> 
		パスワード：<input type="password" name="pass"><br> 
		氏名：<input type="text" name="name"><br>
		<input type="submit" value="ログイン">
	</form>
</body>
</html>