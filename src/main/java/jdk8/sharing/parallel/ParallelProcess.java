package jdk8.sharing.parallel;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelProcess {

	public static long sequentialSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).reduce(0L, Long::sum);
	}

	public static long iterativeSum(long n) {
		long result = 0;
		for (long i = 1L; i <= n; i++) {
			result += i;
		}
		return result;
	}

	public static long parallelSum(long n) {
		return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}

	public static long parallelSum2(long n) {
		return LongStream.rangeClosed(1, n).parallel().reduce(0L, Long::sum);
	}

	public static long measureSumPerf(Function<Long, Long> adder, long n) {
		long fastest = Long.MAX_VALUE;
		for (int i = 0; i < 10; i++) {
			long start = System.nanoTime();
			adder.apply(n);
			long duration = (System.nanoTime() - start) / 1_000_000;
			if (duration < fastest)
				fastest = duration;
		}
		return fastest;
	}

	public static void main(String[] args) {
		System.out.println("sequentialSum done in: " + measureSumPerf(ParallelProcess::sequentialSum, 100_000_000));
		System.out.println("iterativeSum done in: " + measureSumPerf(ParallelProcess::iterativeSum, 100_000_000));
//		System.out.println("parallelSum done in: " + measureSumPerf(ParallelProcess::parallelSum, 100_000_000));
		System.out.println("Parallel range sum done in:" + measureSumPerf(ParallelProcess::parallelSum2, 100_000_000));
	}

}
