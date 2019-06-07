<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.board.model.BoardDTO,tkl.bReply.model.ReplyDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset='utf-8'>
<center>
<link rel="stylesheet" type="text/css" href="http://image.lgeshop.com/css/style_2005.css">

<html>
  <head>
    <title>reboard_content.jsp</title>
  </head>
  
  <body>
    <center>
	  <hr>
	    <font>
		  <b>JSS board</b>
		</font>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="board.do">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='index.jsp'>메인</a>
	  <hr>
	  <table align="center" width="600" cellspacing="1" 
	                          cellpadding="3" border="1" id="table">
		<tr>
		  <td align="center" width="15%"><b>순번</b></td>
		  <td align="center" width="35%">&nbsp;${dto.bNo}</td>
		  <td align="center" width="15%"><b>날짜</b></td>
		  <td align="center" width="35%">
			&nbsp;${dto.bContent}
		  </td>
		</tr>
		<tr>
		  <td><b>글쓴이</b></td>
		  <td>
			&nbsp;${dto.mNick}
	      </td>
		  <td><b>HomePage</b></td>
		  <td>
		    &nbsp;${dto.mNick}
		  </td>
		</tr>
		<tr>
		  <td>&nbsp;</td>
		  <td><b>조회수</b> : ${dto.bView}</td>
		</tr>
		<tr>
		  <td><b>제목</b> : ${dto.bSubject}</td>
		  <td><b>첨부파일</b>: <a href="board.do?m=board_download&bImgCopy=${dto.bImgCopy}">${dto.bImg}</a>

		  </td>
		</tr>
		<tr>

		  <td><img src="image//${dto.bImg}"></img>
		  <br/>${dto.bContent}</td>
		</tr>
		<tr>
		  <td>
		    <hr>
			<!----------------- re 변화 2 ----------------> 
			<a href="board.do?m=board_update_form&bNo=${dto.bNo}">편집</a> | 
			<a href="board.do?m=board_delete&bNo=${dto.bNo}&bImgCopy=${dto.bImgCopy}">삭제</a>  
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
		  <form name="f1" action="board.do?m=replyIn&bNo=${dto.bNo}" method="post">
			  <td colspan="3">
			     <input type="hidden" name="method" value="replySave">
				 <input type="text" name="brContent" size="50">
				 &nbsp;&nbsp;비밀번호
				 <input type="text" name="pwd_reply" size="10">
				 <input type="button" value="등록" onclick="check()">
			  </td>
		  </form>
		</tr>
	  </table>
	  
	  <br><hr width="600" color="Maroon" size="2" noshade><br>
	  <!-- 추천 및 삭제 폼 -->
		${dto.bLike}
<div class="row">

<div class="col-lg-6 mt-3">
	
	<a onclick="return confirm('추천하시겠습니까?')" href="board.do?m=board_like&bNo=${dto.bNo}&brNo=${rDto.brNo}&">추천</a> 
</div>
</div>
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
		 <tr>
		 	<c:forEach items="${rList}" var="rDto">
	
	
	<tr>
	<td>${rDto.mNick}</td>
	<td>${rDto.brContent}</td>
	<td>${rDto.brWriteDate}</td>
	<td>${rDto.brLike}</td>
	<td>${rDto.brDisLike}</td>
	<td width="10%"> 
		<a href="board.do?m=reply_delete&bNo=${dto.bNo}&brNo=${rDto.brNo}&"> 삭제</a>
	</td>
	</tr>
	</c:forEach>
		     <td>
			    <font><b>R E P L Y</b></font>
			 </td>
		 </tr>
	  </table>
	  </div>
	</center>
  </body>
</html>