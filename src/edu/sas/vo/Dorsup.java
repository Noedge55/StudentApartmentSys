package edu.sas.vo;
/**
 * 公寓管理员表vo类
 *
 */
public class Dorsup {
	private String supno;			//公寓管理员编号
	private String supname;			//公寓管理员姓名
	private String apartno;			//公寓号
	private String phonenum;		//手机号码
	private Apartment apartment;	//公寓信息
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	public String getSupno() {
		return supno;
	}
	public void setSupno(String supno) {
		this.supno = supno;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getApartno() {
		return apartno;
	}
	public void setApartno(String apartno) {
		this.apartno = apartno;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	
}
