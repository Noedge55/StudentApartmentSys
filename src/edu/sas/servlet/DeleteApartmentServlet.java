package edu.sas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;

public class DeleteApartmentServlet extends HttpServlet{
	/**
	 * ɾ����Ԣ
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String apartno = req.getParameter("apartno");
		System.out.println(apartno);
		try {
			if(DAOFactory.getIApartmentDAOInstance().doRemove(apartno)){
				req.setAttribute("info", "��Ԣ"+apartno+"ɾ���ɹ�");
				req.getRequestDispatcher("apartment-manager.jsp").forward(req, resp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
