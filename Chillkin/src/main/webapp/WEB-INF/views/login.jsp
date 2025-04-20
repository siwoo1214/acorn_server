<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인</title>
</head>
<body>

<h2>가맹점 로그인</h2>

<form action="/Chillkin/login" method="post">
    지점 ID (Branch ID): <input type="text" name="branch_id"><br><br>
    비밀번호: <input type="password" name="pw"><br><br>
    <input type="submit" value="로그인">
</form>
<a href="/Chillkin/signup">회원가입</a>

</body>
</html>
