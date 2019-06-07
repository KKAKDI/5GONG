<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Baloo+Bhai'>
<link rel='stylesheet'
	href='https://fonts.googleapis.com/css?family=Jua&amp;subset=korean'>

<title>Take A Look</title>

</head>

<body>
	<div class='container'>
		<header id='header'>
			<div class='title'>
				<img src='img/icon.png'>
				<form name='serch' action='검색서블릿' method='post'>
					<input type='radio' name='serch' value='sell'/>팝니다
					<input type='radio' name='serch' value='buy'/>삽니다				
					<input type='text' name='serchdeal'/>
					<input type='submit' value='검색'>
				</form>
			</div>
			<div class='upper'>
				<%
					String id = (String)session.getAttribute("session_id");
					if(id==null){
				%>
					<a href='login.do?m=in'>로그인</a>
				<%
					}
					else{
				%>
					<a href=''><%=id %> 님</a>
					<a href='#'>회원정보수정</a>
				<%
					}
				%>
					<a href='login.do?m=out'>로그아웃</a>
				
			</div>			
	</div>
	<div id='GNBBOX'>
		<nav id='GNB' class='clearfix'>
			<ul>
				<li><a href='index.do'>새소식</a></li>
				<li><a href=''>중고거래</a></li>
				<li><a href=''>자유게시판</a></li>
				<li><a href=''>고객센터</a></li>
			</ul>
	</div>

	</header>
	<div class='container clearfix'>
		<section id='content'>
			<div class='data_box'>

			</div>
		</section>
	</div>
	<footer id='footer' class='clearfix'>
		<div class='footerinner'>
			<div class='copyright'>
				<p>COPYRIGHT 5GONG ALL RIGHTS RESERVED.</p>
			</div>
			<p class='contact_k'>BITCAMP 119 GROUP 5GONG</p>
		</div>
	</footer>
</body>
</html>
