package by.training.epam.builders;

import by.training.epam.parsers.DOMParser;
import by.training.epam.parsers.SAXParser;
import by.training.epam.parsers.StAXParser;
import by.training.epam.parsers.XMLParser;

public class CandiesBuilderFactory {

	private enum TypeParser {
		SAX, STAX, DOM
	}
	
	public XMLParser createCandiesListBuilder(String typeParser){
		
		TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
		
		switch (type){
		case SAX:
			return new SAXParser();
		case DOM:
			return new DOMParser();
		case STAX:
			return StAXParser.getInstance();
		default:
			throw new EnumConstantNotPresentException (type.getDeclaringClass(), type.name());
		}
		
	}
}
