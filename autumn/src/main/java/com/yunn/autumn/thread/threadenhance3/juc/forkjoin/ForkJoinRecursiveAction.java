package com.yunn.autumn.thread.threadenhance3.juc.forkjoin;

import java.util.Optional;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * ForkJoinRecursiveAction
 *
 * @author yunN
 * @createTime 2021年02月03日 14:19
 * @description 无返回值
 */
public class ForkJoinRecursiveAction {

    private final static int MAX_THRESHOLD = 3;

    private static final AtomicInteger sum = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.submit(new CalculateRecursiveAction(0, 10));
        boolean res = forkJoinPool.awaitTermination(1, TimeUnit.SECONDS);
        Optional.of(sum).ifPresent(System.out::println);

    }

    /**
     * 无结果、异步执行
     */
    private static class CalculateRecursiveAction extends RecursiveAction {

        private static final long serialVersionUID = -785875781476654554L;

        private final int start;

        private final int end;

        public CalculateRecursiveAction(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (start - end <= MAX_THRESHOLD) {
                sum.addAndGet(IntStream.rangeClosed(start, end).sum());
            } else {
                int middle = (start + end) / 2;
                CalculateRecursiveAction leftAction = new CalculateRecursiveAction(start, middle);
                CalculateRecursiveAction rightAction = new CalculateRecursiveAction(middle + 1, end);
                leftAction.fork();
                rightAction.fork();
            }
        }
    }

}
