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
	<tr>
	<td align='center'><img src="img/notice_icon.jpg" border=0 alt="notice" /></td>
	<td align='center'>운영자</td>
	<td align='center'>GM</td>
	<td align='center'>오늘부터 사이트 폐지합니다.</td>
	<td align='center'>2019-06-09</td>
	<td align='center'>9999999</td>
	</tr>
	
	<c:set var="doneLoop" value="false"/>
	<c:forEach var="list" items="${list}" begin="${beginNum}" end="${beginNum+(recodeSizePerPage-1)}" step="1">
	 <c:if test="${not doneLoop}">

      <tr>
         <td>${list.bNo}</td>
         <td>${list.mNick}</td>
         <td>${list.mEmail}</td>
         <td>
            <a href='board.do?m=board_content&bNo=${list.bNo}'>${list.bSubject}</a>
            <span style="color: red;">[${list.CNT}]</span>
         </td>
         <td>${list.bWriteDate}</td>
         <td>${list.bView}</td>
      </tr>
               <c:if test="${totalRecodeSize <= beginNum}">
              <c:set var="doneLoop" value="true"/>
      </c:if>
         </c:if>
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

<c:if test="${curBlock >0}">
	<a href ="board.do?m=board_list&curBlock=${curBlock-1}&curPage=${startPage-1}&sk=${sk}&sv=${sv}">이전</a>
</c:if>


<c:set var="doneLoop" value="false"/>
	<c:forEach var="i" begin="${startPage}" end="${endPage-1}" step="1">
		<c:if test="${not doneLoop}">
   			 <td><a href ="board.do?m=board_list&curBlock=${curBlock}&curPage=${i}&sk=${sk}&sv=${sv}">${i+1} | </a></td>
  	
   		<c:if test="${pageSize <= (i+1)}">
    	<c:set var="doneLoop" value="true"/>
    	
   		 </c:if>
 	</c:if>
 </c:forEach>
    
    
    
    
<c:if test="${curBlock < (pageSize/pageSizePerBlock)-1}">
	<a href ="board.do?m=board_list&curBlock=${curBlock+1}&sk=${sk}&sv=${sv}">다음</a>
</c:if>

