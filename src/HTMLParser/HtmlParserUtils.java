package HTMLParser;

/**
 * Created by ZhaoTao on 2016/6/20.
 */
public class HtmlParserUtils {
    public static String removeSpaceEnter(String str){
        return str.replaceAll(" ","").replaceAll("\r\n","");
    }

    public static String removeSpaceEnter2(String str){
        return str.replaceAll(" ","").replaceAll("\r\n","|");
    }

    public static String removeHtmlTag(String str){
        return str.replaceAll("&nbsp;","");
    }

}
