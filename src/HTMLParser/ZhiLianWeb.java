package HTMLParser;

import org.htmlparser.Node;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ZhaoTao on 2016/6/20.
 */

/**
 * 智联招聘网
 */
public class ZhiLianWeb {

    private String queryUrl = "http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E4%BC%9A%E8%AE%A1&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1";

    public void setQueryUrl(String queryUrl) {
        this.queryUrl = queryUrl;
    }

    public JobOperatingPostCollect extractLinks(String url) {
        JobOperatingPostCollect jobOperatingPostCollect = new JobOperatingPostCollect();
        jobOperatingPostCollect.setUrl(url);
        try {
            // 1、构造一个Parser，并设置相关的属性
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type","text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");
           /* parser.getConnection().setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());*/

            NodeFilter filterClassTitleLi = new HasAttributeFilter("class","inner-left fl");
            NodeFilter filterClassForm = new HasAttributeFilter("class","terminal-ul clearfix");
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class","tab-inner-cont");

            //3、使用parser根据filter来取得所有符合条件的节点
            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassTitleLi);//标题

            //4、对取得的Node进行处理
            for(int i = 0; i<nodeList.size();i++){
                Node node = nodeList.elementAt(i);
                if(node instanceof Div){
                    Div divNode = (Div)node;
                    Node[] nodelist1 = divNode.getChildrenAsNodeArray();
                    for(Node node1:nodelist1){
                        if(node1.getText().equals("h1")){
                            jobOperatingPostCollect.setTitle(node1.getFirstChild().getText());    //标题
                        }
                        if(node1.getText().equals("h2")){
                            if(null!=node1.getFirstChild().getFirstChild()){
                                jobOperatingPostCollect.setCompany(node1.getFirstChild().getFirstChild().getText());    //公司
                            }

                        }
                        if(node1.getText().equals("div style=\"width:683px;\" class=\"welfare-tab-box\"")){//吸引
                            NodeList nodelist2 = node1.getChildren();
                            jobOperatingPostCollect.setAttraction(nodelist2.asString());
                        }
                    }

                 /*   Parser parser1 = Parser.createParser(titlehtmlText,"utf-8");*/

                }
            }

            URLConnection connection2 = url1.openConnection();
            connection2.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection2);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassForm);//内容
            String str = nodeListForm.asString();
            String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String strArray[] = str2.split("\\|");

            jobOperatingPostCollect.setPay(strArray[1].substring(5));
            jobOperatingPostCollect.setAddress(strArray[2].substring(5));
            jobOperatingPostCollect.setPublishData(strArray[3].substring(5));
            jobOperatingPostCollect.setNature(strArray[4].substring(5));
            jobOperatingPostCollect.setExperience(strArray[5].substring(5));
            jobOperatingPostCollect.setEducation(strArray[6].substring(5));
            jobOperatingPostCollect.setNumber(strArray[7].substring(5));
            jobOperatingPostCollect.setClasses(strArray[8].substring(5));

            URLConnection connection3 = url1.openConnection();
            connection3.setRequestProperty("X-Forwarded-For",HtmlParserUtils.getRandomIp());
            parser = new Parser(connection3);   //描述
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);

            str = nodeListForm2.elementAt(0).getChildren().asString();
            str = HtmlParserUtils.removeSpaceEnter2(str);
            str2 = HtmlParserUtils.removeHtmlTag(str);
            strArray = str2.split("\\|");

            jobOperatingPostCollect.setDesc(strArray[2]);
           if(strArray.length>7){
               jobOperatingPostCollect.setAddress(strArray[7]);
           }
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

    public  Set<String> getUrls(String fromUrl){
        LinkFilter linkFilter = new LinkFilter(){
            @Override
            public boolean accept(String url) {
               if(url.contains("http://jobs.zhaopin.com/")&&url.contains(".htm")){
                   return true;
               }else {
                   return false;
               }
            }
        };
        Set<String> urlSet = HtmlLinkParser.extractLinks(fromUrl, linkFilter);

        return urlSet;
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
