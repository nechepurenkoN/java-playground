package io.github.nechepurenkon.javaplayground.parallel;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Factorial {

    private final long n;
    private final int threadCount;

    public Factorial(long n) {
        this.n = n;
        threadCount = Runtime.getRuntime().availableProcessors();
    }

    public long getArgument() {
        return n;
    }

    public BigInteger count() {
        final long chunkSize = n / threadCount;
        IntStream.range(0, threadCount)
                 .mapToObj(i -> new FactorialIntervalTask(BigInteger.valueOf(i * chunkSize), BigInteger.valueOf((i + 1) * chunkSize - 1)))
                 .forEach(fit -> {
                     System.out.println(fit.left() + " " + fit.right());
                 });

        return null;
    }
}

class FactorialIntervalTask implements Supplier<BigInteger> {
    private BigInteger left;
    private final BigInteger right;

    FactorialIntervalTask(BigInteger left, BigInteger right) {
        this.left = left;
        this.right = right;
    }

    public BigInteger left() {
        return left;
    }

    public BigInteger right() {
        return right;
    }

    @Override
    public BigInteger get() {

        if (left.equals(right)) {
            return left.multiply(BigInteger.ONE);
        }

        BigInteger accumulator = BigInteger.ONE;
        while (!left.equals(right)) {
            accumulator = accumulator.multiply(left);
            left = left.add(BigInteger.ONE);
        }

        return accumulator.multiply(right);
    }

}
