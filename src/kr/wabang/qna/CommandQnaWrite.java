package kr.wabang.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandQnaWrite implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 질문 / 답변 글쓰기
		req.setCharacterEncoding("UTF-8");
		
		QnaVO vo = new QnaVO();
		vo.setM_id(req.getParameter("userid"));
		vo.setQ_title(req.getParameter("title"));
		vo.setQ_content(req.getParameter("content"));
		
		System.out.println("userid=" +req.getParameter("userid"));
		System.out.println("title=" +req.getParameter("title"));
		System.out.println("content=" +req.getParameter("content"));
		
		QnaDAO dao = new QnaDAO();
		int cnt = dao.QnaInsert(vo);
		
		req.setAttribute("cnt", cnt);
		
		return "qnaWriteOk.jsp";
	}
}
