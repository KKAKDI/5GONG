<%@ page contentType="text/html;charset=utf-8" import="java.util.*,tkl.board.model.BoardDTO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta charset='utf-8'>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

<center>
 <link type="text/css" rel="stylesheet" href="/_css/_comm.min.css?v=190401">
        <link type="text/css" rel="stylesheet" href="/_head_tail/css/_head_comm.css?v=190610">
        	<link type='text/css' rel='stylesheet' href='css/view.css?v=190326'>

        	


<hr>
<h2>거래 창</h2>
&nbsp;&nbsp;&nbsp;
<a href='board.do?m=board_input'>글쓰기</a>
&nbsp;&nbsp;&nbsp;
<a href='index.jsp'>인덱스</a>
<hr width='600' size='2' noshade>
</center>
<script language="javascript">
function check() {
    if (document.search.keyWord.value == "") {
        alert("검색어를 입력하세요.");
        document.search.keyWord.focus();
        return;
    }
    document.search.submit();
}
	</script>
	<script>
   function logout(){
      location.href="sign_in.jsp";
   }
   <%
   
   String sessionNick  = (String)session.getAttribute("session_nick");
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
   </script>   
   <style>
form{
	 margin: 0 auto;
    width: 400px;
    /* To see the outline of the form */
    padding: 1em;
    border: 1px solid #CCC;
    border-radius: 1em;
}
form div + div{
margin-top: 1em;
}
</style>
 <div style="margin-top:15px;text-align:center;"></div>
    <div class="g_content">
        <div class="g_title_blue">
        </div>
        <a name="top"></a>
        <form name="frmSell" id="frmSell">
            <div class="g_subtitle">물품정보</div>
            <table class="g_blue_table">
                <colgroup>
                    <col width="160">
                    <col width="250">
                    <col width="160">
                    <col />
                </colgroup>
                <tr>
                    <th>진행상태</th>
                    <td colspan="3">${dto.pd_status}</td>
                </tr>
                <tr>
                    <th>상품명</th>
                    <td colspan="3">
                        ${dto.pd_name}</td>
                </tr>
                                <tr>
                    <th>거래번호</th>
                    <td>${dto.pay_pd_no}</td>
                    <th>등록일시</th>
                    <td>${dto.pm_regdate}</td>
                </tr>
                                    <tr>
                        <th>최소구매수량</th>
                        <td>1 개</td>
                        <th>최대구매수량</th>
                        <td>2 개</td>
                    </tr>
                    <tr>
                        <th>상품가격</th>
                        <td>${dto.pd_price}</td>
                        <th>구매할인</th>
                        <td>-</td>
                    </tr>
                                </table>
        </form>
         <div style="margin-top:15px;text-align:center;"></div>
    <div class="g_content">
        <div class="g_title_blue">
        </div>
        <a name="top"></a>
        <form name="frmSell" id="frmSell">
            <div class="g_subtitle">판매자 정보</div>
            <table class="g_blue_table">
                <colgroup>
                    <col width="160">
                    <col width="250">
                    <col width="160">
                    <col />
                </colgroup>
                <tr>
                    <th>판매자</th>
                    <td colspan="3">${dto.pm_seller}</td>
                </tr>
                <tr>
                    <th>판매자 은행</th>
                    <td colspan="3">
                        ${dto.pm_s_bank}</td>
                </tr>
                                <tr>
                    <th>판매자 계좌번호</th>
                    <td>${dto.pm_s_account}</td>
                </tr>
                                    <tr>
                        <th>배송주소</th>
                        <td>{dto.pm_bchek}</td>
                    </tr>
                                </table>
        </form>
        
            <div class="g_content">
        <div class="g_title_blue">
        </div>
        <a name="top"></a>
        <form name="frmSell" id="frmSell">
            <div class="g_subtitle">구매자 정보</div>
            <table class="g_blue_table">
                <colgroup>
                    <col width="160">
                    <col width="250">
                    <col width="160">
                    <col />
                </colgroup>
                <tr>
                    <th>구매자</th>
                    <td colspan="3">${dto.pm_buyer}</td>
                </tr>
                <tr>
                    <th>구매자 은행</th>
                    <td colspan="3">
                        ${dto.pm_b_bank}</td>
                </tr>
                                <tr>
                    <th>구매자 계좌번호</th>
                    <td>${dto.pm_b_account}</td>
                </tr>
                                    <tr>
                        <th>배송주소</th>
                        <td>{dto.pm_bchek}</td>
                    </tr>
                                </table>
        </form>
         


