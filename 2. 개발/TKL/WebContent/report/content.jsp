<%@ page contentType="text/html; charset=utf-8" import="java.util.*,tkl.report.model.ReportDTO,tkl.member.model.MemberDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>
<meta charset='utf-8'>
<title>${dtoContent.rNick}님의 ${dtoContent.rNO}번 신고내용</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,400,700&display=swap&subset=korean">
<link rel="stylesheet" href="../css/reset.css">

</head>
<iframe id="ifrm_filedown"  
 style="position:absolute;
z-index:1;
visibility:hidden;">
</iframe>


<h2>Simple Board with Servlet(MINI)</h2>
&nbsp;&nbsp;&nbsp;

<a href='rBoard.do?m=in_form'><b>신고하기</b></a>
<table>

<tr>
<td><b>신고분류</b></td>
<td>${dtoContent.rClass}</td>
<td><b>등록일</b></td>
<td>${dtoContent.rWriteDate}</td>
</tr>
<tr>
<td><b>제목</b></td>
<td>${dtoContent.rSubject}</td>
<td><b>처리현황</b></td>
<td>${dtoContent.rState}</td>
</tr>
<tr>
<td><b>글내용</b></td>
<td>${dtoContent.rContent}</td>
</tr>

<tr>
<td><b>첨부파일</b></td>
<td><a href="rBoard.do?m=fileDownLoad&rFile=${dtoContent.rFile}">${dtoContent.rFile}</a></td>

</tr>
</table>

<b>

<a href='rBoard.do?m=del&rNO=${dtoContent.rNO}&rFile=${dtoContent.rFileCopy}'>삭제</a>

<a href='rBoard.do?m=list'>목록</a>


<%
   String sessionGrant = (String)session.getAttribute("session_grant"); 
	System.out.println("sessionGrant2222 : " + sessionGrant);
      if(sessionGrant.equals("0 ")){
         System.out.println(sessionGrant);
%>   
    <a href='rBoard.do?m=rIn_form&rNO=${dtoContent.rNO}'>답변</a>
<%
   }else{
      
%>
    
<%
   }
%>
</b>

<table>
<tr id="ta">

<tr>
<td><b>답변</b></td>
<td>${dtoContent.rReply}</td>
</tr>
 </table>
 
