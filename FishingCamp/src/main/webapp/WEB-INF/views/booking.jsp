<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form  action="/fishing/insertbooking"  method="post">
	<table>
		<tr>
			<td>낚시꾼 회원 코드</td>
			<td> <input type="text" name="a_code"></td>
		</tr>
			
		<tr>
			<td>일수</td>
			<td> <input type="text" name="days"></td>
		</tr>
		
		<tr>
			<td colspan="2"> <button>예약</button>  </td>
		</tr>
	</table>
</form>
</body>
</html>