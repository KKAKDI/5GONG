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
	&nbsp;&nbsp;&nbsp;<a href='news.do?&m=list'>새소식 전체</a>
	&nbsp;&nbsp;&nbsp;<a href='news.do?&m=news_notice'>공지사항</a>
   &nbsp;&nbsp;&nbsp;<a href='news.do?&m=news_event'>이벤트</a>
   <br/><br/>
	<div >
	<a href='news/news_reg.jsp'>새소식 등록</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<br><br>
	</div>
	<table>
		<tr>
			<th >글번호</th>
			<th >닉네임</th>
			<th >제목</th>
			<th >내용</th>
			<th >등록일</th>
			<th >조회수</th>
			
		</tr>
		<c:if test="${list_event.size() == 0}">
			<tr>
				<td >데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${list_event}" var="dto">
		<tr>
			<td>${dto.n_no}</td>
			<td >${dto.n_nick}</td>
			<td >
			<span>[${dto.n_division}]</span>
				${dto.n_subject}</td>
			<td ><a href='news.do?m=con&n_no=${dto.n_no}'>${dto.n_content}</a></td>
			<td>${dto.n_writedate}</td>
			<td >${dto.n_view}</td>
		</tr>
		</c:forEach>
	</table>



</body>
</html>