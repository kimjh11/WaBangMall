package kr.wabang.qna;

import java.util.List;

public interface QnaInterface {
	//���� �� ����
	public int QnaInsert(QnaVO vo);
	
	//���� �� ����
	public void selectQnaView(QnaVO vo);
	
	//���� �� ���� 
	public int updateQnaView(QnaVO vo);
	
	//���� �� ����
	public int deleteQnaView(QnaVO vo);
	
	//�� ���ڵ� ��
	public int totalRecord(QnaVO vo);
	
	//�ش� ������ ���ڵ� ����Ʈ
	public List<QnaVO> pageList(QnaVO vo);
}
