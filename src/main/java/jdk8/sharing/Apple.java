package jdk8.sharing;

import java.util.ArrayList;
import java.util.List;

public class Apple {

	private String color;

	private long weight;

	public Apple(String color, long weight) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public static void main(String[] args) {

	}

	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> resultList = new ArrayList<Apple>(inventory.size());

		for (Apple apple : inventory) {
			if ("green".equals(apple.getColor())) {
				resultList.add(apple);
			}
		}

		return resultList;
	}
	
	// 需求的变化	根据颜色
	public static List<Apple> findApplesByColor(List<Apple> inventory, String color) {
		List<Apple> resultList = new ArrayList<Apple>(inventory.size());

		for (Apple apple : inventory) {
			if (color.equals(apple.getColor())) {
				resultList.add(apple);
			}
		}

		return resultList;
	}
	
	// 再次变化根据重量。。。。。。TODO （可用策略模式解决，但是代码容易膨胀）

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public long getWeight() {
		return weight;
	}

	public void setWeight(long weight) {
		this.weight = weight;
	}

}
