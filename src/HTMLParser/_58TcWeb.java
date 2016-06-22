package HTMLParser;

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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ZhaoTao on 2016/6/22.
 */
public class _58TcWeb {
    private String queryUrl = "http://tj.58.com/zpcaiwushenji/pn1/?key=%E4%BC%9A%E8%AE%A1&cmcskey=%E4%BC%9A%E8%AE%A1&final=1";

    public void setQueryUrll(int i) {
        queryUrl = "http://tj.58.com/zpcaiwushenji/pn"+i+"/?key=%E4%BC%9A%E8%AE%A1&cmcskey=%E4%BC%9A%E8%AE%A1&final=1";
    }

    public Set<String> getUrls(String fromUrl){
        LinkFilter linkFilter = new LinkFilter(){
            @Override
            public boolean accept(String url) {
                if(url.contains("http://tj.58.com/zpcaiwushenji")&&url.contains("x.shtml")){
                    return true;
                }else {
                    return false;
                }
            }
        };
        Set<String> urlSet = HtmlLinkParser.extractLinks(fromUrl, linkFilter);

        return urlSet;
    }

    public  JobRecord extractLinks(String url){
        JobRecord jobRecord = new JobRecord();
        jobRecord.setUrl(url);
        try {

            NodeFilter filterClassA = new HasAttributeFilter("class","posinfo");
            NodeFilter filterClassB = new HasAttributeFilter("class","infoview clearfix");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class","posMsg borb");
            NodeFilter titleNodeFilter = new NodeClassFilter(TitleTag.class);

            // 1、构造一个Parser，并设置相关的属性
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type","text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");

            NodeList nodeList = parser.extractAllNodesThatMatch(titleNodeFilter);//标题
            String str = nodeList.asString();
            jobRecord.setTitle(str.substring(0,str.indexOf("_")));
            jobRecord.setCompany(str.substring(str.indexOf("_")+1,str.indexOf("最新招聘信息")));

            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassA);//内容
            str = nodeListForm.asString();String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String strArray[] = HtmlParserUtils.removeHtmlTag(str2).split("\\|");
            jobRecord.setPay(strArray[6]);
            jobRecord.setEducation(strArray[10]);
            jobRecord.setClasses(strArray[17]);
            jobRecord.setNumber(strArray[18]);
            jobRecord.setExperience(strArray[22]);
            jobRecord.setAddress(strArray[27]);

            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassB);
            str = nodeListForm2.asString();
            jobRecord.setAttraction(HtmlParserUtils.removeSpaceEnter(str));

            URLConnection connection4 = url1.openConnection();
            connection4.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection4);
            parser.setEncoding("utf-8");
            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(filterClassFormIneer);
            str = nodeListForm3.asString();
            jobRecord.setDesc(HtmlParserUtils.removeHtmlTag(HtmlParserUtils.removeSpaceEnter(str)));

        } catch (ParserException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return jobRecord;
        }
    }

    public List<JobRecord> getRecord() throws InterruptedException {

        List<JobRecord> list = new ArrayList<>();

        for(int i=1;i<=3;i++){
            this.setQueryUrll(i);
            Set<String> urlSetTemp = getUrls(queryUrl);
            Iterator<String> itTemp = urlSetTemp.iterator();
            while(itTemp.hasNext()){
                Thread.sleep(1000);
                list.add(extractLinks(itTemp.next()));
            }
        }
        return list;
    }
}
