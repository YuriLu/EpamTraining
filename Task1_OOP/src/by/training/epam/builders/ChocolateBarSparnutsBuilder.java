package by.training.epam.builders;

import by.training.epam.entity.ChocolateBar;
import by.training.epam.entity.ChocolateBarFiller;
import by.training.epam.entity.Sweet;

public class ChocolateBarSparnutsBuilder implements SweetsBuilder {

	@Override
	public Sweet createSweet() {

		return new ChocolateBar("Sparnuts", "Spartak", "470-97", 100, 250, 80, false, ChocolateBarFiller.NUTS);

	}

}
