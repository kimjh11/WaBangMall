package kr.wabang.member;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.mypage.OrderVO;

public class CommandFindId implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		String email = req.getParameter("email1");
		System.out.println("아이디찾기 이메일:"+email);
		
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.findId(email);
		
		req.setAttribute("id", vo.getM_id());
		System.out.println("아이디:"+vo.getM_id());
		return "findId.jsp";
	}

}
