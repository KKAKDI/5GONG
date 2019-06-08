<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/sign_in.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="js/signin.js"></script>
<title>Take A Look Sign In</title>
<style>
	#emailck{
		display:none;
	}
	#pwdck{
		display:none;
	}
</style>
</head>
<body>
   <div class="login_page">
      <div class="sign_in">
         <form name='signin' id='signin' action='member.do?m=signin' method='post'>
            <fieldset>
               <legend><a href=""><img src='img/icon.png'></a></legend>
               <div class="login_box">
                  <p>
                     <label for="u_email">이메일</label>
                     <input type='text' name='email' id='u_email' placeholder="Email address">
                     <div id='emailck'></div>
                  </p>
                  <p>
                     <label for="u_pwd">비밀번호</label>
                     <input type='password' name='pwd' id='u_pwd' placeholder="Password"> 
                     <div id='pwdck'></div>
                  </p>
               </div>
               <input type='submit' value='로그인'> 
               <input type='button' id='kakao' value='카카오 아이디 로그인'>
               <input type='button' id='google'value='구글 아이디 로그인'> 
               <input type='button' id='find' value='ID/PW 찾기'> 
               <input type='button' id='signup' value='회원가입'>
            </fieldset>
         </form>
      </div>
   </div>
   <div class="dim"></div>
</body>
</html>