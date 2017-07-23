package edu.sas.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.sas.factory.DAOFactory;
import edu.sas.util.MD5Code;
import edu.sas.vo.Users;

public class LoginServlet extends HttpServlet{
	/**
	 * ��¼����
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");					//���յ�¼ҳ�洫�������û���
		String password = req.getParameter("password");				//���յ�¼ҳ�洫����������
		String code = req.getParameter("code");						//���յ�¼ҳ�洫��������֤��
		String rand = (String) req.getSession().getAttribute("rand");	//������֤�뱾���ֵ
		String info = "";
		//����֤��Ϊ��
		if(code==null || "".equals(code)){
			info="��֤�벻��Ϊ��";		//���������Ϣ
			req.setAttribute("info", info);
			req.getRequestDispatcher("login.jsp").forward(req,resp);	//��������Ϣ���ݵ���¼����
		}
		//����֤���������
		if(!code.equalsIgnoreCase(rand)){
			info="��֤�����";
			req.setAttribute("info", info);
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
		try {
			//���û������������������
			if(userid == null || "".equals(userid)||password == null||"".equals(password)||!DAOFactory.getIUsersDAOInstance().findLogin(userid, new MD5Code().getMD5ofStr(password))){
				info="�û������������";
				req.setAttribute("info", info);
				req.getRequestDispatcher("login.jsp").forward(req,resp);
			}else{
				//��¼�ɹ������û�����Ȩ�޴��ݻ���ҳ��
				Users user = DAOFactory.getIUsersDAOInstance().findById(userid);
				req.getSession().setAttribute("userid", userid);
				req.getSession().setAttribute("permission",user.getPermission());
				resp.sendRedirect("index.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
