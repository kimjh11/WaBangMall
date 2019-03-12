package kr.wabang.order;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.wabang.controller.CommandService;
import kr.wabang.item.ItemDAO;
import kr.wabang.item.ItemVO;

public class CmdShoppingListInsert implements CommandService {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 장바구니페이지
		req.setCharacterEncoding("UTF-8");


		String bSelectOpt[] = req.getParameterValues("bSelectOpt");
		String bColor[] = req.getParameterValues("bColor");		
		String bCount[] = req.getParameterValues("bCount");
		
		//System.out.println("옵션명:"+Arrays.deepToString(bSelectOpt));
		//System.out.println("색상명:"+Arrays.deepToString(bColor));
		//System.out.println("수량:"+Arrays.deepToString(bCount));
		
		ItemVO itemVO = new ItemVO(req.getParameter("iCode"));
		ItemDAO itemDAO = new ItemDAO();
		
		itemDAO.itemSelect(itemVO);
		itemVO.setNoOptPrice(itemVO.getiPrice(), itemVO.getiDiscount());//원가
		
		HttpSession ses = req.getSession();

		ShoppingListVO listVO = new ShoppingListVO();
		
		listVO.setiCode(req.getParameter("iCode"));
		listVO.setmId((String)ses.getAttribute("loginId"));
		listVO.setbCount(bCount);
		listVO.setbSelectOpt(bSelectOpt);
		listVO.setbColor(bColor);
		listVO.setbPrice(itemVO.getNoOptPrice());//상품원가
		listVO.setbPayment(Integer.parseInt(req.getParameter("bPayment")));//총결제금액
		
		ShoppingListDAO dao = new ShoppingListDAO();
		List<ShoppingListVO> list = dao.insertShoppingList(listVO);
		
		req.setAttribute("list", list);

		return "shoppingListInsertOk.jsp";
	}

}
