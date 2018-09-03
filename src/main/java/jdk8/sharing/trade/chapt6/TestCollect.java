package jdk8.sharing.trade.chapt6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import jdk8.sharing.stream.Dish;
import jdk8.sharing.stream.Dish.Type;

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
	
	public void getCollectReduce() {
		Integer result = menu.stream().collect(Collectors.reducing(0, Dish::getCalories, (i, j) -> i + j));
		System.out.println(result);
	}
	
	public void getGroupBy() {
		Map<Type, Map<String, List<Dish>>> result = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.groupingBy(dish -> {
			if (dish.getCalories() <= 400) return "DIET";
			else if (dish.getCalories() <= 700) return "NORMAL";
			else return "FAT";
		})));
		
		System.out.println(result);
	}
	
	public void getGroupByCount() {
		Map<Type, Long> result = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.counting()));
		System.out.println(result);
	}
	
	public void findMaxCaloriesGroupByType() {
		Map<Type, Optional<Dish>> result = menu.stream().collect(Collectors.groupingBy(Dish::getType, Collectors.maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		TestCollect testCollect = new TestCollect();
//		testCollect.getSum();
//		testCollect.getSum2();
//		testCollect.getCollectReduce();
//		testCollect.getGroupBy();
//		testCollect.getGroupByCount();
		testCollect.findMaxCaloriesGroupByType();
	}

}
