/*로그인이 됐다면 $(".dim").css("display":"none"); 스크립트 작성 필요*/

$(document).ready(function(){
  var regEmail = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/i;

  $.fn.getUrlParameter = function (sParam) {
            var sPageURL = decodeURIComponent(window.location.search.substring(1)),
                    sURLVariables = sPageURL.split('&'),
                    sParameterName,
                    i;
            for (i = 0; i < sURLVariables.length; i++) {
                sParameterName = sURLVariables[i].split('=');
                if (sParameterName[0] === sParam) {
                    return sParameterName[1] === undefined ? true : sParameterName[1];
                }
            }
          }
  var type = $.fn.getUrlParameter('e');
  if(type=='1'){
    $("#pwdck").show();
    $("#pwdck").css("color", "red");
    $("#pwdck").text("잘못된 로그인 정보입니다.");
  }

  $("#email").keyup(function(){
		if ( regEmail.test($.trim($("#email").val())) ){
			$("#emailck").css("display", "none");
      $("#email").css("border","1px solid #49ff86");
      return true;
		}else{
			$("#emailck").show();
			$("#emailck").css("color", "red");
			$("#emailck").text("이메일 형식에 맞지 않습니다.");
			return false;
		}
	});
  $("#pwd").keyup(function(){
		var pwd = $("#pwd").val();
		if(pwd.length<8){
      $("#pwdck").show();
      $("#pwdck").css("color", "red");
      $("#pwdck").text("비밀번호는 8자 이상 입력해야합니다.");
      return false;
    }else{
      $("#pwdck").css("display","none");
      $("#pwd").css("border","1px solid #49ff86");
      return true;
    }
	});
  $("#signin").submit(function(){
    var getEmail = $("#email").val();
    var getPwd = $("#pwd").val();

    if(getEmail==""){
      $("#emailck").show();
      $("#emailck").css("color", "red");
      $("#emailck").text("이메일을 입력해주세요.");
      return false;
    }else if(getPwd==""){
      $("#pwdck").show();
      $("#pwdck").css("color", "red");
      $("#pwdck").text("비밀번호를 입력해주세요.");
      return false;
    }else{
      return true;
    }
  });

  $("#signup").click(function(){
    location.href="sign_up.jsp";
  });
  $("#find").click(function(){
    location.href("findMember.jsp");
  });
  $("#kakao").click(function(){

  });
  $("#google").click(function(){

  });
});
