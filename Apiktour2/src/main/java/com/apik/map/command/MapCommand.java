package com.apik.map.command;

public class MapCommand {
	private int locnum;
	private String locname,loctype;
	private double locationx,locationy;
	
	//°Ë»ö
	private String keyWord,keyField;
	
	public int getLocnum() {
		return locnum;
	}
	public void setLocnum(int locnum) {
		this.locnum = locnum;
	}
	public String getLocname() {
		return locname;
	}
	public void setLocname(String locname) {
		this.locname = locname;
	}
	public String getLoctype() {
		return loctype;
	}
	public void setLoctype(String loctype) {
		this.loctype = loctype;
	}
	public double getLocationx() {
		return locationx;
	}
	public void setLocationx(double locationx) {
		this.locationx = locationx;
	}
	public double getLocationy() {
		return locationy;
	}
	public void setLocationy(double locationy) {
		this.locationy = locationy;
	}
	public String getKeyWord() {
		return keyWord;
	}
	public void setKeyWord(String keyWord) {
		this.keyWord = keyWord;
	}
	public String getKeyField() {
		return keyField;
	}
	public void setKeyField(String keyField) {
		this.keyField = keyField;
	}
	
	
}
