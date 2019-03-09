package kr.wabang.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandQnaUpdateOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ���� �� ����
		req.setCharacterEncoding("UTF-8");
		
		QnaVO vo = new QnaVO();
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		vo.setM_id(req.getParameter("userid"));
		vo.setQ_title(req.getParameter("title"));
		vo.setQ_content(req.getParameter("content"));
		
		QnaDAO dao = new QnaDAO();
		int cnt = dao.updateQnaView(vo);
		
		req.setAttribute("cnt", cnt);
		
		//�� ���� ������ �� ���� ���� ������ �̵��� �ʿ���.
		req.setAttribute("q_num", vo.getQ_num()); //���ڵ� ��ȣ
		req.setAttribute("num", vo.getNum()); //���� ������ ��ȣ
		
		return "qnaUpdateOk.jsp";
	}

}
