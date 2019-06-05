<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Take A Look Sign Up</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style>
	#pwdck{display:none;}
	#nickck{display:none;}
	#signupform{width:220px; margin:auto;}
</style>
<script>

$(document).ready(function(){ 
	$("#emailconfirm").click(function(){
		alert("이메일 인증완료");
	});
	$("#nickconfirm").click(function(){		
		getNick = $("#nick").val();		
		if(getNick==''){
			alert("닉네임을 입력하세요.");
			return;
		}
		$.ajax({
			type:'POST',
			url:'signUp.do',
			data: {
				"nick" : getNick
					},
			success:function(data){
				var obj = JSON.parse(data);
				var memlist = obj.member;
				for(var i=0;i<memlist.length;i++){
					console.log(memlist[i].nick);
					if(memlist[i].nick==getNick){
						jQuery("#nickck").show();
						$("#nickck").css("color", "red");
						$("#nickck").text("닉네임 사용불가능.");
					}else{
						jQuery("#nickck").show();
						$("#nickck").css("color", "green");
						$("#nickck").text("닉네임 사용가능.");
					}
				}		
			}			
		});
	});	
	$("#pwd2").focusout(function(){
		var pwd1 = $("#pwd1").val();
		var pwd2 = $("#pwd2").val();
		if(pwd1==pwd2){
			if($("#pwdck").css('display')=='none'){
				jQuery("#pwdck").show();
				$("#pwdck").css("color", "green");
				$("#pwdck").text("비밀번호가 일치합니다.");			
			}else{
				$("#pwdck").css("color", "green");
				$("#pwdck").text("비밀번호가 일치합니다.");			
			}			
		}else{			
			jQuery("#pwdck").show();
			$("#pwdck").css("color", "red");
			$("#pwdck").text("비밀번호가 불일치합니다.");
		}
	});
	
});
</script>
</head>
<body>
	<div id='signupform'>
	<form name='signup' action='가입서블릿' method='post'>
	 <fieldset>
	<legend> 회 원 가 입 </legend>
		이메일
		<input type='text' name='email' id='email' title='이메일은 ID로 사용됩니다.' maxlength = '40' autofocus required> 
		<input type='button' id='emailconfirm' value='이메일 인증'/>
		<br>
		<!-- 비밀번호 체크 쿼리 필요 -->
		비밀번호
		<input type='password' id='pwd1' required/>		
		<br>
		비밀번호 확인
		<input type='password' id='pwd2' required/> 	
		<div id='pwdck'></div> 		
		 닉네임 :
		<input type='text' name='nick' id='nick' title='닉네임은 사이트 활동에 사용됩니다.' maxlength = '12' required> 
		<div id='nickck'></div>
		<input type='button' id='nickconfirm' value='닉네임 중복확인'/>
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
		계좌번호
		<input type='text' id='accountnum' required title='- 을 제외하고 입력해주세요.'/> 
		예금주
		<input type='text' id='accountname' required/> 
		<br>
		핸드폰번호
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
	</div>
</body>
</html>