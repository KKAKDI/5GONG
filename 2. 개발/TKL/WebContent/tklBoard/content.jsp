<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.board.model.BoardDTO"%>
<meta charset='utf-8'>
<center>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">
<html>
  <head>
    <title>reboard_content.jsp</title>

  </head>
  <body>
    <center>
	  <hr width="600" color="Maroon" size="2" noshade>
	    <font size="5" color="Navy">
		  <b>JSS board</b>
		</font>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="jboard.do">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='index.do'>메인</a>
		  
	  <hr width="600" color="Maroon" size="2" noshade>
	  
	  
<%
	BoardDTO dto = (BoardDTO)request.getAttribute("dto");

%>


	  <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1" id="table">
		<tr>
		  <td align="center" width="15%"><b>순번</b></td>
		  <td align="center" width="35%">&nbsp;<%=dto.getIdx() %></td>
		  <td align="center" width="15%"><b>날짜</b></td>
		  <td align="center" width="35%">
			&nbsp;<%=dto.getWritedate() %>
		  </td>
		</tr>
		<tr>
		  <td align="center" width="15%"><b>글쓴이</b></td>
		  <td align="center" width="35%">
			&nbsp; <%=dto.getWriter() %>
	      </td>
		  <td align="center" width="15%"><b>HomePage</b></td>
		  <td align="center" width="35%">
		    &nbsp;<%=dto.getHomepage() %>
		  </td>
		</tr>
		<tr>
		  <td colspan="3">&nbsp;</td>
		  <td><b>조회수</b> : <%=dto.getReadnum() %></td>
		</tr>
		<tr>
		  <td colspan="2"><b>제목</b> : <%=dto.getSubject() %></td>
		  <td colspan="2"><b>첨부파일</b>: <a href="jboard/download.jsp?filename=<%=dto.getFilename()%>"><%=dto.getOfilename() %></a>

		  </td>
		</tr>
		<tr>

		  <td colspan="4"><%=dto.getContent() %></td>
		</tr>
		<tr>
		  <td colspan="4" align="center">
		    <hr width="550" color="Maroon" size="2" noshade>
			<!----------------- re 변화 2 ---------------->
			<a href="jboard.do?method=list">목록</a> | 
			<a href="jboard.do?m=updateForm&idx=<%=dto.getIdx()%>">편집</a> | 
			<a href="jboard.do?m=deleteForm&idx=<%=dto.getIdx()%>">삭제</a> | 
			<a href="jboard.do?m=reply&idx=<%=dto.getIdx()%>&subject=<%=dto.getSubject()%>">답변</a>
		    <!-- <a href=
	"reboard_rewrite.jsp?idx=13&ref=9&lev=0&sunbun=0&cp=1">
			  답변
		    </a> -->
			
			<!-------------------------------------------->
		  </td>
		</tr>
		<tr align="center" id="ta">
		  <td>
		     리플달기 
		  </td>

          <script language="javascript">
              function check()
              {

                  	  f1.submit();

              }
          </script>
		  <form name="f1" action="jboard.do?m=reply_check&idx=<%=dto.getIdx() %>&writer=<%=dto.getWriter() %>" method="post">
			  <td colspan="3">
			     <input type="hidden" name="method" value="replySave">
				 <input type="text" name="content_reply" size="50">
				 &nbsp;&nbsp;비밀번호
				 <input type="text" name="pwd_reply" size="10">
				 <input type="button" value="등록" onclick="check()">
			  </td>
		  </form>
		</tr>
	  </table>
	  
	  <br><hr width="600" color="Maroon" size="2" noshade><br>
	  
	  
<script language="javascript">     
      function replyDelCheck(idx_reply)
      {
          //alert("loginJs : " + loginJs);
          //alert("idx_reply : " + idx_reply);
          if(!loginJs) //로그인 안함 
          {
             
             alert("로그인 or 리플의 비밀번호를 입력하셔야 합니다.");
             yesNo = confirm("로그인을 하시겠습니까?");
             if(yesNo)
             {
                  location.href="/M2Project/login.do";   
      
             }
             else
             {
                   pwd_reply = prompt("리플 비밀번호를 입력해주세요..");
                   location.href ="/M2Project/rb-reply-del.do?method=replyDel"
                        +"&idx_reply="+idx_reply+"&pwd_reply="+pwd_reply;
             }
          }
          else  // 로그인 함 
          {
               location.href ="/M2Project/rb-reply-del.do?method=replyDel"
                        +"&idx_reply="+idx_reply;
          }
      }
</script>
		
      <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1"> 
		 <tr align="center">
		     <td colspan="2">
			    <font color="red"><b>R E P L Y</b></font>
			 </td>
		 </tr>
		 
<%
		ArrayList<ReplyDTO> rdto = (ArrayList<ReplyDTO>)request.getAttribute("list");
		for(ReplyDTO temp : rdto){			
%>
                     <tr align="center">
                       <td width="90%">

		<%=temp.getReplyContent()%><br>
		(writer:<%=temp.getReplyId()%>, writedate:<%=temp.getReplyDate()%>)

					   </td>
					   <td width="10%"> 
					     <a href="jboard.do?m=secretIn&replyIdx=<%=temp.getIdx()%>&idx=<%=dto.getIdx() %>&"> 삭제</a>
					   </td>
				     <tr>    
<%
		}
%>


	  </table>
	  </div>
	</center>
  </body>
</html>


