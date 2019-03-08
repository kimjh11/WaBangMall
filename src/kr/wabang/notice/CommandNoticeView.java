package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �������� ����
		NoticeVO vo = new NoticeVO();
		//�� ��ȣ
		vo.setN_num(Integer.parseInt(req.getParameter("n_num")));
		//���� ������ ��ȣ
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		
		NoticeDAO dao = new NoticeDAO();
		dao.selectNoticeView(vo);
		
		req.setAttribute("vo", vo);
		return "noticeView.jsp";
	}

}
