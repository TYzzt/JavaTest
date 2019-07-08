/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/10/19
 * \* Time: 14:26
 * \* Description:
 * \
 */
public class StaticTest {
    static int x;
    int y;

    StaticTest() {
        x++;
        y++;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println((Integer) i);
        }

    }
}
