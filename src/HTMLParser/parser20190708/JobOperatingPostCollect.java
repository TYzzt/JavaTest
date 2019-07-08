package HTMLParser.parser20190708;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by DXG on 2016/6/22.
 */
public class JobOperatingPostCollect {

    private int id;
    private String url;
    private String title;
    private String pay;
    private String address;
    private String company;
    private String nature;
    private String experience;
    private String education;
    private String number;
    private String classes;
    private String operateDesc;
    private String attraction;
    private Timestamp publishDate;
    private String state;
    private Boolean sfFilter;//是否被筛选，是否被添加到发布表中
    private String source;//岗位信息来源
    private Timestamp createTime;//信息创建日期
    private String companyInfo; //公司简介

    public JobOperatingPostCollect() {
    }

    public JobOperatingPostCollect(int id, String url, String title, String pay, String address, String company, String nature, String experience, String education, String number, String classes, Object publishDate, String state, String source, Object createTime) {
        this.id = id;
        this.url = url;
        this.title = title;
        this.pay = pay;
        this.address = address;
        this.company = company;
        this.nature = nature;
        this.experience = experience;
        this.education = education;
        this.number = number;
        this.classes = classes;
        this.publishDate = stringToTimestamp(publishDate.toString());
        ;
        this.state = state;
        this.source = source;
        this.createTime = stringToTimestamp(createTime.toString());
        ;
    }

    public static Timestamp stringToTimestamp(String dateStr) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        try {
            Date date = sdf.parse(dateStr);
            date.getTime();
            cal.setTime(date);
            return new Timestamp(cal.getTimeInMillis());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        cal.setTime(new Date());
        return new Timestamp(cal.getTimeInMillis());
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getOperateDesc() {
        return operateDesc;
    }

    public void setOperateDesc(String operateDesc) {
        this.operateDesc = operateDesc;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public Timestamp getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Timestamp publishDate) {
        this.publishDate = publishDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Boolean getSfFilter() {
        return sfFilter;
    }

    public void setSfFilter(Boolean sfFilter) {
        this.sfFilter = sfFilter;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    /* 用于根据titile和company去重*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobOperatingPostCollect that = (JobOperatingPostCollect) o;

        if (null != that.title &&
                null != title &&
                null != company &&
                null != that.company && that.title.equals(title) && that.company.equals(company)) {
            return true;
        } else {
            return false;
        }

    }

    /* 用于根据titile和company去重*/
    @Override
    public int hashCode() {
        int result = 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (company != null ? company.hashCode() : 0);
        return result;
    }
}
