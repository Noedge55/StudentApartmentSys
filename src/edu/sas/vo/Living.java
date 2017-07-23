package edu.sas.vo;

import java.util.Date;

public class Living {
	private String livno;
	private String stuno;
	private String dorno;
	private Date intime;
	private Date outime;
	 public String getLivno() {
		return livno;
	}
	public void setLivno(String livno) {
		this.livno = livno;
	}
	public String getStuno() {
		return stuno;
	}
	public void setStuno(String stuno) {
		this.stuno = stuno;
	}
	public String getDorno() {
		return dorno;
	}
	public void setDorno(String dorno) {
		this.dorno = dorno;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}
	public Date getOutime() {
		return outime;
	}
	public void setOutime(Date outime) {
		this.outime = outime;
	}
}
