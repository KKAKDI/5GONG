--ȸ�� (���� - 0:������, 1:�Ϲ�ȸ��)
insert into MEMBER values('aaa@naver.com', '�г���1', '0', '�ֿ���', '��������', 111122223333, 01011112222, 1000000, 90, SYSDATE);
insert into MEMBER values('bbb@google.com', '�г���2', '0', '������', '��������', 444455556666, 01033334444, 2000000, 100, SYSDATE);
insert into MEMBER values('ccc@daum.net', '�г���3', '1', '������', '�츮����', 777788889999, 01055556666, 900000, 80, SYSDATE);
insert into MEMBER values('ddd@naver.com', '�г���4', '1', '������', 'īī����ũ', 123456789012, 01012345678, 800000, 70, SYSDATE);
insert into MEMBER values('eee@google.com', '�г���5', '1', '�ڵ���', '�������', 987654321234, 01098765432, 700000, 60, SYSDATE);

--��ǰ (������� - 0:�Ǹ���, 1:�ŷ���, 2:�ŷ��Ϸ�)
insert into PRODUCT values(1, 'ccc@daum.net', '�г���3', '1', '�г���4', '����Ű �ȭ', 100000, '����Ű �ȭ', '����Ű �ȭ 10������ �˴ϴ�', 'a1.jsp', 'a1_copy01.jsp', SYSDATE);
insert into PRODUCT values(2, 'ddd@naver.com', '�г���4', '0', null, '���߶��� �ȭ', 150000, '���߶��� �ȭ', '���߶��� �ȭ 15������ �˴ϴ�', 'a2.jsp', 'a2_copy02.jsp', SYSDATE);
insert into PRODUCT values(3, 'eee@google.com', '�г���5', '2', '�г���3', '�Ƶ�ٽ� �ȭ', 120000, '�Ƶ�ٽ� �ȭ', '�Ƶ�ٽ� �ȭ 12������ �˴ϴ�', 'a3.jsp', 'a3_copy03.jsp', SYSDATE);
insert into PRODUCT values(4, 'ddd@naver.com', '�г���4', '2', '�г���5', '������ ��ȭ', 80000, '������ ��ȭ', '������ ��ȭ 8������ �˴ϴ�', 'a4.jsp', 'a4_copy04.jsp', SYSDATE);

--����
insert into PAYMENT values(1, 1, '�г���3', 777788889999, '�г���4', 123456789012, 100000, 100000, SYSDATE);
insert into PAYMENT values(2, 2, '�г���4', 123456789012, null, null, 150000, null, SYSDATE);
insert into PAYMENT values(3, 3, '�г���5', 987654321234, '�г���3', 777788889999, 120000, 120000, SYSDATE);
insert into PAYMENT values(4, 4, '�г���4', 123456789012, '�г���5', 987654321234, 80000, 80000, SYSDATE);

--�ŷ����
insert into HISTORY values(1, '�г���5', 987654321234, '�г���3', 777788889999, 120000, SYSDATE);
insert into HISTORY values(2, '�г���4', 123456789012, '�г���5', 987654321234, 80000, SYSDATE);

--��ǰ���
insert into P_REPLY values(1, 1, 'ddd@naver.com', '�г���4', '����Ű �ȭ 9���� ���� �����Ѱ���?', 'b1.png', 'b1_copy.png', SYSDATE);
insert into P_REPLY values(2, 3, 'eee@google.com', '�г���5', '���߶��� �ȭ 14���� ���� �����Ѱ���?', 'b2.png', 'b2_copy.png', SYSDATE);

--�Ű���
insert into REPORT values(1, '�г���3 ���� ��� �Ű�', '�г���3 ������ ��ǰ ����� �����ʴ� ��ǰ�� ������ ��⸦ ���߽��ϴ�', 'a.jpg', 'ddd@naver.com', '�г���4', SYSDATE);
insert into REPORT values(2, '�г���4 ���� ��� �Ű�', '�г���5 ������ ��ǰ�� ������ �ʽ��ϴ�', 'b.jpg', 'eee@google.com', '�г���5', SYSDATE);

--���ҽ� ( ���� - 0:��������, 1:�̺�Ʈ)
insert into NEWS values(1, 'aaa@naver.com', '�г���1', '[����]��� ��ó ���', '���� �� �ŷ� �� ��⸦ ���� ��� ������ �Ű� �ٶ��ϴ�', 10, SYSDATE, '0');
insert into NEWS values(2, 'bbb@google.com', '�г���2', '[�̺�Ʈ]ù ���� �� ������ ���� �̺�Ʈ', 'ù ���� �� �����Ḧ �������ִ� �̺�Ʈ�� �����մϴ� ���� �����ϼ���', 10, SYSDATE, '1');

--�����Խ���
insert into BOARD values(1, 'ccc@daum.net', '�г���3', '��S10 5G', '�Ե� ��� ��S10 5G ���Դ��� ������?', 'aa.jpg', 'aa_copy01.jpg', 0, 0, SYSDATE);
insert into BOARD values(2, 'ddd@naver.com', '�г���4', '���̽� û�ұ�', '���̽� û�ұ� �߰��� �ʹ� ��δ���...', 'bb.jpg', 'bb_copy01.jpg', 0, 0, SYSDATE);
insert into BOARD values(3, 'eee@google.com', '�г���5', '������', '������1�̶� ������2 ���� ���� ���̳�?', null, null, 0, 0, SYSDATE);

--�ڰԴ��
insert into B_REPLY values(1, 1, 'ddd@naver.com', '�г���4', '������S10�̻� �ٵ� ������ 5G�� �߾���������', SYSDATE, 'aaa.png', 'aaa_copy01.png', 0, 0);
insert into B_REPLY values(2, 2, 'eee@google.com', '�г���5',  '�׳� �߰�� ��ٿ� ���ŷ� ��°� ������', SYSDATE, 'bbb.png', 'bbb_copy01.png', 0, 0);
insert into B_REPLY values(3, 3, 'ccc@daum.net', '�г���3', '������1 ��ٿ� ������2 ��°� �ξ� �̵���', SYSDATE, 'ccc.png', 'ccc_copy01.png', 0, 0);