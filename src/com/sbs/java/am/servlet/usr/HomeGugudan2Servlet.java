package com.sbs.java.am.servlet.usr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/usr/home/gugudan2")
public class HomeGugudan2Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		// 만들때마다 해줘야 함
		
		if(req.getParameter("dan") == null) {
			resp.getWriter().append("dan을 입력해주세요.");
			return;
		}
		
		int dan = Integer.parseInt(req.getParameter("dan"));
		int limit = 9;
		
		if(req.getParameter("limit") != null) {
			limit = Integer.parseInt(req.getParameter("limit"));
		}
		
		req.setAttribute("dan", dan); // Attribute -> 넘길 때 변환 과정이 필요없다.
		req.setAttribute("limit", limit);
		
		RequestDispatcher rd = req.getRequestDispatcher("/jsp/user/home/gugudan2.jsp"); // html 파일을 넘겨줌
		rd.forward(req, resp);
	}

}
