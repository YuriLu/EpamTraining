package by.training.epam.main;

import java.util.List;

import by.training.epam.entity.Text;
import by.training.epam.parsers.TextParser;
import by.training.epam.utils.FileUtils;

public class MainClass {

	public final static String INITIAL_FILE_PATH = "./res/essence.txt";
	public final static String RESTORED_FILE_PATH = "./res/restored.txt";
	
	public static void main(String[] args){
		
		List<String> list = FileUtils.getFileRows(INITIAL_FILE_PATH);
		
		TextParser tp = new TextParser(list);
		Text text = tp.parseRows();
		
		FileUtils.restoreTextInFile(RESTORED_FILE_PATH, text);
		
		// Tasks tasks = new Tasks();
		// tasks.taskSix(text);
		// tasks.taskSeven(text);
		// tasks.taskEight(text);
		
		
	}
	
}
