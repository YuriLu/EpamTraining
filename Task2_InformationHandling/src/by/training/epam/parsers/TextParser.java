package by.training.epam.parsers;

import java.util.List;
import java.util.regex.Pattern;

import by.training.epam.entity.Text;

public class TextParser {

	private static final String REGEX_TITLES = "[\\s+]?[0-9].+|";
	private static final String REGEX_SENTENCES = "[\\s+]?.+(\\.|\\:)";

	private List<String> rows;

	public TextParser(List<String> rows) {
		this.rows = rows;
	}

	public Text parseRows(){
		
		Text text = new Text();
		ParagraphsParser parpar = new ParagraphsParser();
		
		for (String row : rows) {
			
			if(Pattern.matches(REGEX_TITLES, row)){
				text.addParagraph(parpar.parseTitle(row));
			} else {
				if (Pattern.matches(REGEX_SENTENCES, row)){
					text.addParagraph(parpar.parseSentenses(row));
				} else {
					text.addParagraph(parpar.parseCode(row));
				}
			}
			
		}
		
		
		return text;
	}

}
