package HtmlParserTest;

import HTMLParser.happyacc.HappyaccLogin;
import org.htmlparser.util.ParserException;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2016/11/9
 * \* Time: 8:59
 * \* Description:
 * \
 */
public class LeKuaiTest {

    @Test
    public void testTuPian() throws IOException {
        HappyaccLogin.getPic("http://www.happyacc.com/md/vericode/securimage_show.php?sid=0.26672960309127003");
    }

    @Test
    public void testTuPin() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss");
        System.out.println(format.format(new Date()));
    }

    @Test
    public void naioePage() throws IOException, ParserException {
        HappyaccLogin.naioePage("http://www.happyacc.com/ws/exampassport.php?key=happyaccpassport&from=http%3A%2F%2Fexam.happyacc.com%2FexamDesc.do%3FexamId%3D140");
    }

    @Test
    public void testZ() {


        String str = " \uFEFF<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta http-equiv=\"X-UA-Compatible\" content=\"IE=IE8\" /><title>在线考试平台</title>\t<link href=\"css/css.css\" rel=\"stylesheet\" type=\"text/css\" />\t<script src=\"resources/scripts/jquery-1.7.1.min.js\"></script>    <script src=\"resources/scripts/jquery-ui-1.8.10.custom.min.js\"></script>\t<script src=\"js/enterExamination.js\"></script>\t\t<link href=\"css/south.css\" rel=\"stylesheet\" type=\"text/css\" />\t<script type =\"text/javascript\" src=\"artDialog.js?skin=default\"></script><link href=\"hacss/ha_top.css\" rel=\"stylesheet\" type=\"text/css\" /><link rel=\"icon\" href=\"http://www.happyacc.com/index2014/img/logoicon.png\" type=\"image/x-icon\" />\t<style >\t\t.posit{\t\t \t  position:relative;\t\t\t  margin-left:350px;\t\t} \t\t.posit1{ \t\t\t\t \t\t\t\tmargin-top: -310px; \t\t\t\tmargin-left: -75px; \t\t\t\twidth: 320px; \t\t\t} \t\t.posit1 div{ \t\t\t\t \t\t\t\t margin-top:70px; \t\t\t\t color: red; \t\t\t\t font-size: 18px; \t\t \t\t\t\t} </style></head><script type=\"text/javascript\"> javascript:window.history.forward(1); </script><body> <!--头部开始--><div class=\"top_exm\">    <div class=\"logo\"><img src=\"images/logo_exm.jpg\" width=\"483\" height=\"77\"/></div>    </div>  <!--头部结束-->    <!--中间开始-->  <form action=\"./examDesc.do\" method=\"post\"\tid=\"formMTQw\">\t            <input type=\"hidden\" value='MTQw'   name=\"paperId\"  id='paperId'/>\t\t\t\t<input type=\"hidden\" value='2'  name=\"courseId\" id='courseId'/>\t\t\t\t<input type=\"hidden\" value='140'    name=\"examId\"   id='examId'/>\t\t\t\t<input type=\"hidden\" value='1808471'\t name=\"packageBuyId\" id='packageBuyId'/>  </form>  <form method=\"post\" action=\"./enterExamLogin.do\" id=\"form\">       <input type=\"hidden\" name=\"paperId\"      value=\"MTQw\"      \t\tid=\"paperId\">       <input type=\"hidden\" name=\"paperName\"    value=\"《财经法规》免费试卷（一）\"            id=\"paperName\">       <input type=\"hidden\" name=\"examRecordId\" value=\"\" id=\"examRecordId\" >       <input type=\"hidden\" name=\"courseName\"   value=\"财经法规与会计职业道德\"       id=\"courseName\">       <input type=\"hidden\" name=\"user_id\"      value=\"177148\"       \t\tid=\"user_id\">    <div class=\"exm_login\">    <div class=\"exm_login_t\">财经法规与会计职业道德</div>    <div class=\"exm_login_m\">      <div class=\"exm_login_m_left\">        <ul>           <ol><img src=\"http://www.happyacc.com/member/userheader.php?u=TYzzt\"  width=\"60\" height=\"60\"/></ol>           <li>姓名：TYzzt</li>           <li>准考证号：<span  id=\"testCardCode2\">KJKS1478677984166</span></li>           <li>证件号：<span  id=\"papersCode2\">411102197511264620</span></li>        </ul>      </div>      <div class=\"exm_login_m_right\">          <dl>\t        <dt>准考证号:</dt>\t        <dd><input name=\"testCardCode\" id=\"testCardCode\" type=\"text\"  class=\"input1\" value=\"请输入左边的准考证号\" onFocus=\"if(value==defaultValue){value='';this.style.color='#000'}\" onBlur=\"if(!value){value=defaultValue;this.style.color='#999'}\" style=\"color:#999999\"/></dd>\t        <dt>证件号:</dt>\t        <dd><input name=\"papersCode\"   id=\"papersCode\"   type=\"text\"  class=\"input1\" value=\"请输入左边的证件号\"   onFocus=\"if(value==defaultValue){value='';this.style.color='#000'}\" onBlur=\"if(!value){value=defaultValue;this.style.color='#999'}\" style=\"color:#999999\"/></dd>\t        <dt>&nbsp;</dt>\t        <dd><a href=\"#\"><img src=\"images/login_exm_dl.gif\"  id=\"login\" /></a><a href=\"#\" onclick=\"seePaperInfo(MTQw);\" class=\"input2\"><img src=\"images/login_exm_qx.gif\" value=\"sub\"  id='sub'/></a></dd>\t      </dl>      </div>      <div class=\"clear\"></div>    </div>       <div class=\"exm_login_b\"></div>  </div>  </form>  <!--中间结束-->    <!--底部开始-->\uFEFF<div class=\"footer\">    <div class=\"bz\">    \t<!--        <a href=\"http://www.happyacc.com/\">首页</a>        <a href=\"http://www.happyacc.com/help.htm\">帮助中心</a>        <a href=\"http://www.happyacc.com/news/list_all_63/\">网站公告</a>        <a href=\"./naioePage.do\">会计在线模考</a>        <a href=\"http://www.happyacc.com/news/detail_389/\">招聘信息</a>        <br>        -->        <!--京ICP备13028093号 -->\t\t京ICP备15037166号-1<script>var _hmt = _hmt || [];(function() {  var hm = document.createElement(\"script\");  hm.src = \"//hm.baidu.com/hm.js?805cda4978dd0b1c029372727343e7ef\";  var s = document.getElementsByTagName(\"script\")[0];   s.parentNode.insertBefore(hm, s);})();</script>    </div>    <div class=\"copy\">©happyacc.com Inc. All Rights Reserved</div></div>   <!--底部结束-->  </body></html>";


        String str2 = "\n" +
                "       <input type=\"hidden\"  name=\"paperName\"    value='《财经法规》免费试卷（一）'   id='paperName'>\n" +
                "       <input type=\"hidden\"  name=\"paperId\"      value='140'     id='paperId'>\n" +
                "       <input type=\"hidden\"  name=\"courseId\"     value='2'    id='courseId'>\n" +
                "        <input type=\"hidden\" value=\"2016\"     id=\"paperYear\"    name=\"paperYear\">\n" +
                "       <input type=\"hidden\"  name=\"courseName\"   value='财经法规与会计职业道德'  id='courseName'>\n" +
                "       <input type=\"hidden\"  name=\"examId\"       value='140'      id='examId'>\n" +
                "       <input type=\"hidden\"  name=\"packageBuyId\" value='1808471'\t   \t\t   id='packageBuyId'>\n" +
                "  ";

        Pattern p = Pattern.compile("(<form method=\"post\" action=\"./enterExamLogin.do\" id=\"form\">)([\\s\\S]*?)(</form>)");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group(2);
            System.out.println("Found value: " + str);
        }
        Pattern p2 = Pattern.compile("(name=\")([\\w]*)(\" *)(value=['\"])([\\w\\W]*?)(['\"])");
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            System.out.println("Found value: " + m2.group(2) + m2.group(5));
        }

        Pattern p01 = Pattern.compile("(<span  id=\"testCardCode2\">)([\\w\\W]*?)(</span>)");
        Matcher m0 = p01.matcher(str);
        if (m0.find()) {
            System.out.println("testCardCode=" + m0.group(2));
        }
        Pattern p02 = Pattern.compile("(<span  id=\"papersCode2\">)([\\w\\W]*?)(</span>)");
        Matcher m00 = p02.matcher(str);
        if (m00.find()) {
            System.out.println("papersCode=" + m00.group(2));
        }


    }

}
