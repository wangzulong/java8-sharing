package jdk8.sharing.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import jdk8.sharing.stream.Dish;

public class TestMyCollector {

	private static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
	
	private static void testMyCollect() {
		MyCollector<Dish> myCollector = new MyCollector<Dish>();
		
		Optional.of(menu.stream().collect(myCollector)).ifPresent(System.out::println);
	}
	public static void main(String[] args) {
		TestMyCollector.testMyCollect();

	}

}
