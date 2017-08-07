package edu.sas.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Apartment;
import edu.sas.vo.Living;

/**
 * Servlet implementation class ApartmentStudentServlet
 */
@WebServlet("/ApartmentStudentServlet")
public class ApartmentStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApartmentStudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ��������DΪ������XΪ����
		String areaEast = "D";
		String areaWest = "X";
		try {
			//�����еĹ�Ԣ����List����������
			List<Apartment> listEast = DAOFactory.getIApartmentDAOInstance().findAll(areaEast);
			List<Apartment> listWest = DAOFactory.getIApartmentDAOInstance().findAll(areaWest);
			request.setAttribute("listEast", listEast);
			request.setAttribute("listWest", listWest);
			
			String apartno = request.getParameter("apartno");
			String keyword = request.getParameter("keyword");	//��ѯ�ؼ���
			if(apartno == null){
				apartno = "";
			}
			if(keyword == null){
				keyword = "";
			}
			//���õ�ǰҳ������ҳ����������ÿҳ����ÿ��¥��
			int pageNow = 1 ;
			if(request.getParameter("pageNow") != null){
				//���е�ǰҳ���������ȡ��ǰҳ
				pageNow=Integer.parseInt(request.getParameter("pageNow")); 
			}
			
			//����ù�Ԣ�µ�����ѧ��
			Apartment apart = DAOFactory.getIApartmentDAOInstance().findById(apartno);
			List<Living> listLiving = DAOFactory.getILivingDAOInstance().findAll(apartno);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("apartment-students.jsp").forward(request, response);
	}

}
