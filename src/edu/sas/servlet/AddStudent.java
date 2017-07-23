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
		//将学生信息从request对象中取出，并封装进student类中
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
			//添加学生操作
			if(DAOFactory.getIStudentDAOInstance().doCreate(student)){
				//若添加成功返回添加成功信息
				request.setAttribute("info","添加成功");
				request.getRequestDispatcher("apartment-students.jsp").forward(request, response);
			}else{
				//若添加失败则返回失败信息
				request.setAttribute("info", "添加失败");
				request.getRequestDispatcher("student-add.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
