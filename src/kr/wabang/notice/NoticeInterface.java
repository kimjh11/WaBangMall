package kr.wabang.notice;

import java.util.List;

public interface NoticeInterface {
	//�� ����
	public int NoticeInsert(NoticeVO vo);
	
	//�� ����
	public void selectNoticeView(NoticeVO vo);
	
	//�� ����
	public int updateNoticeView(NoticeVO vo);
	
	//�� ����
	public int deleteNoticeView(NoticeVO vo);
	
	//��  ���ڵ� ��
	public int totalRecord(NoticeVO vo);
	
	//�ش� ������ ���ڵ� ����Ʈ
	public List<NoticeVO> pageList(NoticeVO vo);
}
