<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="utf-8">
<title>간단한 게시판</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/product_reg.css">
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
 

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
    
</head>
	<body>
	<form name="f" method="post" action="../news.do?m=in" >
<br/><br/><br/>
	
	<b>새소식 글 작성</b>


	<br/><br/>
		<table>
			<tr>
				<td>글 제목 : <input type="text" name="n_subject" size="60"></td>
			</tr>
			<tr>
			<td>이메일 :  <input type="text" name = "n_email" value=${session_email} disabled="disabled"></td>
			</tr>
			<tr>
			<td>닉네임 :  <input type="text" name = "n_nick" value=${session_nick} disabled="disabled" ></td>

			</tr>
			<tr>
				<td>글 구분 : 
						<select name="n_division">
						<option>공지사항</option>
						<option>이벤트</option>
						</select>
				</td>
			</tr>
			
			<tr>
				<td colspan='2'>글내용<br/><br/> 
				<textarea name="n_content" rows="10" cols="60"></textarea></td>
			</tr>
			
			<tr>
				<td>
				<input type="submit" value="등록"> 
				<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
		<br>
	</form>
</body>
</html>