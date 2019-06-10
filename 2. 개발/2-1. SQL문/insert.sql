--회원 (권한 - 0:관리자, 1:일반회원)
insert into MEMBER values('bit@naver.com', '비트','1', '1q2w3e4r!','비트캠프', '국민은행', 134256854943,01055765483 ,1000000, 100, SYSDATE);
insert into MEMBER values('king@naver.com', '킹' ,'0', '1q2w3e4r!','왕', '국민은행' , 138549345934,01047568345,3000000,80, SYSDATE);
insert into MEMBER values('aaa@google.com','운학','0','1q2w3e4r!', '최운학', '국민은행',111122223333,01011112222,2000000,90,SYSDATE);
insert into MEMBER values('bbb@google.com','지훈','0','1q2w3e4r!', '곽지훈','신한은행',444455556666,01033334444,2000000,90,SYSDATE);
insert into MEMBER values('ccc@naver.com','성식','0','1q2w3e4r!', '조성식','카카오뱅크',124578435892,01012345678,2000000,90,SYSDATE);
insert into MEMBER values('ddd@naver.com','정우','0','1q2w3e4r!', '변정우','우리은행',777788889999,01055556666,2000000,90,SYSDATE);
insert into MEMBER values('eee@daum.net', '동진','0','1q2w3e4r!', '박동진','기업은행',987654321234,01098765432,2000000,90,SYSDATE);
insert into MEMBER values('fff@naver.com', '채연' ,'1', '1q2w3e4r!','정채연', '국민은행', 139706594945,01043583223, 2000000, 70 , SYSDATE);
insert into MEMBER values('ggg@naver.com','나리','0', '1q2w3e4r!','김나리', '신한은행' , 448689574056,01065943452,800000, 75,  SYSDATE);
insert into MEMBER values('hhh@naver.com', '영훈' ,'1', '1q2w3e4r!','최영훈', '신한은행', 448658095464,01086747432, 1200000, 85 , SYSDATE);
insert into MEMBER values('iii@google.com','성호' ,'0', '1q2w3e4r!','신성호', '신한은행', 445848794033,01032656473, 600000, 95 ,   SYSDATE);
insert into MEMBER values('jjj@google.com','현서' ,'1', '1q2w3e4r!','정현서', '카카오뱅크', 123869540943,01095663734,800000, 60 , SYSDATE);
insert into MEMBER values('kkk@daum.net','찬우' ,'0', '1q2w3e4r!','정찬우', '카카오뱅크', 124669940345,01067743822,1000000, 75,   SYSDATE);
insert into MEMBER values('lll@daum.net' ,'재현','1', '1q2w3e4r!','김재현', '우리은행', 774583492524,01054783432,1500000, 80, SYSDATE);
insert into MEMBER values('mmm@daum.net', '호균','0', '1q2w3e4r!','이호균', '우리은행',772347543892,01027374234, 2000000, 90 ,  SYSDATE);

-- 회원 금융 정보
insert into MONEY_MEMBER values('최운학', '01011112222', '국민은행', '111122223333', '최운학');
insert into MONEY_MEMBER values('곽지훈', '01033334444', '신한은행', '444455556666', '곽지훈');
insert into MONEY_MEMBER values('조성식', '01012345678', '카카오뱅크', '123456789012', '조성식');
insert into MONEY_MEMBER values('변정우', '01055556666', '우리은행', '777788889999', '변정우');
insert into MONEY_MEMBER values('박동진', '01098765432', '기업은행', '987654321234', '박동진');

--상품 (진행상태 - 0:판매중, 1:거래중, 2:거래완료 / 상품유형 - 0:팝니다, 1:삽니다)
--인성팝니다
insert into PRODUCT values(1, 'bit@naver.com', '비트', 100, '인성팝니다', '형규', '아이패드', '인성', 500000, '아이패드', '아이패드 50만원에 팝니다', 0, 0, 'iPad.jsp', 'iPad_copy01.jsp',SYSDATE); 
--정신머리 팝니다
insert into PRODUCT values(2, 'king@naver.com', '킹', 80, '정신머리팝니다', '인희', '휴대용선풍기', '정신머리', 13000, '휴대용선풍기', '휴대용 선풍기 13000원에 팝니다',1, 0, 'handifan.jsp', 'handifan_copy02.jsp',SYSDATE);
--영혼팝니다
insert into PRODUCT values(3, 'aaa@google.com','운학', 90, '영혼팝니다', '시욱', '노트북', '영혼', 700000, '노트북', 'LG gram 70만원에 팝니다', 0, 0, 'gram.jsp', 'gram_copy03.jsp',SYSDATE);
--월요일 팝니다
insert into PRODUCT values(4, 'bbb@google.com','지훈', 90, '월요일팝니다', '채현', '그래픽카드', '월요일', 600000, '그래픽카드', 'GTX 1080 60만원에 팝니다', 0, 0, 'gtx1080.jsp', 'gtx1080_copy04.jsp',SYSDATE);
--근윽 팝니다
insert into PRODUCT values(5, 'ccc@naver.com','성식', 90, '근윽팝니다', '찬우', '모자', '근윽', 300000, '모자', '한정판 명품모자 30만원에 팝니다', 1, 0, 'cap.jsp', 'cap_copy05.jsp', SYSDATE);
--출근자 삽니다 
insert into PRODUCT values(6, 'ddd@naver.com','정우', 90, '출근자삽니다', '현', '모니터', '출근자', 250000, '모니터', 'LED모니터 25만원에 삽니다', 1, 0, 'monitor.jsp', 'monitor_copy06.jsp', SYSDATE);
--여포 삽니다
insert into PRODUCT values(7, 'eee@daum.net', '동진', 90, '여포삽니다', '성호', '신발', '여포', 150000, '신발','나이키 신발 15만원에 삽니다', 0, 0, 'nike.jsp', 'nike_copy07.jsp', SYSDATE);
--주말 삽니다
insert into PRODUCT values(8, 'fff@naver.com','채연',70, '주말삽니다', '정인',  '컵밥', '주말', 20000, '컵밥', '컵밥 20개 2만원에 삽니다', 1, 0, 'cupbab.jsp', 'cupbab_copy08.jsp',SYSDATE);
--머리카락 삽니다
insert into PRODUCT values(9, 'ggg@naver.com','나리',75, '머리카락삽니다', '선우' ,  '노트북', '머리카락', 750000, '노트북', '삼성 시리즈9 75만원에 삽니다',0, 0, 'series9.jsp', 'series9_copy09.jsp',SYSDATE);
--저는 서울 삽니다
insert into PRODUCT values(10,'hhh@naver.com', '영훈',85, '저는서울삽니다', '현서' , '도서', '저는서울', 20000, '도서', '스프링책 2만원에 삽니다', 1, 0, 'book.jsp', 'book_copy10.jsp',SYSDATE); 
--주말 삽니다
insert into PRODUCT values(11,'iii@google.com','성호',95, '주말삽니다', '성훈',  '전자담배', '주말', 100000, '전자담배', '전자담배 10만원에 삽니다', 1, 0, 'eleccigr.jsp', 'eleccigr_copy11.jsp',SYSDATE);
--정신머리 팝니다
insert into PRODUCT values(12,'jjj@google.com','현서',60,'정신머리팝니다', '찬우',  '지갑', '정신머리', 500000, '지갑', '구찌지갑 50만원에 팝니다', 0, 0, 'gucci.jsp', 'gucci_copy12.jsp',SYSDATE);
--룰루랄라 삽니다
insert into PRODUCT values(13,'kkk@daum.net','찬우',75, '룰루랄라삽니다', '의창',  '벨트', '룰루랄라', 300000, '벨트', '루이비통벨트 30만원에 팝니다', 0, 0, 'luisvit.jsp', 'luisvit_copy13.jsp',SYSDATE); 
--노래주머니 팝니다
insert into PRODUCT values(14,'lll@daum.net','재현',80, '노래주머니팝니다', '찬우',  '이어폰','노래주머니', 140000, '이어폰','에어팟2 14만원에 팝니다', 1, 0, 'airpod.jsp', 'airpod_copy14.jsp',SYSDATE);
-- 전 잘삽니다
insert into PRODUCT values(15,'mmm@daum.net', '호균',90, '전잘삽니다', '도연',  '블루투스스피커', '전잘', 70000, '블루투스스피커', '블루투스스피커 7만원에 삽니다', 1, 0, 'BTspeaker.jsp', 'BTspeaker_copy15.jsp',SYSDATE);


--결제
insert into PAYMENT values(1, 1, '비트', '국민은행', 134256854943, '형규', null, 123456789012, 500000, 500000, SYSDATE, '서울시 양천구 월정로 29길 22 태산주택 502호' , '구매확인', '판매확인');
insert into PAYMENT values(2, 2, '킹','국민은행', 138549345934, '인희',null, null, 13000, 13000, SYSDATE, '화곡역 5번 출구', '구매확인', '판매확인');
insert into PAYMENT values(3, 3, '운학','국민은행', 111122223333, '시욱',null, 777788889999, 700000, 700000, SYSDATE, '서울대역', '구매안함', '판매확인');
insert into PAYMENT values(4, 4, '지훈','신한은행', 444455556666, '채현',null, 987654321234, 600000, 600000, SYSDATE, '비트캠프', '구매확인', '판매안함');

--거래기록
insert into HISTORY values(1, '비트', 1342568574943, '형규', 123456789012, 500000, SYSDATE);
insert into HISTORY values(2, '킹', 138549345934, '인희', null, 13000, SYSDATE);

--상품댓글
insert into P_REPLY values(1, 1, 'bit@naver.com', '비트', '아이패드 3만원 할인가능한가요?', 'iPad.png', 'iPad_copy01.png', SYSDATE);
insert into P_REPLY values(2, 3, 'aaa@google.com', '운학', '직거래하면 만원 빼주시나요?', 'gram.jsp', 'gram_copy03.jsp', SYSDATE);


--신고목록
insert into REPORT values(1, '비트 유저 사기 신고', '비트 유저가 상품 내용과 맞지않는 물품을 보내는 사기를 당했습니다', 'iPad.png', 'iPad_copy01.png', 'bit@naver.com', '비트', SYSDATE, '처리중', '댓글1', '사기신고');
insert into REPORT values(2, '운학 유저 사기 신고', '운학 유저가 물품을 보내지 않습니다', 'gram.jsp', 'gram_copy03.jsp', 'aaa@google.com', '운학', SYSDATE, '처리중', '댓글2', '사기신고');

--새소식 ( 구분 - 0:공지사항, 1:이벤트)
insert into NEWS values(1, 'aaa@naver.com', '운학', '사기 대처 방법', '유저 간 거래 시 사기를 당할 경우 빠르게 신고 바랍니다', 0, SYSDATE, '공지사항');
insert into NEWS values(2, 'bbb@google.com', '지훈', '첫 결제 시 수수료 감면 이벤트', '첫 결제 시 수수료를 감면해주는 이벤트를 진행합니다 지금 참여하세요', 0, SYSDATE, '이벤트');

--자유게시판
insert into BOARD values(1, 'aaa@google.com', '운학', '갤S10 5G', '님들 요새 갤S10 5G 나왔던데 쓸만함?', 'aa.jpg', 'aa_copy01.jpg', 0, 0, SYSDATE, 0);
insert into BOARD values(2, 'bbb@google.com', '지훈', '다이슨 청소기', '다이슨 청소기 중고가도 너무 비싸던데...', 'bb.jpg', 'bb_copy01.jpg', 0, 0, SYSDATE, 0);
insert into BOARD values(3, 'ccc@naver.com', '성식', '에어팟', '에어팟1이랑 에어팟2 성능 차이 많이남?', null, null, 0, 0, SYSDATE, 0);
insert into BOARD values(4, 'ddd@naver.com', '정우', '그램','그램 30만원에 싸게 매입합니다' , null, null,0, 0, SYSDATE, 0);
insert into BOARD values(5, 'eee@daum.net', '동진','데스크탑','컴퓨터 장비 싸게 매입합니다 문의주세여',null, null, 0, 0, SYSDATE, 0);
insert into BOARD values(6, 'fff@naver.com', '채연','컵밥', '컵밥은 중고로 판매 안하나요?',null, null, 0, 0, SYSDATE, 0);
insert into BOARD values(7, 'ggg@naver.com', '나리','닌텐도', '닌텐도 스위치 가장 싼 가격이 얼마인가요?',null, null,0, 0, SYSDATE, 0);
insert into BOARD values(8, 'hhh@naver.com', '영훈','풋살화', '풋살화 싸게 팝니다 문의주세요',null, null, 0, 0, SYSDATE, 0);
insert into BOARD values(9, 'iii@google.com', '성호','전자담배', '전자담배 팔아요 종류별로있습니다 문의주세요',null, null, 0, 0, SYSDATE, 0);
insert into BOARD values(10, 'jjj@google.com', '현서','노트북', '요즘 가성비 좋은 노트북 종류가 뭐가있나요?',null, null, 0, 0, SYSDATE, 0);

--자게댓글
insert into B_REPLY values(1, 1, 'bbb@google.com', '지훈', 'ㅇㅇ갤S10이쁨 근데 아직은 5G는 잘안터지더라', SYSDATE, 'aaa.png', 'aaa_copy01.png', 0, 0,'bbb@naver.com', '지훈');
insert into B_REPLY values(2, 2, 'iii@google.com', '성호',  '그냥 중고로 살바엔 새거로 사는게 훨씬 이득입니다', SYSDATE, 'bbb.png', 'bbb_copy01.png', 0, 0, 'iii@google.com', '성호');
insert into B_REPLY values(3, 3, 'hhh@naver.com', '영훈', '에어팟1 살바엔 에어팟2 사는게 훨씬 이득임', SYSDATE, 'ccc.png', 'ccc_copy01.png', 0, 0, 'hhh@naver.com', '영훈');

commit;