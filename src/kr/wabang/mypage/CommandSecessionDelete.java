package kr.wabang.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.member.MemberDAO;
import kr.wabang.member.MemberVO;

public class CommandSecessionDelete implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//ȸ��Ż��
		req.setCharacterEncoding("UTF-8");
		
		//���� ���̵�
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId");
		
		MemberVO vo = new MemberVO();
		vo.setM_pwd(req.getParameter("userpwd"));
		
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.myInfoDelete(userid ,vo);
		
		//���� �����
		if(cnt>0){
			session.invalidate();
		}
		
		req.setAttribute("cnt", cnt);
		
		return "secessionOk.jsp";
	}
}
