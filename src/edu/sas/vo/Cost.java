package edu.sas.vo;

import java.util.Date;
/*
 * �������ͷ�����ϸ��
 */
public class Cost {
	private String costno ;	//���õ���
	private String dorno;	//���Һ�
	private int rctype ;	//��ֵ����
	private int rcmoney;	//��ֵ���
	private Date rctime;	//��ֵʱ��
	private int used ;		//��ʹ����
	private int remain ;	//ʣ����
	private int totmoney;	//����
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
