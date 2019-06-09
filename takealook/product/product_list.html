<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,tkl.product.model.ProductDTO"%>
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
	&nbsp;&nbsp;&nbsp;<a href='./'>메인</a>
	<table>
		<tr>
			<th>상품번호</th>
			<th>진행상태</th>
			<th>제목</th>
			<th>판매자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
<%
   /*
   int pageSizePerBlock = 3;
   int curPage = (Integer)request.getAttribute("currentPage");
   int tableRowNum =(Integer)request.getAttribute("tableRowNum");
   int curBlock = 1;
   if(request.getAttribute("curBlock") != null){
      curBlock = Integer.parseInt(request.getAttribute("curBlock").toString());
   }
   int totalRecodeSize = tableRowNum;
   int curPage1 = curBlock*pageSizePerBlock;
   if(request.getParameter("curPage1") != null) {
      curPage1 = Integer.parseInt(request.getParameter("curPage1"));
   }
   int recodeSizePerPage =2;
   int beginNum = curPage1 * recodeSizePerPage;
   int pageSize = (int)Math.ceil((double)totalRecodeSize/recodeSizePerPage);*/
%>
	<c:forEach var="list" items="${list}" begin="${beginNum}" end="${beginNum+recodeSizePerPage}" step="1">
		<tr>
			<td>${list.pd_no}</td>
			<td>${list.pd_status}</td>
			<td>${list.pd_class}</td>
			<td>
				<a href='product.do?m=content&pd_no=${list.pd_no}'>${list.pd_subject}</a>
				<span style="color: red;">[${list.cnt}]</span>
			</td>
			<td>${list.pd_nick}</td>
			<td>${list.pd_regdate}</td>
			<td>${list.pd_view}</td>
		</tr>
		</c:forEach>

		<!--  
		<c:if test="${list.size() == 0}">
			<tr>
				<td colspan="5">데이터가 없습니다</td>
			</tr>
		</c:if>
		<c:forEach items="${list}" var="dto">
			<tr>
				<td>${dto.pd_no}</td>
				<td>${dto.pd_status}</td>
				<td>
				<span style="color:gray;">[${dto.pd_class}]</span>
				<a href='product.do?m=content&pd_no=${dto.pd_no}'>${dto.pd_subject}</a>
				<c:if test="${dto.cnt != 0}">
				<span style="color:red;">[${dto.cnt}]</span>
				</c:if>
				</td>
				<td>${dto.pd_nick}</td>
				<td>${dto.pd_regdate}</td>
				<td>${dto.pd_view}</td>
			</tr>
		</c:forEach>
		-->
	</table>
	<%
         //if(curBlock >0){
%>
		<c:if test="${curBlock > 0}">
			 <a href ="product.do?curBlock=${curBlock-1}">이전</a>
		</c:if>
        
<%
        // }
         //int startPage = curBlock*pageSizePerBlock;
         //int endPage = startPage + pageSizePerBlock;
         //for(int i =startPage; i<endPage; i++){
         //   if(pageSize<=i) break;
            
%>			
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
        <a href ="product.do?curBlock=${curBlock}&curPage1=${i}">${i+1} | </a>
        </c:forEach>     
<%
        // }
        // if(curBlock < pageSize/pageSizePerBlock){
%>
		<c:if test="${curBlock < (pageSize/pageSizePerBlock)-2}">
			 <a href ="product.do?&curBlock=${curBlock+1}">다음</a>
		</c:if>
		
		
		
<%
        // }
%>
	
</body>
</html>
