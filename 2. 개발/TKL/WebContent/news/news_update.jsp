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
	<h2>글 수정</h2>
	<a href='news/news_update.jsp'>상품수정</a>
	<form name='f' method='post' action='news.do?m=update&n_no=${view.n_no}'>
	<table>
			<tr>
				<td > 글 번호 : ${view.n_no}</td>
			</tr>
			
			<tr>
				<td >글 구분 : ${view.n_division}</td>
			</tr>
			
			<tr>
				<td >닉네임 : ${view.n_nick} </td>
			</tr>
			
			<tr>
				<td>글제목 : <input type = 'text' name='n_subject' size = '60' value = '${view.n_subject}'>
				</td>
			</tr>
			
			<tr >
				<td >글내용 : <input type='text' name = 'n_content'  size='100' value = '${view.n_content}'>
				</td>
			</tr>
	</table>
	 	<input type='submit' value='수정하기'>
			<a href='news.do?m=list'>목록</a>	
	</form>
			
</body>
</html>