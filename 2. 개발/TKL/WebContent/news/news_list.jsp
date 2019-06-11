<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, tkl.news.model.NewsDTO, tkl.member.model.MemberDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<Style>
	align="center"
</Style>

<meta charset="UTF-8">
<title>새소식 목록</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/product_list_buy.css">
<script>
   function logout(){
      location.href="sign_in.jsp";
   }
   <%
   
   String sessionNick  = (String)session.getAttribute("session_nick");
   sessionNick = sessionNick.trim();
      if(sessionNick==null){
   %>   
      alert("session 없음");      
      Kakao.cleanup();   
      logout();
   <%       
      }
   %>         
   </script>   

</head>
<body>
<center>
	<h1>
		새소식
	</h1>

	&nbsp;&nbsp;&nbsp;<a href='./'>홈</a>
	&nbsp;&nbsp;<a href='news.do?&m=news_notice'>공지사항</a>
   &nbsp;&nbsp;&nbsp;<a href='news.do?&m=news_event'>이벤트</a>	
	<center>
	<br/>
	<div >
<%
	String sessionGrant = (String)session.getAttribute("session_grant"); 
	sessionGrant = sessionGrant.trim();
		if(sessionGrant.equals("0") ){
			System.out.println(sessionGrant);
%>   
	 &nbsp;<a href='news/news_reg.jsp'>새소식 등록</a>
	 		  <hr width='600' size='2' noshade>

<%
	}else{
		
%>
	 
<%
	}
%>
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
		<c:if test="${list.size() == 0}">
			<tr>
				<td >데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${list}" begin="${beginNum}" end="${beginNum+recodeSizePerPage}" step="1">
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
	
		<c:if test="${curBlock > 0}">
			 <a href ="news.do?curBlock=${curBlock-1}">이전</a>
		</c:if>
		
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
        <a href ="news.do?curBlock=${curBlock}&curPage1=${i}">${i+1} | </a>
        </c:forEach>  
          
        <c:if test="${curBlock < (pageSize/pageSizePerBlock)-2}">
			 <a href ="news.do?&curBlock=${curBlock+1}">다음</a>
		</c:if> 

</body>
</html>
