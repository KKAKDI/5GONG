--ȸ�� (���� - 0:������, 1:�Ϲ�ȸ��)
insert into MEMBER values('bit@naver.com', '��Ʈ','1', '1q2w3e4r!','��Ʈķ��', '��������', 134256854943,01055765483 ,1000000, 100, SYSDATE);
insert into MEMBER values('king@naver.com', 'ŷ' ,'0', '1q2w3e4r!','��', '��������' , 138549345934,01047568345,3000000,80, SYSDATE);
insert into MEMBER values('wunhak@google.com','����','1','1q2w3e4r!', '�ֿ���', '��������',135473965433,01034538924,2000000,90,SYSDATE);
insert into MEMBER values('jihun@google.com','����','1','1q2w3e4r!', '������','��������',448934759232,01043572484,2000000,90,SYSDATE);
insert into MEMBER values('seongsik@naver.com','����','1','1q2w3e4r!', '������','īī����ũ',124578435892,01013287435,2000000,90,SYSDATE);
insert into MEMBER values('jeongwoo@naver.com','����','1','1q2w3e4r!', '������','�츮����',774357935639,01046328533,2000000,90,SYSDATE);
insert into MEMBER values('dongjin@daum.net', '����','1','1q2w3e4r!', '�ڵ���','īī����ũ',128564694433,01074892342,2000000,90,SYSDATE);
insert into MEMBER values('fff@naver.com', 'ä��' ,'1', '1q2w3e4r!','��ä��', '��������', 139706594945,01043583223, 2000000, 70 , SYSDATE);
insert into MEMBER values('ggg@naver.com','����','0', '1q2w3e4r!','�質��', '��������' , 448689574056,01065943452,800000, 75,  SYSDATE);
insert into MEMBER values('hhh@naver.com', '����' ,'1', '1q2w3e4r!','�ֿ���', '��������', 448658095464,01086747432, 1200000, 85 , SYSDATE);
insert into MEMBER values('iii@google.com','��ȣ' ,'0', '1q2w3e4r!','�ż�ȣ', '��������', 445848794033,01032656473, 600000, 95 ,   SYSDATE);
insert into MEMBER values('jjj@google.com','����' ,'1', '1q2w3e4r!','������', 'īī����ũ', 123869540943,01095663734,800000, 60 , SYSDATE);
insert into MEMBER values('kkk@daum.net','����' ,'0', '1q2w3e4r!','������', 'īī����ũ', 124669940345,01067743822,1000000, 75,   SYSDATE);
insert into MEMBER values('lll@daum.net' ,'����','1', '1q2w3e4r!','������', '�츮����', 774583492524,01054783432,1500000, 80, SYSDATE);
insert into MEMBER values('mmm@daum.net', 'ȣ��','0', '1q2w3e4r!','��ȣ��', '�츮����',772347543892,01027374234, 2000000, 90 ,  SYSDATE);

-- ȸ�� ���� ����
insert into MONEY_MEMBER values('�ֿ���', '01011112222', '��������', '111122223333', '�ֿ���');
insert into MONEY_MEMBER values('������', '01033334444', '��������', '444455556666', '������');
insert into MONEY_MEMBER values('������', '01012345678', 'īī����ũ', '123456789012', '������');
insert into MONEY_MEMBER values('������', '01055556666', '�츮����', '777788889999', '������');
insert into MONEY_MEMBER values('�ڵ���', '01098765432', '�������', '987654321234', '�ڵ���');

--��ǰ (������� - 0:�Ǹ���, 1:�ŷ���, 2:�ŷ��Ϸ� / ��ǰ���� - 0:�˴ϴ�, 1:��ϴ�)
--�μ��˴ϴ�
insert into PRODUCT values(1, 'bit@naver.com', '��Ʈ', 100, '�μ��˴ϴ�', '����', '�����е�', '�μ�', 500000, '�����е�', '�����е� 50������ �˴ϴ�', 0, 0, 'iPad.jsp', 'iPad_copy01.jsp',SYSDATE); 
--���ŸӸ� �˴ϴ�
insert into PRODUCT values(2, 'king@naver.com', 'ŷ', 80, '���ŸӸ��˴ϴ�', '����', '�޴�뼱ǳ��', '���ŸӸ�', 13000, '�޴�뼱ǳ��', '�޴�� ��ǳ�� 13000���� �˴ϴ�',1, 0, 'handifan.jsp', 'handifan_copy02.jsp',SYSDATE);
--��ȥ�˴ϴ�
insert into PRODUCT values(3, 'wunhak@google.com','����', 90, '��ȥ�˴ϴ�', '�ÿ�', '��Ʈ��', '��ȥ', 700000, '��Ʈ��', 'LG gram 70������ �˴ϴ�', 0, 0, 'gram.jsp', 'gram_copy03.jsp',SYSDATE);
--������ �˴ϴ�
insert into PRODUCT values(4, 'jihun@google.com','����', 90, '�������˴ϴ�', 'ä��', '�׷���ī��', '������', 600000, '�׷���ī��', 'GTX 1080 60������ �˴ϴ�', 0, 0, 'gtx1080.jsp', 'gtx1080_copy04.jsp',SYSDATE);
--���� �˴ϴ�
insert into PRODUCT values(5, 'seongsik@naver.com','����', 90, '�����˴ϴ�', '����', '����', '����', 300000, '����', '������ ��ǰ���� 30������ �˴ϴ�', 1, 0, 'cap.jsp', 'cap_copy05.jsp', SYSDATE);
--����� ��ϴ� 
insert into PRODUCT values(6, 'jeongwoo@naver.com','����', 90, '����ڻ�ϴ�', '��', '�����', '�����', 250000, '�����', 'LED����� 25������ ��ϴ�', 1, 0, 'monitor.jsp', 'monitor_copy06.jsp', SYSDATE);
--���� ��ϴ�
insert into PRODUCT values(7, 'dongjin@daum.net', '����', 90, '������ϴ�', '��ȣ', '�Ź�', '����', 150000, '�Ź�','����Ű �Ź� 15������ ��ϴ�', 0, 0, 'nike.jsp', 'nike_copy07.jsp', SYSDATE);
--�ָ� ��ϴ�
insert into PRODUCT values(8, 'fff@naver.com','ä��',70, '�ָ���ϴ�', '����',  '�Ź�', '�ָ�', 20000, '�Ź�', '�Ź� 20�� 2������ ��ϴ�', 1, 0, 'cupbab.jsp', 'cupbab_copy08.jsp',SYSDATE);
--�Ӹ�ī�� ��ϴ�
insert into PRODUCT values(9, 'ggg@naver.com','����',75, '�Ӹ�ī����ϴ�', '����' ,  '��Ʈ��', '�Ӹ�ī��', 750000, '��Ʈ��', '�Ｚ �ø���9 75������ ��ϴ�',0, 0, 'series9.jsp', 'series9_copy09.jsp',SYSDATE);
--���� ���� ��ϴ�
insert into PRODUCT values(10,'hhh@naver.com', '����',85, '���¼����ϴ�', '����' , '����', '���¼���', 20000, '����', '������å 2������ ��ϴ�', 1, 0, 'book.jsp', 'book_copy10.jsp',SYSDATE); 
--�ָ� ��ϴ�
insert into PRODUCT values(11,'iii@google.com','��ȣ',95, '�ָ���ϴ�', '����',  '���ڴ��', '�ָ�', 100000, '���ڴ��', '���ڴ�� 10������ ��ϴ�', 1, 0, 'eleccigr.jsp', 'eleccigr_copy11.jsp',SYSDATE);
--���ŸӸ� �˴ϴ�
insert into PRODUCT values(12,'jjj@google.com','����',60,'���ŸӸ��˴ϴ�', '����',  '����', '���ŸӸ�', 500000, '����', '�������� 50������ �˴ϴ�', 0, 0, 'gucci.jsp', 'gucci_copy12.jsp',SYSDATE);
--������ ��ϴ�
insert into PRODUCT values(13,'kkk@daum.net','����',75, '�������ϴ�', '��â',  '��Ʈ', '������', 300000, '��Ʈ', '���̺��뺧Ʈ 30������ �˴ϴ�', 0, 0, 'luisvit.jsp', 'luisvit_copy13.jsp',SYSDATE); 
--�뷡�ָӴ� �˴ϴ�
insert into PRODUCT values(14,'lll@daum.net','����',80, '�뷡�ָӴ��˴ϴ�', '����',  '�̾���','�뷡�ָӴ�', 140000, '�̾���','������2 14������ �˴ϴ�', 1, 0, 'airpod.jsp', 'airpod_copy14.jsp',SYSDATE);
-- �� �߻�ϴ�
insert into PRODUCT values(15,'mmm@daum.net', 'ȣ��',90, '���߻�ϴ�', '����',  '�����������Ŀ', '����', 70000, '�����������Ŀ', '�����������Ŀ 7������ ��ϴ�', 1, 0, 'BTspeaker.jsp', 'BTspeaker_copy15.jsp',SYSDATE);


--����
insert into PAYMENT values(1, 1, '�г���3',null, 777788889999, '�г���4',null, 123456789012, 100000, 100000, SYSDATE, '����� ��õ�� ������ 29�� 22 �»����� 502ȣ' , '����Ȯ��', '�Ǹ�Ȯ��');
insert into PAYMENT values(2, 2, '�г���4',null, 123456789012, null,null, null, 150000, null, SYSDATE, 'ȭ� 5�� �ⱸ', '����Ȯ��', '�Ǹ�Ȯ��');
insert into PAYMENT values(3, 3, '�г���5',null, 987654321234, '�г���3',null, 777788889999, 120000, 120000, SYSDATE, '����뿪', '���ž���', '�Ǹ�Ȯ��');
insert into PAYMENT values(4, 4, '�г���4',null, 123456789012, '�г���5',null, 987654321234, 80000, 80000, SYSDATE, '��Ʈķ��', '����Ȯ��', '�Ǹž���');

--�ŷ����
insert into HISTORY values(1, '�г���5', 987654321234, '�г���3', 777788889999, 120000, SYSDATE);
insert into HISTORY values(2, '�г���4', 123456789012, '�г���5', 987654321234, 80000, SYSDATE);

--��ǰ���
insert into P_REPLY values(1, 1, 'ddd@naver.com', '�г���4', '����Ű �ȭ 9���� ���� �����Ѱ���?', 'b1.png', 'b1_copy.png', SYSDATE);
insert into P_REPLY values(2, 3, 'eee@google.com', '�г���5', '���߶��� �ȭ 14���� ���� �����Ѱ���?', 'b2.png', 'b2_copy.png', SYSDATE);

--�Ű���
insert into REPORT values(1, '�г���3 ���� ��� �Ű�', '�г���3 ������ ��ǰ ����� �����ʴ� ��ǰ�� ������ ��⸦ ���߽��ϴ�', 'a.jpg', 'a_copy.jpg', 'ddd@naver.com', '�г���4', SYSDATE, 'ó����', '���1', '���Ű�');
insert into REPORT values(2, '�г���4 ���� ��� �Ű�', '�г���5 ������ ��ǰ�� ������ �ʽ��ϴ�', 'b.jpg', 'b_copy.jpg', 'eee@google.com', '�г���5', SYSDATE, 'ó����', '���2', '���Ű�');

--���ҽ� ( ���� - 0:��������, 1:�̺�Ʈ)
insert into NEWS values(1, 'aaa@naver.com', '�г���1', '��� ��ó ���', '���� �� �ŷ� �� ��⸦ ���� ��� ������ �Ű� �ٶ��ϴ�', 0, SYSDATE, '��������');
insert into NEWS values(2, 'bbb@google.com', '�г���2', 'ù ���� �� ������ ���� �̺�Ʈ', 'ù ���� �� �����Ḧ �������ִ� �̺�Ʈ�� �����մϴ� ���� �����ϼ���', 0, SYSDATE, '�̺�Ʈ');

--�����Խ���
insert into BOARD values(1, 'ccc@daum.net', '�г���3', '��S10 5G', '�Ե� ��� ��S10 5G ���Դ��� ������?', 'aa.jpg', 'aa_copy01.jpg', 0, 0, SYSDATE, 0);
insert into BOARD values(2, 'ddd@naver.com', '�г���4', '���̽� û�ұ�', '���̽� û�ұ� �߰��� �ʹ� ��δ���...', 'bb.jpg', 'bb_copy01.jpg', 0, 0, SYSDATE, 0);
insert into BOARD values(3, 'eee@google.com', '�г���5', '������', '������1�̶� ������2 ���� ���� ���̳�?', null, null, 0, 0, SYSDATE, 0);

--�ڰԴ��
insert into B_REPLY values(1, 1, 'ddd@naver.com', '�г���4', '������S10�̻� �ٵ� ������ 5G�� �߾���������', SYSDATE, 'aaa.png', 'aaa_copy01.png', 0, 0,'ddd@naver.com', '�г���4');
insert into B_REPLY values(2, 2, 'eee@google.com', '�г���5',  '�׳� �߰�� ��ٿ� ���ŷ� ��°� ������', SYSDATE, 'bbb.png', 'bbb_copy01.png', 0, 0, 'ddd@naver.com', '�г���4');
insert into B_REPLY values(3, 3, 'ccc@daum.net', '�г���3', '������1 ��ٿ� ������2 ��°� �ξ� �̵���', SYSDATE, 'ccc.png', 'ccc_copy01.png', 0, 0, 'ccc@daum.net', '�г���3');

commit;