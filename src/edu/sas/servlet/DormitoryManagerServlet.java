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
import edu.sas.vo.Dormitory;

/**
 * Servlet implementation class DormitoryManagerServlet
 */
@WebServlet("/DormitoryManagerServlet")
public class DormitoryManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DormitoryManagerServlet() {
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
		//获取区域名称D为东区，X为西区
		String areaEast = "D";
		String areaWest = "X";
		try {
			//将所有的公寓存入List传回主界面
			List<Apartment> listEast = DAOFactory.getIApartmentDAOInstance().findAll(areaEast);
			List<Apartment> listWest = DAOFactory.getIApartmentDAOInstance().findAll(areaWest);
			request.setAttribute("listEast", listEast);
			request.setAttribute("listWest", listWest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//主界面默认公寓号为X12
		String apartno = request.getParameter("apartno");
		if(apartno == null){
			apartno = "X12";
		}
		String keyword = request.getParameter("keyword");
		if(keyword == null){
			keyword = "";
		}
		//设置当前页，做分页操作，这里每页代表每个楼层
		int pageNow = 1 ;
		if(request.getParameter("pageNow") != null){
			//若有当前页传来，则获取当前页
			pageNow=Integer.parseInt(request.getParameter("pageNow")); 
		}
		
		try {
			//将所有寝室输出，并传回主页面
			Apartment apart = DAOFactory.getIApartmentDAOInstance().findById(apartno);
			List<Dormitory> listDormitory = DAOFactory.getIDormitoryDAOInstance().findAllPaging((apartno + "-" +keyword), pageNow, apart.getLvdornum());
			request.setAttribute("listDormitory", listDormitory);
			request.setAttribute("apartno", apartno);
			request.setAttribute("pageNow", pageNow);
			request.setAttribute("pageCount", apart.getLevels());
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("dormitory-manager.jsp").forward(request, response);
	}
}
