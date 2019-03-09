package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 공지사항 보기
		NoticeVO vo = new NoticeVO();
		//글 번호
		vo.setN_num(Integer.parseInt(req.getParameter("n_num")));
		//현재 페이지 번호
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		
		NoticeDAO dao = new NoticeDAO();
		dao.selectNoticeView(vo);
		
		req.setAttribute("vo", vo);
		return "noticeView.jsp";
	}

}
