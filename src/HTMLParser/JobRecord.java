package HTMLParser;

/**
 * Created by ZhaoTao on 2016/6/20.
 */
public class JobRecord {
    private String url;
    private String title;
    private String pay;
    private String address;
    private String company;
    private String nature; //性质
    private String experience; //工作经验
    private String education;
    private String number;
    private String classes;
    private String desc;//描述
    private String attraction;//吸引力
    private String publishData; //发布日期
    private String state; //是否审核

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "JobRecord{" +
                "url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", pay='" + pay + '\'' +
                ", address='" + address + '\'' +
                ", company='" + company + '\'' +
                ", nature='" + nature + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", number='" + number + '\'' +
                ", classes='" + classes + '\'' +
                ", desc='" + desc + '\'' +
                ", attraction='" + attraction + '\'' +
                ", publishData='" + publishData + '\'' +
                '}';
    }

    public String getPublishData() {
        return publishData;
    }

    public void setPublishData(String publishData) {
        this.publishData = publishData;
    }

    public String getAttraction() {
        return attraction;
    }

    public void setAttraction(String attraction) {
        this.attraction = attraction;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
}
