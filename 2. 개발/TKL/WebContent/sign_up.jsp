<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Take A Look Sign Up</title>
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/sign_up.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="js/signup.js"></script>
</head>
<body>
<div id='take_signup'>

   <div id='signupform'>
      <a href=""><img src="img/logo.png" alt=""></a>
      <form name='signup' action='member.do?m=insert' method='post'>
            <div class="tkl_emali">
               <label for='email'>이메일 :</label> 
               <input type='text' name='email' id='email' title='이메일은 ID로 사용됩니다.' required>
               <input type='button' id='emailconfirm' value='이메일 인증'>
               <div id='emailck'></div>
            </div>
            <div class="tkl_phone">
               <label for='phone'>핸드폰 :</label>
               <input type='text' name='phone' id='phone' title='-을 제외하고 입력해주세요.' required> 
               <input type='button' id='phoneconfirm' value='핸드폰 본인 인증'>
               <div id='phoneck'></div>
            
            </div>
            <div class="tkl_namefix">
             <label for=name>이&nbsp;&nbsp;름 :</label>
              <input type="text" name='name' id='name' value='' disabled>
               <div id="namefixck"></div>
            </div>
            <div class="tkl_pw">
               <label for='pwd1'>비밀번호 :</label>
               <input type='password' id='pwd1' required >
               <div id='pwdck'></div>
            </div>
            <div class="tkl_pw_2">
               <label for='pwd2'>비번확인 :</label>
               <input type='password' name='pwd2' id='pwd2' required >
               <div id='pwd2ck'></div>
            </div>
            <div class="tkl_usenick">
               <label for='nick'>닉네임 :</label>
               <input type='text' name='nick' id='nick' title='닉네임은 사이트 활동에 사용됩니다.' maxlength='12' required>
               <input type='button' id='nickconfirm' value='닉네임 중복확인'>
               <div id='nickck'></div>
            </div>
            <div class="tkl_confirm">
               <div class="bank_select_zone">
               <span>은행명 :</span>
                  <select name='bank' id='bank'>
                     <option value='국민은행'>국민은행</option>
                     <option value='농협'>농협</option>
                     <option value='기업은행'>ibk기업은행</option>
                     <option value='신한은행'>신한은행</option>
                     <option value='우리은행'>우리은행</option>
                     <option value='카카오뱅크'>카카오뱅크</option>
                  </select>
               </div>
               <br>
            <label for='actname'>예금주 :</label>
            <input type='text' id='actname' value='' required >
            <div id='actck'></div>

            <label for='actnum'>계좌번호 :</label>
            <input type='text' id='actnum' name='actnum' required title='- 을 제외하고 입력해주세요.'>
            <input type='button' id='actconfirm' value='계좌정보 인증'> 
            </div>
         <div class="agree">
            <span>이용약관 방침</span>
            <input type='button' id='service' value='동의'> 

            <span>개인정보 처리방침</span>
            <input type='button' id='privacy' value='동의'> 

           
         </div>
         <input type='submit' id='submit' class="signup_fin" value='회원가입'>
      </form>
   </div>
</div>
  <div class="dim"></div>
</body>

</html>