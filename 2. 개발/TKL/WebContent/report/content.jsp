<%@ page contentType="text/html; charset=utf-8" import="java.util.*,tkl.report.model.ReportDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<meta charset='utf-8'>
<center>

<iframe id="ifrm_filedown"  
 style="position:absolute;
z-index:1;
visibility:hidden;">
</iframe>


<h2>Simple Board with Servlet(MINI)</h2>
&nbsp;&nbsp;&nbsp;

<a href='rBoard.do?m=in_form'><b>신고하기</b></a>
<hr width='600' size='2' noshade>
<table border='1' width='600' align='center' cellpadding='3'>

<tr>
<td align="center" width="15%"><b>글번호</b></td>
<td align="center" width="15%">${dtoContent.rNO}</td>
<td align="center" width="15%"><b>글쓴이</b></td>
<td align="center" width="20%">${dtoContent.rNick}</td>
<td align="center" width="10%"><b>등록일</b></td>
<td align="center" width="25%">${dtoContent.rWriteDate}</td>
</tr>
<tr>
<td align='center'><b>제목</b></td>
<td colspan="3">${dtoContent.rSubject}</td>
<td align="center" width="15%"><b>처리현황</b></td>
<td align="center" width="35%">${dtoContent.rState}</td>
</tr>
<tr>
<td align='center'><b>글내용</b></td>
<td colspan="5">${dtoContent.rContent}</td>
</tr>

<tr>
<td align='center'><b>첨부파일</b></td>
<td colspan="5"><a href="rBoard.do?m=fileDownLoad&rFile=${dtoContent.rFile}">${dtoContent.rFile}</a></td>

</tr>
</table>
<hr width='600' size='2' noshade>
<b>

<a href='rBoard.do?m=del&rNO=${dtoContent.rNO}&rFile=${dtoContent.rFileCopy}'>삭제</a>

<a href='rBoard.do?m=list'>목록</a>

</b>

<hr width='600' size='2' noshade>
</center>

<table border='1' width='600' align='center' cellpadding='3'>
<tr align="center" id="ta">

<tr>
<td align="center" width="15%"><b>답변</b></td>
<td colspan="5" align="center" width="85%"></td>
</tr>
 </table>
 
