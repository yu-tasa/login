<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>確認画面</h1>
	<h2>以下の情報で登録いたしました</h2>
	<p>ユーザーID:<c:out value="${userId}" /></p>
	<p>パスワード：<c:out value="${pass}" /></p>
	<p>名前：<c:out value="${name}" /></p>
	<a href="WelcomServlet">トップへ</a>
</body>
</html>