package by.training.epam.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Present implements Iterable<Sweet> {

	private List<Sweet> list;

	public Present(List<Sweet> list) {
		this.list = list;
	}

	public void putSweet(Sweet sweet){
		list.add(sweet);
	}
	
	public Sweet showSweet(int index){
		return list.get(index);
	}
	
	public void eatSweet(int index){
		list.remove(index);
	}
	
	public int getPresentSweetsCount(){
		return list.size();
	}
	
	public List<Sweet> getSweetsWithShugarAmountInRange(int from, int to) {

		List<Sweet> sugarList = new ArrayList<>();
		
		for (Sweet sweet : list) {
			if (sweet.getSugarAmount() >= from && sweet.getSugarAmount() <= to) {
				sugarList.add(sweet);
			}
		}

		return sugarList;

	}

	public void sortByWeight() {

		Collections.sort(list, new Comparator<Sweet>() {

			@Override
			public int compare(Sweet o1, Sweet o2) {
				return o1.getWeight() - o2.getWeight();
			}
		});

	}

	public int getPresentWeight() {

		int weight = 0;

		for (Sweet sweets : list) {
			weight += sweets.getWeight();
		}

		return weight;
	}

	@Override
	public Iterator<Sweet> iterator() {
		return list.iterator();
	}

}
