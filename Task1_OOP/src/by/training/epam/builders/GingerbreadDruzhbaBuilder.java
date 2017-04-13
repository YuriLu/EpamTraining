package by.training.epam.builders;

import by.training.epam.entity.Gingerbread;
import by.training.epam.entity.GingerbreadFiller;
import by.training.epam.entity.Sweet;

public class GingerbreadDruzhbaBuilder implements SweetsBuilder {

	@Override
	public Sweet createSweet() {
		return new Gingerbread("Druzhba", "Bread Factory No1", "450-40", 60, 20, 200, 5, GingerbreadFiller.RAISINS);
	}

}
