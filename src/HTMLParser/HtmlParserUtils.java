package HTMLParser;

import java.util.Random;

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

    public static String removeSpaceEnter3(String str){
        return str.replaceAll(" ","").replaceAll("\r","").replaceAll("\n"," ");
    }

    public static String removeHtmlTag(String str){
        return str.replaceAll("&nbsp;","").replaceAll("\t","");
    }

    public static String  getRandomIp(){
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

}
