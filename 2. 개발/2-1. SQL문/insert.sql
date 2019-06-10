--회원 (권한 - 0:관리자, 1:일반회원)
insert into MEMBER values('aaa@naver.com', '닉네임1', '0','1q2w3e4r!', '최운학', '국민은행', 111122223333, 01011112222, 1000000, 90, SYSDATE);
insert into MEMBER values('bbb@google.com', '닉네임2', '0','1q2w3e4r!', '곽지훈', '신한은행', 444455556666, 01033334444, 2000000, 100, SYSDATE);
insert into MEMBER values('ccc@daum.net', '닉네임3', '1','1q2w3e4r!', '변정우', '우리은행', 777788889999, 01055556666, 900000, 80, SYSDATE);
insert into MEMBER values('ddd@naver.com', '닉네임4', '1','1q2w3e4r!', '조성식', '카카오뱅크', 123456789012, 01012345678, 800000, 70, SYSDATE);
insert into MEMBER values('eee@google.com', '닉네임5', '1','1q2w3e4r!', '박동진', '기업은행', 987654321234, 01098765432, 700000, 60, SYSDATE);

-- 회원 금융 정보
insert into MONEY_MEMBER values('최운학', '01011112222', '국민은행', '111122223333', '최운학');
insert into MONEY_MEMBER values('곽지훈', '01033334444', '신한은행', '444455556666', '곽지훈');
insert into MONEY_MEMBER values('조성식', '01012345678', '카카오뱅크', '123456789012', '조성식');
insert into MONEY_MEMBER values('변정우', '01055556666', '우리은행', '777788889999', '변정우');
insert into MONEY_MEMBER values('박동진', '01098765432', '기업은행', '987654321234', '박동진');

--상품 (진행상태 - 0:판매중, 1:거래중, 2:거래완료 / 상품유형 - 0:팝니다, 1:삽니다)
--인성팝니다
insert into PRODUCT values(1, 'bit@naver.com', '비트', '판매중', '형규', '아이패드', '팝니다', 500000, '아이패드', '아이패드 50만원에 팝니다', 0, 'iPad.jsp', 'iPad_copy01.jsp',SYSDATE); 
--정신머리 팝니다
insert into PRODUCT values(2, 'king@naver.com', '킹', '판매완료', '인희', '휴대용선풍기', '팝니다', 13000, '휴대용선풍기', '휴대용 선풍기 13000원에 팝니다', 0, 'handifan.jsp', 'handifan_copy02.jsp',SYSDATE);
--영혼팝니다
insert into PRODUCT values(3, 'wunhak@google.com','운학', '판매중', '시욱', '노트북', '팝니다', 700000, '노트북', 'LG gram 70만원에 팝니다', 0, 'gram.jsp', 'gram_copy03.jsp',SYSDATE);
--월요일 팝니다
insert into PRODUCT values(4, 'jihun@google.com','지훈', '거래완료', '채현', '그래픽카드', '팝니다', 600000, '그래픽카드', 'GTX 1080 60만원에 팝니다', 0, 'gtx1080.jsp', 'gtx1080_copy04.jsp',SYSDATE);
--근윽 팝니다
insert into PRODUCT values(5, 'seongsik@naver.com','성식', '판매중', '찬우', '모자', '팝니다', 300000, '모자', '한정판 명품모자 30만원에 팝니다', 0, 'cap.jsp', 'cap_copy05.jsp', SYSDATE);
--출근자 삽니다 
insert into PRODUCT values(6, 'jeongwoo@naver.com','정우', '거래중', '현', '모니터', '삽니다', 250000, '모니터', 'LED모니터 25만원에 삽니다', 0, 'monitor.jsp', 'monitor_copy06.jsp', SYSDATE);
--여포 삽니다
insert into PRODUCT values(7, 'dongjin@daum.net', '동진', '거래완료', '성호', '신발', '삽니다', 150000, '나이키 신발 15만원에 삽니다', 0, 'nike.jsp', 'nike_copy07.jsp', SYSDATE);
--주말 삽니다
insert into PRODUCT values(8, 'fff@naver.com','채연', '거래중', '정인', '컵밥', '삽니다', 20000, '컵밥', '컵밥 20개 2만원에 삽니다', 0, 'cupbab.jsp', 'cupbab_copy08.jsp',SYSDATE);
--머리카락 삽니다
insert into PRODUCT values(9, 'ggg@naver.com','나리', '거래중', '선우' , '노트북', '삽니다', 750000, '노트북', '삼성 시리즈9 75만원에 삽니다', 0, 'series9.jsp', 'series9_copy09.jsp',SYSDATE);
--저는 서울 삽니다
insert into PRODUCT values(10,'hhh@naver.com', '영훈', '판매완료', '현서' , '도서', '삽니다', 20000, '도서', '스프링책 2만원에 삽니다', 0, 'book.jsp', 'book_copy10.jsp',SYSDATE); 
--주말 삽니다
insert into PRODUCT values(11,'iii@google.com','성호','거래중', '성훈', '전자담배', '삽니다', 100000, '전자담배', '전자담배 10만원에 삽니다', 0, 'eleccigr.jsp', 'eleccigr_copy11.jsp',SYSDATE);
--정신머리 팝니다
insert into PRODUCT values(12,'jjj@google.com','현서','판매중', '찬우', '지갑', '팝니다', 500000, '지갑', '구찌지갑 50만원에 팝니다', 0, 'gucci.jsp', 'gucci_copy12.jsp',SYSDATE);
--룰루랄라 삽니다
insert into PRODUCT values(13,'kkk@daum.net','의창', '거래중', '찬우', '벨트', '삽니다', 300000, '벨트', '루이비통벨트 30만원에 팝니다', 0, 'luisvit.jsp', 'luisvit_copy13.jsp',SYSDATE); 
--노래주머니 팝니다
insert into PRODUCT values(14,'lll@daum.net','재현', '판매완료', '찬우', '이어폰','팝니다', 140000, '이어폰','에어팟2 14만원에 팝니다', 0, 'airpod.jsp', 'airpod_copy14.jsp',SYSDATE);
-- 전 잘삽니다
insert into PRODUCT values(15,'mmm@daum.net', '호균', '거래중', '도연', '블루투스스피커', '삽니다', 70000, '블루투스스피커', '블루투스스피커 7만원에 삽니다', 0, 'BTspeaker.jsp', 'BTspeaker_copy15.jsp',SYSDATE);


--결제
insert into PAYMENT values(1, 1, '닉네임3',null, 777788889999, '닉네임4',null, 123456789012, 100000, 100000, SYSDATE, '서울시 양천구 월정로 29길 22 태산주택 502호' , '구매확인', '판매확인');
insert into PAYMENT values(2, 2, '닉네임4',null, 123456789012, null,null, null, 150000, null, SYSDATE, '화곡역 5번 출구', '구매확인', '판매확인');
insert into PAYMENT values(3, 3, '닉네임5',null, 987654321234, '닉네임3',null, 777788889999, 120000, 120000, SYSDATE, '서울대역', '구매안함', '판매확인');
insert into PAYMENT values(4, 4, '닉네임4',null, 123456789012, '닉네임5',null, 987654321234, 80000, 80000, SYSDATE, '비트캠프', '구매확인', '판매안함');

--거래기록
insert into HISTORY values(1, '닉네임5', 987654321234, '닉네임3', 777788889999, 120000, SYSDATE);
insert into HISTORY values(2, '닉네임4', 123456789012, '닉네임5', 987654321234, 80000, SYSDATE);

--상품댓글
insert into P_REPLY values(1, 1, 'ddd@naver.com', '닉네임4', '나이키 운동화 9만에 에눌 가능한가요?', 'b1.png', 'b1_copy.png', SYSDATE);
insert into P_REPLY values(2, 3, 'eee@google.com', '닉네임5', '뉴발란스 운동화 14만에 에눌 가능한가요?', 'b2.png', 'b2_copy.png', SYSDATE);

--신고목록 ( 처리상태 - 0:처리중, 1:처리완료 )
insert into REPORT values(1, '닉네임3 유저 사기 신고', '닉네임3 유저가 상품 내용과 맞지않는 물품을 보내는 사기를 당했습니다', 'a.jpg', 'a_copy.jpg', 'ddd@naver.com', '닉네임4', SYSDATE, '0', '댓글1');
insert into REPORT values(2, '닉네임4 유저 사기 신고', '닉네임5 유저가 물품을 보내지 않습니다', 'b.jpg', 'b_copy.jpg', 'eee@google.com', '닉네임5', SYSDATE, '0', '댓글2');

--새소식 ( 구분 - 0:공지사항, 1:이벤트)
insert into NEWS values(1, 'aaa@naver.com', '닉네임1', '사기 대처 방법', '유저 간 거래 시 사기를 당할 경우 빠르게 신고 바랍니다', 0, SYSDATE, '공지사항');
insert into NEWS values(2, 'bbb@google.com', '닉네임2', '첫 결제 시 수수료 감면 이벤트', '첫 결제 시 수수료를 감면해주는 이벤트를 진행합니다 지금 참여하세요', 0, SYSDATE, '이벤트');

--자유게시판
insert into BOARD values(1, 'ccc@daum.net', '닉네임3', '갤S10 5G', '님들 요새 갤S10 5G 나왔던데 쓸만함?', 'aa.jpg', 'aa_copy01.jpg', 0, 0, SYSDATE, 0);
insert into BOARD values(2, 'ddd@naver.com', '닉네임4', '다이슨 청소기', '다이슨 청소기 중고가도 너무 비싸던데...', 'bb.jpg', 'bb_copy01.jpg', 0, 0, SYSDATE, 0);
insert into BOARD values(3, 'eee@google.com', '닉네임5', '에어팟', '에어팟1이랑 에어팟2 성능 차이 많이남?', null, null, 0, 0, SYSDATE, 0);

--자게댓글
insert into B_REPLY values(1, 1, 'ddd@naver.com', '닉네임4', 'ㅇㅇ갤S10이쁨 근데 아직은 5G는 잘안터지더라', SYSDATE, 'aaa.png', 'aaa_copy01.png', 0, 0,'ddd@naver.com', '닉네임4');
insert into B_REPLY values(2, 2, 'eee@google.com', '닉네임5',  '그냥 중고로 살바엔 새거로 사는게 나을듯', SYSDATE, 'bbb.png', 'bbb_copy01.png', 0, 0, 'ddd@naver.com', '닉네임4');
insert into B_REPLY values(3, 3, 'ccc@daum.net', '닉네임3', '에어팟1 살바엔 에어팟2 사는게 훨씬 이득임', SYSDATE, 'ccc.png', 'ccc_copy01.png', 0, 0, 'ccc@daum.net', '닉네임3');

commit;