package edu.sas.vo;

//import java.util.Set;
/*
 * 公寓表的vo类
 */
public class Apartment {
	private String apartno;						//公寓号
	private int lvdornum;						//公寓内每一层寝室数量
	private int stutotnum;						//公寓内容纳总人数
	private int stulivnum;						//公寓内已经入住的人数
	private float area;							//公寓面积
	private int levels;							//寝室层数

	public float getArea() {
		return area;
	}
	public void setArea(float area) {
		this.area = area;
	}
	//	private Set<Dormitory> dormitories;			//公寓内的寝室信息
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
