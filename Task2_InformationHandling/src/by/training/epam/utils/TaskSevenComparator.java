package by.training.epam.utils;

import java.util.Comparator;

import by.training.epam.entity.Word;

public class TaskSevenComparator implements Comparator<Word>{

	private static final String VOWELS = "aAeEiIoOuUyY";
	
	@Override
	public int compare(Word o1, Word o2) {
		
		if(getRelativeNumber(o1)-getRelativeNumber(o2) < 0){
			return 1;
		} else {
			if(getRelativeNumber(o1)-getRelativeNumber(o2) > 0){
				return -1;
			}
		}
		return 0;
	}
	
	private double getRelativeNumber(Word word){
		
		char[] chArr = word.getItem().toCharArray();
		int vowelCount = 0;
		for(char c : chArr){
			if(VOWELS.contains(Character.valueOf(c).toString())){ 
				vowelCount++;
			}
		}
		
		return (double)vowelCount/word.getItem().length();
	}

}
