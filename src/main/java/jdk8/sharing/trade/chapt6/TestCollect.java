package jdk8.sharing.trade.chapt6;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import jdk8.sharing.stream.Dish;

public class TestCollect {

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	
	public Integer getSum() {
		Integer result = menu.stream().collect(Collectors.summingInt(Dish::getCalories));
		System.out.println(result);
		return result;
	}
	
	public void getSum2() {
		Optional<Integer> result = menu.stream().map(Dish::getCalories).reduce(Integer::sum);
		System.out.println(result.get());
	}
	
	public static void main(String[] args) {
		TestCollect testCollect = new TestCollect();
//		testCollect.getSum();
		testCollect.getSum2();
	}

}
