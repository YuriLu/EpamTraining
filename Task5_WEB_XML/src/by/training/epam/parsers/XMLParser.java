package by.training.epam.parsers;

import java.util.List;

import by.training.epam.entity.Candy;

public interface XMLParser {

	public List<Candy> createCandiesList(String xmlFileName);
	
}
