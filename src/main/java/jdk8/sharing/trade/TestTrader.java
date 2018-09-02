package jdk8.sharing.trade;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
	
	public List<String> findTraderNames() {
		List<String> result = transactions.stream().map(d -> d.getTrader().getName())
				.distinct().sorted().collect(toList());
		
		System.out.println(result);
		return result;
	}
	
	public boolean findTraderFromMilan() {
		Optional<Trader> result = transactions.stream().map(f -> f.getTrader()).filter(f -> "Milan".equals(f.getCity())).findAny();
		System.out.println(result.get());
		return result.isPresent();
	}
	
	public Integer getSumFromCambridge() {
		Optional<Integer> result = transactions.stream().filter(f -> "Cambridge".equals(f.getTrader().getCity())).map(f -> f.getValue()).reduce(Integer::sum);
		System.out.println(result.get());
		return result.get();
	}
	
	public Integer getMaxTransaction() {
		Optional<Integer> result = transactions.stream().map(f -> f.getValue()).reduce(Integer::max);
		System.out.println(result.get());
		return result.get();
	}
	
	public Transaction getMinTransaction() {
		Optional<Transaction> result = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		System.out.println(result.get());
		return result.get();
	}
	
	public static void main(String[] args) {
		TestTrader testTrader = new TestTrader();
//		testTrader.findTransactionBy2011();
//		testTrader.findListTraders();
//		testTrader.findTraders();
//		testTrader.findTraderNames();
//		System.out.println(testTrader.findTraderFromMilan());
//		testTrader.getSumFromCambridge();
//		testTrader.getMaxTransaction();
		testTrader.getMinTransaction();
	}

}
