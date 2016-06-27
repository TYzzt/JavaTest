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
        List<JobOperatingPostCollect> list = new ZhiLianWeb().getRecord();
        System.out.println(1);
    }
    @Test
    public void testgetJob51() throws InterruptedException {
        List<JobOperatingPostCollect> list = new _51JobWeb().getRecord();
        System.out.println(1);
    }
    @Test
    public void testgetJobChin() throws InterruptedException {
        List<JobOperatingPostCollect> list = new ChinahrWeb().getRecord();
        System.out.println(1);
    }
    @Test
    public void testgetJob58() throws InterruptedException {
        List<JobOperatingPostCollect> list = new _58TcWeb().getRecord();
        System.out.println(1);
    }

    @Test
    public void testgetJobGj() throws InterruptedException {
        List<JobOperatingPostCollect> list = new GanJiWeb().getRecord();
        System.out.println(1);
    }
    @Test
    public void test(){
        System.out.println(HtmlParserUtils.getRandomIp());
    }
    @Test
    public void test51URl(){
        _51JobWeb f = new _51JobWeb();
        int i = 0;
        Iterator<String> it = f.getUrls("http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9").iterator();
        while(it.hasNext()){
            i++;
            System.out.println(it.next());
        }
        System.out.println(i);
    }
    @Test
    public void test51job(){
        _51JobWeb f = new _51JobWeb();
        f.extractLinks("http://jobs.51job.com/tianjin/78907086.html?s=0");
    }
    @Test
    public void testChianHr(){
        ChinahrWeb f = new ChinahrWeb();
        f.extractLinks("http://www.chinahr.com/job/13-455745.html");
    }
    @Test
    public void test58(){
        _58TcWeb f = new _58TcWeb();
        f.extractLinks("http://tj.58.com/zpcaiwushenji/25269518676015x.shtml?psid=151983199192225748380042638&entinfo=25269518676015_3&role=3&iuType=j_2&PGTID=0d303653-0001-2d62-b709-c64f9b35fd2f&ClickID=3");
    }

    @Test
    public void testgj() {
        GanJiWeb f = new GanJiWeb();
        f.extractLinks("http://tj.ganji.com/zpcaiwushenji/1677673895x.htm");
    }

}
