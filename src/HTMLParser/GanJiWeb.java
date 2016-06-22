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

/**
 * 赶集网招聘信息
 */
public class GanJiWeb {
    private String queryUrl = "http://tj.ganji.com/zpcaikuai/z1/o1";

    public void setQueryUrll(int i) {
        queryUrl = "http://tj.ganji.com/zpcaikuai/z1/o" + i;
    }

    public Set<String> getUrls(String fromUrl){
        LinkFilter linkFilter = new LinkFilter(){
            @Override
            public boolean accept(String url) {
                if (url.contains("http://tj.ganji.com/zpcaiwushenji") && url.contains("x.htm")) {
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

            NodeFilter filterClassA = new HasAttributeFilter("class", "clearfix pos-relat");
            NodeFilter filterClassB = new HasAttributeFilter("class", "d-welf-items");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class", "deta-Corp");
            NodeFilter titleNodeFilter = new NodeClassFilter(TitleTag.class);

            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type","text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");
            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassA);
            String str = nodeList.asString();
            String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String[] strArray = str2.split("\n");

            jobRecord.setClasses(strArray[2].substring(strArray[2].indexOf("：") + 1));
            jobRecord.setPay(strArray[5].substring(0, strArray[5].indexOf("急用钱")));
            jobRecord.setEducation(strArray[6].substring(strArray[2].indexOf("：") + 1));
            jobRecord.setExperience(strArray[8].substring(strArray[2].indexOf("：") + 1));
            jobRecord.setNumber(strArray[10].substring(strArray[2].indexOf("：") + 1));
            jobRecord.setAddress(strArray[19].substring(strArray[2].indexOf("：") + 1));

            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassB);//内容
            str = nodeListForm.asString();
            jobRecord.setAttraction(HtmlParserUtils.removeSpaceEnter3(str));

            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);   //描述
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);
            str = nodeListForm2.asString();
            jobRecord.setDesc(HtmlParserUtils.removeSpaceEnter3(str));

            URLConnection connection4 = url1.openConnection();
            connection4.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection4);
            parser.setEncoding("utf-8");
            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(titleNodeFilter);
            str = nodeListForm3.asString();
            jobRecord.setTitle(str.substring(str.indexOf("【") + 1, str.indexOf(",")));
            jobRecord.setCompany(str.substring(str.indexOf(",") + 1, str.indexOf("】")));

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
                JobRecord jobRecord = extractLinks(itTemp.next());
                if (null != jobRecord.getTitle()) {
                    list.add(jobRecord);
                }
            }
        }
        return list;
    }
}
