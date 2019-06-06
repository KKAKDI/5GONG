<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Take A Look Sign Up</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style>
#emailck {
	display: none;
}

#pwdck {
	display: none;
}

#pwd2ck {
	display: none;
}

#nickck {
	display: none;
}

#signupform {
	width: 220px;
	margin: auto;
}
</style>
<script src="js/signup.js"></script>
</head>
<body>
	<div id='signupform'>
		<form name='signup' action='가입서블릿' method='post'>
			<fieldset>
				<legend> 회 원 가 입 </legend>
				이메일 <input type='text' name='email' id='email'
					title='이메일은 ID로 사용됩니다.' required>
				<div id='emailck'></div>
				<input type='button' id='emailconfirm' value='이메일 인증' /> <br>
				<!-- 비밀번호 체크 쿼리 필요 -->
				비밀번호 <input type='password' id='pwd1' required />
				<div id='pwdck'></div>
				비밀번호 확인 <input type='password' id='pwd2' required />
				<div id='pwd2ck'></div>
				닉네임 : <input type='text' name='nick' id='nick'
					title='닉네임은 사이트 활동에 사용됩니다.' maxlength='12' required>
				<div id='nickck'></div>
				<input type='button' id='nickconfirm' value='닉네임 중복확인' /> <br>
				은행명 : <select name='bank'>
					<option value='kb'>국민은행</option>
					<option value='nh'>농협</option>
					<option value='ibk'>ibk기업은행</option>
					<option value='sh'>신한은행</option>
					<option value='wr'>우리은행</option>
					<option value='kko'>카카오뱅크</option>
				</select> <br> 계좌번호 <input type='text' id='accountnum' required
					title='- 을 제외하고 입력해주세요.' /> 예금주 <input type='text'
					id='accountname' required /> <br> 핸드폰번호 <input type='text'
					name='phone' id='phone' title='- 을 제외하고 입력해주세요.' maxlength='11'
					required> <input type='button' id='phoneconfirm'
					onclick='confirm_phone()' value='핸드폰 인증' /> <br> 이용약관 방침 <input
					type='button' id='이용약관' value='동의' /> <br> 개인정보 처리방침 <input
					type='button' id='개인정보' value='동의' /> <br> <input
					type='submit' value='회원가입'>
			</fieldset>
		</form>
	</div>
</body>
</html>