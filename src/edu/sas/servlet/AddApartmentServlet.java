package edu.sas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Apartment;

/**
 * 添加公寓Servlet
 */
public class AddApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//分别接收公寓相关信息，并封装进apartment对象内
		String apartno = request.getParameter("apartno");
		int lvdornum = Integer.parseInt(request.getParameter("lvdornum"));
		int levels = Integer.parseInt(request.getParameter("levels"));
		float area =Float.parseFloat(request.getParameter("area")) ;
		Apartment vo = new Apartment();
		vo.setApartno(apartno);
		vo.setLvdornum(lvdornum);
		vo.setLevels(levels);
		vo.setArea(area);
		vo.setStutotnum(levels * lvdornum * 4);
		vo.setStulivnum(0);
		//添加公寓操作
		try {
			if(DAOFactory.getIApartmentDAOInstance().doCreate(vo)){
				//若公寓添加成功，则向apartment-manager.jsp页面传递成功消息
				request.setAttribute("info", "添加公寓成功");
				request.getRequestDispatcher("apartment-manager.jsp").forward(request, response);
			}else{
				//若公寓添加成功，则向apartment-add.jsp页面传递失败消息
				request.setAttribute("info", "添加公寓失败");
				request.getRequestDispatcher("apartment-add.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
