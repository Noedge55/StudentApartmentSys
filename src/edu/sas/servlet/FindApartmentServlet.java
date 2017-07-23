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
	 * ��ѯ��ԢServlet
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String keyword ="";
		if(req.getParameter("keyword")==null){
			keyword = "";
		}else{
			keyword = req.getParameter("keyword");	//��ȡ��ѯ�ؼ���
		}
		
		try {
			List<Apartment> list;
			//ģ����ѯ��Ԣ����
			list = DAOFactory.getIApartmentDAOInstance().findAll(keyword);
			//����Ԣ����request�����У�������apartment-manager.jspҳ��
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
