package edu.sas.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Student student = new Student();
		request.setCharacterEncoding("utf-8");
		//��ѧ����Ϣ��request������ȡ��������װ��student����
		String stuno = request.getParameter("stuno");
		String stuname = request.getParameter("stuname");
		int sex = Integer.parseInt(request.getParameter("sex"));
		String major = request.getParameter("major");
		String classname = request.getParameter("classname");
		String phonenum = request.getParameter("phonenum");
		student.setStuno(stuno);
		student.setStuname(stuname);
		student.setSex(sex);
		student.setMajor(major);
		student.setClassname(classname);
		student.setPhonenum(phonenum);
		
		try {
			//���ѧ������
			if(DAOFactory.getIStudentDAOInstance().doCreate(student)){
				//����ӳɹ�������ӳɹ���Ϣ
				request.setAttribute("info","��ӳɹ�");
				request.getRequestDispatcher("apartment-students.jsp").forward(request, response);
			}else{
				//�����ʧ���򷵻�ʧ����Ϣ
				request.setAttribute("info", "���ʧ��");
				request.getRequestDispatcher("student-add.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
