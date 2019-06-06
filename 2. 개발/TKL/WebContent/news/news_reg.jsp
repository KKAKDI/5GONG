<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>간단한 게시판</title>
<meta charset="utf-8">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    
</head>
	<body>
	<form name="f" method="post" action="../news.do?m=in" >
<br/><br/><br/>
	
	<b>공지글 작성</b>


	<br/><br/>
		<table>
			<tr>
				<td>글 제목 : <input type="text" name="n_subject" size="60"></td>
			</tr>
			<tr>
				<td>글 구분 : <input type="text" name="n_division"></td>
			</tr>
		 	<!-- <tr>
				<td>이메일 :<input type="text" name="n_email"></td>
			</tr>
			<tr> -->
				<td>닉네임 : <input type="text" name="n_nick" ></td>
			</tr>
			<tr>
				<td colspan='2'>글내용<br/><br/> 
				<textarea name="n_content" rows="10" cols="60"></textarea></td>
			</tr>
			
			<tr>
				<td>
				<input type="submit" value="등록"> 
				<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
		<br>
	</form>
</body>
</html>