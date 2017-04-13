package by.training.epam.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import by.training.epam.entity.ParagraphCode;
import by.training.epam.entity.ParagraphText;
import by.training.epam.entity.ParagraphTitle;
import by.training.epam.entity.Text;
import by.training.epam.parsers.TextParser;

public class TextParserTest {

	@Test
	public void testParseRows() {
		boolean flag = true;
		
		List<String> testRows = new ArrayList<>();
		testRows.add("1. Title");
		testRows.add(" Sentence.");
		testRows.add("  code {}");
		
		TextParser tp = new TextParser(testRows);
		Text parsed = tp.parseRows();
		
		if(!(parsed.getParagraph(0) instanceof ParagraphTitle)){
			flag = false;
		}
		if(!(parsed.getParagraph(1) instanceof ParagraphText)){
			flag = false;
		}
		if(!(parsed.getParagraph(2) instanceof ParagraphCode)){
			flag = false;
		}
		
		assertTrue(flag);
	}

}
