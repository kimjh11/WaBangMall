package kr.wabang.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandNoticeUpdate implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 공지사항 글 수정하기
		NoticeVO vo = new NoticeVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));//현재 페이지 번호
		vo.setN_num(Integer.parseInt(req.getParameter("n_num"))); //레코드 번호
		
		NoticeDAO dao = new NoticeDAO();
		dao.selectNoticeView(vo);
		
		req.setAttribute("vo", vo);
		return "noticeUpdateForm.jsp";
	}

}
