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

#phoneck {
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

#actck {
	display: none;
}

#signupform {
	width: 225px;
	margin: auto;
}
</style>
<script src="js/signup.js"></script>
</head>
<body>
	<div id='signupform'>
		<form name='signup' action='/member.do?m=insert' method='post'>
			<fieldset>
				<legend> 회 원 가 입 </legend>
				이메일 <input type='text' name='email' id='email'
					title='이메일은 ID로 사용됩니다.' required>
				<div id='emailck'></div>
				<input type='button' id='emailconfirm' value='이메일 인증' /> <br>
				핸드폰번호 <input type='text' name='phone' id='phone'
					title='- 을 제외하고 입력해주세요.' required> <input type='button'
					id='phoneconfirm' value='핸드폰 본인 인증' /> <br>
				<div id='phoneck'></div>
				<input type="text" name='name' id='name' value='' disabled />
				<div id="namefix"></div>
				비밀번호 <input type='password' id='pwd1' required />
				<div id='pwdck'></div>
				비밀번호 확인 <input type='password' id='pwd2' required />
				<div id='pwd2ck'></div>
				닉네임 : <input type='text' name='nick' id='nick'
					title='닉네임은 사이트 활동에 사용됩니다.' maxlength='12' required>
				<div id='nickck'></div>
				<input type='button' id='nickconfirm' value='닉네임 중복확인' /> <br>
				은행명 : <select name='bank' id='bank'>
					<option value='국민은행'>국민은행</option>
					<option value='농협'>농협</option>
					<option value='기업은행'>ibk기업은행</option>
					<option value='신한은행'>신한은행</option>
					<option value='우리은행'>우리은행</option>
					<option value='카카오뱅크'>카카오뱅크</option>
				</select> <br> 계좌번호 <input type='text' id='actnum' required
					title='- 을 제외하고 입력해주세요.' /> 예금주 <input type='text'
					id='actname' value='' required />
				<div id='actck'></div>
				<input type='button' id='actconfirm' value='계좌정보 인증' /> <br>
				이용약관 방침 <input type='button' id='service' value='동의' /> <br> 개인정보
				처리방침 <input type='button' id='privacy' value='동의' /> <br> <input
					type='submit' id='submit' value='회원가입'>
			</fieldset>
		</form>
	</div>
</body>
</html>