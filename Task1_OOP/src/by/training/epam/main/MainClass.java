package by.training.epam.main;


import by.training.epam.builders.PresentBuilder;
import by.training.epam.entity.Present;
import by.training.epam.entity.Sweet;

public class MainClass {
	
	public static void main(String[] args) {

		Present present = PresentBuilder.createPresent();

		present.sortByWeight();
		
		for (Sweet sweet : present) {
			System.out.println(sweet);
		}

		System.out.println("_______________________________________________");

		for (Sweet sweet : present.getSweetsWithShugarAmountInRange(110, 150)) {
			System.out.println(sweet + " Sugar amount:" + sweet.getSugarAmount());
		}

	}

}
