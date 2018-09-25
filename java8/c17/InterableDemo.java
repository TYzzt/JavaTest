package c17;

import c15.TestC15;

import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhaoTao on 2016/7/11.
 */
public class InterableDemo {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E8%B4%A2%E5%8A%A1%E6%80%BB%E7%9B%91&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E8%B4%A2%E5%8A%A1%E7%BB%8F%E7%90%86&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E5%87%BA%E7%BA%B3&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E6%A0%B8%E7%AE%97&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E6%88%90%E6%9C%AC&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E7%A8%8E%E5%8A%A1&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fr omJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E5%86%85%E6%8E%A7&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E9%A2%84%E7%AE%97&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E6%80%BB%E8%B4%A6&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9",
                "http://search.51job.com/jobsearch/search_result.php?fromJs=1&jobarea=050000%2C00&funtype=0000&industrytype=00&keyword=%E5%BE%80%E6%9D%A5&keywordtype=2&lang=c&stype=2&postchannel=0000&fromType=1&confirmdate=9"
        );
        list.forEach(TestC15::testStr);
    }

}
