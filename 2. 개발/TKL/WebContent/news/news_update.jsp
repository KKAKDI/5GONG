<%@ page contentType="text/html;charset=UTF-8" import="tkl.news.model.NewsDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>공지사항 상세보기</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
<script>
   function logout(){
      location.href="sign_in.jsp";
   }
   <%
   
   String sessionNick  = (String)session.getAttribute("session_nick");
   String sessionEmail  = (String)session.getAttribute("session_email");
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
	<h2>글 수정</h2>
	<form name='f' method='post' action='news.do?m=update&n_no=${updateview.n_no}'>
	<table>
			<tr>
				<td > 글 번호 : ${updateview.n_no}</td>
			</tr>
			
			<tr>
				<td >글 구분 :  ${updateview.n_division}</td>
			</tr>
			<tr>
			<td >이메일 : ${updateview.n_email}</td>
			</tr>
			<tr>
				<td >닉네임 : ${updateview.n_nick} </td>
			</tr>
			
			<tr>
				<td>글제목 : <input type = 'text' name='n_subject' size = '60' value = '${updateview.n_subject}'>
				</td>
			</tr>
			
			<tr >
				<td >글내용 : <input type='text' name = 'n_content'  size='100' value = '${updateview.n_content}'>
				</td>
			</tr>
	</table>
	 	<input type='submit' value='수정하기'>
			<a href='news.do?m=list'>목록</a>	
	</form>
			
</body>
</html>