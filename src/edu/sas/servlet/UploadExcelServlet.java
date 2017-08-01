package edu.sas.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;

import edu.sas.factory.DAOFactory;
import edu.sas.vo.Student;

/**
 * Servlet implementation class UploadExcelServlet
 * ��������ѧ��Excel��
 * 
 * @author yzc
 */
@WebServlet("/UploadExcelServlet")
public class UploadExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String msg = ""; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadExcelServlet() {
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
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding(request.getCharacterEncoding());	//���ñ����ʽ
		try {
			List<FileItem> fileList = upload.parseRequest(request);
			List<Student> list = null;
			for(FileItem item:fileList){
				list = this.importXlsx(item.getInputStream());
				for(Student vo:list){
					DAOFactory.getIStudentDAOInstance().doCreate(vo);
					msg = "����ɹ�";
				}				
			}
			request.setAttribute("msg",msg);
			request.getRequestDispatcher("student-add.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Student> importXlsx(InputStream is) throws IOException {
		List<Student> list = new ArrayList<Student>();
		try {
			Workbook wb = WorkbookFactory.create(is);
			for(int i = 0,len = wb.getNumberOfSheets(); i < len ; i++) {
				Sheet sheet = wb.getSheetAt(i);
				if(sheet == null) {
					msg = "excel����������Ϊ��";
					break;
				}
				for(int j = 1 ; j <= sheet.getLastRowNum() ; j ++) {
					Row row = sheet.getRow(j);
					if(row == null) {
						msg = "�ñ���Ϊ��";
						break;
					}
					if(row.getLastCellNum() != 6) {
						msg = "ÿ�е�Ԫ�����ֻ��Ϊ5��";
						break;
					}
					Student vo = new Student();
					vo.setStuno(getValue(row.getCell(0)));
					vo.setStuname(getValue(row.getCell(1)));
					int sex = (getValue(row.getCell(2)) == "��"?1:0);
					vo.setSex(sex);
					vo.setMajor(getValue(row.getCell(3)));
					vo.setClassname(getValue(row.getCell(4)));
					vo.setPhonenum(getValue(row.getCell(5)));
					list.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			is.close();
		}
		return list;
	}
	public String getValue(Cell cell){
		String result = "" ;
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:									//����Ԫ���ֵΪboolean����
			result = cell.getBooleanCellValue() + "";
			break;
		case STRING:									//����Ԫ���ֵΪString����
			result = cell.getStringCellValue();
			break;
		case FORMULA:									//����Ԫ���ֵΪFormula����
			result = cell.getCellFormula();
			break;
		case NUMERIC:									//����Ԫ���ֵΪ��ֵ��
			if(DateUtil.isCellDateFormatted(cell)){//��Ϊ����ʱ
				result = DateUtil.getJavaDate(cell.getNumericCellValue()).toString();
			}else{
				result = cell.getNumericCellValue() + "";				
			}
			break; 
		default:
			break;
		}
		return result;
	}
}
