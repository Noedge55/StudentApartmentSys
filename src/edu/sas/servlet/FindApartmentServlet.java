package edu.sas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Apartment;

public class FindApartmentServlet extends HttpServlet {

	/**
	 * 查询公寓Servlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String keyword ="";
		if(req.getParameter("keyword")==null){
			keyword = "";
		}else{
			keyword = req.getParameter("keyword");	//获取查询关键字
		}
		
		try {
			List<Apartment> list;
			//模糊查询公寓操作
			list = DAOFactory.getIApartmentDAOInstance().findAll(keyword);
			//将公寓存入request对象中，并传回apartment-manager.jsp页面
			req.setAttribute("list", list);									
			req.getRequestDispatcher("apartment-manager.jsp").forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
}
