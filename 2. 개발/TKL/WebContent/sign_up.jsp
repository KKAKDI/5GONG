<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Take A Look Sign Up</title>
<script type="text/javascript">
function confirm_email(){
	alert("이메일 인증완료");
}
function confirm_nick(){
	alert("사용할 수 있는 닉네임 입니다");
}
function confirm_phone(){
	alert("실명 인증이 완료 되었습니다");
}
</script>
</head>
<body>
	
	<form name='signup' action='가입서블릿' method='post'>
	 <fieldset>
	<legend> 회 원 가 입 </legend>
		이메일 :
		<input type='text' name='email' id='email' title='이메일은 ID로 사용됩니다.' maxlength = '40' autofocus required> 
		<input type='button' id='emailconfirm' onclick='confirm_email()' value='이메일 인증'/>
		<br>
		<!-- 비밀번호 체크 쿼리 필요 -->
		비밀번호 :
		<input type='password' id='pwd1' required/> 
		<br>
		비밀번호 확인 :
		<input type='password' id='pwd2' required/> 	
		 <br>
		 닉네임 :
		<input type='text' name='nick' id='nick' title='닉네임은 사이트 활동에 사용됩니다.' maxlength = '12' required> 
		<input type='button' id='nickconfirm' onclick='confirm_nick()' value='닉네임 중복확인'/>
		<br>
		은행명 :
		<select name='bank'>
			<option value ='kb'>국민은행</option>
			<option value ='nh'>농협</option>
			<option value ='ibk'>ibk기업은행</option>
			<option value ='sh'>신한은행</option>
			<option value ='wr'>우리은행</option>
			<option value ='kko'>카카오뱅크</option>		
		</select>	
		<br>
		계좌번호 :
		<input type='text' id='accountnum' required title='- 을 제외하고 입력해주세요.'/> 
		예금주 :
		<input type='text' id='accountname' required/> 
		<br>
		핸드폰번호 :
		<input type='text' name='phone' id='phone' title='- 을 제외하고 입력해주세요.' maxlength = '11' required> 
		<input type='button' id='phoneconfirm' onclick='confirm_phone()' value='핸드폰 인증'/>
		<br>
		이용약관 방침
		<input type='button' id='이용약관'  value='동의'/>
		<br>
		개인정보 처리방침
		<input type='button' id='개인정보' value='동의'/>
		<br>
		<input type='submit' value='회원가입'>		
		</fieldset>
	</form>
</body>
</html>