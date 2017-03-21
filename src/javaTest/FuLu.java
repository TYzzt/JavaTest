package javaTest;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2017/2/28
 * \* Time: 10:14
 * \* Description:
 * \
 */
public class FuLu {
    public static void main(String[] args) {
/**
 * 位运算
 */

        int x = 10; //00001010
        int y = 6;  //00000110
        /**   按位非 ~   **/
        int a = ~x; //11110101

        /**   按位与 & 两个位都是1才会返回1，否则返回0   **/
        a = x & y; //00000010

        /**   按位或 | 其中有一个1就会返回1   **/
        a = x | y; //00001110

        /**   按位异或 ^ 位相同时返回0   **/
        a = x ^ y; //00001110

        /**   按位异或 ^ 位相同时返回0   **/
        a = x ^ y; //00001110

        //11-> 00001011
        x = -11; //11110101     java用补码存储值，改变正负号时把位取反后加1

        /**   右移 >> 右移后左方补0，正负号不变 **/
        a = x >> 2; // 11111101
        System.out.println(Integer.toBinaryString(a));
        /**   无符号右移 >> 右移后左方补0，正负号可能会变化 **/
        a = x >>> 2; // 00111101
        System.out.println(Integer.toBinaryString(a));
        /**   左移 >> 和>>>一样，方向相反，右方补0，正负号可能会变化**/
        a = x << 2; // 11010100
        System.out.println(Integer.toBinaryString(a));

    }
}
