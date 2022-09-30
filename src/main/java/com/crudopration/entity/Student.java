package com.crudopration.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int rollNo;
	private String name;
	@Override
	public String toString() {
		return "Student [id=" + id + ", rollNo=" + rollNo + ", name=" + name + "]";
	}
	public Student(int id, int rollNo, String name) {
		super();
		this.id = id;
		this.rollNo = rollNo;
		this.name = name;
	}
	public Student() {
		super();
	}
	
	
	
	

}
