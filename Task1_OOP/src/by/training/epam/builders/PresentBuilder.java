package by.training.epam.builders;

import java.util.List;

import by.training.epam.entity.Present;
import by.training.epam.entity.Sweet;
import by.training.epam.utils.FileUtils;

public class PresentBuilder {

	public static Present createPresent() {

		FileUtils utils = new FileUtils();

		List<Sweet> list = utils.getSweetsListFromFile();

		Present pres = new Present(list);

		return pres;
	}

}
