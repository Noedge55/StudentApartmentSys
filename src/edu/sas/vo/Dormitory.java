package edu.sas.vo;

import java.util.Set;
/**
 * 寝室表vo类
 *
 */
public class Dormitory {
	private String dorno;			//寝室号
	private String apartno;			//公寓号
	private int stutotnum;			//寝室可容纳人数
	private int stulivnum;			//寝室已居住人数
	private String stuno;			//寝室长学号
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
