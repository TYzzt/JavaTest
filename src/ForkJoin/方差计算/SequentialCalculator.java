package ForkJoin.方差计算;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/13
 * \* Time: 16:03
 * \* Description:
 * \
 */
public interface SequentialCalculator {
    double computeSequentially(double[] numbers, int start, int end);
}
