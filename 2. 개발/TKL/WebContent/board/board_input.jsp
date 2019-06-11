<%@ page contentType="text/html;charset=utf-8"%>

<meta charset='utf-8'>
<html>
  <head>
     <link type="text/css" rel="stylesheet" href="/_css/_comm.min.css?v=190401">
        <link type="text/css" rel="stylesheet" href="/_head_tail/css/_head_comm.css?v=190610">
        	<link type='text/css' rel='stylesheet' href='css/view.css?v=190326'>
    <title>TKL</title>
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
		document.input.submit();
	  }
	</script>
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
      console.log("session : ${session_email}");   
   <%
      }   
   %>
   </script>   
  </head>
  <center>
  <body>
	    <font><b>글 쓰 기</b></font>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="../board.do">목록</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='../index.jsp'>메인</a>
	  <form name="input" action="../board.do?m=board_in" method="post"
	                                     enctype="multipart/form-data">
	    <table>
		  <tr>
		    <td>제목</td>
			<td>
			  <input type="text" name="bSubject" size="60">
			</td>
		  </tr>
		  <tr>
		    <td>내용</td>
			<td>
			<img id="blah" src="" alt="미리보기" />
			  <textarea name="bContent"></textarea>
			</td>
		  </tr>
		  <tr>
		    <td>작성자</td>
			<td>
			  <input type="text" name="mNick" value='${session_nick}' disabled>
			</td>
		  </tr>
		  <tr>
		    <td>첨부파일</td>
			<td>
			<input type='file' id="imgInp" name="bImg" multiple/><br/>
			</td>
		  </tr>
		  <tr>
		    <td>
			  <input type="button" value="전송하기" onclick="checkValue()">
			  <input type="reset" value="다시쓰기">
			</td>
		  </tr>
		</table>
	  </form>
  </body>
</html>
</center>