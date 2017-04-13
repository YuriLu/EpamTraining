package by.training.epam.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import by.training.epam.entity.Text;
import by.training.epam.entity.Word;
import by.training.epam.utils.TaskEightComparator;
import by.training.epam.utils.TaskSevenComparator;

public class Tasks {

	public void taskSix(Text text) {

		//6. ���������� ����� ������ � ���������� ������� �� ������ 
		//�����. �����, ������������ � ����� �����, �������� � ������� ������.
		
		List<Word> list = text.getAllWords();

		Collections.sort(list);

		char firstChar = 32;

		for (int i = 0; i < list.size(); i++) {

			if (list.get(i).toString().charAt(0) == firstChar) {
				System.out.print(list.get(i) + ", ");
			} else {

				firstChar = list.get(i).toString().charAt(0);
				System.out.println();
				System.out.print(list.get(i) + " ");
			}

		}

	}
	
	public void taskSeven(Text text){
		
		//7. �������������� ����� ������ �� ����������� ���� ������� ����
		//(��������� ���������� ������� � ������ ���������� ���� � �����).
		
		List<Word> list = text.getAllWords();
		
		Collections.sort(list, new TaskSevenComparator());
		
		for (Word word : list) {
			System.out.println(word);
		}
		
	}
	
	public void taskEight(Text text){
		
		//8. ����� ������, ������������ � ������� ����, ��������������
		//� ���������� ������� �� ������ ��������� ����� �����.
		
		List<Word> allWords = text.getAllWords();
		List<Word> allVowelStartsWords = new ArrayList<>();
		
		String vowels = "aAeEiIoOuUyY";
		
		for (Word word : allWords) {
			if(vowels.contains(Character.valueOf(word.toString().charAt(0)).toString())){
				allVowelStartsWords.add(word);
			}
		}
		
		Collections.sort(allVowelStartsWords, new TaskEightComparator());
		
		for (Word word : allVowelStartsWords) {
			System.out.println(word);
		}
	}

}
