package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandNoticeDeleteOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 글 삭제하기
		NoticeVO vo = new NoticeVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		vo.setN_num(Integer.parseInt(req.getParameter("n_num")));
		
		HttpSession session = req.getSession();
		vo.setAdminId((String)session.getAttribute("adminloginId"));
		
		NoticeDAO dao = new NoticeDAO();
		int cnt = dao.deleteNoticeView(vo);
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("vo", vo); //페이지 때문에..
		
		return "noticeDeleteOk.jsp";
	}

}
