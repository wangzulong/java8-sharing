package jdk8.sharing.completable;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureInAction2 {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2, r -> {
			Thread thread = new Thread(r);
			thread.setDaemon(false);
			return thread;
		});
		
		CompletableFuture.supplyAsync(CompletableFutureInAction::get, executor)
			.whenComplete((v, t) -> {
				Optional.ofNullable(v).ifPresent(System.out::println);
				Optional.ofNullable(t).ifPresent(x -> x.printStackTrace());
			});
		
		System.out.println("====no=======block========");
	}

}
