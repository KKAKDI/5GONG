<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.report.model.ReportDTO"%>

<center>
<html>
  <head>
    <title>TKL 신고하기</title>
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
	<link rel="stylesheet" href="css/reset.css">
	<link rel="stylesheet" href="../css/product_buy_list.css">
	<meta charset='utf-8'>
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
		if(document.input.rClass.value == "0"){
		alert("신고분류를 선택 해주세요");
		  return false;
		}
		document.input.submit();
	  }
	</script>
  </head>
  
  <%
	String sessionNick  = (String)session.getAttribute("session_nick");
  %>
  
  <body onload="input.writer.focus()">
	      <h2>TKL 신고하기</h2>
		  <a href='../rBoard.do'>글목록</a>
	<form name="input" method="post" action="../rBoard.do?m=in" enctype="multipart/form-data">
	   <table>
	      <tr>
		     <td align='center'>닉네임</td>
			 <td><input type="hidden" name="rNick" size="60" value="<%=sessionNick%>"><%=sessionNick%></td>
			 <td>신고분류 : 
					<select name="rClass">
						<option value="0">----선택----</option>
						<option value="사기신고">사기신고</option>
						<option value="불편신고">불편신고</option>
						<option value="허위상품신고">허위상품신고</option>
					</select>
				</td>
		  </tr>
          <tr>
		     <td align='center'>제목</td>
			 <td><input type="text" name="rSubject" size="60"></td>
		  </tr>
		  <tr>
		     <td align='center'>신고내용</td>
			 <td><textarea name="rContent" rows="5" cols="53"></textarea></td>
		  </tr>
		  <tr>
		     <td align='center'>파일첨부</td>
			 <td><input type="file" name="rFile" size="60"></td>
		  </tr>
		  <tr>
		     <td colspan='3' align='center'>
			    <input type="button" value="작성하기" onclick="check()">
				<input type="reset" value="다시입력">
			 </td>
		  </tr>
	   </table>
	   <br>
	</form>
  </body>
</html>
</center>