package edu.sas.vo;

import java.util.Date;
/*
 * ά�ޱ�vo��
 */
public class Repairs {
	private String repno;	//ά�޵����
	private String dorno;	//���Һ�
	private String gname;	//��Ʒ����
	private Date writime;	//��¼ʱ��
	private Date reptime;	//ά��ʱ��
	private boolean isRepair;	//�Ƿ�ά��
	private String reptext;	//ά�����˵��
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
