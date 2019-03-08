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
		//내 주문목록
		MyPageDAO dao = new MyPageDAO();
		HttpSession session = req.getSession();
		OrderVO vo = new OrderVO();
		String userid = (String) session.getAttribute("loginId");
		
		//아이디 받아왔는지 확인.
		System.out.println("로그인한 아이디="+userid);
		
		//현재 페이지
		String numStr = req.getParameter("num");
		if(numStr == null){
			vo.setNum(1);
		}else{
			vo.setNum(Integer.parseInt(numStr));
		}
		
		//총 레코드 수
		vo.setTotalRecord(dao.totalRecord(vo,userid));
		System.out.println("토탈테코드="+vo.getTotalRecord());
		System.out.println("시작페이지="+vo.getStartPage());
		List<OrderVO> list = dao.getAllOrder(userid,vo);

		req.setAttribute("vo", vo);
		req.setAttribute("list", list);
		
		return "myorder.jsp";
	}

}
