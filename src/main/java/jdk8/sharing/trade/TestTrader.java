package jdk8.sharing.trade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import static java.util.stream.Collectors.toList;

public class TestTrader {

	Trader raoul = new Trader("Raoul", "Cambridge");
	Trader mario = new Trader("Mario", "Milan");
	Trader alan = new Trader("Alan", "Cambridge");
	Trader brian = new Trader("Brian", "Cambridge");
	List<Transaction> transactions = Arrays.asList(new Transaction(brian, 2011, 300),
			new Transaction(raoul, 2012, 1000), new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710),
			new Transaction(mario, 2012, 700), new Transaction(alan, 2012, 950));

	
	public List<Transaction> findTransactionBy2011() {
		List<Transaction> result = transactions.stream().filter(d -> d.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).collect(toList());
		System.out.println(result);
		return result;
	}
	
	public List<String> findListTraders() {
		List<String> result = transactions.stream().map(d -> d.getTrader().getCity()).distinct().collect(toList());
		System.out.println(result);
		return result;
	}
	
	public List<Trader> findTraders() {
		List<Trader> result = transactions.stream().map(d -> d.getTrader()).filter(f -> "Cambridge".equals(f.getCity()))
				.distinct().sorted(Comparator.comparing(Trader::getName)).collect(toList());
		
		System.out.println(result);
		return result;
	}
	
	public static void main(String[] args) {
		TestTrader testTrader = new TestTrader();
//		testTrader.findTransactionBy2011();
//		testTrader.findListTraders();
		testTrader.findTraders();
	}

}
