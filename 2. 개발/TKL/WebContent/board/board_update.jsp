<%@ page contentType="text/html;charset=utf-8" import="tkl.board.model.BoardDTO"%>

<!DOCTYPE html>
 <link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
 <meta charset='utf-8'>
<html>
  <head>
     <link type="text/css" rel="stylesheet" href="/_css/_comm.min.css?v=190401">
     <link type="text/css" rel="stylesheet" href="/_head_tail/css/_head_comm.css?v=190610">
     <link type='text/css' rel='stylesheet' href='css/view.css?v=190326'>
	<title>reboard_edit.jsp</title>
	<script>
   function logout(){
      location.href="sign_in.jsp";
   }
   <%
   
   String sessionNick  = (String)session.getAttribute("session_nick");
      if(sessionNick==null){
   %>   
      alert("session 없음");      
      Kakao.cleanup();   
      logout();
   <%       
      }else{
   %>         
      alert("session : <%=sessionNick%>");   
   <%
      }   
   %>
   </script>   
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script language="javascript">
    $(document).ready(function(){
        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
                reader.onload = function (e) { 
                //파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
                    $('#blah').attr('src', e.target.result);
                    //이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
                    //(아래 코드에서 읽어들인 dataURL형식)
                }                    
                reader.readAsDataURL(input.files[0]);
                //File내용을 읽어 dataURL형식의 문자열로 저장
            }
        }//readURL()--

        //file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
        $("#imgInp").change(function(){
            //alert(this.value); //선택한 이미지 경로 표시
            readURL(this);
        });
     });
	  function checkValue()
	  {
		if(document.input.bSubject.value == "")
		{
		  alert("제목을 입력해주세요");
		  return false;
		}
		if(document.input.bContent.value == "")
		{
		  alert("내용을 입력해주세요");
		  return false;
		}
		if(document.input.mNick.value == "")
		{
		  alert("이름을 입력해주세요");
		  return false;
		}
		if(document.input.email.value == "")
		{
		  alert("이메일을 입력해주세요");
		  return false;
		}
		if(document.input.pwd.value == "")
		{
		  alert("처음 글의 비밀번호를 입력해주세요");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  <body>
	<center>
	  <hr>
		<font size="5" color="Navy"><b>글 편 집</b></font>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="board.do">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='index.do'>메인</a>
	  <hr>
	  <!------------------------ re 변화 1 --------------------------->
	  <form name="input" action="board.do?m=board_update&bNo=${dto.bNo }" method="post">
	  <!------------------------------------------------------------->
	   <!-- 히든을 이용하여 글 번호를 넘긴다. -->
	   <!-- <input type="hidden" name="idx" value="14"> --> 

		<table align="center" width="600" cellspacing="1" 
										  cellpadding="3" border="1">
		  <tr>
			<td>제목</td>
			<td>
			  <input type="text" name="bSubject" size="60" value="${dto.bSubject}">
			</td>
		  </tr>
		  <tr>
			<td>내용</td>
			<td>
				<img id="blah" src='image//${dto.bImgCopy}' alt="미리보기" />
			  <textarea name="bContent" rows="10" cols="60">${dto.bContent}</textarea>
			</td>
		  </tr>
		  <tr>
			<td>작성자</td>
			<td>
			  <input type="text" name="mNick" size="60" value="${dto.bSubject}">
			</td>
		  </tr>
		  <tr>
			<td>이메일</td>
			<td>
			  <input type="text" name="email" size="60" value="${dto.mEmail} ">
			</td>
		  </tr>
		  <tr>
			<td>홈페이지</td>
			<td>
			  <input type="text" name="homepage" size="60" value="${dto.mEmail}">
			</td>
		  </tr>
		  <tr>
			<td>패스워드</td>
			<td>
			  <input type="text" name="pwd" size="60" value="${dto.mNick}">
			</td>
		  </tr>
		  <tr>
		    <td>첨부파일</td>
			<td>
			<input type='file' id="imgInp" name="bImg" value ='image//${dto.bImg}' multiple/><br/>
			</td>
		  </tr>
			<td>
			  <input type="button" value="전송하기" onclick="checkValue()">
			  <input type="reset" value="다시쓰기">
			</td>
		  </tr>
		</table>
	  </form>
	  <hr>
	</center>
  </body>
</html>