package HTMLParser.parser20190708;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.ParagraphTag;
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
 * 58同城
 */
public class _58TcWeb implements Runnable {
    public Thread t;
    private String queryUrl = "http://tj.58.com/zpcaiwushenji/pn1/?key=%E4%BC%9A%E8%AE%A1&cmcskey=%E4%BC%9A%E8%AE%A1&final=1";
    //关键字：财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来，
    private List<String> queryUrlList = Arrays.asList(
            "http://tj.58.com/job/?key=%E8%B4%A2%E5%8A%A1%E6%80%BB%E7%9B%91&cmcskey=%E8%B4%A2%E5%8A%A1%E6%80%BB%E7%9B%91&final=1",
            "http://tj.58.com/job/?key=%E8%B4%A2%E5%8A%A1%E7%BB%8F%E7%90%86&cmcskey=%E8%B4%A2%E5%8A%A1%E7%BB%8F%E7%90%86&final=1",
            "http://tj.58.com/job/?key=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&cmcskey=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&final=1",
            "http://tj.58.com/job/?key=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&cmcskey=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&final=1",
            "http://tj.58.com/zpcaiwushenji/?key=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&cmcskey=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&final=1",
            "http://tj.58.com/zpcaiwushenji/?key=%E5%87%BA%E7%BA%B3&cmcskey=%E5%87%BA%E7%BA%B3&final=1",
            "http://tj.58.com/job/?key=%E6%A0%B8%E7%AE%97&cmcskey=%E6%A0%B8%E7%AE%97&final=1",
            "http://tj.58.com/job/?key=%E6%88%90%E6%9C%AC&cmcskey=%E6%88%90%E6%9C%AC&final=1",
            "http://tj.58.com/job/?key=%E7%A8%8E%E5%8A%A1&cmcskey=%E7%A8%8E%E5%8A%A1&final=1",
            "http://tj.58.com/job/?key=%E5%86%85%E6%8E%A7&cmcskey=%E5%86%85%E6%8E%A7&final=1",
            "http://tj.58.com/job/?key=%E9%A2%84%E7%AE%97&cmcskey=%E9%A2%84%E7%AE%97&final=1",
            "http://tj.58.com/job/?key=%E6%80%BB%E8%B4%A6&cmcskey=%E6%80%BB%E8%B4%A6&final=1",
            "http://tj.58.com/job/?key=%E5%BE%80%E6%9D%A5&cmcskey=%E5%BE%80%E6%9D%A5&final=1"
    );
    private List<JobOperatingPostCollect> collectList = new ArrayList<>();

    public _58TcWeb() {
        t = new Thread(this);
        t.start();
    }

    public void setQueryUrll(int i) {
        queryUrl = "http://tj.58.com/zpcaiwushenji/pn" + i + "/?key=%E4%BC%9A%E8%AE%A1&cmcskey=%E4%BC%9A%E8%AE%A1&final=1";
    }

    ;

    public List<JobOperatingPostCollect> getCollectList() {
        return this.collectList;
    }

    public Set<String> getUrls(String fromUrl) {
        LinkFilter linkFilter = new LinkFilter() {
            @Override
            public boolean accept(String url) {
                if (url.contains("http://tj.58.com/zpcaiwushenji") && url.contains("x.shtml")) {
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
        jobOperatingPostCollect.setSource("58同城");
        try {

            NodeFilter filterClassA = new HasAttributeFilter("class", "posinfo");
            NodeFilter filterClassB = new HasAttributeFilter("class", "infoview clearfix");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class", "posMsg borb");
            NodeFilter titleNodeFilter = new NodeClassFilter(TitleTag.class);
            NodeFilter filterClassIdA = new HasAttributeFilter("id", "gongsi");

            // 1、构造一个Parser，并设置相关的属性
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");

            NodeList nodeList = parser.extractAllNodesThatMatch(titleNodeFilter);//标题
            String str = nodeList.asString();
            jobOperatingPostCollect.setTitle(str.substring(0, str.indexOf("_")));
            jobOperatingPostCollect.setCompany(str.substring(str.indexOf("_") + 1, str.indexOf("最新招聘信息")));

            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassA);//内容
            str = nodeListForm.asString();
            String str2 = str;
            jobOperatingPostCollect.setPay(HtmlParserUtils.jiansuo(str2, "薪资待遇："));
            jobOperatingPostCollect.setEducation(HtmlParserUtils.jiansuo(str2, "学历要求："));
            jobOperatingPostCollect.setClasses(HtmlParserUtils.jiansuo(str2, "招聘职位："));
            jobOperatingPostCollect.setNumber("");
            jobOperatingPostCollect.setExperience("工作年限：");
            jobOperatingPostCollect.setAddress("工作地址：");

            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassB);
            str = nodeListForm2.asString();
            jobOperatingPostCollect.setAttraction(HtmlParserUtils.removeSpaceEnter(str));

            URLConnection connection4 = url1.openConnection();
            connection4.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection4);
            parser.setEncoding("utf-8");
            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(filterClassFormIneer);
            str = nodeListForm3.asString();
            jobOperatingPostCollect.setOperateDesc(HtmlParserUtils.operateForm(str));
            jobOperatingPostCollect.setPublishDate(timestamp);

            URLConnection connection5 = url1.openConnection();
            connection5.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            parser = new Parser(connection5);
            parser.setEncoding("utf-8");
            NodeList nodeListForm4 = parser.extractAllNodesThatMatch(filterClassIdA);
            str = nodeListForm4.asString();
            NodeList nodeListForm5 = nodeListForm4.elementAt(0).getChildren();
            for (int i = 0; i < nodeListForm5.size(); i++) {
                Node node = nodeListForm5.elementAt(i);
                if (node instanceof ParagraphTag) {
                    jobOperatingPostCollect.setCompanyInfo(node.getChildren().asString());
                }
            }
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
        System.out.println("58getJob");
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
                        System.out.println("58getJob");
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
