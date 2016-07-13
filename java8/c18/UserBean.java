package c18;

/**
 * Created by ZhaoTao on 2016/7/13.
 */
public class UserBean {
    private String userName;
    private int a;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "UserBean{" +
                "userName='" + userName + '\'' +
                ", a=" + a +
                '}';
    }
}
