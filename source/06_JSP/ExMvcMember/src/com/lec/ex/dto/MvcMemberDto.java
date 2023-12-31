package com.lec.ex.dto;

import java.sql.Date;
import java.sql.Timestamp;

public class MvcMemberDto {
	private String mid;
	private String mpw;
	private String mname;
	private String memail;	
	private Date mbirth;	
	private Timestamp mrdate;
	
		
	public MvcMemberDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public MvcMemberDto(String mid, String mpw, String mname, String memail, Date mbirth, Timestamp mrdate) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.memail = memail;
		this.mbirth = mbirth;
		this.mrdate = mrdate;
	}



	public String getMid() {
		return mid;
	}



	public void setMid(String mid) {
		this.mid = mid;
	}



	public String getMpw() {
		return mpw;
	}



	public void setMpw(String mpw) {
		this.mpw = mpw;
	}



	public String getMname() {
		return mname;
	}



	public void setMname(String mname) {
		this.mname = mname;
	}



	public String getMemail() {
		return memail;
	}



	public void setMemail(String memail) {
		this.memail = memail;
	}



	public Date getMbirth() {
		return mbirth;
	}



	public void setMbirth(Date mbirth) {
		this.mbirth = mbirth;
	}



	public Timestamp getMrdate() {
		return mrdate;
	}



	public void setMrdate(Timestamp mrdate) {
		this.mrdate = mrdate;
	}



	@Override
	public String toString() {
		return "MvcMemberDto [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", memail=" + memail + ", mbirth="
				+ mbirth + ", mrdate=" + mrdate + "]";
	}
	
	
	
}
