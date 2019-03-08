package kr.wabang.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;

public class CommandLoginOk implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//일반 유저 로그인
		MemberVO vo = new MemberVO();
		vo.setM_id(req.getParameter("userid"));
		vo.setM_pwd(req.getParameter("userpwd"));
		
		//어드민 로그인
		AdminVO adminvo = new AdminVO();
		adminvo.setAdminId(req.getParameter("userid"));
		adminvo.setAdminPwd(req.getParameter("userpwd"));
		
		//일반 유저 DAO
		MemberDAO dao = new MemberDAO();
		dao.loginCheck(vo);
		
		//어드민 DAO
		dao.adminloginCheck(adminvo);
		
		//일반 유저
		req.setAttribute("vo", vo);
		//어드민
		req.setAttribute("adminvo", adminvo);
		
		//로그인 성공시 세션에 필요한 데이터 기록 
		if(vo.getLoginStatus().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("loginId", vo.getM_id());
			System.out.println(vo.getM_id());
			session.setAttribute("loginStatus", vo.getLoginStatus());
			System.out.println(vo.getLoginStatus());
		}
		
		//어드민 로그인 성공시 세션에 필요한 데이터 기록
		if(adminvo.getAdminloginStatus().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("adminloginId", adminvo.getAdminId());
			System.out.println("admin="+adminvo.getAdminId());
			session.setAttribute("adminloginStatus", adminvo.getAdminloginStatus());
			System.out.println("admin="+adminvo.getAdminloginStatus());
		}
		
		return "loginOk.jsp";
	}

}
