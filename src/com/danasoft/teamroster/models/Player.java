package com.danasoft.teamroster.models;

public class Player implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	private String first_name;
	private String last_name;
	private int age;
	
	public Player() {
		
	}
	public Player(String first, String last, int age) {
		this.first_name = first;
		this.last_name = last;
		this.age = age;
	}
	
	public String getFirst() {
		return this.first_name;
	}
	public String getLast() {
		return this.last_name;
	}
	public int getAge() {
		return this.age;
	}
	
	public void setFirst(String first) {
		this.first_name = first;
	}
	public void setLast(String last) {
		this.last_name = last;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printDetails() {
		System.out.println(this.getFirst() + " " + this.getLast() + " " + this.getAge());
	}
}
