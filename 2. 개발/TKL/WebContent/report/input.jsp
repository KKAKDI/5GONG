<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.report.model.ReportDTO"%>

<html>
  <head>
    <title>TKL 신고하기</title>
	<meta charset='utf-8'>
	<link rel='stylesheet' type='text/css' href='../css/style.css'>
	<script language="javascript">
	  function check(){
	    if(document.input.rSubject.value == ""){
		  alert("제목을 입력해주세요");
		  return false;
		}
		if(document.input.rContent.value == ""){
		  alert("내용을 입력해주세요");
		  return false;
		}
		if(document.input.rNick.value == ""){
		  alert("닉네임을 입력해주세요");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  <body onload="input.writer.focus()">
    <center>
	   <hr width="600" size="2" noshade>
	      <h2>TKL 신고하기</h2>
		  <a href='../rBoard.do'>글목록</a>
	   <hr width="600" size="2" noshade>
	</center>
	<form name="input" method="post" action="../rBoard.do?m=in" enctype="multipart/form-data">
	   <table border="1" width="600" align="center"  cellpadding="3" cellspacing="1">
	      <tr>
		     <td width="30%" align="center">닉네임</td>
			 <td align="center"><input type="text" name="rNick" size="60"></td>
		  </tr>
          <tr>
		     <td align="center">제목</td>
			 <td align="center"><input type="text" name="rSubject" size="60"></td>
		  </tr>
		  <tr>
		     <td align="center">신고내용</td>
			 <td align="center"><textarea name="rContent" rows="5" cols="53"></textarea></td>
		  </tr>
		  <tr>
		     <td align="center">파일첨부</td>
			 <td align="center"><input type="file" name="rFile" size="60"></td>
		  </tr>
		  <tr>
		     <td colspan="2" align="center">
			    <input type="button" value="작성하기" onclick="check()">
				<input type="reset" value="다시입력">
			 </td>
		  </tr>
	   </table>
	   <br>
	   <hr width="600" size="2" noshade>
	</form>
  </body>
</html>