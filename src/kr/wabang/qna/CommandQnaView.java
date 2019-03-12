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
		// �亯 ����
		AnswerVO answervo = new AnswerVO();
		
		//�� ��ȣ
		vo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		answervo.setQ_num(Integer.parseInt(req.getParameter("q_num")));
		
		//���� ������ ��ȣ
		vo.setNum(Integer.parseInt(req.getParameter("num")));
		
		QnaDAO dao = new QnaDAO();
		dao.selectQnaView(vo);
		dao.selectAnswer(answervo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("answervo", answervo);
		
		return "qnaView.jsp";
	}
}
