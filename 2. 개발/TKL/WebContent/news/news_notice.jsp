<%@ page contentType="text/html;charset=UTF-8" import="tkl.news.model.NewsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/news_list.css">

<script>
   function logout(){
      location.href="sign_in.jsp";
   }
   <%
   
   String sessionNick  = (String)session.getAttribute("session_nick");
   
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
		공지사항
	</h1>
	&nbsp;&nbsp;&nbsp;<a href='news.do?&m=list'>새소식 전체</a>
	&nbsp;&nbsp;&nbsp;<a href='news.do?&m=news_event'>이벤트</a>	
	<br/><br/>
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
	<div >
	<center>
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
		<c:if test="${list_notice.size() == 0}">
			<tr>
				<td >데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${list_notice}" var="dto">
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
