package by.training.epam.builders;

import by.training.epam.entity.Lollipop;
import by.training.epam.entity.LollipopFiller;
import by.training.epam.entity.LollipopTastes;
import by.training.epam.entity.Sweet;

public class LollipopBuratinoBuilder implements SweetsBuilder{

	@Override
	public Sweet createSweet() {
	
		return new Lollipop("Buratino", "Kommunarka", "470-97", 10, 100, LollipopTastes.BURATINO, LollipopFiller.NONE);

	}

}
