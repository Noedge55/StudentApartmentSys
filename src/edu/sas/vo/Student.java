package edu.sas.vo;
/*
 *ѧ����vo��
 */
public class Student {
	private String stuno ;	//ѧ��
	private String stuname;	//ѧ������
	private int sex ;		//ѧ���Ա�
	private String major ;	//ѧ��רҵ
	private String classname ;	//ѧ���༶
	private String phonenum ;	//�ֻ�����
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
}
