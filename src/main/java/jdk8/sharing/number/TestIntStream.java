package jdk8.sharing.number;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import jdk8.sharing.stream.Dish;

public class TestIntStream {

	List<Dish> menu = Arrays.asList(new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH), new Dish("salmon", false, 450, Dish.Type.FISH));

	public int getSumCalories() {
		int result = menu.stream().mapToInt(Dish::getCalories).sum();
		System.out.println(result);
		return result;
	}

	public void printSqrt() {
		Stream<int[]> result = IntStream.rangeClosed(1, 100).boxed()
				.flatMap(a -> IntStream.rangeClosed(a, 100).filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
						.mapToObj(b -> new int[] { a, b, (int) Math.sqrt(a * a + b * b) }));

		result.limit(5).forEach(t -> System.out.print(t[0] + ", " + t[1] + ", " + t[2]));
	}

	public void printn() {
		Stream.iterate(0, n -> n + 2).limit(10).forEach(System.out::println);
	}

	public void printFibonacci() {
		Stream.iterate(new int[]{0, 1},  t -> new int[]{t[1], t[0]+t[1]})
        .limit(20)
        .forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
	}

	public static void main(String[] args) {
		TestIntStream testIntStream = new TestIntStream();
		// testIntStream.getSumCalories();
		// testIntStream.printSqrt();
//		testIntStream.printn();
		testIntStream.printFibonacci();
	}

}
