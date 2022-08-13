package io.github.nechepurenkon.javaplayground.parallel;

import java.math.BigInteger;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Factorial {

    private final long n;
    private final long chunkSize;

    public Factorial(long n) {
        this.n = n;
        chunkSize = n / Runtime.getRuntime().availableProcessors() + 1;
    }

    public long getArgument() {
        return n;
    }

    public BigInteger count() {
        return Stream.iterate(1L, i -> i < n, i -> i + chunkSize)
              .map(this::createTask)
              .parallel()
              .map(FactorialIntervalTask::get)
              .reduce(BigInteger.ONE, BigInteger::multiply);
    }

    protected FactorialIntervalTask createTask(long index) {
        return new FactorialIntervalTask(
            BigInteger.valueOf(index),
            BigInteger.valueOf(Math.min(index + chunkSize - 1, n))
        );
    }

    protected static class FactorialIntervalTask implements Supplier<BigInteger> {
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
}

