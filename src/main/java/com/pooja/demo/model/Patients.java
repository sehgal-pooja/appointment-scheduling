package com.pooja.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
public class Patients {
	
	@Transient
	public final static String SEQUENCE_NAME = "patient_sequence";
	
	
	@Id
	private long pid;
	
	private String pname;
	private String address;
	private String pdept;
	private boolean status;
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPdept() {
		return pdept;
	}
	public void setPdept(String pdept) {
		this.pdept = pdept;
	}
	
}
