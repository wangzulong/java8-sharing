package jdk8.sharing.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

public class MenuTest {

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	public static void main(String[] args) {
		MenuTest menuTest = new MenuTest();
		// menuTest.testStream2();
		// menuTest.testDishName();
		// menuTest.testVegetarian2();
		// menuTest.testNameLength();
		menuTest.testCount();
	}

	public void testStream() {
		List<String> threeHighCaloricDishNames = menu.stream().filter(d -> d.getCalories() < 400).map(Dish::getName)
				.limit(3).collect(toList());

		System.out.println(threeHighCaloricDishNames);
	}

	public void testDishName() {
		List<String> dishNames = menu.stream().map(Dish::getName).collect(toList());
		System.out.println(dishNames);
	}

	public void testStream2() {
		List<String> threeHighCaloricDishNames = menu.stream().filter(d -> {
			System.out.println("filtering: " + d.getName());
			return d.getCalories() < 400;
		}).map(d -> {
			System.out.println("mapping: " + d.getName());
			return d.getName();
		}).limit(3).collect(toList());

		System.out.println(threeHighCaloricDishNames);
	}

	public void testVegetarian() {
		List<Dish> resultList = menu.stream().filter(Dish::isVegetarian).collect(toList());
		System.out.println(resultList);
	}

	public void testVegetarian2() {
		List<Dish> resultList = menu.stream().filter(Dish::isVegetarian).limit(2).collect(toList());
		System.out.println(resultList);
	}

	public void testNameLength() {
		List<Integer> nameLengths = menu.stream().map(Dish::getName).map(String::length).collect(toList());
		System.out.println(nameLengths);
	}

	/**
	 * 测验5.3:归约 怎样用map和reduce方法数一数流中有多少个菜呢?
	 */
	public void testCount() {
		Optional<Integer> result = menu.stream().map(d -> 1).reduce(Integer::sum);
		System.out.println(result.get());
	}

}
