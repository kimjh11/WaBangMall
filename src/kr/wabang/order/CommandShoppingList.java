package kr.wabang.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.item.ItemDAO;
import kr.wabang.item.ItemVO;

public class CommandShoppingList implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 장바구니페이지
		ItemVO itemVO = new ItemVO(req.getParameter("iCode"));
		ItemDAO itemDAO = new ItemDAO();
		
		itemDAO.itemSelect(itemVO);
		HttpSession ses = req.getSession();
		
		ShoppingListVO vo = new ShoppingListVO();
		vo.setiCode(req.getParameter("iCode"));
		vo.setmId(ses.getId());
		vo.setbCount(req.getParameter("bCount"));
		vo.setbSelectOpt(req.getParameter("bSelectOpt"));
		vo.setbColor(req.getParameter("bColor"));
		vo.setbPrice(itemVO.getiPrice());
		vo.setbPayment(Integer.parseInt(req.getParameter("bPayment")));
		
		ShoppingListDAO dao = new ShoppingListDAO();
		int cnt = dao.insertShoppingList(vo);
		
		return "storeShoppingList.jsp";
	}

}
