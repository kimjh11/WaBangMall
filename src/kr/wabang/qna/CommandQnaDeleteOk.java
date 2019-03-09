package kr.wabang.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandQnaDeleteOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 질문 글 삭제하기
		QnaVO vo = new QnaVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		HttpSession session = req.getSession();
		vo.setM_id((String)session.getAttribute("loginId"));
		
		QnaDAO dao = new QnaDAO();
		int cnt = dao.deleteQnaView(vo);
		
		req.setAttribute("cnt", cnt);
		req.setAttribute("vo", vo);
		
		return "qnaDeleteOk.jsp";
	}
}
