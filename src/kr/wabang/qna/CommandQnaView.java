package kr.wabang.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandQnaView implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// ���� ����
		QnaVO vo = new QnaVO();
		
		//�� ��ȣ
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		//���� ������ ��ȣ
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		
		QnaDAO dao = new QnaDAO();
		dao.selectQnaView(vo);
		
		req.setAttribute("vo", vo);
		
		return "qnaView.jsp";
	}
}
