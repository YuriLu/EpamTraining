package by.training.epam.builders;

import by.training.epam.entity.ChocolateBar;
import by.training.epam.entity.ChocolateBarFiller;
import by.training.epam.entity.Sweet;

public class ChocolateBarAirFunBuilder implements SweetsBuilder {

	
	@Override
	public Sweet createSweet() {

		return new ChocolateBar("Air Fun", "Spartak", "470-97", 85, 190, 20, true, ChocolateBarFiller.NONE);
	}

	
	
}
