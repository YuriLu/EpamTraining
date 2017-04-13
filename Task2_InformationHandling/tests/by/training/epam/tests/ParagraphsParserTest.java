package by.training.epam.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import by.training.epam.entity.Paragraph;
import by.training.epam.entity.Punctuation;
import by.training.epam.entity.Sentence;
import by.training.epam.entity.Space;
import by.training.epam.entity.Word;
import by.training.epam.parsers.ParagraphsParser;

public class ParagraphsParserTest {

	@Test
	public void testParseTitle() {
		String someTitle = "1. Title";
		boolean flag = true;
		
		Punctuation punctOne = new Punctuation("1");
		Punctuation punctTwo = new Punctuation(".");
		Space space = new Space(" ");
		Word word = new Word("Title");
		
		ParagraphsParser parpar = new ParagraphsParser();
		Paragraph parFromMethod = parpar.parseTitle(someTitle);
		
		for (Sentence sentence : parFromMethod) {
			if(!sentence.getPart(0).equals(punctOne)){
				flag = false;
			}
			if(!sentence.getPart(1).equals(punctTwo)){
				flag = false;
			}
			if(!sentence.getPart(2).equals(space)){
				flag = false;
			}
			if(!sentence.getPart(3).equals(word)){
				flag = false;
			}
		}
		
		assertTrue(flag);
	}

	@Test
	public void testParseSentenses() {
		
		String someText = " Sentence. Sentence:";
		boolean flag = true;
		
		Space space = new Space(" ");
		Word word = new Word("Sentence");
		Punctuation puncOne = new Punctuation(".");
		Punctuation puncTwo = new Punctuation(":");
		
		ParagraphsParser parpar = new ParagraphsParser();
		Paragraph parFromMethod = parpar.parseSentenses(someText);
		
		for (Sentence sentence : parFromMethod) {
			if(!sentence.getPart(0).equals(space)){
				flag = false;
			}
			if(!sentence.getPart(1).equals(word)){
				flag = false;
			}
			if(!(sentence.getPart(2).equals(puncOne)) &&
					!(sentence.getPart(2).equals(puncTwo))){
				flag = false;
			}
		}
		
		assertTrue(flag);
	}

	@Test
	public void testParseCode() {
		String someCode = " void {}";
		boolean flag = true;
		
		Space space = new Space(" ");
		Word word = new Word("void");
		Punctuation puncOne = new Punctuation("{");
		Punctuation puncTwo = new Punctuation("}");
		
		ParagraphsParser parpar = new ParagraphsParser();
		Paragraph parFromMethod = parpar.parseCode(someCode);
		
		for (Sentence sentence : parFromMethod) {
			if(!sentence.getPart(0).equals(space)){
				flag = false;
			}
			if(!sentence.getPart(1).equals(word)){
				flag = false;
			}
			if(!sentence.getPart(2).equals(space)){
				flag = false;
			}
			if(!sentence.getPart(3).equals(puncOne)){
				flag = false;
			}
			if(!sentence.getPart(4).equals(puncTwo)){
				flag = false;
			}
		}
		
		assertTrue(flag);
	}

}
