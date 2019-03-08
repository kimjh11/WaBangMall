package kr.wabang.notice;

import java.util.List;

public interface NoticeInterface {
	//글 쓰기
	public int NoticeInsert(NoticeVO vo);
	
	//글 선택
	public void selectNoticeView(NoticeVO vo);
	
	//글 수정
	public int updateNoticeView(NoticeVO vo);
	
	//글 삭제
	public int deleteNoticeView(NoticeVO vo);
	
	//총  레코드 수
	public int totalRecord(NoticeVO vo);
	
	//해당 페이지 레코드 리스트
	public List<NoticeVO> pageList(NoticeVO vo);
}
