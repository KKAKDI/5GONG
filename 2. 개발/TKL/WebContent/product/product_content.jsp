<%@ page contentType="text/html;charset=UTF-8" import="tkl.product.model.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>상품 상세정보</title>
<style type="text/css">
table {
	border: 1px solid #333;;
	width: 1000px;
	height: 500px;
}

tr, th, td {
	border: 1px solid #333;
}
</style>
</head>
<body>
	<h2>상품 상세정보</h2>
	<table>
			
			<tr>
				<td rowspan="6"><img
					src='product.do?m=con_file&pd_img_copy=${con.pd_img_copy}'></td>
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
				<td>상품등록날짜 : ${con.pd_regdate}</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button"
					value="구매하기" onclick="location.href='product.do?m=list' "></td>
			</tr>
			<tr>
				<td colspan="3">댓글</td>
			</tr>
		
	</table>
</body>
</html>