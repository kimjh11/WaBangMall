package kr.wabang.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.member.MemberDAO;
import kr.wabang.member.MemberVO;
import kr.wabang.order.BasketDAO;
import kr.wabang.order.BasketVO;
import kr.wabang.qna.AnswerVO;
import kr.wabang.qna.QnaDAO;
import kr.wabang.qna.QnaVO;

public class CommandSecessionDelete implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//회원탈퇴
		req.setCharacterEncoding("UTF-8");
		
		//세션 아이디
		HttpSession session = req.getSession();
		String userid = (String) session.getAttribute("loginId");
		
		MemberVO membervo = new MemberVO();
		membervo.setM_pwd(req.getParameter("userpwd"));
		
		//////////////////////////////////////////////////////
		//1.장바구니 지우기
		BasketDAO BasketDAO = new BasketDAO();
		int cnt = BasketDAO.deleteListAll(userid);
		
		//2.주문 지우기
		BasketDAO orderDao = new BasketDAO();
		int orderCnt = orderDao.orderDelete(userid);
		
		//3.답변 지우기
		QnaDAO answerDao = new QnaDAO();
		int answerCnt = answerDao.deleteQnaAnswer(userid);
		
		//4.질문 지우기
		QnaDAO questionDao = new QnaDAO();
		int questionCnt = questionDao.deletequestion(userid);
				
		//5.회원 지우기
		MemberDAO dao = new MemberDAO();
		int membercnt = dao.myInfoDelete(userid ,membervo);
		/////////////////////////////////////////////////////
		
		//세션 지우기
		if(membercnt>0){
			session.invalidate();
		}
		
		//뷰 페이지로 값 전달
		req.setAttribute("cnt", cnt);
		req.setAttribute("orderCnt", orderCnt);
		req.setAttribute("answerCnt", answerCnt);
		req.setAttribute("questionCnt", questionCnt);
		req.setAttribute("membercnt", membercnt);
		
		return "secessionOk.jsp";
	}
}
