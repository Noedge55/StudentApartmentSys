package edu.sas.vo;

import java.util.Date;
/*
 * ���������vo��
 */
public class Hygiene {
	private String hygno;	//�������
	private String dorno;	//���ұ��
	private Date cktime;	//�������
	private int hyscore;	//��������
	private String hytext;	//���������ע
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
