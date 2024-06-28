<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>スッキリ商店</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		ユーザーID：<input type="text" name="userId"><br> パスワード：<input
			type="password" name="pass"><br> <input type="submit"
			value="ログイン">
	</form>
	<a href="ForgotUser">ID・パスワードを忘れた方はこちら</a>
	<%
        String errorMessage = (String) request.getAttribute("errorMessage");
        if (errorMessage != null) {
    %>
        <p style="color:red;"><%= errorMessage %></p>
    <%
        }
    %>
</body>
</html>