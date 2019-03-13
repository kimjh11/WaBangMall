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
	
	//�亯 ���� ��������
	public void selectAnswer(AnswerVO answervo);
	
	//�亯 ���� �����
	public int deleteAnswer(AnswerVO answervo);
	
	//�亯 ����� -ȸ��Ż��
	public int deleteQnaAnswer(String userid);
	
	//���� ����� -ȸ��Ż��
	public int deletequestion(String userid);
}
