package edu.sas.vo;

//import java.util.Set;
/*
 * ��Ԣ���vo��
 */
public class Apartment {
	private String apartno;						//��Ԣ��
	private int lvdornum;						//��Ԣ��ÿһ����������
	private int stutotnum;						//��Ԣ������������
	private int stulivnum;						//��Ԣ���Ѿ���ס������
	private float area;							//��Ԣ���
	private int levels;							//���Ҳ���

	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	//	private Set<Dormitory> dormitories;			//��Ԣ�ڵ�������Ϣ
//	public Set<Dormitory> getDormitories() {
//		return dormitories;
//	}
//	public void setDormitories(Set<Dormitory> dormitories) {
//		this.dormitories = dormitories;
//	}
	public String getApartno() {
		return apartno;
	}
	public void setApartno(String apartno) {
		this.apartno = apartno;
	}
	public int getLvdornum() {
		return lvdornum;
	}
	public void setLvdornum(int lvdornum) {
		this.lvdornum = lvdornum;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
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
