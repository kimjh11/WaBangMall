package kr.wabang.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�������� ����Ʈ ������
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		
		//���� ������
		String numStr = req.getParameter("num");
		if(numStr == null){
			vo.setNum(1);
		}else{
			vo.setNum(Integer.parseInt(numStr));
		}
		
		//�˻��� ,Ű
		vo.setSearchWord(req.getParameter("searchWord"));
		if(vo.getSearchWord() == null || vo.getSearchWord().equals("")){
			vo.setSearchKey(null);
		}else{
			vo.setSearchKey(req.getParameter("searchKey"));
		}
		
		//�� ���ڵ� ��
		vo.setTotalRecord(dao.totalRecord(vo));
		
		//�ش� ������ ���ڵ� ����Ʈ
		List<NoticeVO> list = dao.pageList(vo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		
		return "notice.jsp";
	}
}
