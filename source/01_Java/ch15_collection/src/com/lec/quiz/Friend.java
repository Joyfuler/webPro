package com.lec.quiz;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Friend {
	private String name;
	private String phone;
	private String address;
	private Date birthday;
	
	
	
	
	public Friend(String name, String address, String phone, Date birthday) {
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.birthday = birthday;
		
			
	}

	@Override
	public String toString() {
		if (birthday != null) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
		return "이름 : " + name + "\n주소 : " + address + "\n핸드폰 : " + phone + "\n생일 : " + sdf.format(birthday);
		} else {
		return "이름 : " + name + "\n주소 : " + address + "\n핸드폰 : " + phone + "\n생일 : ";	
		}
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	
	
	
}
