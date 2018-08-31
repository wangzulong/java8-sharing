package jdk8.sharing;

import java.util.Comparator;

public class LamdaExpression {
	
	public static void main(String[] args) {
		Comparator<Apple> appleCompator = (o1, o2) ->o1.getColor().compareTo(o2.getColor());
		
		
	}

}
