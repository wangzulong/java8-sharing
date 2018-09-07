package jdk8.sharing.completable;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureInAction {

	private static final Random RANDOM = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Double> completableFuture = new CompletableFuture<>();
		
		new Thread(() -> {
			double value = get();
			completableFuture.complete(value);
		}).start();
		
		System.out.println("====no=======block========");
		
//		Optional.ofNullable(completableFuture.get()).ifPresent(System.out::println);
		
		//Java 8 API
		completableFuture.whenComplete((v, t) -> {
			Optional.ofNullable(v).ifPresent(System.out::println);
			Optional.ofNullable(t).ifPresent(x -> x.printStackTrace());
		});
	}
	
	static double get() {
		try{
			Thread.sleep(RANDOM.nextInt(10000));
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return RANDOM.nextDouble();
	}

}
