package HTMLParser;

import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by ZhaoTao on 2016/6/21.
 */

/**
 * 51job招聘
 */
public class _51JobWeb {
    private String queryUrl = "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9&curr_page=1";

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public Set<String> getUrls(String fromUrl){
        LinkFilter linkFilter = new LinkFilter(){
            @Override
            public boolean accept(String url) {
                if(url.contains("http://jobs.51job.com/tianjin")){
                    return true;
                }else {
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
        try {

            NodeFilter filterClassTitleLi = new HasAttributeFilter("class","tHeader tHjob");
            NodeFilter filterClassForm = new HasAttributeFilter("class","jtag inbox");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class","bmsg job_msg inbox");
            NodeFilter filterClassFormbms = new HasAttributeFilter("class","bmsg inbox");

            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type","text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("gbk");


            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassTitleLi);//标题
            Div div= (Div) nodeList.elementAt(0);
            String str = div.toPlainTextString();
            String strTemp = HtmlParserUtils.removeSpaceEnter2(str);
            String strArray[] = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");

            jobOperatingPostCollect.setTitle(strArray[3]);
            jobOperatingPostCollect.setPay(strArray[5]);
            jobOperatingPostCollect.setAddress(strArray[4]);
            jobOperatingPostCollect.setCompany(strArray[7]);

            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("gbk");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassForm);//内容
            str = nodeListForm.asString();
            strTemp = HtmlParserUtils.removeSpaceEnter2(str);
            strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");
            jobOperatingPostCollect.setEducation(strArray[2]);
            jobOperatingPostCollect.setNumber(strArray[3]);
            jobOperatingPostCollect.setPublishData(String.valueOf(new Date().getYear() + 1900) + "-" + strArray[4].substring(0, 5));
            String tempAttraction = "";
            for(int i=9;i<strArray.length;i++){
                tempAttraction+=" "+strArray[i];
            }
            jobOperatingPostCollect.setAttraction(tempAttraction);


            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);   //描述
            parser.setEncoding("gbk");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);

            str = nodeListForm2.asString();
            strTemp = HtmlParserUtils.removeSpaceEnter2(str);
            strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");
            StringBuffer sbDesc = new StringBuffer();
            for(int i=0;i<strArray.length-2;i++){
                sbDesc.append(strArray[i]);
            }
            jobOperatingPostCollect.setDesc(sbDesc.toString());


            URLConnection connection4 = url1.openConnection();
            connection4.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection4);   //描述
            parser.setEncoding("gbk");
            NodeList nodeListForm3 = parser.extractAllNodesThatMatch(filterClassFormbms);

            str = nodeListForm3.asString();
            strTemp = HtmlParserUtils.removeSpaceEnter2(str);
            strArray = HtmlParserUtils.removeHtmlTag(strTemp).split("\\|");
            jobOperatingPostCollect.setAddress(HtmlParserUtils.removeHtmlTag(strArray[3]));

        } catch (ParserException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            return jobOperatingPostCollect;
        }
    }

    public List<JobOperatingPostCollect> getRecord() throws InterruptedException {

        List<JobOperatingPostCollect> list = new ArrayList<>();
        Set<String> urlSet = getUrls(queryUrl); //获取url

        Iterator<String> it = urlSet.iterator();
        while(it.hasNext()){
            Thread.sleep(1000);
            JobOperatingPostCollect jobOperatingPostCollect = extractLinks(it.next());
            if (null != jobOperatingPostCollect.getTitle()) {
                list.add(jobOperatingPostCollect);
            }
        }
        //翻页
        String queryUrl2 = queryUrl.substring(0,queryUrl.length()-1)+"2";
        Set<String> urlSet2 = getUrls(queryUrl2);
        Iterator<String> it2 = urlSet2.iterator();
        while(it2.hasNext()){
            Thread.sleep(1000);
            JobOperatingPostCollect jobOperatingPostCollect = extractLinks(it2.next());
            if (null != jobOperatingPostCollect.getTitle()) {
                list.add(jobOperatingPostCollect);
            }
        }
        return list;
    }
}
