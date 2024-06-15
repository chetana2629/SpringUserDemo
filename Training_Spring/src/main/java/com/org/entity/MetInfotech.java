package com.org.entity;

public class MetInfotech implements TrainingCompany {

	private Trainer trainer;
	
	public MetInfotech() {
		this.trainer=trainer;
		System.out.println("Default contructor of MetInfotech");
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}
     public void conductTaining() {
    	 System.out.println("Metinfotech Conducting Training");
    	 trainer.train();
     }
	@Override
	public String toString() {
		return "MetInfotech [trainer=" + trainer + "]";
	}

	@Override
	public void conductTrainig() {
		// TODO Auto-generated method stub
		
	}

}
