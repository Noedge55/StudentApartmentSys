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
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("apartment-students.jsp").forward(request, response);
	}

}
