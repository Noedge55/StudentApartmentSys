package edu.sas.vo;

import java.util.Date;
/*
 * 各种类型费用明细表
 */
public class Cost {
	private String costno ;	//费用单号
	private String dorno;	//寝室号
	private int rctype ;	//充值类型
	private int rcmoney;	//充值金额
	private Date rctime;	//充值时间
	private int used ;		//已使用量
	private int remain ;	//剩余量
	private int totmoney;	//总量
	public String getCostno() {
		return costno;
	}
	public void setCostno(String costno) {
		this.costno = costno;
	}
	public String getDorno() {
		return dorno;
	}
	public void setDorno(String dorno) {
		this.dorno = dorno;
	}
	public int getRctype() {
		return rctype;
	}
	public void setRctype(int rctype) {
		this.rctype = rctype;
	}
	public int getRcmoney() {
		return rcmoney;
	}
	public void setRcmoney(int rcmoney) {
		this.rcmoney = rcmoney;
	}
	public Date getRctime() {
		return rctime;
	}
	public void setRctime(Date rctime) {
		this.rctime = rctime;
	}
	public int getUsed() {
		return used;
	}
	public void setUsed(int used) {
		this.used = used;
	}
	public int getRemain() {
		return remain;
	}
	public void setRemain(int remain) {
		this.remain = remain;
	}
	public int getTotmoney() {
		return totmoney;
	}
	public void setTotmoney(int totmoney) {
		this.totmoney = totmoney;
	}
}
