--ȸ�� (���� - 0:������, 1:�Ϲ�ȸ��)
insert into MEMBER values('aaa@naver.com', '�г���1', '0','1q2w3e4r!', '�ֿ���', '��������', 111122223333, 01011112222, 1000000, 90, SYSDATE);
insert into MEMBER values('bbb@google.com', '�г���2', '0','1q2w3e4r!', '������', '��������', 444455556666, 01033334444, 2000000, 100, SYSDATE);
insert into MEMBER values('ccc@daum.net', '�г���3', '1','1q2w3e4r!', '������', '�츮����', 777788889999, 01055556666, 900000, 80, SYSDATE);
insert into MEMBER values('ddd@naver.com', '�г���4', '1','1q2w3e4r!', '������', 'īī����ũ', 123456789012, 01012345678, 800000, 70, SYSDATE);
insert into MEMBER values('eee@google.com', '�г���5', '1','1q2w3e4r!', '�ڵ���', '�������', 987654321234, 01098765432, 700000, 60, SYSDATE);

-- ȸ�� ���� ����
insert into MONEY_MEMBER values('�ֿ���', '01011112222', '��������', '111122223333', '�ֿ���');
insert into MONEY_MEMBER values('������', '01033334444', '��������', '444455556666', '������');
insert into MONEY_MEMBER values('������', '01012345678', 'īī����ũ', '123456789012', '������');
insert into MONEY_MEMBER values('������', '01055556666', '�츮����', '777788889999', '������');
insert into MONEY_MEMBER values('�ڵ���', '01098765432', '�������', '987654321234', '�ڵ���');

--��ǰ (������� - 0:�Ǹ���, 1:�ŷ���, 2:�ŷ��Ϸ� / ��ǰ���� - 0:�˴ϴ�, 1:��ϴ�)
--�μ��˴ϴ�
insert into PRODUCT values(1, 'bit@naver.com', '��Ʈ', '�Ǹ���', '����', '�����е�', '�˴ϴ�', 500000, '�����е�', '�����е� 50������ �˴ϴ�', 0, 'iPad.jsp', 'iPad_copy01.jsp',SYSDATE); 
--���ŸӸ� �˴ϴ�
insert into PRODUCT values(2, 'king@naver.com', 'ŷ', '�ǸſϷ�', '����', '�޴�뼱ǳ��', '�˴ϴ�', 13000, '�޴�뼱ǳ��', '�޴�� ��ǳ�� 13000���� �˴ϴ�', 0, 'handifan.jsp', 'handifan_copy02.jsp',SYSDATE);
--��ȥ�˴ϴ�
insert into PRODUCT values(3, 'wunhak@google.com','����', '�Ǹ���', '�ÿ�', '��Ʈ��', '�˴ϴ�', 700000, '��Ʈ��', 'LG gram 70������ �˴ϴ�', 0, 'gram.jsp', 'gram_copy03.jsp',SYSDATE);
--������ �˴ϴ�
insert into PRODUCT values(4, 'jihun@google.com','����', '�ŷ��Ϸ�', 'ä��', '�׷���ī��', '�˴ϴ�', 600000, '�׷���ī��', 'GTX 1080 60������ �˴ϴ�', 0, 'gtx1080.jsp', 'gtx1080_copy04.jsp',SYSDATE);
--���� �˴ϴ�
insert into PRODUCT values(5, 'seongsik@naver.com','����', '�Ǹ���', '����', '����', '�˴ϴ�', 300000, '����', '������ ��ǰ���� 30������ �˴ϴ�', 0, 'cap.jsp', 'cap_copy05.jsp', SYSDATE);
--����� ��ϴ� 
insert into PRODUCT values(6, 'jeongwoo@naver.com','����', '�ŷ���', '��', '�����', '��ϴ�', 250000, '�����', 'LED����� 25������ ��ϴ�', 0, 'monitor.jsp', 'monitor_copy06.jsp', SYSDATE);
--���� ��ϴ�
insert into PRODUCT values(7, 'dongjin@daum.net', '����', '�ŷ��Ϸ�', '��ȣ', '�Ź�', '��ϴ�', 150000, '����Ű �Ź� 15������ ��ϴ�', 0, 'nike.jsp', 'nike_copy07.jsp', SYSDATE);
--�ָ� ��ϴ�
insert into PRODUCT values(8, 'fff@naver.com','ä��', '�ŷ���', '����', '�Ź�', '��ϴ�', 20000, '�Ź�', '�Ź� 20�� 2������ ��ϴ�', 0, 'cupbab.jsp', 'cupbab_copy08.jsp',SYSDATE);
--�Ӹ�ī�� ��ϴ�
insert into PRODUCT values(9, 'ggg@naver.com','����', '�ŷ���', '����' , '��Ʈ��', '��ϴ�', 750000, '��Ʈ��', '�Ｚ �ø���9 75������ ��ϴ�', 0, 'series9.jsp', 'series9_copy09.jsp',SYSDATE);
--���� ���� ��ϴ�
insert into PRODUCT values(10,'hhh@naver.com', '����', '�ǸſϷ�', '����' , '����', '��ϴ�', 20000, '����', '������å 2������ ��ϴ�', 0, 'book.jsp', 'book_copy10.jsp',SYSDATE); 
--�ָ� ��ϴ�
insert into PRODUCT values(11,'iii@google.com','��ȣ','�ŷ���', '����', '���ڴ��', '��ϴ�', 100000, '���ڴ��', '���ڴ�� 10������ ��ϴ�', 0, 'eleccigr.jsp', 'eleccigr_copy11.jsp',SYSDATE);
--���ŸӸ� �˴ϴ�
insert into PRODUCT values(12,'jjj@google.com','����','�Ǹ���', '����', '����', '�˴ϴ�', 500000, '����', '�������� 50������ �˴ϴ�', 0, 'gucci.jsp', 'gucci_copy12.jsp',SYSDATE);
--������ ��ϴ�
insert into PRODUCT values(13,'kkk@daum.net','��â', '�ŷ���', '����', '��Ʈ', '��ϴ�', 300000, '��Ʈ', '���̺��뺧Ʈ 30������ �˴ϴ�', 0, 'luisvit.jsp', 'luisvit_copy13.jsp',SYSDATE); 
--�뷡�ָӴ� �˴ϴ�
insert into PRODUCT values(14,'lll@daum.net','����', '�ǸſϷ�', '����', '�̾���','�˴ϴ�', 140000, '�̾���','������2 14������ �˴ϴ�', 0, 'airpod.jsp', 'airpod_copy14.jsp',SYSDATE);
-- �� �߻�ϴ�
insert into PRODUCT values(15,'mmm@daum.net', 'ȣ��', '�ŷ���', '����', '�����������Ŀ', '��ϴ�', 70000, '�����������Ŀ', '�����������Ŀ 7������ ��ϴ�', 0, 'BTspeaker.jsp', 'BTspeaker_copy15.jsp',SYSDATE);


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

--�Ű��� ( ó������ - 0:ó����, 1:ó���Ϸ� )
insert into REPORT values(1, '�г���3 ���� ��� �Ű�', '�г���3 ������ ��ǰ ����� �����ʴ� ��ǰ�� ������ ��⸦ ���߽��ϴ�', 'a.jpg', 'a_copy.jpg', 'ddd@naver.com', '�г���4', SYSDATE, '0', '���1');
insert into REPORT values(2, '�г���4 ���� ��� �Ű�', '�г���5 ������ ��ǰ�� ������ �ʽ��ϴ�', 'b.jpg', 'b_copy.jpg', 'eee@google.com', '�г���5', SYSDATE, '0', '���2');

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