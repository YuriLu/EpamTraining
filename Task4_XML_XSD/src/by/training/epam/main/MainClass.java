package by.training.epam.main;

public class MainClass {

	public static final String FILENAME = "res/Task4.xml";
	public static final String SCHEMANAME = "res/Task4xsd.xsd";
	
	public static void main(String[] args) {
		
		XmlValidator xmVal = new XmlValidator();
		xmVal.validate(FILENAME, SCHEMANAME);
		
		
	}

}
