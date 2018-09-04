package jdk8.sharing.collectors;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import jdk8.sharing.stream.Dish;

public class CollectorsAction {

	private static List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));
	
	private static void testCollectingAndThen() {
		Optional.ofNullable(menu.stream().collect(Collectors.collectingAndThen(Collectors.averagingInt(Dish::getCalories), 
				d -> "average Calories is " + d))).ifPresent(System.out::println);
		
	}
	
	private static void testGroupingByConcurrent() {
		Optional.ofNullable(menu.stream().collect(Collectors.groupingByConcurrent(Dish::getType,  
				Collectors.averagingDouble(Dish::getCalories)))).ifPresent(System.out::println);
		
	}
	
	private static void testJoining() {
		Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",")))
			.ifPresent(System.out::println);
	}
	
	private static void testJoining2() {
		Optional.ofNullable(menu.stream().map(Dish::getName).collect(Collectors.joining(",", "st_", "_end")))
			.ifPresent(System.out::println);
	}
	
	private static void testMapping() {
		Optional.ofNullable(menu.stream().collect(Collectors.groupingBy(Dish::getType, 
				Collectors.mapping(Dish::getName, Collectors.toList())))).ifPresent(System.out::println);;
	}
	
	private static void testMapping2() {
		Optional.of(menu.stream().collect(Collectors.mapping(Dish::getName, Collectors.joining(","))))
			.ifPresent(System.out::println);
	}
	
	private static void testMaxBy() {
		menu.stream().collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
			.ifPresent(System.out::println);
	}
	
	private static void testMinBy() {
		menu.stream().collect(Collectors.minBy(Comparator.comparingInt(Dish::getCalories)))
			.ifPresent(System.out::println);
	}
	
	private static void testReducingBinaryOperator() {
		menu.stream().collect(Collectors.reducing(BinaryOperator
				.maxBy(Comparator.comparingInt(Dish::getCalories)))).ifPresent(System.out::println);
	}
	
	private static void testReducingBinaryOperatorAnddentity() {
		Integer result = menu.stream().map(Dish::getCalories).collect(Collectors.reducing(0, (i,j) -> i+j));
		System.out.println(result);
	}
	
	private static void testReducingBinaryOperatorAnddentityAndFunction() {
		Integer result = menu.stream().collect(Collectors
				.reducing(0, Dish::getCalories, (i,j) -> i+j));
		System.out.println(result);
	}
	
	private static void testSummarizingDouble() {
		Optional.ofNullable(menu.stream().collect(Collectors.summarizingDouble(Dish::getCalories)))
		.ifPresent(System.out::println);
	}
	
	private static void testSummarizingInt() {
		Optional.ofNullable(menu.stream().collect(Collectors.summarizingInt(Dish::getCalories)))
		.ifPresent(System.out::println);
	}
	
	private static void testToCollection() {
		Optional.ofNullable(menu.stream().collect(Collectors.toCollection(LinkedList::new)))
			.ifPresent(System.out::println);;
	}
	
	private static void testToConcurrentMap() {
		Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getName, Dish::getCalories)))
			.ifPresent(System.out::println);
	}
	
	/**
	 * TYPE:TOTAL
	 */
	private static void testToConcurrentMapAndBinaryOperator() {
		Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType, 
				d -> 1, (i,j) -> i+j))).ifPresent(v -> {
					System.out.println(v);
					System.out.println(v.getClass());
				});
	}
	
	private static void testToConcurrentMapAndBinaryOperatorAndSupplier() {
		Optional.ofNullable(menu.stream().collect(Collectors.toConcurrentMap(Dish::getType, 
				d -> 1, (i,j) -> i+j, ConcurrentSkipListMap::new))).ifPresent(v -> {
					System.out.println(v);
					System.out.println(v.getClass());
				});
	}
	
	public static void main(String[] args) {
		CollectorsAction.testCollectingAndThen();
		CollectorsAction.testGroupingByConcurrent();
		CollectorsAction.testJoining();
		CollectorsAction.testJoining2();
		CollectorsAction.testMapping();
		CollectorsAction.testMapping2();
		CollectorsAction.testMaxBy();
		CollectorsAction.testMinBy();
		CollectorsAction.testReducingBinaryOperator();
		CollectorsAction.testReducingBinaryOperatorAnddentity();
		CollectorsAction.testReducingBinaryOperatorAnddentityAndFunction();
		CollectorsAction.testSummarizingDouble();
		CollectorsAction.testSummarizingInt();
		CollectorsAction.testToCollection();
		CollectorsAction.testToConcurrentMap();
		CollectorsAction.testToConcurrentMapAndBinaryOperator();
		CollectorsAction.testToConcurrentMapAndBinaryOperatorAndSupplier();
	}

}
