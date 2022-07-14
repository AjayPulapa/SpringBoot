package com.mss.task.jpacrud;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Studenttable")
public class Student {
    @Id
    private int id;
    private String name;
    private String dept;
    private int age;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
    
}
