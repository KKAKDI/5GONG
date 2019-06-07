<%@ page contentType="text/html;charset=utf-8"%>

<meta charset='utf-8'>
<html>
  <head>
    <title>reboard_write.jsp</title>
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
		if(document.input.eMail.value == "")
		{
		  alert("이메일을 입력해주세요");
		  return false;
		}
		if(document.input.pwd.value == "")
		{
		  alert("비밀번호를 입력해주세요");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  <body>
    <center>
	  <hr>
	    <font><b>글 쓰 기</b></font>
	    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="board.do">목록</a>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href='index.jsp'>메인</a>
	  <hr>
      <!-------------------- re 변화 1 ------------------------------->
	  <form name="input" action="board.do?m=board_in" method="post"
	                                     enctype="multipart/form-data">
	  <!-------------------------------------------------------------->
	    <!-- <input type="hidden"  name="method" value="writeOk"> -->
	    <table align="center" width="600" cellspacing="1" 
		                                  cellpadding="3" border="1">
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
			  <input type="text" name="mNick">
			</td>
		  </tr>
		  <tr>
		    <td>이메일</td>
			<td>
			  <input type="text" name="eMail">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">홈페이지</td>
			<td align="center" width="80%">
			  <input type="text" name="homepage">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">패스워드</td>
			<td align="center" width="80%">
			  <input type="text" name="pwd">
			</td>
		  </tr>
		  <tr>
		    <td align="center" width="20%">첨부파일</td>
			<td align="center" width="80%">
			<input type='file' id="imgInp" name="filename" multiple/><br/>
			  <input type="file" name="bImg">
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
	  <hr>
	</center>
  </body>
</html>