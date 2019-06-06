<%@ page contentType="text/html;charset=UTF-8" import="tkl.news.model.NewsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>새소식 목록</title>
</head>
<body>
	<h1>
		새소식
	</h1>
	<br/>
	<tr><b>공지사항</b></tr>
	<br><br>
	<div >
	<a href='news/news_reg.jsp'>공지등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br><br>
	
	</div>
	<table>
		<tr>
			<th align='center' width='5%'>글번호</th>
			<th align='center' width='10%'>닉네임</th>
			<th align='center' width='30%'>제목</th>
			<th align='center' width='40%'>내용</th>
			<th align='center' width='10%'>등록일</th>
			<th align='center' width='5%'>조회수</th>
			
		</tr>
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5" align="center">데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td align='center'>${dto.n_no}</td>
			<td align='center'>${dto.n_nick}</td>
			<td align='center'>${dto.n_subject}</td>
			<td align='center'><a href='news.do?m=con&n_no=${dto.n_no}'>${dto.n_content}</a></td>
			<td align='center'>${dto.n_writedate}</td>
			<td align='center'>${dto.n_view}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
