package ForkJoin.方差计算;

import java.util.concurrent.RecursiveTask;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/13
 * \* Time: 16:02
 * \* Description: Fork/Join框架
 * 对一个double数组进行切分，当子数组的长度小于等于给定阈值（THRESHOLD）时停止切分。切分完成后，对子数组进行顺序处理，并将下列接口定义的操作应用于子数组。
 * \
 */
public class ForkJoinCalculator extends RecursiveTask<Double> {
    public static final long THRESHOLD = 1_000_000;
    static int i = 0;

    private final SequentialCalculator sequentialCalculator;
    private final double[] numbers;
    private final int start;
    private final int end;

    public ForkJoinCalculator(double[] numbers, SequentialCalculator sequentialCalculator) {
        this(numbers, 0, numbers.length, sequentialCalculator);
    }

    private ForkJoinCalculator(double[] numbers, int start, int end, SequentialCalculator
            sequentialCalculator) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
        this.sequentialCalculator = sequentialCalculator;
    }

    @Override
    protected Double compute() {
        int length = end - start;
        if (length <= THRESHOLD) {
            return sequentialCalculator.computeSequentially(numbers, start, end);
        }
        ForkJoinCalculator leftTask = new ForkJoinCalculator(numbers, start, start + length / 2,
                sequentialCalculator);
        leftTask.fork();
        ForkJoinCalculator rightTask = new ForkJoinCalculator(numbers, start + length / 2, end,
                sequentialCalculator);
        System.out.println(++i);
        Double rightResult = rightTask.compute();
        Double leftResult = leftTask.join();
        return leftResult + rightResult;
    }
}
