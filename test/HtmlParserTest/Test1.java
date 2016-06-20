package HtmlParserTest;

import HTMLParser.HtmlLinkParser;
import HTMLParser.JobRecord;
import HTMLParser.LinkFilter;
import HTMLParser.ZhiLIanFilter;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by ZhaoTao on 2016/6/17.
 */
public class Test1 {
    @Test
    public void testExtractLinks() {
        String url = "http://www.baidu.com";
        LinkFilter linkFilter;
        linkFilter = new LinkFilter(){
            @Override
            public boolean accept(String url) {
                if(url.contains("baidu")){
                    return true;
                }else{
                    return false;
                }
            }

        };
        Set<String> urlSet = HtmlLinkParser.extractLinks(url, linkFilter);

        Iterator<String> it = urlSet.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }


    @Test
    public void testgetJob(){
        List<JobRecord> list =  new ZhiLIanFilter().getRecord();
        System.out.println(1);
    }


}
