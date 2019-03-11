package kr.wabang.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;
import oracle.net.aso.r;

public class CommandQnaUpdate implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 질문 글 수정하기(선택)
		QnaVO vo = new QnaVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));//현재 페이지 번호
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));//레코드 번호
		
		QnaDAO dao = new QnaDAO();
		dao.selectQnaView(vo);
		
		req.setAttribute("vo", vo);
		
		return "qnaUpdateForm.jsp";
	}
}
