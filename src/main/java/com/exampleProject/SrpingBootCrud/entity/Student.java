package com.exampleProject.SrpingBootCrud.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="crud")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sid;
	private String sname;
	private String semail;
	private String sAddress;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSemail() {
		return semail;
	}
	public void setSemail(String semail) {
		this.semail = semail;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", semail=" + semail + ", sAddress=" + sAddress + "]";
	}
	public Student()
	{
		super();
	}

}
