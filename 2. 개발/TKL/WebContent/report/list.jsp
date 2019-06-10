<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.report.model.ReportDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<meta charset='utf-8'>
<title>TKL 신고게시판 List</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="../css/reset.css">
</head>
&nbsp;&nbsp;&nbsp;
<a href='rBoard.do?m=in_form'>신고하기</a>
&nbsp;&nbsp;&nbsp;
<a href='index.do'>홈</a>
&nbsp;&nbsp;&nbsp;

<form action="rBoard.do">
<select name="searchKey">
<option value="0">--처리상태--</option>
<option value="list">모두보기</option>
<option value="listR">처리중</option>
<option value="listC">처리완료</option>
</select>
<input type="submit" value="검색"/>
</form>

<table>
<tr>
<!-- <th>글번호</th> -->
<th>분류</th>
<th>글제목</th>
<th>작성자</th>
<th>등록일</th>
<th>처리상태</th>
</tr>
<%
	int pg = (int) request.getAttribute("page");
	int fromPage = (int) request.getAttribute("fromPage");
	int toPage = (int) request.getAttribute("toPage");
	int allPage = (int) request.getAttribute("allPage");
	int block = (int) request.getAttribute("block");
%>


<c:if test="${list.size() == 0}">
			<tr>
				<td colspan='5' align='center'>신고 내역이 없습니다.</td>
			</tr>
		</c:if>
		

<c:forEach items="${list}" var="dto">		
<tr>
<!-- <td>${dto.rNO}</td> -->
<td>${dto.rClass}</td>
<td><a href='rBoard.do?m=content&rNO=${dto.rNO}'>${dto.rSubject}</a></td>
<td>${dto.rNick}</td>
<td>${dto.rWriteDate}</td>
<td>${dto.rState}</td>

</tr>
</c:forEach>

</table>

<br>
 <div class="page_num">
	<ul>					
		<%
			if (pg > block) { //처음, 이전 링크
		%> 
		<a href="rBoard.do?pg=1">◀◀</a> <a href="rBoard.do?pg=<%=fromPage - 1%>">◀</a>
		<%
			} else {
		%><span style="color: gray">◀◀</span><span style="color: blue">◀</span>
		<%
			}
		%> 
		<%
		 	for (int i = fromPage; i <= toPage; i++) {
		 		if (i == pg) {
		 %>
		  <span><%=i%></span>
		  <%
		 		} else {
		 %> 
		 <a href="rBoard.do?pg=<%=i%>"><%=i%></a>
		 <%
		 		}
		 	}
		 %> 
		 <%
		 	if (toPage < allPage) { //다음, 이후 링크
		 %>
		  <a href="rBoard.do?pg=<%=toPage + 1%>">▶</a><a href="rBoard.do?pg=<%=allPage%>">▶▶</a>
		<%
		 	} else {
		 %> <span style="color: blue">▶</span><span style="color: gray">▶▶</span>
		<%
		 	}
		 %>					
	</ul>
</div>