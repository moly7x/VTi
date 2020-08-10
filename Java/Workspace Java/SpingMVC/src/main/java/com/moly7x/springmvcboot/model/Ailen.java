//
package com.moly7x.springmvcboot.model;

/**
 * This class is . 
 * 
 * @author: Tân
 * @create_date: 30/07/2020
 */
public class Ailen {
	private int aid;
	private String aname;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	
	@Override
	public String toString() {
		return "Ailen [aid=" + aid + ", aname=" + aname + "]";
	}
		
}
