package edu.sas.vo;

import java.util.Date;
/*
 * 维修表vo类
 */
public class Repairs {
	private String repno;	//维修单编号
	private String dorno;	//寝室号
	private String gname;	//物品名称
	private Date writime;	//记录时间
	private Date reptime;	//维修时间
	private boolean isRepair;	//是否维修
	private String reptext;	//维修情况说明
	public String getRepno() {
		return repno;
	}
	public void setRepno(String repno) {
		this.repno = repno;
	}
	public String getDorno() {
		return dorno;
	}
	public void setDorno(String dorno) {
		this.dorno = dorno;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public Date getWritime() {
		return writime;
	}
	public void setWritime(Date writime) {
		this.writime = writime;
	}
	public Date getReptime() {
		return reptime;
	}
	public void setReptime(Date reptime) {
		this.reptime = reptime;
	}
	public boolean isRepair() {
		return isRepair;
	}
	public void setRepair(boolean isRepair) {
		this.isRepair = isRepair;
	}
	public String getReptext() {
		return reptext;
	}
	public void setReptext(String reptext) {
		this.reptext = reptext;
	}
	
}
