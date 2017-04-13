package by.training.epam.builders;

import by.training.epam.entity.ChocolateCandy;
import by.training.epam.entity.ChocolateCandyFiller;
import by.training.epam.entity.Sweet;

public class ChocolateCandyKryzhachekBuilder implements SweetsBuilder {

	@Override
	public Sweet createSweet() {

		return new ChocolateCandy("Kryzhachek", "Kommunarka", "4570-93", 30, 100, 30, false,
				ChocolateCandyFiller.COCOA_CRUMB);
	}

}
