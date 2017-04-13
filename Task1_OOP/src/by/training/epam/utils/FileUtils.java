package by.training.epam.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import by.training.epam.builders.Director;
import by.training.epam.builders.SweetsBuilder;
import by.training.epam.builders.SweetsBuildersPool;
import by.training.epam.entity.Sweet;

public class FileUtils {

	private static final Logger log = Logger.getLogger("FileUtils.class");

	public static final String FILE_FULL_PATH = "./res/Sweets.txt";

	public List<Sweet> getSweetsListFromFile() {

		List<Sweet> sweetsList = new ArrayList<>();

		File file = new File(FILE_FULL_PATH);

		try {

			List<String> fileRows = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
			Map<String, Integer> sweetSet = parseFileRows(fileRows);
			sweetsList = creatCertainObjects(sweetSet);

		} catch (IOException e) {
			log.error(e);
		}

		return sweetsList;

	}

	private Map<String, Integer> parseFileRows(List<String> fileRows) {

		Map<String, Integer> map = new HashMap<>();

		String[] splitedRow;

		for (int i = 1; i < fileRows.size(); i++) {

			splitedRow = fileRows.get(i).trim().split(",");

			if (splitedRow.length == 2) {

				try {
					int count = Integer.parseInt(splitedRow[1]);
					map.put(splitedRow[0], count);
				} catch (NumberFormatException e) {
					log.error(e);
				}

			} else {
				if (!("".equals(splitedRow[0]))) {
					log.warn("Invalid row`s format: " + fileRows.get(i));
				}
			}
		}

		return map;
	}

	private List<Sweet> creatCertainObjects(Map<String, Integer> sweetSet) {

		List<Sweet> sweetsList = new ArrayList<Sweet>();
		SweetsBuildersPool sbp = new SweetsBuildersPool();
		Director director = new Director();

		/*
		 * Here we compare certain class simple name in builder`s pool with
		 * one`s type of sweet in our file. Thus, we specify in file name of
		 * certain builder`s class. Of course we could create pool with
		 * builder`s objects and during iteration just ask some field "name" and
		 * compare it for example, but in this case we had to create all objects
		 * in the pool. But now we can create objects ONLY if "string" element
		 * equals to our class. I thought it would be better :)
		 */

		for (Map.Entry<String, Integer> element : sweetSet.entrySet()) {

			int count = 0;

			for (Class<? extends SweetsBuilder> clazz : sbp) {

				count++;

				if (clazz.getSimpleName().equals(element.getKey())) {
					try {
						director.setBuilder(clazz.newInstance());

						for (int i = 0; i < element.getValue(); i++) {
							sweetsList.add(director.createSweet());
						}

					} catch (InstantiationException | IllegalAccessException e) {
						log.error(e);
					}
					count--;
				}

			}

			if (count == sbp.getPoolSize()) {
				log.warn("Such builder doesn`t exist: " + element.getKey());
			}
		}

		return sweetsList;
	}

}
