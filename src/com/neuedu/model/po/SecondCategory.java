package com.neuedu.model.po;

public class SecondCategory {
	private int sc_id;
	private String sc_name;
	private String sc_info;
	private FirstCategory fc;
	private boolean isDelete;
	
	public int getSc_id() {
		return sc_id;
	}
	public void setSc_id(int sc_id) {
		this.sc_id = sc_id;
	}
	public String getSc_name() {
		return sc_name;
	}
	public void setSc_name(String sc_name) {
		this.sc_name = sc_name;
	}
	public String getSc_info() {
		return sc_info;
	}
	public void setSc_info(String sc_info) {
		this.sc_info = sc_info;
	}
	public FirstCategory getFc() {
		return fc;
	}
	public void setFc(FirstCategory fc) {
		this.fc = fc;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	
}
