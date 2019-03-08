package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeUpdate implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �������� �� �����ϱ�
		NoticeVO vo = new NoticeVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));//���� ������ ��ȣ
		vo.setN_num(Integer.parseInt(req.getParameter("n_num"))); //���ڵ� ��ȣ
		
		NoticeDAO dao = new NoticeDAO();
		dao.selectNoticeView(vo);
		
		req.setAttribute("vo", vo);
		return "noticeUpdateForm.jsp";
	}

}
