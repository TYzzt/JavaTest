package HTMLParser.parser20190708;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: ZhaoTao
 * \* Date: 2019/7/8
 * \* Time: 10:09
 * \* Description:
 * \
 */
public class ZhiLianObject {
    private String businessArea;
    private DetialBean company;
    private DetialBean eduLevel;
    private String emplType;
    private String jobName;
    private DetialBean jobType;
    private String positionURL;
    private String salary; //money
    private String updateDate;
    private DetialBean workingExp;
    private List<String> welfare;

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public DetialBean getCompany() {
        return company;
    }

    public void setCompany(DetialBean company) {
        this.company = company;
    }

    public DetialBean getEduLevel() {
        return eduLevel;
    }

    public void setEduLevel(DetialBean eduLevel) {
        this.eduLevel = eduLevel;
    }

    public String getEmplType() {
        return emplType;
    }

    public void setEmplType(String emplType) {
        this.emplType = emplType;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public DetialBean getJobType() {
        return jobType;
    }

    public void setJobType(DetialBean jobType) {
        this.jobType = jobType;
    }

    public String getPositionURL() {
        return positionURL;
    }

    public void setPositionURL(String positionURL) {
        this.positionURL = positionURL;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public DetialBean getWorkingExp() {
        return workingExp;
    }

    public void setWorkingExp(DetialBean workingExp) {
        this.workingExp = workingExp;
    }

    public List<String> getWelfare() {
        return welfare;
    }

    public void setWelfare(List<String> welfare) {
        this.welfare = welfare;
    }

    class DetialBean {
        private String name;
        private String number;
        private DetialBean size;
        private DetialBean type;

        private List<DetialBean> items;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public DetialBean getSize() {
            return size;
        }

        public void setSize(DetialBean size) {
            this.size = size;
        }

        public DetialBean getType() {
            return type;
        }

        public void setType(DetialBean type) {
            this.type = type;
        }

        public List<DetialBean> getItems() {
            return items;
        }

        public void setItems(List<DetialBean> items) {
            this.items = items;
        }
    }
}
