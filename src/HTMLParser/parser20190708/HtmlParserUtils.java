package HTMLParser.parser20190708;


import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ZhaoTao on 2016/6/20.
 */
public class HtmlParserUtils {
    public static String removeSpaceEnter(String str) {
        return str.replaceAll(" ", "").replaceAll("\r\n", "");
    }

    public static String removeSpaceEnter2(String str) {
        return str.replaceAll(" ", "").replaceAll("\r\n", "|");
    }

    public static String removeSpaceEnter4(String str) {
        return str.replaceAll(" ", "").replaceAll("\r\n", "\r\n|");
    }

    public static String removeSpaceEnter3(String str) {
        return str.replaceAll(" ", "").replaceAll("\r", "").replaceAll("\n", " ");
    }

    public static String removeHtmlTag(String str) {
        return str.replaceAll("&nbsp;", "").replaceAll("\t", "");
    }

    public static String getRandomIp() {
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        sb.append(random.nextInt(255));
        sb.append(".");
        sb.append(random.nextInt(255));
        sb.append(".");
        sb.append(random.nextInt(255));
        sb.append(".");
        sb.append(random.nextInt(255));
        return sb.toString();
    }

    public static String punctuationForm(String str) {
        return str.replaceAll("：", ":").replaceAll("；", ";").replaceAll("。", ".").replaceAll("，", ",");
    }

    public static String flagForm(String str) {
        str = str.replaceAll("[\\d一二三四五六七八九][、.]", "|");
        return str;
    }

    public static String operateForm(String str) {
        String temp = removeSpaceEnter(str);
        temp = removeHtmlTag(temp);  //去除空格和回车
        temp = punctuationForm(temp);//标点符号
        temp = flagForm(temp);//格式化
        return temp;
    }

    /**
     * 用于判断标题是否含有这些关键字
     *
     * @param str
     * @return
     */
    public static boolean titleFilter(String str) {
        //关键字：财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来
        String filter[] = {
                "财务", "会计", "会计", "出纳", "核算", "成本", "税务", "内控", "预算", "总账", "往来"
        };
        for (int i = 0; i < filter.length; i++) {
            return str.contains(filter[i]);
        }
        return false;
    }

    /**
     * 返回begin后的字符串，以空格截至
     *
     * @param org   原始字符串
     * @param begin 开头字符串
     * @return
     */
    public static String jiansuo(String org, String begin) {
        String regEx = begin + "\\s*(\\S*)\\s";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(org);
        if (matcher.find()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            return matcher.group(1);

        } else return "";
    }

}
