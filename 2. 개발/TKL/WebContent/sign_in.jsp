<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <link rel="stylesheet" href="css/reset.css">
   <link rel="stylesheet" href="css/sign_in.css">
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
   <script src="js/signin.js"></script>
   <title>Take A Look Sign In</title>
</head>
<body>
   <div class="login_page">
      <div class="sign_in">
         <div class="upper">
            <a href=""><img src='img/logo.png'></a>
            <span>15초만에 가입하고 </span>
            <span>떼껄룩에서 안전하게 거래하세요!</span>
         </div>
         <form name='signin' id='signin' action='member.do?m=signin' method='post'>
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
            <input type='submit' class="bg_cos" value='로그인'>
            <a id='kakao-login-btn' class="kakao" ></a>
            <script type='text/javascript'>
				  //<![CDATA[
				    // 사용할 앱의 JavaScript 키를 설정해 주세요.
				    Kakao.init('8def6bb52c88c5d02955e69d07bf963f');
				    // 카카오 로그인 버튼을 생성합니다.
				    Kakao.Auth.createLoginButton({
				      container: '#kakao-login-btn',
				      success: function(authObj) {
				        // 로그인 성공시, API를 호출합니다.
				        Kakao.API.request({
				          url: '/v2/user/me',
				          success: function(res) {
				            //alert(JSON.stringify(res));
				            location.href="./index.do?m=kakao&nick="+res.properties.nickname;
				          },
				          fail: function(error) {
				            alert(JSON.stringify(error));
				          }
				        });
				      },
				      fail: function(err) {
				        alert(JSON.stringify(err));
				      }
				    });
				  //]]>
				</script>
            <input type='button' id='google' class="google" value='구글 아이디 로그인'>
            <input type='button' id='find' class="bg_cos" value='ID / PW 찾기'>
            <input type='button' id='signup' class="bg_newmem" value='아직 계정이 없으신가요? 가입하기'>
         </form>
      </div>
   </div>
   <div class="dim"></div>
</body>
</html>