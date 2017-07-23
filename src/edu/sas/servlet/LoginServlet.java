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
	 * 登录操作
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");					//接收登录页面传过来的用户名
		String password = req.getParameter("password");				//接收登录页面传过来的密码
		String code = req.getParameter("code");						//接收登录页面传过来的验证码
		String rand = (String) req.getSession().getAttribute("rand");	//接收验证码本身的值
		String info = "";
		//若验证码为空
		if(code==null || "".equals(code)){
			info="验证码不能为空";		//输出错误信息
			req.setAttribute("info", info);
			req.getRequestDispatcher("login.jsp").forward(req,resp);	//将错误信息传递到登录界面
		}
		//若验证码输入错误
		if(!code.equalsIgnoreCase(rand)){
			info="验证码错误";
			req.setAttribute("info", info);
			req.getRequestDispatcher("login.jsp").forward(req,resp);
		}
		try {
			//若用户名或者密码输入错误
			if(userid == null || "".equals(userid)||password == null||"".equals(password)||!DAOFactory.getIUsersDAOInstance().findLogin(userid, new MD5Code().getMD5ofStr(password))){
				info="用户名或密码错误";
				req.setAttribute("info", info);
				req.getRequestDispatcher("login.jsp").forward(req,resp);
			}else{
				//登录成功，将用户名和权限传递回主页面
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
