<%@ page contentType="text/html;charset=UTF-8"
	import="tkl.product.model.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/product_list_buy.css">
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
      }   
   %>
</script> 
</head>
<body>
	<h1>상품 목록</h1>
	<a href='product/product_reg.jsp'>상품등록</a> &nbsp;&nbsp;&nbsp;
	<a href='product.do'>전체</a> &nbsp;&nbsp;&nbsp;
	<a href='product.do?m=list_sel'>팝니다</a> &nbsp;&nbsp;&nbsp;
	<a href='product.do?m=list_buy'>삽니다</a> &nbsp;&nbsp;&nbsp;
	<a href='./'>메인</a>
	<table>
		<tr>
			<th>상품번호</th>
			<th>진행상태</th>
			<th>제목</th>
			<th>판매자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:set var="doneLoop" value="false"/>
		<c:forEach var="list" items="${list}" begin="${beginNum}" end="${beginNum+recodeSizePerPage-1}">
   			<c:if test="${not doneLoop}">
   			<c:if test="${totalRecodeSize <= beginNum}">
     			<c:set var="doneLoop" value="true"/>
			</c:if>
			<tr>
				<td>${list.pd_no}</td>
				<td>${list.pd_status}</td>
				<td>${list.pd_class}</td>
				<td><a href='product.do?m=content&pd_no=${list.pd_no}'>${list.pd_subject}</a>
					<span style="color: red;">[${list.cnt}]</span></td>
				<td>${list.pd_nick}</td>
				<td>${list.pd_regdate}</td>
				<td>${list.pd_view}</td>
			</tr>
			</c:if>
		</c:forEach>
	</table>
	<c:if test="${curBlock > 0}">
		<a href="product.do?curBlock=${curBlock-1}&curPage1=${startPage-1}">◀이전</a>
		<c:if test="${curPage < curPage-1}">
			
		</c:if>
	</c:if>
	<c:set var="doneLoop" value="false"/>
	<c:forEach var="i" begin="${startPage}" end="${endPage-1}">
		<c:if test="${not doneLoop}">
		<a href="product.do?curBlock=${curBlock}&curPage1=${i}">${i+1}</a>
		<c:if test="${pageSize <= (i+1)}">
			<c:set var="doneLoop" value="true"/>
		</c:if>
		</c:if>
	</c:forEach>
	<c:if test="${curBlock < (pageSize/pageSizePerBlock)-1}">
		<a href="product.do?curBlock=${curBlock+1}">다음▶</a>
	</c:if>
</body>
</html>
