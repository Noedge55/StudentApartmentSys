package edu.sas.vo;
/**
 * ��Ԣ����Ա��vo��
 *
 */
public class Dorsup {
	private String supno;			//��Ԣ����Ա���
	private String supname;			//��Ԣ����Ա����
	private String apartno;			//��Ԣ��
	private String phonenum;		//�ֻ�����
	private Apartment apartment;	//��Ԣ��Ϣ
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
