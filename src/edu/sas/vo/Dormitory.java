package edu.sas.vo;

import java.util.Set;
/**
 * ���ұ�vo��
 *
 */
public class Dormitory {
	private String dorno;			//���Һ�
	private String apartno;			//��Ԣ��
	private int stutotnum;			//���ҿ���������
	private int stulivnum;			//�����Ѿ�ס����
	private String stuno;			//���ҳ�ѧ��
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	private Set<Student> students ;
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Apartment getApartment() {
		return apartment;
	}
	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}
	private Apartment apartment ;
	public String getDorno() {
		return dorno;
	}
	public void setDorno(String dorno) {
		this.dorno = dorno;
	}
	public String getApartno() {
		return apartno;
	}
	public void setApartno(String apartno) {
		this.apartno = apartno;
	}
	public int getStutotnum() {
		return stutotnum;
	}
	public void setStutotnum(int stutotnum) {
		this.stutotnum = stutotnum;
	}
	public int getStulivnum() {
		return stulivnum;
	}
	public void setStulivnum(int stulivnum) {
		this.stulivnum = stulivnum;
	}
	
}
