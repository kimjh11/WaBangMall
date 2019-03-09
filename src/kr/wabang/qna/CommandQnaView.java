package kr.wabang.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandQnaView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 질문 보기
		QnaVO vo = new QnaVO();
		
		//글 번호
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		//현재 페이지 번호
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		
		QnaDAO dao = new QnaDAO();
		dao.selectQnaView(vo);
		
		req.setAttribute("vo", vo);
		
		return "qnaView.jsp";
	}
}
