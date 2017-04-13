package by.training.epam.builders;

import by.training.epam.entity.Sweet;

public class Director {

	private SweetsBuilder builder;
	
	public void setBuilder(SweetsBuilder builder){
		this.builder = builder;
	}

	public Sweet createSweet() {
		return builder.createSweet();
	}

}
