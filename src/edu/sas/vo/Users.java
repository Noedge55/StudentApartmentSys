package edu.sas.vo;
/*
 * 用户表vo类
 */
public class Users {
	private String userid ;		//用户id（学号，管理员编号）
	private String password ;	//用户密码
	private int permission;		//用户权限
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
