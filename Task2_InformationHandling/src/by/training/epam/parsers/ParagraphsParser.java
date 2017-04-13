package by.training.epam.parsers;

import java.util.ArrayList;
import java.util.List;

import by.training.epam.entity.Paragraph;
import by.training.epam.entity.ParagraphCode;
import by.training.epam.entity.ParagraphText;
import by.training.epam.entity.ParagraphTitle;
import by.training.epam.entity.Punctuation;
import by.training.epam.entity.Sentence;
import by.training.epam.entity.SimplePart;
import by.training.epam.entity.Space;
import by.training.epam.entity.Word;

public class ParagraphsParser {

	public ParagraphsParser() {
	}

	public Paragraph parseTitle(String row) {

		List<SimplePart> simpleList = parseToSimpleParts(row);

		Sentence sentence = new Sentence(simpleList);
		List<Sentence> list = new ArrayList<>();
		list.add(sentence);
		return new ParagraphTitle(list);
	}

	public Paragraph parseSentenses(String row) {

		List<Sentence> list = new ArrayList<>();
		String[] splitSentences = row.split("\\.");
		for (String sentence : splitSentences) {
			if (!sentence.endsWith(":")) {
				sentence = sentence.concat(".");
			}
			List<SimplePart> simpleList = parseToSimpleParts(row);
			list.add(new Sentence(simpleList));
		}

		return new ParagraphText(list);

	}

	public Paragraph parseCode(String row) {

		List<SimplePart> simpleList = parseToSimpleParts(row);
		
		Sentence sentence = new Sentence(simpleList);
		List<Sentence> list = new ArrayList<>();
		list.add(sentence);
		return new ParagraphCode(list);

	}

	private List<SimplePart> parseToSimpleParts(String row) {
		List<SimplePart> simpleList = new ArrayList<>();

		StringBuilder strb = new StringBuilder();

			for (char character : row.toCharArray()) {
				if (Character.isLetter(character)) {
					strb.append(character);
				} else {
					if (strb.length() != 0) {
						simpleList.add(new Word(strb.toString()));
						strb = new StringBuilder();
					}
					
					if(Character.isWhitespace(character)){
						simpleList.add(new Space(String.valueOf(character)));
					} else {
						simpleList.add(new Punctuation(String.valueOf(character)));
					}
				}
			}

			if (strb.length() != 0) {
				simpleList.add(new Word(strb.toString()));
				strb = new StringBuilder();
			}

		return simpleList;
	}

}
