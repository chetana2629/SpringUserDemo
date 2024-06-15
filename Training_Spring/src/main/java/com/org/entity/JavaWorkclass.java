package com.org.entity;

public class JavaWorkclass implements Worksop {

	private TrainingCompany company;
	
	public JavaWorkclass() {
		System.out.println("Defalut contructor of JavaWorkshop");
	}

	public JavaWorkclass(TrainingCompany company) {
		super();
		this.company = company;
		System.out.println("Parameterized Constructor of Javashop");
	}

	@Override
	public void conductWorksho() {
	System.out.println("java WorkShop Started!!!");
	company.conductTrainig();
	}

	public TrainingCompany getCompany() {
		return company;
	}

	public void setCompany(TrainingCompany company) {
		this.company = company;
	}
 
	
	@Override
	public String toString() {
		return "JavaWorkclass [company=" + company + "]";
	}

}
