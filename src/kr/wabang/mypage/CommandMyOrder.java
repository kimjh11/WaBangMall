package kr.wabang.mypage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.member.MemberVO;
import kr.wabang.notice.NoticeVO;

public class CommandMyOrder implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//�� �ֹ����
		MyPageDAO dao = new MyPageDAO();
		HttpSession session = req.getSession();
		OrderVO vo = new OrderVO();
		String userid = (String) session.getAttribute("loginId");
		
		//���̵� �޾ƿԴ��� Ȯ��.
		System.out.println("�α����� ���̵�="+userid);
		
		//���� ������
		String numStr = req.getParameter("num");
		if(numStr == null){
			vo.setNum(1);
		}else{
			vo.setNum(Integer.parseInt(numStr));
		}
		
		//�� ���ڵ� ��
		vo.setTotalRecord(dao.totalRecord(vo,userid));
		System.out.println("��Ż���ڵ�="+vo.getTotalRecord());
		System.out.println("����������="+vo.getStartPage());
		List<OrderVO> list = dao.getAllOrder(userid,vo);

		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		
		return "myorder.jsp";
	}

}
