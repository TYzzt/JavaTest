package ForkJoin.方差计算;

import java.util.concurrent.ForkJoinPool;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/13
 * \* Time: 16:00
 * \* Description:
 * \
 */
public class VarianceImperative {

    public static double getVarianceImperative(double[] population) {
        double average = 0.0; //平均值
        for (double p : population) {
            average += p;
        }
        average /= population.length;

        double variance = 0.0; //每个数据与平均值之差的平方和
        for (double p : population) {
            variance += (p - average) * (p - average);
        }
        return variance / population.length;
    }

    public static double getvarianceForkJoin(double[] population) {
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        double total = forkJoinPool.invoke(new ForkJoinCalculator
                (population, new SequentialCalculator() {
                    @Override
                    public double computeSequentially(double[] numbers, int start, int end) {
                        double total = 0;
                        for (int i = start; i < end; i++) {
                            total += numbers[i];
                        }
                        return total;
                    }
                }));
        final double average = total / population.length;
        double variance = forkJoinPool.invoke(new ForkJoinCalculator
                (population, new SequentialCalculator() {
                    @Override
                    public double computeSequentially(double[] numbers, int start, int end) {
                        double variance = 0;
                        for (int i = start; i < end; i++) {
                            variance += (numbers[i] - average) * (numbers[i] - average);
                        }
                        return variance;
                    }
                }));
        return variance / population.length;
    }

    public static void main(String[] args) {
        double number[] = {40, 30, 50, 80};
        System.out.println(getVarianceImperative(number));
        System.out.println(getvarianceForkJoin(number));
    }

}
