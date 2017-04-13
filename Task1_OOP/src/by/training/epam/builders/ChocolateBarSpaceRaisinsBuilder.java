package by.training.epam.builders;

import by.training.epam.entity.ChocolateBar;
import by.training.epam.entity.ChocolateBarFiller;
import by.training.epam.entity.Sweet;

public class ChocolateBarSpaceRaisinsBuilder implements SweetsBuilder{

	@Override
	public Sweet createSweet() {

		return new ChocolateBar("Space Raisins", "Gomeldrev", "470-97", 85, 270, 70, false, ChocolateBarFiller.RAISINS);

	}
	
}
