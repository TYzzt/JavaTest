package HTMLParser.parser20190708;


import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.nodes.TextNode;
import org.htmlparser.tags.Div;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by ZhaoTao on 2016/6/21.
 */

/**
 * 51job招聘
 */
public class _51JobWeb implements Runnable {

    public Thread t;
    private String queryUrl = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9&curr_page=1";
    //关键字：财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来，会计
    private List<String> queryUrlList = Arrays.asList(
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E8%B4%A2%E5%8A%A1%E6%80%BB%E7%9B%91&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E8%B4%A2%E5%8A%A1%E7%BB%8F%E7%90%86&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E5%87%BA%E7%BA%B3&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E6%A0%B8%E7%AE%97&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E6%88%90%E6%9C%AC&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E7%A8%8E%E5%8A%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E5%86%85%E6%8E%A7&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E9%A2%84%E7%AE%97&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E6%80%BB%E8%B4%A6&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000&keyword=%E4%BC%9A%E8%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
            "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E5%BE%80%E6%9D%A5&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9"
    );
    private List<JobOperatingPostCollect> collectList = new ArrayList<>();

    public _51JobWeb() {
        t = new Thread(this);
        t.start();
    }

    public List<JobOperatingPostCollect> getCollectList() {
        return this.collectList;
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public Set<String> getUrls(String fromUrl) {
        LinkFilter linkFilter = new LinkFilter() {
            @Override
            public boolean accept(String url) {
                if (url.contains("https://jobs.51job.com/tianjin")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        Set<String> urlSet = HtmlLinkParser.extractLinks(fromUrl, linkFilter);

        return urlSet;
    }


    public JobOperatingPostCollect extractLinks(String url) {
        JobOperatingPostCollect jobOperatingPostCollect = new JobOperatingPostCollect();
        jobOperatingPostCollect.setUrl(url);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        jobOperatingPostCollect.setCreateTime(timestamp);
        jobOperatingPostCollect.setState("0");
        jobOperatingPostCollect.setSfFilter(false);
        jobOperatingPostCollect.setSource("前程无忧(51Job)");
        try {

            NodeFilter filterClassTitleLi = new HasAttributeFilter("class", "tHeader tHjob"); //标题
            NodeFilter filterClassForm = new HasAttributeFilter("class", "jtag");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class", "bmsg job_msg inbox");
            NodeFilter filterClassFormbms = new HasAttributeFilter("class", "bmsg inbox");
            NodeFilter filterClassFormtbms = new HasAttributeFilter("class", "tmsg inbox");


            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("gbk");


            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassTitleLi);//标题
            Div div = (Div) nodeList.elementAt(0);
            String str = div.toPlainTextString();

            System.out.println(str);

            String strTemp = HtmlParserUtils.removeSpaceEnter2(str);
            String[] strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");

            jobOperatingPostCollect.setTitle(strArray[4]);
            jobOperatingPostCollect.setPay(strArray[6]);
            jobOperatingPostCollect.setAddress(strArray[14]);
            jobOperatingPostCollect.setCompany(strArray[9]);
            jobOperatingPostCollect.setEducation(strArray[16]);
            jobOperatingPostCollect.setExperience(strArray[15]);
            jobOperatingPostCollect.setNumber(strArray[17]);
            Timestamp ts;
            try {
                ts = new Timestamp(DateUtil.parseDate(DateUtil.DATE_STYLE4, String.valueOf(new Date().getYear() + 1900) + "-" + strArray[18].substring(0, 5)).getTime());

            } catch (Exception e) {
                ts = new Timestamp(System.currentTimeMillis());
                e.printStackTrace();
            }
            jobOperatingPostCollect.setPublishDate(ts);

            parser.reset();
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassForm);//内容
            str = nodeListForm.asString();
            strTemp = HtmlParserUtils.removeSpaceEnter2(str);
            strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");
//            jobOperatingPostCollect.setEducation(strArray[2]);
//            jobOperatingPostCollect.setNumber(strArray[3]);

            StringBuilder tempAttraction = new StringBuilder();
            for (String s : strArray) {
                tempAttraction.append(" ").append(s);
            }
            jobOperatingPostCollect.setAttraction(tempAttraction.toString());


            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);   //描述
            parser.setEncoding("gbk");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);

            NodeList listNode = nodeListForm2.elementAt(0).getChildren();
            String operDesc = "";
            String temp = "";
            temp = listNode.toHtml();
            for (int i = 0; i < listNode.size(); i++) {
                Node node = listNode.elementAt(i);
                if (node instanceof TextNode) {
                    operDesc += ((TextNode) node).getText();
                }

            }


            str = nodeListForm2.asString();
            strTemp = HtmlParserUtils.removeSpaceEnter4(str);
            strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");
            StringBuffer sbDesc = new StringBuffer();
            for (int i = 0; i < strArray.length - 2; i++) {
                sbDesc.append(strArray[i]);
            }
            jobOperatingPostCollect.setOperateDesc(HtmlParserUtils.operateForm(sbDesc.toString()));

            parser.reset();

            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(filterClassFormbms);

//            str = nodeListForm3.asString();
//            strTemp = HtmlParserUtils.removeSpaceEnter2(str);
//            strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");
//            jobOperatingPostCollect.setAddress(HtmlParserUtils.removeHtmlTag(strArray[3]));


            parser.reset();
            NodeList nodeListForm4 = parser.extractAllNodesThatMatch(filterClassFormtbms);
            str = nodeListForm4.asString();
            NodeList listNode2 = nodeListForm4.elementAt(0).getChildren();
            strTemp = "";
            for (int i = 0; i < listNode2.size(); i++) {
                Node node = listNode2.elementAt(i);
                if (node instanceof TagNode) {
                    strTemp += "|";
                }
                if (node instanceof TextNode) {
                    strTemp += ((TextNode) node).getText();
                }
            }

            jobOperatingPostCollect.setCompanyInfo(HtmlParserUtils.removeHtmlTag(HtmlParserUtils.removeSpaceEnter2(strTemp)));

        } catch (ParserException | IOException e) {
            e.printStackTrace();
        }
        return jobOperatingPostCollect;
    }

    public List<JobOperatingPostCollect> getRecord() throws InterruptedException {
        System.out.println("51getJob");
        List<JobOperatingPostCollect> list = new ArrayList<>();
        Set<String> urlSet = getUrls(queryUrl); //获取url

        Iterator<String> it = urlSet.iterator();
        while (it.hasNext()) {
            Thread.sleep(1000);
            JobOperatingPostCollect jobOperatingPostCollect = extractLinks(it.next());
            if (null != jobOperatingPostCollect.getTitle() && null != jobOperatingPostCollect.getOperateDesc()) {
                list.add(jobOperatingPostCollect);
            }
        }
        //翻页
/*        String queryUrl2 = queryUrl.substring(0,queryUrl.length()-1)+"2";
        Set<String> urlSet2 = getUrls(queryUrl2);
        Iterator<String> it2 = urlSet2.iterator();
        while(it2.hasNext()){
            Thread.sleep(1000);
            JobOperatingPostCollect jobOperatingPostCollect = extractLinks(it2.next());
            if (null != jobOperatingPostCollect.getTitle()) {
                list.add(jobOperatingPostCollect);
            }
        }*/
        return list;
    }

    @Override
    public void run() {
        for (String str : queryUrlList) {
            try {
                Set<String> urlSet = getUrls(str); //获取url

                Iterator<String> it = urlSet.iterator();
                int i = 0; //限制50条
                while (it.hasNext() && i < 50) {
                    Thread.sleep(1000);
                    JobOperatingPostCollect jobOperatingPostCollect = extractLinks(it.next());
                    System.out.println("51getJob");
                    if (null != jobOperatingPostCollect.getTitle() && null != jobOperatingPostCollect.getOperateDesc()
                            && HtmlParserUtils.titleFilter(jobOperatingPostCollect.getTitle())) {
                        collectList.add(jobOperatingPostCollect);
                    }
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

//
//    public static void main(String[] args) {
//        new _51JobWeb().extractLinks("https://jobs.51job.com/tianjin-hdq/114608035.html?s=01&t=0");
//    }

}
