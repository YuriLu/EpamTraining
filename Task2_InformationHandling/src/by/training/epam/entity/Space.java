package by.training.epam.entity;

public class Space extends SimplePart {

	public Space(String item) {
		super(item);
	}

	@Override
	public boolean isWord() {
		return false;
	}

	@Override
	public boolean isSpace() {
		return true;
	}

	@Override
	public boolean isPunctuation() {
		return false;
	}

	
}
