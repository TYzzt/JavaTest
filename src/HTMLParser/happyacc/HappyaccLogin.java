package HTMLParser.happyacc;

import HTMLParser.HtmlParserUtils;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/11/8
 * \* Time: 17:30
 * \* Description: 模拟登录+爬虫
 * \
 */
public class HappyaccLogin {
    static String urlMain = "http://exam.happyacc.com/enterExam.do";
    static String vericodeUrl = "http://www.happyacc.com/md/vericode/securimage_show.php?sid=0.26672960309127003";
    static String loginUrl = "http://www.happyacc.com/member/userlogin.php?t=3";
    static String responseCookie;//标示Session必须

    static String cjfkmfUrl = "http://www.happyacc.com/ws/exampassport.php?key=happyaccpassport&from=http%3A%2F%2Fexam.happyacc.com%2FexamDesc.do%3FexamId%3D140";//《财经法规》免费试卷（一）

    static String enterExamUrl = "http://exam.happyacc.com/enterExam.do"; //登陆页
    static String enterExamLoginUrl = "http://exam.happyacc.com/enterExamLogin.do"; //登陆


    public static void main(String[] args) throws IOException, ParserException {


        /*获取验证码*/
        getPic(vericodeUrl);
        message("----------------\n获取验证码成功！");
        File file = new File("D:/verCode.txt");
        String ver = "";
        try (FileInputStream f = new FileInputStream(file)) {
            for (int i = 0; i < 4; i++) {
                ver += (char) f.read();
            }
        }
        message("----------------\n验证码：" + ver);
         /*登录*/
        String afterLogin;
        StringBuffer sb = new StringBuffer(); //POST参数
        sb.append("user_name=" + "TYzzt");
        sb.append("&user_pwd=" + "lk78231960");
        sb.append("&user_validatecode=" + ver);

        afterLogin = openPostUrl(loginUrl, sb.toString());
        message("-----------------\n登录后：" + afterLogin);

        if (!afterLogin.equals("1")) { //登录失败
            message("失败");
            return;
        }

        /*获取试卷信息url*/
        String examInfoUrl = null; //试卷信息url
        String exaemDesc = naioePage(cjfkmfUrl);
        Pattern p = Pattern.compile("(szUrl=')(.*)(')");
        Matcher m = p.matcher(exaemDesc);
        if (m.find()) {
            examInfoUrl = m.group(2);
            System.out.println("Found value: " + examInfoUrl);
        }
        /*解析试卷信息页*/
        String exameDescPage = naioePage(examInfoUrl);

        /*打开登陆页*/
        String parttern1 = "(<form action=\"./enterExam.do \" method=\"post\" id=\"form\">)([\\s\\S]*?)(</form>)";
        String parm = getExamInfoForm(exameDescPage, parttern1);
        String exameLoginPage = openPostUrl(enterExamUrl, parm);

        /*登陆*/
        String parttern2 = "(<form method=\"post\" action=\"./enterExamLogin.do\" id=\"form\">)([\\s\\S]*?)(</form>)";
        String loginParm = getExamInfoForm(parttern2, parttern2);
        String loginPageOne = openPostUrl(enterExamLoginUrl, loginParm);

        message(loginPageOne);

    }

    public static void message(String str) {
        System.out.println(str);
    }

    /**
     * 获取图片
     */
    public static void getPic(String url) throws IOException {
        URL url2 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url2.openConnection();

        responseCookie = connection.getHeaderField("Set-Cookie");//取到所用的Cookie
        InputStream dataInputStream = connection.getInputStream();
        String imageName = "D:/" + Math.random() + ".jpg";
        FileOutputStream fileOutputStream = new FileOutputStream(new File(imageName));
        byte[] buffer = new byte[1024];
        int length;

        while ((length = dataInputStream.read(buffer)) > 0) {
            fileOutputStream.write(buffer, 0, length);
        }

        dataInputStream.close();
        fileOutputStream.close();
    }

    /**
     * post
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String openPostUrl(String url, String parm) throws IOException {

        StringBuilder sbR = new StringBuilder();

        //访问URL，并把信息存入sb中

        URL url3 = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) url3.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);//允许连接提交信息
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Cookie", responseCookie); //设置Cookie
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.71 Safari/537.36");

        connection.setRequestProperty("Content-Length",
                String.valueOf(parm.length()));

        OutputStream os = connection.getOutputStream();
        os.write(parm.getBytes());
        os.close();

        //取Cookie
        BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        responseCookie = connection.getHeaderField("Set-Cookie");//取到所用的Cookie
        message("cookie:" + responseCookie);

        //取返回的页面
        String line = br.readLine();
        while (line != null) {
            sbR.append(line);
            line = br.readLine();
        }

        return sbR.toString();
    }

    //返回页面
    public static String viewPage(String sURL) throws IOException {
        StringBuilder sbR = new StringBuilder();

        //打开URL连接
        URL url1 = new URL(sURL);
        HttpURLConnection connection1 = (HttpURLConnection) url1.openConnection();

        //给服务器送登录后的cookie
        connection1.setRequestProperty("Cookie", responseCookie);

        //读取返回的页面信息到br1
        BufferedReader br1 = new BufferedReader(new InputStreamReader(connection1.getInputStream()));

        //取返回的页面,br1转sbR
        String line1 = br1.readLine();
        while (line1 != null) {
            sbR.append(line1);
            line1 = br1.readLine();
        }

        return sbR.toString();
    }

    /**
     * 获取
     *
     * @throws IOException
     * @throws ParserException
     */
    public static String naioePage(String url) throws IOException, ParserException {
        URL url1 = new URL(url);
        URLConnection connection = url1.openConnection();
        connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
        connection.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
        if (null != responseCookie) {
            connection.setRequestProperty("Cookie", responseCookie);
        }
        Parser parser = new Parser(connection);
        parser.setEncoding("utf-8");
        StringBuffer sb = new StringBuffer();

        message("=================================================");
        for (NodeIterator i = parser.elements(); i.hasMoreNodes(); ) {
            Node node = i.nextNode();
            sb.append(node.toHtml());
        }
        message("=================================================");
        responseCookie = connection.getHeaderField("Set-Cookie");//取到所用的Cookie
        message("cookie:" + responseCookie);
        return sb.toString();
    }

    /**
     * 获取form中的key value
     *
     * @param pageStr
     * @return
     */
    public static String getExamInfoForm(String pageStr, String pattern) {
        StringBuffer sb = new StringBuffer();
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(pageStr); //取出form
        if (m.find()) {
            pageStr = m.group(2);
            System.out.println("Found value: " + pageStr);
        }

        Pattern p2 = Pattern.compile("(name=\")([\\w]*)(\" *)(value=['\"])([\\w\\W]*?)(['\"])");
        Matcher m2 = p2.matcher(pageStr);
        while (m2.find()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(m2.group(2) + "=" + m2.group(5));
            System.out.println("Found value: " + m2.group(2) + m2.group(5));
        }
        return sb.toString();

    }

}
