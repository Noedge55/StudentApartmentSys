package edu.sas.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import edu.sas.vo.Student;

public class ExcelHelper {
	public static String msg = ""; 
	
	public List<Student> importXlsx(InputStream is) {
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
					if(row.getLastCellNum() != 5) {
						msg = "ÿ�е�Ԫ�����ֻ��Ϊ5��";
						break;
					}
					Student vo = new Student();
					vo.setStuno(row.getCell(0).getStringCellValue());
					vo.setStuname(row.getCell(1).getStringCellValue());
					int sex = row.getCell(2).getStringCellValue() == "��"?1:0;
					vo.setSex(sex);
					vo.setMajor(row.getCell(3).getStringCellValue());
					vo.setClassname(row.getCell(4).getStringCellValue());
					vo.setPhonenum(row.getCell(5).getStringCellValue());
					list.add(vo);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
