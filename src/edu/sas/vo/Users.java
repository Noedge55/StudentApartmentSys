package edu.sas.vo;
/*
 * �û���vo��
 */
public class Users {
	private String userid ;		//�û�id��ѧ�ţ�����Ա��ţ�
	private String password ;	//�û�����
	private int permission;		//�û�Ȩ��
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPermission() {
		return permission;
	}
	public void setPermission(int permission) {
		this.permission = permission;
	}
}
