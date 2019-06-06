<%@ page contentType="text/html;charset=UTF-8" import="tkl.product.model.ProductDTO,tkl.preply.model.PreplyDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>상품 상세정보</title>
<script type="text/javascript">
		function changeView(value)
		{
			if(value == 0)	
				location.href='BoardListAction.bo?page=${pageNum}';
			else if(value == 1)
				location.href='BoardReplyFormAction.bo?num=${board.board_num}&page=${pageNum}';
		}
		
		function doAction(value)
		{
			if(value == 0) // 수정
				location.href="BoardUpdateFormAction.bo?num=${board.board_num}&page=${pageNum}";
			else if(value == 1) // 삭제
				location.href="BoardDeleteAction.bo?num=${board.board_num}";
		}
		

		var httpRequest = null;
		
		// httpRequest 객체 생성
		function getXMLHttpRequest(){
			var httpRequest = null;
		
			if(window.ActiveXObject){
				try{
					httpRequest = new ActiveXObject("Msxml2.XMLHTTP");	
				} catch(e) {
					try{
						httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
					} catch (e2) { httpRequest = null; }
				}
			}
			else if(window.XMLHttpRequest){
				httpRequest = new window.XMLHttpRequest();
			}
			return httpRequest;	
		}
		
		// 댓글 등록
		function writeCmt()
		{
			var form = document.getElementById("writeCommentForm");
			
			var board = form.comment_board.value
			var id = form.comment_id.value
			var content = form.comment_content.value;
			
			if(!content)
			{
				alert("내용을 입력하세요.");
				return false;
			}
			else
			{	
				var param="comment_board="+board+"&comment_id="+id+"&comment_content="+content;
					
				httpRequest = getXMLHttpRequest();
				httpRequest.onreadystatechange = checkFunc;
				httpRequest.open("POST", "CommentWriteAction.co", true);	
				httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=EUC-KR'); 
				httpRequest.send(param);
			}
		}
		
		function checkFunc(){
			if(httpRequest.readyState == 4){
				// 결과값을 가져온다.
				var resultText = httpRequest.responseText;
				if(resultText == 1){ 
					document.location.reload(); // 상세보기 창 새로고침
				}
			}
		}
	
	</script>
</head>
<body>
	<h2>상품 상세정보</h2>
	<a href='product.do?m=update_form&pd_no=${con.pd_no}'>상품수정</a>
	&nbsp;&nbsp;&nbsp;<a href='product.do?m=delete&pd_no=${con.pd_no}&pd_img_copy=${con.pd_img_copy}'>상품삭제</a>
	<table>
		<tr>
			<td rowspan="6"><img src='product.do?m=content_img&pd_img_copy=${con.pd_img_copy}'></td>
			<td colspan="2">상품번호 : ${con.pd_no}</td>
		</tr>
		<tr>
			<td colspan="2">상품유형 : ${con.pd_class}</td>
		</tr>
		<tr>
			<td colspan="2">상품이름 : ${con.pd_name}</td>
		</tr>
		<tr>
			<td colspan="2">가격 : ${con.pd_price}</td>
		</tr>
		<tr>
			<td>조회수 : ${con.pd_view}</td>
		</tr>
		<tr>
			<td>상품등록날짜 : ${con.pd_regdate}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="구매하기"
				onclick="location.href='product.do?m=list' "></td>
		</tr>
	</table>
	<form name="f" method="post" action="product.do?m=reply_in">
		<table>
			<tr>
				<td><input type="hidden" name="method" value="replySave">
					<input type="text" name="content_reply" size="50"> <br />
					&nbsp;&nbsp;비밀번호 : <input type="text" name="pwd_reply" size="10">
					<input type="button" value="등록" onclick="check()"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<th>내용</th>
				<th>작성날짜</th>
			</tr>
			<c:forEach items="${reply_list}" var="dto">
			<tr>
				<td>${dto.m_nick}</td>
				<td>${dto.pr_comment}</td>
				<td>${dto.pr_writedate}</td>
			</tr>
		</c:forEach>
		</table>
	</form>
</body>
</html>