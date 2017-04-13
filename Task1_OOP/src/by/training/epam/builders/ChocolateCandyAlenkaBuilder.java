package by.training.epam.builders;

import by.training.epam.entity.ChocolateCandy;
import by.training.epam.entity.ChocolateCandyFiller;
import by.training.epam.entity.Sweet;

public class ChocolateCandyAlenkaBuilder implements SweetsBuilder {

	@Override
	public Sweet createSweet() {

		return new ChocolateCandy("Alenka", "Spartak", "4570-93", 27, 130, 40, true,
				ChocolateCandyFiller.NONE);
	}
	
}
