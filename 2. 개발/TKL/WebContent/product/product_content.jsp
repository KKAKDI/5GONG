<%@ page language="java" contentType="text/html; charset=UTF-8" import ="java.util.*, tkl.product.model.ProductDTO"%>
<meta charset='utf-8'>
<!DOCTYPE html>
<html>
<title>상품 상세정보</title>
<head>
<meta charset="utf-8">
		<title>Title</title>
		<style type="text/css">
			table{border:1px solid #333; ; width:1000px; height:500px;}
			tr, th, td {border:1px solid #333;}
		</style>
<body >
	
		<h2>상품 상세정보</h2>
	<center>
	<% 
	ProductDTO dto = (ProductDTO)request.getAttribute("con");
	%>
	<table> 
			<colgroup>
				<col width="50%">
				<col width="25%">
				<col width="25%">
			</colgroup>
			<tbody>
				<tr>
					<td rowspan="5">이미지 :
					 <%=dto.getPd_img()%></td>
					<td colspan="2">상품번호 : 
					<%=dto.getPd_no()%></td>
				</tr>
				<tr>
				<td colspan="2">상품이름 :
				<%=dto.getPd_name()%></td>
				
				</tr>
				<tr>
				<td colspan="2">가격 :
				
				<%=dto.getPd_price()%></td>
				
				</tr>
				<tr>
					 <td>조회수</td>
					 <td>작성시간 : 
					 <%=dto.getPd_regdate()%></td>	
				</tr>
				
				
				<tr>
					<td colspan ="2">
					<input type="button" value="구매하기" onclick="location.href='product.do?m=list' ">
					</td>
				</tr>
				<tr>
					<td colspan="3">댓글</td>
				</tr>
			</tbody>
		</table>
	</center>
</body>
</head>
</html>