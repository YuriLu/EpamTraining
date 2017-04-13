package by.training.epam.utils;

import java.util.Comparator;

import by.training.epam.entity.Word;

public class TaskEightComparator implements Comparator<Word> {

	private static final String VOWELS = "aAeEiIoOuUyY";
	
	@Override
	public int compare(Word o1, Word o2) {
	
		return findFirstConsonant(o1)-findFirstConsonant(o2);
		
	}

	private char findFirstConsonant(Word word) {

		for (int i = 0; i < word.toString().length(); i++) {
			if(!(VOWELS.contains(Character.valueOf(word.toString().charAt(i)).toString()))){
				return word.toString().charAt(i);
			}
		}
		return Character.MAX_VALUE;
	}

}
