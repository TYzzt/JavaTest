package HTMLParser;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.tags.Div;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ZhaoTao on 2016/6/20.
 */

/**
 * 智联招聘网解析
 */
public class ZhiLianWeb {

    private  String queryUrl = "http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E4%BC%9A%E8%AE%A1&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1";

    public  JobRecord extractLinks(String url) {
        JobRecord jobRecord = new JobRecord();
        jobRecord.setUrl(url);
        try {
            // 1、构造一个Parser，并设置相关的属性
            Parser parser = new Parser(url);
            parser.setEncoding("utf-8");

            System.out.println(parser.toString());

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
                            jobRecord.setTitle(node1.getFirstChild().getText());    //标题
                        }
                        if(node1.getText().equals("h2")){
                            jobRecord.setCompany(node1.getFirstChild().getFirstChild().getText());    //公司
                        }
                        if(node1.getText().equals("div style=\"width:683px;\" class=\"welfare-tab-box\"")){//吸引
                            NodeList nodelist2 = node1.getChildren();
                            jobRecord.setAttraction(nodelist2.asString());
                        }
                    }

                 /*   Parser parser1 = Parser.createParser(titlehtmlText,"utf-8");*/

                }
            }

            parser = new Parser(url);
            parser.setEncoding("utf-8");
            NodeList nodeListForm = parser.extractAllNodesThatMatch(filterClassForm);//内容
            String str = nodeListForm.asString();
            String str2 = HtmlParserUtils.removeSpaceEnter2(str);
            String strArray[] = str2.split("\\|");

            jobRecord.setPay(strArray[1].substring(5));
            jobRecord.setAddress(strArray[2].substring(5));
            jobRecord.setPublishData(strArray[3].substring(5));
            jobRecord.setNature(strArray[4].substring(5));
            jobRecord.setExperience(strArray[5].substring(5));
            jobRecord.setEducation(strArray[6].substring(5));
            jobRecord.setNumber(strArray[7].substring(5));
            jobRecord.setClasses(strArray[8].substring(5));

            parser = new Parser(url);   //描述
            parser.setEncoding("utf-8");
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);

            str = nodeListForm2.elementAt(0).getChildren().asString();
            str = HtmlParserUtils.removeSpaceEnter2(str);
            str2 = HtmlParserUtils.removeHtmlTag(str);
            strArray = str2.split("\\|");

            jobRecord.setDesc(strArray[2]);
           if(strArray.length>7){
               jobRecord.setAddress(strArray[7]);
           }
        } catch (ParserException e) {
            e.printStackTrace();
        }
        return jobRecord;
    }

    public  Set<String> getUrls(){
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
        Set<String> urlSet = HtmlLinkParser.extractLinks(queryUrl, linkFilter);

        return urlSet;
    }


    public  List<JobRecord> getRecord(){
        Set<String> urlSet = getUrls();
        Iterator<String> it = urlSet.iterator();
        List<JobRecord> list = new ArrayList<>();
        while(it.hasNext()){
            list.add(extractLinks(it.next()));
        }
        return list;
    }
}
