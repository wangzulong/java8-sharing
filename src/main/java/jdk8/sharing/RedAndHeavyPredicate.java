package jdk8.sharing;

public class RedAndHeavyPredicate implements ApplePredicate {

	@Override
	public boolean test(Apple apple) {
		return "red".equals(apple.getColor()) && (150 < apple.getWeight());
	}

}
