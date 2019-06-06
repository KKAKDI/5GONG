<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Take A Look Sign In</title>
</head>
<body>
	<img src='img/icon.png'>		
<form name='signin' action='로그인서블릿' method='post'>
	 <fieldset>
	<legend> 로 그 인 </legend>
		<input type='text' name='email' id='email' placeholder="Email address"/> 		
		<br>				
		<input type='password' id='pwd' placeholder="Password"/> 
		<br>
		<input type='submit' value='로그인'>
		<br>
		 <input type='button' id='kakao'  value='카카오 아이디 로그인'/>
		 <br>
		 <input type='button' id='google'  value='구글 아이디 로그인'/>
		 <br>
		 <input type='button' id='find'  value='ID/PW 찾기'/>
		<input type='button' id='signup' value='회원가입'/>
		</fieldset>
	</form>
</body>
</html>