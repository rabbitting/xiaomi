package com.xiaomi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiaomi.entity.Cart;
import com.xiaomi.service.CartService;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet{

	public CartServlet() {
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartService service = new CartService();
		PrintWriter out = response.getWriter();
		String operate = request.getParameter("operate");
		
		if("cartList".equals(operate)) {
			if(service.refreshCartList(request)) {
				request.getRequestDispatcher("cartlist.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("errorempty.jsp").forward(request, response);
			}
		}else if("deleteCart".equals(operate)) {
			String id = request.getParameter("id");
			service.deleteCartByUid(Integer.parseInt(id));
			service.refreshCartList(request);
			request.getRequestDispatcher("cartlist.jsp").forward(request, response);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CartService service = new CartService();
		PrintWriter out = response.getWriter();
		String operate = request.getParameter("operate");
		
		if("change_number".equals(operate)) {
			int selectId = Integer.parseInt(request.getParameter("selectId"));
			int goodNum = Integer.parseInt(request.getParameterValues("good_num")[selectId - 1]);
			int cartId = Integer.parseInt(request.getParameterValues("cart_id")[selectId - 1]);
			service.changeNumber(goodNum, cartId);
			service.refreshCartList(request);
			request.getRequestDispatcher("cartlist.jsp").forward(request, response);
		}
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.service(request, response);
	}

	@Override
	public void destroy() {

	}

	@Override
	public void init() throws ServletException {

	}
	
	

}
