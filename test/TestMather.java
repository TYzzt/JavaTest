import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2018/11/6
 * \* Time: 9:25
 * \* Description:
 * \
 */
public class TestMather {


    public static void main(String[] args) {
        System.out.println(Pattern.matches("^d", "ddd啊...d啊"));
        Pattern p = Pattern.compile("^d");
        Matcher m = p.matcher("addd啊...d啊");
        System.out.println(m.matches());
        System.out.println(m.find());

    }

}
