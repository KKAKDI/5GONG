<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
   <title>TAKE A LOOK</title>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="initial-scale=1, width=device-width">
   <!-- <link rel="shortcut icon" href="favicon.ico"> -->
   <!-- <link href="https://fonts.googleapis.com/css?family=Titillium+Web:400,600,700" rel="stylesheet"> -->
   <!-- <link rel="stylesheet" href="css/font.css"> -->
   <link rel="stylesheet" href="css/reset.css">
   <link rel="stylesheet" href="css/style.css">
   <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
   <!--[if IE 9]>
	<script src="js/main_ie9.js"></script>
	<script src="js/gnb.js"></script>
	<link rel="stylesheet" href="css/ie9.css">
	<![endif]-->

   <!--[if IE 8]>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv-printshiv.js"></script>
	<script src="js/main_ie8.js"></script>
	<script src="js/gnb.js"></script>
	<link rel="stylesheet" href="css/ie8.css">
	<![endif]-->

   <!--[if gt IE 9]><!-->
   <!-- <script src="js/main.js"></script>
	<script src="js/gnb.js"></script> -->
   <!--<![endif]-->
   <script src="js/main.js"></script>
   <script src="https://developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script>
	function logout(){
		location.href="sign_in.jsp";
	}
	<%	
	String sessionNick  = (String)session.getAttribute("session_nick");
		if(sessionNick==null){
	%>	
		
		Kakao.cleanup();	
		logout();
	<% 		
		}
		%>
	</script>	
</head>

<body>
   <div class="wrap">
      <div id="skip_navi" class="skip_navi">
         <div class="skip_wrap">
            <a href="#content">본문 내용 바로가기</a>
            <a href="#GNB">주 메뉴 바로가기</a>
         </div>
      </div>
      <header id="header" class="clearflx">
         <div class="logo"><a href="index.do"><img src="img/logo.png" alt="logo"></a></div>
         <div class="search">
            <form action="product.do?m=" method="get">
               <div class="search_radio">
                  <input type="radio" id="ra_sell" name="m" value="list_sel">
                  <label for="ra_sell"><span class="span_sell"></span>팝니다</label>
                  <input type="radio" id="ra_buy" name="m" value="list_buy">
                  <label for="ra_buy"><span class="span_buy"></span>삽니다</label>
                  <!--radio 버튼을 숨기고 css로 효과를 label사용 id 부여 후 사용 용도에 맞게 id for 동기화-->
               </div>
               <div class="search_bar">
                  <input type="text" id="search_t" class="search_text" name="" value="" placeholder="아이폰7">
               </div>
               <div class="search_button">
                  <input type="submit" value="검색">
               </div>
            </form>
         </div>
         <div class="location">
            <ul>
               <li><a href=""><%=sessionNick%></a></li>
               <li><a href="">고객센터</a></li>
               <li><a href="member.do?m=out">로그아웃</a></li>
            </ul>
         </div>
      </header>
      <div class="nav_wrap">
         <nav id="GNB">
            <ul>
               <li>
                  <a href="news.do?&m=list">새소식</a>
                  <ul class="sub">
                     <li><a href="news.do?&m=news_notice">공지사항</a></li>
                     <li><a href="news.do?&m=news_event">이벤트</a></li>
                  </ul>
               </li>
               <li>
                  <a href="product.do">중고거래</a>
                  <ul class="sub">
                     <li><a href="product.do">상품목록</a></li>
                     <li><a href="product.do?m=reg_form">상품등록</a></li>                    
                  </ul>
               </li>
               <li>
                  <a href="board.do">자유게시판</a>
                  <ul class="sub">
                     <li><a href="board.do?m=board_list">게시판목록</a></li>
                     <li><a href="board.do?m=board_input">글 작성</a></li>                    
                  </ul>
               </li>
               <li>
                  <a href="rBoard.do">고객센터</a>
                  <ul class="sub">                     
                     <li><a href="rBoard.do">신고목록</a></li>
                     <li><a href="rBoard.do?m=in_form">신고작성</a></li>
                  </ul>
               </li>
            </ul>
         </nav>
         <div class="sub_shadow"></div>
      </div>
      
      <div class="keyvisual">
         <ul class="gallery">
            <li><img src="img/key1.png" alt=""></li>
            <li><img src="img/key2.png" alt=""></li>
            <li><img src="img/key3.png" alt=""></li>
            <li><img src="img/key4.png" alt=""></li>
         </ul>
         <ul class="direction_nav">
            <li class="left"><a href="" title="left"><img src="img/btn_left.png"></a></li>
            <li class="right"><a href="" title="right"><img src="img/btn_right.png"></a></li>
         </ul>
      </div>
   </div>
   <section id="content" class="clearflx">
      <div class="product_area">
         <div class="title_wrap">
            <h1 class="product_title">Take a look!</h1>
         </div>
         <div class="pro_buy">
            <ul>
               <li>
                  <a href="product.do?m=content&pd_no=1">
                     <img src="img/iPad.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>인성 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=2">
                     <img src="img/handifan.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>정신머리 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=3">
                     <img src="img/gram.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>영혼 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=4">
                     <img src="img/gtx1080.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>월요일 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=5">
                     <img src="img/cap.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>근윽 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
            </ul>
         </div>
         <div class="pro_sell">
            <ul>
               <li>
                  <a href="product.do?m=content&pd_no=6">
                     <img src="img/monitor.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>출근자 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=7">
                     <img src="img/nike.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>여포 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=8">
                     <img src="img/cupbab.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>주말 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=9">
                     <img src="img/series9.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>머리카락 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=10">
                     <img src="img/book.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>저는 서울 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
            </ul>
         </div>
         <div class="pro_now">
            <ul>
               <li>
                  <a href="product.do?m=content&pd_no=11">
                     <img src="img/eleccigr.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>주말 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=12">
                     <img src="img/gucci.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>정신머리 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=13">
                     <img src="img/luisvit.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>룰루랄라 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=14">
                     <img src="img/airpod.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>노래주머니 팝니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
               <li>
                  <a href="product.do?m=content&pd_no=15">
                     <img src="img/BTspeaker.jpg" height = '135' width='200' alt="demo">
                     <dl>
                        <dt>전 잘 삽니다</dt>
                        <dd class="comment">댓글</dd>
                        <dd class="comment_int">00</dd>
                        <dd class="contant">연락</dd>
                        <dd class="contant_int">00</dd>
                     </dl>
                  </a>
               </li>
            </ul>
         </div>
      </div>
      <div class="user_area clearflx"">
         <div class=" title_wrap">
         <h1 class="free_title">떼껄룩의 꿀팁!</h1>
      </div>
      <div class="free_board_top">
         <ul>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
         </ul>
      </div>
      <div class="free_board">
         <ul>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
            <li>
               <a href="">글제목</a>
               <dl>
                  <dd class="user_nick">촉촉란</dd>
                  <dd class="regi_date">0000.00.00</dd>
                  <dd class="hits_int">00</dd>
               </dl>
            </li>
         </ul>
      </div>
      </div>
   </section>
   <div class="ad_zone">
      <div class="ad_promo">
         <a href="">프로모션 보러가기</a>
      </div>
   </div>
   <div class="service_area clearflx">
      <div class="notice">
         <dl>
            <dt>Notice</dt>
         </dl>
         <table>
            <tr class=>
               <td><a href="">상반기 프로모션 안내</a></td>
               <td>0000.00.00</td>
            </tr>
            <tr class=>
               <td><a href="">서비스 점검 안내</a></td>
               <td>0000.00.00</td>
            </tr>
            <tr class=>
               <td><a href="">개인정보 처리방침 변경 안내</a></td>
               <td>0000.00.00</td>
            </tr>
         </table>
      </div>
      <div class="qna">
         <dl>
            <dt>Q&A</dt>
            <dd class="sub_dt">친절하게 답변해 드리겠습니다.</dd>
            <dd class="dd_point">02)6203-5370</dd>
            <dd>평일 10:00 ~ 18:00
               <br>점심 12:30 ~ 13:30</dd>
         </dl>
      </div>
      <div class="cs_center">
         <dl>
            <dt>CS Center</dt>
            <dd class="sub_dt">토/일요일, 공휴일 휴무</dd>
            <dd class="dd_point">무엇이든 물어보세요!</dd>
            <dd><a href="">문의하기</a></dd>
         </dl>
      </div>
   </div>

   <footer id="footer">
      <div class="footer_inner">
         <div class="footer_list">
            <ul>
               <li><a href="">이용약관</a></li>
               <li><a href="">개인정보 취급방침</a></li>
               <li><a href="">위치기반서비스 이용약관</a></li>
               <li><a href="">광고주 센터</a></li>
               <li><a href="">신고리스트</a></li>
            </ul>
         </div>
         <small class="txt_copyright">
            Copyright © <a href="https://github.com/KKAKDI/5GONG.git">Team.5GONG</a> All rights reserved.
         </small>
      </div>
   </footer>
</body>

</html>