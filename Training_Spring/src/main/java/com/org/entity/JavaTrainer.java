package com.org.entity;

public class JavaTrainer implements Trainer {
	
	private String name;
	private List<String> modules;
	
	public JavaTrainer() {
		System.out.println("Default contructor of Java Trainer.");
	}

	public JavaTrainer(String name, List<String> modules) {
		super();
		this.name = name;
		this.modules = modules;
		System.out.println("Parameterized contructor of Java Trainer.");
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getModules() {
		return modules;
	}

	public void setModules(List<String> modules) {
		this.modules = modules;
	}

	public void train() {
		System.out.println(name+" is teaching "+modules);
	}

	@Override
	public String toString() {
		return "JavaTrainer [name=" + name + ", modules=" + modules + "]";
	}
	
	

}
