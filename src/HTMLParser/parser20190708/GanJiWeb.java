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
 * Created by ZhaoTao on 2016/6/22.
 */

/**
 * 赶集网招聘信息
 */
public class GanJiWeb implements Runnable {
    public Thread t;
    private String queryUrl = "http://tj.ganji.com/zpcaikuai/z1/o1";
    //关键字：财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来，会计
    private List<String> queryUrlList = Arrays.asList(
            "http://tj.ganji.com/zpcaiwuzongjian/z1/o1",
            "http://tj.ganji.com/zpcaiwujingli/z1/o1",
            "http://tj.ganji.com/zpcaiwuzhuguan/z1/o1",
            "http://tj.ganji.com/zpkuaijizhuguan/z1/o1",
            "http://tj.ganji.com/zpkuaijijingli/z1/o1",
            "http://tj.ganji.com/zpchuna/z1/o1",
            "http://tj.ganji.com/zphesuan/z1/o1",
            "http://tj.ganji.com/zpchengben/z1/o1",
            "http://tj.ganji.com/zpshuiwu/z1/o1",
            "http://tj.ganji.com/zpneikong/z1/o1",
            "http://tj.ganji.com/zpyusuan/z1/o1",
            "http://tj.ganji.com/zpzongzhang/z1/o1",
            "http://tj.ganji.com/zpwanglai/z1/o1",
            "http://tj.ganji.com/zpcaikuai/z1/o1"
    );
    private List<JobOperatingPostCollect> collectList = new ArrayList<>();

    public GanJiWeb() {
        t = new Thread(this);
        t.start();
    }

    public void setQueryUrll(int i) {
        queryUrl = "http://tj.ganji.com/zpcaikuai/z1/o" + i;
    }

    ;

    public List<JobOperatingPostCollect> getCollectList() {
        return this.collectList;
    }

    public Set<String> getUrls(String fromUrl) {
        LinkFilter linkFilter = new LinkFilter() {
            @Override
            public boolean accept(String url) {
                if (url.contains("http://tj.ganji.com/zpcaiwushenji") && url.contains("x.htm")) {
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
        jobOperatingPostCollect.setSource("赶集网");
        try {

            NodeFilter filterClassA = new HasAttributeFilter("class", "clearfix pos-relat");
            NodeFilter filterClassB = new HasAttributeFilter("class", "d-welf-items");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class", "deta-Corp");
            NodeFilter titleNodeFilter = new NodeClassFilter(TitleTag.class);
            NodeFilter filterIdA = new HasAttributeFilter("id", "description-compy"); //公司信息

            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");
            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassA);
            String str = nodeList.asString();
            String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String[] strArray = str2.split("\n");

            jobOperatingPostCollect.setClasses(strArray[2].substring(strArray[2].indexOf("：") + 1));
            jobOperatingPostCollect.setPay(strArray[5].substring(0, strArray[5].indexOf("急用钱")));
            jobOperatingPostCollect.setEducation(strArray[6].substring(strArray[2].indexOf("：") + 1));
            jobOperatingPostCollect.setExperience(strArray[8].substring(strArray[2].indexOf("：") + 1));
            jobOperatingPostCollect.setNumber(strArray[10].substring(strArray[2].indexOf("：") + 1));
            jobOperatingPostCollect.setAddress(strArray[19].substring(strArray[2].indexOf("：") + 1));

            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassB);//内容
            str = nodeListForm.asString();
            jobOperatingPostCollect.setAttraction(HtmlParserUtils.removeSpaceEnter3(str));

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
            jobOperatingPostCollect.setTitle(str.substring(str.indexOf("【") + 1, str.indexOf(",")));
            jobOperatingPostCollect.setCompany(str.substring(str.indexOf(",") + 1, str.indexOf("】")));
            jobOperatingPostCollect.setPublishDate(timestamp);


            URLConnection connection5 = url1.openConnection();
            connection5.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection5);
            parser.setEncoding("utf-8");
            NodeList nodeListForm4 = parser.extractAllNodesThatMatch(filterIdA);
            str = nodeListForm4.asString();
            jobOperatingPostCollect.setCompanyInfo(str);

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

    public List<JobOperatingPostCollect> getRecord() throws InterruptedException {
        System.out.println("ganjigetJob");
        List<JobOperatingPostCollect> list = new ArrayList<>();

        for (int i = 1; i <= 1; i++) {
            this.setQueryUrll(i);
            Set<String> urlSetTemp = getUrls(queryUrl);
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
                for (int i = 1; i <= 1; i++) {
                    /*  this.setQueryUrll(i);*/
                    Set<String> urlSetTemp = getUrls(str);
                    Iterator<String> itTemp = urlSetTemp.iterator();
                    while (itTemp.hasNext()) {

                        Thread.sleep(1000);
                        System.out.println("ganjigetJob");
                        JobOperatingPostCollect jobOperatingPostCollect = extractLinks(itTemp.next());
                        if (null != jobOperatingPostCollect.getTitle() && null != jobOperatingPostCollect.getOperateDesc()
                                && HtmlParserUtils.titleFilter(jobOperatingPostCollect.getTitle())) {
                            collectList.add(jobOperatingPostCollect);
                        }

                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
