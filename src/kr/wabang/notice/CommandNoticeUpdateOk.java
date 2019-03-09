package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeUpdateOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// �������� �� �����ϱ�
		req.setCharacterEncoding("UTF-8");
		
		NoticeVO vo = new NoticeVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		vo.setN_num(Integer.parseInt(req.getParameter("n_num")));
		
		vo.setAdminId(req.getParameter("adminid"));
		vo.setN_title(req.getParameter("title"));
		vo.setN_content(req.getParameter("content"));
		
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.updateNoticeView(vo);
		
		req.setAttribute("cnt", cnt);
		
		//�� ���� ������ �� ���� ���� ������ �̵��� �ʿ�
		req.setAttribute("n_num", vo.getN_num()); //���ڵ� ��ȣ
		req.setAttribute("num", vo.getNum()); //���� ������ ��ȣ
		
		return "noticeUpdateOk.jsp";
	}

}
