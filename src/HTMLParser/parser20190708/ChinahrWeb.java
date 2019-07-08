package HTMLParser.parser20190708;


import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.TitleTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by ZhaoTao on 2016/6/20.
 */

/**
 * 中华英才网解析
 */
public class ChinahrWeb implements Runnable {

    public Thread t;
    private String queryUrl = "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E4%BC%9A%E8%AE%A1&refreshTime=1&page=1";
    //关键字：财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来,会计
    private List<String> queryUrlList = Arrays.asList(
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E8%B4%A2%E5%8A%A1%E6%80%BB%E7%9B%91&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E8%B4%A2%E5%8A%A1%E7%BB%8F%E7%90%86&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E5%87%BA%E7%BA%B3&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E6%A0%B8%E7%AE%97&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E6%88%90%E6%9C%AC&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E7%A8%8E%E5%8A%A1&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E5%86%85%E6%8E%A7&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E9%A2%84%E7%AE%97&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E6%80%BB%E8%B4%A6&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E5%BE%80%E6%9D%A5&refreshTime=1&page=1",
            "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E4%BC%9A%E8%AE%A1&refreshTime=1&page=1"
    );
    private List<JobOperatingPostCollect> collectList = new ArrayList<>();

    public ChinahrWeb() {
        t = new Thread(this);
        t.start();
    }

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    ;

    public List<JobOperatingPostCollect> getCollectList() {
        return this.collectList;
    }

    public JobOperatingPostCollect extractLinks(String url) {
        JobOperatingPostCollect jobOperatingPostCollect = new JobOperatingPostCollect();
        jobOperatingPostCollect.setUrl(url);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        jobOperatingPostCollect.setCreateTime(timestamp);
        jobOperatingPostCollect.setState("0");
        jobOperatingPostCollect.setSfFilter(false);
        jobOperatingPostCollect.setSource("中华英才网");
        try {
            NodeFilter filterClassTitleLi = new HasAttributeFilter("class", "base_info");
            NodeFilter filterClassA = new HasAttributeFilter("class", "job_fit_tags");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class", "job_intro_wrap");
            NodeFilter titleNodeFilter = new NodeClassFilter(TitleTag.class);
            NodeFilter filterClassCompnyTag = new HasAttributeFilter("class", "compny_tag");
            NodeFilter filterClassCompnySer = new HasAttributeFilter("class", "company_service");

            // 1、构造一个Parser，并设置相关的属性
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");

            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassTitleLi);//标题
            String str = nodeList.asString();
            String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String strArray[] = HtmlParserUtils.removeHtmlTag(str2).split("\\|");
            jobOperatingPostCollect.setTitle(strArray[3]);
            jobOperatingPostCollect.setPay(strArray[8]);
            jobOperatingPostCollect.setAddress(strArray[11]);
            jobOperatingPostCollect.setNature(strArray[14]);
            jobOperatingPostCollect.setEducation(strArray[17]);
            jobOperatingPostCollect.setExperience(strArray[20]);


            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassA);//内容
            str = nodeListForm.asString();
            jobOperatingPostCollect.setAttraction(HtmlParserUtils.removeHtmlTag(HtmlParserUtils.removeSpaceEnter3(str)));

            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);   //描述
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);
            str = nodeListForm2.asString();
            jobOperatingPostCollect.setOperateDesc(HtmlParserUtils.operateForm(str));

            URLConnection connection4 = url1.openConnection();
            connection4.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection4);
            parser.setEncoding("utf-8");
            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(titleNodeFilter);
            str = nodeListForm3.asString();
            jobOperatingPostCollect.setCompany(str.substring(str.indexOf("_") + 1, str.indexOf("招聘信息 —")));
            jobOperatingPostCollect.setPublishDate(timestamp);

            URLConnection connection5 = url1.openConnection();
            connection5.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection5);
            parser.setEncoding("utf-8");
            NodeList nodeListForm4 = parser.extractAllNodesThatMatch(filterClassCompnyTag);
            str = nodeListForm4.asString();
            try {
                str2 = HtmlParserUtils.removeHtmlTag(str).replaceAll("[\r\n ]", "");
            } catch (Exception e) {
                str2 = "";
            }
            URLConnection connection6 = url1.openConnection();
            connection6.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection6);
            parser.setEncoding("utf-8");
            NodeList nodeListForm5 = parser.extractAllNodesThatMatch(filterClassCompnySer);
            str = nodeListForm5.asString();
            str2 += "||" + str;
            jobOperatingPostCollect.setCompanyInfo(str2);

        } catch (ParserException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return jobOperatingPostCollect;
        }
    }

    public Set<String> getUrls(String fromUrl) {
        LinkFilter linkFilter = new LinkFilter() {
            @Override
            public boolean accept(String url) {
                if (url.contains("http://www.chinahr.com/job") && url.contains(".html")) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        Set<String> urlSet = HtmlLinkParser.extractLinks(fromUrl, linkFilter);

        return urlSet;
    }

    public List<JobOperatingPostCollect> getRecord() throws InterruptedException {
        System.out.println("ChinagetJob");
        List<JobOperatingPostCollect> list = new ArrayList<>();

        for (int i = 1; i <= 1; i++) {
            String queryUrlTemp = queryUrl.substring(0, queryUrl.length() - 1) + i;
            Set<String> urlSetTemp = getUrls(queryUrlTemp);
            Iterator<String> itTemp = urlSetTemp.iterator();
            while (itTemp.hasNext()) {
                Thread.sleep(1000);
                JobOperatingPostCollect jobOperatingPostCollect = extractLinks(itTemp.next());
                if (null != jobOperatingPostCollect.getTitle() && null != jobOperatingPostCollect.getOperateDesc()) {
                    list.add(jobOperatingPostCollect);
                }
            }
        }
        return list;
    }

    @Override
    public void run() {
        for (String str : queryUrlList) {
            try {
                /* String queryUrlTemp = queryUrl.substring(0,queryUrl.length()-1)+i;*/
                Set<String> urlSetTemp = getUrls(str);
                Iterator<String> itTemp = urlSetTemp.iterator();
                while (itTemp.hasNext()) {
                    Thread.sleep(1000);
                    System.out.println("ChinagetJob");
                    JobOperatingPostCollect jobOperatingPostCollect = extractLinks(itTemp.next());
                    if (null != jobOperatingPostCollect.getTitle() && null != jobOperatingPostCollect.getOperateDesc()
                            && HtmlParserUtils.titleFilter(jobOperatingPostCollect.getTitle())) {
                        collectList.add(jobOperatingPostCollect);
                    }

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
