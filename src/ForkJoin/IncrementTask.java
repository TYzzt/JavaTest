package ForkJoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

import static ForkJoin.方差计算.ForkJoinCalculator.THRESHOLD;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/6/13
 * \* Time: 16:45
 * \* Description:
 * \
 */
class IncrementTask extends RecursiveAction {
    final long[] array;
    final int lo;
    final int hi;

    IncrementTask(long[] array, int lo, int hi) {
        this.array = array;
        this.lo = lo;
        this.hi = hi;
    }

    public static void main(String[] args) {
        long[] arrays = {0, 1, 23, 444};
        IncrementTask task = new IncrementTask(arrays, 0, arrays.length);
        System.out.println(Arrays.toString(arrays));
        final ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(task);
        System.out.println(Arrays.toString(arrays));
    }

    protected void compute() {
        if (hi - lo < THRESHOLD) {
            for (int i = lo; i < hi; ++i)
                array[i]++;
        } else {
            int mid = (lo + hi) >>> 1;
            invokeAll(new IncrementTask(array, lo, mid),
                    new IncrementTask(array, mid, hi));
        }
    }
}
