package kr.wabang.qna;

import java.util.List;

public interface QnaInterface {
	//질문 글 쓰기
	public int QnaInsert(QnaVO vo);
	
	//질문 글 선택
	public void selectQnaView(QnaVO vo);
	
	//질문 글 수정 
	public int updateQnaView(QnaVO vo);
	
	//질문 글 삭제
	public int deleteQnaView(QnaVO vo);
	
	//총 레코드 수
	public int totalRecord(QnaVO vo);
	
	//해당 페이지 레코드 리스트
	public List<QnaVO> pageList(QnaVO vo);
	
	//답변 내용 가져오기
	public void selectAnswer(AnswerVO answervo);
	
	//답변 내용 지우기
	public int deleteAnswer(AnswerVO answervo);
	
	//답변 지우기 -회원탈퇴
	public int deleteQnaAnswer(String userid);
	
	//질문 지우기 -회원탈퇴
	public int deletequestion(String userid);
}
