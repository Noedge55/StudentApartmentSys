package edu.sas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Apartment;

/**
 * ��ӹ�ԢServlet
 */
public class AddApartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//�ֱ���չ�Ԣ�����Ϣ������װ��apartment������
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
		//��ӹ�Ԣ����
		try {
			if(DAOFactory.getIApartmentDAOInstance().doCreate(vo)){
				//����Ԣ��ӳɹ�������apartment-manager.jspҳ�洫�ݳɹ���Ϣ
				request.setAttribute("info", "��ӹ�Ԣ�ɹ�");
				request.getRequestDispatcher("apartment-manager.jsp").forward(request, response);
			}else{
				//����Ԣ��ӳɹ�������apartment-add.jspҳ�洫��ʧ����Ϣ
				request.setAttribute("info", "��ӹ�Ԣʧ��");
				request.getRequestDispatcher("apartment-add.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
