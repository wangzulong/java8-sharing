package jdk8.sharing.stream;

import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;

public class TestString {

	private String[] words = {"Hello","World"};
	
	public static void main(String[] args) {
		TestString testStr = new TestString();
//		testStr.getArrayStr();
//		testStr.getListInteger();
		testStr.getListInteger2();
	}

	public List<String> getListStr() {
		List<String> strs = new ArrayList<String>();
		strs.add("Hello");
		strs.add("world");
		
//		List<String> result = strs.stream().map(d -> d.split("")).collect(toList());
		
		return null;
	}
	
	public List<String> getArrayStr() {
		List<String> strs = new ArrayList<String>();
		strs.add("2389");
		strs.add("751");
		
		List<String> result = strs.stream().map(d -> d.split("")).flatMap(Arrays::stream).sorted().collect(toList());
		System.out.println(result);
		return result;
	}
	
	public List<Integer> getListInteger() {
		List<Integer> intList = new ArrayList<Integer>();
		
		intList.addAll(Arrays.asList(1,2,3,4,5));
		
		List<Integer> result = intList.stream().map(d -> d*d).collect(toList());
		System.out.println(result);
		return result;
	}
	
	/**
	 * (2) 给定两个数字列表，如何返回所有的数对呢?例如，给定列表[1, 2, 3]和列表[3, 4]，应 该返回[(1, 3), (1, 4), (2, 3), (2, 4), (3, 3), (3, 4)]。
	 * 为简单起见，你可以用有两个元素的数组来代 表数对。
	 * @return
	 */
	public List<int[]> getListInteger2() {
		List<Integer> numbers1 = Arrays.asList(1, 2, 3); 
		List<Integer> numbers2 = Arrays.asList(3, 4); 
		List<int[]> pairs = numbers1.stream().flatMap(i -> numbers2.stream().map(j -> new int[]{i,j})).collect(toList());
//		pairs.stream().map(Arrays::asList).flatMap(Arrays::stream).forEach(System.out::println);
		return pairs;
	}
}
