<%@ page contentType="text/html;charset=UTF-8" import="tkl.product.model.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>중고상품 목록</title>
</head>
<body>
	<h1>중고상품 목록</h1>
	<a href='product/product_reg.jsp'>상품등록</a>
	&nbsp;&nbsp;&nbsp;<a href='product.do'>전체</a>
	&nbsp;&nbsp;&nbsp;<a href='product.do?&m=list_sel'>팝니다</a>
	&nbsp;&nbsp;&nbsp;<a href='product.do?&m=list_buy'>삽니다</a>
	<table>
		<tr>
			<th>상품번호</th>
			<th>진행상태</th>
			<th>제목</th>
			<th>판매자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<c:if test="${list_sel.size() == 0}">
			<tr>
				<td colspan="5">데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${list_sel}" var="dto">
			<tr>
				<td>${dto.pd_no}</td>
				<td>${dto.pd_status}</td>
				<td>
				<span id="a" style="color:gray;">[${dto.pd_class}]</span>
				<a href='product.do?m=content&pd_no=${dto.pd_no}'>${dto.pd_subject}</a>
				<c:if test="${dto.cnt != 0}">
				<span id="a" style="color:red;">[${dto.cnt}]</span>
				</c:if>
				</td>
				<td>${dto.pd_nick}</td>
				<td>${dto.pd_regdate}</td>
				<td>${dto.pd_view}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
