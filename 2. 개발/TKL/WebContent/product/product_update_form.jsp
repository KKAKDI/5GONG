<%@ page contentType="text/html;charset=UTF-8" import="tkl.product.model.ProductDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="utf-8">
<title>상품 상세정보</title>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
	$(document).ready(function() {
		function readURL(input) {
			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#blah').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}
		$("#imgInp").change(function() {
			readURL(this);
		});
	});
</script>
</head>
<body>
	<h2>상품 수정</h2>
	&nbsp;&nbsp;&nbsp;<a href='product.do'>상품목록</a>
	<form name='f' method='post' action='product.do?m=update&pd_no=${update_form.pd_no}&pd_class=${update_form.pd_class}'>
	<table>
		<tr>
			<td rowspan="7"><input type='file' id="imgInp" name="pd_img_copy" accept=".jpg, .png"/><br/>
        <img id="blah" src="product.do?m=content_img&pd_img_copy=${update_form.pd_img_copy}" alt="이미지" /></td>
			<td colspan="2">상품번호 : ${update_form.pd_no}</td>
		</tr>
		<tr>
			<td colspan="2">상품유형 : ${update_form.pd_class}</td>
		</tr>
		<tr>
			<td colspan="2">상품이름 : <input type='text' name='pd_name'
					value='${update_form.pd_name}'></td>
		</tr>
		<tr>
			<td colspan="2">가격 : <input type='text' name='pd_price'
					value='${update_form.pd_price}'></td>
		</tr>
		<tr>
			<td>상품등록날짜 : ${update_form.pd_regdate}</td>
		</tr>
		<tr>
			<td>조회수 : ${update_form.pd_view}</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="button" value="구매하기"
				onclick="location.href='product.do?m=list' "></td>
		</tr>
		<tr>
			<td colspan='2' align='center'>
				<input type='submit' value='수정하기'>
				<input type="reset" value="다시쓰기">
			</td>
		</tr>
		<tr>
			<td colspan="3">댓글</td>
		</tr>
	</table>
	</form>
</body>
</html>