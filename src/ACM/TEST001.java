package ACM;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/2/1
 * \* Time: 10:32
 * \* Description:
 * \
 */
public class TEST001 {


    public static void main(String[] args) {
        int[] nums = {2, 3, 2, 1, 3};
        System.out.println(new TEST001().singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; ++i) {
            result ^= nums[i];
            System.out.println(result);
        }
        return result;
    }

    public int[] a() {
        return new int[]{1, 3};
    }

}
