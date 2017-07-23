package edu.sas.vo;

import java.util.Date;
/*
 * 卫生管理表vo类
 */
public class Hygiene {
	private String hygno;	//卫生编号
	private String dorno;	//寝室编号
	private Date cktime;	//检查日期
	private int hyscore;	//卫生分数
	private String hytext;	//卫生情况备注
	public String getHygno() {
		return hygno;
	}
	public void setHygno(String hygno) {
		this.hygno = hygno;
	}
	public String getDorno() {
		return dorno;
	}
	public void setDorno(String dorno) {
		this.dorno = dorno;
	}
	public Date getCktime() {
		return cktime;
	}
	public void setCktime(Date cktime) {
		this.cktime = cktime;
	}
	public int getHyscore() {
		return hyscore;
	}
	public void setHyscore(int hyscore) {
		this.hyscore = hyscore;
	}
	public String getHytext() {
		return hytext;
	}
	public void setHytext(String hytext) {
		this.hytext = hytext;
	} 
}
