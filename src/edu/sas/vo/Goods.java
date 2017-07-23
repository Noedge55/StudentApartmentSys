package edu.sas.vo;
/*
 * 物品表vo类
 */
public class Goods {
	private String dorno;	//寝室号
	private String goodno;	//物品编号
	private String dgname;	//物品名称
	private String gdcount;	//物品数量
	
	public String getDorno() {
		return dorno;
	}
	public void setDorno(String dorno) {
		this.dorno = dorno;
	}
	public String getGoodno() {
		return goodno;
	}
	public void setGoodno(String goodno) {
		this.goodno = goodno;
	}
	public String getDgname() {
		return dgname;
	}
	public void setDgname(String dgname) {
		this.dgname = dgname;
	}
	public String getGdcount() {
		return gdcount;
	}
	public void setGdcount(String gdcount) {
		this.gdcount = gdcount;
	}
}
