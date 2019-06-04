<%@ page contentType="text/html;charset=UTF-8" import="tkl.product.model.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>중고상품 목록</title>
</head>
<body>
	<h1>
		중고상품 목록
	</h1>
	<div align='right'>
	<a href='product/product_reg.jsp'>상품등록</a>
	&nbsp;&nbsp;&nbsp; <a href='product/product_update.jsp'>상품수정</a>
	</div>
	<table>
		<tr>
			<th align='center' width='10%'>상품번호</th>
			<th align='center' width='10%'>거래상태</th>
			<th align='center' width='10%'>제목</th>
			<th align='center' width='10%'>판매자</th>
			<th align='center' width='10%'>등록일</th>
		</tr>
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5" align="center">데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td align='center'>${dto.pd_no}</td>
			<td align='center'>${dto.pd_status}</td>
			<td align='center'><a href="product.do?m=con&pd_no=${dto.pd_no}">${dto.pd_subject} </a></td>
			<td align='center'>${dto.pd_nick}</td>
			<td align='center'>${dto.pd_regdate}</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>
