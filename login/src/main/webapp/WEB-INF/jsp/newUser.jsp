<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="NewUserServlet" method="post">
		ユーザーID：<input type="text" name="userId"><br> 
		パスワード：<input type="password" name="pass"><br> 
		氏名：<input type="text" name="name"><br>
		<input type="submit" value="ログイン">
	</form>
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