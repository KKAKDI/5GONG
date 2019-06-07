//유효성 검사(이메일 유형, 비밀번호 유형 etc)
//이메일 , 본인, 계좌 JSON 만들어서 인증하기
//인증유효성 검사
$(document).ready(function(){
	var regEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i; //이메일 요휴성검사
	var regName = /^[가-힣]{2,4}$/; //이름 유효성 검사 2~4자 사이
	var regNick = /^[a-z0-9_-]{3,16}$/; //아이디 유효성 검사 316자 사이
	var regTel = /^[0-9]{11}$/; //전화번호 유효성 검사
	var emailCheck = false;
	var phoneCheck = false;
	var pwdCheck = false;
	var nickCheck = false;
	var actCheck = false;
	var terms1Check = false;
	var terms2Check = false;

	$("#email").keyup(function(){
		if ( regEmail.test($.trim($("#email").val())) ){
			$("#emailck").css("display", "none");
		}else{
			$("#emailck").show();
			$("#emailck").css("color", "red");
			$("#emailck").text("이메일 형식에 맞지 않습니다.");
			return false;
		}
	});
	$("#emailconfirm").click(function(){
		var getEmail = $("#email").val();
		$.ajax({
			type:'POST',
			url:'json.do',
			data: {
				"email" : getEmail
					},
			success:function(data){
				var obj = JSON.parse(data);
				var memlist = obj.member;
				for(var i=0;i<memlist.length;i++){
					if(memlist[i].email==getEmail){
						$("#emailck").show();
						$("#emailck").css("color", "red");
						$("#emailck").text("이미 사용중인 이메일 입니다.");
						return;
					}else{
						$("#emailck").show();
						$("#emailck").css("color", "green");
						$("#emailck").text("이메일 인증 완료.");
						emailCheck = true;
					}
				}
			}
		});
	});
	$("#phone").keyup(function(){
		if ( regTel.test($.trim($("#phone").val())) ){
			$("#phoneck").css("display", "none");
		}else{
			$("#phoneck").show();
			$("#phoneck").css("color", "red");
			$("#phoneck").text("핸드폰번호 형식에 맞지 않습니다.");
			return false;
		}
	});
	$("#phoneconfirm").click(function(){
		var getPhone = $("#phone").val();
		$.ajax({
			type:'POST',
			url:'json.do',
			data: {
				"phone" : getPhone
					},
			success:function(data){
				var obj = JSON.parse(data);
				var actlist = obj.actinfo;
				for(var i=0;i<actlist.length;i++){
					if(actlist[i].phone==getPhone){
						$("#namefix").show();
						$("#namefix").css("color", "green");
						$("#namefix").text("본인 인증 완료.");
						$("#name").val(actlist[i].name);
						$("#actname").val(actlist[i].name);
						$("#actname").attr("disabled",true);
						phoneCheck = true;
						return;
					}else{
						$("#namefix").show();
						$("#namefix").css("color", "red");
						$("#namefix").text("본인 인증 실패.");
					}
				}
			}
		});
	});
	$("#nick").keyup(function(){
		 var getNick = $("#nick").val();
			if(getNick==''){
				$("#nickck").show();
				$("#nickck").css("color", "red");
				$("#nickck").text("닉네임을 입력하세요.");
			}else if(getNick.length<2){
				$("#nickck").show();
				$("#nickck").css("color", "red");
				$("#nickck").text("닉네임은 2글자이상 사용가능.");
			}else{
				$("#nickck").css("display", "none");
			}
	});
	$("#nickconfirm").click(function(){
		var getNick = $("#nick").val();
		$.ajax({
			type:'POST',
			url:'json.do',
			data: {
				"nick" : getNick
					},
			success:function(data){
				var obj = JSON.parse(data);
				var memlist = obj.member;
				for(var i=0;i<memlist.length;i++){
					if(memlist[i].nick==getNick){
						$("#nickck").show();
						$("#nickck").css("color", "red");
						$("#nickck").text("닉네임 사용불가능.");
						return;
					}else{
						$("#nickck").show();
						$("#nickck").css("color", "green");
						$("#nickck").text("닉네임 중복확인.");
						nickCheck = true;
					}
				}
			}
		});
	});
	$("#pwd1").keyup(function(){
		var pwd1 = $("#pwd1").val();
		if(!/^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,25}$/.test(pwd1)){
			$("#pwdck").show();
			$("#pwdck").css("color", "red");
			$("#pwdck").text("숫자+영문자+특수문자 조합 8자리 이상 사용해야 합니다.");
		}else{
			$("#pwdck").css("display", "none");
		}
		var ckNumber = pwd1.search(/[0-9]/g);
    var ckEnglish = pwd1.search(/[a-z]/ig);
		if(ckNumber <0 || ckEnglish <0){
			$("#pwdck").show();
			$("#pwdck").css("color", "red");
			$("#pwdck").text("숫자와 영문자를 혼용해야 합니다.");
    }
		if(/(\w)\1\1\1/.test(pwd1)){
			$("#pwdck").show();
			$("#pwdck").css("color", "red");
			$("#pwdck").text("같은 문자를 4번이상 사용할 수 없습니다.");
    }

	});
	$("#pwd2").keyup(function(){
		var pwd1 = $("#pwd1").val();
		var pwd2 = $("#pwd2").val();
		if(pwd2.length==0){
			$("#pwd2ck").show();
			$("#pwd2ck").css("color", "red");
			$("#pwd2ck").text("비밀번호를 입력해주세요.");
		}
		else if(pwd1==pwd2){
			if($("#pwd2ck").css('display')=='none'){
				$("#pwdck").show();
				$("#pwd2ck").css("color", "green");
				$("#pwd2ck").text("비밀번호가 일치합니다.");
				pwdCheck = true;
			}else{
				$("#pwd2ck").css("color", "green");
				$("#pwd2ck").text("비밀번호가 일치합니다.");
				pwdCheck = true;
			}
		}else{
			$("#pwd2ck").show();
			$("#pwd2ck").css("color", "red");
			$("#pwd2ck").text("비밀번호가 불일치합니다.");
		}
	});
	$("#actconfirm").click(function(){
		var getBank = $("#bank").val();
		var getActNum = $("#actnum").val();
		var getActName = $("#actname").val();
		$.ajax({
			type:'POST',
			url:'json.do',
			data: {
				"bank":getBank,
				"actnum":getActNum,
				"actown":getActName
					},
			success:function(data){
				var obj = JSON.parse(data);
				var actlist = obj.actinfo;
				for(var i=0;i<actlist.length;i++){
					if(actlist[i].bank==getBank&&actlist[i].actnum==getActNum&&actlist[i].actown==getActName){
						$("#actck").show();
						$("#actck").css("color", "green");
						$("#actck").text("계좌 인증 완료.");
						actCheck = true;
						return;
					}else{
						$("#actck").show();
						$("#actck").css("color", "red");
						$("#actck").text("계좌정보가 일치하지 않습니다.");
					}
				}
			}
		});
	});
});
