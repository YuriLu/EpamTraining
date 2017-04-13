package by.training.epam.builders;

import by.training.epam.entity.Lollipop;
import by.training.epam.entity.LollipopFiller;
import by.training.epam.entity.LollipopTastes;
import by.training.epam.entity.Sweet;

public class LollipopBarbarisBuilder implements SweetsBuilder{

	@Override
	public Sweet createSweet() {
		return new Lollipop("Barbaris", "Spartak", "470-97", 10, 110, LollipopTastes.STARWBERRY, LollipopFiller.STRAWBERRY_JAM);
	}
	
	

}
