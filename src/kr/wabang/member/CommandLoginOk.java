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
		//�Ϲ� ���� �α���
		MemberVO vo = new MemberVO();
		vo.setM_id(req.getParameter("userid"));
		vo.setM_pwd(req.getParameter("userpwd"));
		
		//���� �α���
		AdminVO adminvo = new AdminVO();
		adminvo.setAdminId(req.getParameter("userid"));
		adminvo.setAdminPwd(req.getParameter("userpwd"));
		
		//�Ϲ� ���� DAO
		MemberDAO dao = new MemberDAO();
		dao.loginCheck(vo);
		
		//���� DAO
		dao.adminloginCheck(adminvo);
		
		//�Ϲ� ����
		req.setAttribute("vo", vo);
		//����
		req.setAttribute("adminvo", adminvo);
		
		//�α��� ������ ���ǿ� �ʿ��� ������ ��� 
		if(vo.getLoginStatus().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("loginId", vo.getM_id());
			System.out.println(vo.getM_id());
			session.setAttribute("loginStatus", vo.getLoginStatus());
			System.out.println(vo.getLoginStatus());
		}
		
		//���� �α��� ������ ���ǿ� �ʿ��� ������ ���
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
