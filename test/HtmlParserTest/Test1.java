package HtmlParserTest;

import HTMLParser.*;
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
    public void testgetJob() throws InterruptedException {
        List<JobRecord> list =  new ZhiLianWeb().getRecord();
        System.out.println(1);
    }
    @Test
    public void test(){
        System.out.println(HtmlParserUtils.getRandomIp());
    }

}
