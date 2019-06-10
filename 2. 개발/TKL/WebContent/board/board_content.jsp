<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.board.model.BoardDTO,tkl.bReply.model.ReplyDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset='utf-8'>
<link rel="stylesheet" type="text/css" href="http://img.lgeshop.com/css/style_2005.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<html>
  <head>
    <title>reboard_content.jsp</title>
    <script>
   function logout(){
      location.href="sign_in.jsp";
   }
   <%
   
   String sessionNick  = (String)session.getAttribute("session_nick");
   BoardDTO dto = (BoardDTO)request.getAttribute("dto");
   ArrayList<String> rList = (ArrayList<String>)request.getAttribute("likeList"); 
   System.out.println("자바스크립트 bNo : "+dto.getbNo());
      if(sessionNick==null){
   %>   
      alert("session 없음");       
      logout();
   <%       
      }else{
   %>
   console.log("session : ${session_email}");    
   <%
      }   
      
     
   %>
	function checkNick(){
		var mNick = document.getElementById("mNick");
		var sessionNick = '<%=sessionNick%>';
		var bNo = '<%=dto.getbNo()%>';
		var brNo = document.getElementById("brNo");
		console.log(mNick.value);
		console.log(sessionNick);
 		 if(mNick.value==sessionNick){
 			 alert("글이 삭제되었습니다");
 			 location.href='board.do?m=reply_delete&bNo='+bNo+'&brNo='+brNo.value+''
 		 }else{
 			 alert("자신의 글이 아니므로 삭제할 수 없습니다.");
 			 location.href("board.dom?bNo="+bNo);
 		 }
	}
	function checkLike(){
		var sessionNick = '<%=sessionNick%>';
		var Array = '<%=rList%>';*
	}
	
	
   </script>   
  </head>
  
  <body>
	    <font>
		  <b>JSS board</b>
		</font>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href="board.do">목록</a>
		  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  <a href='index.jsp'>메인</a><br/><br/>
		  
		  <td><b>순번 : </b>${dto.bNo}</td><br/><br/>
		  <td><b>날짜 : </b>${dto.bWriteDate}</td><br/><br/>
		  <td><b>글쓴이 : </b>&nbsp;${dto.mNick}</td><br/><br/>
		  <td><b>조회수 : </b>${dto.bView}</td><br/><br/>
		  <td><b>제목 : </b>${dto.bSubject}</td><br/><br/>
		  <td><b>첨부파일</b>: <a href="board.do?m=board_download&bImgCopy=${dto.bImgCopy}">${dto.bImg}</a></td><br/><br/>
		  <td><img src="img//${dto.bImgCopy}"></img>
		  <b>내용 : </b>${dto.bContent}</td><br/><br/>
		  <td>
		  <c:choose>
		  <c:when test='${dto.mNick==session_nick}'>
			 <input type='button' value='편집' onclick="location.href='board.do?m=board_update_form&bNo=${dto.bNo}'">
			<input type='button' value='삭제' onclick="location.href='board.do?m=board_delete&bNo=${dto.bNo}&bImgCopy=${dto.bImgCopy}'">
		 </c:when>
		 <c:otherwise>
		 <input type='button' value='편집' disabled>
		<input type='button' value='삭제' disabled>
		 
		 </c:otherwise>
		 </c:choose>
		  </td>
		  <td>
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
				 <input type="button" value="등록" onclick="check()">
			  </td>
		  </form>
		</tr>
	  </table>
		${dto.bLike}
	<a onclick="return confirm('추천하시겠습니까?')" href="board.do?m=board_like&bNo=${dto.bNo}&brNo=${rDto.brNo}&">추천</a><br/><br/> 
	<b>R E P L Y</b>
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
      <table> 
		 	<c:forEach items="${rList}" var="rDto">
	<td >${rDto.mNick}</td>
	<td> &nbsp;&nbsp;${rDto.brContent}</td>
	<td>${rDto.brWriteDate}</td>
	<!--<td>${rDto.brLike}</td>
	<td>${rDto.brDisLike}</td>-->
	<td> 

		<input type="button" value="삭제" onclick="checkNick()"/>
		<input id="mNick" value="${rDto.mNick}" type="hidden"/>
		<input id="brNo" value="${rDto.brNo}" type="hidden"/>

	</td>
	</tr>
	</c:forEach>
		     <td>
			    
			 </td>
		 </tr>
	  </table>
	  </div>
  </body>
</html>