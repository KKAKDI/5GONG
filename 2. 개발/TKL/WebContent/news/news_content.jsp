<%@ page contentType="text/html;charset=UTF-8" import="tkl.news.model.NewsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>공지사항 상세보기</title>
<style type="text/css">
table {
	border: 1px solid #333;;
	width: 1000px;
	height: 500px;
}

tr, th, td {
	border: 1px solid #333;
}
</style>
</head>
<body>
	<h2>공지사항</h2>
	<table>
			<tr>
				<td >글 번호 : ${con.n_no}</td>
			</tr>
			
			<tr>
				<td >글 구분 : ${con.n_division}</td>

			</tr>
			<tr>
				<td>닉네임 : ${con.n_nick}</td>
			</tr>
			<tr>
				<td>글제목 : ${con.n_subject}</td>
			</tr>
			<tr >
				<td >글내용 : ${con.n_content}</td>
			</tr>
			
		
	</table>
			<b> 
			<a href='news.do?m=view&n_no=${con.n_no}'>수정</a>| 
			<a href='news.do?m=del&n_no=${con.n_no}'>삭제</a>| 
			<a href='news.do?m=list'>목록</a>	
			</b>
</body>
</html>