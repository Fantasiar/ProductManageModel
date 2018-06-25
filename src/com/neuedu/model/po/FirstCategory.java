package com.neuedu.model.po;

public class FirstCategory {
	private int fc_id;
	private String fc_name;
	private String fc_info;
	private boolean isDelete;
	
	public int getFc_id() {
		return fc_id;
	}
	public void setFc_id(int fc_id) {
		this.fc_id = fc_id;
	}
	public String getFc_name() {
		return fc_name;
	}
	public void setFc_name(String fc_name) {
		this.fc_name = fc_name;
	}
	public String getFc_info() {
		return fc_info;
	}
	public void setFc_info(String fc_info) {
		this.fc_info = fc_info;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
