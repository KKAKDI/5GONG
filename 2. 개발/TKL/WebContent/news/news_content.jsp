<%@ page contentType="text/html;charset=UTF-8" import="tkl.news.model.NewsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 상세보기</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
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

<meta charset="utf-8">


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
			<td >이메일 : ${con.n_email}</td>
			
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
<%
	String sessionGrant = (String)session.getAttribute("session_grant"); 
		if(sessionGrant.equals("0") ){
			System.out.println(sessionGrant);
%>   
	 <a href='news.do?m=updateview&n_no=${con.n_no}'>수정</a>| 
			<a href='news.do?m=del&n_no=${con.n_no}'>삭제</a>| 
			
<%
	}else{
		
%>
	 <a href='news.do?m=list'>목록</a>	
<%
	}
%>
			
			</b>
</body>
</html>