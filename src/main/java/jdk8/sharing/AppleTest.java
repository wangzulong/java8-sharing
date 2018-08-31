package jdk8.sharing;

import java.util.ArrayList;
import java.util.List;

public class AppleTest {

	public static void main(String[] args) {
//		List<Apple> redAndHeavyApples = filterApples(inventory, new RedAndHeavyPredicate());
		
//		List<Apple> redAndHeavyApples = filterApples(inventory, (apple) -> "red".equals(apple.getColor()) && (150 < apple.getWeight()));


	}

	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
		List<Apple> resultList = new ArrayList<Apple>(inventory.size());
		for(Apple apple: inventory) {
			if (predicate.test(apple)) {
				resultList.add(apple);
			}
		}
		
		return resultList;
	}
}
