<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.board.model.BoardDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset='utf-8'>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

<center>
<link rel="stylesheet" type="text/css" href="//www.ppomppu.co.kr/css/style.css?v=2019050104" />
<link rel="stylesheet" type="text/css" href="//www.ppomppu.co.kr/css/stylesheet.css?v=2019050104" />
<link rel="stylesheet" type="text/css" href="//www.ppomppu.co.kr/zboard/dq_css/cate_tab_201303042.css" />
<link rel="shortcut icon" href="//img.ppomppu.co.kr/favicon.ico" />
<link rel="apple-touch-icon" href="//img.ppomppu.co.kr/images/nn128.jpeg"/>

<hr>
<h2>자유게시판</h2>
&nbsp;&nbsp;&nbsp;
<a href='board.do?m=board_input'>글쓰기</a>
&nbsp;&nbsp;&nbsp;
<a href='index.jsp'>인덱스</a>
<hr width='600' size='2' noshade>
</center>
<script language="javascript">
function check() {
    if (document.search.keyWord.value == "") {
        alert("검색어를 입력하세요.");
        document.search.keyWord.focus();
        return;
    }
    document.search.submit();
}
	</script>

<table>
	<tr>
	<th>글번호</th>
	<th>작성자</th>
	<th>이메일</th>
	<th>글제목</th>
	<th>날짜</th>
	<th>조회수</th>
	</tr>
	<c:if test="${list.size() == 0}">
	<tr>
	<td>데이터가 하나도 없음</td>
	</tr>
	</c:if>

	<c:forEach items="${list}" var="dto">
	
	
	<tr>
	<td>${dto.bNo}</td>
	<td>${dto.mNick}</td>
	<td><c:out value="${dto.mEmail}" escapeXml="true">email없음</c:out></td>
	<td>
	
	<a href='board.do?m=board_content&bNo=${dto.bNo}'>${dto.bSubject}&nbsp;&nbsp;</a>
	<c:if test="${dto.CNT != 0 }">
	[${dto.CNT}]
	</c:if>
	</td>
	<td>${dto.bWriteDate}</td>
	<td>${dto.bView}</td>
	</tr>
	</c:forEach>
	


</table>

<form action="board.do?m=board_list" method="post">
	<select name="sk">
		<option value="">전체보기</option>
		<option value="M_NICK">닉네임</option>
		<option value="B_SUBJECT">제목</option>
		<option value="B_CONTENT">내용</option>
	</select>
	<input type="text" name="sv">
	<input type="submit" value="검색">
</form>

