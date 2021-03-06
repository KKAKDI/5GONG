<%@page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>간단한 게시판</title>
<meta charset="utf-8">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/product_reg.css">
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
	$(document).ready(function() {
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader(); //파일을 읽기 위한 FileReader객체 생성
				reader.onload = function(e) {
					//파일 읽어들이기를 성공했을때 호출되는 이벤트 핸들러
					$('#blah').attr('src', e.target.result);
					//이미지 Tag의 SRC속성에 읽어들인 File내용을 지정
					//(아래 코드에서 읽어들인 dataURL형식)
				}
				reader.readAsDataURL(input.files[0]);
				//File내용을 읽어 dataURL형식의 문자열로 저장
			}
		}
		//file 양식으로 이미지를 선택(값이 변경) 되었을때 처리하는 코드
		$("#imgInp").change(function() {
			//alert(this.value); //선택한 이미지 경로 표시
			readURL(this);
		});
	});
	function logout(){
	      location.href="sign_in.jsp";
	}
	<%
	String sessionEmail  = (String)session.getAttribute("session_email");
	String sessionNick  = (String)session.getAttribute("session_nick");
	   if(sessionNick==null){
	%>   
	   alert("session 없음");      
	   Kakao.cleanup();   
	   logout();
	<%       
	   }   
	%>
</script>
</head>
<body>
	<form name="f" method="post" action="../product.do?m=reg" enctype="multipart/form-data">
		<input type='file' id="imgInp" name="pd_img_copy" accept=".jpg, .png" multiple/><br/>
        <input type='hidden' name='pd_nick' value='<%=sessionNick%>'>
        <input type='hidden' name='pd_email' value='<%=sessionEmail%>'>
        <img id="blah" src="#" alt="이미지를 넣어주세요" />
		<table>
			<tr>
				<td>제목 : <input type="text" name="pd_subject"></td>
			</tr>
			<tr>
				<td>상품명 : <input type="text" name="pd_name"></td>
			</tr>
			<tr>
				<td>상품유형 : 
					<select name="pd_class">
						<option value="0">----선택----</option>
						<option value="팝니다">팝니다</option>
						<option value="삽니다">삽니다</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>가격 : <input type="text" name="pd_price"></td>
			</tr>
			<tr>
				<td colspan='2'>글내용 : <textarea name="pd_content" rows="10" cols="60"></textarea></td>
			</tr>
			<tr>
				<td>
				<input type="submit" value="등록"> 
				<input type="reset" value="다시입력">
				</td>
			</tr>
		</table>
		<br>
	</form>
</body>
</html>