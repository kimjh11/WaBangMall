package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandMyInfoSelect implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//내 정보 수정
		//session 아이디로 데이터 선택 후 view 페이지로 이동
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId");
		
		//DB
		MemberDAO dao = new MemberDAO();
		MemberVO vo = dao.myInfoSelect(userid);
		
		req.setAttribute("vo", vo);
		
		return "myInfo.jsp";
	}
}
