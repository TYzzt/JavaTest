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
 * Created by ZhaoTao on 2016/6/20.
 */

/**
 * 中华英才网解析
 */
public class ChinahrWeb {

    private String queryUrl = "http://www.chinahr.com/sou/?city=35%2C399&keyword=%E4%BC%9A%E8%AE%A1&refreshTime=1&page=1";

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public  JobRecord extractLinks(String url) {
        JobRecord jobRecord = new JobRecord();
        jobRecord.setUrl(url);
        //todo 时间
        try {
            NodeFilter filterClassTitleLi = new HasAttributeFilter("class","base_info");
            NodeFilter filterClassA = new HasAttributeFilter("class","job_fit_tags");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class","job_intro_wrap");
            NodeFilter titleNodeFilter = new NodeClassFilter(TitleTag.class);

            // 1、构造一个Parser，并设置相关的属性
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type","text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");

            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassTitleLi);//标题
            String str = nodeList.asString();
            String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String strArray[] = HtmlParserUtils.removeHtmlTag(str2).split("\\|");
            jobRecord.setTitle(strArray[3]);
            jobRecord.setPay(strArray[8]);
            jobRecord.setAddress(strArray[11]);
            jobRecord.setNature(strArray[14]);
            jobRecord.setEducation(strArray[17]);
            jobRecord.setExperience(strArray[20]);


            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassA);//内容
            str = nodeListForm.asString();
            jobRecord.setAttraction(HtmlParserUtils.removeHtmlTag(HtmlParserUtils.removeSpaceEnter3(str)));

            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);   //描述
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);
            str = nodeListForm2.asString();
            jobRecord.setDesc(HtmlParserUtils.removeSpaceEnter(str));

            URLConnection connection4 = url1.openConnection();
            connection4.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection4);
            parser.setEncoding("utf-8");
            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(titleNodeFilter);
            str = nodeListForm3.asString();
            jobRecord.setCompany(str.substring(str.indexOf("_")+1,str.indexOf("招聘信息 —")));


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

    public  Set<String> getUrls(String fromUrl){
        LinkFilter linkFilter = new LinkFilter(){
            @Override
            public boolean accept(String url) {
               if(url.contains("http://www.chinahr.com/job")&&url.contains(".html")){
                   return true;
               }else {
                   return false;
               }
            }
        };
        Set<String> urlSet = HtmlLinkParser.extractLinks(fromUrl, linkFilter);

        return urlSet;
    }

    public  List<JobRecord> getRecord() throws InterruptedException {
        List<JobRecord> list = new ArrayList<>();

        for(int i=1;i<=5;i++){
            String queryUrlTemp = queryUrl.substring(0,queryUrl.length()-1)+i;
            Set<String> urlSetTemp = getUrls(queryUrlTemp);
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
