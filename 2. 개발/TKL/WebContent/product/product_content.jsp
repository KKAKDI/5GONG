<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,tkl.product.model.ProductDTO,tkl.preply.model.PreplyDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>상품 상세정보</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<style>
html {
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 16px;
	font-weight: 400;
}

input[type="button"], input[type="submit"] {
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 16px;
	font-weight: 400;
}

input[type="text"] {
	width: 600px;
	height: 30px;
}

#update_link, #delete_link {
	color: gray;
}

#content_tb, #reply_tb {
	text-align: center;
}

#payblock {
	display: none;
}
</style>
<script>
	function logout() {
		location.href = "sign_in.jsp";
	}
<%String sessionEmail = (String) session.getAttribute("session_email");
			String sessionNick = (String) session.getAttribute("session_nick");
			if (sessionNick == null) {%>
	alert("session 없음");
	Kakao.cleanup();
	logout();
<%}%>
	$(document).ready(function() {
		var flag = true;
		$("#showtable").click(function() {
			if(flag){
				$("#payblock").css("display", "block");
				flag = false;
			}else{
				$("#payblock").css("display", "none");
				flag = true;
			}
			var getNick = "${session_nick}";
			console.log(getNick);
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
							console.log(memlist[i].bank+"/"+memlist[i].actnum);
							$("#bank").text(memlist[i].bank);
							$("#account").text(memlist[i].actnum);
						}else{
							console.log(memlist[i].bank+"/"+memlist[i].actnum);
						}
					}
				}
			});
		});
	});
</script>
</head>
<body>
	<h2>상품 상세정보</h2>
	<a href='product.do'>상품목록</a>
	<c:choose>
		<c:when test="${con.pd_nick eq session_nick}">
			&nbsp;&nbsp;&nbsp;<a
				href='product.do?m=update_form&pd_no=${con.pd_no}'>상품수정</a>
			&nbsp;&nbsp;&nbsp;<a
				href='product.do?m=delete&pd_no=${con.pd_no}&pd_img_copy=${con.pd_img_copy}'>상품삭제</a>
		</c:when>
		<c:otherwise>
			<a id="update_link">상품수정</a>
			<a id="delete_link">상품삭제</a>
		</c:otherwise>
	</c:choose>
	<input type='hidden' name='pd_no' value='${con.pd_no}'>
	<table id="content_tb">
		<tr>
			<td rowspan="10"><img
				src='product.do?m=content_img&pd_img_copy=${con.pd_img_copy}'></td>
			<td colspan="2">상품번호 : ${con.pd_no}</td>
		</tr>
		<tr>
			<td colspan="2">판매자 : ${con.pd_nick}</td>
		</tr>
		<tr>
			<td colspan="2">신뢰도 : ${con.pd_trust}</td>
		</tr>
		<tr>
			<td colspan="2">상품유형 : ${con.pd_class}</td>
		</tr>
		<tr>
			<td colspan="2">진행상태 : ${con.pd_status}</td>
		</tr>
		<tr>
			<td colspan="2">상품명 : ${con.pd_name}</td>
		</tr>
		<tr>
			<td colspan="2">가격 : ${con.pd_price}</td>
		</tr>
		<tr>
			<td>상품등록날짜 : ${con.pd_regdate}</td>
		</tr>
		<tr>
			<td>조회수 : ${con.pd_view}</td>
		</tr>
		<tr>
			<td><input type="button" id="showtable" value="즉시구매"></td>
		</tr>
	</table>
	<div id = payblock>
	<table >
		<form name="f" method="post" action="transfer.do?m=payment">
		<input type='hidden' name='pd_no' value='${con.pd_no}'>	
			<tr>
				<th>구매자</th>
				<th id="buyer" name="buyer">${session_nick}</th>
			</tr>
		<th>구매자은행</th>
		<th id="bank" name="bank"></th>
		<tr>
			<th>구매자계좌</th>
			<th id="account" name="account"></th>
		</tr>
		<tr>
			<th>배송주소</th>
			<th><input type="text" id="addr" name="addr"></th>
		</tr>		
		<tr>
			<td><input type="submit" value="구매요청"></td>
		</tr>
		</form>
	</table>
	</div>
	<form name="f" method="post" action="product.do?m=reply_reg">
		<input type='hidden' name='pd_no' value='${con.pd_no}'> <input
			type='hidden' name='pd_nick' value='<%=sessionNick%>'> <input
			type='hidden' name='pd_email' value='<%=sessionEmail%>'>
		<table id="reply_tb">
			<tr>
				<th>작성자</th>
				<th>내용</th>
				<th>작성날짜</th>
			</tr>
			<c:forEach items="${reply_list}" var="dto">
				<tr>
					<td>${dto.pd_nick}</td>
					<td>${dto.pr_comment}</td>
					<td>${dto.pr_writedate}</td>
					<c:choose>
						<c:when test="${dto.pd_nick eq session_nick}">
							<td><input type="button" value="삭제"
								onclick="location.href='product.do?m=reply_delete&pd_no=${con.pd_no}&pr_no=${dto.pr_no}'">
							</td>
						</c:when>
						<c:otherwise>
							<td><input type="button" value="삭제" disabled></td>
						</c:otherwise>
					</c:choose>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3"><a>[<%=sessionNick%>]
				</a> <input type="text" name="pr_comment"> <input type="submit"
					value="등록"></td>
			</tr>
		</table>
	</form>
</body>
</html>