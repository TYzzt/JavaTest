package HTMLParser.parser20190708;


import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ZhaoTao on 2016/6/20.
 */

/**
 * 智联招聘网
 */
public class ZhiLianWeb implements Runnable {


    public Thread t;
    //关键字：财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来，会计
//    private List<String> queryUrlList= Arrays.asList(
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E8%B4%A2%E5%8A%A1%E6%80%BB%E7%9B%91&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E8%B4%A2%E5%8A%A1%E7%BB%8F%E7%90%86&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E5%87%BA%E7%BA%B3&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E6%A0%B8%E7%AE%97&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E6%88%90%E6%9C%AC&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E7%A8%8E%E5%8A%A1&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E5%86%85%E6%8E%A7&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E9%A2%84%E7%AE%97&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E6%80%BB%E8%B4%A6&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E5%BE%80%E6%9D%A5&sb=0&sm=0&fl=531&isadv=0&isfilter=1&p=1&pd=1",
//    		"http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E5%A4%A9%E6%B4%A5&kw=%E4%BC%9A%E8%AE%A1&p=1&isadv=0"
//    		);
    //财务总监，财务经理，财务主管，会计主管，会计经理，出纳，核算，成本，税务，内控，预算，总账，往来，会计
    //改为ajax 查询 2019年7月8日
    private List<String> queryUrlList = Arrays.asList("https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=天津&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=财务总监&kt=3&=0",
            "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E8%B4%A2%E5%8A%A1%E4%B8%BB%E7%AE%A1&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E4%BC%9A%E8%AE%A1%E4%B8%BB%E7%AE%A1&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E4%BC%9A%E8%AE%A1%E7%BB%8F%E7%90%86&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E5%87%BA%E7%BA%B3&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E6%A0%B8%E7%AE%97&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E6%88%90%E6%9C%AC&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E7%A8%8E%E5%8A%A1&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E5%86%85%E6%8E%A7&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E9%A2%84%E7%AE%97&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E6%80%BB%E8%B4%A6&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E5%BE%80%E6%9D%A5&kt=3&=0", "https://fe-api.zhaopin.com/c/i/sou?pageSize=20&cityId=%E5%A4%A9%E6%B4%A5&salary=0,0&workExperience=-1&education=-1&companyType=-1&employmentType=-1&jobWelfareTag=-1&kw=%E4%BC%9A%E8%AE%A1&kt=3&=0");
    private Gson gson = new Gson();
    private List<JobOperatingPostCollect> collectList = new ArrayList<>();

    public ZhiLianWeb() {
        t = new Thread(this);
        t.start();
    }

    ;

    public static void main(String[] args) {
        new ZhiLianWeb().extractLinks(null);
    }

    public List<JobOperatingPostCollect> getCollectList() {
        return this.collectList;
    }

    public JobOperatingPostCollect extractLinks(ZhiLianObject zhiLianObject) {
        if (null == zhiLianObject) {
            return new JobOperatingPostCollect();
        }

        JobOperatingPostCollect jobOperatingPostCollect = new JobOperatingPostCollect();
        String url = zhiLianObject.getPositionURL();

        jobOperatingPostCollect.setUrl(zhiLianObject.getPositionURL());
        jobOperatingPostCollect.setTitle(zhiLianObject.getJobName());
        jobOperatingPostCollect.setPay(zhiLianObject.getSalary());
        jobOperatingPostCollect.setAddress(zhiLianObject.getBusinessArea());
        jobOperatingPostCollect.setCompany(zhiLianObject.getCompany().getName());
        jobOperatingPostCollect.setExperience(zhiLianObject.getWorkingExp().getName());
        jobOperatingPostCollect.setAttraction(String.join(",", zhiLianObject.getWelfare()));
        jobOperatingPostCollect.setPublishDate(new Timestamp(DateUtil.parseDate(DateUtil.DATE_STYLE5, zhiLianObject.getUpdateDate()).getTime()));
        jobOperatingPostCollect.setState("0");
        jobOperatingPostCollect.setSfFilter(false);
        jobOperatingPostCollect.setSource("智联招聘");
        jobOperatingPostCollect.setCreateTime(new Timestamp(System.currentTimeMillis()));


        try {
            URL url1 = new URL(url);
            URLConnection connection = url1.openConnection();
            connection.setRequestProperty("Content-Type", "text/html; charset=utf-8");
            connection.setRequestProperty("X-Forwarded-For", HtmlParserUtils.getRandomIp());
            Parser parser = new Parser(connection);
            parser.setEncoding("utf-8");

            NodeFilter filterClassTitleLi = new HasAttributeFilter("class", "summary-plane__info"); //标题
            NodeFilter filterClassFormIneer = new HasAttributeFilter("class", "company");
            NodeFilter filterClassdescribtion = new HasAttributeFilter("class", "describtion__detail-content");


            NodeList nodeList = parser.extractAllNodesThatMatch(filterClassTitleLi);//标题
            nodeList = nodeList.elementAt(0).getChildren();
            StringBuilder str = new StringBuilder(nodeList.elementAt(nodeList.size() - 1).toPlainTextString());
            jobOperatingPostCollect.setNumber(str.toString());

            parser.reset();
            NodeList nodeListForm2 = parser.extractAllNodesThatMatch(filterClassFormIneer);

            nodeListForm2 = nodeListForm2.elementAt(0).getChildren();
            str = new StringBuilder();
            for (int i = 0; i < nodeListForm2.size(); i++) {
                str.append(nodeListForm2.elementAt(i).toPlainTextString()).append("|");
            }
            jobOperatingPostCollect.setCompanyInfo(str.toString());

            parser.reset();
            nodeListForm2 = parser.extractAllNodesThatMatch(filterClassdescribtion);

            nodeListForm2 = nodeListForm2.elementAt(0).getChildren();
            str = new StringBuilder();
            for (int i = 0; i < nodeListForm2.size(); i++) {
                str.append(nodeListForm2.elementAt(i).toPlainTextString()).append("|");
            }
            jobOperatingPostCollect.setOperateDesc(str.toString());

        } catch (IOException | ParserException e) {
            e.printStackTrace();
        }


        return jobOperatingPostCollect;
    }

    private List<ZhiLianObject> getZhiLianObj(String url) {
        List<ZhiLianObject> zhiLianObjectList = null;
        try {
            String resultUrl = HttpUtil.openUrl(url, null);

            JsonElement element = new JsonParser().parse(resultUrl);
            element = element.getAsJsonObject().get("data").getAsJsonObject().get("results");
            zhiLianObjectList = gson.fromJson(element, new TypeToken<List<ZhiLianObject>>() {
            }.getType());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return zhiLianObjectList;
    }

    @Override
    public void run() {
        for (String str : queryUrlList) {
            try {
                List<ZhiLianObject> lianObjects = getZhiLianObj(str);
                if (null != lianObjects) {
                    for (ZhiLianObject lianObject : lianObjects) {
                        Thread.sleep(1000);
                        JobOperatingPostCollect collect = extractLinks(lianObject);
                        if (null != collect) {
                            System.out.println("zlzpJobGet");
                            collectList.add(collect);
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
