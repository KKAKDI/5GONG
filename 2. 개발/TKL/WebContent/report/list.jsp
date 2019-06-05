<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.report.model.ReportDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<meta charset='utf-8'>
<link rel='stylesheet' type='text/css' href='css/style.css'>
<center>
<hr width='600' size='2' noshade>
<h2>TKL 신고게시판 List</h2>
&nbsp;&nbsp;&nbsp;
<a href='rBoard.do?m=in_form'>신고하기</a>
&nbsp;&nbsp;&nbsp;
<a href='index.do'>인덱스</a>
&nbsp;&nbsp;&nbsp;

<form action="rBoard.do">
<select name="m">
<option value="list">--처리상태--</option>
<option value="list">모두보기</option>
<option value="listR">처리중</option>
<option value="listC">처리완료</option>
</select>
<input type="submit" value="검색"/>
</form>

</center>
<table border='1' width='600' align='center' cellpadding='2'>
<tr>
<th>글번호</th>
<th>글제목</th>
<th>작성자</th>
<th>등록일</th>
<th>처리상태</th>
</tr>

<c:if test="${list.size() == 0}">
			<tr>
				<td colspan='5' align='center'>데이터가 하나도 없음</td>
			</tr>
		</c:if>
		

<c:forEach items="${list}" var="dto">		
<tr>
<td>${dto.rNO}</td>
<td><a href='rBoard.do?m=content&rNO=${dto.rNO}'>${dto.rSubject}</a></td>
<td>${dto.rNick}</td>
<td>${dto.rWriteDate}</td>
<td>${dto.rState}</td>
</tr>
</c:forEach>

</table>