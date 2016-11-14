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
        for (int i = 0; i < 10; i++) {
            HappyaccLogin.getPic("http://www.happyacc.com/md/vericode/securimage_show.php?sid=0.26672960309127003");
        }
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
        Pattern p2 = Pattern.compile("(name=\")([\\w]*)(\"\\s*)(value=['\"])([\\w\\W]*?)(['\"])");
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

    @Test
    public void testZ2() {
        String str = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" /><meta http-equiv=\"X-UA-Compatible\" content=\"IE=EmulateIE8\" /><title>在线考试平台</title>\t<link href=\"css/css.css\" rel=\"stylesheet\" type=\"text/css\" />    <script src=\"resources/scripts/jquery-1.7.1.min.js\"></script>    <script src=\"js/countdown2.js\"></script> <link href=\"hacss/ha_top.css\" rel=\"stylesheet\" type=\"text/css\" /><script src=\"js/goods/base64.js\" type=\"text/javascript\"></script><link rel=\"icon\" href=\"http://www.happyacc.com/index2014/img/logoicon.png\" type=\"image/x-icon\" /></head><script type=\"text/javascript\"> javascript:window.history.forward(1);</script><body><form action=\"./goexam.do?examstyle=1\" id=\"form\" method=\"post\">\t<input type=\"hidden\" name=\"paperId\"\t\tid=\"paperId\" \tvalue=\"MTQw\" />\t<input type=\"hidden\" name=\"examRecordId\"    value=\"1359821\" />\t<input type=\"hidden\" name=\"courseName\"\t \tvalue=\"财经法规与会计职业道德\" />\t<input type=\"hidden\" name=\"testCardCode\"    value=\"KJKS1478683399841\" />\t<input type=\"hidden\" name=\"papersCode\"\t \tvalue=\"632724200809036732\" /></form> <!--头部开始--><div class=\"top_time\">    <div class=\"ks_info\">       <div class=\"ks_photo\"><img src=\"http://www.happyacc.com/member/userheader.php?u=TYzzt\"  width=\"93\" height=\"93\"/></div>       <div class=\"ks_xx\">          <ul>             <li>姓名：TYzzt</li>             <li>准考证号：KJKS1478683399841</li>             <li>证件号:632724200809036732</li>          </ul>       </div>    </div>    <div class=\"ks_item\">       财经法规与会计职业道德    </div></div><!--头部结束--><div class=\"contain\">  <!--中间开始-->    <div class=\"ks_note\">      <div class=\"ks_tx\">      距离考试开始还有      <span id=\"countDown\">00:00:120</span>    </div>    <div class=\"ks_tx\" id=\"ks_tx\">\t\t\t\t\t  <center>\t\t                  <div style=\"width:300px;float:left;\">\t\t\t\t\t        <script type=\"text/javascript\">\t\t\t\t\t\t\t    /*考试系统进入考试页面1*/\t\t\t\t\t\t\t    var cpro_id = \"u2334321\";\t\t\t\t\t\t\t</script>\t\t\t\t\t\t\t<script src=\"http://cpro.baidustatic.com/cpro/ui/c.js\" type=\"text/javascript\"></script>\t\t                  </div>\t\t                  <div style=\"width:300px;float:right;\">\t\t                  \t<a href=\"#?examstyle=1\"><span id=\"quickEnter\">快&nbsp;速&nbsp;进&nbsp;入</span></a>\t\t                  </div>\t\t              </center>    </div>    <div class=\"ks_tx_2\"></div>  </div>    <div class=\"ks_note_c\">     <h1>考试须知：</h1>     <div class=\"ks_note_c2\"><font size=+1>全国会计专业技术资格无纸化考试试点有关考务要求</font><br/>一、开考前40分钟，考生本人凭本人准考证进入考场，经监考人员核对准考证和身份证后，在考生签到表上签名，对号入座，将准考证和身份证放置在桌面上，以备检查。<br/>二、考生在登录界面输入准考证号和证件号进行登录，核对计算机屏幕显示的姓名、性别、准考证号和证件号是否正确，等待考试开始。<br/>三、如出现无法登录考试服务器、信息有误、运行故障等异常情况，考生应举手示意，请监考人员帮助解决，不得自行取置。<br/>四、考试开始后，计算机自动进入答题界面。<br/>五、考试开始30分钟后，考生不得进入考场参加考试。开考试30分钟内未在考试机上登录的考生，视为行缺考，考试系统将不再接受该准考证号登录。<br/>六、考场为考生统一提供演算草稿纸和演算用笔，考试结束后由监考人员统一收回，考生不得带出考场，违者按作弊取理。<br/>七、考生自觉遵守考场秩序，保持考场安静，遇到问题可举手向监考人员示意。<br/>.八、开考60分钟后，考生方可交卷，考生交卷后应立即离开考场，不得在考场附近逗留、谈论或喧哗。<br/>九、考试结束后，系统自动为所有未交卷考生统一交卷。<br/>十、会计资格无纸化考试试点有关考务的其它要求，按照《全国会计专业技术资格考试考务规则》（财会考办字[1999]16号）、《全国会计专业技术资格考试考场规则》（财会考办字[2002]4号）的相关规定执行。<br/>十一、进入模考答题页面后，5分钟内不允许交卷。</div>  </div>  <!--中间结束-->    <!--底部开始-->  <!--底部结束--></div>\uFEFF<div class=\"footer\">    <div class=\"bz\">    \t<!--        <a href=\"http://www.happyacc.com/\">首页</a>        <a href=\"http://www.happyacc.com/help.htm\">帮助中心</a>        <a href=\"http://www.happyacc.com/news/list_all_63/\">网站公告</a>        <a href=\"./naioePage.do\">会计在线模考</a>        <a href=\"http://www.happyacc.com/news/detail_389/\">招聘信息</a>        <br>        -->        <!--京ICP备13028093号 -->\t\t京ICP备15037166号-1<script>var _hmt = _hmt || [];(function() {  var hm = document.createElement(\"script\");  hm.src = \"//hm.baidu.com/hm.js?805cda4978dd0b1c029372727343e7ef\";  var s = document.getElementsByTagName(\"script\")[0];   s.parentNode.insertBefore(hm, s);})();</script>    </div>    <div class=\"copy\">©happyacc.com Inc. All Rights Reserved</div></div></body></html>";


        Pattern p = Pattern.compile("(<form action=\"./goexam.do\\?examstyle=1\" id=\"form\" method=\"post\">)([\\s\\S]*?)(</form>)");
        Matcher m = p.matcher(str);
        if (m.find()) {
            str = m.group(2);
            System.out.println("Found value: " + str);
        }
        Pattern p2 = Pattern.compile("(name=\")([\\w]*)(\"\\s*)(value=['\"])([\\w\\W]*?)(['\"])");
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            System.out.println("Found value: " + m2.group(2) + m2.group(5));
        }
        System.out.println("..............");
        Pattern p3 = Pattern.compile("(id=\")([\\w]*)(\"\\s*)(value=['\"])([\\w\\W]*?)(['\"])");
        Matcher m3 = p3.matcher(str);
        while (m3.find()) {
            System.out.println("Found value: " + m3.group(2) + m3.group(5));
        }

    }


}
