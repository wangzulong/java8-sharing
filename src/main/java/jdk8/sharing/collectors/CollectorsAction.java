package jdk8.sharing.collectors;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

import jdk8.sharing.stream.Dish;
import jdk8.sharing.stream.Dish.Type;

public class CollectorsAction {

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
	
	public void testCollectingAndThen() {
		Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), 
				d -> "average Calories is " + d))).ifPresent(System.out::println);
		
	}
	
	public void testGroupingByConcurrent() {
		Optional.ofNullable(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType, 
				Collectors.averagingDouble(Dish::getCalories)))).ifPresent(System.out::println);
		
	}
	
	public void testJoining() {
		Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",")))
			.ifPresent(System.out::println);
	}
	
	public void testJoining2() {
		Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",", "st_", "_end")))
			.ifPresent(System.out::println);
	}
	
	public void testMapping() {
		Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType, 
				Collectors.mapping(Dish::getName, Collectors.toList())))).ifPresent(System.out::println);;
	}
	
	
	public static void main(String[] args) {
		CollectorsAction collectorsAction = new CollectorsAction();
//		collectorsAction.testCollectingAndThen();
//		collectorsAction.testGroupingByConcurrent();
//		collectorsAction.testJoining();
//		collectorsAction.testJoining2();
		collectorsAction.testMapping();
	}

}
