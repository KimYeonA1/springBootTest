<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<h3>게시글 삭제</h3>
<form method="post" action="/board/post">
<button type="submit" name="remove">삭제</button>
</form>
<a href="/board/get?list1">목록</a>
</body>
</html>