package kr.wabang.qna;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.wabang.controller.CommandService;

public class CommandQnaList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//Q&A�� ���� ����Ʈ ���
		QnaDAO dao = new QnaDAO();
		QnaVO vo = new QnaVO();
		
		//���� ������
		String numStr = req.getParameter("num");
		if(numStr == null){
			vo.setNum(1);
		}else{
			vo.setNum(Integer.parseInt(numStr));
		}
		
		//�˻���, Ű
		vo.setSearchWord(req.getParameter("searchWord"));
		if(vo.getSearchWord() == null || vo.getSearchWord().equals("")){
			vo.setSearchKey(null);
		}else{
			vo.setSearchKey(req.getParameter("searchKey"));
		}
		
		//�� ���ڵ� ��
		vo.setTotalRecord(dao.totalRecord(vo));
		
		//�ش� ������ ���ڵ� ����Ʈ
		List<QnaVO> list = dao.pageList(vo);
		
		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		
		return "qnaList.jsp";
	}

}
