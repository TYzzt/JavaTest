package HTMLParser.parser20190708;


/**
 * Created by ZhaoTao on 2016/6/17.
 */
//本接口所定义的过滤器，用于判断url是否属于本次搜索范围。
public interface LinkFilter {
    public boolean accept(String url);
}
