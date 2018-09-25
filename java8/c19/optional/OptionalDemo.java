package c19.optional;

import java.util.Optional;

/**
 * Created by ZhaoTao on 2016/7/15.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Optional<String> noVal = Optional.empty();  //不包含值的Optional实例

        Optional<String> hasVal = Optional.of("ABCDaaaF");

        if (noVal.isPresent()) {
            System.out.println("This won't be displayed");
        } else {
            System.out.println("noVal has no value");
        }

        if (hasVal.isPresent()) {
            System.out.println("The String in hasValue is:" + hasVal.get());
        }

        String defStr = noVal.orElse("Default String");

        System.out.println(defStr);
        System.out.println(hasVal.orElse("Default String"));

        Optional<String> hasVal2 = Optional.ofNullable(null);
        System.out.println(hasVal2.orElse("Null Test"));

        Optional<String> hasVal2_change = hasVal.map(String::toUpperCase);
        System.out.println(hasVal2_change.orElse("Null Test"));

    }
}
